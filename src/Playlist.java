public class Playlist {
    private String nome;
    private Musica[] listaDeMusicas= {};

    public Playlist(String nome) {
        this.nome = nome;
        this.listaDeMusicas = new Musica[0]; // Inicializa um array vazio
    }

    public void addListaDeMusica(Musica[] musicas) {
        listaDeMusicas = musicas;
    }
    public Musica[] getListaDeMusicas(){
        return this.listaDeMusicas;
    }
    public void informacoesPlaylist() {
        int tempoTotal = 0;
        StringBuilder musicasFormatadas = new StringBuilder();

        for (Musica musica : listaDeMusicas) {
            musicasFormatadas.append("- ").append(musica.getTitulo()).append("\n");
            tempoTotal += musica.getDuracao();
        }
        int horas = tempoTotal / 60;
        int minutos = tempoTotal % 60;
        String tempoFormatado = String.format("%02d:%02d", horas, minutos);
        System.out.println("Playlist: " + nome);
        System.out.println("Tempo total: " + tempoFormatado);
        System.out.print(musicasFormatadas);
    }
}
