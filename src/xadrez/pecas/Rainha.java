package xadrez.pecas;

import xadrez.tabuleiro.Tabuleiro;
import xadrez.xadrez.Cor;
import xadrez.xadrez.PecaDeXadrez;
import xadrez.tabuleiro.Posicao;

public class Rainha extends PecaDeXadrez {

    public Rainha(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    @Override
    public String toString() {
        return "Q";
    }


	/* Movimenta a peça para as direções que são possiveis dentro das regras do jogo */

    
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro() .getLinhas()][getTabuleiro() .getColunas()];
        Posicao p = new Posicao (0,0); 
        p.setValores(posicao.getLinha () - 1, posicao.getColuna() -1);
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() -1, p.getColuna() -1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() -1, posicao.getColuna() +1);
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() -1, p.getColuna() +1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() +1, posicao.getColuna() +1);
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() +1, p.getColuna() +1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() +1, posicao.getColuna() -1);
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() +1, p.getColuna() -1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() -1, posicao.getColuna());
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() -1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna() -1);
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() -1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna() +1);
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() +1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() +1, posicao.getColuna());
        while (getTabuleiro() .posicaoExiste(p) && !getTabuleiro() .existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() +1);
        }
        if (getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}
