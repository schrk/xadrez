package xadrez.xadrez;

	//Cria o método exceção no jogo, mostra os erros, etc

import xadrez.tabuleiro.Excecaotabuleiro;

public class ExcecaoXadrez extends Excecaotabuleiro {

    private static final long serialVersionUID = 1L;

    public ExcecaoXadrez (String msg) {
        super(msg);
    }

}
