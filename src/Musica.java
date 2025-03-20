public class Musica {
    private String titulo;
    private String artista;
    private Integer duracao;

    public Musica(String titulo, String artista, Integer duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void exibirInformacao() {
        System.out.println("Nome: " + titulo + " | Feito por: " + artista + " | Duração: " + duracao + " minutos");
    }
}
