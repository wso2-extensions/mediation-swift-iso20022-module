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

package org.wso2.carbon.module.swiftiso20022.utils;

import org.testng.annotations.DataProvider;

import java.util.Map;

/**
 * Test constants for JsonToMT103TransformerTest.
 */
public class JsonToMT103ValidatorTestConstants {

    public static final String VALID_BLOCK01_PAYLOAD = "{\n" +
            "        \"applicationIdentifier\": \"F\",\n" +
            "        \"serviceIdentifier\": \"01\",\n" +
            "        \"logicalTerminalAddress\": \"BANKFRPPAXXX\",\n" +
            "        \"sessionNumber\": \"4321\",\n" +
            "        \"sequenceNumber\": \"123456\"\n" +
            "    }";
    public static final String VALID_BLOCK02_PAYLOAD = "{\n" +
            "        \"inputOutputIdentifier\": \"O\",\n" +
            "        \"messageType\": \"103\",\n" +
            "        \"inputTime\": \"0930\",\n" +
            "        \"messageInputReference\": \"180711BANKFRPPAXXX7635123456\",\n" +
            "        \"outputDate\": \"091230\",\n" +
            "        \"outputTime\": \"0912\",\n" +
            "        \"priority\": \"N\"\n" +
            "    }";
    public static final String VALID_BLOCK03_PAYLOAD = "{\n" +
            "        \"serviceIdentifier\": \"EBA\",\n" +
            "        \"validationFlag\": \"STP\",\n" +
            "        \"endToEndReference\": \"180f1e65-90e0-44d5-a49a-92b55eb3025f\"\n" +
            "    }";
    public static final String VALID_BLOCK04_PAYLOAD = "{\n" +
            "        \"sendersReference\": \"Ref254\",\n" +
            "        \"timeIndication\": [\n" +
            "            \"/CLSTIME/0800+0100\",\n" +
            "            \"/RNCTIME/0800+0100\"\n" +
            "        ],\n" +
            "        \"bankOperationCode\": \"SPAY\",\n" +
            "        \"instructionCodes\" : [\n" +
            "            \"CHQB/BENEFICIARY\",\n" +
            "            \"CORT\",\n" +
            "            \"PHOI/BENEFICIARY\"\n" +
            "        ],\n" +
            "        \"value\": \"981209USD1000,00\",\n" +
            "        \"instructedAmount\": \"USD1000,00\",\n" +
            "        \"exchangeRate\": \"0,978\",\n" +
            "        \"orderingCustomer\": {\n" +
            "            \"option\": \"F\",\n" +
            "            \"details\": [\n" +
            "                \"/12345678\",\n" +
            "                \"1/SMITH JOHN\",\n" +
            "                \"2/299, PARK AVENUE\",\n" +
            "                \"3/US/NEW YORK, NY 10017\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"sendingInstitution\": {\n" +
            "            \"option\": \"A\",\n" +
            "            \"details\": [\n" +
            "                \"ABNANL2A\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"receiversCorrespondent\": {\n" +
            "            \"option\": \"A\",\n" +
            "            \"details\": [\n" +
            "                \"IRVTUS3N\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"beneficiaryCustomer\": {\n" +
            "            \"option\": \"\",\n" +
            "            \"details\": [\n" +
            "                \"/BE62510007547061\",\n" +
            "                \"JOHANN WILLEMS\",\n" +
            "                \"RUE JOSEPH II, 19\",\n" +
            "                \"1040 BRUSSELS\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"detailsOfCharges\": \"SHA\",\n" +
            "        \"sendersCharges\": [\n" +
            "            \"USD10,00\",\n" +
            "            \"USD5,00\",\n" +
            "            \"USD5,00\"\n" +
            "        ],\n" +
            "        \"receiversCharges\": \"USD10,00\",\n" +
            "        \"senderToReceiverInformation\": [\n" +
            "            \"/INS/ABNANL2A\",\n" +
            "            \"/INT/123456789012345678\"\n" +
            "        ],\n" +
            "        \"regulatoryReporting\": [\n" +
            "            \"/ORDERRES/BE//MEILAAN 1, 9000 GENT\"\n" +
            "        ]\n" +
            "    }";
    public static final String VALID_BLOCK05_PAYLOAD = "{\n" +
            "        \"checksum\": \"123456789ABC\",\n" +
            "        \"possibleDuplicateEmission\": \"0930200912BANKFRPPAXXX7635123456\",\n" +
            "        \"delayedMessage\": \"\",\n" +
            "        \"messageReference\": \"7788990800778899BANKFRPPAXXX4321123456\",\n" +
            "        \"possibleDuplicateMessage\": \"0800778899BANKFRPPAXXX4321123456\",\n" +
            "        \"systemOriginatedMessage\": \"0800778899BANKFRPPAXXX4321123456\"\n" +
            "    }";

    public static final String VALID_PAYLOAD = "{\n" +
            "    \"block01\": " + VALID_BLOCK01_PAYLOAD + ",\n" +
            "    \"block02\": " + VALID_BLOCK02_PAYLOAD + ",\n" +
            "    \"block03\": " + VALID_BLOCK03_PAYLOAD + ",\n" +
            "    \"block04\": " + VALID_BLOCK04_PAYLOAD + ",\n" +
            "    \"block05\": " + VALID_BLOCK05_PAYLOAD + "\n" +
            "}";

    @DataProvider(name = "emptyMandatoryBlockDataProvider")
    Object[][] getEmptyMandatoryBlockDataProvider() {
        return new Object[][]{
                {"{}"},
                {"{\"block01\": " + VALID_BLOCK01_PAYLOAD + "}"},
                {"{\"block01\": " + VALID_BLOCK01_PAYLOAD + ",\n" + "\"block03\":" + VALID_BLOCK03_PAYLOAD + "}"},
        };
    }

    public static String getBlock01Payload(Map<String, String> params) {
        return "{\n" +
                "        \"applicationIdentifier\": " +
                params.getOrDefault("applicationIdentifier", "\"F\"") + ",\n" +
                "        \"serviceIdentifier\": " +
                params.getOrDefault("serviceIdentifier", "\"01\"") + ",\n" +
                "        \"logicalTerminalAddress\": " +
                params.getOrDefault("logicalTerminalAddress", "\"BANKFRPPAXXX\"") + ",\n" +
                "        \"sessionNumber\": " +
                params.getOrDefault("sessionNumber", "\"4321\"") + ",\n" +
                "        \"sequenceNumber\": " +
                params.getOrDefault("sequenceNumber", "\"123456\"") + "\n" +
                "    }";
    }

    @DataProvider(name = "invalidBlock01Payload")
    Object[][] getInvalidBlock01Payload() {
        return new Object[][]{
                {"{}"},
                {getBlock01Payload(Map.of("applicationIdentifier", "\"\""))},
                {getBlock01Payload(Map.of("applicationIdentifier", "\" \""))},
                {getBlock01Payload(Map.of("applicationIdentifier", "\"A\""))},
                {getBlock01Payload(Map.of("applicationIdentifier", "\"F a\""))},
                {getBlock01Payload(Map.of("serviceIdentifier", "\"\""))},
                {getBlock01Payload(Map.of("serviceIdentifier", "\" \""))},
                {getBlock01Payload(Map.of("serviceIdentifier", "\"1\""))},
                {getBlock01Payload(Map.of("serviceIdentifier", "\"1394\""))},
                {getBlock01Payload(Map.of("logicalTerminalAddress", "\"\""))},
                {getBlock01Payload(Map.of("logicalTerminalAddress", "\" \""))},
                {getBlock01Payload(Map.of("logicalTerminalAddress", "\"12314\""))},
                {getBlock01Payload(Map.of("logicalTerminalAddress", "\"BANKFRPPAXXX123\""))},
                {getBlock01Payload(Map.of("logicalTerminalAddress", "\"BANKFRP  XXX\""))},
                {getBlock01Payload(Map.of("sessionNumber", "\"\""))},
                {getBlock01Payload(Map.of("sessionNumber", "\"      \""))},
                {getBlock01Payload(Map.of("sessionNumber", "\"123\""))},
                {getBlock01Payload(Map.of("sessionNumber", "\"13378953\""))},
                {getBlock01Payload(Map.of("sessionNumber", "\"21 1\""))},
                {getBlock01Payload(Map.of("sequenceNumber", "\"\""))},
                {getBlock01Payload(Map.of("sequenceNumber", "\"  \""))},
                {getBlock01Payload(Map.of("sequenceNumber", "\"1234567\""))},
                {getBlock01Payload(Map.of("sequenceNumber", "\"12  567\""))},
        };
    }

    public static String getBlock02Payload(Map<String, String> params) {
        return "{\n" +
                "        \"inputOutputIdentifier\":" +
                params.getOrDefault("inputOutputIdentifier", "\"O\"") + ",\n" +
                "        \"messageType\": " +
                params.getOrDefault("messageType", "\"103\"") + ",\n" +
                "        \"destinationLogicalTerminalAddress\": " +
                params.getOrDefault("destinationLogicalTerminalAddress", "\"BANKFRPPAXXX\"") + ",\n" +
                "        \"inputTime\": " +
                params.getOrDefault("inputTime", "\"0930\"") + ",\n" +
                "        \"messageInputReference\": " +
                params.getOrDefault("messageInputReference",
                        "\"180711BANKFRPPAXXX7635123456\"") + ",\n" +
                "        \"outputDate\": " +
                params.getOrDefault("outputDate", "\"091230\"") + ",\n" +
                "        \"outputTime\": " +
                params.getOrDefault("outputTime", "\"0912\"") + ",\n" +
                "        \"priority\": " +
                params.getOrDefault("priority", "\"N\"") + ",\n" +
                "        \"deliveryMonitoringCode\": " +
                params.getOrDefault("deliveryMonitoringCode", "\"1\"") + ",\n" +
                "        \"obsolescencePeriodCode\": " +
                params.getOrDefault("obsolescencePeriodCode", "\"003\"") + "\n" +
                "    }";
    }

    @DataProvider(name = "invalidBlock02Payload")
    Object[][] getInvalidBlock02Payload() {
        return new Object[][]{
                {"{}"},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\" \""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"S\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I  l\""))},
                {getBlock02Payload(Map.of("messageType", "\"\""))},
                {getBlock02Payload(Map.of("messageType", "\"  \""))},
                {getBlock02Payload(Map.of("messageType", "\"102\""))},
                {getBlock02Payload(Map.of("messageType", "\"1034\""))},
                {getBlock02Payload(Map.of("priority", "\"\""))},
                {getBlock02Payload(Map.of("priority", "\" \""))},
                {getBlock02Payload(Map.of("priority", "\"U  u\""))},
                {getBlock02Payload(Map.of("priority", "\"5\""))},
                {getBlock02Payload(Map.of("inputTime", "\"\""))},
                {getBlock02Payload(Map.of("inputTime", "\" \""))},
                {getBlock02Payload(Map.of("inputTime", "\"091\""))},
                {getBlock02Payload(Map.of("inputTime", "\"091M\""))},
                {getBlock02Payload(Map.of("messageInputReference", "\"\""))},
                {getBlock02Payload(Map.of("messageInputReference", "\"  \""))},
                {getBlock02Payload(Map.of("messageInputReference", "\"  1234\""))},
                {getBlock02Payload(Map.of("messageInputReference", "\"180711BANKFRPPAXXX7635123456PQRST\""))},
                {getBlock02Payload(Map.of("outputDate", "\"\""))},
                {getBlock02Payload(Map.of("outputDate", "\"  \""))},
                {getBlock02Payload(Map.of("outputDate", "\"2012\""))},
                {getBlock02Payload(Map.of("outputDate", "\"2012AB\""))},
                {getBlock02Payload(Map.of("outputTime", "\"\""))},
                {getBlock02Payload(Map.of("outputTime", "\" \""))},
                {getBlock02Payload(Map.of("outputTime", "\"091\""))},
                {getBlock02Payload(Map.of("outputTime", "\"091M\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "destinationLogicalTerminalAddress", "\"\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "destinationLogicalTerminalAddress", "\" \""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "destinationLogicalTerminalAddress", "\"BANK\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "destinationLogicalTerminalAddress", "\"BANKFRPPAXXX123\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "deliveryMonitoringCode", "\"\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "deliveryMonitoringCode", "\" \""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "deliveryMonitoringCode", "\"A\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "deliveryMonitoringCode", "\"12\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "obsolescencePeriodCode", "\"\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "obsolescencePeriodCode", "\"   \""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "obsolescencePeriodCode", "\"01\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "obsolescencePeriodCode", "\"0123\""))},
                {getBlock02Payload(Map.of("inputOutputIdentifier", "\"I\"",
                        "obsolescencePeriodCode", "\"01A\""))},
        };
    }

    public static String getBlock03Payload(Map<String, String> params) {
        return "{\n" +
                "        \"serviceIdentifier\": " +
                params.getOrDefault("serviceIdentifier", "\"EBA\"") + ",\n" +
                "        \"bankingPriority\": " +
                params.getOrDefault("bankingPriority", "\"xxxx\"") + ",\n" +
                "        \"messageUserReference\": " +
                params.getOrDefault("messageUserReference", "\"REF014086252/015\"") + ",\n" +
                "        \"validationFlag\": " +
                params.getOrDefault("validationFlag", "\"STP\"") + ",\n" +
                "        \"endToEndReference\": " +
                params.getOrDefault("endToEndReference",
                        "\"180f1e65-90e0-44d5-a49a-92b55eb3025f\"") + ",\n" +
                "        \"serviceTypeIdentifier\": " +
                params.getOrDefault("serviceTypeIdentifier", "\"325\"") + "\n" +
                "    }";
    }

    @DataProvider(name = "invalidBlock03Payload")
    Object[][] getInvalidBlock03Payload() {
        return new Object[][]{
                {"{}"},
                {getBlock03Payload(Map.of("serviceIdentifier", "\"\""))},
                {getBlock03Payload(Map.of("serviceIdentifier", "\"  \""))},
                {getBlock03Payload(Map.of("serviceIdentifier", "\"EB\""))},
                {getBlock03Payload(Map.of("serviceIdentifier", "\"EB1\""))},
                {getBlock03Payload(Map.of("bankingPriority", "\"\""))},
                {getBlock03Payload(Map.of("bankingPriority", "\"   \""))},
                {getBlock03Payload(Map.of("bankingPriority", "\"xxx\""))},
                {getBlock03Payload(Map.of("bankingPriority", "\"xxxxxx\""))},
                {getBlock03Payload(Map.of("messageUserReference", "\"\""))},
                {getBlock03Payload(Map.of("messageUserReference", "\"   \""))},
                {getBlock03Payload(Map.of("messageUserReference", "\"REF014086252/015ABC\""))},
                {getBlock03Payload(Map.of("validationFlag", "\"\""))},
                {getBlock03Payload(Map.of("validationFlag", "\"FLAG\""))},
                {getBlock03Payload(Map.of("endToEndReference", "\"\""))},
                {getBlock03Payload(Map.of("endToEndReference", "\"    \""))},
                {getBlock03Payload(Map.of("endToEndReference", "\"2844j-fwam-2442\""))},
                {getBlock03Payload(Map.of("endToEndReference", "\"180f1e65-90e0-44d5-a49a-92b55eb3025f-3294\""))},
                {getBlock03Payload(Map.of("serviceTypeIdentifier", "\"\""))},
                {getBlock03Payload(Map.of("serviceTypeIdentifier", "\"   \""))},
                {getBlock03Payload(Map.of("serviceTypeIdentifier", "\"   \""))},
                {getBlock03Payload(Map.of("serviceTypeIdentifier", "\"12A\""))},
        };
    }

    public static String getBlock04Payload(Map<String, String> params) {
        return "{\n" +
                "        \"sendersReference\": " +
                params.getOrDefault("sendersReference", "\"Ref254\"") + ",\n" +
                "        \"timeIndication\": " +
                params.getOrDefault("timeIndication", "[\"/CLSTIME/0800+0100\"]") + ",\n" +
                "        \"bankOperationCode\": " +
                params.getOrDefault("bankOperationCode", "\"SPAY\"") + ",\n" +
                "        \"instructionCodes\" : " +
                params.getOrDefault("instructionCodes",
                        "[\"CHQB/BENEFICIARY\",\"PHOI/BENEFICIARY\"]") + ",\n" +
                "        \"transactionTypeCode\" : " +
                params.getOrDefault("transactionTypeCode", "\"K90\"") + ",\n" +
                "        \"value\": " +
                params.getOrDefault("value", "\"981209USD1000,00\"") + ",\n" +
                "        \"instructedAmount\": " +
                params.getOrDefault("instructedAmount", "\"USD1000,00\"") + ",\n" +
                "        \"exchangeRate\": " +
                params.getOrDefault("exchangeRate", "\"0,978\"") + ",\n" +
                "        \"orderingCustomer\": " +
                params.getOrDefault("orderingCustomer", "{\n" +
                        "            \"option\": \"F\",\n" +
                        "            \"details\": [\n" +
                        "                \"/12345678\",\n" +
                        "                \"1/SMITH JOHN\",\n" +
                        "                \"2/299, PARK AVENUE\",\n" +
                        "                \"3/US/NEW YORK, NY 10017\"\n" +
                        "            ]\n" +
                        "        }") + ",\n" +
                "        \"sendingInstitution\": {\n" +
                "            \"option\": \"A\",\n" +
                "            \"details\": [\n" +
                "                \"ABNANL2A\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"receiversCorrespondent\": {\n" +
                "            \"option\": \"A\",\n" +
                "            \"details\": [\n" +
                "                \"IRVTUS3N\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"beneficiaryCustomer\": {\n" +
                "            \"option\": \"\",\n" +
                "            \"details\": [\n" +
                "                \"/BE62510007547061\",\n" +
                "                \"JOHANN WILLEMS\",\n" +
                "                \"RUE JOSEPH II, 19\",\n" +
                "                \"1040 BRUSSELS\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"remittanceInformation\": " +
                params.getOrDefault("remittanceInformation", "[\"/INV/abc/SDF-96//1234-234///ROC/98I\"]") + ",\n" +
                "        \"detailsOfCharges\": " +
                params.getOrDefault("detailsOfCharges", "\"SHA\"") + ",\n" +
                "        \"sendersCharges\": " +
                params.getOrDefault("sendersCharges", "[\"USD10,00\"]") + ",\n" +
                "        \"receiversCharges\": " +
                params.getOrDefault("receiversCharges", "\"USD10,00\"") + ",\n" +
                "        \"senderToReceiverInformation\": " +
                params.getOrDefault("senderToReceiverInformation",
                        "[\"/INS/ABNANL2A\", \"/INT/123456789012345678\"]") + ",\n" +
                "        \"regulatoryReporting\": " +
                params.getOrDefault("regulatoryReporting",
                        "[\"/ORDERRES/BE//MEILAAN 1, 9000 GENT\"]") + ",\n" +
                "        \"envelopeContents\": " +
                params.getOrDefault("envelopeContents",
                        "\"/UEDI/UNH+123A5+FINPAY:D:98A:UN'DOC+\"") + "\n" +
                "    }";
    }

    public static String getEntityPayload(Map<String, String> params) {
        return "{\n" +
                "            \"option\": " +
                params.getOrDefault("option", "\"A\"") + ",\n" +
                "    \"details\": " +
                params.getOrDefault("details", "[\n\"ABNANL2A\"\n]\n") + "\n" +
                "}\n";
    }

    @DataProvider(name = "invalidBlock04Payload")
    Object[][] getInvalidBlock04Payload() {
        return new Object[][]{
                {"{}"},
                {getBlock04Payload(Map.of("sendersReference", "\"\""))},
                {getBlock04Payload(Map.of("sendersReference", "\"Ref254ABCDEFGHIJKLMNOPQRST\""))},
                {getBlock04Payload(Map.of("timeIndication", "[]"))},
                {getBlock04Payload(Map.of("timeIndication", "[\"\"]"))},
                {getBlock04Payload(Map.of("timeIndication", "[\"/CLSTIME/0915+0200?ABCDEFGHIJ\"]"))},
                {getBlock04Payload(Map.of("bankOperationCode", "\"\""))},
                {getBlock04Payload(Map.of("bankOperationCode", "\"PAY\""))},
                {getBlock04Payload(Map.of("bankOperationCode", "\"PA Y\""))},
                {getBlock04Payload(Map.of("instructionCodes", "[]"))},
                {getBlock04Payload(Map.of("instructionCodes", "[\"\"]"))},
                {getBlock04Payload(Map.of("instructionCodes", "[\"PHOI/BENEFICIARY?ABCDEFGHLJKLMNOPQRSTU\"]"))},
                {getBlock04Payload(Map.of("transactionTypeCode", "\"\""))},
                {getBlock04Payload(Map.of("transactionTypeCode", "\"K\""))},
                {getBlock04Payload(Map.of("transactionTypeCode", "\"K 0\""))},
                {getBlock04Payload(Map.of("transactionTypeCode", "\"K900\""))},
                {getBlock04Payload(Map.of("value", "\"\""))},
                {getBlock04Payload(Map.of("value", "\"981209USD1000,000000000000000000000\""))},
                {getBlock04Payload(Map.of("instructedAmount", "\"\""))},
                {getBlock04Payload(Map.of("instructedAmount", "\"USD1000,00000000000000\""))},
                {getBlock04Payload(Map.of("exchangeRate", "\"\""))},
                {getBlock04Payload(Map.of("exchangeRate", "\"0,923658325398529525922557\""))},
                {getBlock04Payload(Map.of("orderingCustomer", "{}"))},
                {getBlock04Payload(Map.of("orderingCustomer", "{\"option\":\"A\"}"))},
                {getBlock04Payload(Map.of("orderingCustomer",
                        getEntityPayload(Map.of("option", "\"abc\""))))},
                {getBlock04Payload(Map.of("orderingCustomer",
                        getEntityPayload(Map.of("details", "[]"))))},
                {getBlock04Payload(Map.of("orderingCustomer",
                        getEntityPayload(Map.of("details", "[\"\"]"))))},
                {getBlock04Payload(Map.of("orderingCustomer",
                        getEntityPayload(Map.of("details", "[\"   \"]"))))},
                {getBlock04Payload(Map.of("orderingCustomer",
                        getEntityPayload(Map.of(
                                "details", "[\"this line is longer than the allowed character count\"]"))))},
                {getBlock04Payload(Map.of("orderingCustomer",
                        getEntityPayload(Map.of(
                                "details", "[\"line01\",\"line02\",\"line03\",\"line04\",\"line05\"]"))))},
                {getBlock04Payload(Map.of("remittanceInformation", "[]"))},
                {getBlock04Payload(Map.of("remittanceInformation", "[\"\"]"))},
                {getBlock04Payload(Map.of("remittanceInformation",
                        "[\"/INV/abc/SDF-96//1234-234///ROC/98IOPSRTAFFA\"]"))},
                {getBlock04Payload(Map.of("detailsOfCharges", "\"\""))},
                {getBlock04Payload(Map.of("detailsOfCharges", "\"SH1\""))},
                {getBlock04Payload(Map.of("detailsOfCharges", "\"SHA1\""))},
                {getBlock04Payload(Map.of("sendersCharges", "[]"))},
                {getBlock04Payload(Map.of("sendersCharges", "[\"\"]"))},
                {getBlock04Payload(Map.of("sendersCharges", "[\"USD80000000,00000000\"]"))},
                {getBlock04Payload(Map.of("receiversCharges", "\"\""))},
                {getBlock04Payload(Map.of("receiversCharges", "\" \""))},
                {getBlock04Payload(Map.of("receiversCharges", "\"EUR80000000,000000000\""))},
                {getBlock04Payload(Map.of("senderToReceiverInformation", "[]"))},
                {getBlock04Payload(Map.of("senderToReceiverInformation", "[\"\"]"))},
                {getBlock04Payload(Map.of("senderToReceiverInformation",
                        "[\"/INT/1234567890123456789012345678901234567890\"]"))},
                {getBlock04Payload(Map.of("senderToReceiverInformation",
                        "[\"/INT\", \"/INT\", \"/INT\", \"/INT\", \"/INT\", \"/INT\", \"/INT\"]"))},
                {getBlock04Payload(Map.of("regulatoryReporting", "[]"))},
                {getBlock04Payload(Map.of("regulatoryReporting", "[\"\"]"))},
                {getBlock04Payload(Map.of("regulatoryReporting",
                        "[\"/ORDERRES/BE//MEILAAN 1, 9000 GENT ? ABCDEFGHIJKLMNOP\"]"))},
                {getBlock04Payload(Map.of("regulatoryReporting",
                        "[\"/ORDERRES\", \"/ORDERRES\", \"/ORDERRES\", \"/ORDERRES\"]"))},
                {getBlock04Payload(Map.of("envelopeContents", "\"\""))},
        };
    }

    public static String getBlock05Payload(Map<String, String> params) {
        return "{\n" +
                "        \"checksum\": " +
                params.getOrDefault("checksum", "\"123456789ABC\"") + ",\n" +
                "        \"possibleDuplicateEmission\": " +
                params.getOrDefault("possibleDuplicateEmission",
                        "\"0930200912BANKFRPPAXXX7635123456\"") + ",\n" +
                "        \"messageReference\": " +
                params.getOrDefault("messageReference",
                        "\"7788990800778899BANKFRPPAXXX4321123456\"") + ",\n" +
                "        \"possibleDuplicateMessage\": " +
                params.getOrDefault("possibleDuplicateMessage",
                        "\"0800778899BANKFRPPAXXX4321123456\"") + ",\n" +
                "        \"systemOriginatedMessage\": " +
                params.getOrDefault("systemOriginatedMessage",
                        "\"0800778899BANKFRPPAXXX4321123456\"") + "\n" +
                "    }";
    }

    @DataProvider(name = "invalidBlock05Payload")
    Object[][] getInvalidBlock05Payload() {
        return new Object[][]{
                {"{}"},
                {getBlock05Payload(Map.of("checksum", "\"\""))},
                {getBlock05Payload(Map.of("checksum", "\"  \""))},
                {getBlock05Payload(Map.of("checksum", "\"123456789ABCDE\""))},
                {getBlock05Payload(Map.of("possibleDuplicateEmission", "\"\""))},
                {getBlock05Payload(Map.of("possibleDuplicateEmission",
                        "\"1348120811BANKFRPPAXXX2222123456ABC\""))},
                {getBlock05Payload(Map.of("possibleDuplicateEmission", "\"13481208  BANKFRPPAXXX   2123456\""))},
                {getBlock05Payload(Map.of("messageReference", "\"\""))},
                {getBlock05Payload(Map.of("messageReference", "\"1806271539180626BANKFRPPAXXX2222123456ANC\""))},
                {getBlock05Payload(Map.of("messageReference", "\"1806271539180  6BANKFRPPAXXX2   123456\""))},
                {getBlock05Payload(Map.of("possibleDuplicateMessage", "\"\""))},
                {getBlock05Payload(Map.of("possibleDuplicateMessage",
                        "\"1348120811BANKFRPPAXXX2222123456ABC\""))},
                {getBlock05Payload(Map.of("possibleDuplicateMessage", "\"13481208  BANKFRPPAXXX   2123456\""))},
                {getBlock05Payload(Map.of("systemOriginatedMessage", "\"\""))},
                {getBlock05Payload(Map.of("systemOriginatedMessage",
                        "\"1348120811BANKFRPPAXXX2222123456ABC\""))},
                {getBlock05Payload(Map.of("systemOriginatedMessage", "\"13481208  BANKFRPPAXXX   2123456\""))},
        };
    }

}
