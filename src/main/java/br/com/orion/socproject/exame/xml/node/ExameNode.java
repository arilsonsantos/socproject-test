package br.com.orion.socproject.exame.xml.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ExameNode {


	@XmlElement
	private Integer codigoTuss;

	@XmlElement
	private String nome;

	@XmlElement
	private String informacaoComplementar;

}
