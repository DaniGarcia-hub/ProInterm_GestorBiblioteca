//Alex Pérez Pérez

public class Autor {
    private int idAutor;
    private String nacionalidad;
    private String premios;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Autor(int idAutor, String nacionalidad, String premios, String nombre, String apellido1, String apellido2) {
        if (idAutor <= 0) {
            throw new IllegalArgumentException("El ID del autor no puede ser cero o negativo.");
        }
        this.idAutor = idAutor;
        this.nacionalidad = nacionalidad;
        this.premios = premios;
        if  (nombre.isEmpty()){
            this.nombre = "Anónimo";
        } else {
            this.nombre = nombre;
        }
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        if (idAutor <= 0) {
            throw new IllegalArgumentException("El ID del autor no puede ser cero o negativo.");
        }
        this.idAutor = idAutor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if  (nombre.isEmpty()){
            this.nombre = "Anónimo";
        } else {
            this.nombre = nombre;
        }
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + idAutor);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Premios: " + premios);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido 1: " + apellido1);
        System.out.println("Apellido 2: " + apellido2);
    }
}
