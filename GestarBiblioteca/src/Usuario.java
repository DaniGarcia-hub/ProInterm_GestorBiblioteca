package GestarBiblioteca.src;

// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW. | TABLA USUARIO.

public class Usuario {
    private long idUsuario;
    private String nombre, direccion, telefono, email, fregistro;

    public Usuario(long idUsuario, String nombre, String direccion, String telefono, String email, String fregistro){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fregistro = fregistro;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFregistro() {
        return fregistro;
    }

    public void setFregistro(String fregistro) {
        this.fregistro = fregistro;
    }

    @Override
    public String toString() {
        return "ID Usuario: " + idUsuario +
                " | Nombre: " + nombre +
                " | Direccion: " + direccion +
                " | Telefono: " + telefono +
                " | Email: " + email +
                " | Fecha registro: " + fregistro + ".";
    }
}
