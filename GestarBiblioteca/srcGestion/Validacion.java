package GestarBiblioteca.srcGestion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW.

public class Validacion {

    static final int MAX_11CARACTER = 11;
    static final int MAX_35CARACTER = 35;
    static final String CONDICIONESEMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    protected static boolean comprobarStrigSoloLetras(String palabraComprobar){
        boolean correcto = true;
        for (int i = 0; i < palabraComprobar.length(); i++){
            if (!Character.isAlphabetic(palabraComprobar.charAt(i))){
                System.err.println("Solo se permiten carácteres alfabéticos.");
                correcto = false;
                break;
            }
        }
        return correcto;
    }

    protected static boolean comprobarSoloNumeros(String palabraComprobar){
        boolean correcto = true;
        for (int i = 0; i < palabraComprobar.length(); i++){
            if (!Character.isDigit(palabraComprobar.charAt(i))){
                System.err.println("Solo se permiten números.");
                correcto = false;
                break;
            }
        }
        return correcto;
    }

    protected static boolean validarIDUsuario(long idUsuario){
        String conversionIDUsuario = String.valueOf(idUsuario);
        if (conversionIDUsuario.length() > MAX_11CARACTER){
            System.err.println("No se permite un código de libro con una longitud mayor a 11 dígitos.");
            return false;
        }
        return true;
    }

    protected static boolean validarNombre(String nombreUsuario){
        boolean devolver = true;
        if (nombreUsuario.isEmpty()){
            System.err.println("No se puede dejar el nombre vacío.");
            devolver = false;
        } else if (nombreUsuario.length() > MAX_35CARACTER) {
            System.err.println("No se permite una cantidad mayor a 35 carácteres.");
            devolver = false;
        } else if (!comprobarStrigSoloLetras(nombreUsuario)) {
            devolver = false;
        }
        return devolver;
    }

    protected static boolean validarDireccion(String direccionUsuario){
        boolean devolver = true;
        if (direccionUsuario.length() > MAX_35CARACTER){
            System.err.println("No se permite una cantidad mayor a 35 carácteres.");
            devolver = false;
        }
        return devolver;
    }

    // DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW.

    protected static boolean validarTelefono(String telefonoUsuario){
        boolean devolver = true;
        if (!comprobarSoloNumeros(telefonoUsuario)) {
            devolver = false;
        } else if (telefonoUsuario.length() != 9){
            System.err.println("La longitud del telefono debe ser de 9 dígitos.");
            devolver = false;
        }
        return devolver;
    }

    /*
    Sobre el metodo validarmail.
    El contenido se ha sacado de Internet, sin hacer uso de IA. Adjunto fuentes:
    Obtener pattern y saber funcionamiento: https://unipython.com/validar-un-email-en-java/
    Testear funcionamiento: https://techiedelight.com/compiler/
    Aprender como funciona visualmente: https://regexper.com/#%5E%5BA-Za-z0-9._%25%2B-%5D%2B%40%5BA-Za-z0-9.-%5D%2B%5C.%5BA-Za-z%5D%7B2%2C%7D%24
    */

    protected static boolean validarEmail(String email){
        boolean devolver = true;
        Pattern condicionesEmail = Pattern.compile(CONDICIONESEMAIL);
        if (!condicionesEmail.matcher(email).find()){
            System.err.println("Formato inválido.");
            devolver = false;
        }
        return devolver;
    }

    protected static boolean validarFecha(String fechaUsuario){
        boolean formatoCorrecto = true;
        SimpleDateFormat fechaFormateado = new SimpleDateFormat("dd/MM/yyyy");
        fechaFormateado.setLenient(false);

        try{
            Date fechaUsuarioAdaptada = fechaFormateado.parse(fechaUsuario);
            Date fechaActual = fechaFormateado.parse(fechaFormateado.format(new Date()));

            if (fechaUsuarioAdaptada.after(fechaActual)){
                System.err.println("No se permite colocar una fecha de registro superior a la actual.");
                formatoCorrecto = false;
            }
        } catch (ParseException e) {
            System.out.println("Formato de la fecha inválida.");
            formatoCorrecto = false;
        }
        return formatoCorrecto;
    }
}
