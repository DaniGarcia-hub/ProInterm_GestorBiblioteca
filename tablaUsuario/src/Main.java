import GestarBiblioteca.src.Usuario;
import GestarBiblioteca.srcGestion.ArrayDeUsuario;
import static GestarBiblioteca.srcGestion.Solicitud.*;
import static GestarBiblioteca.srcGestion.Validacion.*;
import GestarBiblioteca.Colores;
import GestarBiblioteca.srcGestion.Solicitud;

import java.util.*;
// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW. | TABLA USUARIO.

public class Main {
    public static void main(String[] args) {
        ArrayDeUsuario listaUsuarios = new ArrayDeUsuario();

        // ¡Creación de ejemplo!
        listaUsuarios.addNewUsuario(new Usuario(1, "Ana Pérez", "Calle Mayor, 10", "611223344", "ana.perez@example.com", "2024-01-10"));
        listaUsuarios.addNewUsuario(new Usuario(2, "Luis García", "Avenida Sol, 23", "622334455", "luis.garcia@example.com", "2024-02-15"));
        listaUsuarios.addNewUsuario(new Usuario(3, "Marta López", "Calle Luna, 35", "633445566", "marta.lopez@example.com", "2024-03-20"));
        listaUsuarios.addNewUsuario(new Usuario(4, "Carlos Martínez", "Calle Mayor, 50", "644556677", "carlos.martinez@example.com", "2024-04-25"));
        listaUsuarios.addNewUsuario(new Usuario(5, "Laura Sánchez", "Avenida Norte, 18", "655667788", "laura.sanchez@example.com", "2024-05-30"));

        boolean continuar = true;
        System.out.println(Colores.COLOR_AZUL + "APP Insertar datos tabla Usuario." + Colores.COLOR_RESET);
        while (continuar){
            menuPrincipal();
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
                    if (listaUsuarios.getUsuarios().isEmpty()){
                        System.out.println(Colores.COLOR_ROJO + "ERROR. No se pueden borrar usuarios. No se tiene registrado ningún usuario." + Colores.COLOR_RESET);
                    } else {
                        valido = false;
                        do {
                            idUsuario = solicitarIDUsuario();
                            if(!validarExistenciaIDUsuario(idUsuario, listaUsuarios)){
                                System.out.println(Colores.COLOR_ROJO + "ID Usuario no registrada. No se puede borrar un usuario que no existe." + Colores.COLOR_RESET);
                            } else valido = true;
                        } while (!valido);
                        listaUsuarios.removeUsuario(listaUsuarios.queryUsuario(idUsuario));
                        System.out.println(Colores.COLOR_VERDE + "USUARIO ELIMINADO." + Colores.COLOR_RESET);
                    }
                    break;
                case 3:
                    if (listaUsuarios.getUsuarios().isEmpty()){
                        System.out.println(Colores.COLOR_ROJO + "ERROR. No se pueden actualizar usuarios. No se tiene registrado ningún usuario." + Colores.COLOR_RESET);
                    } else {
                        valido = false;
                        do {
                            idUsuario = solicitarIDUsuario();
                            if (!validarExistenciaIDUsuario(idUsuario, listaUsuarios)){
                                System.out.println(Colores.COLOR_ROJO + "ID Usuario no registrada. No se puede actualizar un usuario que no existe." + Colores.COLOR_RESET);
                            } else valido = true;
                        } while (!valido);
                        listaUsuarios.updateUsuario(listaUsuarios.queryUsuario(idUsuario), new Usuario(idUsuario,solicitarNombre(),solicitarDireccion(), solicitarTelefono(), solicitarEmail(), solicitarFecha()));
                        System.out.println(Colores.COLOR_VERDE + "USUARIO ACTUALIZADO." + Colores.COLOR_RESET);
                        System.out.println(listaUsuarios.queryUsuario(idUsuario));
                    }
                    break;
                case 4:
                    if (listaUsuarios.getUsuarios().isEmpty()){
                        System.out.println(Colores.COLOR_ROJO + "ERROR. No se pueden consultas usuarios. No se tiene registrado ningún usuario." + Colores.COLOR_RESET);
                    } else {
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
                        System.out.println(listaUsuarios.queryUsuario(idUsuario));
                    }
                    break;
                case 5:
                    if (listaUsuarios.getUsuarios().isEmpty()){
                        System.out.println(Colores.COLOR_ROJO + "ERROR. No se pueden imprimir usuarios. No se tiene registrado ningún usuario." + Colores.COLOR_RESET);
                    } else {
                        listaUsuarios.printUsuarios();
                    }
                    break;
                case 6:
                    if (listaUsuarios.getUsuarios().isEmpty()){
                        System.out.println(Colores.COLOR_ROJO + "ERROR. No se pueden generar archivos. No se tiene registrado ningún usuario." + Colores.COLOR_RESET);
                    } else {
                        menuGenerar();
                        final int NUM_OPCGENERAR = 1;
                        int opcUsuario = solicitarOpc();
                        if (opcUsuario < 0 || opcUsuario > NUM_OPCGENERAR){
                            System.out.println(Colores.COLOR_ROJO + "Opción incorrecta." + Colores.COLOR_RESET);
                        } else if (opcUsuario == 0) {
                            // Se fuerza el salir.
                        } else {
                            boolean ejecucionCorrecta = false;
                            Set<Map<String, Object>> datosExportar = new HashSet<>();
                            menuOpcGenerar();
                            switch (solicitarOpc()){
                                case 0:
                                    // Se fuerza el salir.
                                    break;
                                case 1:
                                    Usuario usuarioExportar = listaUsuarios.queryUsuario(solicitarUsuario());
                                    if (usuarioExportar == null){
                                        System.out.println(Colores.COLOR_ROJO + "Usuario no encontrado." + Colores.COLOR_RESET);
                                    } else {
                                        // Uso de LinkedHashMap para que se metan ordenadas las claves. Sino salen desordenadas.
                                        Map<String, Object> extraccionUsuario = new LinkedHashMap<>();
                                        rellenarMap(extraccionUsuario, usuarioExportar);
                                        datosExportar.add(extraccionUsuario);
                                        ejecucionCorrecta = true;
                                    }
                                    break;
                                case 2:
                                    Scanner sc = new Scanner(System.in);
                                    System.out.print("¿Cuantos usuarios quieres introducir? Cantidad usuarios registrados: " + listaUsuarios.getUsuarios().size() + ". ");
                                    int cantUsuario = Solicitud.solicitarCantidad();
                                    if (cantUsuario >= 1 && cantUsuario <= listaUsuarios.getUsuarios().size()){
                                        for (int i = 0; i < cantUsuario; i++){
                                            // Uso de LinkedHashMap para que se metan ordenadas las claves. Sino salen desordenadas.
                                            Map<String, Object> extraccionUsuario = new LinkedHashMap<>();
                                            Usuario usuarioExportar2 = listaUsuarios.queryUsuario(solicitarUsuario());
                                            boolean encontrado = false;
                                            while (!encontrado) {
                                                if (usuarioExportar2 == null) {
                                                    System.out.println(Colores.COLOR_ROJO + "Usuario no encontrado." + Colores.COLOR_RESET);
                                                    usuarioExportar2 = listaUsuarios.queryUsuario(solicitarUsuario());
                                                } else {
                                                    rellenarMap(extraccionUsuario, usuarioExportar2);
                                                    datosExportar.add(extraccionUsuario);
                                                    encontrado = true;
                                                }
                                            }
                                        }
                                        ejecucionCorrecta = true;
                                    } else {
                                        System.out.println(Colores.COLOR_ROJO + "ERROR. No se dispone de esa cantidad de usuarios." + Colores.COLOR_RESET);
                                    }
                                    break;
                                case 3:
                                    for (Usuario usuario : listaUsuarios.getUsuarios()){
                                        // Uso de LinkedHashMap para que se metan ordenadas las claves. Sino salen desordenadas.
                                        Map<String, Object> extraccionUsuario = new LinkedHashMap<>();
                                        rellenarMap(extraccionUsuario, usuario);
                                        datosExportar.add(extraccionUsuario);
                                    }
                                    ejecucionCorrecta = true;
                                    break;
                                default:
                                    System.out.println(Colores.COLOR_ROJO +  "Opción incorrecta." + Colores.COLOR_RESET);
                            }

                            // En función del tipo de archivo a generar...
                            if (ejecucionCorrecta){
                                switch (opcUsuario){
                                    case 1: // Opción XML.
                                        mostrarXML(datosExportar);
                                        break;
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println(Colores.COLOR_ROJO + "Opción incorrecta." + Colores.COLOR_RESET);
            }
        }
        System.out.println("Saliendo del programa...");
    }

    public static void menuPrincipal(){
        System.out.println("""
                |-------------------------------|
                  1. Insertar.
                  2. Eliminar.
                  3. Actualizar.
                  4. Consultar.
                  5. Imprimir.
                  6. Exportar datos.
                  0. Salir.
                |-------------------------------|""");
    }

    public static void menuGenerar(){
        System.out.println("""
                |-------------------------------|
                  1. XML.
                  0. Salir.
                |-------------------------------|""");
    }

    public static void menuOpcGenerar(){
        System.out.println("""
                |-------------------------------|
                  1. Generar un usuario registrado.
                  2. X usuarios registrados.
                  3. Todos los usuarios registrados.
                  0. Salir.
                |-------------------------------|""");
    }

    public static int solicitarOpc(){
        Scanner sc = new Scanner(System.in);
        boolean ejecucionCorrecta = false;
        while (!ejecucionCorrecta){
            try {
                System.out.print("Escoge una opción: ");
                String entrada = sc.nextLine().trim();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e){
                System.out.println(Colores.COLOR_ROJO + "Formato incorrecto." + Colores.COLOR_RESET);
            }
        }
        return -1;
    }

    public static void rellenarMap(Map<String, Object> almacenInfo, Usuario usuarioInfo){
        almacenInfo.put("id", usuarioInfo.getIdUsuario());
        almacenInfo.put("nombre", usuarioInfo.getNombre());
        almacenInfo.put("direccion", usuarioInfo.getDireccion());
        almacenInfo.put("telefono", usuarioInfo.getTelefono());
        almacenInfo.put("email", usuarioInfo.getEmail());
        almacenInfo.put("fregistro", usuarioInfo.getFregistro());
    }

    public static void mostrarXML(Set<Map<String, Object>> datos){
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        System.out.println("<Usuarios>");
        for (Map<String, Object> mapUsuario : datos){
            System.out.println("    <Usuario>");
            String[] claves = mapUsuario.keySet().toArray(new String[0]);
            for (String clave : claves){
                System.out.println("        <"+ clave + ">" + mapUsuario.get(clave) + "</" + clave + ">");
            }
            System.out.println("    </Usuario>");
        }
        System.out.println("</Usuarios>");
    }
}