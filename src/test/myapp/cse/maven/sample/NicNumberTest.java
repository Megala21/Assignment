package cse.maven.sample;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cse.maven.exception.*;
import static org.testng.Assert.assertEquals;

public class NicNumberTest {
	
	@Test
	public class NICInterpreterTest {

		NicInterpreter interpreter;

		@BeforeClass
		public void setUp() {
			interpreter = new NicInterpreter();
		}

		@Test
		public void createBmiTest1() throws InvalidNicException {
			Initializing init = interpreter.getDetails("917242453v");
			assertEquals(init.getGender(), "Female");
		}

		@Test(expectedExceptions = InvalidNicException.class)
		public void createBmiTest2() throws InvalidNicException {
			Initializing init = interpreter.getDetails("fsdfsdfsdf");
		}

		@Test
		public void testCalculate1() throws InvalidNicException {
			Initializing init = interpreter.getDetails("917242453v");
			assertEquals(init.getYear(), 1991);
		}

	}

}
