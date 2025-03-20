import java.util.Scanner;

public class Main {
    static Scanner leitor = new Scanner(System.in);
    static MusicCloud musicCloud = new MusicCloud();

    public static void main(String[] args) {
        texto("Qual o nome da Playlist: ");
        Playlist playlist = new Playlist(ler());
        boolean isAddMusic = true;
        while (isAddMusic) {
            texto("Digite o nome da música: ");
            String nomeMusica = ler();
            Object musicaProcurada = musicCloud.searchMusic(nomeMusica);
            if (musicaProcurada instanceof String) {
                boolean resposta = continuar();
                if (resposta) {
                    Musica novaMusica = adicionarNovaMusicaMusicCloud(nomeMusica);
                    adicionarNovaMusicaPlayList(playlist, novaMusica);
                }
            } else if (musicaProcurada instanceof Musica) {
                adicionarNovaMusicaPlayList(playlist, (Musica) musicaProcurada);
                texto("Música já estava no Music Cloud e foi adicionada à Playlist!");
            }
            texto("Deseja adicionar mais músicas à playlist? (s/n): ");
            String continuar = ler();
            if (!continuar.equalsIgnoreCase("s")) {
                playlist.informacoesPlaylist();
                isAddMusic = false; // Sai do loop
            }
        }
    }

    static void texto(String texto) {
        System.out.println(texto);
    }

    static String ler() {
        return leitor.nextLine();
    }

    static void adicionarNovaMusicaPlayList(Playlist playlist, Musica musica) {
        Musica[] musicasAtuais = playlist.getListaDeMusicas();
        Musica[] novoArray = new Musica[musicasAtuais.length + 1];
        System.arraycopy(musicasAtuais, 0, novoArray, 0, musicasAtuais.length);
        novoArray[novoArray.length - 1] = musica;
        playlist.addListaDeMusica(novoArray);
        texto("Música adicionada à Playlist!");
    }

    static Musica adicionarNovaMusicaMusicCloud(String nomeMusica) {
        texto("Digite o nome do artista: ");
        String artista = ler();
        texto("Digite a duração da música (minutos): ");
        int duracao = Integer.parseInt(ler());
        Musica novaMusica = new Musica(nomeMusica, artista, duracao);
        Musica[] novoArray = new Musica[musicCloud.musicasDisponiveis.length + 1];
        System.arraycopy(musicCloud.musicasDisponiveis, 0, novoArray, 0, musicCloud.musicasDisponiveis.length);
        novoArray[novoArray.length - 1] = novaMusica;
        musicCloud.addNovaMusica(novoArray);
        texto("Música adicionada ao Music Cloud!");
        return novaMusica;
    }

    static boolean continuar() {
        texto("Deseja adicionar essa música ao Music Cloud? (s/n): ");
        String resposta = ler();
        return resposta.equalsIgnoreCase("s");
    }
}
