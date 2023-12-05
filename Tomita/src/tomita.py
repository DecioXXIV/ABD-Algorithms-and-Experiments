class Tomita:

    def __init__(self, graph):
        self.graph = graph.graph
        self.maximal_cliques = dict()
        self.counter = 0

        self.tomita(r = set(), p = set(self.graph.keys()), x = set())
        print("\n*** FINE DELLA RICERCA ***")
        print("Sono state trovate le seguenti Clique Massimali:")
        for key in self.maximal_cliques:
            print(self.maximal_cliques[key])

    def tomita(self, r, p, x):
        if len(p) == 0 and len(x) == 0:
            self.maximal_cliques[self.counter] = r
            self.counter += 1
            return
        
        map_candidate_neighbors = dict()
        for node in p.union(x):
            neighbors_in_p = len(self.graph[node].intersection(p))
            map_candidate_neighbors[node] = neighbors_in_p
        
        u = None
        max_value = -1
        for node in map_candidate_neighbors:
            if map_candidate_neighbors[node] > max_value:
                max_value = map_candidate_neighbors[node]
                u = node

        for node in list(p.difference(self.graph[u])):
            self.tomita(r.union({node}), p.intersection(self.graph[node]), x.intersection(self.graph[node]))
            p.remove(node)
            x.add(node)