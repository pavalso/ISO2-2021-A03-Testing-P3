package A03.P3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class Ej3Test {
	
	static String EXPECTED_MESSAGE = "Range must be from 0 to 100";

	@Test
	public void testGet_range() throws IOException {
		int input0 = Ej3.get_range(0);
		int input1 = Ej3.get_range(1);
		int input10 = Ej3.get_range(10);
		int input35 = Ej3.get_range(35);
		int input50 = Ej3.get_range(50);
		int input70 = Ej3.get_range(70);
		int input90 = Ej3.get_range(90);
		int input100 = Ej3.get_range(100);
		int input99 = Ej3.get_range(99);
		assertTrue(throwsExcpt(-1));
		assertTrue(throwsExcpt(101));
		assertTrue(throwsExcpt(10000));
		assertTrue(throwsExcpt(-10000));
		assertEquals(0, input0);
		assertEquals(0, input1);
		assertEquals(1, input10);
		assertEquals(2, input35);
		assertEquals(3, input50);
		assertEquals(4, input70);
		assertEquals(5, input90);
		assertEquals(5, input100);
		assertEquals(5, input99);
	}

	public boolean throwsExcpt(int input) {
		try {
			Ej3.get_range(input);
		} catch (Exception e) {
			return true;
		}
		return false;
	}
}
