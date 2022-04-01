
package xadrez.pecas;

import xadrez.tabuleiro.Posicao;
import xadrez.tabuleiro.Tabuleiro;
import xadrez.xadrez.Cor;
import xadrez.xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez{
    
    public Peao(Cor cor, Tabuleiro tabuleiro){
        super(cor, tabuleiro);
    }
    

	/* Movimenta a peça para as direções que são possiveis dentro das regras do jogo */


    @Override
    public boolean[][] movimentosPossiveis(){
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao (0, 0);
        if(getCor() == Cor.WHITE){
            p.setValores(posicao.getLinha() - 1, posicao.getColuna());
            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() - 2, posicao.getColuna());
            Posicao p2 = new Posicao (posicao.getLinha() - 1, posicao.getColuna());
            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)
                    && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().existeUmaPeca(p2)
                    && getContadorMovimentos()==0) {  
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
            if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
        } else {
            p.setValores(posicao.getLinha() + 1, posicao.getColuna());
            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() + 2, posicao.getColuna());
            Posicao p2 = new Posicao (posicao.getLinha() - 1, posicao.getColuna());
            if(getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)
                    && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().existeUmaPeca(p2)
                    && getContadorMovimentos()==0) {  
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
            if(getTabuleiro().posicaoExiste(p) && verificaExistenciaPeçaOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
        }
        return mat;
    }
    
    @Override
    public String toString(){
        return "P";
    }
}
