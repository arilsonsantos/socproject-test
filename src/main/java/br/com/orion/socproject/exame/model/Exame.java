package br.com.orion.socproject.exame.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Exame {

	private Integer id;
	private Integer codigoTuss;
	private String nome;

	public Exame(Integer id, Integer codigoTuss, String nome) {
		this.id = id;
		this.codigoTuss = codigoTuss;
		this.nome = nome;
		
	}

}
