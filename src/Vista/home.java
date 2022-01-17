package Vista;

import java.util.Scanner;
import Modelo.Usuario;

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
            System.out.println("    4. Administrar Ventas.");
            System.out.println("    5. Salir.");
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
                case 3:
                {
                    proveedores Proveedores = new proveedores();
                    Proveedores.mostrarMenu();
                    break;
                }
                case 4:
                {
                    venta Venta = new venta(usuario);
                    Venta.mostrarMenu();
                    break;
                }
                case 5:
                {
                    System.out.println("================================================");
                    System.out.println("                CERRANDO SESIÓN");
                    System.out.println("================================================");
                    break;
                }
            }
        }while(opc < 5);
    }    
}