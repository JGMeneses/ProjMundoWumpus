public class Agente {
	int iAtual, jAtual;//Posição atual do agente, linha e coluna
	
	boolean percep[]; //[brisa, fedor, brilho,poco,Wumpus,tesouro,agente],Array de percepções do agente
	
	public Agente(MundoWumpus mw, int iInicial, int jInicial) {
		iAtual = iInicial;
		jAtual = jInicial;
		percep = new boolean[7];// Inicializa o array de percepções com tamanho 7
		mw.inserirAgente(iAtual,jAtual);// Insere o agente no mundo Wumpus
		this.setPercep(mw);// Define as percepções iniciais do agente
	}
	
	public int[] getPosicaoAtual() {
		int posAtual[] = new int[2];
		posAtual[0] = iAtual;
		posAtual[1] = jAtual;
		return posAtual; // Retorna a posição atual do agente como um array de inteiros
	}
	
	public void setPosAtual(int i, int j) {
		iAtual = i;
		jAtual = j;
	}
	
	public boolean[] getPercep() {
		return percep;// Retorna as percepções do agente
	}
	
	public void setPercep(MundoWumpus mw) {
		int i;
		boolean[] p = mw.getPercepcoesSala(iAtual, jAtual); // Obtém as percepções da sala atual do mundo Wumpus
		for(i=0; i<7; i++) {
			percep[i] = p[i];// Copia as percepções para o array de percepções do agente
		}
	}
	
	public void mover(int iNovo, int jNovo, MundoWumpus mw) {
		mw.atualizarAgente(iAtual, jAtual, iNovo, jNovo);// Atualiza a posição do agente no mundo Wumpus
		this.setPosAtual(iNovo,jNovo);// Define a nova posição do agente
		this.setPercep(mw);// Define as percepções da nova sala do agente
	}
	

}



