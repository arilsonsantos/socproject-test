package br.com.orion.socproject.enums;


import lombok.Getter;

public enum ExameEnum {
	
	GRAVADO("Exame gravado com sucesso"),
	
	TITULO_ADICIONAR("Adicionar Exame"),
	TITULO_ATUALIZAR("Atualizar Exame"),
	
	//ERROS
	NAO_GRAVADO("As informações não foram gravadas."),
	CODIGO_EXISTENTE("Este código já existe.");
	
	@Getter
	private String descricao;

	private ExameEnum(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return this.descricao;
	}


}