package xadrez.xadrez;

import xadrez.tabuleiro.Posicao;

	//Verifica as linhas e colunas do tabuleiro


public class PosicaoXadrez {
  private char coluna;
  private int linha;

    public PosicaoXadrez (char coluna, int linha) {
        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
        throw new ExcecaoXadrez("Erro instanciado! Valores validos são de A e E e 1 a 8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    protected Posicao convertePosicao() {
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static PosicaoXadrez posicaoOriginal (Posicao posicao) {
        return new PosicaoXadrez ((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }
  
    @Override
    public String toString() {
        return "" + coluna + linha;
    }

}
