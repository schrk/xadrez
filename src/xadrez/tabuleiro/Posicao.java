package xadrez.tabuleiro;

	//Armazena as linhas e colunas do tabuleiro, ou seja, as posições

public class Posicao {
    private int linha;
    private int coluna;
    
    public Posicao(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    public void setValores(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    
   
    public String ToString(){
        return linha + ", " + coluna;
    }
}
