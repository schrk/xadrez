package xadrez.xadrez;

import xadrez.tabuleiro.Peça;
import xadrez.tabuleiro.Posicao;
import xadrez.tabuleiro.Tabuleiro;


	//Conta os movimentos, verifica as peças e se o jogo ainda não acabou


public abstract class PecaDeXadrez extends Peça {
    private Cor cor;
    private int contadorMovimentos;

    public PecaDeXadrez(Cor cor, Tabuleiro tabuleiro) {
        super(tabuleiro);
        this.cor = cor;
    }

    public int getContadorMovimentos(){
        return contadorMovimentos;
    }

    public Cor getCor() {
        return cor;
    }

    public PosicaoXadrez pegaPosicaoXadrez() {
        return PosicaoXadrez.posicaoOriginal(posicao);
    }

    protected boolean verificaExistenciaPeçaOponente(Posicao posicao) {
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro () .peça(posicao);
        return p != null && p.getCor() != cor;
    }

    public void incrementaContador() {
        contadorMovimentos++;
    }

    public void decrementaContador() {
        contadorMovimentos--;
    }
}
