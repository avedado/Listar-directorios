package edu.teis;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Ordenaciones {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la ruta del fichero:");
        Path path = Paths.get(scanner.nextLine());

        Map<String, Comparator<String>> opcionesOrden = new HashMap<>();
        opcionesOrden.put("ascinsensitive", String.CASE_INSENSITIVE_ORDER);
        opcionesOrden.put("descinsensitive", String.CASE_INSENSITIVE_ORDER.reversed());
        opcionesOrden.put("ascsensitive", Comparator.naturalOrder());
        opcionesOrden.put("descsensitive", Comparator.reverseOrder());

        System.out.println("Ingresa el tipo de orden (ascinsensitive, descinsensitive, ascsensitive, descsensitive):");
        String ordenString = scanner.nextLine().toLowerCase().trim();

        if (!Files.exists(path)) {
            System.out.println("La ruta no existe en el sistema.");
            return;
        }

        try {
            List<String> lineas = Files.readAllLines(path);
            Comparator<String> comparador = opcionesOrden.get(ordenString);

            if (comparador == null) {
                System.out.println("Orden no reconocido, se usará ascendente insensible por defecto.");
                comparador = opcionesOrden.get("ascinsensitive");
                ordenString = "ascinsensitive";
            }

            List<String> lineasOrdenadas = lineas.stream()
                    .sorted(comparador)
                    .collect(Collectors.toList());


            String nombreOriginal = path.getFileName().toString();
            String nombreSinExtension = nombreOriginal.contains(".") ? nombreOriginal.substring(0, nombreOriginal.lastIndexOf('.')) : nombreOriginal;
            String extension = nombreOriginal.contains(".") ? nombreOriginal.substring(nombreOriginal.lastIndexOf('.')) : "";

            String nombreResultado = nombreSinExtension + "_" + ordenString + extension;
            Path resultadoPath = path.getParent().resolve(nombreResultado);

            Files.write(resultadoPath, lineasOrdenadas);

            System.out.println("Archivo ordenado guardado en: " + resultadoPath.toString());

        } catch (IOException e) {
            System.out.println("No se ha podido abrir o escribir el fichero.");
        }
    }
}