package xadrez.pecas;

import xadrez.tabuleiro.Posicao;
import xadrez.tabuleiro.Tabuleiro;
import xadrez.xadrez.Cor;
import xadrez.xadrez.PecaDeXadrez;

public class Bispo extends PecaDeXadrez{
    
    public Bispo(Cor cor, Tabuleiro tabuleiro){
        super(cor, tabuleiro);
    }
    
    @Override
    public String toString(){
        return "B";
    }


	/* Movimenta a peça para as direções que são possiveis dentro das regras do jogo */

    
    @Override
    public boolean[][] movimentosPossiveis(){
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao (0, 0);
        //nordeste
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() -1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() - 1, p.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //noroeste
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() - 1, p.getColuna() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //sudeste
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() + 1, p.getColuna() + 1);
        }
        if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //sudoeste
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValores(p.getLinha() + 1, p.getColuna() - 1);
        }
        if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}

