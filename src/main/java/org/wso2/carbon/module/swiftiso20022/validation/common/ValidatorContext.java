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

import java.util.Map;

/**
 * Context class to hold the request attributes for validation.
 */
public class ValidatorContext {

    private final String fieldName;
    private final String fieldDisplayName;
    private int fieldLength;

    // to store any additional property to be used in custom validators
    private Map<String, Object> properties;

    public ValidatorContext(String fieldName, String fieldDisplayName) {
        this.fieldName = fieldName;
        this.fieldDisplayName = fieldDisplayName;
    }

    public ValidatorContext(String fieldName, String fieldDisplayName, int fieldLength) {
        this.fieldName = fieldName;
        this.fieldDisplayName = fieldDisplayName;
        this.fieldLength = fieldLength;
    }

    public ValidatorContext(String fieldName,
                            String fieldDisplayName, int fieldLength, Map<String, Object> properties) {
        this(fieldName, fieldDisplayName, fieldLength);
        this.properties = properties;
    }

    public ValidatorContext(String fieldName, String fieldDisplayName, Map<String, Object> properties) {
        this.fieldName = fieldName;
        this.fieldDisplayName = fieldDisplayName;
        this.properties = properties;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDisplayName() {
        return fieldDisplayName;
    }

    public int getFieldLength() {
        return fieldLength;
    }

    // method to directly access stored property
    public Object getProperty(String key) {
        return properties.get(key);
    }
}
