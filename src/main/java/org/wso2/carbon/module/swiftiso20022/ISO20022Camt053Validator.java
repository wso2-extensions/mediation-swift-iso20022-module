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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.jaxen.JaxenException;
import org.wso2.carbon.connector.core.AbstractConnector;
import org.wso2.carbon.connector.core.ConnectException;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;
import org.wso2.carbon.module.swiftiso20022.utils.ConnectorUtils;
import org.wso2.carbon.module.swiftiso20022.utils.ISO20022Camt053ValidatorUtils;
import org.wso2.carbon.module.swiftiso20022.utils.ISOMessageParser;
import org.wso2.carbon.module.swiftiso20022.utils.XSDValidator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.IOException;

/**
 * Validate the ISO20022.camt.053 message.
 */
public class ISO20022Camt053Validator extends AbstractConnector {
    private static Log log = LogFactory.getLog(ISO20022Camt053Validator.class);

    @Override
    public void connect(MessageContext messageContext) throws ConnectException {
        String rootElementTag = ISOMessageParser.getRootXMLElement(messageContext);

        if (!ConnectorConstants.XML_INPUT_BUSINESS_ENV_TAG.equals(rootElementTag) &&
                (!ConnectorConstants.XML_INPUT_DOCUMENT_TAG.equals(rootElementTag))) {
            // Invalid XML root tag
            log.error(ConnectorConstants.ERROR_INVALID_XML_ROOT_TAG_MESSAGE);
            ConnectorUtils.appendErrorToMessageContext(messageContext,
                    ConnectorConstants.ERROR_INVALID_XML_ROOT_TAG,
                    ConnectorConstants.ERROR_INVALID_XML_ROOT_TAG_MESSAGE);

            super.handleException(ConnectorConstants.ERROR_INVALID_XML_ROOT_TAG_MESSAGE, messageContext);
        }

        boolean isBusinessMsg = ConnectorConstants.XML_INPUT_BUSINESS_ENV_TAG.equals(rootElementTag);

        // Processing ISO20022.camt.053 message
        try {
            String xPath = ISOMessageParser.constructXPath(isBusinessMsg, ConnectorConstants.XPATH_DOCUMENT);
            String documentStr = ISOMessageParser.extractISOMessage(messageContext, xPath);

            XSDValidator documentValidator = new XSDValidator(ConnectorConstants.XSD_SCHEMA_CAMT_053_001);
            documentValidator.validateXMLContent(documentStr);

            // Validate MT940 related ISO20022.camt.053 validations
            if (!ISO20022Camt053ValidatorUtils.isElectronicSequenceNumberExists(isBusinessMsg, messageContext)) {
                log.error(ConnectorConstants.ERROR_MISSING_ELECTRONIC_SEQUENCE_NUMBER);
                ConnectorUtils.appendErrorToMessageContext(messageContext,
                        ConnectorConstants.ERROR_INVALID_ISO_CAMT053_XML_MSG,
                        ConnectorConstants.ERROR_MISSING_ELECTRONIC_SEQUENCE_NUMBER);

                throw new ConnectException(ConnectorConstants.ERROR_MISSING_ELECTRONIC_SEQUENCE_NUMBER);
            } else if (!ISO20022Camt053ValidatorUtils.isLegalSequenceNumberExists(isBusinessMsg, messageContext)) {
                log.error(ConnectorConstants.ERROR_MISSING_LEGAL_SEQUENCE_NUMBER);
                ConnectorUtils.appendErrorToMessageContext(messageContext,
                        ConnectorConstants.ERROR_INVALID_ISO_CAMT053_XML_MSG,
                        ConnectorConstants.ERROR_MISSING_LEGAL_SEQUENCE_NUMBER);

                throw new ConnectException(ConnectorConstants.ERROR_MISSING_LEGAL_SEQUENCE_NUMBER);
            } else if (!ISO20022Camt053ValidatorUtils.isOpeningBalanceExists(isBusinessMsg, messageContext)) {
                log.error(ConnectorConstants.ERROR_MISSING_OPENING_BALANCE);
                ConnectorUtils.appendErrorToMessageContext(messageContext,
                        ConnectorConstants.ERROR_INVALID_ISO_CAMT053_XML_MSG,
                        ConnectorConstants.ERROR_MISSING_OPENING_BALANCE);

                throw new ConnectException(ConnectorConstants.ERROR_MISSING_OPENING_BALANCE);
            } else if (!ISO20022Camt053ValidatorUtils.isClosingBalanceExists(isBusinessMsg, messageContext)) {
                log.error(ConnectorConstants.ERROR_MISSING_CLOSING_BALANCE);
                ConnectorUtils.appendErrorToMessageContext(messageContext,
                        ConnectorConstants.ERROR_INVALID_ISO_CAMT053_XML_MSG,
                        ConnectorConstants.ERROR_MISSING_CLOSING_BALANCE);

                throw new ConnectException(ConnectorConstants.ERROR_MISSING_CLOSING_BALANCE);
            }

            log.debug("Valid camt.053.001.11 message");
        } catch (SAXParseException e) {
            String errMsg = String.format("%s, Line number: %d, Column number: %d",
                    e.getMessage(), e.getLineNumber(), e.getColumnNumber());

            log.error(e.getMessage(), e);
            ConnectorUtils.appendErrorToMessageContext(messageContext,
                    ConnectorConstants.ERROR_INVALID_ISO_CAMT053_XML_MSG,
                    errMsg);

            throw new ConnectException(e, errMsg);
        } catch (SAXException | JaxenException | IOException e) {
            log.error(e.getMessage(), e);
            ConnectorUtils.appendErrorToMessageContext(messageContext,
                    ConnectorConstants.ERROR_VALIDATING_XML, e.getMessage());

            throw new ConnectException(e, ConnectorConstants.ERROR_VALIDATING_CAMT_XML_MSG);
        }
    }
}
