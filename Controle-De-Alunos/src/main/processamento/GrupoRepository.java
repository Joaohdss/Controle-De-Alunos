package main.processamento;


import java.util.ArrayList;
import java.util.List;

import main.exception.NomeNuloOuVazio;
/**
 * Responsavel pelo cadastro dos grupos
 * @author Henrique
 *
 */
public class GrupoRepository {
	private Grupo grupo;
	private List<Grupo> grupos;
	private static final String CADASTRO_REALIZADO = "CADASTRO REALIZADO!";
	private static final String CADASTRADO_GRUPO = "GRUPO JA CADASTRADO!";
	private static final String GRUPO_NAO_CADASTRADO = "GRUPO NAO CADASTRADO";
	
	public GrupoRepository() {
		this.grupos = new ArrayList<>();
	}
	/**
	 * Metodo criado para adicionar um grupo para uma lista
	 * @param nome do grupo
	 * @return
	 * @throws Exception 
	 */
	public String adiciona(String nome)throws Exception{
		if(nome.trim().equals("")){
			throw new NomeNuloOuVazio("Nome do grupo nulo ou vazio");
		}
		grupo = new Grupo(nome);
		if (grupos.contains(grupo)) {
			return CADASTRADO_GRUPO;
		}
		grupos.add(grupo);
		return CADASTRO_REALIZADO;
	}
	/**
	 * 
	 * @param nome do grupo
	 * @return um Grupo
	 */
	public Grupo recuperar(String nome){
		Grupo grupoRecuperar = null;
		for (Grupo grupo : grupos) {
			if (grupo.getNome().equals(nome)) {
				grupoRecuperar = grupo;
			}
		}
		return grupoRecuperar;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
}

