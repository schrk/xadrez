package xadrez.xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Bispo;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;
import xadrez.pecas.Peao;
import xadrez.pecas.Rainha;
import xadrez.tabuleiro.Posicao;
import xadrez.tabuleiro.Tabuleiro;
import xadrez.tabuleiro.Peça;

public class JogoDeXadrez {
    private Tabuleiro tabuleiro;
    private int turno;
    private Cor JogadorAtual;
    private boolean check;
    private boolean checkMate;

    private List<Peça> pecasNoTabuleiro = new ArrayList<>();
    private List<Peça> pecasCapturadas = new ArrayList<>();

public int getTurno(){
    return turno;
}

public boolean getCheckMate() {
    return checkMate;
}

public Cor getJogadorAtual(){
    return JogadorAtual;
}

public boolean getCheck() {
    return check;
}

	//Informa os valores iniciais ao tabuleiro, o turno que se encontra e o jogador que inicia o jogo


public JogoDeXadrez() {
    tabuleiro = new Tabuleiro(8,8);
    turno = 1;
    JogadorAtual = Cor.WHITE;
    setupInicial();
}


 	//Contador utilizado para contar os turnos


private void proximaRodada () {
    turno++;
    JogadorAtual = (JogadorAtual == Cor.WHITE) ? Cor.BLACK : Cor. WHITE;
}


	//Coordenadas das peças


public PecaDeXadrez[][] getPeças() {
    PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
    for (int i = 0; i < tabuleiro.getLinhas(); i++) {
        for (int j = 0; j > tabuleiro.getColunas(); j++) {
            mat[i][j] = (PecaDeXadrez) tabuleiro.peça(i,j);
        }
    }
    return mat;
}


	    //Coloca uma nova peça no tabuleiro


private void colocaNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
    tabuleiro.colocaPeça(peca, new PosicaoXadrez(coluna, linha).convertePosicao());
    pecasNoTabuleiro.add(peca);
}


	 //Coloca as peças iniciais no tabuleiro


private void setupInicial() {
    colocaNovaPeca('a', 1, new Torre(Cor.WHITE, tabuleiro));
    colocaNovaPeca('b', 1, new Cavalo(Cor.WHITE, tabuleiro));
    colocaNovaPeca('c', 1, new Bispo(Cor.WHITE, tabuleiro));
    colocaNovaPeca('d', 1, new Rainha(Cor.WHITE, tabuleiro));
    colocaNovaPeca('e', 1, new Rei(Cor.WHITE, tabuleiro));
    colocaNovaPeca('f', 1, new Bispo(Cor.WHITE, tabuleiro));
    colocaNovaPeca('g', 1, new Cavalo(Cor.WHITE, tabuleiro));
    colocaNovaPeca('h', 1, new Torre(Cor.WHITE, tabuleiro));
    colocaNovaPeca('a', 2, new Peao(Cor.WHITE, tabuleiro));
    colocaNovaPeca('b', 2, new Peao(Cor.WHITE, tabuleiro));
    colocaNovaPeca('c', 2, new Peao(Cor.WHITE, tabuleiro));
    colocaNovaPeca('d', 2, new Peao(Cor.WHITE, tabuleiro));
    colocaNovaPeca('e', 2, new Peao(Cor.WHITE, tabuleiro));
    colocaNovaPeca('f', 2, new Peao(Cor.WHITE, tabuleiro));
    colocaNovaPeca('g', 2, new Peao(Cor.WHITE, tabuleiro));
    colocaNovaPeca('h', 2, new Peao(Cor.WHITE, tabuleiro));

    colocaNovaPeca('a', 8, new Torre(Cor.BLACK, tabuleiro));
    colocaNovaPeca('b', 8, new Cavalo(Cor.BLACK, tabuleiro));
    colocaNovaPeca('c', 8, new Bispo(Cor.BLACK, tabuleiro));
    colocaNovaPeca('d', 8, new Rainha(Cor.BLACK, tabuleiro));
    colocaNovaPeca('e', 8, new Rei(Cor.BLACK, tabuleiro));
    colocaNovaPeca('f', 8, new Bispo(Cor.BLACK, tabuleiro));
    colocaNovaPeca('g', 8, new Cavalo(Cor.BLACK, tabuleiro));
    colocaNovaPeca('h', 8, new Torre(Cor.BLACK, tabuleiro));
    colocaNovaPeca('a', 7, new Peao(Cor.BLACK, tabuleiro));
    colocaNovaPeca('b', 7, new Peao(Cor.BLACK, tabuleiro));
    colocaNovaPeca('c', 7, new Peao(Cor.BLACK, tabuleiro));
    colocaNovaPeca('d', 7, new Peao(Cor.BLACK, tabuleiro));
    colocaNovaPeca('e', 7, new Peao(Cor.BLACK, tabuleiro));
    colocaNovaPeca('f', 7, new Peao(Cor.BLACK, tabuleiro));
    colocaNovaPeca('g', 7, new Peao(Cor.BLACK, tabuleiro));
    colocaNovaPeca('h', 7, new Peao(Cor.BLACK, tabuleiro));
    
}


	//Informa se na posição há uma peça, de quem é a peça e se ela pode ser utilizada


private void validaMovimentoOrigem(Posicao posicao) {
    if (!tabuleiro.existeUmaPeca(posicao)) {
        throw new ExcecaoXadrez("Não existe peça na posicao!");
    }
    if (JogadorAtual != ((PecaDeXadrez)tabuleiro.peça(posicao)).getCor()) {
        throw new ExcecaoXadrez("A peça escolhida não é sua!");
    }
    if (!tabuleiro.peça(posicao).existeMovimentoPossivel()) {
        throw new ExcecaoXadrez ("Não existe movimento possível!");
    }
}


	//Lê onde a peça está e para onde vai, se o valor da casa for nulo ele vai para lá, se não for nulo, significa que há outra peça la que vai ser adicionada as peças capturadas

private Peça fazMovimento(Posicao origem, Posicao destino) {
    PecaDeXadrez p = (PecaDeXadrez) tabuleiro.removePeça(origem);
    p.incrementaContador();
    Peça peçaCapturada = tabuleiro.removePeça(destino);
    tabuleiro.colocaPeça(p, destino);
    if (peçaCapturada != null) {
        pecasNoTabuleiro.remove(peçaCapturada);
        pecasCapturadas.add(peçaCapturada);
    }
    return peçaCapturada;
}


	 //metodo que desfaz uma jogada, atraves do atributo p que recebe o valor da peca retira da posicao origem, depois o metodo colocaPeca coloca p em posicao origem, caso pecaCapturada nao seja nulo, o metodo colocaPeca ira colocar pecaCapturada em posicao destino, depois PecaCapturada será retirada de PecasCapturadas e sera adcionada a Tabuleiro
	

private void desfazMovimento(Posicao origem, Posicao destino, Peça pecaCapturada) {
    PecaDeXadrez p = (PecaDeXadrez) tabuleiro.removePeça (destino);
    p.decrementaContador();
    tabuleiro.colocaPeça(p, origem);

    if (pecaCapturada != null) {
        tabuleiro.colocaPeça(pecaCapturada, destino);
        pecasCapturadas.remove(pecaCapturada);
        pecasNoTabuleiro.add(pecaCapturada);
    }
}


	//Checa se a peça pode se movimentar até a posição desejada, se não puder ira abrir a excecaoxadrez


private void validaMovimentoDestino(Posicao origem, Posicao destino) {
    if (!tabuleiro.peça(origem).movimentosPossiveis(destino)) {
        throw new ExcecaoXadrez("Peça escolhida não pode se mover a posição de destino!");
    }
}


	//Compila os metodos anteriores para checar se vai haver um CHECK ou um CHECKMATE, se for false o jogo continuará normalmente, só retorna peça capturada


public PecaDeXadrez realizaJogada(PosicaoXadrez origem, PosicaoXadrez destino) {
    Posicao o = origem.convertePosicao();
    Posicao d =   destino.convertePosicao();
    validaMovimentoOrigem(o);
    validaMovimentoDestino(o,d);
    Peça peçaCapturada = fazMovimento(o,d);
    if (testaCheck(JogadorAtual)) {
        desfazMovimento(o,d,peçaCapturada);
        throw new ExcecaoXadrez("Você não pode se colocar em check!");
    }
    check = (testaCheck(oponente(JogadorAtual))) ? true : false;

    if (testaCheck(oponente(JogadorAtual))) {
        checkMate = true;
    } else {
        proximaRodada();
    }
    return (PecaDeXadrez) peçaCapturada;
}

	//Valida um movimento


public boolean[][] movimentosPossiveis (PosicaoXadrez posicaoOrigem) {
    Posicao posicao = posicaoOrigem.convertePosicao();
    validaMovimentoOrigem(posicao);
    return tabuleiro.peça(posicao).movimentosPossiveis();
}


	//Checa a cor do oponente


private Cor oponente(Cor cor) {
    return (cor == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
}

	//Checa que se o Rei ainda não foi capturado, abre um exceção se ele foi

private PecaDeXadrez rei(Cor cor) {
    List<Peça> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == cor)
        .collect(Collectors.toList());
    for (Peça p : list) {
        if (p instanceof Rei) {
            return (PecaDeXadrez) p;
        }
    }  
    throw new IllegalStateException("Nao existe rei no tabuleiro!");
}

private boolean testaCheck (Cor cor) {
    Posicao posicaoRei = rei(cor).pegaPosicaoXadrez().convertePosicao();
    List <Peça> peçasOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
    for (Peça p: peçasOponente) {
        boolean[][] mat = p.movimentosPossiveis();
        if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
            return true;
        }
    }
    return false;
}


	//Testa o CHECKMATE


private boolean testaCheckMate (Cor cor) {
    if (!testaCheck(cor)) {
        return false;
    }
    List<Peça> lista = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == cor)
        .collect(Collectors.toList());
        for (Peça p: lista) {
            boolean [][] mat = p.movimentosPossiveis();
            for (int i = 0; i < tabuleiro.getLinhas(); i++) {
                for (int j = 0; j <tabuleiro.getColunas(); j++) {
                    if (mat[i][j]) {
                        Posicao origem = ((PecaDeXadrez)p).pegaPosicaoXadrez().convertePosicao();
                        Posicao destino = new Posicao (i,j);
                        Peça peçaCapturada = fazMovimento(origem,destino);
                        boolean testCheck = testaCheck(cor);
                        desfazMovimento(origem,destino,peçaCapturada);
                        if (!testCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
