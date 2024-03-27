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

package org.wso2.carbon.module.swiftiso20022;

import org.apache.axis2.context.MessageContext;
import org.apache.synapse.SynapseException;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.json.JSONObject;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.module.swiftiso20022.utils.ConnectorUtils;
import org.wso2.carbon.module.swiftiso20022.utils.JsonToMT103ValidatorTestConstants;
import org.wso2.carbon.module.swiftiso20022.utils.JsonToMt103Utils;
import org.wso2.carbon.module.swiftiso20022.validation.common.ValidationResult;

import java.util.Optional;

/**
 * Test class for JsonToMt103Transformer.
 */
@PowerMockIgnore("jdk.internal.reflect.*")
@PrepareForTest({ConnectorUtils.class})
public class JsonToMT103ValidatorTests extends PowerMockTestCase {

    private MessageContext messageContext;

    JsonToMT103Validator jsonToMT103Transformer = new JsonToMT103Validator();

    @BeforeClass
    public void init() {
        messageContext = Mockito.spy(MessageContext.class);
    }

    @Test
    public void testJsonToMT103Transformer() throws Exception {
        Axis2MessageContext msgCxt = Mockito.mock(Axis2MessageContext.class);
        Mockito.doReturn(messageContext).when(msgCxt).getAxis2MessageContext();

        PowerMockito.mockStatic(ConnectorUtils.class);
        PowerMockito.when(ConnectorUtils.buildMessagePayloadFromMessageContext(messageContext))
                .thenReturn(Optional.of(JsonToMT103ValidatorTestConstants.VALID_PAYLOAD));
        PowerMockito.doNothing().when(ConnectorUtils.class, "appendErrorToMessageContext",
                Mockito.any(), Mockito.anyString(), Mockito.anyString());

        jsonToMT103Transformer.connect(msgCxt);
    }

    @Test(expectedExceptions = SynapseException.class, dataProvider = "emptyMandatoryBlockDataProvider",
            dataProviderClass = JsonToMT103ValidatorTestConstants.class)
    public void testEmptyMandatoryBlock(String payload) throws Exception {
        Axis2MessageContext msgCxt = Mockito.mock(Axis2MessageContext.class);
        Mockito.doReturn(messageContext).when(msgCxt).getAxis2MessageContext();

        PowerMockito.mockStatic(ConnectorUtils.class);
        PowerMockito.when(ConnectorUtils.buildMessagePayloadFromMessageContext(messageContext))
                .thenReturn(Optional.of(payload));
        PowerMockito.doNothing().when(ConnectorUtils.class, "appendErrorToMessageContext",
                Mockito.any(), Mockito.anyString(), Mockito.anyString());

        jsonToMT103Transformer.connect(msgCxt);
    }

    @Test(dataProvider = "invalidBlock01Payload", dataProviderClass = JsonToMT103ValidatorTestConstants.class)
    public void testValidateBlock01(String block01PayloadString) {
        JSONObject block01 = new JSONObject(block01PayloadString);
        ValidationResult validationResult = JsonToMt103Utils.validateBlock01(block01);

        Assert.assertFalse(validationResult.isValid());
    }

    @Test(dataProvider = "invalidBlock02Payload", dataProviderClass = JsonToMT103ValidatorTestConstants.class)
    public void testValidateBlock02(String block02PayloadString) {
        JSONObject block02 = new JSONObject(block02PayloadString);
        ValidationResult validationResult = JsonToMt103Utils.validateBlock02(block02);

        Assert.assertFalse(validationResult.isValid());
    }

    @Test(dataProvider = "invalidBlock03Payload", dataProviderClass = JsonToMT103ValidatorTestConstants.class)
    public void testValidateBlock03(String block03PayloadString) {
        JSONObject block03 = new JSONObject(block03PayloadString);
        ValidationResult validationResult = JsonToMt103Utils.validateBlock03(block03);

        Assert.assertFalse(validationResult.isValid());
    }

    @Test(dataProvider = "invalidBlock04Payload", dataProviderClass = JsonToMT103ValidatorTestConstants.class)
    public void testValidateBlock04(String block04PayloadString) {
        JSONObject block04 = new JSONObject(block04PayloadString);
        ValidationResult validationResult = JsonToMt103Utils.validateBlock04(block04);

        Assert.assertFalse(validationResult.isValid());
    }

    @Test(dataProvider = "invalidBlock05Payload", dataProviderClass = JsonToMT103ValidatorTestConstants.class)
    public void testValidateBlock05(String block05PayloadString) {
        JSONObject block05 = new JSONObject(block05PayloadString);
        ValidationResult validationResult = JsonToMt103Utils.validateBlock05(block05);

        Assert.assertFalse(validationResult.isValid());
    }
}
