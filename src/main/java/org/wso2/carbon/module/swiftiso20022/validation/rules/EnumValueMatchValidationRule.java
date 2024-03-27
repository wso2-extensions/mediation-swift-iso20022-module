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

package org.wso2.carbon.module.swiftiso20022.validation.rules;

import org.json.JSONObject;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationResult;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidatorContext;

import java.util.List;

/**
 * Checks whether value matches with the provided in enum in the validation list.
 */
public class EnumValueMatchValidationRule implements ValidationRule {

    private final List<ValidatorContext> validationParamList;

    // Validation context must include enum class as a property.
    // Key to store enum name is "enumClassName"
    public EnumValueMatchValidationRule(List<ValidatorContext> validationParamList) {
        this.validationParamList = validationParamList;
    }

    /**
     * Validate whether the parameter contains a value from a predefined value set.
     *
     * @param payload Payload to be validated.
     * @return Validation Result
     */
    @Override
    public ValidationResult validate(JSONObject payload) {
        for (ValidatorContext ctx : validationParamList) {

            // validation happens only if the key is present
            if (payload.has(ctx.getFieldName())) {
                String stringValue = payload.getString(ctx.getFieldName());

                // getting enum class from the validation context
                // invalid class will fail the process
                Class<?> enumClass = (Class<?>) ctx.getProperty(ConnectorConstants.ENUM_KEY);

                // iterate each enum value
                for (Object enumValue : enumClass.getEnumConstants()) {

                    // checks equality with enum value after converting it to a string
                    if (enumValue.toString().equals(stringValue)) {
                        return new ValidationResult();
                    }
                }
                return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                        String.format(ConnectorConstants.ERROR_PARAMETER_INVALID, ctx.getFieldDisplayName()));
            }
        }
        return new ValidationResult();
    }
}
