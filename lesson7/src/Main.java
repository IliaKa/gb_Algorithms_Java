public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 6);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(2, 9);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);

        System.out.println(bfs.hasPathTo(9));
        System.out.println(bfs.pathTo(9));
        System.out.println(bfs.distTo(9));
    }
}