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

package org.wso2.carbon.module.swiftiso20022.models.mt103models.blocks;

import org.wso2.carbon.module.swiftiso20022.models.mt103models.Entity;

import java.util.List;

/**
 * Class that models request payload block04.
 */
public class Block04 {

    private String sendersReference;
    private List<String> timeIndication;
    private String bankOperationCode;
    private List<String> instructionCodes;
    private String transactionTypeCode;
    private String value;
    private String instructedAmount;
    private String exchangeRate;
    private Entity orderingCustomer;
    private Entity sendingInstitution;
    private Entity orderingInstitution;
    private Entity sendersCorrespondent;
    private Entity receiversCorrespondent;
    private Entity thirdReimbursementInstitution;
    private Entity intermediaryInstitution;
    private Entity accountWithInstitution;
    private Entity beneficiaryCustomer;
    private List<String> remittanceInformation;
    private String detailsOfCharges;
    private List<String> sendersCharges;
    private String receiversCharges;
    private List<String> senderToReceiverInformation;
    private List<String> regulatoryReporting;
    private String envelopeContents;
}
