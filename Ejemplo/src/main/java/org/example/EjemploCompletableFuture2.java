package org.example;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

//Ejercicio 4
public class EjemploCompletableFuture2 {
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

        CompletableFuture<Object> tareaMasRapida = CompletableFuture.anyOf(tarea1, tarea2, tarea3, tarea4);

        try {
            int valorMasRapido = (int) tareaMasRapida.get();
            System.out.println("Valor de la tarea más rápida: " + valorMasRapido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void simularProcesamiento(int numeroAleatorio) {
        try {
            Thread.sleep(numeroAleatorio);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
