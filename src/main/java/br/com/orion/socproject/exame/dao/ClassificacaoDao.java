package br.com.orion.socproject.exame.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.orion.socproject.exame.model.Classificacao;

public class ClassificacaoDao {

	public List<Classificacao> findAll(){
		Classificacao c1 = new Classificacao(1, "Consulta");
		Classificacao c2 = new Classificacao(1, "Procedimentos Clínicos");
		
		List<Classificacao> classificacoes = new ArrayList<>();
		classificacoes.add(c1);
		classificacoes.add(c2);
		
		return classificacoes;
	}
	
}
