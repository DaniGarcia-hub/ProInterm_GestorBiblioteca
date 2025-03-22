package GestarBiblioteca.srcGestion;
import GestarBiblioteca.Colores;

import java.util.Scanner;
import static GestarBiblioteca.srcGestion.Validacion.*;

// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW. | TABLA USUARIO.

public class Solicitud {
    static Scanner sc = new Scanner(System.in);
    public static long solicitarIDUsuario(){
        long idusuario = -1;
        do {
            try{
                System.out.println("Introduce el ID de usuario:\nCondiciones:\n- No puede ser negativo.\n- No debe contener 0 el inicio.");
                idusuario = Math.abs(Long.parseLong(sc.nextLine().trim()));
            } catch (NumberFormatException e){
                System.out.println(Colores.COLOR_ROJO + "Formato incorrecto. (Necesita números)." + Colores.COLOR_RESET);
                solicitarIDUsuario();
            }
        } while (!validarIDUsuario(idusuario));
        return idusuario;
    }

    public static String solicitarNombre(){
        String nombre;
        do {
            System.out.print("Introduce el nombre del usuario: ");
            nombre = sc.nextLine();

        } while (!validarNombre(nombre));
        return nombre;
    }

    public static String solicitarDireccion(){
        String direccion;
        do {
            System.out.print("Introduce la dirección del usuario: ");
            direccion = sc.nextLine();
        } while (!validarDireccion(direccion));
        return direccion;
    }

    public static String solicitarTelefono(){
        String telefono;
        do {
            System.out.print("Introduce el teléfono del usuario. (Ejemplo: 655502307): ");
            telefono = sc.nextLine();
        } while (!validarTelefono(telefono));
        return telefono;
    }

    public static String solicitarEmail(){
        String email;
        do {
            System.out.print("Introduce el correo electrónico del usuario. (Ejemplo: dangarqui2@gmail.com): ");
            email = sc.nextLine();
        } while (!validarEmail(email));
        return email;
    }

    public static String solicitarFecha(){
        String fecha;
        do {
            System.out.print("Introduce la fecha de registro del usuario (dd/MM/yyyy): ");
            fecha = sc.nextLine();
        } while (!validarFecha(fecha));
        return fecha;
    }

    public static int solicitarUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean ejecucionCorrecta = false;
        while (!ejecucionCorrecta){
            try {
                System.out.print("Escoge el usuario por su ID. Ejemplo: (5): ");
                String entrada = sc.nextLine().trim();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e){
                System.out.println(Colores.COLOR_ROJO + "Formato incorrecto." + Colores.COLOR_RESET);
            }
        }
        return -1;
    }

    public static int solicitarCantidad(){
        Scanner sc = new Scanner(System.in);
        boolean ejecucionCorrecta = false;
        while (!ejecucionCorrecta){
            try {
                System.out.print("Indica la cantidad: ");
                String entrada = sc.nextLine().trim();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e){
                System.out.println(Colores.COLOR_ROJO + "Formato incorrecto." +  Colores.COLOR_RESET);
            }
        }
        return -1;
    }
}
