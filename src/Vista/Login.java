package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Usuario;

public class Login
{
    Scanner sc = new Scanner(System.in);
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Login(ArrayList<Usuario> usuarios)
    {
        this.usuarios = usuarios;
    }

    public boolean verificarCredenciales(String usuario, String password)
    {
        for (Usuario u : usuarios)
        {
            if (u.getUsuario().equals(usuario) && u.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public int buscarUsuario(String usuario)
    {
        for (int i = 0; i < usuarios.size(); i++)
        {
            if (usuarios.get(i).getUsuario().equals(usuario))
            {
                return i;
            }
        }
        return -1;
    }

    public void mostrarLogin()
    {
        String usuario, password;
        do{
            System.out.println("========= [ Por favor inicie sesión. ] =========");
            System.out.println("");
            System.out.println("Ingrese su usuario: ");
            usuario = sc.nextLine();
            System.out.println("Ingrese su contraseña: ");
            password = sc.nextLine();

            if(verificarCredenciales(usuario, password))
            {
                home inicio = new home(usuarios.get(buscarUsuario(usuario)));
                inicio.mostrarMenu();
            }
            else
            {
                System.out.println("");
                System.out.println("|================================================|");
                System.out.println("|        USUARIO O CONTRASEÑA INCORRECTOS        |");
                System.out.println("|================================================|");
                System.out.println("");
            }
        }while(!verificarCredenciales(usuario, password));
    }
}
