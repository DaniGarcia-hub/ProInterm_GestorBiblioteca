package GestarBiblioteca.srcGestion;
import java.util.InputMismatchException;
import java.util.Scanner;
import static GestarBiblioteca.srcGestion.Validacion.*;

// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW.

public class Solicitud {
    static Scanner sc = new Scanner(System.in);
    public static long solicitarIDUsuario(){
        long idusuario = -1;
        do {
            try{
                System.out.println("Introduce el ID de usuario:\nCondiciones:\n- No puede ser negativo.\n- No debe contener 0 el inicio.");
                idusuario = Math.abs(sc.nextLong());
            } catch (InputMismatchException e){
                System.err.println("Formato incorrecto. (Necesita números).");
                sc.nextLine();
                solicitarIDUsuario();
            }
        } while (!validarIDUsuario(idusuario));

        return idusuario;
    }

    public static String solicitarNombre(){
        sc.nextLine();

        String nombre;
        do {
            System.out.println("Introduce el nombre del usuario:");
            nombre = sc.nextLine();

        } while (!validarNombre(nombre));
        return nombre;
    }

    public static String solicitarDireccion(){
        String direccion;
        do {
            System.out.println("Introduce la dirección del usuario:");
            direccion = sc.nextLine();
        } while (!validarDireccion(direccion));
        return direccion;
    }

    public static String solicitarTelefono(){
        String telefono;
        do {
            System.out.println("Introduce el teléfono del usuario. (Ejemplo: 655502307):");
            telefono = sc.nextLine();
        } while (!validarTelefono(telefono));
        return telefono;
    }

    public static String solicitarEmail(){
        String email;
        do {
            System.out.println("Introduce el correo electrónico del usuario. (Ejemplo: dangarqui2@gmail.com):");
            email = sc.nextLine();
        } while (!validarEmail(email));
        return email;
    }

    public static String solicitarFecha(){
        String fecha;
        do {
            System.out.println("Introduce la fecha de registro del usuario (dd/MM/yyyy):");
            fecha = sc.nextLine();
        } while (!validarFecha(fecha));
        return fecha;
    }
}
