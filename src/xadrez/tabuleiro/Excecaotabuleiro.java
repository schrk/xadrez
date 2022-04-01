package xadrez.tabuleiro;

//Cria o método exceção no tabuleiro para informar uma mensagem

public class Excecaotabuleiro extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public Excecaotabuleiro(String msg){
        super(msg);
    }
}
