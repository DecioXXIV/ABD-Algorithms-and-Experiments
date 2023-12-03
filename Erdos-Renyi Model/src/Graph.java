import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<Integer, List<Integer>> graph;
	
	public Graph(Integer numNodes, Float probability) {
		this.createGraphErdosRenyi(numNodes, probability);
		
		for (Integer node: this.graph.keySet()) {
			List<Integer> adiacency = this.graph.get(node);
			Collections.sort(adiacency);
			this.graph.put(node, adiacency);
		}
	}
	
	private void createGraphErdosRenyi(Integer numNodes, Float probability) {
		this.graph = new HashMap<>();
		
		for (int i = 0; i < numNodes; i++) {
			this.graph.put(i, new ArrayList<>());
		}
		
		for (Integer node: this.graph.keySet()) {
			for (Integer neighbor: this.graph.keySet()) {
				if (node != neighbor) {
					double random = Math.random();
					if (random < probability)
						this.addEdge(node, neighbor);
				}
			}
		}
	}
	
	private void addEdge(Integer firstNode, Integer secondNode) {
		List<Integer> adiacencyFirstNode = this.graph.get(firstNode);
		List<Integer> adiacencySecondNode = this.graph.get(secondNode);
		
		if (!adiacencyFirstNode.contains(secondNode) && !adiacencySecondNode.contains(firstNode)) {
			adiacencyFirstNode.add(secondNode);
			adiacencySecondNode.add(firstNode);
			
			this.graph.put(firstNode, adiacencyFirstNode);
			this.graph.put(secondNode, adiacencySecondNode);
		}
	}
	
	@Override
	public String toString() {
		System.out.println("GRAPH DESCRIPTION: ");
		String output = "";
		
		for (Integer key: this.graph.keySet())
			output += key + " -> " + this.graph.get(key) + "\n";
		
		return output;
	}
}