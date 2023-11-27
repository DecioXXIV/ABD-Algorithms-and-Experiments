from graph import Graph
from bron_kerbosch import BronKerbosch

graph = Graph()

graph.add_edge('A', 'B')
graph.add_edge('A', 'C')
graph.add_edge('A', 'D')
graph.add_edge('B', 'C')
graph.add_edge('B', 'D')
graph.add_edge('D', 'E')

graph.print_desc()

bk = BronKerbosch(graph)