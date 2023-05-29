

public class AristaNOdirigida<T> implements Arista<T> {
	private Vertice<T> vertice_uno;
    private Vertice<T> vertice_dos;

	private int peso;
	
	public AristaNOdirigida(Vertice<T> vertice1,Vertice<T> vertice2, int p){
			this.vertice_uno=vertice1;
            this.vertice_dos=vertice2;
			peso = p;
	}

	@Override
	public Vertice<T> getVerticeUNO() {
		return this.vertice_uno;
	}
    
	public Vertice<T> getVerticeDOS() {
		return this.vertice_dos;
	}
	@Override
	public int peso() {
		return peso;
	}
}

