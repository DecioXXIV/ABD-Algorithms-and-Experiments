import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BatageljZaversnik {

	public Map<Integer, List<Integer>> graph;
	public int nodes;
	public Integer[] degree;
	public Integer[] bin;
	public Integer[] sort;
	public Integer[] pos;
	
	public BatageljZaversnik(Graph graph) {
		this.graph = graph.getGraph();
		this.nodes = this.graph.keySet().size();
		
		this.degree = new Integer[this.nodes];
		this.sort = new Integer[this.nodes];
		this.pos = new Integer[this.nodes];
		this.bin = null;
	}
	
	public void BZAlgorithm() {
		
		// Step 1: inizializzazione
		computeDegree();
		buildBin();
		buildSortAndPos();
		resetBin();
		
		// Step 2: esecuzione dell'Algoritmo
		for (int i=0; i < this.sort.length; i++) {
			int node = this.sort[i];
			int nodeDegree = this.degree[node];
						
			for (int neighbor: this.graph.get(node)) {
				int neighborDegree = this.degree[neighbor];
				int neighborPos = this.pos[neighbor];
				if (neighborDegree > nodeDegree) {
					
					int firstNodeInTheBucket = this.sort[this.bin[neighborDegree]];
					int firstNodeInTheBucketPos = this.pos[firstNodeInTheBucket];
					
					// Scambio in 'sort'
					int temp = this.sort[neighborPos];
					this.sort[neighborPos] = this.sort[firstNodeInTheBucketPos];
					this.sort[firstNodeInTheBucketPos] = temp;
					
					// Scambio in 'pos'
					temp = this.pos[neighbor];
					this.pos[neighbor] = this.pos[firstNodeInTheBucket];
					this.pos[firstNodeInTheBucket] = temp;
					
					// Aggiornamento di 'bin'
					this.bin[neighborDegree] = this.bin[neighborDegree] + 1;
					
					// Aggiornamento di 'degree'
					this.degree[neighbor] = neighborDegree - 1;
				}
			}
		}
		
		// Step 3: ritornare i risultati
		System.out.println("*** FINE DELLA RICERCA ***");
		
		Set<Integer> core = new HashSet<>(this.graph.keySet());
		int coreness = 0;
		while (core.size() > 0) {
			for (int node = 0; node < this.degree.length; node++) {
				if (this.degree[node] < coreness)
					core.remove(node);
			}
			System.out.println("Nodi che fanno parte del " + coreness + "-core: " + core);
			coreness++;
		}
		System.out.println("\n");
	}
	
	private void computeDegree() {

		for (int i=0; i < this.degree.length; i++) {
			Integer neighbors = this.graph.get(i).size();
			this.degree[i] = neighbors;
		}
	}
	
	private void buildBin() {
		int maxDegree = Integer.MIN_VALUE;
		
		for (int i=0; i < this.degree.length; i++) {
			if (this.degree[i] > maxDegree)
				maxDegree = this.degree[i];
		}
		
		this.bin = new Integer[maxDegree+1];
		
		for (int i=0; i < this.bin.length; i++) {
			int numNodes = 0;
			for (int j=0; j < this.degree.length; j++) {
				if (this.degree[j] == i)
					numNodes++;
			}
			this.bin[i] = numNodes;
		}
		
		int start = 0;
		int num;
		for (int d=0; d <= maxDegree; d++) {
			num = this.bin[d];
			this.bin[d] = start;
			start = start + num;
		}
	}
	
	private void buildSortAndPos() {
		for (int i=0; i < this.degree.length; i++) {
			int degree = this.degree[i];
			int position = this.bin[degree];
			
			this.sort[position] = i;
			this.pos[i] = position;
			
			this.bin[degree] = this.bin[degree] + 1;
		}
	}
	
	private void resetBin() {
		int maxDegree = Integer.MIN_VALUE;
		for (int i=0; i < this.degree.length; i++) {
			if (this.degree[i] > maxDegree)
				maxDegree = this.degree[i];
		}
		
		for (int d = maxDegree; d > 0; d--) {
			this.bin[d] = this.bin[d-1];
		}
		this.bin[0] = 0;
	}
}