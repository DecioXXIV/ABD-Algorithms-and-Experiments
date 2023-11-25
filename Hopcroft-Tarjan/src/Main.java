
public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");

		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "J");
		graph.addEdge("B", "K");
		graph.addEdge("B", "N");

		graph.addEdge("C", "D");
		graph.addEdge("C", "E");
		graph.addEdge("C", "F");
		graph.addEdge("C", "G");

		graph.addEdge("E", "F");
		graph.addEdge("E", "G");
		graph.addEdge("E", "I");

		graph.addEdge("F", "G");
		graph.addEdge("F", "H");
		graph.addEdge("F", "I");

		graph.addEdge("J", "K");
		graph.addEdge("J", "L");
		graph.addEdge("J", "M");
		graph.addEdge("J", "N");

		graph.addEdge("K", "L");

		graph.addEdge("K", "M");

		System.out.println(graph.toString());
		
		HopcroftTarjan ht = new HopcroftTarjan(graph);
		ht.HTAlgorithm("A", null);
	}
}
