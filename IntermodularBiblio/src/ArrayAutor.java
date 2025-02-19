import java.util.ArrayList;

public class ArrayAutor {
    private ArrayList<Autor> autores;

    public ArrayAutor() {
        this.autores = new ArrayList<>();
    }

    public boolean addNewAutor(Autor autor) {
        if (findAutorById(autor.getIdAutor()) != null) {
            return false;
        }
        autores.add(autor);
        return true;
    }

    public boolean removeAutor(int idAutor) {
        Autor autor = findAutorById(idAutor);
        if (autor != null) {
            autores.remove(autor);
            return true;
        }
        return false;
    }

    public boolean updateAutor(Autor autor) {
        Autor existingAutor = findAutorById(autor.getIdAutor());
        if (existingAutor != null) {
            int index = autores.indexOf(existingAutor);
            autores.set(index, autor);
            return true;
        }
        return false;
    }

    Autor findAutorById(int idAutor) {
        for (Autor autor : autores) {
            if (autor.getIdAutor() == idAutor) {
                return autor;
            }
        }
        return null;
    }

    private Autor findAutorByObject(Autor autor) {
        int index = autores.indexOf(autor);
        if (index != -1) {
            return autores.get(index);
        }
        return null;
    }

    public ArrayList<Autor> queryAutor() {
        return autores;
    }

    public void printAutor() {
        for (Autor autor : autores) {
            autor.mostrarInformacion();
            System.out.println("-----------");
        }
    }
}
