package main.tela;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.processamento.CaFacade;

/**
 * 
 * @author joao.soares Matricula : 116110572 
 * Disciplina: Laboratorio de Programacao 2 Lab03 - 2017.1
 */
public class Tela {
	private static CaFacade menu;
	
	public static void main(String[] args) throws Exception {
		String matricula;
		String nome;
		String curso;
		String nomeDoGrupo;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		menu = new CaFacade();
		while (true) {

			System.out.println("\n(C)adastrar Aluno\n" + "(E)xibir Aluno\n" + "(N)ovo Grupo\n"
					+ "(A)locar Aluno no Grupo\n" + "(R)egistrar Resposta de Aluno\n"
					+ "(I)mprimir Alunos que Responderam\n" + "(O)ra, vamos fechar o programa!\n");
			System.out.print("\nOpcao> ");

			String entrada = input.readLine();
			
			if (entrada.equalsIgnoreCase("o")) {
				break;
			} else if (entrada.equalsIgnoreCase("c")) {
				
				System.out.print("\nMatricula: ");
				matricula = input.readLine();
				System.out.print("Nome: ");
				nome = input.readLine();
				System.out.print("Curso: ");
				curso = input.readLine();
				System.out.println(menu.cadastroAluno(matricula, curso, nome));
				
			} else if (entrada.equalsIgnoreCase("e")) {
				
				matricula = input.readLine();
				System.out.println(menu.consultaAluno(matricula));
			}
			
			else if (entrada.equalsIgnoreCase("n")) {
				nomeDoGrupo = input.readLine();
				System.out.println(menu.cadastrarGrupo(nomeDoGrupo));
			}
			else if (entrada.equalsIgnoreCase("a")) {
				System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
				String letra = input.readLine();
			
				if (letra.equalsIgnoreCase("a")) {
					System.out.print("Nome do Grupo : ");
					nomeDoGrupo = input.readLine();
					System.out.print("Matricula do aluno : ");
					matricula = input.readLine();
					
					System.out.println(menu.associaAlunoG(nomeDoGrupo, matricula));
				}else if(letra.equalsIgnoreCase("i")){
					System.out.print("Nome do Grupo : ");
					nomeDoGrupo = input.readLine();
					System.out.println(menu.imprimiAssociadoGrupo(nomeDoGrupo));
					
				}else{
					System.out.println("Invalido");
				}
				
			}else if(entrada.equalsIgnoreCase("r")){
				System.out.print("Matricula do aluno : ");
				matricula = input.readLine();
				System.out.println(menu.associaAlunoQuadroVerde(matricula));
			}else if(entrada.equalsIgnoreCase("i")){
				System.out.println(menu.imprimiAlunosQuadroVerde());
			}
			
			else {
				System.out.print("OPCAO INVALIDA!\n \n");
			}

		}
	}

}