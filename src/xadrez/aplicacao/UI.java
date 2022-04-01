package xadrez.aplicacao;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import xadrez.xadrez.Cor;
import xadrez.xadrez.JogoDeXadrez;
import xadrez.xadrez.PecaDeXadrez;
import xadrez.xadrez.PosicaoXadrez;

public class UI {

	//Atribuindo cores para as letras
    
    public static final String RESET = "\033[0m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";


	//Atribuindo cores para o background
            
    public static final String ANSI_BLACK_BACKGROUND = "u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "u001B[47m";

	//Metodo para gerar o tabuleiro de rodada impar, ou seja, quando o jogador está selecionando a peça, a matriz "pecas" irá informar o tamanho das linhas e colunas
            
    public static void imprimeTabuleiro(PecaDeXadrez[][] peças) {
        for(int i = 0; i < peças.length; i++){
            System.out.print((8-i) + " ");
            for(int j = 0; j < peças.length; j++){
                imprimePeça(peças[i][j], false);
            }
            System.out.println();
        }
        System.out.println(" a b c d e f g h");
    }
    
	//Imprime as peças e coloca "-" onde não há peças, colore as casas dos possiveis movimentos

    private static void imprimePeça(PecaDeXadrez peça, boolean fundo){
        if(fundo == true){
            System.out.print(ANSI_YELLOW_BACKGROUND);
        }
        if(peça == null){
            System.out.print("-" + RESET);
        } else {    
            if(peça.getCor() == Cor.WHITE){
                System.out.print(RED_BOLD + peça + RESET);
            } else {
                System.out.print(peça);
            }
        }
        System.out.print(" ");
    }
    
	//Lê a posição em que o jogador escolher botar a peça, se for invalido irá printar "Valor Inválido!"

    public static PosicaoXadrez lePosicao(Scanner sc){
        try{
            String s = sc.nextLine();
            char coluna = s.charAt(0);
            int linha =  Integer.parseInt(s.substring(1));
            return new PosicaoXadrez(coluna, linha);
        } catch(RuntimeException e) {
            throw new InputMismatchException("Valor Inválido!");
        }
    }

	//Contador que limpa a tela "clearscreen"
    
    public static void clearScreen(){
        for(int i = 0; i < 30; i++){
            System.out.println();
        }
        System.out.flush();
    }
    
	//Mostra no tabuleiro as jogadas que podem ser feitas com a peça escolhida

    public static void imprimeTabuleiro(PecaDeXadrez[][] peças, boolean[][] mp){
        for(int i = 0; i < peças.length; i++){
            System.out.print((8-i) + " ");
            for(int j = 0; j < peças.length; j++){
                imprimePeça(peças[i][j], mp[i][j]);
            }
            System.out.println();
        }
        System.out.println(" a b c d e f g h");
    }

	//Informa as peças capturadas, o numero de jogadas, o turno e informa se ocorrer um check ou um checkmate
    
    public static void imprimePartida(JogoDeXadrez jogo, List<PecaDeXadrez> capturadas){
        imprimeTabuleiro(jogo.getPeças());
        System.out.println();
        imprimePecasCapturadas(capturadas);
        System.out.println("Rodada " + jogo.getTurno());
        System.out.println("Jogador Atual: "  + jogo.getJogadorAtual());
        if(!jogo.getCheckMate()){
            if(jogo.getCheck()){
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("CHECKMATE!");
            System.out.println("Vencedor: " + jogo.getJogadorAtual());
        }
    }
    
	 //Faz uma lista com as peças capturadas

    private static void imprimePecasCapturadas(List<PecaDeXadrez> capturadas){
        List<PecaDeXadrez> brancas = capturadas.stream().filter(x -> x.getCor() == Cor.WHITE)
                .collect(Collectors.toList());
        List<PecaDeXadrez> pretas = capturadas.stream().filter(x -> x.getCor() == Cor.BLACK)
                .collect(Collectors.toList());
        
        System.out.println("Peças capturadas: ");
        System.out.print("Brancas: ");
        System.out.print(RED_BOLD);
        System.out.println(Arrays.toString(brancas.toArray()));
        System.out.print(RESET);
        
        System.out.println("Peças capturadas: ");
        System.out.print("Pretas: ");
        System.out.print(BLACK_BOLD);
        System.out.println(Arrays.toString(pretas.toArray()));
        System.out.print(RESET);
    }
}
