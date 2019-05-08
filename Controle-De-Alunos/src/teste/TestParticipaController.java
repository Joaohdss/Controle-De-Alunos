package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.exception.NomeNuloOuVazio;
import main.processamento.AlunoRepository;
import main.processamento.GrupoRepository;
import main.processamento.ParticipaController;
import main.processamento.QuadroVerde;

public class TestParticipaController {
	ParticipaController participa;
	private static final String CADASTRO_REALIZADO = "CADASTRO REALIZADO!";
	private static final String CADASTRADO_ALUNO = "MATRICULA JA CADASTRADA!";
	private static final String CADASTRADO_GRUPO = "GRUPO JA CADASTRADO!";
	private static final String ALUNO_NAO_REGISTRADO = "ALUNO NAO REGISTRADO";
	private static final String GRUPO_NAO_EXISTE = "GRUPO NAO EXISTE!";
	private static final String ALUNO_REGISTRADO = "ALUNO REGISTRADO!";
	private static final String ALUNO_JA_R = "ALUNO JA REGISTRADO!";

	@Before
	public void setup() {
		this.participa = new ParticipaController();
	}

	@Test
	public void testAdicionaAluno() throws Exception {
		assertEquals(CADASTRO_REALIZADO, participa.adicionaAluno("123456", "Historia", "Joao Henrique"));
		assertEquals(CADASTRADO_ALUNO, participa.adicionaAluno("123456", "Historia", "Joao Henrique"));
	}

	@Test
	public void testAdicionaGrupo() throws Exception {
		assertEquals(CADASTRO_REALIZADO, participa.adicionaGrupo("Corrida naruto"));
		assertEquals(CADASTRADO_GRUPO, participa.adicionaGrupo("Corrida naruto"));
	}

	@Test
	public void testConsultaAluno() throws Exception {
		assertEquals("ALUNO NAO MATRICULADO", participa.consultaAluno("1231456"));
		assertEquals("ALUNO NAO MATRICULADO",  participa.consultaAluno(""));
		participa.adicionaAluno("123456", "Computacao", "Joao Henrique");
		assertEquals("Aluno : 123456 - Joao Henrique - Computacao",  participa.consultaAluno("123456"));
		
	}

	@Test
	public void testAssociarAlunoGrupo() throws Exception {
		assertEquals(GRUPO_NAO_EXISTE, participa.associarAlunoGrupo("bola", "14564"));
		participa.adicionaGrupo("Corrida naruto");
		assertEquals(ALUNO_NAO_REGISTRADO, participa.associarAlunoGrupo("Corrida naruto", "14564"));
		participa.adicionaAluno("123456", "Computacao", "Joao Henrique");
		assertEquals("ALUNO ALOCADO!", participa.associarAlunoGrupo("Corrida naruto", "123456"));
		
	}

	@Test
	public void testImprimiAssociadosGrupo() throws Exception {
		participa.adicionaGrupo("Corrida naruto");
		participa.adicionaAluno("123456", "Computacao", "Joao Henrique");
		assertEquals("GRUPO NAO EXISTE!", participa.imprimiAssociadosGrupo("Bola7"));
		assertEquals("NENHUM ALUNO NO GRUPO!", participa.imprimiAssociadosGrupo("Corrida naruto"));
		participa.associarAlunoGrupo("Corrida naruto", "123456");
		assertEquals("Grupos : Corrida naruto\nAlunos do grupo Corrida naruto: \n"
				+ "* Aluno : 123456 - Joao Henrique - Computacao\n", participa.imprimiAssociadosGrupo("Corrida naruto"));
	}

	@Test
	public void testAddResponderam() throws Exception {
		participa.adicionaAluno("123456", "Computacao", "Joao Henrique");
		participa.adicionaAluno("123", "Eng. civil", "Redson");
		assertEquals(ALUNO_NAO_REGISTRADO, participa.addResponderam("212"));
		assertEquals(ALUNO_REGISTRADO, participa.addResponderam("123"));
		assertEquals(ALUNO_REGISTRADO, participa.addResponderam("123456"));
		assertEquals(ALUNO_JA_R, participa.addResponderam("123456"));
		assertEquals(ALUNO_JA_R, participa.addResponderam("123"));
	}

	@Test
	public void testImprimiResponderam() throws Exception {
		participa.adicionaAluno("123456", "Computacao", "Joao Henrique");
		participa.adicionaAluno("123", "Eng. civil", "Redson");
		assertEquals("Nenhum aluno respondeu", participa.imprimiResponderam());
		participa.addResponderam("123456");
		participa.addResponderam("123");
		assertEquals("\nAlunos : \n1.  Aluno : 123456 - Joao Henrique - Computacao\n2.  Aluno : 123 - Redson - Eng. civil\n", participa.imprimiResponderam());
		
	}

}
