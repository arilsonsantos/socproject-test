package br.com.orion.socproject.exame.action;

import static br.com.orion.socproject.enums.ExameEnum.CODIGO_EXISTENTE;
import static br.com.orion.socproject.enums.ExameEnum.GRAVADO;
import static br.com.orion.socproject.enums.ExameEnum.NAO_GRAVADO;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import br.com.orion.socproject.exame.dao.ClassificacaoDao;
import br.com.orion.socproject.exame.dao.ExameDao;
import br.com.orion.socproject.exame.model.Classificacao;
import br.com.orion.socproject.exame.model.Exame;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExameAction extends ActionSupport {

	private static final long serialVersionUID = -9139552003327198846L;

	private Integer id;
	private Exame exame;
	private List<Exame> exames;
	private String mensagem;
	private ExameDao exameDao;
	private Integer idClassificacaoX;
	private List<Classificacao> classificacoes;

	public ExameAction() {
		ClassificacaoDao  classificacaoDao = new ClassificacaoDao();
		classificacoes = classificacaoDao.findAll();
	}

	public String view() throws Exception {
		exameDao = new ExameDao();
		exames = exameDao.findAll();
		if (exames != null) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String prepareInsert() {
		exame = new Exame();
		return SUCCESS;
	}

	public String insert() throws Exception {
		exameDao = new ExameDao();
		if (exame != null) {
			if (exame.getId() == null && exameDao.getByCodigoTuss(exame.getCodigoTuss()) != null) {
				mensagem = CODIGO_EXISTENTE.toString();
				return SUCCESS;
			}

			if (exameDao.save(exame)) {
				mensagem = GRAVADO.toString();
				return SUCCESS;
			}
		}
		mensagem = NAO_GRAVADO.toString();
		return ERROR;
	}

	public String delete() throws Exception {
		exameDao = new ExameDao();

		if (exameDao.deleteById(id)) {
			findAllExame();
			return SUCCESS;
		}
		return ERROR;
	}

	public String prepareEdit() throws Exception {
		exame = new Exame();
		exameDao = new ExameDao();
		Exame exameToUpdate = exameDao.getByID(id);

		exame.setId(exameToUpdate.getId());
		exame.setCodigoTuss(exameToUpdate.getCodigoTuss());
		exame.setNome(exameToUpdate.getNome());

		return SUCCESS;
	}

	public String update() throws Exception {
		exameDao = new ExameDao();

		if (exame != null && exameDao.save(exame)) {
			mensagem = GRAVADO.toString();
			return SUCCESS;
		}
		mensagem = NAO_GRAVADO.toString();
		return ERROR;
	}

	private void findAllExame() {
		exames = new ExameDao().findAll();
	}

	@Override
	public void validate() {

		if (exame != null) {
			if (StringUtils.isEmpty(exame.getNome())) {
				addFieldError("nome", "O Nome não pode ser vazio");
			}

			if (null == exame.getCodigoTuss()) {
				addFieldError("coditoTuss", "O Código TUSS não pode ser vazio");

			}
		}

	}

}
