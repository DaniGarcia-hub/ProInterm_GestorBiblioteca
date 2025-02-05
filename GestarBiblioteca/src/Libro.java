package GestarBiblioteca.src;

import java.util.Scanner;

public class Libro {
    private String codLibro, titulo, idioma, editorial, autor;
    private boolean esAudioLibro, esDigital, esFisico;

    public Libro (String codLibro, String titulo, String idioma, String editorial, String autor){
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.idioma = idioma;
        this.editorial = editorial;
        this.autor = autor;
        this.esAudioLibro = false;
        this.esDigital = false;
        this.esFisico = false;
    }

    protected void registrarAudioLibro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ISBN del audiolibro:");
        String ISBN = sc.nextLine();

        System.out.println("Introduce la duración del audiolibro:");
        int duracion = sc.nextInt();


        this.esAudioLibro = true;
    }
}
