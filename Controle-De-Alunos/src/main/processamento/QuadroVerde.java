package main.processamento;

import java.util.ArrayList;
import java.util.List;
/**
 * Responsavel pelo cadastro de alunos que responderam no quadro
 *
 */
public class QuadroVerde {
	
	private List<Aluno> responderam;
	private static final String ALUNO_REGISTRADO = "ALUNO REGISTRADO!";
	private static final String ALUNO_JA_R = "ALUNO JA REGISTRADO!";

	public QuadroVerde() {
		this.responderam = new ArrayList<Aluno>();
	}
	/**
	 * Add alunos que responderam no quadro
	 * @param aluno
	 * @return
	 */
	
	public String addAluno(Aluno aluno){
		if(responderam.contains(aluno)){
			return ALUNO_JA_R;
		}
		this.responderam.add(aluno);
		return ALUNO_REGISTRADO;
	}
	/**
	 * Imprimi lista de alunos que responderam no quadro
	 * @return
	 */
	public String imprimiAssociado(){
		String listaDeAssociados = "";
		if(responderam.size() < 1){
			return "Nenhum aluno respondeu";
		}
		int contador = 1 ;
		for (Aluno aluno : responderam) {
			listaDeAssociados += contador +".  "+ aluno.toString() +"\n";
			contador ++;
		}
		
		return "\nAlunos : \n"+ listaDeAssociados;
	}
}
