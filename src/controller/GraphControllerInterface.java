package controller;
/**
 * 
 * @author Lauro �ngelo Gon�alves de Moraes 
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
             * @param node1		N� de origem da aresta.
             * @param node2		N� de destino da aresta.
             * @param weight	Peso da aresta.
             */
            public Edge(int node1, int node2, int weight) {
                    this.node1 = node1;
                    this.node2 = node2;
                    this.weight = weight;
            }
            /**
             * Retorna o n� de origem da aresta.
             * @return	Retorna o n� de origem da aresta.
             */
            public int getNode1(){
                    return this.node1;
            }
            /**
             * Retorna o n� de destino da aresta.
             * @return	Retorna o n� de destino da aresta.
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
     * Insere uma aresta orientada entre dois v�rtices informados por par�metro e atribui um peso a ele, que por padr�o ser� 1.
     * @param node1		V�rtice de origem.
     * @param node2		V�rtice de destino.
     * @param weight	Peso associado � aresta.
     * @return			Retorna true caso se consiga inserir a aresta com sucesso.
     */
    abstract public boolean insertEdge(int node1, int node2, int weight);
    
    /**
     * Insere uma aresta n�o-orientada entre dois v�rtices informados por par�metro e atribui um peso a ele, que por padr�o ser� 1
     * @param node1		Primeiro v�rtice.
     * @param node2		Segundo v�rtice.
     * @param weight	Peso associado � aresta.
     * @return			Retorna true caso se consiga inserir a aresta com sucesso.
     */
    abstract public boolean insertNonOrientedEdge(int node1, int node2, int weight);
    
    /**
     * Verifica se h� uma aresta entre dois v�rtices informados.
     * @param node1		Primeiro v�rtice.
     * @param node2		Segundo v�rtice.
     * @return			Retorna true caso a aresta exista.
     */
    abstract public boolean existsEdge(int node1, int node2);
    
    /**
     * Verifica se h� v�rtices adjacentes.
     * @param node1		V�rtice base da verifica��o.
     * @return			Retorna true caso a lista de adjac�ncia n�o esteja vazia.
     */
    abstract public boolean adjacencyListEmpty(int node1);
    
    /**
     * Verifica se h� v�rtices adjacentes e caso exista, retorna o primeiro de sua lista.
     * @param node1		V�rtice base da verifica��o.
     * @return			Retorna a aresta que liga o v�rtice ao seu primeiro adjacente ou null, casa n�o exista.
     */
    abstract public Edge adjacencyListFirst(int node1);
    
    /**
     * Retorna a pr�xima aresta do pr�ximo v�rtice da lista de adjac�ncia de um v�rtice.
     * @param node1		V�rtice base da verifica��o.
     * @return			Retorna a aresta do pr�ximo v�rtice da lista ou null caso esteja no final da lista.
     */
    abstract public Edge adjacencyNext(int node1);
    
    /**
     * Retira uma aresta de um grafo orientado.
     * @param node1		V�rtice de origem.
     * @param node2		V�rtice de destino.
     * @return			Retorna a resta removida ou null caso n�o seja poss�vel remov�-la.
     */
    abstract public Edge removeOrientedEdge(int node1, int node2);
    
    /**
     * Retira uma aresta de um grafo n�o-orientado.
     * @param node1		Primeiro v�rtice.
     * @param node2		Segundo v�rtice.
     * @return			Retorna a resta removida ou null caso n�o seja poss�vel remov�-la.
     */
    abstract public Edge removeNonOrientedEdge(int node1, int node2);
    
    /**
     * Retorna o n�mero total de v�rtices presentes no grafo.
     * @return	Retorna o n�mero total de v�rtices presentes no grafo.
     */
    abstract public int getTotalNodesNumber();
    
    /**
     * Retorna o n�mero total de arestas presentes no grafo.
     * @return	Retorna o n�mero total de arestas presentes no grafo.
     */
    abstract public int getTotalEdgesNumber(); 

}
