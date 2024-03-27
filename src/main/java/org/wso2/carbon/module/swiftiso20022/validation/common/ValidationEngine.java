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

package org.wso2.carbon.module.swiftiso20022.validation.common;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.module.swiftiso20022.validation.rules.AlphaNumericParamValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.AlphaParamValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.CurrencyFormatValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.DateFormatValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.EnumValueMatchValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.FixedValueParamValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.MTCharacterSetXValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.MandatoryParamValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.NumericParamValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.OptionalStringParamValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.rules.ParameterLengthValidationRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Validation Engine class to perform validation rules.
 */
public class ValidationEngine {

    private static final Logger logger = LoggerFactory.getLogger(ValidationEngine.class);

    private final List<ValidationRule> ruleList;

    public ValidationEngine() {
        ruleList = new ArrayList<>();
    }

    public ValidationEngine addMandatoryParamValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new MandatoryParamValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addOptionalStringParamValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new OptionalStringParamValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addAlphaNumericParamValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new AlphaNumericParamValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addAlphaParamValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new AlphaParamValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addNumericParamValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new NumericParamValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addMTCharacterSetXValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new MTCharacterSetXValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addParameterLengthValidationRule(List<ValidatorContext> validationParamList,
                                                             List<String> definedLengthFields) {
        this.ruleList.add(new ParameterLengthValidationRule(validationParamList, definedLengthFields));
        return this;
    }

    public ValidationEngine addDateFormatValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new DateFormatValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addCurrencyFormatValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new CurrencyFormatValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addEnumValueMatchValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new EnumValueMatchValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addFixedValueParamValidationRule(List<ValidatorContext> validationParamList) {
        this.ruleList.add(new FixedValueParamValidationRule(validationParamList));
        return this;
    }

    public ValidationEngine addCustomRule(ValidationRule rule) {
        this.ruleList.add(rule);
        return this;
    }

    /**
     * Recursively validate Validation Rule Set.
     *
     * @return validation results.
     */
    public ValidationResult validate(JSONObject payload) {

        for (ValidationRule rule : this.ruleList) {
            ValidationResult validationResult = rule.validate(payload);
            if (logger.isDebugEnabled()) {
                logger.debug(String.format("applicable validator %s invoked with context and returned %b",
                        rule.getClass().getSimpleName(), validationResult.isValid()));
            }

            if (!validationResult.isValid()) {
                if (logger.isDebugEnabled()) {
                    logger.debug(String.format("Stop on failure validator %s returned unsuccessful" +
                                    " validation therefore stopping further validation",
                            rule.getClass().getSimpleName()));
                }
                return validationResult;
            }
        }
        return new ValidationResult();
    }
}
