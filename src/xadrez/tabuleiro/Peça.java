package xadrez.tabuleiro;

//Enxerga os movimentos possíveis das peças


public abstract class Peça {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;
    
    public Peça(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }
    
    protected Tabuleiro getTabuleiro(){
        return tabuleiro;
    }
    
    public abstract boolean[][] movimentosPossiveis();
    
    public boolean movimentosPossiveis(Posicao posicao){
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }
    
    public boolean existeMovimentoPossivel(){
        boolean[][] mat =  movimentosPossiveis();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
