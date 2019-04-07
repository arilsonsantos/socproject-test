package br.com.orion.socproject.exame.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import br.com.orion.socproject.exame.dao.ExameDao;
import br.com.orion.socproject.exame.model.Exame;
import br.com.orion.socproject.exame.xml.node.CabecalhoNode;
import br.com.orion.socproject.exame.xml.node.ExameNode;
import br.com.orion.socproject.exame.xml.node.MensagemRequisicaoNode;
import br.com.orion.socproject.exame.xml.node.MensagemRespostaNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebService(serviceName = "ExameService")
public class ExameService implements IExameService {

	@Resource
	private WebServiceContext wsContext;
	
	@WebMethod
	@SuppressWarnings("unchecked")
	public MensagemRespostaNode mensagemRequisicao(@WebParam(name = "mensagemRequisicao")MensagemRequisicaoNode mensagemRequisicao) {

		MessageContext msgContext = wsContext.getMessageContext();
		
		Map<Object, Object> http_headers = (Map<Object, Object>) msgContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<String> usuario = (List<String>) http_headers.get("user");
		//List<String> senha = (List<String>) http_headers.get("password");
		
		System.out.println("Header da requisição: ");
		System.out.println("Usuário: " + usuario.get(0));
		System.out.println("Header: " + http_headers.get("host").toString());
		
		MensagemRespostaNode mensagemRespostaNode = new MensagemRespostaNode();
		CabecalhoNode cabecalhoNode = new CabecalhoNode();

		cabecalhoNode.setDataHora(LocalDateTime.now());
		cabecalhoNode.setVersao("1.0");

		mensagemRespostaNode.setHeader(cabecalhoNode);

		ExameDao exameDao = new ExameDao();
		Exame exame = exameDao.getByCodigoTuss(mensagemRequisicao.getCodigoTuss());
		
		if (exame != null) {
			ExameNode exameNode = new ExameNode();
			exameNode.setCodigoTuss(exame.getCodigoTuss());
			exameNode.setNome(exame.getNome());
			exameNode.setInformacaoComplementar("Uma informação que não estaria na tabela Exame");

			mensagemRespostaNode.setExameNode(exameNode);

			log.info("Renornando mensagem com Exame");

			return mensagemRespostaNode;
		}

		log.info("Renornando mensagem com erro");
		return mensagemRespostaNode;
	}

	@Override
	public String hello(String str) {
		return "Hello " + str;

	}


}
