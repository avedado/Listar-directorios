package edu.teis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cuestionarios {
    public static void main(String[] args) {

        try {

            List<String> lineas = Files.readAllLines(Paths.get("C://Users//Maria//OneDrive//Escritorio//DAM//PR//java//directorios//src//main//java//edu//teis//res//test.txt"));
            String respuestas = lineas.getFirst();
            Map<String, String> examenes = new HashMap<>();

            lineas.forEach(line -> {
                String[] linea = line.split(" ", 2);
                if (linea.length < 2) {
                    System.out.println("Formato incorrecto");
                };


            });

        } catch (
                IOException e) {
            System.out.println("No se ha podido abrir el fichero.");
        }
    }
}
