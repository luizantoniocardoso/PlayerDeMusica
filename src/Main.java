import java.util.Scanner;

public class Main {

    static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) {


        escreverTexto("Qual o nome da Playlist: ");
        String PlaylistFav = ler();



    }


    static void escreverTexto(String texto){
        System.out.println(texto);
    }

    static String ler(){
        return leitor.nextLine();
    }
}