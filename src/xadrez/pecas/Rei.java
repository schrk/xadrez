package xadrez.pecas;

import xadrez.tabuleiro.Tabuleiro;
import xadrez.xadrez.Cor;
import xadrez.xadrez.PecaDeXadrez;
import xadrez.tabuleiro.Posicao;

public class Rei extends PecaDeXadrez {

    public Rei(Cor cor, Tabuleiro tabuleiro) {
      super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "K";
    }
    
    private boolean podeMover(Posicao posicao) {
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro() .peça(posicao);
        return p == null || p.getCor() != getCor();
    }


	/* Movimenta a peça para as direções que são possiveis dentro das regras do jogo */

    
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro() .getLinhas()][getTabuleiro() .getColunas()];
        Posicao p = new Posicao (0,0);
     
        p.setValores(posicao.getLinha() -1, posicao.getColuna());
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() +1, posicao.getColuna());
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna() -1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna() +1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() -1, posicao.getColuna() -1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() -1, posicao.getColuna() +1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() +1, posicao.getColuna() +1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
        mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() +1, posicao.getColuna() +1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}
