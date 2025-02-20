import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Editorial> editoriales = new ArrayList<>();
        Editorial editorial = new Editorial(1,"El Mundo","C/Vicente Blasco Ibáñez nº8", "698414904");
        editoriales.add(editorial);

        menu();
        int opcion = -1;

        while (opcion != 7) {
            System.out.print("Elige una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                System.out.println("------------------------------------------------");

                switch (opcion){
                    case 1:
                        editorial.addNewEditorial(editoriales);
                        break;

                    case 2:
                        editorial.updateEditorial(editoriales);
                        break;

                    case 3:
                        editorial.removeEditorial(editoriales);
                        break;

                    case 4:
                        System.out.print("Introduce el nombre de la editorial que buscas: ");
                        String nombre = sc.nextLine();
                        Editorial editorialExistente = editorial.queryEditorial(editoriales, nombre);

                        if (editorialExistente != null) {
                            System.out.println("Información de la editorial especificada:");
                            System.out.println(editorialExistente.toString());
                        } else {
                            System.out.println("Esta editorial no existe");
                        }
                        System.out.println("------------------------------------------------");
                        break;

                    case 5:
                        System.out.println("Lista de editoriales registradas:");
                        for (Editorial editorial1 : editoriales) {
                            System.out.println(editorial1.toString());
                        }
                        System.out.println("------------------------------------------------");
                        break;

                    case 6:
                        menu();
                        System.out.print("Elige una opción: ");
                        opcion = sc.nextInt();
                        break;

                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error. Introduce un número del 1 al 6");
                sc.nextLine();
            }
        }
    }

    public static void menu() {
        System.out.println("1. Insertar nueva editorial\n" +
                "2. Eliminar editorial existente\n" +
                "3. Actualizar editorial existente\n" +
                "4. Consultar una editorial existente\n" +
                "5. Imprimir lista de editoriales\n" +
                "6. Salir del programa\n" +
                "7. Salir del programa");
    }
}