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

package org.wso2.carbon.module.swiftiso20022.utils;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.xpath.AXIOMXPath;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.synapse.MessageContext;
import org.jaxen.JaxenException;
import org.wso2.carbon.connector.core.ConnectException;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;

import java.util.List;
import java.util.Optional;

/**
 * Extract part of the ISO 20022 XML message from message context.
 */
public class ISOMessageParser {

    /**
     * Retrieve specific OMElement from MessageContext according to the XPATH.
     * @param xPath         XPath expression to the OMElement
     * @param mc            MessageContext which contains the XML 20022 input
     * @return OMElement    Required XML element as OMElement
     * @throws JaxenException
     */
    public static OMElement getXMLElementByXPath(String xPath, MessageContext mc) throws JaxenException {
        AXIOMXPath xpathExp = new AXIOMXPath(xPath);

        // Setting up XML namespaces for AXIOM SOAP, AppHdr, and Document
        xpathExp.addNamespace(ConnectorConstants.SOAP_PREFIX, ConnectorConstants.SOAP_NAMESPACE);
        xpathExp.addNamespace(ConnectorConstants.APPHDR_PREFIX, ConnectorConstants.XML_INPUT_APPHDR_NAMESPACE);
        xpathExp.addNamespace(ConnectorConstants.DOCUMENT_PREFIX, ConnectorConstants.XML_INPUT_DOCUMENT_NAMESPACE);

        OMNode rootElement = mc.getEnvelope().getBody();
        return (OMElement) xpathExp.selectSingleNode(rootElement);
    }

    /**
     * Retrieve specific list of OMElement from MessageContext according to the XPATH.
     * @param xPath                 XPath expression to the OMElements
     * @param mc                    MessageContext which contains the XML 20022 input
     * @return "List<OMELement>"    List of OMElements
     * @throws JaxenException
     */
    public static List<OMElement> getXMLElementsByPath(String xPath, MessageContext mc) throws JaxenException {
        AXIOMXPath xpathExp = new AXIOMXPath(xPath);

        // Setting up XML namespaces for AXIOM SOAP, AppHdr, and Document
        xpathExp.addNamespace(ConnectorConstants.SOAP_PREFIX, ConnectorConstants.SOAP_NAMESPACE);
        xpathExp.addNamespace(ConnectorConstants.APPHDR_PREFIX, ConnectorConstants.XML_INPUT_APPHDR_NAMESPACE);
        xpathExp.addNamespace(ConnectorConstants.DOCUMENT_PREFIX, ConnectorConstants.XML_INPUT_DOCUMENT_NAMESPACE);

        OMNode rootElement = mc.getEnvelope().getBody();
        return xpathExp.selectNodes(rootElement);
    }

    /**
     * Read the XML input from MessageContext and return the content of child elements of the parent tag as a String.
     * @param mc         MessageContext which contains the XML 20022 input
     * @param xPath      Xpath for the XML contents which needs to be extracted
     * @return           Child contents as a String element
     */
    public static String extractISOMessage(MessageContext mc, String xPath) throws ConnectException,
            OMException, JaxenException  {
        OMElement element = getXMLElementByXPath(xPath, mc);

        if (element == null) {
            // No element to be extracted
            String errMsg = String.format("Error: %s element not present in the XML", xPath);

            throw new ConnectException(errMsg);
        }

        return element.toString();
    }

    /**
     * Read the ISO message from MessageContext and return the Root element tag name.
     * @param mc         MessageContext which contains the XML 20022 input
     * @return           Root XML tag name
     */
    public static String getRootXMLElement(MessageContext mc) {
        return Optional.ofNullable(mc.getEnvelope())
                .map(SOAPEnvelope::getBody)
                .map(OMElement::getFirstElement)
                .map(OMElement::getLocalName)
                .orElse(null);
    }

    /**
     * Construct XPath conditionally if businessHdr present or not.
     * @param isBusinessMsg Is the given XML message is a business message or not
     * @param xPath         XPath which need an update according to the business message is present or not
     * @return              Updated XPath
     */
    public static String constructXPath(boolean isBusinessMsg, String xPath) {
        if (isBusinessMsg) {
            return ConnectorConstants.XPATH_BUSINESS_MESSAGE_START + xPath;
        } else {
            return ConnectorConstants.XPATH_CAMT_MESSAGE_START + xPath;
        }
    }
}
