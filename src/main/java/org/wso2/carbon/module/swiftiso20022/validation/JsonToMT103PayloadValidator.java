/**
 * Copyright (c) 2024, WSO2 LLC. (https://www.wso2.com).
 * <p>
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.module.swiftiso20022.validation;

import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.constants.MT103Constants;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationEngine;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidatorContext;
import org.wso2.carbon.module.swiftiso20022.validation.rules.custom.MT103ArrayFieldValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.custom.MT103EntityFieldValidationRule;


import java.util.List;
import java.util.Map;

/**
 * Class to validate the JSON payload for MT103 transformation.
 */
public class JsonToMT103PayloadValidator {

    // List of mandatory fields in block 01
    private static final List<ValidatorContext> block01MandatoryFieldValidationParamList = List.of(
            new ValidatorContext(MT103Constants.BLOCK01_LOGICAL_TERMINAL_ADDRESS_KEY,
                    ConnectorConstants.BLOCK01_LOGICAL_TERMINAL_ADDRESS),
            new ValidatorContext(MT103Constants.BLOCK01_SESSION_NUMBER_KEY,
                    ConnectorConstants.BLOCK01_SESSION_NUMBER),
            new ValidatorContext(MT103Constants.BLOCK01_SEQUENCE_NUMBER_KEY,
                    ConnectorConstants.BLOCK01_SEQUENCE_NUMBER)
    );

    // List of fields with predefined values in block 01
    private static final List<ValidatorContext> block01FixedValueFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK01_APPLICATION_ID_KEY, ConnectorConstants.BLOCK01_APPLICATION_ID,
                    Map.of(ConnectorConstants.FIXED_VALUE_KEY, MT103Constants.MT103_APPLICATION_ID)),
            new ValidatorContext(MT103Constants.BLOCK01_SERVICE_ID_KEY, ConnectorConstants.BLOCK01_SERVICE_ID,
                    Map.of(ConnectorConstants.FIXED_VALUE_KEY, MT103Constants.MT103_SERVICE_ID))
    );

    // List of numeric fields in block 01
    private static final List<ValidatorContext> block01NumericFieldValidationParamList = List.of(
            new ValidatorContext(MT103Constants.BLOCK01_SESSION_NUMBER_KEY,
                    ConnectorConstants.BLOCK01_SESSION_NUMBER),
            new ValidatorContext(MT103Constants.BLOCK01_SEQUENCE_NUMBER_KEY,
                    ConnectorConstants.BLOCK01_SEQUENCE_NUMBER)
    );

    // List of fields with length validations in block 01
    private static final List<ValidatorContext> block01FieldsLengthValidationParamList = List.of(
            new ValidatorContext(MT103Constants.BLOCK01_LOGICAL_TERMINAL_ADDRESS_KEY,
                    ConnectorConstants.BLOCK01_LOGICAL_TERMINAL_ADDRESS,
                    ConnectorConstants.LOGICAL_TERMINAL_ADDRESS_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK01_SESSION_NUMBER_KEY,
                    ConnectorConstants.BLOCK01_SESSION_NUMBER, ConnectorConstants.SESSION_NUMBER_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK01_SEQUENCE_NUMBER_KEY,
                    ConnectorConstants.BLOCK01_SEQUENCE_NUMBER, ConnectorConstants.SEQUENCE_NUMBER_LENGTH)
    );

    // List of fields with constant length in block 01
    private static final List<String> block01DefinedLengthFields =
            List.of(MT103Constants.BLOCK01_LOGICAL_TERMINAL_ADDRESS_KEY,
                    MT103Constants.BLOCK01_SESSION_NUMBER_KEY, ConnectorConstants.BLOCK01_SEQUENCE_NUMBER);

    // List of alphanumeric fields in block 01
    private static final List<ValidatorContext> block02AlphanumericValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK01_LOGICAL_TERMINAL_ADDRESS_KEY,
                    ConnectorConstants.BLOCK01_LOGICAL_TERMINAL_ADDRESS)
    );

    /**
     * Method to construct validation engine for block 01 validation.
     *
     * @return {@link ValidationEngine} with block 01 validation parameters
     */
    public static ValidationEngine getMT103Block01ValidationEngine() {
        return new ValidationEngine()
                .addMandatoryParamValidationRule(block01MandatoryFieldValidationParamList)
                .addFixedValueParamValidationRule(block01FixedValueFieldValidationParamsList)
                .addNumericParamValidationRule(block01NumericFieldValidationParamList)
                .addAlphaNumericParamValidationRule(block02AlphanumericValidationParamsList)
                .addParameterLengthValidationRule(block01FieldsLengthValidationParamList, block01DefinedLengthFields);
    }

    // List of mandatory fields in block 02 of a input message
    private static final List<ValidatorContext> inputBlock02MandatoryFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS_KEY,
                    ConnectorConstants.BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS)
    );

    // List of optional fields in block 02 of a input message
    private static final List<ValidatorContext> inputBlock02OptionalFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_PRIORITY_KEY, ConnectorConstants.BLOCK02_PRIORITY),
            new ValidatorContext(MT103Constants.BLOCK02_DELIVERY_MONITORING_CODE_KEY,
                    ConnectorConstants.BLOCK02_DELIVERY_MONITORING_CODE),
            new ValidatorContext(MT103Constants.BLOCK02_OBSOLESCENCE_PERIOD_CODE_KEY,
                    ConnectorConstants.BLOCK02_OBSOLESCENCE_PERIOD_CODE)
    );

    // List of fields with predefined values in block 02 of a input message
    private static final List<ValidatorContext> block02FixedValueFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_MESSAGE_TYPE_KEY, ConnectorConstants.BLOCK02_MESSAGE_TYPE,
                    Map.of(ConnectorConstants.FIXED_VALUE_KEY, MT103Constants.MT103_MESSAGE_TYPE))
    );

    // List of fields with length validations in block 02 of a input message
    private static final List<ValidatorContext> inputBlock02LengthValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS_KEY,
                    ConnectorConstants.BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS,
                    ConnectorConstants.LOGICAL_TERMINAL_ADDRESS_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK02_PRIORITY_KEY,
                    ConnectorConstants.BLOCK02_PRIORITY, ConnectorConstants.BLOCK02_PRIORITY_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK02_DELIVERY_MONITORING_CODE_KEY,
                    ConnectorConstants.BLOCK02_DELIVERY_MONITORING_CODE,
                    ConnectorConstants.BLOCK02_DELIVERY_MONITORING_CODE_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK02_OBSOLESCENCE_PERIOD_CODE_KEY,
                    ConnectorConstants.BLOCK02_OBSOLESCENCE_PERIOD_CODE,
                    ConnectorConstants.BLOCK02_OBSOLESCENCE_PERIOD_LENGTH)
    );

    // List of fields with constant length in block 02 of a input message
    private static final List<String> inputBlock02DefinedLengthFields = List.of(
            MT103Constants.BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS_KEY,
            MT103Constants.BLOCK02_PRIORITY_KEY,
            MT103Constants.BLOCK02_DELIVERY_MONITORING_CODE_KEY,
            MT103Constants.BLOCK02_OBSOLESCENCE_PERIOD_CODE_KEY
    );

    // List of numeric fields in block 02 of a input message
    private static final List<ValidatorContext> inputBlock02NumericFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_DELIVERY_MONITORING_CODE_KEY,
                    ConnectorConstants.BLOCK02_DELIVERY_MONITORING_CODE),
            new ValidatorContext(MT103Constants.BLOCK02_OBSOLESCENCE_PERIOD_CODE_KEY,
                    ConnectorConstants.BLOCK02_OBSOLESCENCE_PERIOD_CODE)
    );

    // List of alphabetic fields in block 02 of a input message
    private static final List<ValidatorContext> inputBlock02AlphaFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_PRIORITY_KEY,
                    ConnectorConstants.BLOCK02_PRIORITY)
    );

    // List of alphanumeric fields in block 02 of a input message
    private static final List<ValidatorContext> inputBlock02AlphaNumericFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS_KEY,
                    ConnectorConstants.BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS)
    );

    /**
     * Method to construct validation engine for input message block 02 validation.
     *
     * @return {@link ValidationEngine} with input message block 02 validation parameters
     */
    public static ValidationEngine getMT103InputBlock02ValidationEngine() {
        return new ValidationEngine()
                .addMandatoryParamValidationRule(inputBlock02MandatoryFieldValidationParamsList)
                .addOptionalStringParamValidationRule(inputBlock02OptionalFieldValidationParamsList)
                .addFixedValueParamValidationRule(block02FixedValueFieldValidationParamsList)
                .addParameterLengthValidationRule(
                        inputBlock02LengthValidationParamsList, inputBlock02DefinedLengthFields)
                .addNumericParamValidationRule(inputBlock02NumericFieldValidationParamsList)
                .addAlphaParamValidationRule(inputBlock02AlphaFieldValidationParamsList)
                .addAlphaNumericParamValidationRule(inputBlock02AlphaNumericFieldValidationParamsList);
    }

    // List of mandatory fields in block 02 of a output message
    private static final List<ValidatorContext> outputBlock02MandatoryFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_INPUT_TIME_KEY, ConnectorConstants.BLOCK02_INPUT_TIME),
            new ValidatorContext(MT103Constants.BLOCK02_MESSAGE_INPUT_REFERENCE_KEY,
                    ConnectorConstants.BLOCK02_MESSAGE_INPUT_REFERENCE),
            new ValidatorContext(MT103Constants.BLOCK02_OUTPUT_DATE_KEY, ConnectorConstants.BLOCK02_OUTPUT_DATE),
            new ValidatorContext(MT103Constants.BLOCK02_OUTPUT_TIME_KEY, ConnectorConstants.BLOCK02_OUTPUT_TIME)

    );

    // List of optional fields in block 02 of a output message
    private static final List<ValidatorContext> outputBlock02OptionalFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_PRIORITY_KEY, ConnectorConstants.BLOCK02_PRIORITY)
    );

    // List of fields with length validations in block 02 of a output message
    private static final List<ValidatorContext> outputBlock02LengthValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_PRIORITY_KEY,
                    ConnectorConstants.BLOCK02_PRIORITY, ConnectorConstants.BLOCK02_PRIORITY_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK02_INPUT_TIME_KEY, ConnectorConstants.BLOCK02_INPUT_TIME,
                    ConnectorConstants.TIME_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK02_MESSAGE_INPUT_REFERENCE_KEY,
                    ConnectorConstants.BLOCK02_MESSAGE_INPUT_REFERENCE,
                    ConnectorConstants.BLOCK02_MESSAGE_INPUT_REFERENCE_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK02_OUTPUT_DATE_KEY, ConnectorConstants.BLOCK02_OUTPUT_DATE,
                    ConnectorConstants.DATE_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK02_OUTPUT_TIME_KEY, ConnectorConstants.BLOCK02_OUTPUT_TIME,
                    ConnectorConstants.TIME_LENGTH)
    );

    // List of fields with constant length in block 02 of a output message
    private static final List<String> outputBlock02DefinedLengthFields = List.of(
            MT103Constants.BLOCK02_PRIORITY_KEY,
            MT103Constants.BLOCK02_INPUT_TIME_KEY,
            MT103Constants.BLOCK02_MESSAGE_INPUT_REFERENCE_KEY,
            MT103Constants.BLOCK02_OUTPUT_DATE_KEY,
            MT103Constants.BLOCK02_OUTPUT_TIME_KEY
    );

    // List of numeric fields in block 02 of a output message
    private static final List<ValidatorContext> outputBlock02NumericFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_INPUT_TIME_KEY, ConnectorConstants.BLOCK02_INPUT_TIME),
            new ValidatorContext(MT103Constants.BLOCK02_OUTPUT_DATE_KEY, ConnectorConstants.BLOCK02_OUTPUT_DATE),
            new ValidatorContext(MT103Constants.BLOCK02_OUTPUT_TIME_KEY, ConnectorConstants.BLOCK02_OUTPUT_TIME)
    );

    // List of alphabetic fields in block 02 of a output message
    private static final List<ValidatorContext> outputBlock02AlphaFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_PRIORITY_KEY,
                    ConnectorConstants.BLOCK02_PRIORITY)
    );

    // List of alphanumeric fields in block 02 of a output message
    private static final List<ValidatorContext> outputBlock02AlphaNumericFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK02_MESSAGE_INPUT_REFERENCE_KEY,
                    ConnectorConstants.BLOCK02_MESSAGE_INPUT_REFERENCE)
    );

    /**
     * Method to construct validation engine for output message block 02 validation.
     *
     * @return {@link ValidationEngine} with output message block 02 validation parameters
     */
    public static ValidationEngine getMT103OutputBlock02ValidationEngine() {
        return new ValidationEngine()
                .addMandatoryParamValidationRule(outputBlock02MandatoryFieldValidationParamsList)
                .addOptionalStringParamValidationRule(outputBlock02OptionalFieldValidationParamsList)
                .addFixedValueParamValidationRule(block02FixedValueFieldValidationParamsList)
                .addParameterLengthValidationRule(
                        outputBlock02LengthValidationParamsList, outputBlock02DefinedLengthFields)
                .addNumericParamValidationRule(outputBlock02NumericFieldValidationParamsList)
                .addAlphaParamValidationRule(outputBlock02AlphaFieldValidationParamsList)
                .addAlphaNumericParamValidationRule(outputBlock02AlphaNumericFieldValidationParamsList);
    }

    // List of fields with predefined set of values in block 03
    private static final List<ValidatorContext> block03DefinedValueFields = List.of(
            new ValidatorContext(MT103Constants.BLOCK03_VALIDATION_FLAG_KEY, ConnectorConstants.BLOCK03_VALIDATION_FLAG,
                    Map.of(ConnectorConstants.ENUM_KEY, MT103Constants.ValidationFlag.class))
    );

    // List of mandatory fields in block 03
    private static final List<ValidatorContext> block03MandatoryFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK03_SERVICE_IDENTIFIER_KEY,
                    ConnectorConstants.BLOCK03_SERVICE_IDENTIFIER),
            new ValidatorContext(MT103Constants.BLOCK03_END_TO_END_REFERENCE_KEY,
                    ConnectorConstants.BLOCK03_END_TO_END_REFERENCE)
    );

    // List of optional fields in block 03
    private static final List<ValidatorContext> block03OptionalFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK03_MESSAGE_USER_REFERENCE_KEY,
                    ConnectorConstants.BLOCK03_MESSAGE_USER_REFERENCE),
            new ValidatorContext(MT103Constants.BLOCK03_SERVICE_TYPE_IDENTIFIER_KEY,
                    ConnectorConstants.BLOCK03_SERVICE_TYPE_IDENTIFIER),
            new ValidatorContext(MT103Constants.BLOCK03_BANKING_PRIORITY_KEY,
                    ConnectorConstants.BLOCK03_BANKING_PRIORITY)
    );

    // List of fields with length validations in block 03
    private static final List<ValidatorContext> block03LengthValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK03_SERVICE_IDENTIFIER_KEY,
                    ConnectorConstants.BLOCK03_SERVICE_IDENTIFIER,
                    ConnectorConstants.BLOCK03_SERVICE_IDENTIFIER_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK03_BANKING_PRIORITY_KEY,
                    ConnectorConstants.BLOCK03_BANKING_PRIORITY, ConnectorConstants.BLOCK03_BANKING_PRIORITY_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK03_MESSAGE_USER_REFERENCE_KEY,
                    ConnectorConstants.BLOCK03_MESSAGE_USER_REFERENCE,
                    ConnectorConstants.MESSAGE_USER_REFERENCE_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK03_END_TO_END_REFERENCE_KEY,
                    ConnectorConstants.BLOCK03_END_TO_END_REFERENCE, ConnectorConstants.END_TO_END_REFERENCE_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK03_SERVICE_TYPE_IDENTIFIER_KEY,
                    ConnectorConstants.BLOCK03_SERVICE_TYPE_IDENTIFIER,
                    ConnectorConstants.BLOCK03_SERVICE_TYPE_IDENTIFIER_LENGTH)
    );

    // List of fields with constant length in block 03
    private static final List<String> block03DefinedLengthFields = List.of(
            MT103Constants.BLOCK03_SERVICE_IDENTIFIER_KEY, MT103Constants.BLOCK03_BANKING_PRIORITY_KEY,
            MT103Constants.BLOCK03_END_TO_END_REFERENCE_KEY, MT103Constants.BLOCK03_SERVICE_TYPE_IDENTIFIER_KEY
    );

    // List of numeric fields in block 03
    private static final List<ValidatorContext> block03NumericFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK03_SERVICE_TYPE_IDENTIFIER_KEY,
                    ConnectorConstants.BLOCK03_SERVICE_TYPE_IDENTIFIER)
    );

    // List of alphabetic fields in block 03
    private static final List<ValidatorContext> block03AlphaFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK03_SERVICE_IDENTIFIER_KEY,
                    ConnectorConstants.BLOCK03_SERVICE_IDENTIFIER)
    );

    /**
     * Method to construct validation engine for block 03.
     *
     * @return {@link ValidationEngine} with block 03 validation parameters
     */
    public static ValidationEngine getMT103Block03ValidationEngine() {
        return new ValidationEngine()
                .addEnumValueMatchValidationRule(block03DefinedValueFields)
                .addMandatoryParamValidationRule(block03MandatoryFieldValidationParamsList)
                .addOptionalStringParamValidationRule(block03OptionalFieldValidationParamsList)
                .addParameterLengthValidationRule(
                        block03LengthValidationParamsList, block03DefinedLengthFields)
                .addNumericParamValidationRule(block03NumericFieldValidationParamsList)
                .addAlphaParamValidationRule(block03AlphaFieldValidationParamsList);
    }

    // List of mandatory fields in block 04
    private static final List<ValidatorContext> block04MandatoryFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.SENDERS_REFERENCE_KEY, MT103Constants.SENDERS_REFERENCE),
            new ValidatorContext(MT103Constants.BANK_OPERATION_CODE_KEY, MT103Constants.BANK_OPERATION_CODE_KEY),
            new ValidatorContext(MT103Constants.VALUE_KEY, MT103Constants.VALUE),
            new ValidatorContext(MT103Constants.ORDERING_CUSTOMER_KEY, MT103Constants.ORDERING_CUSTOMER),
            new ValidatorContext(MT103Constants.BENEFICIARY_CUSTOMER_KEY, MT103Constants.BENEFICIARY_CUSTOMER),
            new ValidatorContext(MT103Constants.DETAILS_OF_CHARGES_KEY, MT103Constants.DETAILS_OF_CHARGES)
    );

    // List of optional fields in block 04
    private static final List<ValidatorContext> block04OptionalFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.TRANSACTION_TYPE_CODE_KEY, MT103Constants.TRANSACTION_TYPE_CODE),
            new ValidatorContext(MT103Constants.INSTRUCTED_AMOUNT_KEY, MT103Constants.INSTRUCTED_AMOUNT),
            new ValidatorContext(MT103Constants.EXCHANGE_RATE_KEY, MT103Constants.EXCHANGE_RATE),
            new ValidatorContext(MT103Constants.RECEIVERS_CHARGES_KEY, MT103Constants.RECEIVERS_CHARGES),
            new ValidatorContext(MT103Constants.ENVELOPE_CONTENTS_KEY, MT103Constants.ENVELOPE_CONTENTS)
    );

    // List of fields with length validations in block 04
    private static final List<ValidatorContext> block04LengthValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.SENDERS_REFERENCE_KEY, MT103Constants.SENDERS_REFERENCE,
                    MT103Constants.SENDERS_REFERENCE_LENGTH),
            new ValidatorContext(MT103Constants.BANK_OPERATION_CODE_KEY, MT103Constants.BANK_OPERATION_CODE,
                    MT103Constants.BANK_OPERATION_CODE_LENGTH),
            new ValidatorContext(MT103Constants.TRANSACTION_TYPE_CODE_KEY, MT103Constants.TRANSACTION_TYPE_CODE,
                    MT103Constants.TRANSACTION_TYPE_CODE_LENGTH),
            new ValidatorContext(MT103Constants.VALUE_KEY, MT103Constants.VALUE, MT103Constants.VALUE_LENGTH),
            new ValidatorContext(MT103Constants.INSTRUCTED_AMOUNT_KEY, MT103Constants.INSTRUCTED_AMOUNT,
                    MT103Constants.INSTRUCTED_AMOUNT_LENGTH),
            new ValidatorContext(MT103Constants.EXCHANGE_RATE_KEY, MT103Constants.EXCHANGE_RATE,
                    MT103Constants.EXCHANGE_RATE_LENGTH),
            new ValidatorContext(MT103Constants.DETAILS_OF_CHARGES_KEY, MT103Constants.DETAILS_OF_CHARGES,
                    MT103Constants.DETAILS_OF_CHARGES_LENGTH),
            new ValidatorContext(MT103Constants.RECEIVERS_CHARGES_KEY, MT103Constants.RECEIVERS_CHARGES,
                    MT103Constants.RECEIVERS_CHARGES_LENGTH),
            new ValidatorContext(MT103Constants.ENVELOPE_CONTENTS_KEY, MT103Constants.ENVELOPE_CONTENTS,
                    MT103Constants.ENVELOPE_CONTENTS_LENGTH)
    );

    // List of fields with constant length in block 04
    private static final List<String> block04DefinedLengthFields = List.of(
            MT103Constants.BANK_OPERATION_CODE_KEY, MT103Constants.TRANSACTION_TYPE_CODE_KEY,
            MT103Constants.DETAILS_OF_CHARGES_KEY
    );

    // List of alphanumeric fields in block 04
    private static final List<ValidatorContext> block04AlphaNumericValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BANK_OPERATION_CODE_KEY, MT103Constants.BANK_OPERATION_CODE),
            new ValidatorContext(MT103Constants.TRANSACTION_TYPE_CODE_KEY, MT103Constants.TRANSACTION_TYPE_CODE)
    );

    // List of alphabetic fields in block 04
    private static final List<ValidatorContext> block04AlphaValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.DETAILS_OF_CHARGES_KEY, MT103Constants.DETAILS_OF_CHARGES)
    );

    // List of repetitive fields in block 04
    private static final List<ValidatorContext> block04RepetitiveFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.TIME_INDICATION_KEY, MT103Constants.TIME_INDICATION,
                    MT103Constants.TIME_INDICATION_LENGTH),
            new ValidatorContext(MT103Constants.INSTRUCTION_CODES_KEY, MT103Constants.INSTRUCTION_CODE,
                    MT103Constants.INSTRUCTION_CODE_LENGTH),
            new ValidatorContext(MT103Constants.SENDERS_CHARGES_KEY, MT103Constants.SENDERS_CHARGES,
                    MT103Constants.SENDERS_CHARGES_LENGTH)
    );

    // List of fields with entities in block 04
    private static final List<ValidatorContext> block04EntityFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.ORDERING_CUSTOMER_KEY, MT103Constants.ORDERING_CUSTOMER),
            new ValidatorContext(MT103Constants.SENDING_INSTITUTION_KEY, MT103Constants.SENDING_INSTITUTION),
            new ValidatorContext(MT103Constants.ORDERING_INSTITUTION_KEY, MT103Constants.ORDERING_INSTITUTION),
            new ValidatorContext(MT103Constants.SENDERS_CORRESPONDENT_KEY, MT103Constants.SENDERS_CORRESPONDENT),
            new ValidatorContext(MT103Constants.RECEIVERS_CORRESPONDENT_KEY, MT103Constants.RECEIVERS_CORRESPONDENT),
            new ValidatorContext(
                    MT103Constants.THIRD_REIMBURSEMENT_INSTITUTION_KEY, MT103Constants.THIRD_REIMBURSEMENT_INSTITUTION),
            new ValidatorContext(MT103Constants.INTERMEDIARY_INSTITUTION_KEY, MT103Constants.INTERMEDIARY_INSTITUTION),
            new ValidatorContext(MT103Constants.ACCOUNT_WITH_INSTITUTION_KEY, MT103Constants.ACCOUNT_WITH_INSTITUTION),
            new ValidatorContext(MT103Constants.BENEFICIARY_CUSTOMER_KEY, MT103Constants.BENEFICIARY_CUSTOMER)
    );

    // List of multiline fields in block 04
    private static final List<ValidatorContext> block04MultilineFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.REMITTANCE_INFORMATION_KEY, MT103Constants.REMITTANCE_INFORMATION,
                    MT103Constants.MT103_TEXT_LINE_LENGTH,
                    Map.of(MT103Constants.LINES_ALLOWED_KEY, MT103Constants.REMITTANCE_INFORMATION_LINE_COUNT)),
            new ValidatorContext(MT103Constants.SENDER_TO_RECEIVER_INFORMATION_KEY,
                    MT103Constants.SENDER_TO_RECEIVER_INFORMATION, MT103Constants.MT103_TEXT_LINE_LENGTH,
                    Map.of(MT103Constants.LINES_ALLOWED_KEY, MT103Constants.SENDER_TO_RECEIVER_INFORMATION_LINE_COUNT)),
            new ValidatorContext(MT103Constants.REGULATORY_REPORTING_KEY, MT103Constants.REGULATORY_REPORTING,
                    MT103Constants.MT103_TEXT_LINE_LENGTH,
                    Map.of(MT103Constants.LINES_ALLOWED_KEY, MT103Constants.REGULATORY_REPORTING_LINE_COUNT))
    );

    /**
     * Method to construct validation engine for block 04.
     *
     * @return {@link ValidationEngine} with block 04 validation parameters
     */
    public static ValidationEngine getMT103Block04ValidationEngine() {
        return new ValidationEngine()
                .addMandatoryParamValidationRule(block04MandatoryFieldValidationParamsList)
                .addOptionalStringParamValidationRule(block04OptionalFieldValidationParamsList)
                .addParameterLengthValidationRule(
                        block04LengthValidationParamsList, block04DefinedLengthFields)
                .addAlphaNumericParamValidationRule(block04AlphaNumericValidationParamsList)
                .addAlphaParamValidationRule(block04AlphaValidationParamsList)
                .addCustomRule(new MT103ArrayFieldValidationRule(block04RepetitiveFieldValidationParamsList))
                .addCustomRule(new MT103ArrayFieldValidationRule(block04MultilineFieldValidationParamsList, true))
                .addCustomRule(new MT103EntityFieldValidationRule(block04EntityFieldValidationParamsList));

    }

    // List of mandatory fields in block 05
    private static final List<ValidatorContext> block05MandatoryFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK05_CHECKSUM_KEY, ConnectorConstants.BLOCK05_CHECKSUM)
    );

    // List of optional fields in block 05
    private static final List<ValidatorContext> block05OptionalFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_EMISSION_KEY,
                    ConnectorConstants.BLOCK05_POSSIBLE_DUPLICATE_EMISSION),
            new ValidatorContext(MT103Constants.BLOCK05_MESSAGE_REFERENCE_KEY,
                    ConnectorConstants.BLOCK05_MESSAGE_REFERENCE),
            new ValidatorContext(MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_MESSAGE_KEY,
                    ConnectorConstants.BLOCK05_POSSIBLE_DUPLICATE_MESSAGE),
            new ValidatorContext(MT103Constants.BLOCK05_SYSTEM_ORIGINATED_MESSAGE_KEY,
                    ConnectorConstants.BLOCK05_SYSTEM_ORIGINATED_MESSAGE)
    );

    // List of fields with length validations in block 05
    private static final List<ValidatorContext> block05LengthValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK05_CHECKSUM_KEY, ConnectorConstants.BLOCK05_CHECKSUM,
                    ConnectorConstants.CHECKSUM_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_EMISSION_KEY,
                    ConnectorConstants.BLOCK05_POSSIBLE_DUPLICATE_EMISSION,
                    ConnectorConstants.MESSAGE_REFERENCE_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK05_MESSAGE_REFERENCE_KEY,
                    ConnectorConstants.BLOCK05_MESSAGE_REFERENCE,
                    ConnectorConstants.MESSAGE_REFERENCE_LENGTH_WITH_DATE),
            new ValidatorContext(MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_MESSAGE_KEY,
                    ConnectorConstants.BLOCK05_POSSIBLE_DUPLICATE_MESSAGE,
                    ConnectorConstants.MESSAGE_REFERENCE_LENGTH),
            new ValidatorContext(MT103Constants.BLOCK05_SYSTEM_ORIGINATED_MESSAGE_KEY,
                    ConnectorConstants.BLOCK05_SYSTEM_ORIGINATED_MESSAGE,
                    ConnectorConstants.MESSAGE_REFERENCE_LENGTH)
    );

    // List of fields with constant length in block 05
    private static final List<String> block05DefinedLengthFields = List.of(
            MT103Constants.BLOCK05_CHECKSUM_KEY,
            MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_EMISSION_KEY,
            MT103Constants.BLOCK05_MESSAGE_REFERENCE_KEY,
            MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_MESSAGE_KEY,
            MT103Constants.BLOCK05_SYSTEM_ORIGINATED_MESSAGE_KEY
    );

    // List of alphanumeric fields in block 05
    private static final List<ValidatorContext> block05AlphaNumericFieldValidationParamsList = List.of(
            new ValidatorContext(MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_EMISSION_KEY,
                    ConnectorConstants.BLOCK05_POSSIBLE_DUPLICATE_EMISSION),
            new ValidatorContext(MT103Constants.BLOCK05_MESSAGE_REFERENCE_KEY,
                    ConnectorConstants.BLOCK05_MESSAGE_REFERENCE),
            new ValidatorContext(MT103Constants.BLOCK05_POSSIBLE_DUPLICATE_MESSAGE_KEY,
                    ConnectorConstants.BLOCK05_POSSIBLE_DUPLICATE_MESSAGE),
            new ValidatorContext(MT103Constants.BLOCK05_SYSTEM_ORIGINATED_MESSAGE_KEY,
                    ConnectorConstants.BLOCK05_SYSTEM_ORIGINATED_MESSAGE)
    );

    /**
     * Method to construct validation engine for block 05.
     *
     * @return {@link ValidationEngine} with block 05 validation parameters
     */
    public static ValidationEngine getMT103Block05ValidationEngine() {
        return new ValidationEngine()
                .addMandatoryParamValidationRule(block05MandatoryFieldValidationParamsList)
                .addOptionalStringParamValidationRule(block05OptionalFieldValidationParamsList)
                .addParameterLengthValidationRule(
                        block05LengthValidationParamsList, block05DefinedLengthFields)
                .addAlphaNumericParamValidationRule(block05AlphaNumericFieldValidationParamsList);
    }

}
