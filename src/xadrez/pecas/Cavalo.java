package xadrez.pecas;

import xadrez.tabuleiro.Posicao;
import xadrez.tabuleiro.Tabuleiro;
import xadrez.xadrez.Cor;
import xadrez.xadrez.PecaDeXadrez;

public class Cavalo extends PecaDeXadrez {

    public Cavalo(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "C";
    }


	/* Movimenta a peça para as direções que são possiveis dentro das regras do jogo */
	

    private boolean podeMover(Posicao posicao) {
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peça(posicao);
        return p == null || p.getCor() != getCor();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro() .getLinhas()][getTabuleiro() .getColunas()];  
        Posicao p = new Posicao (0,0);
        p.setValores(posicao.getLinha () - 1, posicao.getColuna() -2);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
      }
        p.setValores(posicao.getLinha () - 2, posicao.getColuna() -1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
      }
        p.setValores(posicao.getLinha () - 2, posicao.getColuna() +1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
      }
        p.setValores(posicao.getLinha () - 1, posicao.getColuna() +2);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
      }
        p.setValores(posicao.getLinha () + 1, posicao.getColuna() +2);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
      }
        p.setValores(posicao.getLinha () + 2, posicao.getColuna() +1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
      }
        p.setValores(posicao.getLinha () + 2, posicao.getColuna() -1);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
      }
        p.setValores(posicao.getLinha () + 1, posicao.getColuna() -2);
        if (getTabuleiro() .posicaoExiste(p) && podeMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;  
    }
}
