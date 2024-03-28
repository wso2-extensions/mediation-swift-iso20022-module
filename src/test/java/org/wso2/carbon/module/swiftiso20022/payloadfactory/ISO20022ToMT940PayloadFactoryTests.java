package org.wso2.carbon.module.swiftiso20022.payloadfactory;

import freemarker.template.Template;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.module.swiftiso20022.utils.FreemarkerTemplateTestUtils;
import org.wso2.carbon.module.swiftiso20022.utils.ISO20022ToMT940PayloadFactoryTestConstants;

import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;


/**
 * Test class for validating payload factory freemarker template.
 */
@PowerMockIgnore("jdk.internal.reflect.*")
public class ISO20022ToMT940PayloadFactoryTests extends PowerMockTestCase {
    @Test
    public void testValidBusinessMessageScenario() throws Exception {
        // Get the ftl file as input stream
        InputStream freemarkerTempStream = getClass().getClassLoader()
                .getResourceAsStream("freemarkerTemplates/ISOToMT940.ftl");

        // Converting XML input to hashmap
        Map<String, Object> root = FreemarkerTemplateTestUtils.getXMLMapFromXMLContent(
                ISO20022ToMT940PayloadFactoryTestConstants.ISO20022_VALID_BUSINESS_MSG);

        Template template = FreemarkerTemplateTestUtils
                .getFreemarkerTemplate(freemarkerTempStream, "ISOToMT940");

        Writer stringwriter = new StringWriter();
        template.process(root, stringwriter);
        String freemarkerOutput = stringwriter.toString().replace("\r", "");

        Assert.assertEquals(freemarkerOutput,
                ISO20022ToMT940PayloadFactoryTestConstants.getValidMT940ForISOBusinessMsg());
    }

    @Test
    public void testValidCAMTMessageScenario() throws Exception {
        // Get the ftl file as input stream
        InputStream freemarkerTempStream = getClass().getClassLoader()
                .getResourceAsStream("freemarkerTemplates/ISOToMT940.ftl");

        // Converting XML input to hashmap
        Map<String, Object> root =  FreemarkerTemplateTestUtils.getXMLMapFromXMLContent(
                ISO20022ToMT940PayloadFactoryTestConstants.ISO20022_VALID_CAMT_MSG);

        Template template =  FreemarkerTemplateTestUtils
                .getFreemarkerTemplate(freemarkerTempStream, "ISOToMT940");

        Writer stringwriter = new StringWriter();
        template.process(root, stringwriter);
        String freemarkerOutput = stringwriter.toString().replace("\r", "");

        Assert.assertEquals(freemarkerOutput,
                ISO20022ToMT940PayloadFactoryTestConstants.MT940_MAPPING_FOR_VALID_CAMT);
    }

    @Test
    public void testVariedLengthBICCodeScenario() throws Exception {
        // Get the ftl file as input stream
        InputStream freemarkerTempStream = getClass().getClassLoader()
                .getResourceAsStream("freemarkerTemplates/ISOToMT940.ftl");

        // Converting XML input to hashmap
        Map<String, Object> root =  FreemarkerTemplateTestUtils.getXMLMapFromXMLContent(
                ISO20022ToMT940PayloadFactoryTestConstants.ISO_BUSINESS_MSG_WITH_MULTIPLE_BIC_CODE_LENGTH);

        Template template =  FreemarkerTemplateTestUtils
                .getFreemarkerTemplate(freemarkerTempStream, "ISOToMT940");

        Writer stringwriter = new StringWriter();
        template.process(root, stringwriter);
        String freemarkerOutput = stringwriter.toString().replace("\r", "");

        Assert.assertEquals(freemarkerOutput,
                ISO20022ToMT940PayloadFactoryTestConstants.getValidMT940ForVariedBICCodeLength());
    }

    @Test
    public void testWithMultipleDateFormatBalanceScenario() throws Exception {
        // Get the ftl file as input stream
        InputStream freemarkerTempStream = getClass().getClassLoader()
                .getResourceAsStream("freemarkerTemplates/ISOToMT940.ftl");

        // Converting XML input to hashmap
        Map<String, Object> root =  FreemarkerTemplateTestUtils.getXMLMapFromXMLContent(
                ISO20022ToMT940PayloadFactoryTestConstants.ISO_BUSINESS_MSG_WITH_MULTIPLE_DATETIME_FORMAT);

        Template template =  FreemarkerTemplateTestUtils
                .getFreemarkerTemplate(freemarkerTempStream, "ISOToMT940");

        Writer stringwriter = new StringWriter();
        template.process(root, stringwriter);
        String freemarkerOutput = stringwriter.toString().replace("\r", "");

        Assert.assertEquals(freemarkerOutput,
                ISO20022ToMT940PayloadFactoryTestConstants.getValidMT940ForISOBusinessMsgWithMultipleDateFormat());
    }

    @Test
    public void testWithEmptyNtryDetailsScenario() throws Exception {
        // Get the ftl file as input stream
        InputStream freemarkerTempStream = getClass().getClassLoader()
                .getResourceAsStream("freemarkerTemplates/ISOToMT940.ftl");

        // Converting XML input to hashmap
        Map<String, Object> root =  FreemarkerTemplateTestUtils.getXMLMapFromXMLContent(
                ISO20022ToMT940PayloadFactoryTestConstants.ISO_BUSINESS_MSG_WITH_EMPTY_ENTRY_DETAILS);

        Template template =  FreemarkerTemplateTestUtils
                .getFreemarkerTemplate(freemarkerTempStream, "ISOToMT940");

        Writer stringwriter = new StringWriter();
        template.process(root, stringwriter);
        String freemarkerOutput = stringwriter.toString().replace("\r", "");

        Assert.assertEquals(freemarkerOutput,
                ISO20022ToMT940PayloadFactoryTestConstants.getValidMT940ForISOBusinessMsgWithEmptyEntryDetails());
    }

    @Test
    public void testMultipleNtryDtlsWithMultipleTxDtsScenario() throws Exception {
        // Get the ftl file as input stream
        InputStream freemarkerTempStream = getClass().getClassLoader()
                .getResourceAsStream("freemarkerTemplates/ISOToMT940.ftl");

        // Converting XML input to hashmap
        Map<String, Object> root =  FreemarkerTemplateTestUtils.getXMLMapFromXMLContent(
                ISO20022ToMT940PayloadFactoryTestConstants.ISO_BUSINESS_MSG_WITH_MULTIPLE_ENTRY_DETAILS);

        Template template =  FreemarkerTemplateTestUtils
                .getFreemarkerTemplate(freemarkerTempStream, "ISOToMT940");

        Writer stringwriter = new StringWriter();
        template.process(root, stringwriter);
        String freemarkerOutput = stringwriter.toString().replace("\r", "");

        Assert.assertEquals(freemarkerOutput,
                ISO20022ToMT940PayloadFactoryTestConstants.getValidMT940ForISOBusinessMsgWithMultipleEntryDetails());
    }

    @Test
    public void testAdditionalEntryDetails() throws Exception {
        // Get the ftl file as input stream
        InputStream freemarkerTempStream = getClass().getClassLoader()
                .getResourceAsStream("freemarkerTemplates/ISOToMT940.ftl");

        // Converting XML input to hashmap
        Map<String, Object> root =  FreemarkerTemplateTestUtils.getXMLMapFromXMLContent(
                ISO20022ToMT940PayloadFactoryTestConstants.ISO_BUSINESS_MSG_WITH_ADDITIONAL_ENTRY_INFO);

        Template template =  FreemarkerTemplateTestUtils
                .getFreemarkerTemplate(freemarkerTempStream, "ISOToMT940");

        Writer stringwriter = new StringWriter();
        template.process(root, stringwriter);
        String freemarkerOutput = stringwriter.toString().replace("\r", "");

        Assert.assertEquals(freemarkerOutput,
                ISO20022ToMT940PayloadFactoryTestConstants.getValidMT940ForISOBusinessMsgWithAdditionalEntryInfo());
    }
}
