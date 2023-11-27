class BronKerbosch:

    def __init__(self, graph):
        self.graph = graph.graph
        self.biconnected_components = dict()
        self.counter = 0

        self.bron_kerbosch(r = set(), p = set(self.graph.keys()), x = set())
        print("\n*** FINE DELLA RICERCA ***")
        print("Sono state trovate le seguenti Clique Massimali:")
        for key in self.biconnected_components:
            print(self.biconnected_components[key])

    def bron_kerbosch(self, r, p, x):
        if len(p) == 0 and len(x) == 0:
            self.biconnected_components[self.counter] = r
            self.counter += 1
        for node in list(p):
            self.bron_kerbosch(r.union({node}), p.intersection(self.graph[node]), x.intersection(self.graph[node]))
            p.remove(node)
            x.add(node)