package Vista;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.archivoTXT;
import Controlador.cHerramienta;

import Modelo.Suplidores;

public class proveedores 
{
    ArrayList<Suplidores> suplidores = new ArrayList<Suplidores>();
    cHerramienta herramienta = new cHerramienta();
    archivoTXT archivo = new archivoTXT();
    Scanner sc = new Scanner(System.in);

    public proveedores()
    {
        cargarProveedores();
    }

    public void cargarProveedores()
    {
        try
        {
            suplidores = herramienta.cargarSuplidores(archivo.leerArchivo("proveedores.txt"));
        }
        catch(ParseException e)
        {
            System.out.println("Error al cargar proveedores: " + e.getMessage());
        }
    }

    public void agregarProveedor()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("                AGREGAR PROVEEDOR");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("Ingrese la Empresa del Proveedor: ");
            String empresa = herramienta.getInputString();
            System.out.println("Ingrese el Prestablecimiento: ");
            String prestablecimiento = herramienta.getInputString();
            System.out.println("Ingrese el Estado del Proveedor (SI/NO): ");
            String activo = herramienta.getInputString();

            String datos = suplidores.size() + "," + empresa + "," + prestablecimiento + "," + activo + "," + suplidores.size() + "\n";
            archivo.guardarArchivo("proveedores.txt", datos);

            suplidores.add(new Suplidores(suplidores.size(), empresa, prestablecimiento, activo, suplidores.size()));

            System.out.println("");
            System.out.println("Proveedor agregado con exito!");
            System.out.println("");
        }
        catch(Exception e)
        {
            System.out.println("Error al agregar proveedor: " + e.getMessage());
        }
    }

    public void modificarProveedor()
    {
        System.out.println("================================================");
        System.out.println("                MODIFICAR PROVEEDOR");
        System.out.println("================================================");
        System.out.println("");
        System.out.println("Ingrese el ID del Proveedor a modificar: ");
        int id = sc.nextInt();

        if(buscarProveedor(id) >= 0)
        {
            int opc = 0;
            do
            {
                System.out.println("    1. Modificar Empresa");
                System.out.println("    2. Modificar Prestablecimiento");
                System.out.println("    3. Modificar Estado");
                System.out.println("    4. Volver");
                System.out.println("");
                System.out.println("Ingrese la opcion: ");
                opc = sc.nextInt();

                switch(opc)
                {
                    case 1:
                    {
                        System.out.println("Empresa actual: " + suplidores.get(buscarProveedor(id)).getEmpresa());
                        System.out.println("Ingrese la nueva Empresa: ");
                        String empresa = herramienta.getInputString();
                        suplidores.get(buscarProveedor(id)).setEmpresa(empresa);
                        System.out.println("");
                        System.out.println("Proveedor modificado con exito!");
                        System.out.println("");
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Prestablecimiento actual: " + suplidores.get(buscarProveedor(id)).getPrestablecimiento());
                        System.out.println("Ingrese el nuevo Prestablecimiento: ");
                        String prestablecimiento = herramienta.getInputString();
                        suplidores.get(buscarProveedor(id)).setPrestablecimiento(prestablecimiento);
                        System.out.println("");
                        System.out.println("Proveedor modificado con exito!");
                        System.out.println("");
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Estado actual: " + suplidores.get(buscarProveedor(id)).getActivo());
                        System.out.println("Ingrese el nuevo Estado: ");
                        String estado = herramienta.getInputString();
                        suplidores.get(buscarProveedor(id)).setActivo(estado);
                        System.out.println("");
                        System.out.println("Proveedor modificado con exito!");
                        System.out.println("");
                        break;
                    }
                }
            }while(opc < 4);
        }

    }

    public void eliminarProveedor()
    {
        System.out.println("================================================");
        System.out.println("                ELIMINAR PROVEEDOR");
        System.out.println("================================================");
        System.out.println("");
        System.out.println("Ingrese el ID del Proveedor a eliminar: ");
        int id = sc.nextInt();

        if(buscarProveedor(id) >= 0)
        {
            System.out.println("");
            System.out.println("Empresa: " + suplidores.get(buscarProveedor(id)).getEmpresa());
            System.out.println("Prestablecimiento: " + suplidores.get(buscarProveedor(id)).getPrestablecimiento());
            System.out.println("Estado: " + suplidores.get(buscarProveedor(id)).getActivo());
            System.out.println("");
            System.out.println("Desea eliminar el Proveedor? (SI/NO)");
            String respuesta = herramienta.getInputString();

            if(respuesta.equals("SI"))
            {
                suplidores.remove(buscarProveedor(id));
                System.out.println("");
                System.out.println("Proveedor eliminado con exito!");
                System.out.println("");
            }
        }
    }

    public void mostrarProveedores()
    {
        System.out.println("================================================");
        System.out.println("                MOSTRAR PROVEEDORES");
        System.out.println("================================================");
        System.out.println("");
        for(int i = 0; i < suplidores.size(); i++)
        {
            System.out.println("ID: " + suplidores.get(i).getIdSupli());
            System.out.println("Empresa: " + suplidores.get(i).getEmpresa());
            System.out.println("Prestablecimiento: " + suplidores.get(i).getPrestablecimiento());
            System.out.println("Estado: " + suplidores.get(i).getActivo());
            System.out.println("");
        }
        System.out.println("");
    }

    private int buscarProveedor(int id) 
    {
        if(suplidores.size() > 0)
        {
            for(int i = 0; i < suplidores.size(); i++)
            {
                if(suplidores.get(i).getIdSupli() == id)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public void mostrarMenu()
    {
        int opc = 0;
        do
        {
            System.out.println("================================================");
            System.out.println("                MENÚ PRINCIPAL");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("    1. Agregar Proveedor.");
            System.out.println("    2. Modificar Proveedor.");
            System.out.println("    3. Eliminar Proveedor.");
            System.out.println("    4. Mostrar Proveedores.");
            System.out.println("    5. Salir.");
            System.out.println("");
            System.out.println("    Seleccione una opción: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                {
                    agregarProveedor();
                    break;
                }
                case 2:
                {
                    modificarProveedor();
                    break;
                }
                case 3:
                {
                    eliminarProveedor();
                    break;
                }
                case 4:
                {
                    mostrarProveedores();
                    break;
                }
                case 5:
                {
                    System.out.println("Volviendo al menú principal...");
                    break;
                }
            }
        }while(opc < 5);
    }
}
