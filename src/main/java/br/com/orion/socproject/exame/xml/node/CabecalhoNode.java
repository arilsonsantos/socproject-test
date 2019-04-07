package br.com.orion.socproject.exame.xml.node;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.orion.socproject.exame.xml.adapter.LocalDateTimeAdapter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class CabecalhoNode {

	@XmlAttribute
	@XmlJavaTypeAdapter(value=LocalDateTimeAdapter.class)
	private LocalDateTime dataHora;

	@XmlAttribute
	private String versao;

}
