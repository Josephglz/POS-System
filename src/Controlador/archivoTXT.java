package Controlador;

import java.io.File;
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
}
