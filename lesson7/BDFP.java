package lesson7;

import java.util.LinkedList;

public class BDFP {
    private boolean[] markedD;
    private boolean[] markedB;
    private int[] edgeToD;
    private int[] edgeToB;
    private int source;

    public BDFP(Graph g, int source) {
        this.source = source;
        markedD = new boolean[g.getVertexCount()];
        markedB = new boolean[g.getVertexCount()];
        edgeToD = new int[g.getVertexCount()];
        edgeToB = new int[g.getVertexCount()];
        dfs(g, source);
        bfs(g, source);
    }

    private void dfs(Graph g, int v) {
        markedD[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!markedD[w]) {
                edgeToD[w] = v;
                dfs(g, w);
            }
        }
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        markedB[source] = true;
        while (!queue.isEmpty()){
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if(!markedB[w]){
                    markedB[w] = true;
                    edgeToB[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(char type, int w) {
        return type == 'D' ? markedD[w] : markedB[w];
    }

    public LinkedList<Integer> pathTo(char type, int w) {
        if (!hasPathTo('D', w) || !hasPathTo('B', w)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = w;
        while (vertex != source) {
            stack.push(vertex);
            if (type == 'D') vertex = edgeToD[vertex];
            if (type == 'B') vertex = edgeToB[vertex];
        }
        return stack;
    }

}
