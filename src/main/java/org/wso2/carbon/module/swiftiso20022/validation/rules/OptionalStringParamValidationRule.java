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

package org.wso2.carbon.module.swiftiso20022.validation.rules;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationResult;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidatorContext;

import java.util.List;

/**
 * Optional Param Validation Rule.
 */
public class OptionalStringParamValidationRule implements ValidationRule {

    private final List<ValidatorContext> validationParamList;

    public OptionalStringParamValidationRule(List<ValidatorContext> validationParamList) {
        this.validationParamList = validationParamList;
    }
    /**
     * Validate whether the string parameter is an optional param.
     *
     * @param payload    Payload to be validated.
     * @return Validation Result
     */
    @Override
    public ValidationResult validate(JSONObject payload) {
        for (ValidatorContext ctx : validationParamList) {
            if (payload.has(ctx.getFieldName())) {
                Object value = payload.get(ctx.getFieldName());
                if (value instanceof String && StringUtils.isBlank(value.toString())) {
                    return new ValidationResult(ConnectorConstants.ERROR_CODE_MISSING_PARAM,
                            String.format(ConnectorConstants.ERROR_OPTIONAL_PARAM_MISSING,
                                    ctx.getFieldDisplayName()));
                }
            }
        }
        return new ValidationResult();
    }
}
