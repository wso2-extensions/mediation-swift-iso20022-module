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

package org.wso2.carbon.module.swiftiso20022.models.mt103models;

import org.wso2.carbon.module.swiftiso20022.models.mt103models.blocks.Block01;
import org.wso2.carbon.module.swiftiso20022.models.mt103models.blocks.Block02;
import org.wso2.carbon.module.swiftiso20022.models.mt103models.blocks.Block03;
import org.wso2.carbon.module.swiftiso20022.models.mt103models.blocks.Block04;
import org.wso2.carbon.module.swiftiso20022.models.mt103models.blocks.Block05;

/**
 * Class that models the request payload.
 */
public class MT103JsonRequestPayload {
    private Block01 block01;
    private Block02 block02;
    private Block03 block03;
    private Block04 block04;
    private Block05 block05;
}
