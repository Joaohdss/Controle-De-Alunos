package teste;

import static org.junit.Assert.*;
import main.exception.CursoNuloOuVazio;
import main.exception.MatriculaNulaOuVazia;
import main.exception.NomeNuloOuVazio;
import main.processamento.AlunoRepository;

import org.junit.Before;
import org.junit.Test;

public class TestAlunoRepository{
	private AlunoRepository alunoRepository;
	private static final String CADASTRO_REALIZADO = "CADASTRO REALIZADO!";
	private static final String CADASTRADO_ALUNO = "MATRICULA JA CADASTRADA!";
	@Before
	public void setup(){
		alunoRepository = new AlunoRepository();
		
	}
	@Test
	public void TestAlunoControllerException() throws Exception{
		try {
			alunoRepository.adicionaAluno("", "Historia", "Pedro");
			fail("Matricula nula ou vazia");
		} catch (MatriculaNulaOuVazia e) {
			assertEquals("Matricula nula ou vazia", e.getMessage());
		}
		try {
			alunoRepository.adicionaAluno("587464", "", "Pedro");
			fail("Curso nulo ou vazio");
		} catch (CursoNuloOuVazio e) {
			assertEquals("Curso nulo ou vazio", e.getMessage());
		}
		try {
			alunoRepository.adicionaAluno("2501312", "Computacao", "");
			fail("Nome nulo ou vazio");
		} catch (NomeNuloOuVazio e) {
			assertEquals("Nome nulo ou vazio", e.getMessage());
		}
	}
	@Test
	public void testAlunoController() throws Exception {
		assertEquals(CADASTRO_REALIZADO,(alunoRepository.adicionaAluno("250", "Pedro", "Historia")));
		assertEquals(CADASTRADO_ALUNO,(alunoRepository.adicionaAluno("250", "Pedro", "Geografia")));

	}
	@Test
	public void testConsultaAluno() throws Exception{
		alunoRepository.adicionaAluno("2501312", "Computacao", "Henrique");
		assertEquals("ALUNO NAO MATRICULADO", alunoRepository.consultaAluno("2501"));
		alunoRepository.adicionaAluno("2501312", "Computacao", "Henrique");
		assertEquals("Aluno : 2501312 - Henrique - Computacao", alunoRepository.consultaAluno("2501312"));
	}

}