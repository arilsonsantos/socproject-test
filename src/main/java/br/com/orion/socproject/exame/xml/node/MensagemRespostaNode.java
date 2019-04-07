package br.com.orion.socproject.exame.xml.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@XmlRootElement(name="mensagemResposta")
@XmlAccessorType(XmlAccessType.FIELD)
public class MensagemRespostaNode {

	@XmlElement
	private CabecalhoNode header;

	@XmlElement(name="exame")
	private ExameNode exameNode;




}
