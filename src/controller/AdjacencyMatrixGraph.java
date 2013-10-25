package controller;

public class AdjacencyMatrixGraph implements GraphControllerInterface {
	private int matrix[][];		// Pesos do tipo inteiro.
	private int positions[];	// Posição atual do vértice de adjacência vistado para cada vértice.
	private int adjacencyNum[];	// Vetor booleano para se saber se uma lista de adjacência está vazia.
	private int numberOfEdges;
	
	public AdjacencyMatrixGraph(int graph_size) {
		this.matrix			= new int[graph_size][graph_size];
		this.positions		= new int[graph_size];
		this.adjacencyNum	= new int[graph_size];
		this.numberOfEdges	= 0;
		
		for(int i=0; i<graph_size; i++) {
			for(int j=0; j<graph_size; j++) {
				// Configura os valores iniciais da matriz de adjacências do grafo.
				this.matrix[i][j] = 0;
			}
			// Configura a posição inicial dentro do vetor de posições das listas de adjacências.
			this.positions[i] = -1;
			this.adjacencyNum[i] = 0;
		}
	}
	
	@Override
	public boolean insertEdge(int node1, int node2, int weight) {
		try {
			// Inserção unidirecional.
			this.matrix[node1][node2] = weight;
			this.adjacencyNum[node1]++;
			this.numberOfEdges++;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertNonOrientedEdge(int node1, int node2, int weight) {
		try {
			// Inserção bidirecional.
			this.matrix[node1][node2] = weight;
			this.matrix[node2][node1] = weight;
			this.adjacencyNum[node1]++;
			this.adjacencyNum[node2]++;
			this.numberOfEdges++;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean existsEdge(int node1, int node2) {
		try {
			return (this.matrix[node1][node2] > 0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean adjacencyListEmpty(int node1) {
		try {
			if(this.adjacencyNum[node1] == 0)
				return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Edge adjacencyListFirst(int node1) {
		try {
			this.positions[node1] = -1;
			return this.adjacencyNext(node1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Edge adjacencyNext(int node1) {
		try {
				this.positions[node1]++;
				while( (this.positions[node1] < this.positions.length) && (this.matrix[node1][this.positions[node1]] == 0) ) {
					this.positions[node1]++;
				}
		        if(this.positions[node1] == this.positions.length) {
		        	return null;
		        } else {
		        	return new Edge(node1, this.positions[node1], this.matrix[node1][this.positions[node1]]);
		        }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Edge removeOrientedEdge(int node1, int node2) {
		try {
			if(this.matrix[node1][node2] == 0) {
				return null; // Aresta não existe
			}
	        else {
				Edge edge = new Edge (node1, node2, this.matrix[node1][node2]);
				this.matrix[node1][node2] = 0;
				this.adjacencyNum[node1]--;
				this.numberOfEdges--;
				return edge;
	        }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Edge removeNonOrientedEdge(int node1, int node2) {
		try {
			if(this.matrix[node1][node2] == 0) {
				return null; // Aresta não existe
			}
	        else {
				Edge edge = new Edge (node1, node2, this.matrix[node1][node2]);
				this.matrix[node1][node2] = 0;
				this.matrix[node2][node1] = 0;
				this.adjacencyNum[node1]--;
				this.adjacencyNum[node2]--;
				this.numberOfEdges--;
				return edge;
	        }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTotalNodesNumber() {
		try {
			return this.positions.length;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getTotalEdgesNumber() {
		try {
			return this.numberOfEdges;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
