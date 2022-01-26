<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:dt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Author>Administrator</Author>
  <LastAuthor>Administrator</LastAuthor>
  <Created>2020-03-03T07:29:00Z</Created>
  <LastSaved>2020-03-05T06:59:09Z</LastSaved>
  <Version>16.00</Version>
 </DocumentProperties>
 <CustomDocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <KSOProductBuildVer dt:dt="string">2052-11.1.0.9440</KSOProductBuildVer>
 </CustomDocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>5865</WindowHeight>
  <WindowWidth>17970</WindowWidth>
  <WindowTopX>32767</WindowTopX>
  <WindowTopY>32767</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Center"/>
   <Borders/>
   <Font ss:FontName="等线" x:CharSet="134" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s88">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
  </Style>
  <Style ss:ID="s89">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Font ss:FontName="等线" x:CharSet="134" ss:Size="14" ss:Color="#000000"
    ss:Bold="1"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="team_test">
  <Table ss:ExpandedColumnCount="8"  x:FullColumns="1"
   x:FullRows="1" ss:StyleID="s88" ss:DefaultColumnWidth="93.75"
   ss:DefaultRowHeight="16.5">
   <Column ss:Index="2" ss:StyleID="s88" ss:AutoFitWidth="0" ss:Width="252.75"/>
   <Column ss:StyleID="s88" ss:AutoFitWidth="0" ss:Width="78.75"/>
   <Column ss:StyleID="s88" ss:AutoFitWidth="0" ss:Width="111.75"/>
   <Column ss:StyleID="s88" ss:AutoFitWidth="0" ss:Width="187.5" ss:Span="1"/>
   <Column ss:Index="7" ss:StyleID="s88" ss:AutoFitWidth="0" ss:Width="80.25"/>
   <Column ss:StyleID="s88" ss:AutoFitWidth="0" ss:Width="103.5"/>
   <Row ss:AutoFitHeight="0" ss:Height="30" ss:StyleID="s89">
    <Cell ss:MergeDown="2"><Data ss:Type="String">序号</Data></Cell>
    <Cell><Data ss:Type="String">企业名称</Data></Cell>
    <Cell><Data ss:Type="String">车队类型</Data></Cell>
    <Cell><Data ss:Type="String">平台车辆总数</Data></Cell>
    <Cell><Data ss:Type="String">数据上传完成车辆数</Data></Cell>
    <Cell><Data ss:Type="String">数据上传平台</Data></Cell>
    <Cell><Data ss:Type="String">上线数</Data></Cell>
    <Cell><Data ss:Type="String">运营数</Data></Cell>
   </Row>
   <Row ss:AutoFitHeight="0" ss:Height="30" ss:StyleID="s89">
    <Cell ss:Index="2"><Data ss:Type="String">总计</Data></Cell>
    <Cell ss:Index="4" ss:StyleID="s88"><Data ss:Type="String">${zhygCarSumNum}</Data></Cell>
    <Cell ss:StyleID="s88"><Data ss:Type="String">${countCarSumNum}</Data></Cell>
    <Cell ss:StyleID="s88"/>
    <Cell ss:StyleID="s88"><Data ss:Type="String">${countCarOnlineNum}</Data></Cell>
    <Cell ss:StyleID="s88"><Data ss:Type="String">${countCarOperationNum}</Data></Cell>
   </Row>
<#if phTeamList?has_content>
   <Row ss:AutoFitHeight="0" ss:Height="30" ss:StyleID="s89">
    <Cell ss:Index="2"><Data ss:Type="String">普货企业</Data></Cell>
    <Cell ss:Index="4" ss:StyleID="s88"/>
    <Cell ss:StyleID="s88"/>
    <Cell ss:StyleID="s88"/>
    <Cell ss:StyleID="s88"/>
    <Cell ss:StyleID="s88"/>
   </Row>
</#if>
<#if phTeamList?has_content>
 <#list phTeamList as item>
   <Row ss:AutoFitHeight="0">
     <Cell><Data ss:Type="Number">${item_index+1}</Data></Cell>
     <Cell><Data ss:Type="String">${item.teamName}</Data></Cell>
     <Cell><Data ss:Type="String">${item.teamCls}</Data></Cell>
     <Cell><Data ss:Type="String">${item.zhygCarNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.carNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.compName}</Data></Cell>
     <Cell><Data ss:Type="String">${item.onlineCarNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.operationNum}</Data></Cell>
   </Row>
 </#list>
</#if>
<#if whTeamList?has_content>
   <Row ss:AutoFitHeight="0">
    <Cell ss:Index="2" ss:StyleID="s89"><Data ss:Type="String">危险品企业</Data></Cell>
    <Cell ss:StyleID="s89"/>
   </Row>
</#if>
<#if whTeamList?has_content>
 <#list whTeamList as item>
   <Row ss:AutoFitHeight="0">
     <Cell><Data ss:Type="Number">${item_index+1}</Data></Cell>
     <Cell><Data ss:Type="String">${item.teamName}</Data></Cell>
     <Cell><Data ss:Type="String">${item.teamCls}</Data></Cell>
     <Cell><Data ss:Type="String">${item.zhygCarNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.carNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.compName}</Data></Cell>
     <Cell><Data ss:Type="String">${item.onlineCarNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.operationNum}</Data></Cell>
   </Row>
 </#list>
</#if>
<#if kyTeamList?has_content>
   <Row ss:AutoFitHeight="0">
    <Cell ss:Index="2" ss:StyleID="s89"><Data ss:Type="String">客运企业</Data></Cell>
    <Cell ss:StyleID="s89"/>
   </Row>
</#if>
<#if kyTeamList?has_content>
 <#list kyTeamList as item>
   <Row ss:AutoFitHeight="0">
     <Cell><Data ss:Type="Number">${item_index+1}</Data></Cell>
     <Cell><Data ss:Type="String">${item.teamName}</Data></Cell>
     <Cell><Data ss:Type="String">${item.teamCls}</Data></Cell>
     <Cell><Data ss:Type="String">${item.zhygCarNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.carNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.compName}</Data></Cell>
     <Cell><Data ss:Type="String">${item.onlineCarNum}</Data></Cell>
     <Cell><Data ss:Type="String">${item.operationNum}</Data></Cell>
   </Row>
 </#list>
</#if>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Unsynced/>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>7</ActiveRow>
     <ActiveCol>2</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="1" ss:ExpandedRowCount="1" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
   <Row ss:AutoFitHeight="0"/>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Unsynced/>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
