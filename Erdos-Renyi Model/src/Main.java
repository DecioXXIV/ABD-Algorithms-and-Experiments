
public class Main {

	public static void main(String[] args) {
		Integer numNodes = null;
		Float probability = null;
		
		for (int i=0; i < args.length; i++) {
			switch(args[i]) {
			case "-nodes":
				numNodes = Integer.parseInt(args[++i]);
				break;
			case "-prob":
				probability = Float.parseFloat(args[++i]);
				break;
			default:
				throw new IllegalArgumentException("Parametro Sconosciuto " + args[i]);
			}
		}
		
		Graph graph = new Graph(numNodes, probability);
		
		System.out.println(graph.toString());
	}
}