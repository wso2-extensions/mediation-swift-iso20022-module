package org.wso2.carbon.module.swiftiso20022.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contains test constants for testing payload factory mediator.
 */
public class ISO20022ToMT940PayloadFactoryTestConstants {
    public static final String ISO20022_VALID_BUSINESS_MSG =
            "<BizMsgEnvlp>\n" +
                    "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
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
                    "\t<MsgDefIdr>camt.053.001.11</MsgDefIdr>\n" +
                    "\t<CreDt>2019-04-25T10:30:00Z</CreDt>\n" +
                    "</AppHdr>\n" +
                    "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
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
                    "                        <Cd>ACHP</Cd>\n" +
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
                    "                        <Cd>ACHB</Cd>\n" +
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
                    "                        <Cd>ASPH</Cd>\n" +
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
                    "                        <RltdPties/>\n" +
                    "                    </TxDtls>\n" +
                    "                </NtryDtls>\n" +
                    "            </Ntry>\n" +
                    "        </Stmt>\n" +
                    "    </BkToCstmrStmt>\n" +
                    "</Document>\n" +
                    "</BizMsgEnvlp>";

    public static final String ISO20022_VALID_CAMT_MSG =
            "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
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
                    "                        <Cd>ACHP</Cd>\n" +
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
                    "                        <Cd>ACHB</Cd>\n" +
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
                    "                        <Cd>ASPH</Cd>\n" +
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
                    "                        <RltdPties/>\n" +
                    "                    </TxDtls>\n" +
                    "                </NtryDtls>\n" +
                    "            </Ntry>\n" +
                    "        </Stmt>\n" +
                    "    </BkToCstmrStmt>\n" +
                    "</Document>\n";

    public static final String MT940_MAPPING_FOR_VALID_CAMT = "{1:F01GSCRUS30XXXX0000000000}{4:\n" +
            ":20:258158850\n" +
            ":21:258158850\n" +
            ":25:DD01100056869\n" +
            ":28C:1/1\n" +
            ":60F:D230930USD843686,20\n" +
            ":61:2310011001RCD10,00ACHPGSGWGDNCTAHQM8\n" +
            ":86:EREF/GSGWGDNCTAHQM8/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
            ":61:2310011001DD10,00ACHBNONREF\n" +
            ":86:PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
            ":61:2310011001CD10,00ASPH20230928LTERMID2000003\n" +
            ":86:EREF/20230928LTERMID2000003/" +
            "PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
            ":62F:D230930USD846665,15\n" +
            ":64:C231002USD334432401,27\n" +
            "-}\n";

    public static String getValidMT940ForISOBusinessMsg() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateStr = dateFormat.format(currentDate);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HHmm");
        String hourStr = hourFormat.format(currentDate);

        return "{1:F01GSCRUS30XXXX0000000000}{2:O9400400190425GSCRUS30XXXX0000000000" + dateStr + hourStr + "N}{4:\n" +
                ":20:258158850\n" +
                ":21:258158850\n" +
                ":25:DD01100056869\n" +
                ":28C:1/1\n" +
                ":60F:D230930USD843686,20\n" +
                ":61:2310011001RCD10,00ACHPGSGWGDNCTAHQM8\n" +
                ":86:EREF/GSGWGDNCTAHQM8/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                ":61:2310011001DD10,00ACHBNONREF\n" +
                ":86:PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                ":61:2310011001CD10,00ASPH20230928LTERMID2000003\n" +
                ":86:EREF/20230928LTERMID2000003/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                ":62F:D230930USD846665,15\n" +
                ":64:C231002USD334432401,27\n" +
                "-}\n";
    }

    public static final String ISO_BUSINESS_MSG_WITH_MULTIPLE_BIC_CODE_LENGTH =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<BizMsgEnvlp>\n" +
            "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
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
            "\t\t\t\t<BICFI>GSCRUS30102</BICFI>\n" +
            "\t\t\t</FinInstnId>\n" +
            "\t\t</FIId>\n" +
            "\t</To>\n" +
            "\t<BizMsgIdr>LOCA000000159</BizMsgIdr>\n" +
            "\t<MsgDefIdr>camt.053.001.11</MsgDefIdr>\n" +
            "\t<CreDt>2019-04-25T10:30:00Z</CreDt>\n" +
            "</AppHdr>\n" +
            "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
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
            "                    <Dt>2023-09-30</Dt>\n" +
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
            "                    <DtTm>2023-09-30T20:00:00.000Z</DtTm>\n" +
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
            "                    <DtTm>2023-09-30T20:00:00.000Z</DtTm>\n" +
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
            "                        <Cd>ACHP</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "            </Ntry>\n" +
            "        </Stmt>\n" +
            "    </BkToCstmrStmt>\n" +
            "</Document>\n" +
            "</BizMsgEnvlp>";

    public static String getValidMT940ForVariedBICCodeLength() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateStr = dateFormat.format(currentDate);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HHmm");
        String hourStr = hourFormat.format(currentDate);

        return "{1:F01GSCRUS30X1020000000000}{2:O9400400190425GSCRUS30XXXX0000000000" + dateStr + hourStr + "N}{4:\n" +
                ":20:258158850\n" +
                ":21:258158850\n" +
                ":25:DD01100056869\n" +
                ":28C:1/1\n" +
                ":60F:D230930USD843686,20\n" +
                ":61:2310011001RCD10,00ACHPNONREF\n" +
                ":62F:D231001USD846665,15\n" +
                ":64:C231001USD334432401,27\n" +
                "-}\n";
    }

    public static final String ISO_BUSINESS_MSG_WITH_MULTIPLE_DATETIME_FORMAT =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<BizMsgEnvlp>\n" +
            "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
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
            "\t<MsgDefIdr>camt.053.001.11</MsgDefIdr>\n" +
            "\t<CreDt>2019-04-25T10:30:00Z</CreDt>\n" +
            "</AppHdr>\n" +
            "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
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
            "                    <Dt>2023-09-30</Dt>\n" +
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
            "                    <DtTm>2023-09-30T20:00:00.000Z</DtTm>\n" +
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
            "                    <DtTm>2023-09-30T20:00:00.000Z</DtTm>\n" +
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
            "                        <Cd>ACHP</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "            </Ntry>\n" +
            "        </Stmt>\n" +
            "    </BkToCstmrStmt>\n" +
            "</Document>\n" +
            "</BizMsgEnvlp>";

    public static String getValidMT940ForISOBusinessMsgWithMultipleDateFormat() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateStr = dateFormat.format(currentDate);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HHmm");
        String hourStr = hourFormat.format(currentDate);

        return "{1:F01GSCRUS30XXXX0000000000}{2:O9400400190425GSCRUS30XXXX0000000000" + dateStr + hourStr + "N}{4:\n" +
                ":20:258158850\n" +
                ":21:258158850\n" +
                ":25:DD01100056869\n" +
                ":28C:1/1\n" +
                ":60F:D230930USD843686,20\n" +
                ":61:2310011001RCD10,00ACHPNONREF\n" +
                ":62F:D231001USD846665,15\n" +
                ":64:C231001USD334432401,27\n" +
                "-}\n";
    }

    public static final String ISO_BUSINESS_MSG_WITH_EMPTY_ENTRY_DETAILS =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<BizMsgEnvlp>\n" +
            "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
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
            "\t<MsgDefIdr>camt.053.001.11</MsgDefIdr>\n" +
            "\t<CreDt>2019-04-25T10:30:00Z</CreDt>\n" +
            "</AppHdr>\n" +
            "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
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
            "                        <Cd>ACHP</Cd>\n" +
            "                    </Prtry>\n" +
            "                </BkTxCd>\n" +
            "            </Ntry>\n" +
            "        </Stmt>\n" +
            "    </BkToCstmrStmt>\n" +
            "</Document>\n" +
            "</BizMsgEnvlp>";

    public static String getValidMT940ForISOBusinessMsgWithEmptyEntryDetails() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateStr = dateFormat.format(currentDate);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HHmm");
        String hourStr = hourFormat.format(currentDate);

        return "{1:F01GSCRUS30XXXX0000000000}{2:O9400400190425GSCRUS30XXXX0000000000" + dateStr + hourStr + "N}{4:\n" +
                ":20:258158850\n" +
                ":21:258158850\n" +
                ":25:DD01100056869\n" +
                ":28C:1/1\n" +
                ":60F:D230930USD843686,20\n" +
                ":61:2310011001RCD10,00ACHPNONREF\n" +
                ":62F:D230930USD846665,15\n" +
                ":64:C231002USD334432401,27\n" +
                "-}\n";
    }

    public static final String ISO_BUSINESS_MSG_WITH_MULTIPLE_ENTRY_DETAILS =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<BizMsgEnvlp>\n" +
            "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
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
            "\t<MsgDefIdr>camt.053.001.11</MsgDefIdr>\n" +
            "\t<CreDt>2019-04-25T10:30:00Z</CreDt>\n" +
            "</AppHdr>\n" +
            "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
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
            "                        <Cd>ACHP</Cd>\n" +
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
            "        </Stmt>\n" +
            "    </BkToCstmrStmt>\n" +
            "</Document>\n" +
            "</BizMsgEnvlp>";

    public static String getValidMT940ForISOBusinessMsgWithMultipleEntryDetails() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateStr = dateFormat.format(currentDate);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HHmm");
        String hourStr = hourFormat.format(currentDate);

        return "{1:F01GSCRUS30XXXX0000000000}{2:O9400400190425GSCRUS30XXXX0000000000" + dateStr + hourStr + "N}{4:\n" +
                ":20:258158850\n" +
                ":21:258158850\n" +
                ":25:DD01100056869\n" +
                ":28C:1/1\n" +
                ":60F:D230930USD843686,20\n" +
                ":61:2310011001RCD10,00ACHPGSGWGDNCTAHQM8\n" +
                ":86:EREF/GSGWGDNCTAHQM8/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                "EREF/GSGWGDNCTAHQM8/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                "EREF/GSGWGDNCTAHQM8/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                "EREF/GSGWGDNCTAHQM8/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                ":62F:D230930USD846665,15\n" +
                ":64:C231002USD334432401,27\n" +
                "-}\n";
    }

    public static final String ISO_BUSINESS_MSG_WITH_ADDITIONAL_ENTRY_INFO =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<BizMsgEnvlp>\n" +
            "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.03\">\n" +
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
            "\t<MsgDefIdr>camt.053.001.11</MsgDefIdr>\n" +
            "\t<CreDt>2019-04-25T10:30:00Z</CreDt>\n" +
            "</AppHdr>\n" +
            "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:camt.053.001.11\">\n" +
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
            "                        <Cd>ACHP</Cd>\n" +
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
            "\t\t<AddtlNtryInf>Sample Unstructured Remittance 123 Sample Unstructured Remittance 123</AddtlNtryInf>\n" +
            "            </Ntry>\n" +
            "        </Stmt>\n" +
            "    </BkToCstmrStmt>\n" +
            "</Document>\n" +
            "</BizMsgEnvlp>";

    public static String getValidMT940ForISOBusinessMsgWithAdditionalEntryInfo() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateStr = dateFormat.format(currentDate);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HHmm");
        String hourStr = hourFormat.format(currentDate);

        return "{1:F01GSCRUS30XXXX0000000000}{2:O9400400190425GSCRUS30XXXX0000000000" + dateStr + hourStr + "N}{4:\n" +
                ":20:258158850\n" +
                ":21:258158850\n" +
                ":25:DD01100056869\n" +
                ":28C:1/1\n" +
                ":60F:D230930USD843686,20\n" +
                ":61:2310011001RCD10,00ACHPGSGWGDNCTAHQM8\n" +
                "Sample Unstructured Remittance 123\n" +
                ":86:EREF/GSGWGDNCTAHQM8/PREF/RP/GS/CTFILERP0002/CTBA0003\n" +
                "Sample Unstructured Remittance 123 Sample Unstructured Remittance 123\n" +
                ":62F:D230930USD846665,15\n" +
                ":64:C231002USD334432401,27\n" +
                "-}\n";
    }
}
