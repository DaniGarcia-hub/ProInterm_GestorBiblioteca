import GestarBiblioteca.src.Usuario;
import GestarBiblioteca.srcGestion.ArrayDeUsuario;
import static GestarBiblioteca.srcGestion.Solicitud.*;
import static GestarBiblioteca.srcGestion.Validacion.*;
import GestarBiblioteca.Colores;

import java.util.InputMismatchException;
import java.util.Scanner;
// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW. | TABLA USUARIO.

public class Main {
    public static void main(String[] args) {
        ArrayDeUsuario listaUsuarios = new ArrayDeUsuario();

        boolean continuar = true;
        System.out.println(Colores.COLOR_AZUL + "APP Insertar datos tabla Usuario." + Colores.COLOR_RESET);
        while (continuar){
            mostrarMenu();
            switch (solicitarOpc()){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    boolean valido = false;
                    long idUsuario = 0;
                    do {
                        idUsuario = solicitarIDUsuario();
                        if (validarExistenciaIDUsuario(idUsuario, listaUsuarios)){
                            System.out.println(Colores.COLOR_ROJO + "No se puede registrar un usuario con un ID ya registrado previamente." + Colores.COLOR_RESET);
                        } else valido = true;
                    } while (!valido);
                    listaUsuarios.addNewUsuario(new Usuario(idUsuario, solicitarNombre(), solicitarDireccion(), solicitarTelefono(), solicitarEmail(), solicitarFecha()));
                    System.out.println(Colores.COLOR_VERDE + "USUARIO CREADO: " + Colores.COLOR_RESET + listaUsuarios.queryUsuario(idUsuario)); // Se busca el usuario para hacer el print con el resultado tras crearlo.
                    break;
                case 2:
                    valido = false;
                    do {
                        idUsuario = solicitarIDUsuario();
                        if(!validarExistenciaIDUsuario(idUsuario, listaUsuarios)){
                            System.out.println(Colores.COLOR_ROJO + "ID Usuario no registrada. No se puede borrar un usuario que no existe." + Colores.COLOR_RESET);
                        } else valido = true;
                    } while (!valido);
                    listaUsuarios.removeUsuario(listaUsuarios.queryUsuario(idUsuario));
                    System.out.println(Colores.COLOR_VERDE + "USUARIO ELIMINADO." + Colores.COLOR_RESET);
                    break;
                case 3:
                    valido = false;
                    do {
                        idUsuario = solicitarIDUsuario();
                        if (!validarExistenciaIDUsuario(idUsuario, listaUsuarios)){
                            System.out.println(Colores.COLOR_ROJO + "ID Usuario no registrada. No se puede actualizar un usuario que no existe." + Colores.COLOR_RESET);
                        } else valido = true;
                    } while (!valido);
                    listaUsuarios.updateUsuario(listaUsuarios.queryUsuario(idUsuario), new Usuario(solicitarIDUsuario(),solicitarNombre(),solicitarDireccion(), solicitarTelefono(), solicitarEmail(), solicitarFecha()));
                    System.out.println(Colores.COLOR_VERDE + "USUARIO ACTUALIZADO." + Colores.COLOR_RESET);
                    break;
                case 4:
                    System.out.println("CONSULTA POR ID USUARIO (Pulse '0' para salir.).");
                    valido = false;
                    do {
                        idUsuario = solicitarIDUsuario();
                        if (idUsuario == 0){
                            break;
                        }
                        if (!validarExistenciaIDUsuario(idUsuario, listaUsuarios)){
                            System.out.println(Colores.COLOR_ROJO + "ID Usuario no registrada." + Colores.COLOR_RESET);
                        } else {
                            valido = true;
                        }
                    } while (!valido);
                    System.out.println(Colores.COLOR_VERDE + "RESULTADO BÚSQUEDA:" + Colores.COLOR_RESET);
                    listaUsuarios.queryUsuario(idUsuario);
                    break;
                case 5:
                    listaUsuarios.printUsuarios();
                    break;
                default:
                    System.out.println(Colores.COLOR_ROJO + "Opción incorrecta." + Colores.COLOR_RESET);
            }
        }
        System.out.println("Saliendo del programa...");
    }

    public static void mostrarMenu(){
        System.out.println("""
                |-------------------------------|
                  1. Insertar.
                  2. Eliminar.
                  3. Actualizar.
                  4. Consultar.
                  5. Imprimir.
                  0. Salir.
                |-------------------------------|""");
    }

    public static int solicitarOpc(){
        Scanner sc = new Scanner(System.in);
        boolean ejecucionCorrecta = false;
        while (!ejecucionCorrecta){
            try {
                System.out.println("Escoge una opción:");
                return sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println(Colores.COLOR_ROJO + "Formato incorrecto." + Colores.COLOR_RESET);
                sc.nextLine();
            }
        }
        return -1;
    }

//    public static void mostrarOPCsBusqueda(){
//        System.out.println("""
//                OPCIONES DE BÚSQUEDA.
//                Filtrar por:
//                1. ID Usuario.
//                2. Nombre.
//                3. Dirección.
//                4. Teléfono.
//                5. Email.
//                6. Fecha registro.""");
//    }
}