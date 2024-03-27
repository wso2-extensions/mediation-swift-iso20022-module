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

package org.wso2.carbon.module.swiftiso20022.constants;

/**
 * Constants for MT103 Message.
 */
public class MT103Constants {

    private MT103Constants() {
        // Private constructor to prevent instantiation
    }

    public static final String MT103_APPLICATION_ID = "F";
    public static final String MT103_SERVICE_ID = "01";
    public static final String MT103_MESSAGE_TYPE = "103";

    /**
     * Enum with allowed values for block03 validation flag field.
     */
    public enum ValidationFlag {
        STP,
        REMIT;
    }

    public static final String MT103_STP_VALIDATION_FLAG = "STP";
    public static final String MT103_REMIT_VALIDATION_FLAG = "REMIT";
    public static final String MT103_ENTITY_OPTION = "option";
    public static final String MT103_ENTITY_DETAILS = "details";
    public static final String LINES_ALLOWED_KEY = "linesAllowed";
    public static final int MT103_ENTITY_DETAILS_LINE_COUNT = 4;
    public static final int MT103_TEXT_LINE_LENGTH = 35;

    // Generic Error Messages
    public static final String ERROR_EMPTY_ENTITY_OPTION = "Option is mandatory for %s field";
    public static final String ERROR_INVALID_ENTITY_OPTION = "Option of field %s is invalid";
    public static final String ERROR_EMPTY_ENTITY_DETAILS = "Details of field %s cannot be empty";
    public static final String ERROR_EMPTY_ENTITY_DETAIL_LINE = "Line %s of details of field %s cannot be empty";
    public static final String ERROR_ENTITY_DETAIL_LINE_LENGTH =
            "Line %s of details of field %s should not contain more than 35 characters ";
    public static final String ERROR_ENTITY_DETAIL_LINE_COUNT =
            "Details of field %s should not contain more than 4 lines";

    public static final String INVALID_BLOCK_ERROR_LOG = "%s validation failed. Caused by %s";

    // MT103 Text Fields
    public static final String SENDERS_REFERENCE = "Sender's Reference";
    public static final String TIME_INDICATION = "Time Indication";
    public static final String BANK_OPERATION_CODE = "Bank Operation Code";
    public static final String INSTRUCTION_CODE = "Instruction Code";
    public static final String TRANSACTION_TYPE_CODE = "Transaction Type Code";
    public static final String VALUE = "Value";
    public static final String INSTRUCTED_AMOUNT = "Instructed Amount";
    public static final String EXCHANGE_RATE = "Exchange Rate";
    public static final String ORDERING_CUSTOMER = "Ordering Customer";
    public static final String SENDING_INSTITUTION = "Sending Institution";
    public static final String ORDERING_INSTITUTION = "Ordering Institution";
    public static final String SENDERS_CORRESPONDENT = "Sender's Correspondent";
    public static final String RECEIVERS_CORRESPONDENT = "Receiver's Correspondent";
    public static final String THIRD_REIMBURSEMENT_INSTITUTION = "Third Reimbursement Institution";
    public static final String INTERMEDIARY_INSTITUTION = "Intermediary Institution";
    public static final String ACCOUNT_WITH_INSTITUTION = "Account With Institution";
    public static final String BENEFICIARY_CUSTOMER = "Beneficiary Customer";
    public static final String REMITTANCE_INFORMATION = "Remittance Information";
    public static final String DETAILS_OF_CHARGES = "Details of Charges";
    public static final String SENDERS_CHARGES = "Sender's Charges";
    public static final String RECEIVERS_CHARGES = "Receiver's Charges";
    public static final String SENDER_TO_RECEIVER_INFORMATION = "Sender to Receiver Information";
    public static final String REGULATORY_REPORTING = "Regulatory Reporting";
    public static final String ENVELOPE_CONTENTS = "Envelope Contents";

    // JSON to MT103 constants
    public static final String BLOCK01 = "block01";
    public static final String BLOCK01_APPLICATION_ID_KEY = "applicationIdentifier";
    public static final String BLOCK01_SERVICE_ID_KEY = "serviceIdentifier";
    public static final String BLOCK01_LOGICAL_TERMINAL_ADDRESS_KEY = "logicalTerminalAddress";
    public static final String BLOCK01_SESSION_NUMBER_KEY = "sessionNumber";
    public static final String BLOCK01_SEQUENCE_NUMBER_KEY = "sequenceNumber";
    public static final String BLOCK02 = "block02";
    public static final String BLOCK02_INPUT_OUTPUT_ID_KEY = "inputOutputIdentifier";
    public static final String BLOCK02_MESSAGE_TYPE_KEY = "messageType";
    public static final String BLOCK02_DESTINATION_LOGICAL_TERMINAL_ADDRESS_KEY = "destinationLogicalTerminalAddress";
    public static final String BLOCK02_INPUT_TIME_KEY = "inputTime";
    public static final String BLOCK02_MESSAGE_INPUT_REFERENCE_KEY = "messageInputReference";
    public static final String BLOCK02_OUTPUT_DATE_KEY = "outputDate";
    public static final String BLOCK02_OUTPUT_TIME_KEY = "outputTime";
    public static final String BLOCK02_PRIORITY_KEY = "priority";
    public static final String BLOCK02_DELIVERY_MONITORING_CODE_KEY = "deliveryMonitoringCode";
    public static final String BLOCK02_OBSOLESCENCE_PERIOD_CODE_KEY = "obsolescencePeriodCode";
    public static final String BLOCK03 = "block03";
    public static final String BLOCK03_SERVICE_IDENTIFIER_KEY = "serviceIdentifier";
    public static final String BLOCK03_BANKING_PRIORITY_KEY = "bankingPriority";
    public static final String BLOCK03_MESSAGE_USER_REFERENCE_KEY = "messageUserReference";
    public static final String BLOCK03_VALIDATION_FLAG_KEY = "validationFlag";
    public static final String BLOCK03_END_TO_END_REFERENCE_KEY = "endToEndReference";
    public static final String BLOCK03_SERVICE_TYPE_IDENTIFIER_KEY = "serviceTypeIdentifier";
    public static final String BLOCK04 = "block04";
    public static final String SENDERS_REFERENCE_KEY = "sendersReference";
    public static final String TIME_INDICATION_KEY = "timeIndication";
    public static final String BANK_OPERATION_CODE_KEY = "bankOperationCode";
    public static final String INSTRUCTION_CODES_KEY = "instructionCodes";
    public static final String TRANSACTION_TYPE_CODE_KEY = "transactionTypeCode";
    public static final String VALUE_KEY = "value";
    public static final String INSTRUCTED_AMOUNT_KEY = "instructedAmount";
    public static final String EXCHANGE_RATE_KEY = "exchangeRate";
    public static final String ORDERING_CUSTOMER_KEY = "orderingCustomer";
    public static final String SENDING_INSTITUTION_KEY = "sendingInstitution";
    public static final String ORDERING_INSTITUTION_KEY = "orderingInstitution";
    public static final String SENDERS_CORRESPONDENT_KEY = "sendersCorrespondent";
    public static final String RECEIVERS_CORRESPONDENT_KEY = "receiversCorrespondent";
    public static final String THIRD_REIMBURSEMENT_INSTITUTION_KEY = "thirdReimbursementInstitution";
    public static final String INTERMEDIARY_INSTITUTION_KEY = "intermediaryInstitution";
    public static final String ACCOUNT_WITH_INSTITUTION_KEY = "accountWithInstitution";
    public static final String BENEFICIARY_CUSTOMER_KEY = "beneficiaryCustomer";
    public static final String REMITTANCE_INFORMATION_KEY = "remittanceInformation";
    public static final String DETAILS_OF_CHARGES_KEY = "detailsOfCharges";
    public static final String SENDERS_CHARGES_KEY = "sendersCharges";
    public static final String RECEIVERS_CHARGES_KEY = "receiversCharges";
    public static final String SENDER_TO_RECEIVER_INFORMATION_KEY = "senderToReceiverInformation";
    public static final String REGULATORY_REPORTING_KEY = "regulatoryReporting";
    public static final String ENVELOPE_CONTENTS_KEY = "envelopeContents";
    public static final String BLOCK05 = "block05";
    public static final String BLOCK05_CHECKSUM_KEY = "checksum";
    public static final String BLOCK05_POSSIBLE_DUPLICATE_EMISSION_KEY = "possibleDuplicateEmission";
    public static final String BLOCK05_MESSAGE_REFERENCE_KEY = "messageReference";
    public static final String BLOCK05_POSSIBLE_DUPLICATE_MESSAGE_KEY = "possibleDuplicateMessage";
    public static final String BLOCK05_SYSTEM_ORIGINATED_MESSAGE_KEY = "systemOriginatedMessage";

    // MT103 field length related constants
    public static final int SENDERS_REFERENCE_LENGTH = 16;
    public static final int TIME_INDICATION_LENGTH = 19;
    public static final int BANK_OPERATION_CODE_LENGTH = 4;
    public static final int INSTRUCTION_CODE_LENGTH = 35;
    public static final int TRANSACTION_TYPE_CODE_LENGTH = 3;
    public static final int VALUE_LENGTH = 24;
    public static final int INSTRUCTED_AMOUNT_LENGTH = 18;
    public static final int EXCHANGE_RATE_LENGTH = 12;
    public static final int DETAILS_OF_CHARGES_LENGTH = 3;
    public static final int SENDERS_CHARGES_LENGTH = 18;
    public static final int RECEIVERS_CHARGES_LENGTH = 18;
    public static final int ENVELOPE_CONTENTS_LENGTH = 9000;

    // MT103 field line count related constants
    public static final int REMITTANCE_INFORMATION_LINE_COUNT = 4;
    public static final int SENDER_TO_RECEIVER_INFORMATION_LINE_COUNT = 6;
    public static final int REGULATORY_REPORTING_LINE_COUNT = 3;
}
