package controller;
/**
 * 
 * @author Lauro Ângelo Gonçalves de Moraes 
 *
 */
public interface GraphControllerInterface {

	/**
	 * @class	Classe definida estaticamente para representar as arestas do grafo.
	 */
    public static class Edge {
            private int node1, node2, weight;
            /**
             * Construtor da classe.
             * @param node1		Nó de origem da aresta.
             * @param node2		Nó de destino da aresta.
             * @param weight	Peso da aresta.
             */
            public Edge(int node1, int node2, int weight) {
                    this.node1 = node1;
                    this.node2 = node2;
                    this.weight = weight;
            }
            /**
             * Retorna o nó de origem da aresta.
             * @return	Retorna o nó de origem da aresta.
             */
            public int getNode1(){
                    return this.node1;
            }
            /**
             * Retorna o nó de destino da aresta.
             * @return	Retorna o nó de destino da aresta.
             */
            public int getNode2(){
                    return this.node2;
            }
            /**
             * Retorna o peso da aresta.
             * @return	Retorna o peso da aresta.
             */
            public int getWeight(){
                    return this.weight;
            }
    }
    
    /**
     * Insere uma aresta orientada entre dois vértices informados por parâmetro e atribui um peso a ele, que por padrão será 1.
     * @param node1		Vértice de origem.
     * @param node2		Vértice de destino.
     * @param weight	Peso associado à aresta.
     * @return			Retorna true caso se consiga inserir a aresta com sucesso.
     */
    abstract public boolean insertEdge(int node1, int node2, int weight);
    
    /**
     * Insere uma aresta não-orientada entre dois vértices informados por parâmetro e atribui um peso a ele, que por padrão será 1
     * @param node1		Primeiro vértice.
     * @param node2		Segundo vértice.
     * @param weight	Peso associado à aresta.
     * @return			Retorna true caso se consiga inserir a aresta com sucesso.
     */
    abstract public boolean insertNonOrientedEdge(int node1, int node2, int weight);
    
    /**
     * Verifica se há uma aresta entre dois vértices informados.
     * @param node1		Primeiro vértice.
     * @param node2		Segundo vértice.
     * @return			Retorna true caso a aresta exista.
     */
    abstract public boolean existsEdge(int node1, int node2);
    
    /**
     * Verifica se há vértices adjacentes.
     * @param node1		Vértice base da verificação.
     * @return			Retorna true caso a lista de adjacência não esteja vazia.
     */
    abstract public boolean adjacencyListEmpty(int node1);
    
    /**
     * Verifica se há vértices adjacentes e caso exista, retorna o primeiro de sua lista.
     * @param node1		Vértice base da verificação.
     * @return			Retorna a aresta que liga o vértice ao seu primeiro adjacente ou null, casa não exista.
     */
    abstract public Edge adjacencyListFirst(int node1);
    
    /**
     * Retorna a próxima aresta do próximo vértice da lista de adjacência de um vértice.
     * @param node1		Vértice base da verificação.
     * @return			Retorna a aresta do próximo vértice da lista ou null caso esteja no final da lista.
     */
    abstract public Edge adjacencyNext(int node1);
    
    /**
     * Retira uma aresta de um grafo orientado.
     * @param node1		Vértice de origem.
     * @param node2		Vértice de destino.
     * @return			Retorna a resta removida ou null caso não seja possível removê-la.
     */
    abstract public Edge removeOrientedEdge(int node1, int node2);
    
    /**
     * Retira uma aresta de um grafo não-orientado.
     * @param node1		Primeiro vértice.
     * @param node2		Segundo vértice.
     * @return			Retorna a resta removida ou null caso não seja possível removê-la.
     */
    abstract public Edge removeNonOrientedEdge(int node1, int node2);
    
    /**
     * Retorna o número total de vértices presentes no grafo.
     * @return	Retorna o número total de vértices presentes no grafo.
     */
    abstract public int getTotalNodesNumber();
    
    /**
     * Retorna o número total de arestas presentes no grafo.
     * @return	Retorna o número total de arestas presentes no grafo.
     */
    abstract public int getTotalEdgesNumber(); 

}
