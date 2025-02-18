package GestarBiblioteca.srcGestion;

import GestarBiblioteca.src.Usuario;
import GestarBiblioteca.Colores;

import java.util.ArrayList;

// DANIEL JOSÉ GARCÍA QUIRANT. 1ºJ DAW. | TABLA USUARIO.

public class ArrayDeUsuario {
    private ArrayList<Usuario> usuarios;

    public ArrayDeUsuario(){
        this.usuarios = new ArrayList<>();
    }

    public void addNewUsuario(Usuario usuarioMeter){
        usuarios.add(usuarioMeter);
    }

    public void removeUsuario(Usuario usuarioBorrar){
        usuarios.remove(usuarioBorrar);
    }

    public void updateUsuario(Usuario usuarioActualizar, Usuario usuarioNuevo){
        usuarios.set(usuarios.indexOf(usuarioActualizar), usuarioActualizar);
    }

    private boolean findUsuario(long idUsuario){
        for (Usuario usuarioID : usuarios){
            if (usuarioID.getIdUsuario() == idUsuario){
                return true;
            }
        }
        return false;
    }

    private boolean findUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }

    public Usuario queryUsuario(long idUsuario){
        Usuario resultBusq = null;
        if(!findUsuario(idUsuario)){
            return resultBusq;
        } else {
            for (Usuario usuario : usuarios){
                if (usuario.getIdUsuario() == idUsuario){
                    resultBusq = usuario;
                }
            }
        }
        return resultBusq;
    }

    public void printUsuarios(){
        System.out.println("Listado de usuarios:");
        for (int i = 0; i < usuarios.size(); i++){
            System.out.println(Colores.COLOR_VERDE + (i+1) + Colores.COLOR_RESET + " | " + usuarios.get(i));
        }
    }
}
