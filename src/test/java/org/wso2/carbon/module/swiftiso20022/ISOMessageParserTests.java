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

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.synapse.MessageContext;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.connector.core.ConnectException;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.utils.ISOMessageParser;
import org.wso2.carbon.module.swiftiso20022.utils.ISOToMT940TestConstants;

/**
 * Test class for ISOMessageParser.
 */
@PowerMockIgnore("jdk.internal.reflect.*")
public class ISOMessageParserTests extends PowerMockTestCase {
    private MessageContext messageContext;

    @BeforeClass
    public void init() {
        messageContext = Mockito.spy(MessageContext.class);
    }

    private SOAPEnvelope getSOAPEnvelope(String xmlPayload) throws Exception {
        OMElement payloadElement = AXIOMUtil.stringToOM(xmlPayload);

        SOAPFactory soapFac = OMAbstractFactory.getSOAP11Factory();
        SOAPEnvelope soapEnv = soapFac.createSOAPEnvelope();
        SOAPBody soapBody = soapFac.createSOAPBody();
        soapBody.addChild(payloadElement);
        soapEnv.addChild(soapBody);

        return soapEnv;
    }

    @Test
    public void testGetRootElementWithAppHdr() throws Exception {
        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_APPHDR_AND_DOCUMENT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        String rootElement = ISOMessageParser.getRootXMLElement(messageContext);
        Assert.assertEquals(ConnectorConstants.XML_INPUT_BUSINESS_ENV_TAG, rootElement);
    }

    @Test
    public void testGetRootElementWithoutAppHdr() throws Exception {
        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_CAMT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        String rootElement = ISOMessageParser.getRootXMLElement(messageContext);
        Assert.assertEquals(ConnectorConstants.XML_INPUT_DOCUMENT_TAG, rootElement);
    }

    @Test(expectedExceptions = OMException.class)
    public void testEmptyPayloadScenario() throws Exception {
        SOAPEnvelope soapEnvelope = getSOAPEnvelope("");
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        String rootElement = ISOMessageParser.getRootXMLElement(messageContext);
        Assert.assertNull(rootElement);
    }

    @Test
    public void testExtractAppHdrFromBusinessMessage() throws Exception {
        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_APPHDR_AND_DOCUMENT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_APPHDR);
        String extractMsg = ISOMessageParser.extractISOMessage(messageContext, xPath);
        Assert.assertEquals(ISOToMT940TestConstants.PAYLOAD_APPHDR, extractMsg);
    }

    @Test
    public void testExtractDocumentFromBusinessMessage() throws Exception {
        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_APPHDR_AND_DOCUMENT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        String xPath = ISOMessageParser.constructXPath(true, ConnectorConstants.XPATH_DOCUMENT);
        String extractMsg = ISOMessageParser.extractISOMessage(messageContext, xPath);
        Assert.assertEquals(ISOToMT940TestConstants.PAYLOAD_CAMT, extractMsg);
    }

    @Test
    public void testExtractDocumentFromMessageWithoutAppHdr() throws Exception {
        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_CAMT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        String xPath = ISOMessageParser.constructXPath(false, ConnectorConstants.XPATH_DOCUMENT);
        String extractMsg = ISOMessageParser.extractISOMessage(messageContext, xPath);
        Assert.assertEquals(ISOToMT940TestConstants.PAYLOAD_CAMT, extractMsg);
    }

    @Test(expectedExceptions = ConnectException.class)
    public void testInvalidXPathScenario() throws Exception {
        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_APPHDR_AND_DOCUMENT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        String xPath = ISOMessageParser.constructXPath(false, ConnectorConstants.XPATH_DOCUMENT);
        String extractMsg = ISOMessageParser.extractISOMessage(messageContext, xPath);
        Assert.assertEquals(ISOToMT940TestConstants.PAYLOAD_CAMT, extractMsg);
    }
}
