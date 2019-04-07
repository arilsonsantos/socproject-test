package br.com.orion.socproject.exame.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Classificacao {

	private Integer id;
	private String nome;

	public Classificacao(Integer id, String nome){
		this.id = id;
		this.nome = nome;
	}
}
