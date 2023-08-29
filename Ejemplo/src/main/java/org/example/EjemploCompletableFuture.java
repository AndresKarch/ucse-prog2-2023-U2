package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

//Ejercicio 3
public class EjemploCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Integer> tarea1 = CompletableFuture.supplyAsync(() -> {
            int numeroAleatorio = ThreadLocalRandom.current().nextInt(100, 501);
            simularProcesamiento(numeroAleatorio);
            return numeroAleatorio;
        });

        CompletableFuture<Integer> tarea2 = CompletableFuture.supplyAsync(() -> {
            int numeroAleatorio = ThreadLocalRandom.current().nextInt(100, 501);
            simularProcesamiento(numeroAleatorio);
            return numeroAleatorio;
        });

        CompletableFuture<Integer> tarea3 = CompletableFuture.supplyAsync(() -> {
            int numeroAleatorio = ThreadLocalRandom.current().nextInt(100, 501);
            simularProcesamiento(numeroAleatorio);
            return numeroAleatorio;
        });

        CompletableFuture<Integer> tarea4 = CompletableFuture.supplyAsync(() -> {
            int numeroAleatorio = ThreadLocalRandom.current().nextInt(100, 501);
            simularProcesamiento(numeroAleatorio);
            return numeroAleatorio;
        });

        CompletableFuture<Integer> todasLasTareas = CompletableFuture.allOf(tarea1, tarea2, tarea3, tarea4)
                .thenApplyAsync(ignorado -> tarea1.join() + tarea2.join() + tarea3.join() + tarea4.join());

        int suma = todasLasTareas.join();
        System.out.println("Suma de los números aleatorios: " + suma);
    }

    private static void simularProcesamiento(int numeroAleatorio) {
        try {
            Thread.sleep(numeroAleatorio);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
