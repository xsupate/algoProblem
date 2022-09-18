package spatel.algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindPathExistInGraph {
    public static void main(String[] args) {
    	int vertices = 5;
		int[][] edegs = {{0,1},{0,2},{3,5},{5,4},{4,3}};
		int source = 0;
		int destination = 4;
		
		FindPathExistInGraph graph = new FindPathExistInGraph();
		System.out.println("Is patrh exist : " + graph.validPath(vertices, edegs, source, destination));
	}
	
	public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int[] temp = edges[i];
            if(map.get(temp[0]) == null){
                map.put(temp[0], new HashSet<Integer>());
            }
            map.get(temp[0]).add(temp[1]);
            
            if(map.get(temp[1]) == null){
                map.put(temp[1], new HashSet<Integer>());
            }
            map.get(temp[1]).add(temp[0]);
        }
        
        boolean visited[] = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            int temp = queue.peek();
            queue.remove(temp);
            if(map.get(temp) != null){
                for(int node : map.get(temp)){
                if(visited[node] == false){
                    visited[node] = true;
                    queue.add(node);
                }
               }
            }
        }
        
        return visited[destination];
    }
}
