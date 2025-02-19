import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayAutor arrayAutor = new ArrayAutor();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addNewAutor();
                    break;
                case 2:
                    removeAutor();
                    break;
                case 3:
                    updateAutor();
                    break;
                case 4:
                    queryAutor();
                    break;
                case 5:
                    printAutor();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Menú:");
        System.out.println("1. Insertar");
        System.out.println("2. Eliminar");
        System.out.println("3. Actualizar");
        System.out.println("4. Consultar");
        System.out.println("5. Imprimir");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void addNewAutor() {
        int idAutor = 0;
        while (true) {
            System.out.print("Introduce el ID del autor: ");
            String input = scanner.nextLine();
            try {
                idAutor = Integer.parseInt(input);
                if (idAutor <= 0) {
                    System.out.println("El ID del autor debe ser un número positivo. Inténtalo de nuevo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. El ID del autor debe ser un número. Inténtalo de nuevo.");
            }
        }

        System.out.print("Introduce la nacionalidad (máximo 30 caracteres, puede estar vacía): ");
        String nacionalidad = scanner.nextLine();
        if (nacionalidad.length() > 30) {
            nacionalidad = nacionalidad.substring(0, 30);
        }

        System.out.print("Introduce los premios (máximo 35 caracteres, puede estar vacío): ");
        String premios = scanner.nextLine();
        if (premios.length() > 35) {
            premios = premios.substring(0, 35);
        }

        System.out.print("Introduce el nombre (máximo 35 caracteres, dejar en blanco para 'Anónimo'): ");
        String nombre = scanner.nextLine();
        if (nombre.length() > 35) {
            nombre = nombre.substring(0, 35);
        }

        System.out.print("Introduce el primer apellido (máximo 35 caracteres, puede estar vacío): ");
        String apellido1 = scanner.nextLine();
        if (apellido1.length() > 35) {
            apellido1 = apellido1.substring(0, 35);
        }

        System.out.print("Introduce el segundo apellido (máximo 35 caracteres, puede estar vacío): ");
        String apellido2 = scanner.nextLine();
        if (apellido2.length() > 35) {
            apellido2 = apellido2.substring(0, 35);
        }

        Autor autor = new Autor(idAutor, nacionalidad, premios, nombre, apellido1, apellido2);
        if (arrayAutor.addNewAutor(autor)) {
            System.out.println("Autor agregado con éxito.");
        } else {
            System.out.println("Ya existe un autor con el mismo ID.");
        }
    }

    private static void removeAutor() {
        System.out.print("Introduce el ID del autor a eliminar: ");
        int idAutor = scanner.nextInt();
        scanner.nextLine();
        if (arrayAutor.removeAutor(idAutor)) {
            System.out.println("Autor eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún autor con el ID proporcionado.");
        }
    }

    private static void updateAutor() {
        Autor autor = inputAutor();
        if (arrayAutor.updateAutor(autor)) {
            System.out.println("Autor actualizado con éxito.");
        } else {
            System.out.println("No se encontró ningún autor con el ID proporcionado.");
        }
    }

    private static void queryAutor() {
        System.out.print("Introduce el ID del autor a consultar: ");
        int idAutor = scanner.nextInt();
        scanner.nextLine();
        Autor autor = arrayAutor.findAutorById(idAutor);
        if (autor != null) {
            autor.mostrarInformacion();
        } else {
            System.out.println("No se encontró ningún autor con el ID proporcionado.");
        }
    }

    private static void printAutor() {
        arrayAutor.printAutor();
    }

    private static Autor inputAutor() {
        int idAutor = 0;
        while (true) {
            System.out.print("Introduce el ID del autor: ");
            String input = scanner.nextLine();
            try {
                idAutor = Integer.parseInt(input);
                if (idAutor <= 0) {
                    System.out.println("El ID del autor debe ser un número positivo. Inténtalo de nuevo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. El ID del autor debe ser un número. Inténtalo de nuevo.");
            }
        }

        System.out.print("Introduce la nacionalidad (máximo 30 caracteres, puede estar vacía): ");
        String nacionalidad = scanner.nextLine();
        if (nacionalidad.length() > 30) {
            nacionalidad = nacionalidad.substring(0, 30);
        }

        System.out.print("Introduce los premios (máximo 35 caracteres, puede estar vacío): ");
        String premios = scanner.nextLine();
        if (premios.length() > 35) {
            premios = premios.substring(0, 35);
        }

        System.out.print("Introduce el nombre (máximo 35 caracteres, dejar en blanco para 'Anónimo'): ");
        String nombre = scanner.nextLine();
        if (nombre.length() > 35) {
            nombre = nombre.substring(0, 35);
        }

        System.out.print("Introduce el primer apellido (máximo 35 caracteres, puede estar vacío): ");
        String apellido1 = scanner.nextLine();
        if (apellido1.length() > 35) {
            apellido1 = apellido1.substring(0, 35);
        }

        System.out.print("Introduce el segundo apellido (máximo 35 caracteres, puede estar vacío): ");
        String apellido2 = scanner.nextLine();
        if (apellido2.length() > 35) {
            apellido2 = apellido2.substring(0, 35);
        }

        return new Autor(idAutor, nacionalidad, premios, nombre, apellido1, apellido2);
    }
}
