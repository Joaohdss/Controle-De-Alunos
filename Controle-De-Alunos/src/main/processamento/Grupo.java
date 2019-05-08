package main.processamento;

import java.util.ArrayList;
import java.util.List;

import main.exception.MatriculaNulaOuVazia;
import main.exception.NomeNuloOuVazio;

public class Grupo {

	private String nome;
	private List<Aluno> associados;

	public Grupo(String nome) throws Exception {
		if (nome.trim().equals("") || nome == null) {
			throw new NomeNuloOuVazio("Nome nulo ou vazio");
		}
		
		this.nome = nome;
		this.associados = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String addAssociado(Aluno aluno) {
		if(associados.contains(aluno)){
			return  "JA ALOCADO";
		}
		this.associados.add(aluno);
		return "ALUNO ALOCADO!";
	}
	public String imprimiAssociado(){
		if(associados.size() < 1){
			return "NENHUM ALUNO NO GRUPO!";
		}
		String listaDeAssociados = "";
		for (Aluno aluno : associados) {
			listaDeAssociados += "* "+ aluno.toString() +"\n";
		}
		return "Grupos : "+ getNome()+ "\nAlunos do grupo " + getNome() + ": \n"+ listaDeAssociados;
	}

	@Override
	public String toString() {
		return "Grupo : " + nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
