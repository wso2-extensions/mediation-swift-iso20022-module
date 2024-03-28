/**
 * Copyright (c) 2024, WSO2 LLC. (https://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.module.swiftiso20022.utils;

import org.apache.commons.lang3.StringUtils;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.constants.MT940Constants;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationResult;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Validation utils for MT940.
 */
public class MT940ValidationUtils {

    /**
     * Method to validate the C1 rule MT940 format.
     * C1 rule - :86: should be preceded by :61:.
     *
     * @param lines  Lines in MT940 format
     * @return    Result of C1 rule validation
     */
    public static boolean isValidC1Rule(String[] lines) {

        for (int itr = 0; itr < lines.length; itr++) {
            if (lines[itr].startsWith(MT940Constants.MT940_INFORMATION)) {
                return lines[itr - 1].startsWith(MT940Constants.MT940_STATEMENT_LINE);
            }
        }
        return true;
    }

    /**
     * Method to validate the C2 rule MT940 format.
     * C2 rule - :60:, :62:, :64: and :65: should have same currency code.
     *
     * @param lines  Lines in MT940 format
     * @return    Result of C2 rule validation
     */
    public static boolean isValidC2Rule(String[] lines) {
        String openBalanceCurrency = null;
        String closeBalanceCurrency = null;
        String closeAvailBalanceCurrency = null;
        String forwardAvailBalanceCurrency = null;

        for (String line : lines) {
            String mandatoryCurrencyField = line.length() > 18 ? line.substring(12, 15) : null;
            String optionalCurrencyField = line.length() > 17 ? line.substring(11, 14) : null;

            if (line.startsWith(MT940Constants.MT940_OPENING_BAL)) {
                openBalanceCurrency = mandatoryCurrencyField;
            } else if (line.startsWith(MT940Constants.MT940_CLOSING_BAL)) {
                closeBalanceCurrency = mandatoryCurrencyField;
            } else if (line.startsWith(MT940Constants.MT940_CLOSING_AVAIL_BAL)) {
                closeAvailBalanceCurrency = optionalCurrencyField;
            } else if (line.startsWith(MT940Constants.MT940_FORWARD_AVAIL_BAL)) {
                forwardAvailBalanceCurrency = optionalCurrencyField;
            }
        }

        if (openBalanceCurrency == null || !openBalanceCurrency.equals(closeBalanceCurrency)) {
            return false;
        } else if (closeAvailBalanceCurrency != null &&
                !openBalanceCurrency.equals(closeAvailBalanceCurrency)) {
            return false;
        }

        return forwardAvailBalanceCurrency == null ||
                openBalanceCurrency.equals(forwardAvailBalanceCurrency);
    }

    /**
     * Method to validate the MT940 format.
     *
     * @param fields  Fields in MT940 format
     * @return    ValidationResult MT940 format is invalid
     */
    public static ValidationResult validateMT940Format(Map<String, Object> fields) {
        ValidationResult validationResult;

        validationResult = validateReference((String) fields.get(MT940Constants.DN_TRANSACTION_REF),
                MT940Constants.DN_TRANSACTION_REF);
        if (!validationResult.isValid()) {
            return validationResult;
        }

        if (fields.containsKey(MT940Constants.DN_RELATED_REF)) {
            validationResult = validateReference((String) fields.get(MT940Constants.DN_RELATED_REF),
                    MT940Constants.DN_RELATED_REF);
            if (!validationResult.isValid()) {
                return validationResult;
            }
        }

        validationResult = validateAccountIdentifier((String) fields.get(MT940Constants.DN_ACC_IDENTIFICATION));
        if (!validationResult.isValid()) {
            return validationResult;
        }

        validationResult = validateStatementNumber((String) fields.get(MT940Constants.DN_STATEMENT_NUMBER));
        if (!validationResult.isValid()) {
            return validationResult;
        }

        validationResult = validateOpeningBalance((String) fields.get(MT940Constants.DN_OPENING_BALANCE));
        if (!validationResult.isValid()) {
            return validationResult;
        }

        validationResult = validateClosingBalance((String) fields.get(MT940Constants.DN_CLOSING_BALANCE));
        if (!validationResult.isValid()) {
            return validationResult;
        }

        validationResult = validateClosingAvailableBalance((String) fields
                .get(MT940Constants.DN_CLOSING_AVAIL_BALANCE));
        if (!validationResult.isValid()) {
            return validationResult;
        }

        validationResult = validateForwardAvailableBalance((String) fields
                .get(MT940Constants.DN_FORWARD_CLOSING_AVAIL_BALANCE));
        if (!validationResult.isValid()) {
            return validationResult;
        }
        return new ValidationResult();
    }

    /**
     * Method to validate whether reference is valid.
     *
     * @param referenceValue  Reference to be validated
     * @return    Whether reference is valid
     */
    public static ValidationResult validateReference(String referenceValue, String fieldName) {
        String[] referenceDetails = referenceValue.split(ConnectorConstants.COLON);
        if (!isListLengthValid(referenceDetails)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID, fieldName));
        }

        String reference = referenceDetails[2];
        if (StringUtils.isBlank(reference)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_MISSING, fieldName));
        }

        if (reference.length() > ConnectorConstants.REFERENCE_LENGTH) {
            return new ValidationResult(ConnectorConstants.ERROR_M50,
                    String.format(ConnectorConstants.ERROR_PARAMETER_LENGTH, fieldName,
                            ConnectorConstants.REFERENCE_LENGTH));
        }

        if (reference.startsWith(ConnectorConstants.SLASH) || reference.endsWith(ConnectorConstants.SLASH) ||
                reference.contains(ConnectorConstants.DOUBLE_SLASH)) {
            return new ValidationResult(ConnectorConstants.ERROR_T26,
                    String.format(ConnectorConstants.ERROR_PARAMETER_CONTAINS_SLASH, fieldName));
        }

        if (!Pattern.matches(ConnectorConstants.MT_REGEX_PATTERN, reference)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID, fieldName));
        }
        return new ValidationResult();
    }

    /**
     * Method to validate whether Account identifier is valid.
     *
     * @param accIdentifier  Account identifier to be validated
     * @return    Whether account identifier is valid
     */
    public static ValidationResult validateAccountIdentifier(String accIdentifier) {
        String[] accIdentifierDetails = accIdentifier.split(ConnectorConstants.COLON);
        if (!isListLengthValid(accIdentifierDetails)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            MT940Constants.DN_ACC_IDENTIFICATION));
        }
        String account = accIdentifierDetails[2];
        if (StringUtils.isBlank(account)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_MISSING,
                            MT940Constants.DN_ACC_IDENTIFICATION));
        }

        if (account.length() > ConnectorConstants.ACC_IDENTIFICATION_LENGTH) {
            return new ValidationResult(ConnectorConstants.ERROR_M50,
                    String.format(ConnectorConstants.ERROR_PARAMETER_LENGTH,
                            MT940Constants.DN_ACC_IDENTIFICATION,
                            ConnectorConstants.ACC_IDENTIFICATION_LENGTH));
        }

        if (!Pattern.matches(ConnectorConstants.MT_REGEX_PATTERN, account)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            MT940Constants.DN_ACC_IDENTIFICATION));
        }
        return new ValidationResult();
    }

    /**
     * Method to validate whether Statement number is valid.
     *
     * @param statementNumber  Statement number to be validated
     * @return    Whether statement number is valid
     */
    public static ValidationResult validateStatementNumber(String statementNumber) {
        String[] statementNumberDetails = statementNumber.split(ConnectorConstants.COLON);
        if (!isListLengthValid(statementNumberDetails)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            MT940Constants.DN_STATEMENT_NUMBER));
        }
        String number = statementNumberDetails[2];
        if (StringUtils.isBlank(number)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_MISSING,
                            MT940Constants.DN_STATEMENT_NUMBER));
        }

        if (number.length() > ConnectorConstants.STATEMENT_NO_LENGTH) {
            return new ValidationResult(ConnectorConstants.ERROR_M50,
                    String.format(ConnectorConstants.ERROR_PARAMETER_LENGTH,
                            MT940Constants.DN_STATEMENT_NUMBER, ConnectorConstants.STATEMENT_NO_LENGTH));
        }

        if (!number.contains(ConnectorConstants.SLASH)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            MT940Constants.DN_STATEMENT_NUMBER));
        }

        if (!StringUtils.isNumeric(number.replace(ConnectorConstants.SLASH, ""))) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            MT940Constants.DN_STATEMENT_NUMBER));
        }
        return new ValidationResult();
    }

    /**
     * Method to validate whether Opening balance is valid.
     *
     * @param openingBalance  Balance to be validated
     * @return    Whether balance is valid
     */
    public static ValidationResult validateOpeningBalance(String openingBalance) {
        String[] openingBalanceDetails = openingBalance.split(ConnectorConstants.COLON);
        if (!isListLengthValid(openingBalanceDetails)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            MT940Constants.DN_OPENING_BALANCE));
        }

        String balance = openingBalanceDetails[2];
        if (StringUtils.isBlank(balance)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_MISSING,
                            MT940Constants.DN_OPENING_BALANCE));
        }

        ValidationResult validationResult = validateBalance(balance, MT940Constants.DN_OPENING_BALANCE);
        if (!validationResult.isValid()) {
            return validationResult;
        }
        return new ValidationResult();
    }

    /**
     * Method to validate whether Closing balance is valid.
     *
     * @param closingBalance  Balance to be validated
     * @return    Whether balance is valid
     */
    public static ValidationResult validateClosingBalance(String closingBalance) {
        String[] closingBalanceDetails = closingBalance.split(ConnectorConstants.COLON);
        if (!isListLengthValid(closingBalanceDetails)) {
            return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            MT940Constants.DN_CLOSING_BALANCE));
        }

        String balance = closingBalanceDetails[2];
        if (StringUtils.isBlank(balance)) {
            return new ValidationResult(ConnectorConstants.ERROR_C24,
                    String.format(ConnectorConstants.ERROR_PARAMETER_MISSING,
                            MT940Constants.DN_CLOSING_BALANCE));
        }

        ValidationResult validationResult = validateBalance(balance, MT940Constants.DN_CLOSING_BALANCE);
        if (!validationResult.isValid()) {
            return validationResult;
        }
        return new ValidationResult();
    }

    /** Method to validate whether Closing available balance is valid.
     *
     * @param closingBalance  Balance to be validated
     * @return     Whether balance is valid
     */
    public static ValidationResult validateClosingAvailableBalance(String closingBalance) {
        if (closingBalance != null) {
            String[] closingBalanceDetails = closingBalance.split(ConnectorConstants.COLON);
            if (!isListLengthValid(closingBalanceDetails)) {
                return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                        String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                                MT940Constants.DN_CLOSING_AVAIL_BALANCE));
            }

            ValidationResult validationResult = validateBalance(closingBalanceDetails[2],
                    MT940Constants.DN_CLOSING_AVAIL_BALANCE);
            if (!validationResult.isValid()) {
                return validationResult;
            }
        }
        return new ValidationResult();
    }

    /** Method to validate whether Forward available balance is valid.
     *
     * @param closingBalance  Balance to be validated
     * @return     Whether balance is valid
     */
    public static ValidationResult validateForwardAvailableBalance(String closingBalance) {
        if (closingBalance != null) {
            String[] closingBalanceDetails = closingBalance.split(ConnectorConstants.COLON);
            if (!isListLengthValid(closingBalanceDetails)) {
                return new ValidationResult(ConnectorConstants.INVALID_REQUEST_PAYLOAD,
                        String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                                MT940Constants.DN_FORWARD_CLOSING_AVAIL_BALANCE));
            }

            ValidationResult validationResult = validateBalance(closingBalanceDetails[2],
                    MT940Constants.DN_FORWARD_CLOSING_AVAIL_BALANCE);
            if (!validationResult.isValid()) {
                return validationResult;
            }
        }
        return new ValidationResult();
    }

    /** Method to validate whether Opening/closing balance is valid.
     *
     * @param balance  Balance to be validated
     * @return     Whether balance is valid
     */
    private static ValidationResult validateBalance(String balance, String balanceName) {
        ValidationResult validationResult;
        if (balance.length() > ConnectorConstants.BALANCE_LENGTH) {
            return new ValidationResult(ConnectorConstants.ERROR_M50,
                    String.format(ConnectorConstants.ERROR_PARAMETER_LENGTH,
                            balanceName, ConnectorConstants.BALANCE_LENGTH));
        }

        if (!balance.startsWith(ConnectorConstants.DEBIT) && !balance.startsWith(ConnectorConstants.CREDIT)) {
            return new ValidationResult(ConnectorConstants.ERROR_T51,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            balanceName));
        }

        validationResult = ValidatorUtils.validateAmountLength(balance.substring(10), balanceName);
        if (!validationResult.isValid()) {
            return validationResult;
        }

        validationResult = validateAmountFormat(balance.substring(10), balanceName);
        if (!validationResult.isValid()) {
            return validationResult;
        }
        return new ValidationResult();
    }

    /** Method to validate whether amount is valid.
     *
     * @param amount  Amount to be validated
     * @return     Whether amount is valid
     */
    private static ValidationResult validateAmountFormat(String amount, String fieldName) {

        if (amount.contains(".")) {
            return new ValidationResult(ConnectorConstants.ERROR_T40,
                    String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                            ConnectorUtils.concatFieldsWithSpaces(fieldName, MT940Constants.DN_AMOUNT)));
        }
        return  new ValidationResult();
    }

    /**
     * Method to validate the List length is valid.
     *
     * @param detailsList  Date to be validated
     * @return    Whether List length is valid
     */
    private static boolean isListLengthValid(String[] detailsList) {
        if (detailsList.length == 3) {
            return true;
        } else {
            return false;
        }
    }
}
