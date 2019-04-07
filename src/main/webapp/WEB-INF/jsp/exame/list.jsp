<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style>
<%@include file="/WEB-INF/css/style.css"%>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SOC Project</title>
</head>
<body>
	<h1>Lista de Exames</h1>

	<div>
		<div >
		<span>
			<input type="text" style="    width: 449px;   height: 30px;  font-size: 13px; text-align: center;" id="txtProcura" onkeyup="myFunction()" placeholder="Procurar por Código TUSS ou Nome" title="Digite um nome">
		</span>
		
			<s:a href="prepareInsert.action">
				<input type="button" class="btn btnAdicionar btnVerde" value="Adicionar" />
			</s:a>
		
		</div>
	</div>

	<table id="tbExame" >
		<tr>
			<th style="width:30px">#</th>
			<th style="width: 100px">CODIGO TUSS</th>
			<th style="width: 270px">NOME</th>
			<th style="width:150px" colspan="2">AÇÃO</th>
		</tr>
		<s:iterator value="exames" status="number">
			<tr>
				<s:hidden value="id" />
				<td><s:property value="#number.count" /></td>
				<td><s:property value="codigoTuss" /></td>
				<td class="colNome"><s:property value="nome"/></td>

				<td>
					<a href="prepareEdit?id=<s:property value="id"/>"> 
						<input	type="button" value="Editar" class="btn btnTabela" />
					</a>
				</td>
				<td>
					<a href="delete.action?id=<s:property value="id"/>"> 
						<input 	id="btnDelete" type="button" value="Remover" onclick="funcao(event)" class="btn btnTabela btnVermelho" />
					</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
<script>
	function funcao(event) {
		var res = confirm("Pressione OK para confirmar");
		if (res == false) {
			event.preventDefault()
		};
	}
	
	//https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_filter_table
	function myFunction() {
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("txtProcura");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("tbExame");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    td1 = tr[i].getElementsByTagName("td")[1];
		    td2 = tr[i].getElementsByTagName("td")[2];
		    if (td1 || td2) {
		      txtValue1 = td1.textContent || td1.innerText;
		      txtValue2 = td2.textContent || td2.innerText;
		      if (txtValue1.toUpperCase().indexOf(filter) > -1 || txtValue2.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
</script>
</html>




