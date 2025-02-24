import java.util.ArrayList;
import java.util.Scanner;

public class Editorial {
    private int id_editorial;
    private String nombre;
    private String direccion;
    private String telefono;
    private static ArrayList<Editorial> editoriales = new ArrayList<>();
    private static int contadorID = 1;

    public Editorial(int id_editorial, String nombre, String direccion, String telefono) {
        this.id_editorial = id_editorial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean addNewEditorial(ArrayList<Editorial> editoriales) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre de la editorial: ");
        String nombre = scanner.nextLine();

        if (queryEditorial(editoriales, nombre) != null) {
            System.out.println("Error. El nombre de la editorial ya existe.");
            return false;
        }

        System.out.print("Introduce la dirección de la editorial: ");
        String direccion = scanner.nextLine();

        for (Editorial editorial : editoriales) {
            if (editorial.getDireccion().equalsIgnoreCase(direccion)) {
                System.out.println("Error. La dirección de la editorial ya existe");
                return false;
            }
        }

        System.out.print("Introduce el teléfono de la editorial: ");
        String telefono = scanner.nextLine();

        for (Editorial editorial : editoriales) {
            if (editorial.getTelefono().equalsIgnoreCase(telefono)) {
                System.out.println("Error. El teléfono ya existe.");
                return false;
            }
        }
        if (contadorID == 1) {
            contadorID++;
        }
        editoriales.add(new Editorial(contadorID++, nombre, direccion, telefono));
        System.out.println("Editorial añadida con éxito.");
        System.out.println("------------------------------------------------");
        return true;
    }

    public boolean removeEditorial(ArrayList<Editorial> editoriales) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de la editorial a eliminar: ");
        String nombre = scanner.nextLine();

        Editorial editorialExistente = queryEditorial(editoriales, nombre);

        if (editorialExistente != null) {
            System.out.println("Eliminando la editorial " + nombre + "...");
            editoriales.remove(editorialExistente);
            return true;
        } else {
            System.out.println("Error. La editorial " + nombre + " no existe");
            return false;
        }
    }

    public boolean updateEditorial(ArrayList<Editorial> editoriales) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de la editorial a actualizar: ");
        String nombre = scanner.nextLine();
        Editorial editorialExistente = queryEditorial(editoriales, nombre);

        if (editorialExistente == null) {
            System.out.println("Error. La editorial " + nombre + " no existe");
            return false;
        }

        System.out.print("Introduce el nuevo nombre de la editorial: ");
        String nuevoNombre = scanner.nextLine();

        if (queryEditorial(editoriales, nuevoNombre) != null) {
            System.out.println("Error. Ese nombre ya existe.");
            return false;
        }

        System.out.print("Introduce la nueva dirección de la editorial: ");
        String nuevaDireccion = scanner.nextLine();

        for (Editorial editorial : editoriales) {
            if (editorial.getDireccion().equalsIgnoreCase(nuevaDireccion)) {
                System.out.println("Error. La dirección ya existe.");
                return false;
            }
        }

        System.out.print("Introduce el nuevo teléfono de la editorial: ");
        String nuevoTelefono = scanner.nextLine();

        for (Editorial editorial : editoriales) {
            if (editorial.getTelefono().equalsIgnoreCase(nuevoTelefono)) {
                System.out.println("Error. El teléfono ya existe.");
                return false;
            }
        }

        editorialExistente.nombre = nuevoNombre;
        editorialExistente.direccion = nuevaDireccion;
        editorialExistente.telefono = nuevoTelefono;

        System.out.println("Editorial actualizada con éxito.");
        System.out.println("------------------------------------------------");
        return true;
    }

    private boolean findEditorial(Editorial editorial) {
        if (editoriales.contains(editorial)) {
            return true;
        }
        return false;
    }

    private boolean findEditorial(int id_editorial) {
        for (Editorial editorial : editoriales) {
            if (editorial.getId_editorial() == id_editorial) {
                return true;
            }
        }
        return false;
    }

    public Editorial queryEditorial(ArrayList<Editorial> editoriales, String nombre) {
        for (Editorial editorial : editoriales) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                return editorial;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "- " + nombre + ": [Id: " + id_editorial + ", Dirección: " + direccion + ", Telefono: " + telefono + "]";
    }
}