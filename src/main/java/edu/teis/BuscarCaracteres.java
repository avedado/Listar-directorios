package edu.teis;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BuscarCaracteres {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la ruta del fichero:");
        String ruta = scanner.nextLine();

        System.out.println("Ingresa el carácter a contar:");
        String caracter = scanner.nextLine();

        if (caracter.length() != 1) {
            System.out.println("Por favor, introduce solo un carácter.");
            return;
        }

        int contador = 0;

        try (FileReader file = new FileReader(ruta)) {
            int index;
            while ((index = file.read()) != -1) {
                String caracterLeido = String.valueOf((char) index);
                if (caracterLeido.equals(caracter)) {
                    contador++;
                }
            }

            System.out.println("El carácter '" + caracter + "' aparece " + contador + " veces.");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
