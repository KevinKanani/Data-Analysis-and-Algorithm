import java.util.Scanner;

public class FloydWarshall {

    final static int INF = 99999; 

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V];
        System.out.println("Enter the adjacency matrix (use 99999 to represent infinity): ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(graph, V);
        
        scanner.close();
    }
}
