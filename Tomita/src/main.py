from graph import Graph
from tomita import Tomita

graph = Graph()

graph.add_edge(0, 4)
		
graph.add_edge(1, 2)
		
graph.add_edge(2, 3)
graph.add_edge(2, 4)
		
graph.add_edge(4, 5)
graph.add_edge(4, 6)
graph.add_edge(4, 7)
graph.add_edge(4, 8)
		
graph.add_edge(5, 6)
graph.add_edge(5, 7)
graph.add_edge(5, 8)
		
graph.add_edge(6, 7)
graph.add_edge(6, 8)
		
graph.add_edge(7, 8)
		
graph.add_edge(8, 9)
		
graph.add_edge(9, 10)
graph.add_edge(9, 11)
		
graph.add_edge(10, 11)
graph.add_edge(10, 12)
graph.add_edge(10, 13)
graph.add_edge(10, 14)

graph.add_edge(11, 12)
graph.add_edge(11, 13)
graph.add_edge(11, 14)
		
graph.add_edge(12, 13)
graph.add_edge(12, 14)
graph.add_edge(12, 15)
		
graph.add_edge(13, 14)
graph.add_edge(13, 16)
		
graph.add_edge(15, 16)
		
graph.add_edge(16, 17)
graph.add_edge(16, 18)
		
graph.add_edge(17, 19)
		
graph.add_edge(18, 19)
graph.add_edge(18, 23)
graph.add_edge(18, 24)
		
graph.add_edge(19, 20)
graph.add_edge(19, 21)
graph.add_edge(19, 22)
graph.add_edge(19, 24)
		
graph.add_edge(22, 24)
graph.add_edge(22, 25)
		
graph.add_edge(23, 26)
graph.add_edge(23, 24)
		
graph.add_edge(24, 25)
graph.add_edge(24, 26)
		
graph.add_edge(25, 26)

graph.print_desc()

bk = Tomita(graph)