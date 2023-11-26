import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<Integer, List<Integer>> graph;
	
	public Graph() {
		this.graph = new HashMap<>();
	}
	
	public void addEdge(Integer firstNode, Integer secondNode) {
		if (this.graph.get(firstNode) == null)
			this.graph.put(firstNode, new ArrayList<Integer>());
		if (this.graph.get(secondNode) == null)
			this.graph.put(secondNode, new ArrayList<Integer>());
		
		List<Integer> adiacencyFirstNode = this.graph.get(firstNode);
		adiacencyFirstNode.add(secondNode);
		this.graph.put(firstNode, adiacencyFirstNode);
		
		List<Integer> adiacencySecondNode = this.graph.get(secondNode);
		adiacencySecondNode.add(firstNode);
		this.graph.put(secondNode, adiacencySecondNode);
	}
	
	public Map<Integer, List<Integer>> getGraph() {
		return this.graph;
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