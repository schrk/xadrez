package xadrez.tabuleiro;

//Informa como o tabuleiro está, se o jogador tentar fazer uma jogada que não é possivel, ele irá dar uma mensagem de erro e mostrar o que ele fez de errado

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peça[][] peças;
    
    public Tabuleiro(int linhas, int colunas){
        if(linhas < 1 || colunas < 1){
            throw new Excecaotabuleiro("Erro criando tabuleiro: deve existir ao menos 1 linha e coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        peças = new Peça[linhas][colunas];
    }
    
    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
    
    public Peça peça(int linha, int coluna){
        if(!posicaoExiste(linha, coluna)){
            throw new Excecaotabuleiro("Posicao não está no tabuleiro");
        }
        return peças[linha][coluna];
    }
    
    public Peça peça(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new Excecaotabuleiro("Posicao não está no tabuleiro");
        }
        return peças[posicao.getLinha()][posicao.getColuna()];
    }
    
    public void colocaPeça(Peça peça, Posicao posicao){
        if(!existeUmaPeca(posicao)){
            throw new Excecaotabuleiro("Já exite uma peça na posição " + posicao);
        }
        peças[posicao.getLinha()][posicao.getColuna()] = peça;
        peça.posicao = posicao;
    }
    
    private boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }
    
    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }
    
    public boolean existeUmaPeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new Excecaotabuleiro("Posicao não está no tabuleiro");
        }
        return peça(posicao) != null;
    }
    
    public Peça removePeça(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new Excecaotabuleiro("Posicao não está no tabuleiro");
        }
        if(peça(posicao) == null){
            return null;
        }
        Peça aux = peça(posicao);
        aux.posicao = null;
        peças[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }
}
