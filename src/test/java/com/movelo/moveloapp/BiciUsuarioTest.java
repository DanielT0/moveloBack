package com.movelo.moveloapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BiciUsuarioTest {
    private Biciusuario usuario = new Biciusuario("1001231231", "Carlos", "Calle 25", "23231343", "carlos@gmail.com",
            "12345");
    private Arbol arbol = new Arbol("Roble", "Roblius", 20.3);

    @Test
    public void getCcTest() {
        assertEquals("1001231231", usuario.getCc());
    }

    @Test
    public void setCcTest() {
        usuario.setCc("123");
        assertEquals("123", usuario.getCc());
    }

    @Test
    public void getNombreTest() {
        assertEquals("Carlos", usuario.getNombre());
    }

    @Test
    public void setNombreTest() {
        usuario.setNombre("Luis");
        assertEquals("Luis", usuario.getNombre());
    }

    @Test
    public void getDireccionTest() {
        assertEquals("Calle 25", usuario.getDireccion());
    }

    @Test
    public void setDireccionTest() {
        usuario.setDireccion("Calle 32");
        assertEquals("Calle 32", usuario.getDireccion());
    }

    @Test
    public void getTelTest() {
        assertEquals("23231343", usuario.getTelefono());
    }

    @Test
    public void setTelTest() {
        usuario.setDireccion("2312345");
        assertEquals("2312345", usuario.getDireccion());
    }

    @Test
    public void getHuellaTest() {
        assertEquals(0.0, usuario.getHuellaCarbonoAcumulada());
    }

    @Test
    public void setHuellaTest() {
        usuario.setHuellaCarbonoAcumulada(103.3);
        assertEquals(103.3, usuario.getHuellaCarbonoAcumulada());
    }

    @Test
    public void getMetrosNoPlantadosTest() {
        assertEquals(0, usuario.getMetrosNoPlantados());
    }

    @Test
    public void setMetrosNoPlantadosTest() {
        usuario.setMetrosNoPlantados(100);
        assertEquals(100, usuario.getMetrosNoPlantados());
    }

    @Test
    public void getKmRecorridoTest() {
        assertEquals(0.0, usuario.getkmRecorridos());
    }

    @Test
    public void gsetKmRecorridoTest() {
        usuario.setMetrosNoPlantados(100);
        assertEquals(100, usuario.getMetrosNoPlantados());
    }

    @Test
    public void addArbolTest() {
        Biciusuario esperado = usuario;
        usuario.addArbol(arbol);
        esperado.addArbol(arbol);
        assertEquals(esperado, usuario);
    }

}
