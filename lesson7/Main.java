package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,6);
        graph.addEdge(4,7);
        graph.addEdge(6,5);
        graph.addEdge(6,9);
        graph.addEdge(7,9);
        graph.addEdge(9,8);

//        System.out.println(graph.getAdjList(9));
//
        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
        System.out.println(dfp.hasPathTo(9));
        System.out.println(dfp.pathTo(9));

        //вообще то. Вы всё сделали сами, еще на уроке.
        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(9));
        System.out.println(bfp.pathTo(9));

        System.out.println("===================================================================");

        BDFP bdfp = new BDFP(graph , 0);

        System.out.println(bdfp.hasPathTo('D', 9));
        System.out.println(bdfp.pathTo('D', 9));
        System.out.println(bdfp.hasPathTo('B', 9));
        System.out.println(bdfp.pathTo('B', 9));

    }
}
