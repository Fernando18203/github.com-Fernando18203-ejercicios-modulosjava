public class ArticuloBibliografico {

    // Atributos privados
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private boolean reservado; // marca si ya fue reservado en el sistema

    // Constructor
    public ArticuloBibliografico(int id, String titulo, String autor, int anoPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.reservado = false;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    // Comportamiento: calcular antigüedad respecto al año actual
    public int calcularAntiguedad(int anoActual) {
        return anoActual - anoPublicacion;
    }

    // Comportamiento: indicar si es reservable según antigüedad (> 5 años)
    public boolean esReservable(int anoActual) {
        return calcularAntiguedad(anoActual) > 5;
    }
}
