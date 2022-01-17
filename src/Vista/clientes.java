package Vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Controlador.cHerramienta;
import Controlador.archivoTXT;
import Modelo.Cliente;

public class clientes 
{
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    cHerramienta herramienta = new cHerramienta();
    archivoTXT archivo = new archivoTXT();
    Scanner sc = new Scanner(System.in);

    public clientes()
    {
        cargarDatos();
    }

    public void cargarDatos()
    {
        try
        {
            listaClientes = herramienta.cargarClientes(archivo.leerArchivo("src\\BD\\clientes.txt"));
        }
        catch(ParseException e)
        {
            System.out.println("Error al cargar los datos de clientes: " + e.getMessage());
        }
    }

    public void mostrarMenu()
    {
        int opc = 0;

        do
        {
            System.out.println("================================================");
            System.out.println("                MENÚ CLIENTES");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("    1. Agregar Cliente.");
            System.out.println("    2. Modificar Cliente.");
            System.out.println("    3. Eliminar Cliente.");
            System.out.println("    4. Mostrar Clientes.");
            System.out.println("    5. Salir.");
            System.out.println("");
            System.out.println("    Seleccione una opción: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                {
                    agregarCliente();
                    break;
                }
                case 2:
                {
                    modificarCliente();
                    break;
                }
                case 3:
                {
                    eliminarCliente();
                    break;
                }
                case 4:
                {
                    mostrarClientes();
                    break;
                }
            }
        }while(opc < 5);
    }

    public int buscarCliente(int id)
    {
        if(listaClientes.size() == 0)
        {
            return -1;
        }
        else
        {
            for(int i = 0; i < listaClientes.size(); i++)
            {
                if(listaClientes.get(i).getIdCliente() == id)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public void agregarCliente()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("                AGREGAR CLIENTE");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("==========      DATOS PERSONALES      ==========");
            System.out.println("    Ingrese el nombre del cliente: ");
            String nombre = herramienta.getInputString();
            System.out.println("    Ingrese el apellido del cliente: ");
            String apellido = herramienta.getInputString();
            System.out.println("    Ingrese el genero del cliente: ");
            String genero = herramienta.getInputString();
            System.out.println("    Ingrese la dirección del cliente: ");
            String direccion = herramienta.getInputString();
            System.out.println("    Ingrese el teléfono del cliente: ");
            String telefono = herramienta.getInputString();
            System.out.println("    Ingrese el celular del cliente: ");
            String celular = herramienta.getInputString();
            System.out.println("    Ingrese la cedula del cliente: ");
            String cedula = herramienta.getInputString();
            System.out.println("    Ingrese la fecha actual(dd/MM/yyyy): ");
            String fecha = herramienta.getInputString();
            Date fechaActual = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            System.out.println("==========      DATOS CRÉDITO      ==========");
            System.out.println("    Ingrese el crédito del cliente: ");
            double credito = sc.nextDouble();

            String datos = listaClientes.size() + ","+ nombre + ","+ apellido + ","+ genero + ","+ direccion + ","+ telefono + ","+ celular + ","+ cedula + ","+ fecha + ","+ credito + "\n";
            archivo.guardarArchivo("src\\BD\\clientes.txt", datos);
            listaClientes.add(new Cliente(listaClientes.size(), nombre, apellido, genero, direccion, telefono, celular, cedula, fechaActual, credito));
            

            System.out.println("");
            System.out.println("    Cliente agregado con exito!");
            System.out.println("");
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void modificarCliente()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("                MODIFICAR CLIENTE");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("    Ingrese el ID del cliente que desea modificar: ");
            int idClient = sc.nextInt();

            if(buscarCliente(idClient) >= 0)
            {
                int opc = 0;
                do
                {
                    System.out.println("    1. Modificar nombre.");
                    System.out.println("    2. Modificar apellido.");
                    System.out.println("    3. Modificar genero.");
                    System.out.println("    4. Modificar dirección.");
                    System.out.println("    5. Modificar teléfono.");
                    System.out.println("    6. Modificar celular.");
                    System.out.println("    7. Modificar cedula.");
                    System.out.println("    8. Modificar fecha.");
                    System.out.println("    9. Modificar crédito.");
                    System.out.println("    10. Volver.");
                    System.out.println("");
                    System.out.println("    Seleccione una opción: ");
                    opc = sc.nextInt();

                    switch(opc)
                    {
                        case 1:
                        {
                            System.out.println("Nombre actual: " + listaClientes.get(buscarCliente(idClient)).getNombre());
                            System.out.println("Ingrese el nuevo nombre: ");
                            String nombre = herramienta.getInputString();
                            listaClientes.get(buscarCliente(idClient)).setNombre(nombre);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Apellido actual: " + listaClientes.get(buscarCliente(idClient)).getApellido());
                            System.out.println("Ingrese el nuevo apellido: ");
                            String apellido = herramienta.getInputString();
                            listaClientes.get(buscarCliente(idClient)).setApellido(apellido);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Genero actual: " + listaClientes.get(buscarCliente(idClient)).getGenero());
                            System.out.println("Ingrese el nuevo genero: ");
                            String genero = herramienta.getInputString();
                            listaClientes.get(buscarCliente(idClient)).setGenero(genero);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Dirección actual: " + listaClientes.get(buscarCliente(idClient)).getDireccion());
                            System.out.println("Ingrese la nueva dirección: ");
                            String direccion = herramienta.getInputString();
                            listaClientes.get(buscarCliente(idClient)).setDireccion(direccion);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 5:
                        {
                            System.out.println("Teléfono actual: " + listaClientes.get(buscarCliente(idClient)).getTelefono());
                            System.out.println("Ingrese el nuevo teléfono: ");
                            String telefono = herramienta.getInputString();
                            listaClientes.get(buscarCliente(idClient)).setTelefono(telefono);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 6:
                        {
                            System.out.println("Celular actual: " + listaClientes.get(buscarCliente(idClient)).getCelular());
                            System.out.println("Ingrese el nuevo celular: ");
                            String celular = herramienta.getInputString();
                            listaClientes.get(buscarCliente(idClient)).setCelular(celular);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 7:
                        {
                            System.out.println("Cédula actual: " + listaClientes.get(buscarCliente(idClient)).getCedula());
                            System.out.println("Ingrese la nueva cédula: ");
                            String cedula = herramienta.getInputString();
                            listaClientes.get(buscarCliente(idClient)).setCedula(cedula);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 8:
                        {
                            System.out.println("Fecha actual: " + listaClientes.get(buscarCliente(idClient)).getFechaReg());
                            System.out.println("Ingrese la nueva fecha: ");
                            String fecha = herramienta.getInputString();
                            Date fechaN = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
                            listaClientes.get(buscarCliente(idClient)).setFechaReg(fechaN);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 9:
                        {
                            System.out.println("Crédito actual: " + listaClientes.get(buscarCliente(idClient)).getCreditos());
                            System.out.println("Ingrese el nuevo crédito: ");
                            double credito = sc.nextDouble();
                            listaClientes.get(buscarCliente(idClient)).setCreditos(credito);
                            System.out.println("");
                            System.out.println("    Cliente modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 10:
                        {
                            System.out.println("Volviendo al menú anterior...");
                            System.out.println("");
                            break;
                        }

                    }

                }while(opc < 10);
            }
            else
            {
                System.out.println("");
                System.out.println("    El cliente no existe!");
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void eliminarCliente()
    {
        try
        {
            System.out.println("");
            System.out.println("    Eliminar cliente");
            System.out.println("");
            System.out.println("Ingrese el ID del cliente a eliminar: ");
            int idClient = sc.nextInt();
            if(buscarCliente(idClient) != -1)
            {
                listaClientes.remove(buscarCliente(idClient));
                System.out.println("");
                System.out.println("    Cliente eliminado con exito!");
                System.out.println("");
            }
            else
            {
                System.out.println("");
                System.out.println("    El cliente no existe!");
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarClientes()
    {
        for(int i = 0; i < listaClientes.size(); i++)
        {
            System.out.println("");
            System.out.println("ID: " + listaClientes.get(i).getIdCliente());
            System.out.println("Nombre: " + listaClientes.get(i).getNombre());
            System.out.println("Apellido: " + listaClientes.get(i).getApellido());
            System.out.println("Genero: " + listaClientes.get(i).getGenero());
            System.out.println("Dirección: " + listaClientes.get(i).getDireccion());
            System.out.println("Teléfono: " + listaClientes.get(i).getTelefono());
            System.out.println("Celular: " + listaClientes.get(i).getCelular());
            System.out.println("Cédula: " + listaClientes.get(i).getCedula());
            System.out.println("Fecha de registro: " + listaClientes.get(i).getFechaReg());
            System.out.println("Créditos: " + listaClientes.get(i).getCreditos());
        }
    }
}
