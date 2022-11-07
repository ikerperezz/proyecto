package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Clases.Usuario;
import Clases.UsuarioPublico;

public class UsuarioPublicoTest {

	@Test
	public void testGetIdLiga() {
		UsuarioPublico u = new UsuarioPublico("jigoa", "123j", "a1",1000000);
		assertEquals("a1", u.getIdLiga());
	}
	@Test
	public void testGetDineroDisponible() {
		UsuarioPublico u = new UsuarioPublico("jigoa", "123j", "a1",1000000);
		assertEquals(1000000, u.getDineroDisponible());
	}
	@Test
	public void testSetIdLiga() {
		UsuarioPublico u = new UsuarioPublico("jigoa", "123j", "a1",1000000);
		u.setIdLiga("a2");
		assertEquals("a2", u.getIdLiga());
	}
	@Test
	public void testSetDineroDisponible() {
		UsuarioPublico u = new UsuarioPublico("jigoa", "123j", "a1",1000000);
		u.setDineroDisponible(99000000);
		assertEquals(99000000, u.getDineroDisponible());
	}

}
