package org.wso2.carbon.module.swiftiso20022.validation.rules;

import org.json.JSONObject;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationResult;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationRule;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidatorContext;

import java.util.List;

/**
 * Validation rule to check a string field with a fixed value.
 */
public class FixedValueParamValidationRule implements ValidationRule {
    private final List<ValidatorContext> contexts;


    /**
     * @param contexts list of validation contexts to be validated
     *                 use {@link ConnectorConstants#FIXED_VALUE_KEY} to store the value as a property
     *                 value should be a string
     */
    public FixedValueParamValidationRule(List<ValidatorContext> contexts) {
        this.contexts = contexts;
    }

    @Override
    public ValidationResult validate(JSONObject payload) {

        for (ValidatorContext context : this.contexts) {

            // validation happens only if the field is present
            if (payload.has(context.getFieldName())) {

                // get the value to be validated from the payload
                String value = payload.getString(context.getFieldName());

                // get predefined value from the context
                String fixedValue = (String) context.getProperty(ConnectorConstants.FIXED_VALUE_KEY);

                if (!fixedValue.equals(value)) {
                    return new ValidationResult(ConnectorConstants.ERROR_CODE_INVALID_PARAM,
                            String.format(ConnectorConstants.ERROR_PARAMETER_INVALID, context.getFieldDisplayName()));
                }
            }
        }

        return new ValidationResult();
    }
}
