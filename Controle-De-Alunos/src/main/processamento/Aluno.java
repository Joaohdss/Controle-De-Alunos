package main.processamento;

import main.exception.CursoNuloOuVazio;
import main.exception.MatriculaNulaOuVazia;
import main.exception.NomeNuloOuVazio;

public class Aluno {
	
	private String matricula;
	private String curso;
	private String nome;
	
	public Aluno(String matricula, String curso, String nome) throws Exception {
		if (matricula.trim().equals("") || matricula == null) {
			throw new MatriculaNulaOuVazia("Matricula nula ou vazia");
		}
		if (curso.trim().equals("")) {
			throw new CursoNuloOuVazio("Curso nulo ou vazio");
		}
		if (nome.trim().equals("")) {
			throw new NomeNuloOuVazio("Nome nulo ou vazio");
		}
		this.matricula = matricula;
		this.curso = curso;
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "Aluno : " + matricula + " - " + nome + " - "+ curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	

}
