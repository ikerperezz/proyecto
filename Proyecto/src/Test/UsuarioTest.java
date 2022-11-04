package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Clases.Usuario;

public class UsuarioTest {

	@Test
	public void testGetUsuario() {
		Usuario u = new Usuario("jigoa", "123j");
		assertEquals("jigoa", u.getUsuario());
	}
	@Test
	public void testGetContraseina() {
		Usuario u = new Usuario("jigoa", "123j");
		assertEquals("123j", u.getContraseina());
	}
	@Test
	public void testSetUsuario() {
		Usuario u = new Usuario("jigoa", "123j");
		u.setUsuario("iperez");
		assertEquals("iperez", u.getUsuario());
	}
	@Test
	public void testSetContraseina() {
		Usuario u = new Usuario("jigoa", "123j");
		u.setContraseina("123i");
		assertEquals("123i", u.getContraseina());
	}
}
