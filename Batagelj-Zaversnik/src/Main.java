
public class Main {

	public static void main(String[] args) {
		
		/* First Graph */
		Graph graph1 = new Graph();
		
		graph1.addEdge(0, 1);
		graph1.addEdge(0, 2);

		graph1.addEdge(1, 2);
		graph1.addEdge(1, 3);
		graph1.addEdge(1, 9);
		graph1.addEdge(1, 10);
		graph1.addEdge(1, 13);

		graph1.addEdge(2, 3);
		graph1.addEdge(2, 4);
		graph1.addEdge(2, 5);
		graph1.addEdge(2, 6);

		graph1.addEdge(4, 5);
		graph1.addEdge(4, 6);
		graph1.addEdge(4, 8);

		graph1.addEdge(5, 6);
		graph1.addEdge(5, 7);
		graph1.addEdge(5, 8);

		graph1.addEdge(9, 10);
		graph1.addEdge(9, 11);
		graph1.addEdge(9, 12);
		graph1.addEdge(9, 13);

		graph1.addEdge(10, 11);
		graph1.addEdge(10, 12);
		
		System.out.println(graph1.toString());
		
		BatageljZaversnik bz = new BatageljZaversnik(graph1);
		bz.BZAlgorithm();
		
		/* Second Graph */
		
		Graph graph2 = new Graph();
		
		graph2.addEdge(0, 4);
		
		graph2.addEdge(1, 2);
		
		graph2.addEdge(2, 3);
		graph2.addEdge(2, 4);
		
		graph2.addEdge(4, 5);
		graph2.addEdge(4, 6);
		graph2.addEdge(4, 7);
		graph2.addEdge(4, 8);
		
		graph2.addEdge(5, 6);
		graph2.addEdge(5, 7);
		graph2.addEdge(5, 8);
		
		graph2.addEdge(6, 7);
		graph2.addEdge(6, 8);
		
		graph2.addEdge(7, 8);
		
		graph2.addEdge(8, 9);
		
		graph2.addEdge(9, 10);
		graph2.addEdge(9, 11);
		
		graph2.addEdge(10, 11);
		graph2.addEdge(10, 12);
		graph2.addEdge(10, 13);
		graph2.addEdge(10, 14);

		graph2.addEdge(11, 12);
		graph2.addEdge(11, 13);
		graph2.addEdge(11, 14);
		
		graph2.addEdge(12, 13);
		graph2.addEdge(12, 14);
		graph2.addEdge(12, 15);
		
		graph2.addEdge(13, 14);
		graph2.addEdge(13, 16);
		
		graph2.addEdge(15, 16);
		
		graph2.addEdge(16, 17);
		graph2.addEdge(16, 18);
		
		graph2.addEdge(17, 19);
		
		graph2.addEdge(18, 19);
		graph2.addEdge(18, 23);
		graph2.addEdge(18, 24);
		
		graph2.addEdge(19, 20);
		graph2.addEdge(19, 21);
		graph2.addEdge(19, 22);
		graph2.addEdge(19, 24);
		
		graph2.addEdge(22, 24);
		graph2.addEdge(22, 25);
		
		graph2.addEdge(23, 26);
		graph2.addEdge(23, 24);
		
		graph2.addEdge(24, 25);
		graph2.addEdge(24, 26);
		
		graph2.addEdge(25, 26);

		System.out.println(graph2.toString());
		
		bz = new BatageljZaversnik(graph2);
		bz.BZAlgorithm();
	}
}