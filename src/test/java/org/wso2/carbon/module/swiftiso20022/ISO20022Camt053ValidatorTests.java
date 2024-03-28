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
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.SynapseException;
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
import org.wso2.carbon.module.swiftiso20022.utils.ISOToMT940TestConstants;
import org.wso2.carbon.module.swiftiso20022.utils.XSDValidator;

/**
 * Test class for ISO20022camtValidator.
 */
@PowerMockIgnore("jdk.internal.reflect.*")
@PrepareForTest({ConnectorUtils.class})
public class ISO20022Camt053ValidatorTests extends PowerMockTestCase {
    private MessageContext messageContext;
    ISO20022Camt053Validator isoValidator = new ISO20022Camt053Validator();

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
    public void testISO20022camt053ValidatorWithoutBusinessHdr() throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(validator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_CAMT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test
    public void testISO20022camt053ValidatorWithBusinessHdr() throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_APPHDR_AND_DOCUMENT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = SynapseException.class,
            expectedExceptionsMessageRegExp = "Invalid ISO XML root tag element")
    public void testInvalidRootElementWithoutAppHdrScenario() throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(validator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_INVALID_ROOT_ELEMENT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = SynapseException.class,
            expectedExceptionsMessageRegExp = "Invalid ISO XML root tag element")
    public void testInvalidRootElementWithAppHdrScenario() throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_INVALID_ROOT_ELEMENT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class,
            expectedExceptionsMessageRegExp =  ".*The content of element 'Document' is not complete.*")
    public void testEmptyPayloadScenario() throws Exception {
        XSDValidator validator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(validator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_EMPTY_CAMT);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }


    @Test(expectedExceptions = ConnectException.class,
            expectedExceptionsMessageRegExp =  ".*The content of element 'Document' is not complete.*")
    public void testEmptyDocumentPayloadWithAppHdrScenario() throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(ISOToMT940TestConstants.PAYLOAD_EMPTY_CAMT_WITH_APPHDR);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '(1|35)' for type " +
            "'Max35Text'.*",
            dataProvider = "invalidStmtId", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidStmtIdScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            "(Electronic Sequence number not present.*|.*'.*' is not a valid value for 'decimal'.*)",
            dataProvider = "invalidElectSeqNumber", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidElectSeqNumScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            "(Legal Sequence number not present.*|.*Invalid content was found starting with element 'LogSeqNum'.*)",
            dataProvider = "invalidLogSeqNumber", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidLogicSeqNumScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'dateTime'.*",
            dataProvider = "invalidCreatedDateTime", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidCreatedTimeScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '[14]' for type " +
            "'ExternalBalanceType1Code'.*",
            dataProvider = "invalidOpeningBalCd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidOpeningBalanceCdScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to pattern '\\[A-Z]\\{3,3}' for type " +
            "'ActiveOrHistoricCurrencyCode'.*",
            dataProvider = "invalidOpeningBalCCY", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidOpeningBalanceCCYScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'decimal'.*",
            dataProvider = "invalidOpeningBalAmt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidOpeningBalanceAmtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".* Value '.*' is not facet-valid with respect to enumeration '\\[CRDT, DBIT]'. " +
            "It must be a value from the enumeration.*",
            dataProvider = "invalidOpeningBalInd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidOpeningBalanceIndScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'dateTime'.*",
            dataProvider = "invalidOpeningBalDt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidOpeningBalanceDtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '[14]' for type " +
                    "'ExternalBalanceType1Code'.*",
            dataProvider = "invalidClosingBalCd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingBalanceCdScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to pattern '\\[A-Z]\\{3,3}' for type " +
                    "'ActiveOrHistoricCurrencyCode'.*",
            dataProvider = "invalidClosingBalCCY", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingBalanceCCYScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'decimal'.*",
            dataProvider = "invalidClosingBalAmt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingBalanceAmtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to enumeration '\\[CRDT, DBIT]'. " +
                    "It must be a value from the enumeration.*",
            dataProvider = "invalidClosingBalInd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingBalanceIndScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'dateTime'.*",
            dataProvider = "invalidOpeningBalDt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingBalanceDtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '[14]' for type " +
                    "'ExternalBalanceType1Code'.*",
            dataProvider = "invalidClosingAvlBalCd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingAvlBalanceCdScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to pattern '\\[A-Z]\\{3,3}' for type " +
                    "'ActiveOrHistoricCurrencyCode'.*",
            dataProvider = "invalidClosingAvlBalCCY", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingAvlBalanceCCYScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'decimal'.*",
            dataProvider = "invalidClosingAvlBalAmt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingAvlBalanceAmtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to enumeration '\\[CRDT, DBIT]'. " +
                    "It must be a value from the enumeration.*",
            dataProvider = "invalidClosingAvlBalInd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingAvlBalanceIndScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'dateTime'.*",
            dataProvider = "invalidClosingAvlBalDt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidClosingAvlBalanceDtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '[14]' for type " +
                    "'ExternalBalanceType1Code'.*",
            dataProvider = "invalidForwardAvlBalCd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidForwardAvlBalanceCdScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to pattern '\\[A-Z]\\{3,3}' for type " +
                    "'ActiveOrHistoricCurrencyCode'.*",
            dataProvider = "invalidForwardAvlBalCCY", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidForwardAvlBalanceCCYScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'decimal'.*",
            dataProvider = "invalidForwardAvlBalAmt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidForwardAvlBalanceAmtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to enumeration '\\[CRDT, DBIT]'. " +
                    "It must be a value from the enumeration.*",
            dataProvider = "invalidForwardAvlBalInd", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidForwardAvlBalanceIndScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'dateTime'.*",
            dataProvider = "invalidForwardAvlBalDt", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidForwardAvlBalanceDtScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' is not facet-valid with respect to pattern '\\[A-Z]\\{3,3}' for type " +
            "'ActiveOrHistoricCurrencyCode'.*",
            dataProvider = "invalidTransCCYEntry", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidTransactionCCYEntryScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'decimal'.*",
            dataProvider = "invalidTransAmtEntry", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidTransactionAmtEntryScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".* Value '.*' is not facet-valid with respect to enumeration '\\[CRDT, DBIT]'. " +
            "It must be a value from the enumeration.*",
            dataProvider = "invalidTransIndEntry", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidTransactionIndEntryScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'boolean'.*",
            dataProvider = "invalidTransRvslIndEntry", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidTransactionRvslIndEntryScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'dateTime'.*",
            dataProvider = "invalidTransBkDtEntry", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidTransactionBkDtEntryScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*'.*' is not a valid value for 'date'.*",
            dataProvider = "invalidTransDtEntry", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidTransactionDtEntryScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            ".*Value '.*' with length = '.*' is not facet-valid with respect to (min|max)Length '(1|35)' for type" +
            " 'Max35Text'.*",
            dataProvider = "invalidTransAcctSvcrRefEntry", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidTransactionAcctSvcrRefEntryScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }

    @Test(expectedExceptions = ConnectException.class, expectedExceptionsMessageRegExp =
            "Missing (Opening|Closing) Balance in ISO20022.camt.053 message",
            dataProvider = "invalidBalance", dataProviderClass = ISOToMT940TestConstants.class)
    public void testInvalidBalanceScenario(String payload) throws Exception {
        XSDValidator appHdrValidator = Mockito.mock(XSDValidator.class);
        XSDValidator documentValidator = Mockito.mock(XSDValidator.class);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_HEAD_001_001).thenReturn(appHdrValidator);
        PowerMockito.whenNew(XSDValidator.class).
                withArguments(ConnectorConstants.XSD_SCHEMA_CAMT_053_001).thenReturn(documentValidator);

        SOAPEnvelope soapEnvelope = getSOAPEnvelope(payload);
        PowerMockito.doReturn(soapEnvelope).when(messageContext).getEnvelope();

        isoValidator.connect(messageContext);
    }
}
