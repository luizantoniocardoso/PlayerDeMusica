public class MusicCloud {
    Musica[] musicasDisponiveis = {};

    public void addNovaMusica(Musica[] musicas){
        musicasDisponiveis = musicas;
    }


    public Object searchMusic(String nomeMusica) {
        if (musicasDisponiveis.length == 0) {return "nenhuma musica encontrada no Music Cloud";}
        for (Musica musica : musicasDisponiveis) {
            if (musica.getTitulo().equalsIgnoreCase(nomeMusica)) {
                return musica;
            }
        }
        return "";
    }
}
