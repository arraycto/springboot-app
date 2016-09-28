<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/commons/include.jsp"%>

<html>
	<head>
		<title>My JSP 'updateUser.jsp' starting page</title>
		<script type="text/javascript">
			function submitForm(){
				$('#ff').submit()
			}
			function toList(){
				window.location="${pageContext.request.contextPath}/sys/resources/toList.do";
			}
			
			$(function(){ 
				
				$('#cc').combobox('setValue','${resources.type }'); 
			})
		</script>
	</head>

	<body>
		<form id="ff" action="${pageContext.request.contextPath}/sys/resources/update.do" method="POST">
			<input type="hidden" name="id" value="${resources.id }">
			<input type="hidden" name="pid" value="${pid}"/>
			<table>
				
				<tr>
					<td>
						name: 
					</td>
					<td>
						<input type="text" name="name" value="${resources.name }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>
						url: 
					</td>
					<td>
						<input type="text" name="url" value="${resources.url }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>
						type: 
					</td>
					<td>
						<input id="cc" class="easyui-combobox" name="type" 
							data-options="
								url:'${pageContext.request.contextPath}/sys/dict/selectByDict.do?type=1',
								method:'get',
								valueField:'code',
								textField:'name',
								panelHeight:'auto'
							">
					</td>
				</tr>
				
			
			</table>
		</form>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="toList()">返回</a>
		</div>
	</body>
</html>
