import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class HopcroftTarjan {
	
	private Map<String, List<String>> graph;
	private Map<String, Integer> number;
	private Map<String, Integer> lowest;
	private Map<String, Boolean> visited;
	private Map<String, Boolean> processed;
	private Stack<String> stack;
	private int id = 1;
	private List<List<String>> biconnectedComponents;
	private List<String> cutVertexes;
	
	public HopcroftTarjan(Graph graph) {
		this.graph = graph.getGraph();
		this.number = new HashMap<>();
		this.lowest = new HashMap<>();
		this.visited = new HashMap<>();
		this.processed = new HashMap<>();
		this.stack = new Stack<>();
		
		for (String node: this.graph.keySet()) {
			this.visited.put(node, false);
			this.processed.put(node, false);
		}
		
		this.biconnectedComponents = new ArrayList<>();
		this.cutVertexes = new ArrayList<>();
	}
	
	public void HTAlgorithm(String startingNode, String parentNode) {
		DFS(startingNode, parentNode);
		
		System.out.println("\n*** FINE DELLA RICERCA ***");
		System.out.println("Sono state trovate le seguenti componenti biconnesse:");
		for (List<String> component: biconnectedComponents)
			System.out.println(component);
		
		System.out.println("\nI seguenti Nodi sono 'Nodi di Taglio' per il Grafo di Input:");
		System.out.println(this.cutVertexes);
	}

	private void DFS(String node, String parent) {
		this.number.put(node, this.id);
		this.lowest.put(node, this.id);
		this.id++;
		
		this.visited.put(node, true);
		this.stack.push(node);
		
		for (String neighbor: this.graph.get(node)) {
			if (this.visited.get(neighbor) == false) { // Se il 'neighbor' non è stato già visitato, visitalo.
				DFS(neighbor, node);
				this.lowest.put(node, Math.min(this.lowest.get(node), this.lowest.get(neighbor)));
			}
			
			else {
				if (this.processed.get(neighbor) == false)
					this.lowest.put(node, Math.min(this.lowest.get(node), this.number.get(neighbor)));
			}
			
			/* Aggiornamento del 'lowest' per il Nodo corrente:
			 * 1) Dal Nodo corrente posso raggiungere tutti i Nodi 'neighbor' (banale...)
			 * 2) Se un Nodo 'neighbor' ha un Nodo 'lowest' più piccolo di me, allora quel Nodo sarà 'lowest' anche per me
			 */
		}
		
		System.out.println("Siamo in uscita dal Nodo '" + node + "', chiamato dal Nodo '" + parent + "'.");
		this.processed.put(node, true);
		
		if (this.lowest.get(node) == this.number.get(parent)) {
			List<String> component = new ArrayList<>();
			String n = this.stack.pop();
			while (n != node) {
				component.add(n);
				n = this.stack.pop();
			}
			component.add(n);
			component.add(parent);
			this.cutVertexes.add(parent);
			this.biconnectedComponents.add(component);
		}
	}
}