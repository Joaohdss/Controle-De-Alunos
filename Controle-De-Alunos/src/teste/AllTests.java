package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAlunoRepository.class, TestGrupoRepository.class,
		TestParticipaController.class })
public class AllTests {

}
