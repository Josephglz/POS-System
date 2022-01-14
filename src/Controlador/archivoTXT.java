package Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class archivoTXT 
{
    public boolean Existe(String ruta)
    {
        File archivo = new File(ruta);
        if(archivo.exists())
        {
            return true;
        }
        return false;
    }

    public String leerArchivo(String ruta)
    {
        String texto = "";
        try
        {
            File archivo = new File(ruta);
            if(archivo.exists())
            {
                Scanner sc = new Scanner(archivo);
                while(sc.hasNextLine())
                {
                    texto += sc.nextLine() + "\n";
                }
                sc.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al leer el archivo");
        }

        return texto;
    }

    public void guardarArchivo(String nombreArchivo, String contenido)
    {
        try
        {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists())
            {
                archivo.createNewFile();
            }
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        }
        catch (Exception e)
        {
            System.out.println("Error al editar archivo: " + e.getMessage());
        }
    } 
}
