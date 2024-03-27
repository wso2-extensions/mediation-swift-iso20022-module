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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.constants.MT103Constants;
import org.wso2.carbon.module.swiftiso20022.validation.JsonToMT103PayloadValidator;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationResult;

/**
 * Class with Json to Mt103 utility methods.
 */
public class JsonToMt103Utils {

    private static final Log logger = LogFactory.getLog(JsonToMt103Utils.class);

    /**
     * Method to validate block 01 of the JSON payload.
     *
     * @param block01Json JSON object of block 01. Can be null
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    public static ValidationResult validateBlock01(JSONObject block01Json) {

        logger.debug("Validating block 01");

        // block 01 is mandatory block
        if (block01Json == null) {
            return new ValidationResult(ConnectorConstants.ERROR_CODE_MISSING_BLOCK,
                    String.format(ConnectorConstants.ERROR_MANDATORY_BLOCK_MISSING, MT103Constants.BLOCK01));
        }

        // validate remaining fields using common validation rules
        return JsonToMT103PayloadValidator.getMT103Block01ValidationEngine().validate(block01Json);
    }

    /**
     * Method to validate block 02 of the JSON payload.
     *
     * @param block02 JSON object of block 02. Can be null
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    public static ValidationResult validateBlock02(JSONObject block02) {

        logger.debug("Validating block 02");

        // block 02 is an optional block
        if (block02 == null) {
            logger.debug("Optional block 02 is absent");
            return new ValidationResult();
        }

        // variable to store input output identifier
        // it is a mandatory parameter
        String inputOutputID;
        if (block02.has(MT103Constants.BLOCK02_INPUT_OUTPUT_ID_KEY)) {
            inputOutputID = block02.getString(MT103Constants.BLOCK02_INPUT_OUTPUT_ID_KEY);
        } else {
            return new ValidationResult(ConnectorConstants.ERROR_CODE_MISSING_PARAM,
                    String.format(ConnectorConstants.ERROR_PARAMETER_MISSING,
                            ConnectorConstants.BLOCK02_INPUT_OUTPUT_ID));
        }

        // input output identifier can only be either "I" or "O"
        switch (inputOutputID) {

            case ConnectorConstants.BLOCK02_INPUT_ID:
                // validate input block 02 header
                return JsonToMT103PayloadValidator.getMT103InputBlock02ValidationEngine().validate(block02);

            case ConnectorConstants.BLOCK02_OUTPUT_ID:
                // validate output block 02 header
                return JsonToMT103PayloadValidator.getMT103OutputBlock02ValidationEngine().validate(block02);
            default:
                // any other character is invalid
                return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                        String.format(ConnectorConstants.ERROR_PARAMETER_INVALID,
                                ConnectorConstants.BLOCK02_INPUT_OUTPUT_ID));
        }
    }

    /**
     * Method to validate block 03 of the JSON payload.
     *
     * @param block03 JSON object of block 03. Can be null
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    public static ValidationResult validateBlock03(JSONObject block03) {

        logger.debug("Validating block 03");

        // block 03 is a mandatory block
        if (block03 == null) {
            return new ValidationResult(ConnectorConstants.ERROR_CODE_MISSING_BLOCK,
                    String.format(ConnectorConstants.ERROR_MANDATORY_BLOCK_MISSING, MT103Constants.BLOCK03));
        }

        // validate remaining fields using common validation rules
        return JsonToMT103PayloadValidator.getMT103Block03ValidationEngine().validate(block03);
    }

    /**
     * Method to validate block 04 of the JSON payload.
     *
     * @param block04 JSON object of block 04. Can be null
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    public static ValidationResult validateBlock04(JSONObject block04) {

        logger.debug("Validating block 04");

        // block 04 is a mandatory block
        if (block04 == null) {
            return new ValidationResult(ConnectorConstants.ERROR_CODE_MISSING_BLOCK,
                    String.format(ConnectorConstants.ERROR_MANDATORY_BLOCK_MISSING, MT103Constants.BLOCK04));
        }

        // validate remaining fields using common validation rules
        return JsonToMT103PayloadValidator.getMT103Block04ValidationEngine().validate(block04);
    }

    /**
     * Method to validate block 05 of the JSON payload.
     *
     * @param block05 JSON object of block 05. Can be null
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    public static ValidationResult validateBlock05(JSONObject block05) {

        logger.debug("Validating block 05");

        // block 05 is an optional block
        if (block05 == null) {
            logger.debug("Optional block 05 is absent");
            return new ValidationResult();
        }

        // validate remaining fields using common validation rules
        return JsonToMT103PayloadValidator.getMT103Block05ValidationEngine().validate(block05);
    }
}
