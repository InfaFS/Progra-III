public class Parcial {
	public Resultado resolver(Grafo<String> ciudades, String origen, int montoMax) {
		
		Resultado resultado = new Resultado();
		resultado.setMontoSobrante(montoMax);
		
		if (ciudades != null && !ciudades.esVacio()) {
			ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
			boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
			
			ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
			vertices.comenzar();
			//Busco el vertice inicial con el cual quiero comenzar a recorrer
			Vertice<String> vInicial = null;
			while(!vertices.fin() && vInicial == null){
				Vertice<String> vertice = vertices.proximo();
				if (vertice.dato().equals(origen)){
					vInicial = vertice;
				}
			}

			if (vInicial != null){
				dfs(vInicial, ciudades, visitados, camino, resultado, montoMax);
			}
		}
		return resultado;
	}

	private void dfs(Vertice<String> vInicial, Grafo<String> ciudades, boolean[] visitados,
			ListaGenerica<String> camino, Resultado resultado, int montoMax) {
		
		visitados[vInicial.getPosicion()] = true;
		camino.agregarFinal(vInicial.dato());
        
		if (camino.tamanio() > resultado.getCamino().tamanio() || (camino.tamanio() == resultado.getCamino().tamanio() && resultado.getMontoSobrante() < montoMax)){
            resultado.setCamino(camino);
            resultado.setMontoSobrante(montoMax);
		}

		ListaGenerica<Arista<String>> adyacentes = ciudades.listaDeAdyacentes(vInicial);
		adyacentes.comenzar();
 		while(!adyacentes.fin()){
			Arista<String> arista = adyacentes.proximo();
			int posicion = arista.getVerticeDestino().getPosicion();
			if(montoMax-arista.peso() >= 0 && !visitados[posicion]){
				dfs(arista.getVerticeDestino(), ciudades, visitados, camino, resultado, montoMax-arista.peso());
			}
		}

		visitados[vInicial.getPosicion()] = false;
		camino.eliminarEn(camino.tamanio()-1);

	}
}