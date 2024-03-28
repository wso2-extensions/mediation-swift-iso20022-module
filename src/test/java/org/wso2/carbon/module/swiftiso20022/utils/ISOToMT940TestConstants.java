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

import org.testng.annotations.DataProvider;

import java.util.Map;

/**
 * Test constants for ISOtoMT940Test.
 */
public class ISOToMT940TestConstants {
    public static final String XML_INPUT_BUSINESS_ENV_TAG = "BizMsgEnvlp";
    public static final String XML_INPUT_APPHDR_TAG = "AppHdr";

    public static final String PAYLOAD_APPHDR = "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
            "\t<Fr>\n" +
            "\t\t<FIId>\n" +
            "\t\t\t<FinInstnId>\n" +
            "\t\t\t\t<BICFI>GSCRUS30</BICFI>\n" +
            "\t\t\t</FinInstnId>\n" +
            "\t\t</FIId>\n" +
            "\t</Fr>\n" +
            "\t<To>\n" +
            "\t\t<FIId>\n" +
            "\t\t\t<FinInstnId>\n" +
            "\t\t\t\t<BICFI>GSCRUS30</BICFI>\n" +
            "\t\t\t</FinInstnId>\n" +
            "\t\t</FIId>\n" +
            "\t</To>\n" +
            "\t<BizMsgIdr>LOCA000000159</BizMsgIdr>\n" +
            "\t<MsgDefIdr>seev.003.001.07</MsgDefIdr>\n" +
            "\t<CreDt>2019-04-25T10:30:00Z</CreDt>\n" +
            "</AppHdr>";
    public static final String PAYLOAD_EMPTY_APPHDR = "" +
            "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
            "</AppHdr>";

    public static final String PAYLOAD_CAMT = "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
            "    <BkToCstmrStmt>\n" +
            "        <GrpHdr>\n" +
            "            <MsgId>235549650</MsgId>\n" +
            "            <CreDtTm>2023-10-05T14:43:51.979</CreDtTm>\n" +
            "            <MsgRcpt>\n" +
            "                <Nm>Test Client Ltd.</Nm>\n" +
            "                <Id>\n" +
            "                    <OrgId>\n" +
            "                        <Othr>\n" +
            "                            <Id>test001</Id>\n" +
            "                        </Othr>\n" +
            "                    </OrgId>\n" +
            "                </Id>\n" +
            "            </MsgRcpt>\n" +
            "        </GrpHdr>\n" +
            "        <Stmt>\n" +
            "            <Id>258158850</Id>\n" +
            "            <ElctrncSeqNb>1</ElctrncSeqNb>\n" +
            "            <LglSeqNb>1</LglSeqNb>\n" +
            "            <CreDtTm>2023-10-05T14:43:52.098</CreDtTm>\n" +
            "            <FrToDt>\n" +
            "                <FrDtTm>2023-09-30T20:00:00.000</FrDtTm>\n" +
            "                <ToDtTm>2023-10-01T19:59:59.000</ToDtTm>\n" +
            "            </FrToDt>\n" +
            "            <Acct>\n" +
            "                <Id>\n" +
            "                    <Othr>\n" +
            "                        <Id>DD01100056869</Id>\n" +
            "                    </Othr>\n" +
            "                </Id>\n" +
            "                <Tp>\n" +
            "                    <Prtry>IBDA_DDA</Prtry>\n" +
            "                </Tp>\n" +
            "                <Ccy>USD</Ccy>\n" +
            "                <Nm>Sample Name 123</Nm>\n" +
            "                <Svcr>\n" +
            "                    <FinInstnId>\n" +
            "                        <BICFI>GSCRUS30</BICFI>\n" +
            "                        <Nm>Goldman Sachs Bank</Nm>\n" +
            "                    </FinInstnId>\n" +
            "                </Svcr>\n" +
            "            </Acct>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>OPBD</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">843686.20</Amt>\n" +
            "                <CdtDbtInd>DBIT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-09-30T20:00:00.000</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>CLBD</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">846665.15</Amt>\n" +
            "                <CdtDbtInd>DBIT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-09-30T20:00:00.000</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>OPAV</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">334432492.92</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-09-30T23:59:00.000Z</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>CLAV</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">334432401.27</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-10-01T23:59:00.000Z</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <TxsSummry>\n" +
            "                <TtlNtries>\n" +
            "                    <NbOfNtries>14</NbOfNtries>\n" +
            "                    <Sum>140.00</Sum>\n" +
            "                  \t<TtlNetNtry>\n" +
            "                      <Amt>40.00</Amt>\n" +
            "                      <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                  \t</TtlNetNtry>\n" +
            "                </TtlNtries>\n" +
            "                <TtlCdtNtries>\n" +
            "                    <NbOfNtries>9</NbOfNtries>\n" +
            "                    <Sum>90.00</Sum>\n" +
            "                </TtlCdtNtries>\n" +
            "                <TtlDbtNtries>\n" +
            "                    <NbOfNtries>5</NbOfNtries>\n" +
            "                    <Sum>50.00</Sum>\n" +
            "                </TtlDbtNtries>\n" +
            "            </TxsSummry>\n" +
            "            <Ntry>\n" +
            "                <NtryRef>52198201</NtryRef>\n" +
            "                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <RvslInd>true</RvslInd>\n" +
            "                <Sts>\n" +
            "                  <Cd>BOOK</Cd>\n" +
            "              \t</Sts>\n" +
            "                <BookgDt>\n" +
            "                    <DtTm>2023-10-01T13:37:14.000</DtTm>\n" +
            "                </BookgDt>\n" +
            "                <ValDt>\n" +
            "                    <Dt>2023-10-01</Dt>\n" +
            "                </ValDt>\n" +
            "                <BkTxCd>\n" +
            "                    <Prtry>\n" +
            "                        <Cd>ACH Credit Reject</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "                <NtryDtls>\n" +
            "                    <TxDtls>\n" +
            "                        <Refs>\n" +
            "                            <MsgId>GSNULXSKMMJ479NMKS</MsgId>\n" +
            "                            <AcctSvcrRef>B20092800002225</AcctSvcrRef>\n" +
            "                            <PmtInfId>RP/GS/CTFILERP0002/CTBA0003</PmtInfId>\n" +
            "                            <EndToEndId>GSGWGDNCTAHQM8</EndToEndId>\n" +
            "                        </Refs>\n" +
            "                        <AmtDtls>\n" +
            "                            <InstdAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                            </InstdAmt>\n" +
            "                            <TxAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                                <CcyXchg>\n" +
            "                                  \t<SrcCcy>USD</SrcCcy>\n" +
            "                                    <TrgtCcy>USD</TrgtCcy>\n" +
            "                                   \t<XchgRate>10.00</XchgRate>\n" +
            "                                </CcyXchg>\n" +
            "                            </TxAmt>\n" +
            "                        </AmtDtls>\n" +
            "                        <RmtInf>\n" +
            "                            <Ustrd>Sample Unstructured Remittance 123</Ustrd>\n" +
            "                        </RmtInf>\n" +
            "                        <RtrInf>\n" +
            "                            <AddtlInf>Status changed to REJECTED : REJECT REVERSAL</AddtlInf>\n" +
            "                        </RtrInf>\n" +
            "                    </TxDtls>\n" +
            "                </NtryDtls>\n" +
            "            </Ntry>\n" +
            "            <Ntry>\n" +
            "                <NtryRef>52198251</NtryRef>\n" +
            "                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                <CdtDbtInd>DBIT</CdtDbtInd>\n" +
            "                <RvslInd>false</RvslInd>\n" +
            "                <Sts>\n" +
            "                  <Cd>BOOK</Cd>\n" +
            "              \t</Sts>\n" +
            "                <BookgDt>\n" +
            "                    <DtTm>2023-10-01T13:37:11.000</DtTm>\n" +
            "                </BookgDt>\n" +
            "                <ValDt>\n" +
            "                    <Dt>2023-10-01</Dt>\n" +
            "                </ValDt>\n" +
            "                <BkTxCd>\n" +
            "                    <Prtry>\n" +
            "                        <Cd>ACH Credit Payment</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "                <NtryDtls>\n" +
            "                    <TxDtls>\n" +
            "                        <Refs>\n" +
            "                            <MsgId>GSNULXSKMMJ479NMKS</MsgId>\n" +
            "                            <AcctSvcrRef>SPB20092845886394</AcctSvcrRef>\n" +
            "                            <PmtInfId>RP/GS/CTFILERP0002/CTBA0003</PmtInfId>\n" +
            "                        </Refs>\n" +
            "                        <AmtDtls>\n" +
            "                            <InstdAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                            </InstdAmt>\n" +
            "                            <TxAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                                <CcyXchg>\n" +
            "                                  \t<SrcCcy>USD</SrcCcy>\n" +
            "                                    <TrgtCcy>USD</TrgtCcy>\n" +
            "                                   \t<XchgRate>10.00</XchgRate>\n" +
            "                                </CcyXchg>\n" +
            "                            </TxAmt>\n" +
            "                        </AmtDtls>\n" +
            "                        <RltdPties>\n" +
            "                            <Cdtr>\n" +
            "                              \t<Pty>\n" +
            "                                \t<Nm>GS Bank USA</Nm>\n" +
            "                              \t</Pty>\n" +
            "                            </Cdtr>\n" +
            "                            <CdtrAcct>\n" +
            "                                <Id>\n" +
            "                                    <Othr>\n" +
            "                                        <Id>ACHCONTROLOUTUSD01</Id>\n" +
            "                                    </Othr>\n" +
            "                                </Id>\n" +
            "                            </CdtrAcct>\n" +
            "                        </RltdPties>\n" +
            "                    </TxDtls>\n" +
            "                </NtryDtls>\n" +
            "            </Ntry>\n" +
            "            <Ntry>\n" +
            "                <NtryRef>52198301</NtryRef>\n" +
            "                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <RvslInd>false</RvslInd>\n" +
            "                <Sts>\n" +
            "                  <Cd>BOOK</Cd>\n" +
            "              \t</Sts>\n" +
            "                <BookgDt>\n" +
            "                    <DtTm>2023-10-01T13:36:04.000</DtTm>\n" +
            "                </BookgDt>\n" +
            "                <ValDt>\n" +
            "                    <Dt>2023-10-01</Dt>\n" +
            "                </ValDt>\n" +
            "                <BkTxCd>\n" +
            "                    <Prtry>\n" +
            "                        <Cd>Incoming Wire</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "                <NtryDtls>\n" +
            "                    <TxDtls>\n" +
            "                        <Refs>\n" +
            "                            <MsgId>20230928LTERMID100000312221631FT01</MsgId>\n" +
            "                            <AcctSvcrRef>I20092800008308</AcctSvcrRef>\n" +
            "                            <PmtInfId>RP/GS/CTFILERP0002/CTBA0003</PmtInfId>\n" +
            "                            <EndToEndId>20230928LTERMID2000003</EndToEndId>\n" +
            "                            <ClrSysRef>20230928LTERMID2000003</ClrSysRef>\n" +
            "                        </Refs>\n" +
            "                        <AmtDtls>\n" +
            "                            <InstdAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                            </InstdAmt>\n" +
            "                            <TxAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                                <CcyXchg>\n" +
            "                                  \t<SrcCcy>USD</SrcCcy>\n" +
            "                                    <TrgtCcy>USD</TrgtCcy>\n" +
            "                                   \t<XchgRate>10.00</XchgRate>\n" +
            "                                </CcyXchg>\n" +
            "                            </TxAmt>\n" +
            "                        </AmtDtls>\n" +
            "                    </TxDtls>\n" +
            "                </NtryDtls>\n" +
            "            </Ntry>\n" +
            "        </Stmt>\n" +
            "    </BkToCstmrStmt>\n" +
            "</Document>";
    public static final String PAYLOAD_EMPTY_CAMT = "" +
            "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
            "</Document>";

    public static final String PAYLOAD_EMPTY_CAMT_WITH_APPHDR = "<BizMsgEnvlp>" +
            PAYLOAD_APPHDR + PAYLOAD_EMPTY_CAMT + "</BizMsgEnvlp>";

    public static final String PAYLOAD_INVALID_ROOT_ELEMENT =
            "<ISOMessage xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
            "    <BkToCstmrStmt>\n" +
            "        <GrpHdr>\n" +
            "            <MsgId>235549650</MsgId>\n" +
            "            <CreDtTm>2023-10-05T14:43:51.979</CreDtTm>\n" +
            "            <MsgRcpt>\n" +
            "                <Nm>Test Client Ltd.</Nm>\n" +
            "                <Id>\n" +
            "                    <OrgId>\n" +
            "                        <Othr>\n" +
            "                            <Id>test001</Id>\n" +
            "                        </Othr>\n" +
            "                    </OrgId>\n" +
            "                </Id>\n" +
            "            </MsgRcpt>\n" +
            "        </GrpHdr>\n" +
            "        <Stmt>\n" +
            "            <Id>258158850</Id>\n" +
            "            <ElctrncSeqNb>1</ElctrncSeqNb>\n" +
            "            <LglSeqNb>1</LglSeqNb>\n" +
            "            <CreDtTm>2023-10-05T14:43:52.098</CreDtTm>\n" +
            "            <FrToDt>\n" +
            "                <FrDtTm>2023-09-30T20:00:00.000</FrDtTm>\n" +
            "                <ToDtTm>2023-10-01T19:59:59.000</ToDtTm>\n" +
            "            </FrToDt>\n" +
            "            <Acct>\n" +
            "                <Id>\n" +
            "                    <Othr>\n" +
            "                        <Id>DD01100056869</Id>\n" +
            "                    </Othr>\n" +
            "                </Id>\n" +
            "                <Tp>\n" +
            "                    <Prtry>IBDA_DDA</Prtry>\n" +
            "                </Tp>\n" +
            "                <Ccy>USD</Ccy>\n" +
            "                <Nm>Sample Name 123</Nm>\n" +
            "                <Svcr>\n" +
            "                    <FinInstnId>\n" +
            "                        <BICFI>GSCRUS30</BICFI>\n" +
            "                        <Nm>Goldman Sachs Bank</Nm>\n" +
            "                    </FinInstnId>\n" +
            "                </Svcr>\n" +
            "            </Acct>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>OPBD</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">843686.20</Amt>\n" +
            "                <CdtDbtInd>DBIT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-09-30T20:00:00.000</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>CLBD</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">846665.15</Amt>\n" +
            "                <CdtDbtInd>DBIT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-09-30T20:00:00.000</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>OPAV</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">334432492.92</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-09-30T23:59:00.000Z</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <Bal>\n" +
            "                <Tp>\n" +
            "                    <CdOrPrtry>\n" +
            "                        <Cd>CLAV</Cd>\n" +
            "                    </CdOrPrtry>\n" +
            "                </Tp>\n" +
            "                <Amt Ccy=\"USD\">334432401.27</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <Dt>\n" +
            "                    <DtTm>2023-10-01T23:59:00.000Z</DtTm>\n" +
            "                </Dt>\n" +
            "            </Bal>\n" +
            "            <TxsSummry>\n" +
            "                <TtlNtries>\n" +
            "                    <NbOfNtries>14</NbOfNtries>\n" +
            "                    <Sum>140.00</Sum>\n" +
            "                  \t<TtlNetNtry>\n" +
            "                      <Amt>40.00</Amt>\n" +
            "                      <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                  \t</TtlNetNtry>\n" +
            "                </TtlNtries>\n" +
            "                <TtlCdtNtries>\n" +
            "                    <NbOfNtries>9</NbOfNtries>\n" +
            "                    <Sum>90.00</Sum>\n" +
            "                </TtlCdtNtries>\n" +
            "                <TtlDbtNtries>\n" +
            "                    <NbOfNtries>5</NbOfNtries>\n" +
            "                    <Sum>50.00</Sum>\n" +
            "                </TtlDbtNtries>\n" +
            "            </TxsSummry>\n" +
            "            <Ntry>\n" +
            "                <NtryRef>52198201</NtryRef>\n" +
            "                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <RvslInd>true</RvslInd>\n" +
            "                <Sts>\n" +
            "                  <Cd>BOOK</Cd>\n" +
            "              \t</Sts>\n" +
            "                <BookgDt>\n" +
            "                    <DtTm>2023-10-01T13:37:14.000</DtTm>\n" +
            "                </BookgDt>\n" +
            "                <ValDt>\n" +
            "                    <Dt>2023-10-01</Dt>\n" +
            "                </ValDt>\n" +
            "                <BkTxCd>\n" +
            "                    <Prtry>\n" +
            "                        <Cd>ACH Credit Reject</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "                <NtryDtls>\n" +
            "                    <TxDtls>\n" +
            "                        <Refs>\n" +
            "                            <MsgId>GSNULXSKMMJ479NMKS</MsgId>\n" +
            "                            <AcctSvcrRef>B20092800002225</AcctSvcrRef>\n" +
            "                            <PmtInfId>RP/GS/CTFILERP0002/CTBA0003</PmtInfId>\n" +
            "                            <EndToEndId>GSGWGDNCTAHQM8</EndToEndId>\n" +
            "                        </Refs>\n" +
            "                        <AmtDtls>\n" +
            "                            <InstdAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                            </InstdAmt>\n" +
            "                            <TxAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                                <CcyXchg>\n" +
            "                                  \t<SrcCcy>USD</SrcCcy>\n" +
            "                                    <TrgtCcy>USD</TrgtCcy>\n" +
            "                                   \t<XchgRate>10.00</XchgRate>\n" +
            "                                </CcyXchg>\n" +
            "                            </TxAmt>\n" +
            "                        </AmtDtls>\n" +
            "                        <RmtInf>\n" +
            "                            <Ustrd>Sample Unstructured Remittance 123</Ustrd>\n" +
            "                        </RmtInf>\n" +
            "                        <RtrInf>\n" +
            "                            <AddtlInf>Status changed to REJECTED : REJECT REVERSAL</AddtlInf>\n" +
            "                        </RtrInf>\n" +
            "                    </TxDtls>\n" +
            "                </NtryDtls>\n" +
            "            </Ntry>\n" +
            "            <Ntry>\n" +
            "                <NtryRef>52198251</NtryRef>\n" +
            "                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                <CdtDbtInd>DBIT</CdtDbtInd>\n" +
            "                <RvslInd>false</RvslInd>\n" +
            "                <Sts>\n" +
            "                  <Cd>BOOK</Cd>\n" +
            "              \t</Sts>\n" +
            "                <BookgDt>\n" +
            "                    <DtTm>2023-10-01T13:37:11.000</DtTm>\n" +
            "                </BookgDt>\n" +
            "                <ValDt>\n" +
            "                    <Dt>2023-10-01</Dt>\n" +
            "                </ValDt>\n" +
            "                <BkTxCd>\n" +
            "                    <Prtry>\n" +
            "                        <Cd>ACH Credit Payment</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "                <NtryDtls>\n" +
            "                    <TxDtls>\n" +
            "                        <Refs>\n" +
            "                            <MsgId>GSNULXSKMMJ479NMKS</MsgId>\n" +
            "                            <AcctSvcrRef>SPB20092845886394</AcctSvcrRef>\n" +
            "                            <PmtInfId>RP/GS/CTFILERP0002/CTBA0003</PmtInfId>\n" +
            "                        </Refs>\n" +
            "                        <AmtDtls>\n" +
            "                            <InstdAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                            </InstdAmt>\n" +
            "                            <TxAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                                <CcyXchg>\n" +
            "                                  \t<SrcCcy>USD</SrcCcy>\n" +
            "                                    <TrgtCcy>USD</TrgtCcy>\n" +
            "                                   \t<XchgRate>10.00</XchgRate>\n" +
            "                                </CcyXchg>\n" +
            "                            </TxAmt>\n" +
            "                        </AmtDtls>\n" +
            "                        <RltdPties>\n" +
            "                            <Cdtr>\n" +
            "                              \t<Pty>\n" +
            "                                \t<Nm>GS Bank USA</Nm>\n" +
            "                              \t</Pty>\n" +
            "                            </Cdtr>\n" +
            "                            <CdtrAcct>\n" +
            "                                <Id>\n" +
            "                                    <Othr>\n" +
            "                                        <Id>ACHCONTROLOUTUSD01</Id>\n" +
            "                                    </Othr>\n" +
            "                                </Id>\n" +
            "                            </CdtrAcct>\n" +
            "                        </RltdPties>\n" +
            "                    </TxDtls>\n" +
            "                </NtryDtls>\n" +
            "            </Ntry>\n" +
            "            <Ntry>\n" +
            "                <NtryRef>52198301</NtryRef>\n" +
            "                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                <CdtDbtInd>CRDT</CdtDbtInd>\n" +
            "                <RvslInd>false</RvslInd>\n" +
            "                <Sts>\n" +
            "                  <Cd>BOOK</Cd>\n" +
            "              \t</Sts>\n" +
            "                <BookgDt>\n" +
            "                    <DtTm>2023-10-01T13:36:04.000</DtTm>\n" +
            "                </BookgDt>\n" +
            "                <ValDt>\n" +
            "                    <Dt>2023-10-01</Dt>\n" +
            "                </ValDt>\n" +
            "                <BkTxCd>\n" +
            "                    <Prtry>\n" +
            "                        <Cd>Incoming Wire</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "                <NtryDtls>\n" +
            "                    <TxDtls>\n" +
            "                        <Refs>\n" +
            "                            <MsgId>20230928LTERMID100000312221631FT01</MsgId>\n" +
            "                            <AcctSvcrRef>I20092800008308</AcctSvcrRef>\n" +
            "                            <PmtInfId>RP/GS/CTFILERP0002/CTBA0003</PmtInfId>\n" +
            "                            <EndToEndId>20230928LTERMID2000003</EndToEndId>\n" +
            "                            <ClrSysRef>20230928LTERMID2000003</ClrSysRef>\n" +
            "                        </Refs>\n" +
            "                        <AmtDtls>\n" +
            "                            <InstdAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                            </InstdAmt>\n" +
            "                            <TxAmt>\n" +
            "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
            "                                <CcyXchg>\n" +
            "                                  \t<SrcCcy>USD</SrcCcy>\n" +
            "                                    <TrgtCcy>USD</TrgtCcy>\n" +
            "                                   \t<XchgRate>10.00</XchgRate>\n" +
            "                                </CcyXchg>\n" +
            "                            </TxAmt>\n" +
            "                        </AmtDtls>\n" +
            "                    </TxDtls>\n" +
            "                </NtryDtls>\n" +
            "            </Ntry>\n" +
            "        </Stmt>\n" +
            "    </BkToCstmrStmt>\n" +
            "</ISOMessage>";

    public static final String PAYLOAD_APPHDR_AND_DOCUMENT = "<BizMsgEnvlp>" +
            PAYLOAD_APPHDR + PAYLOAD_CAMT +
            "</BizMsgEnvlp>";

    public static String getAppHdrPayload(Map<String, String> params) {
        return "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
                "\t<Fr>\n" +
                "\t\t<FIId>\n" +
                "\t\t\t<FinInstnId>\n" +
                "\t\t\t\t<BICFI>" + (params.getOrDefault("FrBIC", "GSCRUS30")) + "</BICFI>\n" +
                "\t\t\t</FinInstnId>\n" +
                "\t\t</FIId>\n" +
                "\t</Fr>\n" +
                "\t<To>\n" +
                "\t\t<FIId>\n" +
                "\t\t\t<FinInstnId>\n" +
                "\t\t\t\t<BICFI>" + (params.getOrDefault("ToBIC", "GSCRUS30")) + "</BICFI>\n" +
                "\t\t\t</FinInstnId>\n" +
                "\t\t</FIId>\n" +
                "\t</To>\n" +
                "\t<BizMsgIdr>" + (params.getOrDefault("BizId", "LOCA000000159")) + "</BizMsgIdr>\n" +
                "\t<MsgDefIdr>" + (params.getOrDefault("MsgId", "seev.003.001.07")) + "</MsgDefIdr>\n" +
                "\t<CreDt>" + (params.getOrDefault("CreDt", "2019-04-25T10:30:00Z")) + "</CreDt>\n" +
                "</AppHdr>\n";

    }

    @DataProvider(name = "invalidReceiverBIC")
    Object[][] getInvalidReceiverBIC() {

        return new Object[][]{
                {getAppHdrPayload(Map.of("FrBIC", ""))},
                {getAppHdrPayload(Map.of("FrBIC", "BCEYL"))},
                {getAppHdrPayload(Map.of("FrBIC", "BCEYLKLX002WWW"))}
        };
    }

    @DataProvider(name = "invalidSenderBIC")
    Object[][] getInvalidSenderBIC() {

        return new Object[][]{
                {getAppHdrPayload(Map.of("ToBIC", ""))},
                {getAppHdrPayload(Map.of("ToBIC", "BCEYL"))},
                {getAppHdrPayload(Map.of("ToBIC", "BCEYLKLX002WWW"))}
        };
    }

    @DataProvider(name = "invalidCreationDate")
    Object[][] getInvalidCreationDate() {

        return new Object[][]{
                {getAppHdrPayload(Map.of("CreDt", ""))},
                {getAppHdrPayload(Map.of("CreDt", "2019-04-25"))},
                {getAppHdrPayload(Map.of("CreDt", "2019-04-2510:30:00Z"))},
                {getAppHdrPayload(Map.of("CreDt", "10:30:00Z"))},
                {getAppHdrPayload(Map.of("CreDt", "10:30:00"))},
        };
    }

    @DataProvider(name = "invalidBusinessMsgId")
    Object[][] getInvalidBusinessMsgId() {

        return new Object[][]{
                {getAppHdrPayload(Map.of("BizId", ""))},
                {getAppHdrPayload(Map.of("BizId", "LOCA0000001593400007810000238500001212"))},
        };
    }

    @DataProvider(name = "invalidMessageDefId")
    Object[][] getInvalidMessageDefinitionId() {

        return new Object[][]{
                {getAppHdrPayload(Map.of("MsgId", ""))},
                {getAppHdrPayload(Map.of("MsgId", "seev.00378001.0012300012.0734500001026"))},
        };
    }

    public static String getBusinessHdrPayload(Map<String, String> params) {
        return "<BizMsgEnvlp>" + getAppHdrPayload(params) + PAYLOAD_CAMT + "</BizMsgEnvlp>";
    }

    @DataProvider(name = "invalidReceiverBICBusinessHdr")
    Object[][] getInvalidReceiverBICBusinessHdr() {

        return new Object[][]{
                {getBusinessHdrPayload(Map.of("FrBIC", ""))},
                {getBusinessHdrPayload(Map.of("FrBIC", "BCEYL"))},
                {getBusinessHdrPayload(Map.of("FrBIC", "BCEYLKLX002WWW"))}
        };
    }

    @DataProvider(name = "invalidSenderBICBusinessHdr")
    Object[][] getInvalidSenderBICBusinessHdr() {

        return new Object[][]{
                {getBusinessHdrPayload(Map.of("ToBIC", ""))},
                {getBusinessHdrPayload(Map.of("ToBIC", "BCEYL"))},
                {getBusinessHdrPayload(Map.of("ToBIC", "BCEYLKLX002WWW"))}
        };
    }

    @DataProvider(name = "invalidCreationDateBusinessHdr")
    Object[][] getInvalidCreationDateBusinessHdr() {

        return new Object[][]{
                {getBusinessHdrPayload(Map.of("CreDt", ""))},
                {getBusinessHdrPayload(Map.of("CreDt", "2019-04-25"))},
                {getBusinessHdrPayload(Map.of("CreDt", "2019-04-2510:30:00Z"))},
                {getBusinessHdrPayload(Map.of("CreDt", "10:30:00Z"))},
                {getBusinessHdrPayload(Map.of("CreDt", "10:30:00"))},
        };
    }

    @DataProvider(name = "invalidBusinessMsgIdBusinessHdr")
    Object[][] getInvalidBusinessMsgIdBusinessHdr() {

        return new Object[][]{
                {getBusinessHdrPayload(Map.of("BizId", ""))},
                {getBusinessHdrPayload(Map.of("BizId", "LOCA0000001593400007810000238500001212"))},
        };
    }

    @DataProvider(name = "invalidMessageDefIdBusinessHdr")
    Object[][] getInvalidMessageDefinitionIdBusinessHdr() {

        return new Object[][]{
                {getBusinessHdrPayload(Map.of("MsgId", ""))},
                {getBusinessHdrPayload(Map.of("MsgId", "seev.00378001.0012300012.0734500001026"))},
        };
    }

    public static String getDocumentPayload(Map<String, String> params) {
        return "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
                "    <BkToCstmrStmt>\n" +
                "        <GrpHdr>\n" +
                "            <MsgId>" + (params.getOrDefault("MsgId", "235549650")) + "</MsgId>\n" +
                "            <CreDtTm>" + (params.getOrDefault("HdrCreDtTm",
                                                "2023-10-05T14:43:51.979")) +
                "</CreDtTm>\n" +
                "            <MsgRcpt>\n" +
                "                <Nm>Test Client Ltd.</Nm>\n" +
                "                <Id>\n" +
                "                    <OrgId>\n" +
                "                        <Othr>\n" +
                "                            <Id>test001</Id>\n" +
                "                        </Othr>\n" +
                "                    </OrgId>\n" +
                "                </Id>\n" +
                "            </MsgRcpt>\n" +
                "        </GrpHdr>\n" +
                "        <Stmt>\n" +
                "            <Id>" + (params.getOrDefault("StmtId", "258158850")) + "</Id>\n" +
                              (params.getOrDefault("ElecSeqNum", "<ElctrncSeqNb>1</ElctrncSeqNb>\n")) +
                              (params.getOrDefault("LogSeqNum", "<LglSeqNb>1</LglSeqNb>\n")) +
                "            <CreDtTm>" + (params.getOrDefault("CreDtTm", "2023-10-05T14:43:52.098")) + "</CreDtTm>\n" +
                "            <FrToDt>\n" +
                "                <FrDtTm>2023-09-30T20:00:00.000</FrDtTm>\n" +
                "                <ToDtTm>2023-10-01T19:59:59.000</ToDtTm>\n" +
                "            </FrToDt>\n" +
                "            <Acct>\n" +
                "                <Id>\n" +
                "                    <Othr>\n" +
                "                        <Id>" + (params.getOrDefault("AcctId", "DD01100056869")) + "</Id>\n" +
                "                    </Othr>\n" +
                "                </Id>\n" +
                "                <Tp>\n" +
                "                    <Prtry>IBDA_DDA</Prtry>\n" +
                "                </Tp>\n" +
                "                <Ccy>USD</Ccy>\n" +
                "                <Nm>Sample Name 123</Nm>\n" +
                "                <Svcr>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>" + (params.getOrDefault("SvcrBIC", "GSCRUS30")) +
                "</BICFI>\n" +
                "                        <Nm>Goldman Sachs Bank</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </Svcr>\n" +
                "            </Acct>\n" +
                (params.getOrDefault("OpeningBal",
                "            <Bal>\n" +
                "                <Tp>\n" +
                "                    <CdOrPrtry>\n" +
                "                        <Cd>" + (params.getOrDefault("OpeningBalCd", "OPBD")) +
                "</Cd>\n" +
                "                    </CdOrPrtry>\n" +
                "                </Tp>\n" +
                "                <Amt Ccy=\"" + (params.getOrDefault("OpeningBalCCY", "USD")) + "\">" +
                (params.getOrDefault("OpeningBalAmt", "843686.20")) + "</Amt>\n" +
                "                <CdtDbtInd>" + (params.getOrDefault("OpeningBalInd", "DBIT")) +
                "</CdtDbtInd>\n" +
                "                <Dt>\n" +
                "                    <DtTm>" + (params.getOrDefault("OpeningBalDt",
                                        "2023-09-30T20:00:00.000")) + "</DtTm>\n" +
                "                </Dt>\n" +
                "            </Bal>\n")) +
                        (params.getOrDefault("ClosingBal",
                "            <Bal>\n" +
                "                <Tp>\n" +
                "                    <CdOrPrtry>\n" +
                "                        <Cd>" + (params.getOrDefault("ClosingBalCd", "CLBD")) +
                "</Cd>\n" +
                "                    </CdOrPrtry>\n" +
                "                </Tp>\n" +
                "                <Amt Ccy=\"" + (params.getOrDefault("ClosingBalCCY", "USD")) + "\">" +
                (params.getOrDefault("ClosingBalAmt", "846665.15")) + "</Amt>\n" +
                "                <CdtDbtInd>" + (params.getOrDefault("ClosingBalInd", "DBIT")) +
                "</CdtDbtInd>\n" +
                "                <Dt>\n" +
                "                    <DtTm>" + (params.getOrDefault("ClosingBalDt",
                "2023-09-30T20:00:00.000")) + "</DtTm>\n" +
                "                </Dt>\n" +
                "            </Bal>\n")) +
                "            <Bal>\n" +
                "                <Tp>\n" +
                "                    <CdOrPrtry>\n" +
                "                        <Cd>" + (params.getOrDefault("ForwardAvlBalCd", "FWAV")) +
                "</Cd>\n" +
                "                    </CdOrPrtry>\n" +
                "                </Tp>\n" +
                "                <Amt Ccy=\"" + (params.getOrDefault("ForwardAvlBalCCY", "USD")) + "\">"
                + (params.getOrDefault("ForwardAvlBalAmt", "334432492.92")) + "</Amt>\n" +
                "                <CdtDbtInd>" + (params.getOrDefault("ForwardAvlBalInd", "CRDT")) +
                "</CdtDbtInd>\n" +
                "                <Dt>\n" +
                "                    <DtTm>" + (params.getOrDefault("ForwardAvlBalDt",
                "2023-09-30T23:59:00.000Z")) + "</DtTm>\n" +
                "                </Dt>\n" +
                "            </Bal>\n" +
                "            <Bal>\n" +
                "                <Tp>\n" +
                "                    <CdOrPrtry>\n" +
                "                        <Cd>" + (params.getOrDefault("ClosingAvlBalCd", "CLAV")) +
                "</Cd>\n" +
                "                    </CdOrPrtry>\n" +
                "                </Tp>\n" +
                "                <Amt Ccy=\"" + (params.getOrDefault("ClosingAvlBalCCY", "USD")) + "\">"
                + (params.getOrDefault("ClosingAvlBalAmt", "334432401.27")) + "</Amt>\n" +
                "                <CdtDbtInd>" + (params.getOrDefault("ClosingAvlBalInd", "CRDT")) +
                "</CdtDbtInd>\n" +
                "                <Dt>\n" +
                "                    <DtTm>" + (params.getOrDefault("ClosingAvlBalDt", "" +
                                "2023-10-01T23:59:00.000Z")) + "</DtTm>\n" +
                "                </Dt>\n" +
                "            </Bal>\n" +
                "            <TxsSummry>\n" +
                "                <TtlNtries>\n" +
                "                    <NbOfNtries>14</NbOfNtries>\n" +
                "                    <Sum>140.00</Sum>\n" +
                "                  \t<TtlNetNtry>\n" +
                "                      <Amt>40.00</Amt>\n" +
                "                      <CdtDbtInd>CRDT</CdtDbtInd>\n" +
                "                  \t</TtlNetNtry>\n" +
                "                </TtlNtries>\n" +
                "                <TtlCdtNtries>\n" +
                "                    <NbOfNtries>9</NbOfNtries>\n" +
                "                    <Sum>90.00</Sum>\n" +
                "                </TtlCdtNtries>\n" +
                "                <TtlDbtNtries>\n" +
                "                    <NbOfNtries>5</NbOfNtries>\n" +
                "                    <Sum>50.00</Sum>\n" +
                "                </TtlDbtNtries>\n" +
                "            </TxsSummry>\n" +
                "            <Ntry>\n" +
                "                <NtryRef>52198201</NtryRef>\n" +
                "                <Amt Ccy=\"" + (params.getOrDefault("TransCCY", "USD")) + "\">" +
                (params.getOrDefault("TransAmt", "10.00")) + "</Amt>\n" +
                "                <CdtDbtInd>" + (params.getOrDefault("TransInd", "CRDT")) +
                "</CdtDbtInd>\n" +
                "                <RvslInd>" + (params.getOrDefault("TransRvslInd", "true")) +
                "</RvslInd>\n" +
                "                <Sts>\n" +
                "                  <Cd>BOOK</Cd>\n" +
                "              \t</Sts>\n" +
                "                <BookgDt>\n" +
                "                    <DtTm>" + (params.getOrDefault("TransBkDt",
                                                "2023-10-01T13:37:14.000")) + "</DtTm>\n" +
                "                </BookgDt>\n" +
                "                <ValDt>\n" +
                "                    <Dt>" + (params.getOrDefault("TransDt", "2023-10-01")) +
                "</Dt>\n" +
                "                </ValDt>\n" +
                "                <BkTxCd>\n" +
                "                    <Prtry>\n" +
                "                        <Cd>ACH Credit Reject</Cd>\n" +
                "                    </Prtry>\n" +
                "                </BkTxCd>\n" +
                "                <NtryDtls>\n" +
                "                    <TxDtls>\n" +
                "                        <Refs>\n" +
                "                            <MsgId>" + (params.getOrDefault("TxMsgId",
                                                "GSNULXSKMMJ479NMKS")) + "</MsgId>\n" +
                "                            <AcctSvcrRef>" + (params.getOrDefault("TxAcctSvcrRef",
                                                "B20092800002225")) + "</AcctSvcrRef>\n" +
                "                            <PmtInfId>" + (params.getOrDefault("TxPmtInfId",
                                                "RP/GS/CTFILERP0002/CTBA0003")) + "</PmtInfId>\n" +
                "                            <EndToEndId>" + (params.getOrDefault("TxEndToEndId",
                                                            "GSGWGDNCTAHQM8")) + "</EndToEndId>\n" +
                "                        </Refs>\n" +
                "                        <AmtDtls>\n" +
                "                            <InstdAmt>\n" +
                "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
                "                            </InstdAmt>\n" +
                "                            <TxAmt>\n" +
                "                                <Amt Ccy=\"USD\">10.00</Amt>\n" +
                "                                <CcyXchg>\n" +
                "                                  \t<SrcCcy>USD</SrcCcy>\n" +
                "                                    <TrgtCcy>USD</TrgtCcy>\n" +
                "                                   \t<XchgRate>10.00</XchgRate>\n" +
                "                                </CcyXchg>\n" +
                "                            </TxAmt>\n" +
                "                        </AmtDtls>\n" +
                "                        <RmtInf>\n" +
                "                            <Ustrd>Sample Unstructured Remittance 123</Ustrd>\n" +
                "                        </RmtInf>\n" +
                "                        <RtrInf>\n" +
                "                            <AddtlInf>Status changed to REJECTED : REJECT REVERSAL</AddtlInf>\n" +
                "                        </RtrInf>\n" +
                "                    </TxDtls>\n" +
                "                </NtryDtls>\n" +
                "            </Ntry>\n" +
                "        </Stmt>\n" +
                "    </BkToCstmrStmt>\n" +
                "</Document>";
    }

    @DataProvider(name = "invalidStmtId")
    Object[][] getInvalidStmtId() {

        return new Object[][]{
            {getDocumentPayload(Map.of("StmtId", ""))},
            {getDocumentPayload(Map.of("StmtId", "258158850258158850258158850258158850258158850"))}
        };
    }

    @DataProvider(name = "invalidElectSeqNumber")
    Object[][] getInvalidElectSeqNumber() {

        return new Object[][]{
            {getDocumentPayload(Map.of("ElecSeqNum", ""))},
            {getDocumentPayload(Map.of("ElecSeqNum", "<ElctrncSeqNb></ElctrncSeqNb>"))},
            {getDocumentPayload(Map.of("ElecSeqNum", "<ElctrncSeqNb>AWESLLIOM12</ElctrncSeqNb>"))}
        };
    }

    @DataProvider(name = "invalidLogSeqNumber")
    Object[][] getInvalidLogicSeqNumber() {

        return new Object[][]{
            {getDocumentPayload(Map.of("LogSeqNum", ""))},
            {getDocumentPayload(Map.of("LogSeqNum", "<LogSeqNum></LogSeqNum>"))},
            {getDocumentPayload(Map.of("LogSeqNum", "<LogSeqNum>EXXLOYIEM34</LogSeqNum>"))}
        };
    }

    @DataProvider(name = "invalidCreatedDateTime")
    Object[][] getInvalidCrdDtTm() {

        return new Object[][]{
            {getDocumentPayload(Map.of("CreDtTm", ""))},
            {getDocumentPayload(Map.of("CreDtTm", "2023-10-05"))},
            {getDocumentPayload(Map.of("CreDtTm", "14:43:52.098"))},
            {getDocumentPayload(Map.of("CreDtTm", "2023-10-05E14:43:52.098"))},
            {getDocumentPayload(Map.of("CreDtTm", "WEESS1000001123"))},
        };
    }

    @DataProvider(name = "invalidAccountId")
    Object[][] getInvalidAccountId() {

        return new Object[][]{
            {getDocumentPayload(Map.of("AcctId", ""))},
            {getDocumentPayload(Map.of("AcctId", "DD01100056869DD01100056869"))}
        };
    }

    @DataProvider(name = "invalidSvcrBIC")
    Object[][] getInvalidSvcrBIC() {

        return new Object[][]{
            {getDocumentPayload(Map.of("SvcrBIC", ""))},
            {getDocumentPayload(Map.of("SvcrBIC", "GSCRUS"))},
            {getDocumentPayload(Map.of("SvcrBIC", "120045630"))},
        };
    }

    @DataProvider(name = "invalidOpeningBalCd")
    Object[][] getInvalidOpeningBalCode() {

        return new Object[][]{
                {getDocumentPayload(Map.of("OpeningBalCd", ""))},
                {getDocumentPayload(Map.of("OpeningBalCd", "BAC123"))}
        };
    }

    @DataProvider(name = "invalidOpeningBalCCY")
    Object[][] getInvalidOpeningBalCCY() {

        return new Object[][]{
                {getDocumentPayload(Map.of("OpeningBalCCY", ""))},
                {getDocumentPayload(Map.of("OpeningBalCCY", "US"))},
                {getDocumentPayload(Map.of("OpeningBalCCY", "USDF"))}
        };
    }

    @DataProvider(name = "invalidOpeningBalAmt")
    Object[][] getInvalidOpeningBalAmt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("OpeningBalAmt", "BCEFIHJ"))}
        };
    }

    @DataProvider(name = "invalidOpeningBalInd")
    Object[][] getInvalidOpeningBalInd() {

        return new Object[][]{
                {getDocumentPayload(Map.of("OpeningBalInd", ""))},
                {getDocumentPayload(Map.of("OpeningBalInd", "DB"))},
                {getDocumentPayload(Map.of("OpeningBalInd", "DBIT24"))}
        };
    }

    @DataProvider(name = "invalidOpeningBalDt")
    Object[][] getInvalidOpeningBalDt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("OpeningBalDt", ""))},
                {getDocumentPayload(Map.of("OpeningBalDt", "2023-09-30"))},
                {getDocumentPayload(Map.of("OpeningBalDt", "20:00:00.000"))},
                {getDocumentPayload(Map.of("OpeningBalDt", "2023-09-30E20:00:00.000"))},
                {getDocumentPayload(Map.of("OpeningBalDt", "WEESS1000001123"))}
        };
    }

    @DataProvider(name = "invalidClosingBalCd")
    Object[][] getInvalidClosingBalCode() {

        return new Object[][]{
            {getDocumentPayload(Map.of("ClosingBalCd", ""))},
            {getDocumentPayload(Map.of("ClosingBalCd", "BAC123"))}
        };
    }

    @DataProvider(name = "invalidClosingBalCCY")
    Object[][] getInvalidClosingBalCCY() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingBalCCY", ""))},
                {getDocumentPayload(Map.of("ClosingBalCCY", "US"))},
                {getDocumentPayload(Map.of("ClosingBalCCY", "USDF"))}
        };
    }

    @DataProvider(name = "invalidClosingBalAmt")
    Object[][] getInvalidClosingBalAmt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingBalAmt", "BCEFIHJ"))}
        };
    }

    @DataProvider(name = "invalidClosingBalInd")
    Object[][] getInvalidClosingBalInd() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingBalInd", ""))},
                {getDocumentPayload(Map.of("ClosingBalInd", "DB"))},
                {getDocumentPayload(Map.of("ClosingBalInd", "DBIT24"))}
        };
    }

    @DataProvider(name = "invalidClosingBalDt")
    Object[][] getInvalidClosingBalDt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingBalDt", ""))},
                {getDocumentPayload(Map.of("ClosingBalDt", "2023-09-30"))},
                {getDocumentPayload(Map.of("ClosingBalDt", "20:00:00.000"))},
                {getDocumentPayload(Map.of("ClosingBalDt", "2023-09-30E20:00:00.000"))},
                {getDocumentPayload(Map.of("ClosingBalDt", "WEESS1000001123"))}
        };
    }

    @DataProvider(name = "invalidClosingAvlBalCd")
    Object[][] getInvalidClosingAvlBalCode() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingAvlBalCd", ""))},
                {getDocumentPayload(Map.of("ClosingAvlBalCd", "BAC123"))}
        };
    }

    @DataProvider(name = "invalidClosingAvlBalCCY")
    Object[][] getInvalidClosingAvlBalCCY() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingAvlBalCCY", ""))},
                {getDocumentPayload(Map.of("ClosingAvlBalCCY", "US"))},
                {getDocumentPayload(Map.of("ClosingAvlBalCCY", "USDF"))}
        };
    }

    @DataProvider(name = "invalidClosingAvlBalAmt")
    Object[][] getInvalidClosingAvlBalAmt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingAvlBalAmt", "BCEFIHJ"))}
        };
    }

    @DataProvider(name = "invalidClosingAvlBalInd")
    Object[][] getInvalidClosingAvlBalInd() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingAvlBalInd", ""))},
                {getDocumentPayload(Map.of("ClosingAvlBalInd", "DB"))},
                {getDocumentPayload(Map.of("ClosingAvlBalInd", "DBIT24"))}
        };
    }

    @DataProvider(name = "invalidClosingAvlBalDt")
    Object[][] getInvalidClosingAvlBalDt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ClosingAvlBalDt", ""))},
                {getDocumentPayload(Map.of("ClosingAvlBalDt", "2023-09-30"))},
                {getDocumentPayload(Map.of("ClosingAvlBalDt", "20:00:00.000"))},
                {getDocumentPayload(Map.of("ClosingAvlBalDt", "2023-09-30E20:00:00.000"))},
                {getDocumentPayload(Map.of("ClosingAvlBalDt", "WEESS1000001123"))}
        };
    }

    @DataProvider(name = "invalidForwardAvlBalCd")
    Object[][] getInvalidForwardAvlBalCode() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ForwardAvlBalCd", ""))},
                {getDocumentPayload(Map.of("ForwardAvlBalCd", "BAC123"))}
        };
    }

    @DataProvider(name = "invalidForwardAvlBalCCY")
    Object[][] getInvalidForwardAvlBalCCY() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ForwardAvlBalCCY", ""))},
                {getDocumentPayload(Map.of("ForwardAvlBalCCY", "US"))},
                {getDocumentPayload(Map.of("ForwardAvlBalCCY", "USDF"))}
        };
    }

    @DataProvider(name = "invalidForwardAvlBalAmt")
    Object[][] getInvalidForwardAvlBalAmt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ForwardAvlBalAmt", "BCEFIHJ"))}
        };
    }

    @DataProvider(name = "invalidForwardAvlBalInd")
    Object[][] getInvalidForwardAvlBalInd() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ForwardAvlBalInd", ""))},
                {getDocumentPayload(Map.of("ForwardAvlBalInd", "DB"))},
                {getDocumentPayload(Map.of("ForwardAvlBalInd", "DBIT24"))}
        };
    }

    @DataProvider(name = "invalidForwardAvlBalDt")
    Object[][] getInvalidForwardAvlBalDt() {

        return new Object[][]{
                {getDocumentPayload(Map.of("ForwardAvlBalDt", ""))},
                {getDocumentPayload(Map.of("ForwardAvlBalDt", "2023-09-30"))},
                {getDocumentPayload(Map.of("ForwardAvlBalDt", "20:00:00.000"))},
                {getDocumentPayload(Map.of("ForwardAvlBalDt", "2023-09-30E20:00:00.000"))},
                {getDocumentPayload(Map.of("ForwardAvlBalDt", "WEESS1000001123"))}
        };
    }

    @DataProvider(name = "invalidTransCCYEntry")
    Object[][] getInvalidTransCCYEntry() {

        return new Object[][] {
                {getDocumentPayload(Map.of("TransCCY", ""))},
                {getDocumentPayload(Map.of("TransCCY", "US"))},
                {getDocumentPayload(Map.of("TransCCY", "USDF"))}
        };
    }

    @DataProvider(name = "invalidTransAmtEntry")
    Object[][] getInvalidTransAmtEntry() {

        return new Object[][] {
                {getDocumentPayload(Map.of("TransAmt", ""))},
                {getDocumentPayload(Map.of("TransAmt", "BCEFIHJ"))}
        };
    }

    @DataProvider(name = "invalidTransIndEntry")
    Object[][] getInvalidTransIndEntry() {

        return new Object[][] {
                {getDocumentPayload(Map.of("TransInd", ""))},
                {getDocumentPayload(Map.of("TransInd", "CRTY"))}
        };
    }

    @DataProvider(name = "invalidTransRvslIndEntry")
    Object[][] getInvalidTransRvslIndEntry() {

        return new Object[][] {
                {getDocumentPayload(Map.of("TransRvslInd", ""))},
                {getDocumentPayload(Map.of("TransRvslInd", "CDIT"))}
        };
    }

    @DataProvider(name = "invalidTransBkDtEntry")
    Object[][] getInvalidTransBkDtEntry() {

        return new Object[][] {
                {getDocumentPayload(Map.of("TransBkDt", ""))},
                {getDocumentPayload(Map.of("TransBkDt", "2023-10-01"))},
                {getDocumentPayload(Map.of("TransBkDt", "13:37:14.000"))},
                {getDocumentPayload(Map.of("TransBkDt", "2023-10-01E13:37:14.000"))}
        };
    }

    @DataProvider(name = "invalidTransDtEntry")
    Object[][] getInvalidTransDtEntry() {

        return new Object[][] {
                {getDocumentPayload(Map.of("TransDt", ""))},
                {getDocumentPayload(Map.of("TransDt", "2023"))},
                {getDocumentPayload(Map.of("TransDt", "2023-10"))}
        };
    }

    @DataProvider(name = "invalidTransAcctSvcrRefEntry")
    Object[][] getInvalidTransAcctSvcrRefEntry() {

        return new Object[][] {
                {getDocumentPayload(Map.of("TxAcctSvcrRef", ""))},
                {getDocumentPayload(Map.of("TxAcctSvcrRef", "B20092800002225B20092800002225B20092800002225"))}
        };
    }

    @DataProvider(name = "invalidBalance")
    Object[][] getInvalidBalance() {

        return new Object[][]{
                {getDocumentPayload(Map.of("OpeningBal", ""))},
                {getDocumentPayload(Map.of("ClosingBal", ""))},
        };
    }
}
