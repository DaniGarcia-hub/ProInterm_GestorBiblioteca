package GestarBiblioteca;

import GestarBiblioteca.src.AudioLibro;
import GestarBiblioteca.src.Digital;
import GestarBiblioteca.src.Fisico;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private String IDBiblioteca, nombreBiblioteca;
    private ArrayList[] libros = new ArrayList[3];

    public Biblioteca(String IDBiblioteca, String nombreBiblioteca){
        this.IDBiblioteca = IDBiblioteca;
        this.nombreBiblioteca = nombreBiblioteca;
        libros[0] = new ArrayList<AudioLibro>();
        libros[1] = new ArrayList<Digital>();
        libros[2] = new ArrayList<Fisico>();
    }

    public void registrarLibro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el código que identificará al libro:");
        String codLibro = sc.nextLine();

        boolean ejecucionCorrecta = false;
        do{
            System.out.println("Introduce el título del libro:");
            String titulo = sc.nextLine();

            if (titulo.isEmpty()){
                System.err.println("El título no puede estar vacío");
            } else if (titulo.length() > 35) {
                System.err.println("La cantidad máxima de carácteres permitidos para el título es de 35 carácteres.");
            } else {
                ejecucionCorrecta = true;
            }
        } while (!ejecucionCorrecta);

        ejecucionCorrecta = false;
        do{
            System.out.println("Introduce el idioma del libro:");
            String idioma = sc.nextLine();

            if (idioma.isEmpty()){
                System.err.println("El libro debe de estar en un idioma.");
            } else if (idioma.length() > 35) {
                System.err.println("La cantidad máxima de carácteres permitidos para informar sobre el idioma es de 35 carácteres.");
            } else {
                ejecucionCorrecta = true;
            }
        } while (!ejecucionCorrecta);


    }

    public String registrarFecha(){


        Scanner sc = new Scanner(System.in);
        boolean ejecucionCorrecta = false;
        do {
            int dia, mes, anyo, hora, minutos, segundos = -1;

            while (dia)

            System.out.println("Introduce la fecha de publicación del libro (Formato a colocar: DIA/MES/AÑO HORA:MINUTOS:SEGUNDOS o DIA/MES/AÑO. Ejemplo: 02/06/2004 23:17:56):");
            String fpublicacion = sc.nextLine();

            if (fpublicacion.isEmpty()){
                System.err.println("Se debe registrar la fecha de publicación del libro.");
            } else {
                if (fpublicacion.length() == 10 || fpublicacion.length() == 19){
                    if (fpublicacion.length() == 10){

                    } else {

                    }
                } else {
                    System.err.println("Formato de fecha incorrecto.");
                }
            }
        } while (!ejecucionCorrecta);
    }
}
