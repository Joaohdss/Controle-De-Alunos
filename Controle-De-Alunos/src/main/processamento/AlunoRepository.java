package main.processamento;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * Responsavel pelo cadastro de alunos
 * @author joao.soares
 *
 */
public class AlunoRepository {
	private Map<String, Aluno> alunos;
	private Aluno aluno;
	private static final String CADASTRO_REALIZADO = "CADASTRO REALIZADO!";
	private static final String CADASTRADO_ALUNO = "MATRICULA JA CADASTRADA!";
	
	public AlunoRepository() {
		alunos = new HashMap<String, Aluno>();
	}
	/**
	 * 
	 * @param matricula do Aluno
	 * @param curso do Aluno
	 * @param nome do Aluno
	 * @return retorna true se o aluno ja existir e nao sera cadastrado , caso contrario sera cadastrado
	 * @throws Exception - casos dos exception quando algum null ou vazio ocorrer
	 */
	public String adicionaAluno(String matricula, String curso, String nome) throws Exception {
		aluno = new Aluno(matricula, curso, nome);
		if(alunos.containsKey(matricula)){
			return CADASTRADO_ALUNO;
		}
			this.alunos.put(matricula, aluno);
		return CADASTRO_REALIZADO;
		
	}
	/**
	 * 
	 * @param matricula do Aluno
	 * @return retorna uma string vazia se nao existir algum aluno matriculado
	 */
	public String consultaAluno(String matricula) {
		String alunoConsultado = "ALUNO NAO MATRICULADO";
		if(alunos.containsKey(matricula)){
			alunoConsultado = alunos.get(matricula).toString();
		}
		return alunoConsultado;
	}
	/**
	 * O metodo recuperar verifica se um aluno estar cadastrado ou nao
	 * @param matricula do aluno
	 * @return um Aluno
	 */
	public Aluno recuperar(String matricula){
		return alunos.get(matricula);
	}
	/**
	 * Imiprimi uma colecao de pessoas
	 * @return
	 */
	public Collection<Aluno> listar(){
		return alunos.values();
	}
}
