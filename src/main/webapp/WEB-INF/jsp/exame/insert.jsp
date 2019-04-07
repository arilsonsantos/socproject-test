<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
<body>
	<h1>Adicionar Exame</h1>

	<div style="color: #ff2b3a">
		<s:fielderror />
	</div>

	<div class="mensagemRetorno">
		<s:property value="mensagem" />
	</div>

	<div>
		<div id="botaoSuperior">
			<s:a href="view.action">
				<input type="button" class="btn btnVoltar" value="Voltar" />
			</s:a>
		</div>
	</div>

	<s:form action="insert" method="POST">
		<s:textfield  class="colPequeno" label="Código TUSS" name="exame.codigoTuss" />
		<s:textfield class="colMedio" label="Nome" name="exame.nome" />

		<s:submit value="Salvar" class="btn btnVerde" />
	</s:form>
	
</body>
</html>
