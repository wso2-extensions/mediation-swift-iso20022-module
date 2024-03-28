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
import org.apache.synapse.MessageContext;
import org.jaxen.JaxenException;
import org.wso2.carbon.connector.core.ConnectException;
import org.wso2.carbon.module.swiftiso20022.constants.ConnectorConstants;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utils methods for ISO20022.camt.053 validations.
 */
public class ISO20022Camt053ValidatorUtils {
    /**
     * Check whether ISO20022.camt.053 message contains electronic sequence number XML element.
     *
     * @param isBusinessMsg Boolean value to indicate ISO20022 message is business message or not
     * @param mc            MessageContext which contains the XML 20022 input
     * @return boolean
     * @throws JaxenException
     */
    public static boolean isElectronicSequenceNumberExists(boolean isBusinessMsg, MessageContext mc)
            throws JaxenException {
            String xPathToSeqNumber = ISOMessageParser.constructXPath(isBusinessMsg,
                    ConnectorConstants.XPATH_ELECTSEQ_NUMBER);

            return ISOMessageParser.getXMLElementByXPath(xPathToSeqNumber, mc) != null;
    }

    /**
     * Check whether ISO20022.camt.053 message contains legal sequence number XML element.
     *
     * @param isBusinessMsg Boolean value to indicate ISO20022 message is business message or not
     * @param mc            MessageContext which contains the XML 20022 input
     * @return boolean
     * @throws ConnectException
     */
    public static boolean isLegalSequenceNumberExists(boolean isBusinessMsg, MessageContext mc) throws JaxenException {
        String xPathToLogicNumber = ISOMessageParser.constructXPath(isBusinessMsg,
                ConnectorConstants.XPATH_LEGALSEQ_NUMBER);

        return ISOMessageParser.getXMLElementByXPath(xPathToLogicNumber, mc) != null;
    }

    /**
     * Check whether ISO20022.camt.053 message contains opening balance(OPBD).
     *
     * @param isBusinessMsg Boolean value to indicate ISO20022 message is business message or not
     * @param mc            MessageContext which contains the XML 20022 input
     * @return
     * @throws ConnectException
     */
    public static boolean isOpeningBalanceExists(boolean isBusinessMsg, MessageContext mc) throws JaxenException {
        String xPathToBalanceEle = ISOMessageParser.constructXPath(isBusinessMsg,
                ConnectorConstants.XPATH_BALANCE_ELEMENTS);

        List<OMElement> codeElements = ISOMessageParser.getXMLElementsByPath(xPathToBalanceEle, mc);
        List<String> codes = codeElements.stream().map(OMElement::getText).collect(Collectors.toList());


        return codes.stream().anyMatch(ConnectorConstants.OPENING_BALANCE_CODE::equals);
    }

    /**
     * Check whether ISO20022.camt.053 message contains closing balance(CLBD).
     *
     * @param isBusinessMsg Boolean value to indicate ISO20022 message is business message or not
     * @param mc            MessageContext which contains the XML 20022 input
     * @return
     * @throws ConnectException
     */
    public static boolean isClosingBalanceExists(boolean isBusinessMsg, MessageContext mc) throws JaxenException {
        String xPathToBalanceEle = ISOMessageParser.constructXPath(isBusinessMsg,
                ConnectorConstants.XPATH_BALANCE_ELEMENTS);

        List<OMElement> codeElements = ISOMessageParser.getXMLElementsByPath(xPathToBalanceEle, mc);
        List<String> codes = codeElements.stream().map(OMElement::getText).collect(Collectors.toList());

        return codes.stream().anyMatch(ConnectorConstants.CLOSING_BALANCE_CODE::equals);
    }
}
