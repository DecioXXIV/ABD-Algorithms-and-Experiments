
public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 10);
		graph.addEdge(2, 11);
		graph.addEdge(2, 14);

		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(3, 7);

		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(5, 9);

		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);

		graph.addEdge(10, 11);
		graph.addEdge(10, 12);
		graph.addEdge(10, 13);
		graph.addEdge(10, 14);

		graph.addEdge(11, 12);

		graph.addEdge(11, 13);

		System.out.println(graph.toString());
		
		BatageljZaversnik bz = new BatageljZaversnik(graph);
		bz.BTAlgorithm();	//TODO
	}
}