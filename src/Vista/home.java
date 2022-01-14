package Vista;

import java.util.Scanner;
import Modelo.*;

public class home 
{
    private Usuario usuario;
    private Scanner sc = new Scanner(System.in);

    public home(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public void mostrarMenu()
    {
        int opc = 0;
        do
        {
            System.out.println("================================================");
            System.out.println("                MENÚ PRINCIPAL");
            System.out.println("     Sesión Iniciada como: " + usuario.getUsuario());
            System.out.println("================================================");
            System.out.println("");
            
            System.out.println("    1. Administrar Almacén.");
            System.out.println("    2. Administrar Clientes.");
            System.out.println("    3. Administrar Proveedores.");
            System.out.println("    4. Generar Venta.");
            System.out.println("    5. Administrar Facturas.");
            System.out.println("    6. Salir.");
            System.out.println("");
            System.out.println("    Seleccione una opción: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                {
                    almacen Almacen = new almacen();
                    Almacen.mostrarAlmacen();
                    break;
                }
                case 2:
                {
                    clientes Clientes = new clientes();
                    Clientes.mostrarMenu();
                    break;
                }
            }
        }while(opc < 6);
    }    
}