package xadrez.aplicacao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import xadrez.xadrez.JogoDeXadrez;
import xadrez.xadrez.PecaDeXadrez;
import xadrez.xadrez.PosicaoXadrez;
import xadrez.xadrez.ExcecaoXadrez;


	/*Se CHECKMATE for false ele irá continuar sendo executado, guarda em origem os dados do jogador e cria uma variavel para os metodos possiveis, quando a variavel é chamada o fundo fica amarelo de acordo com os possiveis movimentos da peça selecionada, depois ve se alguma peça foi capturada ou não */	



public class Xadrez {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoDeXadrez jogo = new JogoDeXadrez();
        List <PecaDeXadrez> capturadas = new ArrayList<>();
        while(!jogo.getCheckMate()){
            try{
                UI.clearScreen();
                UI.imprimePartida(jogo, capturadas);
                System.out.println();
                System.out.println("Origem: ");
                PosicaoXadrez origem = UI.lePosicao(sc);
            
                boolean[][] p = jogo.movimentosPossiveis(origem);
                UI.clearScreen();
                UI.imprimeTabuleiro(jogo.getPeças(), p );
            
                System.out.println();
                System.out.println("Destino: ");
                PosicaoXadrez destino = UI.lePosicao(sc);
            
                PecaDeXadrez peçaCapturada = jogo.realizaJogada(origem, destino);
                
                if(peçaCapturada != null){
                    capturadas.add(peçaCapturada);
                }
            } catch(ExcecaoXadrez e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                
            } catch(InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.imprimePartida(jogo, capturadas);
    }
}
