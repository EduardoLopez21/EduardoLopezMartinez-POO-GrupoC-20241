package Tarea8;

class libros {
    private int id;
    private String titulo;
    private String autor;
    private boolean esRentado;

    public libros(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public boolean EsRentado() {
        return esRentado;
    }

    public void setEsRentado(boolean esRentado) {
        this.esRentado = esRentado;
    }

    @Override
    public String toString() {
        return "Libro:" + "id: " + id + ", titulo: " + titulo + '\'' + ", autor:'" + autor + '\'' + ", esRentado:" + esRentado;
    }
}
