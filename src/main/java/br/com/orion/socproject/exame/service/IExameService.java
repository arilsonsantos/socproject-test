package br.com.orion.socproject.exame.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.orion.socproject.exame.xml.node.MensagemRequisicaoNode;
import br.com.orion.socproject.exame.xml.node.MensagemRespostaNode;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IExameService {

	@WebMethod()
	public MensagemRespostaNode mensagemRequisicao(@WebParam(name="mensagemRequisicao") MensagemRequisicaoNode mensagemRequisicao);

	@WebMethod
	public String hello(@WebParam(name="str")String str);

}
