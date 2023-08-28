package org.example;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AvionPrivadoTest {

    @Test
    public void testVolar() {
        Avion avion = new AvionPrivado(1000, 10);
        int distanciaViaje = 500;

        int combustibleNecesario = (distanciaViaje * avion.getConsumoCombustible()) + (avion.getCapacidadCombustible() / 2);
        int combustibleConsumido = avion.volar(distanciaViaje);

        assertEquals(combustibleNecesario, combustibleConsumido);
    }
    @Test
    public void testVolarDistanciaCero() {
        AvionPrivado avion = new AvionPrivado(1000, 10);
        int distancia = 0;

        int combustibleNecesario = avion.volar(distancia);

        assertEquals(500, combustibleNecesario);
    }

    @Test
    public void testVolarDistanciaPositiva() {
        AvionPrivado avion = new AvionPrivado(1000, 10);
        int distancia = 200;

        int combustibleNecesario = avion.volar(distancia);

        assertEquals(2500, combustibleNecesario);
    }

    @Test
    public void testVolarCapacidadCombustibleMaxima() {
        AvionPrivado avion = new AvionPrivado(2000, 5);
        int distancia = 100;

        int combustibleNecesario = avion.volar(distancia);

        assertEquals(1500, combustibleNecesario);
    }

}
