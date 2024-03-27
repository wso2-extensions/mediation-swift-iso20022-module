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

package org.wso2.carbon.module.swiftiso20022.validation.common;

/**
 * Class to hold the result details of the validation.
 */
public class ValidationResult {
    private final boolean isValid;
    private final String errorCode;
    private final String errorMessage;

    public ValidationResult() {
        this(true, null, null);
    }

    public ValidationResult(boolean isValid, String errorCode, String errorMessage) {
        this.isValid = isValid;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ValidationResult(String errorCode, String errorMessage) {
        this(false, errorCode, errorMessage);
    }

    public boolean isValid() {
        return this.isValid;
    }

    /**
     * @return A boolean specifying whether the validation is failed.
     */
    public boolean isNotValid() {
        return !this.isValid();
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
