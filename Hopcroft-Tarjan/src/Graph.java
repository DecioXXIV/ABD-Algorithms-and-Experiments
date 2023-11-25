import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<String, List<String>> graph;
	
	public Graph() {
		this.graph = new HashMap<>();
	}
	
	public void addEdge(String firstNode, String secondNode) {
		if (this.graph.get(firstNode) == null)
			this.graph.put(firstNode, new ArrayList<String>());
		if (this.graph.get(secondNode) == null)
			this.graph.put(secondNode, new ArrayList<String>());
		
		List<String> adiacencyFirstNode = this.graph.get(firstNode);
		adiacencyFirstNode.add(secondNode);
		this.graph.put(firstNode, adiacencyFirstNode);
		
		List<String> adiacencySecondNode = this.graph.get(secondNode);
		adiacencySecondNode.add(firstNode);
		this.graph.put(secondNode, adiacencySecondNode);
	}
	
	public Map<String, List<String>> getGraph() {
		return this.graph;
	}
	
	@Override
	public String toString() {
		System.out.println("GRAPH DESCRIPTION: ");
		String output = "";
		
		for (String key: this.graph.keySet())
			output += key + " -> " + this.graph.get(key) + "\n";
		
		return output;
	}
}