package hansolo.test.marioparty.Usuario;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import hansolo.marioparty.admin.Usuario;

public class UsuarioTest {
	Usuario test1;

	@Test
	public void test() {
		this.test1=new Usuario("Prueba Nro1");
		Assert.assertEquals("Prueba Nro1", test1.getNombre());
		this.test1.setNombre("Nuevo Nombre");
		Assert.assertEquals("Nuevo Nombre",test1.getNombre());
	}

}
