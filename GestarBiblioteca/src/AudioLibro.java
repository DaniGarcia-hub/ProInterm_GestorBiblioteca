package GestarBiblioteca.src;

public class AudioLibro extends Libro {
    public AudioLibro(String codLibro, String titulo, String idioma, String editorial, String autor) {
        super(codLibro, titulo, idioma, editorial, autor);
        registrarAudioLibro();
    }
}
