class Graph:

    def __init__(self):
        self.graph = dict()

    def add_edge(self, first_node, second_node):
        if (first_node not in self.graph):
            self.graph[first_node] = set()
        if (second_node not in self.graph):
            self.graph[second_node] = set()
        
        adiacency_first_node = self.graph[first_node]
        adiacency_first_node.add(second_node)
        self.graph[first_node] = adiacency_first_node

        adiacency_second_node = self.graph[second_node]
        adiacency_second_node.add(first_node)
        self.graph[second_node] = adiacency_second_node
    
    def print_desc(self):
        print("GRAPH DESCRIPTION:")
        for node in self.graph:
            print(str(node) + " -> " + str(self.graph[node]))