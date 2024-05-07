<#-- Macros --><#macro ltToBIC lTAddress><#if lTAddress?length == 12 >${lTAddress[0..7] + lTAddress[9..11]}<#else>${lTAddress}</#if></#macro>
<#macro getDateTime date time><#assign fullDate="20" + date[0..1] + "-" + date[2..3] + "-" + date[4..5] + "T" /><#assign fullTime=time[0..1] + ":" + time[2..3] + ":00Z">${fullDate + fullTime}</#macro>
<#macro getDtFromDate date>${"20" + date[0..1] + "-" + date[2..3] + "-" + date[4..5]}</#macro><#macro getCurrencyAmt amt><#if amt?replace (",", ".")?ends_with(".")>${amt?replace (",", ".") + "00"}<#else>${amt?replace (",", ".")}</#if></#macro>
<BizMsgEnvlp>
<AppHdr xmlns="urn:iso:std:iso:20022:tech:xsd:head.001.001.03">
	<#if payload.applicationHeaderBlock.messageInputReference?has_content>
	<Fr>
		<FIId>
			<FinInstnId>
				<BICFI><@ltToBIC payload.applicationHeaderBlock.messageInputReference[6..17]/></BICFI><#-- Application header: MIR LT identifier -->
			</FinInstnId>
		</FIId>
	</Fr>
	</#if>
	<To>
		<FIId>
			<FinInstnId>
				<BICFI><@ltToBIC payload.basicHeaderBlock.logicalTerminalAddress/></BICFI><#-- Basic header: LT identifier -->
			</FinInstnId>
		</FIId>
	</To>
	<MsgDefIdr>camt.053.001.11</MsgDefIdr>
	<#if payload.applicationHeaderBlock?has_content>
	<CreDt><@getDateTime payload.applicationHeaderBlock.messageInputReference[0..5] payload.applicationHeaderBlock.inputTime /></CreDt><#-- Application header: Input Time OR Application header: Time in MIR -->
	</#if>
</AppHdr>
<Document xmlns="urn:iso:std:iso:20022:tech:xsd:camt.053.001.11">
    <BkToCstmrStmt>
        <GrpHdr>
            <MsgId>235549650</MsgId><#if payload.applicationHeaderBlock?has_content>
			<CreDt><@getDateTime payload.applicationHeaderBlock.messageInputReference[0..5] payload.applicationHeaderBlock.inputTime /></CreDt></#if><#-- Application header: Input Time OR Application header: Time in MIR -->
            <#if payload.textBlock.statementSequenceNumber.statementNumber?has_content>
            	<MsgPgntn>
            		<PgNb>${payload.textBlock.statementSequenceNumber.statementNumber}</PgNb><#-- Tag 28C: Statement number / [Sequence Number] -->
            	</MsgPgntn>
            </#if>
        </GrpHdr>
        <Stmt>
            <Id>${payload.textBlock.transactionReferenceNumber.value}</Id><#-- Tag 20 / Transaction Reference Number: Value  -->
            <#if payload.textBlock.statementSequenceNumber.statementNumber?has_content>
            	<MsgPgntn>
            		<PgNb>${payload.textBlock.statementSequenceNumber.statementNumber}</PgNb><#-- Tag 28C: Statement number / [Sequence Number] -->
            	</MsgPgntn>
            </#if>
            <#if payload.textBlock.statementSequenceNumber.statementNumber?has_content>
            	<ElctrncSeqNb>${payload.textBlock.statementSequenceNumber.statementNumber}</ElctrncSeqNb><#-- Tag 28C: Statement number / [Sequence Number] -->
            </#if>
            <#if payload.textBlock.statementSequenceNumber.sequenceNumber?has_content>
            	<LglSeqNb>${payload.textBlock.statementSequenceNumber.sequenceNumber}</LglSeqNb><#-- Tag 28C: Statement number / [Sequence Number] -->
            </#if>
            <Acct>
            	<#if payload.textBlock.accountIdentification?has_content>
                <Id>
                    <Othr>
                        <Id>${payload.textBlock.accountIdentification.account}</Id><#-- Tag 25: Account -->
                    </Othr>
                </Id>
                </#if>
                <Svcr>
                    <FinInstnId>
                        <BICFI><@ltToBIC payload.basicHeaderBlock.logicalTerminalAddress/></BICFI><#-- Basic header: LT identifier -->
                    </FinInstnId>
                </Svcr>
            </Acct>
            <Bal>
                <Tp>
                    <CdOrPrtry>
                        <Cd>OPBD</Cd><#-- Tag 60: Opening balance -->
                    </CdOrPrtry>
                </Tp>
                <Amt Ccy="${payload.textBlock.openingBal.currency}"><@getCurrencyAmt payload.textBlock.openingBal.amount/></Amt><#-- Tag 60/Opening Balance: Currency and Amount -->
                <CdtDbtInd><#if payload.textBlock.openingBal.dcMark == "C">CRDT<#else>DBIT</#if></CdtDbtInd><#-- Tag 60/Closing Balance: D/C Mark -->
                <Dt>
                	<Dt><@getDtFromDate payload.textBlock.openingBal.date/></Dt><#-- Tag 60/Opening Balance: Date -->
                </Dt>
            </Bal>
            <Bal>
                <Tp>
                    <CdOrPrtry>
                        <Cd>CLBD</Cd><#-- Tag 62: Closing balance -->
                    </CdOrPrtry>
                </Tp>
                <Amt Ccy="${payload.textBlock.closingBal.currency}"><@getCurrencyAmt payload.textBlock.closingBal.amount/></Amt><#-- Tag 62/Closing Balance: Currency and Amount -->
                <CdtDbtInd><#if payload.textBlock.closingBal.dcMark == "C">CRDT<#else>DBIT</#if></CdtDbtInd><#-- Tag 62/Closing Balance: D/C Mark -->
                <Dt>
                	<Dt><@getDtFromDate payload.textBlock.closingBal.date/></Dt><#-- Tag 62/Closing Balance: Date -->
                </Dt>
            </Bal>
            <#if payload.textBlock.closingAvlBalance?has_content>
            <Bal>
                <Tp>
                    <CdOrPrtry>
                        <Cd>CLAV</Cd><#-- Tag 64: Closing available balance -->
                    </CdOrPrtry>
                </Tp>
                <Amt Ccy="${payload.textBlock.closingAvlBalance.currency}"><@getCurrencyAmt payload.textBlock.closingAvlBalance.amount/></Amt><#-- Tag 64/Closing available balance: Currency and Amount -->
                <CdtDbtInd><#if payload.textBlock.closingAvlBalance.dcMark == "C">CRDT<#else>DBIT</#if></CdtDbtInd><#-- Tag 64/Closing available balance: D/C Mark -->
                <Dt>
                    <Dt><@getDtFromDate payload.textBlock.closingAvlBalance.date/></Dt><#-- Tag 64/Closing available balance: Date -->
                </Dt>
            </Bal>
            </#if>
            <#if payload.textBlock.forwardAvlBalance?has_content>
            <Bal>
                <Tp>
                    <CdOrPrtry>
                        <Cd>FWAV</Cd><#-- Tag 65: Forward available balance -->
                    </CdOrPrtry>
                </Tp>
                <Amt Ccy="${payload.textBlock.forwardAvlBalance.currency}"><@getCurrencyAmt payload.textBlock.forwardAvlBalance.amount/></Amt><#-- Tag 65/Forward available balance: Currency and Amount -->
                <CdtDbtInd><#if payload.textBlock.forwardAvlBalance.dcMark == "C">CRDT<#else>DBIT</#if></CdtDbtInd><#-- Tag 65/Forward available balance: D/C Mark -->
                <Dt>
                    <Dt><@getDtFromDate payload.textBlock.forwardAvlBalance.date/></Dt><#-- Tag 65/Forward available balance: Date -->
                </Dt>
            </Bal>
            </#if>
            <TxsSummry>
            	<#assign creditCount = 0 /><#assign debitCount = 0 />
            	<#assign creditAmount = 0 /><#assign debitAmount = 0 />
            	<#assign statements = [] />
            	<#if payload.textBlock.statementLines?has_content && (payload.textBlock.statementLines?size > 0)>
            		<#assign statements = payload.textBlock.statementLines />
            	</#if>
            	<#list statements as statement>
            		<#if statement.Field61.dcMark == "C" || statement.Field61.dcMark == "RC">
            			<#assign creditCount = creditCount + 1 /><#assign creditAmount = creditAmount + statement.Field61.amount?replace(",", ".")?number />
            		<#else>
            			<#assign debitCount = debitCount + 1 /><#assign debitAmount = debitAmount + statement.Field61.amount?replace(",", ".")?number />
            		</#if>
            	</#list>
            	<TtlNtries>
                    <NbOfNtries>${creditCount + debitCount}</NbOfNtries>
                    <Sum>${(creditAmount + debitAmount)?string("##0.00")}</Sum>
                    <#if (creditAmount < debitAmount)>
                   	<TtlNetNtry>
                   		<Amt>${(debitAmount - creditAmount)?string("##0.00")}</Amt>
                   		<CdtDbtInd>DBIT</CdtDbtInd>
                   	</TtlNetNtry>
                   	<#else>
                   	<TtlNetNtry>
                   		<Amt>${(creditAmount - debitAmount)?string("##0.00")}</Amt>
                   		<CdtDbtInd>CRDT</CdtDbtInd>
                   	</TtlNetNtry>
                   	</#if>
                </TtlNtries>
            	<TtlCdtNtries>
                    <NbOfNtries>${creditCount}</NbOfNtries>
                    <Sum>${creditAmount?string("##0.00")}</Sum>
                </TtlCdtNtries>
            	<TtlDbtNtries>
                    <NbOfNtries>${debitCount}</NbOfNtries>
                    <Sum>${debitAmount?string("##0.00")}</Sum>
                </TtlDbtNtries>
            </TxsSummry>
            <#assign entries = [] />
            <#if payload.textBlock.statementLines?has_content && (payload.textBlock.statementLines?size > 0)>
            	<#assign entries=payload.textBlock.statementLines/>
            </#if>
            <#list entries as entry>
            <Ntry>
                <Amt><@getCurrencyAmt entry.Field61.amount/></Amt><#-- Tag 61: Amount -->
                <CdtDbtInd><#if entry.Field61.dcMark == "C" || entry.Field61.dcMark == "RC">CRDT<#else>DBIT</#if></CdtDbtInd><#-- Tag 61: D/C Mark -->
                <RvslInd><#if entry.Field61.dcMark == "RC" || entry.Field61.dcMark == "RD">true<#else>false</#if></RvslInd><#-- Tag 61: D/C Mark -->
              	<#if entry.Field61.entryDate?has_content>
                <BookgDt>
                    <Dt>${.now?string('yyyy') + "-" + entry.Field61.entryDate[0..1] + "-" + entry.Field61.entryDate[2..3]}</Dt><#-- Tag 61: Entry Date with Current System year -->
                </BookgDt>
                </#if>
                <ValDt>
                    <Dt><@getDtFromDate entry.Field61.valueDate/></Dt><#-- Tag 61: Value Date -->
                </ValDt>
                <#if entry.Field61.refToAccountServicingInstitution?has_content>
                <AcctSvcrRef>${entry.Field61.refToAccountServicingInstitution}</AcctSvcrRef>
                </#if>
            	<BkTxCd>
					<Domn>
						<Cd>${entry.Field61.transactionType + entry.Field61.identificationCode}</Cd><#-- Tag 61: Transaction Type and Identification Code -->
					</Domn>
				</BkTxCd>
				<#if entry.Field86?has_content>
				<NtryDtls>
				<#assign txDtls=entry.Field86.value?split("\\R") />
				<#list txDtls as txDtl>
					<#assign txDtlsStr="" />
					<#assign additionalInfo="" />
					<#assign details=txDtl?split("/") /><#assign detailsCount=details?size - 1 />
					<#list 0..detailsCount as i>
						<#if details[i] == "EREF">
							<#assign txDtlsStr = txDtlsStr + "<EndToEndId>" + details[i + 1] + "</EndToEndId>" />
							<#assign i = i + 1>
						<#elseif details[i] == "IREF">
							<#assign txDtlsStr = txDtlsStr + "<InstrId>" + details[i + 1] + "</InstrId>" />
							<#assign i = i + 1>
						<#elseif details[i] == "PREF">
							<#assign txDtlsStr = txDtlsStr + "<PmtInfId>" + details[i + 1] + "</PmtInfId>" />
							<#assign i = i + 1>
						<#else>
							<#assign additionalInfo = details[i] />
						</#if>
					</#list>
					<#if txDtlsStr != "">
						<TxDtls>
							<Refs>
								${txDtlsStr}
							</Refs>
						</TxDtls>
					</#if>
					<#if additionalInfo != "">
						<AddtlNtryInf>${additionalInfo}</AddtlNtryInf>
					</#if>
				</#list>
				</NtryDtls>
				</#if>
            </Ntry>
            </#list>
            <#if payload.textBlock.infoToAccountOwner?has_content>
            <AddtlStmtInf>${payload.textBlock.infoToAccountOwner.value}</AddtlStmtInf>
            </#if>
        </Stmt>
    </BkToCstmrStmt>
</Document>
</BizMsgEnvlp>