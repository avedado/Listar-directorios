package edu.teis;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class ListarDirectorio
{
    public static void main( String[] args )
    {
        System.out.println("Introduce el directorio ");
        Scanner scanner = new Scanner(System.in);
        String ruta = scanner.nextLine();
        Path dir = Path.of(ruta);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir);)
        {
        for (Path fichero: stream) {
            String Type;
            if (Files.isDirectory(fichero)) Type = "d"; else Type = "-";

            String Permissions = "";
            if (Files.isReadable(fichero)) {
                Permissions += "r";
            } else {
                Permissions += "-";
            }

            if (Files.isWritable(fichero)) {
                Permissions += "w";
            } else {
                Permissions += "-";
            }
            if (Files.isExecutable(fichero)) {
                Permissions += "e";
            } else {
                Permissions += "-";
            }
            System.out.println(Type + Permissions + " " + fichero.getFileName());
        }
        } catch (IOException exception) {
            System.err.println(exception.getMessage() + " no es un directorio");
        }
    }
}


