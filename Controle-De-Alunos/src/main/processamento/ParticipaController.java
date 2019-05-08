package main.processamento;

import main.exception.NomeNuloOuVazio;

public class ParticipaController {
	private AlunoRepository alunoRepository;
	private GrupoRepository grupoRepository;
	private QuadroVerde responderam;
	private static final String GRUPO_NAO_EXISTE = "GRUPO NAO EXISTE!";
	private static final String ALUNO_NAO_REGISTRADO = "ALUNO NAO REGISTRADO";

	public ParticipaController() {
		this.alunoRepository = new AlunoRepository();
		this.grupoRepository = new GrupoRepository();
		this.responderam = new QuadroVerde();
	}
	/**
	 * Metodo criado para criar um aluno e por em uma lista
	 * chama o metodo adicionaAluno da classe AlunoRepository
	 * @param matricula do aluno 
	 * @param curso do aluno
	 * @param nome do aluno
	 * @return uma string avisando se o cadastro foi efetuado com sucesso
	 * @throws Exception ocorre um lancamento de exception caso matricula, curso ou nome seja nulo ou vazio.
	 */
	public String adicionaAluno(String matricula, String curso, String nome) throws Exception {
		return alunoRepository.adicionaAluno(matricula, curso, nome);
	}
	/**
	 * Metodo criado para criar um grupo e add em uma lista
	 * chama o metodo adiciona da classe GrupoRepository
	 * @param nome do grupo
	 * @return uma string avisando se o cadastro foi efetuado com sucesso
	 * @throws Exception 
	 */
	public String adicionaGrupo(String nome) throws Exception {
		return grupoRepository.adiciona(nome);
	}
	public String consultaAluno(String matricula) {
		return alunoRepository.consultaAluno(matricula);
	}
	/**
	 * 
	 * @param nomeDoGrupo do grupo 
	 * @param matricula do aluno 
	 * @return uma String caso associe o aluno ou nao
	 */
	public String associarAlunoGrupo(String nomeDoGrupo, String matricula) {
		if (grupoRepository.recuperar(nomeDoGrupo) != null) {
			if (alunoRepository.recuperar(matricula) != null) {
				Aluno aluno = alunoRepository.recuperar(matricula);
				return grupoRepository.recuperar(nomeDoGrupo).addAssociado(aluno);
			}
		}
		if (grupoRepository.recuperar(nomeDoGrupo) == null){
			return GRUPO_NAO_EXISTE;
		}
		return  ALUNO_NAO_REGISTRADO ;
	}
	/**
	 * Metodo criado para imprimir um determinado grupo e sua lista
	 * chamando o metodo recuperar da classe GrupoRepository
	 * @param nome do grupo
	 * @return
	 */
	public String imprimiAssociadosGrupo(String nome) {
		if (grupoRepository.recuperar(nome) == null) {
			return GRUPO_NAO_EXISTE;
		}
		return grupoRepository.recuperar(nome).imprimiAssociado();
	}
	/**
	 * Metodo criado para add os alunos que responderam no quadro
	 * chamando o metodo addAluno da classe QuadroVerde
	 * @param matricula do aluno
	 * @return
	 */
	public String addResponderam(String matricula) {
		if (alunoRepository.recuperar(matricula) != null) {
			Aluno aluno = alunoRepository.recuperar(matricula);
			return responderam.addAluno(aluno);
		}
		return ALUNO_NAO_REGISTRADO ;
	}
	/**
	 * Metodo criado para imprimi uma lista de alunos
	 * que responderam no quadro
	 * @return uma lista de alunos
	 */
	public String imprimiResponderam() {
		return responderam.imprimiAssociado();
	}
}
