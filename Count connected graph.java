/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;
import java.lang.*;
import java.io.*;
class TestClass {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList();
    static boolean[] visited;
    static int connected_count = 0;
    public static void main(String args[] ) throws Exception {        
        //Scanner
        Scanner s = new Scanner(System.in);
		    int n = s.nextInt(); // number of vertex
        int m = s.nextInt(); // number of edges
    
        visited = new boolean[n+1];
        graph.add(new ArrayList());
        for(int k=1; k <= n; k++){
            // add empty list at each vertex
            graph.add(k, new ArrayList());
        }

        // iterate over edges and all edges
        for(int i=1; i <= m; i++){
            int a= s.nextInt();
            int b= s.nextInt();
            addEdge(a, b);
        }                 

        // dfs
        for(int j=1; j <=n; j++){
            if(!visited[j]){
               connected_count++;
               dfs(j); 
            }
        }
        System.out.println(connected_count);
    }

    private static void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void dfs(int i){
        visited[i] = true;
        for(int children: graph.get(i)){
            if(!visited[children]){
                dfs(children);
            }
        }
    }
}
