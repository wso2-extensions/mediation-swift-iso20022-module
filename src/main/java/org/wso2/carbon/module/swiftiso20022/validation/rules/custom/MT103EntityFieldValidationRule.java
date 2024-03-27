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

package org.wso2.carbon.module.swiftiso20022.validation.rules.custom;

import org.json.JSONArray;
import org.json.JSONObject;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.constants.MT103Constants;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationResult;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidatorContext;

import java.util.List;

/**
 * Entity field refers to fields which identifies an entity e.x: institution, individual
 * Entity fields are accepted as an object with option and details keys.
 * option is a string.
 * details is an array of strings.
 */
public class MT103EntityFieldValidationRule implements ValidationRule {

    private final List<ValidatorContext> contexts;

    public MT103EntityFieldValidationRule(List<ValidatorContext> contexts) {
        this.contexts = contexts;
    }

    /**
     * Method to validate entity JSON object in the payload.
     *
     * @param payload Payload to be validated.
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    @Override
    public ValidationResult validate(JSONObject payload) {
        for (ValidatorContext context : contexts) {

            // validation happens only if the key is present
            if (payload.has(context.getFieldName())) {

                // entity is accepted as a JSON object
                JSONObject entity = payload.getJSONObject(context.getFieldName());

                // validate entity option
                ValidationResult validationResult = validateEntityOption(entity, context);

                if (validationResult.isNotValid()) {
                    return validationResult;
                }

                // validate entity details
                validationResult = validateEntityDetails(entity, context);

                if (validationResult.isNotValid()) {
                    return validationResult;
                }
            }
        }
        return new ValidationResult();
    }

    /**
     * Method to validate the entity option.
     *
     * @param entity  JSONObject containing entity object
     * @param context validation context with validation details
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    private ValidationResult validateEntityOption(JSONObject entity, ValidatorContext context) {

        // check whether the option is provided
        if (entity.has(MT103Constants.MT103_ENTITY_OPTION)) {

            // option is a string
            String option = entity.getString(MT103Constants.MT103_ENTITY_OPTION);

            // option can either be an empty string or a single character
            if (option.length() > 1) {
                return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                        String.format(
                                MT103Constants.ERROR_INVALID_ENTITY_OPTION, context.getFieldDisplayName()));
            }
        } else {
            return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                    String.format(MT103Constants.ERROR_EMPTY_ENTITY_OPTION, context.getFieldDisplayName()));
        }

        return new ValidationResult();
    }

    /**
     * Method to validate the entity details.
     *
     * @param entity  JSONObject containing entity object
     * @param context validation context with validation details
     * @return A {@link ValidationResult} object. Empty if all validations pass, otherwise containing the
     * first encountered error message.
     */
    private ValidationResult validateEntityDetails(JSONObject entity, ValidatorContext context) {

        // check whether the details are provided
        if (entity.has(MT103Constants.MT103_ENTITY_DETAILS)) {

            // details is an array of strings
            JSONArray details = entity.getJSONArray(MT103Constants.MT103_ENTITY_DETAILS);

            // if the key is present there should be at least one value
            if (details.length() == 0) {
                return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                        String.format(
                                MT103Constants.ERROR_EMPTY_ENTITY_DETAILS, context.getFieldDisplayName()));
            }

            // line count should not exceed defined line count
            if (details.length() > MT103Constants.MT103_ENTITY_DETAILS_LINE_COUNT) {
                return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                        String.format(MT103Constants.ERROR_ENTITY_DETAIL_LINE_COUNT,
                                context.getFieldDisplayName()));
            }

            // each value is validated
            for (int i = 0; i < details.length(); i++) {
                String line = details.getString(i);

                // value cannot be blank
                if (line.isBlank()) {
                    return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                            String.format(MT103Constants.ERROR_EMPTY_ENTITY_DETAIL_LINE,
                                    ++i, context.getFieldDisplayName()));
                }

                // value length cannot be longer than defined text line length
                // all entity details line in MT103 has the same length
                if (line.length() > MT103Constants.MT103_TEXT_LINE_LENGTH) {
                    return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                            String.format(MT103Constants.ERROR_ENTITY_DETAIL_LINE_LENGTH,
                                    ++i, context.getFieldDisplayName()));
                }

            }
        } else {
            return new ValidationResult(ConnectorConstants.ERROR_CODE_MISSING_PARAM,
                    String.format(MT103Constants.ERROR_EMPTY_ENTITY_DETAILS, context.getFieldDisplayName()));
        }

        return new ValidationResult();
    }
}
