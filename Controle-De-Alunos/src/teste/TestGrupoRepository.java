package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import main.processamento.Grupo;
import main.processamento.GrupoRepository;

	
public class TestGrupoRepository {
	private GrupoRepository grupoRepository;
	private static final String CADASTRO_REALIZADO = "CADASTRO REALIZADO!";
	private static final String CADASTRADO_GRUPO = "GRUPO JA CADASTRADO!";
	@Before
	public void setup(){
		this.grupoRepository = new GrupoRepository();
	}
	@Test
	public void testAdiciona() throws Exception {
		assertEquals(CADASTRO_REALIZADO, grupoRepository.adiciona("Lista"));
		assertEquals(CADASTRADO_GRUPO, grupoRepository.adiciona("Lista"));
		assertEquals(CADASTRO_REALIZADO, grupoRepository.adiciona("Lab0"));
	}
	@Test
	public void testRecuperar() throws Exception {
		assertEquals(null, grupoRepository.recuperar("Lista"));
		grupoRepository.adiciona("Lista");
		Grupo grupo = grupoRepository.recuperar("Lista");
		assertEquals(grupo,grupoRepository.recuperar("Lista"));
		
	}

}
