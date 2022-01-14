package Vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controlador.archivoTXT;
import Controlador.cHerramienta;
import Modelo.*;

public class almacen 
{
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    cHerramienta herramienta = new cHerramienta();
    archivoTXT archivo = new archivoTXT();
    Scanner sc = new Scanner(System.in);

    public almacen()
    {
        cargarDatos();
    }

    public void cargarDatos()
    {
        try {
            productos = herramienta.cargarProductos(archivo.leerArchivo("src\\BD\\productos.txt"));
            categorias = herramienta.cargarCategorias(archivo.leerArchivo("src\\BD\\categorias.txt"));
        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void mostrarAlmacen()
    {
        int opc = 0;
        do
        {
            System.out.println("================================================");
            System.out.println("              ADMINISTRAR ALMACÉN");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("    1. Administrar Productos.");
            System.out.println("    2. Administrar Categorías.");
            System.out.println("    3. Salir.");
            System.out.println("");
            System.out.println("    Seleccione una opción: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                {
                    MenuProductos();
                    break;
                }
                case 2:
                {
                    MenuCategorias();
                    break;
                }
                case 3:
                {
                    System.out.println("Volviendo al menú principal...");
                    System.out.println("");
                    break;
                }
            }
        }while(opc < 3);
    }
    /* =========================    [   PRODUCTOS    ]    =========================*/
    public void MenuProductos()
    {
        int opc = 0;
        do{
            System.out.println("================================================");
            System.out.println("              ADMINISTRAR PRODUCTOS");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("    1. Agregar Producto.");
            System.out.println("    2. Modificar Producto.");
            System.out.println("    3. Eliminar Producto.");
            System.out.println("    4. Listar Productos.");
            System.out.println("    5. Salir.");
            System.out.println("");
            System.out.println("    Seleccione una opción: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                {
                    insertarProducto();
                    break;
                }
                case 2:
                {
                    modificarProducto();
                    break;
                }
                case 3:
                {
                    eliminarProducto();
                    break;
                }
                case 4:
                {
                    listarProductos();
                    break;
                }
            }
        }while(opc < 5);
    }

    public int buscarProducto(int id)
    {
        if(productos.size() == 0)
        {
            System.out.println("No hay productos en el almacén.");
            return -1;
        }
        else
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
    
    public void insertarProducto()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("                INSERTAR PRODUCTO");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("Ingrese el nombre del producto: ");
            String nombrePro = herramienta.getInputString();
            System.out.println("Ingrese la descripcion del producto: ");
            String descripcionPro = herramienta.getInputString();
            System.out.println("Ingrese el precio de venta del producto: ");
            double precioVenta = sc.nextDouble();
            System.out.println("Ingrese el precio de compra del producto: ");
            double precioCompra = sc.nextDouble();
            System.out.println("Ingrese la cantidad del producto: ");
            int cantidadProdu = sc.nextInt();
            System.out.println("Ingrese la fecha de compra del producto (dd/mm/yyyy): ");
            String fechaCompra = herramienta.getInputString(); 
            Date fCompra=new SimpleDateFormat("dd/MM/yyyy").parse(fechaCompra);
            System.out.println("Ingrese la fecha de vencimiento del producto (dd/mm/yyyy): ");
            String fechaVenci = herramienta.getInputString();
            Date fVenc=new SimpleDateFormat("dd/MM/yyyy").parse(fechaVenci);
            System.out.println("Ingrese si el producto esta activo (SI/NO): ");
            String activo = herramienta.getInputString();
            System.out.println("Ingrese el numero de categoria del producto: ");
            int numCatego = sc.nextInt();
            System.out.println("Ingrese el numero de suplidor del producto: ");
            int numSupli = sc.nextInt();
            productos.add(new Producto(productos.size(), nombrePro, descripcionPro, precioVenta, precioCompra, cantidadProdu, fCompra, fVenc, activo, numCatego, numSupli));
            
            System.out.println("");
            System.out.println("    Producto agregado con exito!");
            System.out.println("");
        }
        catch(ParseException e)
        {
            System.out.println("Error al ingresar la fecha.");
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar los datos.\n" + e.getMessage());
        }
    }

    public void modificarProducto()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("                MODIFICAR PRODUCTO");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("Ingrese el ID del producto que desea modificar: ");
            int idPro = sc.nextInt();
            
            if(buscarProducto(idPro) >= 0)
            {
                int opc = 0;
                do
                {
                    System.out.println("    1. Nombre del producto");
                    System.out.println("    2. Descripcion del producto");
                    System.out.println("    3. Precio de venta del producto");
                    System.out.println("    4. Precio de compra del producto");
                    System.out.println("    5. Cantidad del producto");
                    System.out.println("    6. Fecha de compra del producto");
                    System.out.println("    7. Fecha de vencimiento del producto");
                    System.out.println("    8. Activo del producto");
                    System.out.println("    9. Numero de categoria del producto");
                    System.out.println("    10. Numero de suplidor del producto");
                    System.out.println("    11. Volver");
                    System.out.println("");
                    System.out.println("Seleccione una opción a modificar: ");
                    opc = sc.nextInt();

                    switch(opc)
                    {
                        case 1:
                        {
                            System.out.println("Nombre actual: " + productos.get(buscarProducto(idPro)).getNombrePro());
                            System.out.println("Ingrese el nuevo nombre del producto: ");
                            String nombrePro = herramienta.getInputString();
                            productos.get(buscarProducto(idPro)).setNombrePro(nombrePro);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Descripcion actual: " + productos.get(buscarProducto(idPro)).getDescripcionPro());
                            System.out.println("Ingrese la nueva descripcion del producto: ");
                            String descripcionPro = herramienta.getInputString();
                            productos.get(buscarProducto(idPro)).setDescripcionPro(descripcionPro);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Precio de venta actual: " + productos.get(buscarProducto(idPro)).getPrecioVenta());
                            System.out.println("Ingrese el nuevo precio de venta del producto: ");
                            double precioVenta = sc.nextDouble();
                            productos.get(buscarProducto(idPro)).setPrecioVenta(precioVenta);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Precio de compra actual: " + productos.get(buscarProducto(idPro)).getPrecioCompra());
                            System.out.println("Ingrese el nuevo precio de compra del producto: ");
                            double precioCompra = sc.nextDouble();
                            productos.get(buscarProducto(idPro)).setPrecioCompra(precioCompra);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 5:
                        {
                            System.out.println("Cantidad actual: " + productos.get(buscarProducto(idPro)).getCantidadProdu());
                            System.out.println("Ingrese la nueva cantidad del producto: ");
                            int cantidadProdu = sc.nextInt();
                            productos.get(buscarProducto(idPro)).setCantidadProdu(cantidadProdu);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 6:
                        {
                            System.out.println("Fecha de compra actual: " + productos.get(buscarProducto(idPro)).getFechaCompra());
                            System.out.println("Ingrese la nueva fecha de compra del producto (dd/mm/yyyy): ");
                            String fechaCompra = herramienta.getInputString();
                            Date fCompra=new SimpleDateFormat("dd/MM/yyyy").parse(fechaCompra);
                            productos.get(buscarProducto(idPro)).setFechaCompra(fCompra);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 7:
                        {
                            System.out.println("Fecha de vencimiento actual: " + productos.get(buscarProducto(idPro)).getFechaVenci());
                            System.out.println("Ingrese la nueva fecha de vencimiento del producto (dd/mm/yyyy): ");
                            String fechaVenci = herramienta.getInputString();
                            Date fVenc=new SimpleDateFormat("dd/MM/yyyy").parse(fechaVenci);
                            productos.get(buscarProducto(idPro)).setFechaVenci(fVenc);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 8:
                        {
                            System.out.println("Activo actual: " + productos.get(buscarProducto(idPro)).getActivo());
                            System.out.println("Ingrese el nuevo estado del producto (SI = Activo, NO = Inactivo): ");
                            String activo = herramienta.getInputString();
                            productos.get(buscarProducto(idPro)).setActivo(activo);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 9:
                        {
                            System.out.println("Categoria actual: " + productos.get(buscarProducto(idPro)).getNumCatego());
                            System.out.println("Ingrese el nuevo numero de categoria del producto: ");
                            int numCat = sc.nextInt();
                            productos.get(buscarProducto(idPro)).setNumCatego(numCat);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 10:
                        {
                            System.out.println("Suplidor actual: " + productos.get(buscarProducto(idPro)).getNumSupli());
                            System.out.println("Ingrese el nuevo numero de suplidor del producto: ");
                            int numSup = sc.nextInt();
                            productos.get(buscarProducto(idPro)).setNumSupli(numSup);
                            System.out.println("");
                            System.out.println("    Producto modificado con exito!");
                            System.out.println("");
                            break;
                        }
                        case 11:
                        {
                            System.out.println("Volviendo al menú anterior...");
                            System.out.println("");
                            break;
                        }
                    }
                }while(opc < 11);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar los datos.\n" + e.getMessage());
        }
    }

    public void eliminarProducto()
    {
        try
        {
            System.out.println("Ingrese el ID del producto que desea eliminar: ");
            int idPro = sc.nextInt();
            if(buscarProducto(idPro) == -1)
            {
                System.out.println("El producto no existe.");
            }
            else
            {
                productos.remove(buscarProducto(idPro));
                System.out.println("");
                System.out.println("    Producto eliminado con exito!");
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al leer los datos.\n" + e.getMessage());
        }
    }

    public void listarProductos()
    {
        System.out.println("================================================");
        System.out.println("                LISTADO PRODUCTOS");
        System.out.println("================================================");
        for(int i = 0; i < productos.size(); i ++)
        {
            System.out.println("");
            System.out.println("ID: " + productos.get(i).getIdProducto());
            System.out.println("Nombre: " + productos.get(i).getNombrePro());
            System.out.println("Descripcion: " + productos.get(i).getDescripcionPro());
            System.out.println("Precio de venta: " + productos.get(i).getPrecioVenta());
            System.out.println("Precio de compra: " + productos.get(i).getPrecioCompra());
            System.out.println("Cantidad: " + productos.get(i).getCantidadProdu());
            System.out.println("Fecha de compra: " + productos.get(i).getFechaCompra());
            System.out.println("Fecha de vencimiento: " + productos.get(i).getFechaVenci());
            System.out.println("Activo: " + productos.get(i).getActivo());
            System.out.println("Categoria: " + productos.get(i).getNumCatego());
            System.out.println("Suplidor: " + productos.get(i).getNumSupli());
        }
    }
    /* =========================    [   CATEGORIAS    ]    =========================*/
    public void MenuCategorias()
    {
        int opc = 0;
        do
        {
            System.out.println("================================================");
            System.out.println("              ADMINISTRAR CATEGORÍAS");
            System.out.println("================================================");
            System.out.println("");
            System.out.println("    1. Agregar Categoría.");
            System.out.println("    2. Modificar Categoría.");
            System.out.println("    3. Eliminar Categoría.");
            System.out.println("    4. Listar Categorías.");
            System.out.println("    5. Volver.");
            System.out.println("");
            System.out.println("    Seleccione una opción: ");
            opc = sc.nextInt();

            switch(opc)
            {
                case 1:
                {
                    insertarCategoria();
                    break;
                }
                case 2:
                {
                    modificarCategoria();
                    break;
                }
                case 3:
                {
                    eliminarCategoria();
                    break;
                }
                case 4:
                {
                    listarCategorias();
                    break;
                }
                case 5:
                {
                    System.out.println("Volviendo al menú anterior...");
                    System.out.println("");
                    break;
                }
            }
        }while(opc < 5);
    }
    
    public int buscarCategoria(int id)
    {
        if(categorias.size() == 0)
        {
            return -1;
        }
        for(int i = 0; i < categorias.size(); i ++)
        {
            if(categorias.get(i).getIdCategoria() == id)
            {
                return i;
            }
        }
        return -1;
    }

    public void insertarCategoria()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("               INSERTAR CATEGORÍA");
            System.out.println("================================================");
        
            System.out.println("Ingrese el nombre de la nueva categoría: ");
            String nombreCate = sc.next();
            System.out.println("Ingrese la descripción de la nueva categoría: ");
            String descripcionCate = sc.next();
            System.out.println("Ingrese si la categoría esta activa (SI/NO): ");
            String activoCate = sc.next();
            
            categorias.add(new Categoria(categorias.size(), nombreCate, descripcionCate, activoCate));
            
            System.out.println("");
            System.out.println("    Categoría agregada con exito!");
            System.out.println("");
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar los datos.\n" + e.getMessage());
        }
    }

    public void modificarCategoria()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("               MODIFICAR CATEGORÍA");
            System.out.println("================================================");
            System.out.println("Ingrese el ID de la categoría a modificar: ");
            int idCate = sc.nextInt();

            if(buscarCategoria(idCate) >= 0)
            {
                int opc = 0;
                do
                {
                    System.out.println("    1. Nombre de la categoría.");
                    System.out.println("    2. Descripción de la categoría.");
                    System.out.println("    3. Estado de la categoría.");
                    System.out.println("    4. Volver");
                    System.out.println("");
                    System.out.println("Seleccione una opción a modificar: ");
                    opc = sc.nextInt();

                    switch(opc)
                    {
                        case 1:
                        {
                            System.out.println("Nombre actual: " + categorias.get(buscarCategoria(idCate)).getNombreCat());
                            System.out.println("Ingrese el nuevo nombre de la categoría: ");
                            String nombreCat = herramienta.getInputString();
                            categorias.get(buscarCategoria(idCate)).setNombreCat(nombreCat);
                            System.out.println("");
                            System.out.println("    Categoría modificada con exito!");
                            System.out.println("");
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Descripción actual: " + categorias.get(buscarCategoria(idCate)).getDescripcionCat());
                            System.out.println("Ingrese la nueva descripción de la categoría: ");
                            String descripcionCat = sc.next();
                            categorias.get(buscarCategoria(idCate)).setDescripcionCat(descripcionCat);
                            System.out.println("");
                            System.out.println("    Categoría modificada con exito!");
                            System.out.println("");
                            break;
                        }
                        case 3:
                        {
                            System.out.println("Estado actual: " + categorias.get(buscarCategoria(idCate)).getActivo());
                            System.out.println("Ingrese el nuevo estado de la categoría (SI/NO): ");
                            String activoCat = sc.next();
                            categorias.get(buscarCategoria(idCate)).setActivo(activoCat);
                            System.out.println("");
                            System.out.println("    Categoría modificada con exito!");
                            System.out.println("");
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Volviendo al menú anterior...");
                            System.out.println("");
                            break;
                        }
                    }

                }while(opc < 4);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al leer los datos.\n" + e.getMessage());
        }
    }

    public void eliminarCategoria()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("               ELIMINAR CATEGORÍA");
            System.out.println("================================================");
            System.out.println("Ingrese el ID de la categoría a eliminar: ");
            int idCate = sc.nextInt();

            if(buscarCategoria(idCate) >= 0)
            {
                categorias.remove(buscarCategoria(idCate));
                System.out.println("");
                System.out.println("    Categoría eliminada con exito!");
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al leer los datos.\n" + e.getMessage());
        }
    }

    public void listarCategorias()
    {
        try
        {
            System.out.println("================================================");
            System.out.println("              LISTADO CATEGORÍAS");
            System.out.println("================================================");
            System.out.println("");
            for(int i = 0; i < categorias.size(); i ++)
            {
                System.out.println("");
                System.out.println("ID: " + categorias.get(i).getIdCategoria());
                System.out.println("Nombre: " + categorias.get(i).getNombreCat());
                System.out.println("Descripción: " + categorias.get(i).getDescripcionCat());
                System.out.println("Activo: " + categorias.get(i).getActivo());
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al leer los datos.\n" + e.getMessage());
        }
    }
}