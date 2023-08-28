package org.example;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AvionComercialTest {

    @Test
    public void testVolar() {
        Avion avion = new AvionComercial(1000, 10);
        int distanciaViaje = 500;

        int combustibleNecesario = distanciaViaje * avion.getConsumoCombustible();
        int combustibleConsumido = avion.volar(distanciaViaje);

        assertEquals(combustibleNecesario, combustibleConsumido);
    }

    @Test
    public void testVolarDistanciaCero() {
        AvionComercial avion = new AvionComercial(1000, 10);
        int distancia = 0;

        int combustibleNecesario = avion.volar(distancia);

        assertEquals(0, combustibleNecesario);
    }

    @Test
    public void testVolarDistanciaPositiva() {
        AvionComercial avion = new AvionComercial(1000, 10);
        int distancia = 200;

        int combustibleNecesario = avion.volar(distancia);

        assertEquals(2000, combustibleNecesario);
    }
}
