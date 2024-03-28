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

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * Validate part of the ISO 20022 XML message from message context and validate against XSD format.
 */
public class XSDValidator {
    private final Validator xsdValidator;

    public XSDValidator(String xsdFilePath) throws SAXException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(xsdFilePath);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        StreamSource streamSource = new StreamSource(inputStream);
        Schema schema = schemaFactory.newSchema(streamSource);
        xsdValidator = schema.newValidator();
    }

    /**
     * Validate the XML content against defined XSD validator.
     * @param xmlContent XML content which needs validate against XSD
     * @throws SAXException
     * @throws IOException
     */
    public void validateXMLContent(String xmlContent) throws SAXException, IOException {
        Source content = new StreamSource(new StringReader(xmlContent));

        // Validate XSD against the content
        xsdValidator.validate(content);
    }
}
