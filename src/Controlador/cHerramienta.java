package Controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Modelo.*;

public class cHerramienta 
{
    public ArrayList<Usuario> cargarUsuarios(String info)
    {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        String[] datos = info.split("\n");
        for(int i = 0; i < datos.length; i++)
        {
            String[] datosUsuario = datos[i].split(",");
            Usuario usuario = new Usuario(Integer.parseInt(datosUsuario[0]), datosUsuario[1], datosUsuario[2]);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public ArrayList<Producto> cargarProductos(String info) throws ParseException
    {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        String[] datos = info.split("\n");
        for(int i = 0; i < datos.length; i++)
        {
            String[] datosProducto = datos[i].split(",");
            Date date1=new SimpleDateFormat("dd/mm/yyyy").parse(datosProducto[6]);
            Date date2=new SimpleDateFormat("dd/mm/yyyy").parse(datosProducto[7]);  
            Producto producto = new Producto(Integer.parseInt(datosProducto[0]), datosProducto[1], datosProducto[2], Double.parseDouble(datosProducto[3]), Double.parseDouble(datosProducto[4]), Integer.parseInt(datosProducto[5]), date1, date2, datosProducto[8], Integer.parseInt(datosProducto[9]), Integer.parseInt(datosProducto[10]));
            productos.add(producto);
        }
        return productos;
    }

    public ArrayList<Categoria> cargarCategorias(String info) throws ParseException
    {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        String[] datos = info.split("\n");
        for(int i = 0; i < datos.length; i++)
        {
            String[] datosCategoria = datos[i].split(",");
            Categoria categoria = new Categoria(Integer.parseInt(datosCategoria[0]), datosCategoria[1], datosCategoria[2], datosCategoria[3]);
            categorias.add(categoria);
        }
        return categorias;
    }

    public String getInputString()
    {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
