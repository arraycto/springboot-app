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
				window.location="${pageContext.request.contextPath}/sys/dict/toList.do";
			}
			$(function(){ 
				var s= new Array();
				<c:forEach items="${list}" var="userRole">
				s.push('${userRole.roleId}');
		  		</c:forEach>
				$('#cc').combobox('setValues',s); 
			})
		</script>
	</head>

	<body>
		<form id="ff" action="${pageContext.request.contextPath}/sys/dict/update.do" method="POST">
			<input type="hidden" name="id" value="${dict.id }">
			<table>
				<tr>
					<td>
						code: 
					</td>
					<td>
						<input type="text" name="code" value="${dict.code }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>
						name: 
					</td>
					<td>
						<input type="text" name="name" value="${dict.name }" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td>
						type:
					</td>
					<td>
						<input type="text" name="type" value="${dict.type }" class="easyui-textbox">
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
