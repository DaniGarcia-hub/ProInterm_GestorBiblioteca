import GestarBiblioteca.src.Usuario;

import static GestarBiblioteca.srcGestion.Solicitud.*;

// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW.

public class Main {
    public static void main(String[] args) {
        long idUsuario = solicitarIDUsuario();
        String nombre = solicitarNombre();
        String direccion = solicitarDireccion();
        String telefono = solicitarTelefono();
        String email = solicitarEmail();
        String fregistro = solicitarFecha();

        Usuario usuario = new Usuario(idUsuario, nombre, direccion, telefono, email, fregistro);
        System.out.println(usuario);

    }
}