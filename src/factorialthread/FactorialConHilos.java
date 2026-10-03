import java.util.Scanner;
/*
Laboratorio POO Grupo 12
Ejercicio 3
PRÁCTICA 12.   HILOS

1) Realiza un programa que calcule el factorial de un número utilizando hilos. 
Realizado por: Garduño Martinez Monserrat */ 
// Equipo #05
// Integrantes:
// - Aquino Garcia Valente
// - Catalan Alvarado Franky Axhel
// - Garduno Martinez Monserrat
// - Gutierrez Anaya Saul
// - Martinez Perez Lorena
class FactorialThread extends Thread {
    private int numero;
    private long resultado = 1;

    public FactorialThread(int numero) {
        this.numero = numero;
    }
    public void run() {
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
    }
    public long getResultado() {
        return resultado;
    }
}

public class FactorialConHilos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero para calcular su factorial: ");
        int n = sc.nextInt();

        FactorialThread hilo = new FactorialThread(n);

        hilo.start();

        try {
            hilo.join();
        } catch (InterruptedException e) {
            System.out.println("Error en el hilo.");
        }
        System.out.println("El factorial de " + n + " es: " + hilo.getResultado());
    }
}
