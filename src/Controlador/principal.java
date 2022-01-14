package Controlador;

import Vista.*;

public class principal 
{
    public static void main(String[] args) 
    {
        archivoTXT archivos = new archivoTXT();
        cHerramienta herramienta = new cHerramienta();

        System.out.println("================================================");
        System.out.println("");
        System.out.println("          SISTEMA DE PUNTO DE VENTA");
        System.out.println("");
        System.out.println("================================================");
        System.out.println("");

        Login login = new Login(herramienta.cargarUsuarios(archivos.leerArchivo("src\\BD\\usuarios.txt")));
        login.mostrarLogin();
        
    }    
}
