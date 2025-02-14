import java.util.ArrayList;
import java.util.Scanner;

public class Editorial {
    private int id_editorial;
    private String nombre;
    private String direccion;
    private String telefono;
    ArrayList<Editorial> editoriales;

    public Editorial(int id_editorial, String nombre, String direccion, String telefono) {
        this.id_editorial = id_editorial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.editoriales = new ArrayList<>();
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

    public boolean addNewEditorial() {
        Scanner scanner = new Scanner(System.in);
        boolean resultado = true;

        System.out.print("Introduce el nombre de la editorial: ");
        String nombre = scanner.nextLine();

        for (Editorial editorial : editoriales) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error. El nombre de la editorial ya existe");
                resultado = false;
            } else {
                System.out.print("Introduce la dirección de la editorial: ");
                String direccion = scanner.nextLine();

                if (editorial.getDireccion().equalsIgnoreCase(direccion)) {
                    System.out.println("Error. El direccion de la editorial ya existe");
                    resultado = false;
                } else {
                    System.out.print("Introduce el teléfono de la editorial: ");
                    String telefono = scanner.nextLine();

                    if (editorial.getTelefono().equalsIgnoreCase(telefono)) {
                        System.out.println("Error. El telefono de la editorial ya existe");
                        resultado = false;
                    } else {
                        editoriales.add(new Editorial(getId_editorial() + 1, nombre, direccion, telefono));
                        System.out.println("Editorial añadida con éxito.");
                    }
                }
            }
        }

        return resultado;
    }

    public boolean removeEditorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de la editorial a eliminar: ");
        String nombre = scanner.nextLine();

        if (findEditorial(queryEditorial(nombre))) {
            System.out.println("Eliminando la editorial " + nombre + "...");
            editoriales.remove(queryEditorial(nombre));
            return true;
        } else {
            System.out.println("Error. La editorial " + nombre + " no existe");
            return false;
        }
    }

    public boolean updateEditorial() {
        Scanner scanner = new Scanner(System.in);
        boolean resultado = true;

        System.out.print("Introduce el nombre de la editorial a actualizar: ");
        String nombre = scanner.nextLine();
        Editorial editorialExistente = queryEditorial(nombre);

        System.out.print("Qué campo quieres cambiar?(nombre, dirección o teléfono): ");
        String campo = scanner.nextLine();

        switch (campo) {
            case "nombre":
                System.out.print("Introduce el nuevo nombre de la editorial: ");
                String nombre2 = scanner.nextLine();

                    break;

        }

        for (Editorial editorial : editoriales) {
            if (findEditorial(editorialExistente)) {
                System.out.print("Introduce el nuevo nombre de la editorial: ");
                String nombre2 = scanner.nextLine();

                if(editorial.getNombre().equalsIgnoreCase(nombre2)) {
                    System.out.println("Error. Este nombre de editorial ya existe");

                } else {

                }

                editoriales.set(editoriales.indexOf(editorialExistente), new Editorial(editorialExistente.getId_editorial(), nombre2, ));
                System.out.println("Editorial actualizada con éxito.");
            } else {
                System.out.println("Error. La editorial " + nombre + " no existe");
                resultado = false;
            }
        }
        return resultado;
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

    public Editorial queryEditorial(String nombre) {
        for (Editorial editorial : editoriales) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                return editorial;
            }
        }
        return null;
    }
}