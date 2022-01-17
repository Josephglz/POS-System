package Vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controlador.archivoTXT;
import Controlador.cHerramienta;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;
import Modelo.Usuario;

public class venta 
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Producto> productos = new ArrayList<Producto>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Factura> facturas = new ArrayList<Factura>();
    Usuario usuario = new Usuario();
    cHerramienta herramienta = new cHerramienta();
    archivoTXT archivo = new archivoTXT();

    public venta(Usuario usuario)
    {
        this.usuario = usuario;
        try
        {
            productos = herramienta.cargarProductos(archivo.leerArchivo("src\\BD\\productos.txt"));
            clientes = herramienta.cargarClientes(archivo.leerArchivo("src\\BD\\clientes.txt"));
            facturas = herramienta.cargarFacturas(archivo.leerArchivo("src\\BD\\facturas.txt"));
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
    }

    public int buscarProducto(int id)
    {
        if(productos.size() > 0)
        {
            for(int i = 0; i < productos.size(); i++)
            {
                if(productos.get(i).getIdProducto() == id)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public int buscarCliente(int id)
    {
        if(clientes.size() > 0)
        {
            for(int i = 0; i < clientes.size(); i++)
            {
                if(clientes.get(i).getIdCliente() == id)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public double calcularTotal(ArrayList<Integer[]> carrito)
    {
        double total = 0.0;

        for(int i = 0; i < carrito.size(); i++)
        {
            total += productos.get(buscarProducto(carrito.get(i)[0])).getPrecioVenta() * carrito.get(i)[1];
        }

        return total;
    }

    public void mostrarTicket(int metodo, ArrayList<Integer[]> carrito, float pago) throws ParseException
    {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        String ticket = "==========================================================\n" +
                        "                 TICKET DE VENTA\n" +
                        "Fecha actual: " + herramienta.fechaActual() + "\n" +
                        "Atendió: " + usuario.getUsuario() + "\n" +
                        "Método de pago: " + ((metodo == 1) ? "Efectivo" : "Crédito") + "\n" +
                        "Folio Factura: " + facturas.size() + "\n" +
                        "==========================================================\n" +
                        "CONCEPTO               CANTIDAD               PRECIO\n";
        for(int i = 0; i < carrito.size(); i++)
        {
            ticket = ticket + productos.get(buscarProducto(carrito.get(i)[0])).getNombrePro() + "                 " + carrito.get(i)[1] + "                 " + productos.get(buscarProducto(carrito.get(i)[0])).getPrecioVenta() + "\n";
        }
        ticket = ticket + "\n" +
                 "\n\n" +
                 "                                  TOTAL: $" + calcularTotal(carrito) + "\n" +
                 "                                   PAGO: $" + pago + "\n" +
                 "                                 CAMBIO: $" + (pago - calcularTotal(carrito)) + "\n" +
                 "==========================================================\n" +
                 "               GRACIAS POR SU COMPRA\n" +
                 "==========================================================\n";

        System.out.println(ticket);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        String narchivo = "src\\BD\\facturas\\" + facturas.size() + ".txt";
        archivo.guardarArchivo(narchivo, ticket);

        Date date1 = new SimpleDateFormat("dd/mm/yyyy").parse(herramienta.fechaActual());
        ticket = facturas.size() + herramienta.fechaActual() + calcularTotal(carrito) + calcularTotal(carrito) + "0.0" + pago + "PAGADA" + "SI" + usuario.getIdUsuario() + usuario.getIdUsuario();
        archivo.guardarArchivo("src\\BD\\facturas.txt", ticket);
        facturas.add(new Factura(facturas.size(), date1, calcularTotal(carrito), calcularTotal(carrito), (double)0.0, (double)pago, "PAGADA", "SI", usuario.getIdUsuario(), usuario.getIdUsuario()));
    
    }

    public void generarVenta()
    {
        ArrayList<Integer[]> carrito = new ArrayList<>();
        System.out.println("================================================");
        System.out.println("                VENTA");
        System.out.println("================================================");
        System.out.println("");

        String opc = "";
        do
        {
            System.out.println("Ingrese el codigo del producto: ");
            int codigo = sc.nextInt();
            System.out.println("Ingrese la cantidad: ");
            int cantidad = sc.nextInt();
            if(buscarProducto(codigo) >= 0)
            {
                carrito.add(new Integer[] { codigo, cantidad });
                System.out.println("Producto añadido al carrito!");
                System.out.println("");
                System.out.println("Desea agregar otro producto? (s/n)");
                opc = herramienta.getInputString();
            }
            else
            {
                System.out.println("El producto no existe");
            }
        }while(!opc.equals("n"));

        boolean pagado = false;
        if(carrito.size() > 0)
        {
            do
            {
                System.out.println("================================================");
                System.out.println("                CARRITO");
                System.out.println("================================================");
                System.out.println("");
                System.out.println("    TOTAL A PAGAR: $" + calcularTotal(carrito));
                System.out.println("");
                System.out.println("    Seleccione su método de pago: ");
                System.out.println("    1. Efectivo");
                System.out.println("    2. Crédito");
                System.out.println("");
                opc = herramienta.getInputString();

                switch(Integer.parseInt(opc))
                {
                    case 1:
                    {
                        System.out.println("Ingrese el monto de pago: ");
                        float pago = sc.nextFloat();

                        if(pago >= calcularTotal(carrito))
                        {
                            System.out.println("================================================");
                            System.out.println("                     VENTA");
                            System.out.println("================================================");
                            System.out.println("");
                            System.out.println("    TOTAL A PAGAR: $" + calcularTotal(carrito));
                            System.out.println("    CAMBIO: $" + (pago - calcularTotal(carrito)));
                            System.out.println("");
                            System.out.println("    Gracias por su compra!");
                            System.out.println("");
                            System.out.println("Generando ticket...");
                            mostrarTicket(1, carrito, pago);
                            System.out.println("");
                            System.out.println("================================================");
                            pagado = true;
                        }
                        else
                        {
                            System.out.println("");
                            System.out.println("El pago es insuficiente");
                            System.out.println("");
                        }
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Porfavor ingrese el número de cliente: ");
                        int cliente = sc.nextInt();
                        if(buscarCliente(cliente) >= 0)
                        {
                            System.out.println("");
                            System.out.println("El cliente cuenta con crédito de: $" + clientes.get(buscarCliente(cliente)).getCreditos());
                            System.out.println("");
                            System.out.println("¿Desea pagar con crédito? (s/n)");
                            String opc2 = herramienta.getInputString();
                            if(opc2.equals("s"))
                            {
                                if(calcularTotal(carrito) <= clientes.get(buscarCliente(cliente)).getCreditos())
                                {
                                    System.out.println("================================================");
                                    System.out.println("                     VENTA");
                                    System.out.println("================================================");
                                    System.out.println("");
                                    System.out.println("        TOTAL A PAGAR: $" + calcularTotal(carrito));
                                    System.out.println("     CREDITO RESTANTE: $" + (clientes.get(buscarCliente(cliente)).getCreditos() - calcularTotal(carrito)));
                                    System.out.println("");
                                    System.out.println("    Gracias por su compra!");
                                    System.out.println("");
                                    System.out.println("Generando ticket...");
                                    mostrarTicket(2, carrito, (float)calcularTotal(carrito));
                                    System.out.println("");
                                    System.out.println("================================================");
                                    pagado = true;
                                    clientes.get(buscarCliente(cliente)).setCreditos(clientes.get(buscarCliente(cliente)).getCreditos() - calcularTotal(carrito));
                                }
                                else
                                {
                                    System.out.println("El cliente no cuenta con suficiente crédito");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("El cliente no existe!");
                        }
                        break;
                    }
                }
            }while(!pagado);


        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void administrarFacturas()
    {
        
    }

    public void mostrarMenu()
    {
        int opc = 0;
        do
        {
            System.out.println("================================================");
            System.out.println("                MENÚ VENTA");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("    1. Generar Venta.");
            System.out.println("    2. Administrar Facturas.");
            System.out.println("    3. Salir.");
            System.out.println("");
            System.out.println("    Seleccione una opción: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                {
                    generarVenta();
                    break;
                }
                case 2:
                {
                    administrarFacturas();
                    break;
                }
            }

        }while(opc < 3);
    }    
}
