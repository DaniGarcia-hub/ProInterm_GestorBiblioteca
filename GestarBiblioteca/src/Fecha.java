package GestarBiblioteca.src;

public class Fecha {
    private String dia, mes, anyo, hora, minutos, segundos;

    public Fecha(String dia, String mes, String anyo, String hora, String minutos, String segundos){
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getSegundos() {
        return segundos;
    }

    public void setSegundos(String segundos) {
        this.segundos = segundos;
    }
}
