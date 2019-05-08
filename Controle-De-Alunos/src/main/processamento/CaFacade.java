package main.processamento;

import main.exception.NomeNuloOuVazio;

/**
 * Classe responsavel pela interacao do administrador com o programa
 */
public class CaFacade {

	private ParticipaController participa;
	public CaFacade() {
		participa = new ParticipaController();
	}
	/**
	 * 
	 * @param matricula do aluno
	 * @param curso do aluno
	 * @param nome do aluno
	 * @return
	 * @throws Exception
	 */
	public String cadastroAluno(String matricula, String curso, String nome) throws Exception {
		return participa.adicionaAluno(matricula, curso, nome);
	}
	/**
	 * 
	 * @param matricula do aluno
	 * @return
	 */
	public String consultaAluno(String matricula) {
		return participa.consultaAluno(matricula);
	}
	/**
	 * 
	 * @param nome do grupo
	 * @return
	 * @throws Exception 
	 */
	public String cadastrarGrupo(String nome) throws Exception {
		return participa.adicionaGrupo(nome);
	}
	/**
	 * Metodo para associar aluno a um grupo
	 * @param nome do grupo
	 * @param matricula do aluno
	 * @return uma string
	 */
	public String associaAlunoG(String nome,String matricula){
		return participa.associarAlunoGrupo(nome, matricula);
	}
	/**
	 * 
	 * @param nome
	 * @return
	 */
	public String imprimiAssociadoGrupo(String nome){
		return participa.imprimiAssociadosGrupo(nome);
	}
	public String associaAlunoQuadroVerde(String matricula){
		return participa.addResponderam(matricula);
	}
	public String imprimiAlunosQuadroVerde(){
		return participa.imprimiResponderam();
	}
}