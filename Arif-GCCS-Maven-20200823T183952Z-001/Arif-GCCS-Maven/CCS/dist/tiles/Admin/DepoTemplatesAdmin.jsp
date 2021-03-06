<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<SCRIPT>
        var notSavedChanges=false;

        <bean:size id="templPymtsCount" name="DepoTemplatesAdminForm" property="templPaymentTypes" />
        <bean:size id="allPymtsCount" name="DepoTemplatesAdminForm" property="allPaymentTypes" />

        
        
        var pymtCtgAssoc=new Array(<bean:write name="templPymtsCount" />+<bean:write name="allPymtsCount" />);
       
        <logic:iterate id="elem" name="DepoTemplatesAdminForm" property="templPaymentTypes">
              pymtCtgAssoc["<bean:write name="elem" property="paymentTypeId" />"] = "<bean:write name="elem" property="paymentCtgId" />";
        </logic:iterate>
        <logic:iterate id="elem" name="DepoTemplatesAdminForm" property="allPaymentTypes">
              pymtCtgAssoc["<bean:write name="elem" property="paymentTypeId" />"] = "<bean:write name="elem" property="paymentCtgId" />";
        </logic:iterate>
        

	function move(op,what){
		var frm=document.forms['DepoTemplatesAdminForm'];
		var src;
		var trg;
                var selectedCount=Number(0);

                var sortingLimit=50;
                
                if(what=="locations"){
                    if(op=="add"){
                            src=frm.allLocations;
                            trg=frm.templLocations;
                    }else{
                            src=frm.templLocations;
                            trg=frm.allLocations;
                    }
                 }else{
                    if(op=="add"){
                            src=frm.allPaymentTypes;
                            trg=frm.templPaymentTypesIds;
                            var msg=validatePaymentTypes(src,trg);
                            if(msg!=""){
                                alert(msg);
                                return;
                            }         
                            
                    }else{ 
                            src=frm.templPaymentTypesIds;
                            trg=frm.allPaymentTypes;
                    }
                 }



		for(i=src.length-1;i>=0;i--){
			if(src.options[i].selected){
                                selectedCount++;
                                
                                if(selectedCount>sortingLimit || trg.length>sortingLimit){
                                     trg.options[trg.length]=new Option(src.options[i].text,src.options[i].value);
                                }else{
                                    for(j=trg.length;j>=0;j--){ //to keep the options sorted if this does not take so much time.

                                            if(j==0 || trg.options[j-1].text<=src.options[i].text){
                                                    trg.options[j]=new Option(src.options[i].text,src.options[i].value);
                                                    break;
                                            }else{
                                                    trg.options[j]=new Option(trg.options[j-1].text,trg.options[j-1].value);;
                                            }
                                    }
                                }
				src.options[i]=null;
			}
		}

                if(selectedCount>0) {
                        notSavedChanges=true;

                        if(what=="locations"){
                             prepareLocations();
                             preparePaymentTypes();
							 
                             frm.action.value="loadPayments";
                             frm.submit();
                        }
                }
	}

        function validatePaymentTypes(src,trg){
                var allowedCtgs;
                if(trg.options[0]!=null){
                    firstOpt=trg.options[0];
                }else{
                    firstOpt=src.options[src.selectedIndex];
                }

                switch(pymtCtgAssoc[firstOpt.value]){
                     case "1":
                        allowedCtgs=new Array("1","5");
                        break;
                     case "2":
                        allowedCtgs=new Array("2");
                        break;
                     case "3":
                        allowedCtgs=new Array("3");
                        break;
                     case "4":
                        allowedCtgs=new Array("4");
                        break;
                     case "5":
                        allowedCtgs=new Array("1","5");
                        break;
                }

                var correctPt;
                for(i=1;i<trg.length;i++){
                    correctPt=false;
                    for(j=0;j<allowedCtgs.length;j++){
                        if(pymtCtgAssoc[trg.options[i].value]==allowedCtgs[j]){
                            correctPt=true;
                            break;
                        }
                    }
                    if(!correctPt) return "The payments cannot be added.\n Remember that the only payment types that can be mixed\n in the same template are cash and check. "
                }

                for(i=1;i<src.length;i++){
                    if(src.options[i].selected){
                        correctPt=false;
                        for(j=0;j<allowedCtgs.length;j++){
                            if(pymtCtgAssoc[src.options[i].value]==allowedCtgs[j]){
                                correctPt=true;
                                break;
                            }
                        }
                        if(!correctPt) return "The payments cannot be added.\n Remember that the only payment types that can be mixed\n in the same template are cash and check. "
                    }
                }

                return "";
        }

	function moveAll(op,what){
            
            
		var frm=document.forms['DepoTemplatesAdminForm'];
		var sel;
                var msg;

                if(what=="locations"){
                    if(op=="add"){
                            sel=frm.allLocations;
                            msg="<bean:message key="app.messages.js.AddAllLocations" />";
                    }else{
                            sel=frm.templLocations;
                            msg="<bean:message key="app.messages.js.RemoveAllLocations" />";
                    }
                }else{
                    if(op=="add"){
                            sel=frm.allPaymentTypes;
                            msg="<bean:message key="app.messages.js.AddAllPaymentTypes" />";
                    }else{
                            sel=frm.templPaymentTypesIds;
                            msg="<bean:message key="app.messages.js.RemoveAllPaymentTypes" />";
                    }
                }    
                
                if(confirm(msg)){
                    for(i=0;i<sel.length;i++) sel.options[i].selected=true;
                    move(op,what);
                }    


	}

        function editTemplate(){
            if(!notSavedChanges || confirm("<bean:message key="app.messages.js.UnSavedChanges" />")){
                var frm=document.forms['DepoTemplatesAdminForm'];

                //frm.elements['currentDepTempl.templId'].value=templId;
                prepareLocations();
                preparePaymentTypes();
                frm.submit();
            }
        }

        function newTemplate(){
            if(!notSavedChanges || confirm("<bean:message key="app.messages.js.UnSavedChanges" />")){
                var frm=document.forms['DepoTemplatesAdminForm'];

                frm.elements['currentDepTempl.templId'].selectedIndex=0;

                prepareLocations();
                preparePaymentTypes();
                frm.submit();                                             
            }
        }

        function deleteTemplate(){
            if(!notSavedChanges || confirm("<bean:message key="app.messages.js.UnSavedChanges" />")){
                var frm=document.forms['DepoTemplatesAdminForm'];

                //frm.elements['currentDepTempl.templId'].value=templId;
                prepareLocations();
                preparePaymentTypes();
                frm.action.value="delete";
                frm.submit();
            }    
        }

        function prepareLocations(){
                var frm=document.forms['DepoTemplatesAdminForm'];
                var sel=frm.templLocations;
		for(i=0;i<sel.length;i++) sel.options[i].selected=true;

                frm.allLocations.selectedIndex=-1;
        }

        function preparePaymentTypes(){
                var frm=document.forms['DepoTemplatesAdminForm'];
                var sel=frm.templPaymentTypesIds;
		for(i=0;i<sel.length;i++) sel.options[i].selected=true;

                frm.allPaymentTypes.selectedIndex=-1;
        }

        function validate(){
                var result=""; 
                var frm=document.forms['DepoTemplatesAdminForm'];

                if(frm.elements['currentDepTempl.templDesc'].value.length==0 ||
                   frm.elements['currentDepTempl.templCd'].value.length==0
                   ){
                        result="- <bean:message key="app.messages.js.MustEnterAllField" />\n";
                }

                if(!frm.elements['currentDepTempl.cntRod'].checked && !frm.elements['currentDepTempl.cntPrepaid'].checked && !frm.elements['currentDepTempl.cntPoa'].checked && !frm.elements['currentDepTempl.cntGrnd'].checked && !frm.elements['currentDepTempl.cntOther'].checked && !frm.elements['currentDepTempl.cntCod'].checked && !frm.elements['currentDepTempl.cntFtc'].checked){
                        result=result + "- <bean:message key="app.messages.js.MustSelectASource" />\n";
                }

                if(!frm.localCurrencySelected.checked && !frm.usdCurrencySelected.checked){
                        result=result + "- <bean:message key="app.messages.js.MustSelectACurrency" />\n";
                }

                return result;
        }


        function save(){
                var frm=document.forms['DepoTemplatesAdminForm'];
                var result=validate();
                if(result!=""){
                    alert(result);
                }else{
                    frm.action.value="save";
                    prepareLocations();
                    preparePaymentTypes();
                    frm.submit();
                }                
        }

        function close(){
            if(!notSavedChanges || confirm("<bean:message key="app.messages.js.UnSavedChanges" />")){
                document.location.href="<html:rewrite page="/Admin/AdminIndex.do" />";
            }    
        }

</SCRIPT>



<html:errors />
<nested:form method="post" action="/Admin/DepoTemplatesAdmin.do">    
    <input type="hidden" name="action" >
    <div align="center">

	<table border="0" width="810" cellspacing="0" cellpadding="0" bgcolor="#000000" style="border-collapse: collapse" bordercolor="#111111" height="678">
	  <tr>
			<td bgcolor="#808080" width="4" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="4" width="790" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="6" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
			<td bgcolor="#808080" width="4" height="3">
				<font face="Arial">
					<img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#808080" colspan="4" width="790" height="3">
				<font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
			<td bgcolor="#808080" width="6" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="21">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" width="328" height="21" colspan="2">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" height="21" width="381" style="border-bottom-style: solid; border-bottom-width: 1">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" height="21" width="81">&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="21">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="33">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" height="33" width="74" style="border-right-style: solid; border-right-width: 1">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="center" valign="middle" colspan="2" style="border-style: solid; border-width: 1" height="34">
			<b><font face="Arial" size="2"><br><p align="center">Templates:     
				<nested:select property="currentDepTempl.templId" onchange="editTemplate()">
                    <html:option value="0">------New------</html:option>
			    	<nested:optionsCollection property="allTemplates" label="templCd" value="templId" />
			    </nested:select>         <b><font face="Arial"><%--a href="javascript:editTemplate();">
                    <font size="2"><bean:message key="app.messages.Edit" /></font></a--%><font size="2"> </font>
             <a href="javascript:deleteTemplate();"><font size="2" face="Arial"><bean:message key="app.messages.Delete" /></font></a>
             <a href="javascript:newTemplate();"><font size="2" face="Arial"><bean:message key="app.messages.New" /></font></p></a>
             </font></b></p></td>
		<td bgcolor="#FFFF9C" height="33" width="81" style="border-left-style: solid; border-left-width: 1">&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="33">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="33">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" height="33" width="74" style="border-right-style: solid; border-right-width: 1">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" width="252" style="border-style: solid; border-width: 1" height="34">
			<b><font face="Arial" size="2"><bean:message key="app.messages.Code" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="34" width="380" style="border-style: solid; border-width: 1">
			<font face="Arial">
			&nbsp;<nested:text property="currentDepTempl.templCd" size="20" maxlength="10" /></font></td>
		<td bgcolor="#FFFF9C" height="33" width="81" style="border-left-style: solid; border-left-width: 1">&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="33">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="34">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" height="34" width="74" style="border-right-style: solid; border-right-width: 1">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" width="252" style="border-style: solid; border-width: 1" height="35">
			<b><font face="Arial" size="2"><bean:message key="app.messages.Description" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="35" width="380" style="border-style: solid; border-width: 1">
			<font face="Arial">
			&nbsp;<nested:text property="currentDepTempl.templDesc" size="30" maxlength="30" /></font></td>
		<td bgcolor="#FFFF9C" height="34" width="81" style="border-left-style: solid; border-left-width: 1">&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="34">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="32">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" height="32" width="74" style="border-right-style: solid; border-right-width: 1">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" width="252" style="border-style: solid; border-width: 1" height="33">
			<b><font face="Arial" size="2"><bean:message key="app.messages.Source" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" align="right" height="33" width="390" style="border-style: solid; border-width: 1">
			<p align="left">
			<b><font face="Arial" size="2">&nbsp; 
                        ROD <nested:checkbox property="currentDepTempl.cntRod" value="1"  />&nbsp;&nbsp;
                        PREPAID <nested:checkbox property="currentDepTempl.cntPrepaid" value="1" />&nbsp;&nbsp;
                        POA <nested:checkbox property="currentDepTempl.cntPoa" value="1" />&nbsp;&nbsp;
                        GROUND <nested:checkbox property="currentDepTempl.cntGrnd" value="1" />&nbsp;&nbsp;
                        COD <nested:checkbox property="currentDepTempl.cntCod" value="1" />&nbsp;&nbsp;
                        FTC <nested:checkbox property="currentDepTempl.cntFtc" value="1" />&nbsp;&nbsp;
                        
                        OTHER <nested:checkbox property="currentDepTempl.cntOther" value="1" /></font></b></td>
		<td bgcolor="#FFFF9C" align="right" height="32" width="81" style="border-left-style: solid; border-left-width: 1">&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="32">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="32">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" height="32" width="74" style="border-right-style: solid; border-right-width: 1">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" width="252" style="border-style: solid; border-width: 1" height="33">
			<b><font face="Arial" size="2"><bean:message key="app.messages.Currency" />&nbsp;&nbsp;&nbsp;</font></b></td>
		<td bgcolor="#FFFF9C" height="33" width="380" style="border-style: solid; border-width: 1" >
			<b><font face="Arial" size="2">&nbsp; LOCAL <nested:checkbox property="localCurrencySelected" />&nbsp;&nbsp;&nbsp;
                                                              USD <nested:checkbox property="usdCurrencySelected" /></font></b>
                </td>
		<td bgcolor="#FFFF9C" height="32" width="81" style="border-left-style: solid; border-left-width: 1" >&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="32">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="32">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" height="32" width="74" style="border-right-style: solid; border-right-width: 1">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="right" width="252" style="border-style: solid; border-width: 1" height="33">
			<b><font face="Arial" size="2"><bean:message key="app.messages.CreditCardReimbType" />&nbsp;&nbsp;&nbsp;&nbsp; </font></b></td>
		<td bgcolor="#FFFF9C" height="33" width="380" style="border-style: solid; border-width: 1" >
			<b><font face="Arial" size="2">&nbsp; EFT <nested:radio property="currentDepTempl.crcdReimbTypeCd" value="EFT" />&nbsp;&nbsp;&nbsp;
            CHK <nested:radio property="currentDepTempl.crcdReimbTypeCd" value="CHK"/></font></b></td>
		<td bgcolor="#FFFF9C" height="32" width="81" style="border-left-style: solid; border-left-width: 1" >&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="32">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="189">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="center" height="189" width="74">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="center" style="border-right-style: solid; border-right-width: 1; border-left-style: solid; border-left-width: 1; border-bottom-style:solid; border-bottom-width:1" width="252" height="189">
			<p align="right"><font face="Arial" size="2" ><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <bean:message key="app.messages.Stations" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b></font></td>
		<td bgcolor="#FFFF9C" align="center" height="189" style="border-right-style: solid; border-right-width: 1; border-left-style: solid; border-left-width: 1; border-bottom-style:solid; border-bottom-width:1" width="380">
			<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" id="AutoNumber1" width="254" height="188" >
              <tr>
		<td bgcolor="#FFFF9C" height="188" width="106">
			<p align="center">
			<nested:select property="allLocations" multiple="true" value="" size="11"  style="width:80" >
                            <nested:options property="allLocations"  />
                        </nested:select>
            </td>
		<td bgcolor="#FFFF9C" height="188" width="103">
			<p align="center"><input type="button" onclick="moveAll('add','locations')" value="&gt;&gt;" name="B3"></p>
            <p align="center"><input type="button" value=" &gt; " onclick="move('add','locations')" name="B2"></p>
            <p align="center"><input type="button" value=" &lt; " name="B1" onclick="move('remove','locations')";></p>
            <p align="center"><input type="button" onclick="moveAll('remove','locations')"; value="&lt;&lt;" name="B4"></td>
		<td bgcolor="#FFFF9C" height="188" width="103">
			<p align="center">
			<nested:select property="templLocations" multiple="true"  value=""  size="11"  style="width:80" >
                            <nested:options property="templLocations" />
                        </nested:select></td>
		      </tr>
            </table></td>
		<td bgcolor="#FFFF9C" align="center" height="189" width="81" >&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="189">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="189">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="center" height="189" width="74">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="center" style="border-right-style: solid; border-right-width: 1; border-left-style: solid; border-left-width: 1; border-bottom-style:solid; border-bottom-width:1" width="252" height="189">
			<p align="right"><font face="Arial" size="2" ><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <bean:message key="app.messages.PaymentTypes" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b></font></td>
		<td bgcolor="#FFFF9C" align="center" height="189" style="border-right-style: solid; border-right-width: 1; border-left-style: solid; border-left-width: 1; border-bottom-style:solid; border-bottom-width:1" width="380">
			<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" id="AutoNumber1" width="360" height="188" >
              <tr>
		<td bgcolor="#FFFF9C" height="188" width="184">
			<p align="center">
			<nested:select property="allPaymentTypes" multiple="true"  value=""  size="11"  style="width:150" >
                            <nested:optionsCollection property="allPaymentTypes" label="description" value="paymentTypeId" />
                        </nested:select>
			</td>
		<td bgcolor="#FFFF9C" height="188" width="68">
			<p align="center"><input type="button"  onclick="moveAll('add','paymenttypes')"  value="&gt;&gt;" name="B3"></p>
            <p align="center"><input type="button" onclick="move('add','paymenttypes')"  value=" &gt; " name="B2"></p>
            <p align="center"><input type="button"  onclick="move('remove','paymenttypes')" value=" &lt; " name="B1"></p>
            <p align="center"><input type="button"  onclick="moveAll('remove','paymenttypes')" value="&lt;&lt;" name="B4"></td>
		<td bgcolor="#FFFF9C" height="188" width="166">
			<p align="center">
			<nested:select property="templPaymentTypesIds" multiple="true"  value=""  size="11"  style="width:150" >
                            <nested:optionsCollection property="templPaymentTypes" label="description" value="paymentTypeId" />
                        </nested:select>
                </td>
		      </tr>
            </table></td>
		<td bgcolor="#FFFF9C" align="center" height="189" width="81" >&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="189">&nbsp;</td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="18">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C" align="center" height="18" width="75">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="center" colspan="2" height="18" width="634">&nbsp;
			</td>
		<td bgcolor="#FFFF9C" align="center" height="18" width="81" >&nbsp;
			</td>
		<td bgcolor="#808080" width="6" height="18"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>
          <tr>
			<td bgcolor="#808080" width="4" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
			<td bgcolor="#FFFF9C" colspan="4" height="3"><p align="center"><html:link href="javascript:save();" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link><html:link href="javascript:close()" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38"></html:link></p></td>
			<td bgcolor="#808080" width="4" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="84">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1"></font></td>
		<td bgcolor="#FFFF9C" align="center" colspan="4" height="84" width="790">
	   <%--table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" id="AutoNumber2" align="center" width="550">
           <tr>
             <td width="100" bgcolor="#800080" align="center"><b>
             <font color="#FFFFFF" face="Arial" size="2"><bean:message key="app.messages.Code" /></font></b></td>
             <td width="350" bgcolor="#800080" align="center"><b>
             <font face="Arial" color="#FFFFFF" size="2"><bean:message key="app.messages.Description" /></font></b></td>
             <td width="100" bgcolor="#800080" align="center">&nbsp;</td>
           </tr>
            <nested:iterate property="allTemplates">
           <tr>
             <td  align="center"><font face="Arial" size="2"><nested:write property="templCd" /></font></td>
             <td  align="center"><font face="Arial" size="2"><nested:write property="templDesc" /></font></td>
             <td >
                <p align="center"><b><font face="Arial"><a href="javascript:editTemplate(<nested:write property="templId" />);">
                    <font size="2"><bean:message key="app.messages.Edit" /></font></a><font size="2"> </font>
             <a href="javascript:deleteTemplate(<nested:write property="templId" />);"><font size="2" face="Arial"><bean:message key="app.messages.Delete" /></font></p></a>
            </td>
           </tr>
           </nested:iterate>
         </table--%>
		 </td>
		<td bgcolor="#808080" width="6" height="84"><img border="0" src="pixel.gif" width="1"></td>
	  </tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="790" colspan="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="6" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
	  <tr>
		<td bgcolor="#808080" width="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" width="1" height="1"></font></td>
		<td bgcolor="#808080" width="790" colspan="4" height="4">
			<font face="Arial">
			<img border="0" src="pixel.gif" height="1"></font></td>
		<td bgcolor="#808080" width="6" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td></tr>
</table>
    </div>
</nested:form>
