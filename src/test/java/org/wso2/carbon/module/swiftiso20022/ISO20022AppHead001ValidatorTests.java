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

package org.wso2.carbon.module.swiftiso20022;

import org.apache.synapse.MessageContext;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.core.ConnectException;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.utils.ConnectorUtils;
import org.wso2.carbon.module.swiftiso20022.utils.ISOMessageParser;
import org.wso2.carbon.module.swiftiso20022.utils.ISOToMT940TestConstants;
import org.wso2.carbon.module.swiftiso20022.utils.XSDValidator;

/**
 * Test class for ISO20022headValidator.
 */
@PowerMockIgnore("jdk.internal.reflect.*")
@PrepareForTest({ConnectorUtils.class, ISOMessageParser.class})
public class ISO20022AppHead001ValidatorTests extends PowerMockTestCase {
    private MessageContext messageContext;
    ISO20022AppHead001Validator isoValidator = new ISO20022AppHead001Validator();

    @BeforeClass
    public void init() {
        messageContext = Mockito.spy(MessageContext.class);
    }


    @Test
    public void testISO20022head001ValidatorBusinessHdr() throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(validator);

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);

        PowerMockito.mockStatic(ISOMessageParser.class);
        PowerMockito.when(ISOMessageParser.getRootXMLElement(messageContext))
                .thenReturn(ISOToMT940TestConstants.XML_INPUT_BUSINESS_ENV_TAG);
        PowerMockito.when(ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR))
                .thenReturn(xPath);
        PowerMockito.when(ISOMessageParser.extractISOMessage(messageContext, xPath))
                .thenReturn(ISOToMT940TestConstants.PAYLOAD_APPHDR);

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class,
          expectedExceptionsMessageRegExp = ".*The content of element 'AppHdr' is not complete.*")
    public void testEmptyPayloadScenario() throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(validator);

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);

        PowerMockito.mockStatic(ISOMessageParser.class);
        PowerMockito.when(ISOMessageParser.getRootXMLElement(messageContext))
                .thenReturn(ISOToMT940TestConstants.XML_INPUT_APPHDR_TAG);
        PowerMockito.when(ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR))
                .thenReturn(xPath);
        PowerMockito.when(ISOMessageParser.extractISOMessage(messageContext, xPath))
                .thenReturn(ISOToMT940TestConstants.PAYLOAD_EMPTY_APPHDR);

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to pattern .* for type 'BICFIDec2014Identifier'.*",
            dataProvider = "invalidReceiverBIC", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidReceiverBICScenario(String payload) throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(validator);

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);

        PowerMockito.mockStatic(ISOMessageParser.class);
        PowerMockito.when(ISOMessageParser.getRootXMLElement(messageContext))
                .thenReturn(ISOToMT940TestConstants.XML_INPUT_BUSINESS_ENV_TAG);
        PowerMockito.when(ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR))
                .thenReturn(xPath);
        PowerMockito.when(ISOMessageParser.extractISOMessage(messageContext, xPath))
                .thenReturn(payload);

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to pattern .* for type 'BICFIDec2014Identifier'.*",
            dataProvider = "invalidSenderBIC", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidSenderBICScenario(String payload) throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(validator);

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);

        PowerMockito.mockStatic(ISOMessageParser.class);
        PowerMockito.when(ISOMessageParser.getRootXMLElement(messageContext))
                .thenReturn(ISOToMT940TestConstants.XML_INPUT_BUSINESS_ENV_TAG);
        PowerMockito.when(ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR))
                .thenReturn(xPath);
        PowerMockito.when(ISOMessageParser.extractISOMessage(messageContext, xPath))
                .thenReturn(payload);

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'dateTime'.*",
            dataProvider = "invalidCreationDate", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidCreationDateScenario(String payload) throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(validator);

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);

        PowerMockito.mockStatic(ISOMessageParser.class);
        PowerMockito.when(ISOMessageParser.getRootXMLElement(messageContext))
                .thenReturn(ISOToMT940TestConstants.XML_INPUT_BUSINESS_ENV_TAG);
        PowerMockito.when(ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR))
                .thenReturn(xPath);
        PowerMockito.when(ISOMessageParser.extractISOMessage(messageContext, xPath))
                .thenReturn(payload);

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
   ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '(1|35)' for type 'Max35Text'.*",
            dataProvider = "invalidBusinessMsgId", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidBusinessMsgId(String payload) throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(validator);

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);

        PowerMockito.mockStatic(ISOMessageParser.class);
        PowerMockito.when(ISOMessageParser.getRootXMLElement(messageContext))
                .thenReturn(ISOToMT940TestConstants.XML_INPUT_BUSINESS_ENV_TAG);
        PowerMockito.when(ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR))
                .thenReturn(xPath);
        PowerMockito.when(ISOMessageParser.extractISOMessage(messageContext, xPath))
                .thenReturn(payload);

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
   ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '(1|35)' for type 'Max35Text'.*",
            dataProvider = "invalidMessageDefId", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidMessageDefinitionId(String payload) throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(validator);

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);

        PowerMockito.mockStatic(ISOMessageParser.class);
        PowerMockito.when(ISOMessageParser.getRootXMLElement(messageContext))
                .thenReturn(ISOToMT940TestConstants.XML_INPUT_BUSINESS_ENV_TAG);
        PowerMockito.when(ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR))
                .thenReturn(xPath);
        PowerMockito.when(ISOMessageParser.extractISOMessage(messageContext, xPath))
                .thenReturn(payload);

        isoValidator.connect(messageContext);
    }
}
