package org.example;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadorCombustibleTest {

    @Test
    public void testCalcularCombustible() {
        Avion avionMock = mock(Avion.class);
        when(avionMock.volar(500)).thenReturn(100);

        CalculadorCombustible calculador = CalculadorCombustible.getInstance();
        int combustibleCalculado = calculador.calcularCombustible(avionMock, 500);

        assertEquals(100, combustibleCalculado);
    }
    @Test
    public void testGetInstance() {
        CalculadorCombustible instance1 = CalculadorCombustible.getInstance();
        CalculadorCombustible instance2 = CalculadorCombustible.getInstance();

        assertEquals(instance1, instance2);
    }
}

