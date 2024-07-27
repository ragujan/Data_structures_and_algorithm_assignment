package com.rag_dsa.final_assignment.dijkstras;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindShortestPath<T> {
    private Map<T, List<AdjacencyVertexAndWeight<T>>> map = new HashMap<>();

    public void addVertex(T s) {
        map.put(s, new LinkedList<AdjacencyVertexAndWeight<T>>());
    }

    // assumption the graph is uni directional
    public void addEdge(T source, T destination, Integer weight) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(new AdjacencyVertexAndWeight<T>(destination, weight));
        map.get(destination).add(new AdjacencyVertexAndWeight<T>(source, weight));
    }

    public int getVertexCount() {
        return map.entrySet().size();
    }
    // shortest path tree set
    public Set<T> initializeShortestPaths() {
        Set<T> sptSet = new LinkedHashSet<>();
        for (Map.Entry<T, List<AdjacencyVertexAndWeight<T>>> entry : map.entrySet()) {
            sptSet.add(entry.getKey());
        }
        return sptSet;
    }

    // map that contains shortest path distances for each vertex
    public Map<T, Integer> initializeShortestDistances(T source) {
        Map<T, Integer> distanceMap = new HashMap<>();
        // Each distance pair gets an infinite length beside the first and self vertex
        for (Map.Entry<T, List<AdjacencyVertexAndWeight<T>>> entry : map.entrySet()) {
            distanceMap.put(entry.getKey(), Integer.MAX_VALUE);
        }
        // the self vertex weight is always 0
        distanceMap.put(source, 0);
        return distanceMap;
    }

    private T minDistance(Set<T> shortestPaths, Map<T, Integer> vertextDistanceMap) {
        int min = Integer.MAX_VALUE;
        T min_index = null;

        //
        for (Map.Entry<T, Integer> vertexWithDistance : vertextDistanceMap.entrySet()) {
            if (!shortestPaths.contains(vertexWithDistance.getKey()) && vertexWithDistance.getValue() < min) {
                min = vertexWithDistance.getValue();
                min_index = vertexWithDistance.getKey();
            }
        }
        
        return min_index;

    }

    public int getWeightOfEdge(T source, T destination) {
        List<AdjacencyVertexAndWeight<T>> vertices = map.get(source);
        int weight = 0;

        for (AdjacencyVertexAndWeight<T> vertexAndWeight : vertices) {
            if (vertexAndWeight.vertex().equals(destination)) {
                weight = vertexAndWeight.weight();
                break;
            }
        }
        return weight;

    }

    public boolean hasVertex(T s) {
        if (map.containsKey(s)) {
            return true;
        } else {
            return false;
        }
    }

    public Set<T> getAdjacencyVertices(T source) {
        Set<T> set = new HashSet<>();

        if (map.containsKey(source)) {
            List<AdjacencyVertexAndWeight<T>> vertices = map.get(source);

            for (AdjacencyVertexAndWeight<T> adjacencyVertexAndWeight : vertices) {
                set.add(adjacencyVertexAndWeight.vertex());
            }

        }
        return set;
    }

    public Integer shortestLengthFromSourceToDestination(T source,T destination) {
        Map<T, Integer> shortestLengths = dijkstrasInAction(source);

        return shortestLengths.get(destination);
    }

    public Map<T, Integer> dijkstrasInAction(T source) {
        Set<T> visitedVertices = new LinkedHashSet<>();
        Map<T, Integer> shortestDistances = initializeShortestDistances(source);
        System.out.println("shortest paths are " + visitedVertices);
        System.out.println("shortest Distances map is " + shortestDistances);

        for (Map.Entry<T, Integer> entry : shortestDistances.entrySet()) {
            T u = minDistance(visitedVertices, shortestDistances);
            System.out.println("u is " + u);
            visitedVertices.add(u);

            Set<T> adjacencyVerticesOfU = getAdjacencyVertices(u);
            for (T t : adjacencyVerticesOfU) {
                if (!visitedVertices.contains(t)
                        && getWeightOfEdge(u, t) != 0
                        && shortestDistances.get(u) != Integer.MAX_VALUE
                        && shortestDistances.get(u) + getWeightOfEdge(u, t) < shortestDistances.get(t)) {
                    shortestDistances.put(t, shortestDistances.get(u) + getWeightOfEdge(u, t));
                }
            }

        }
        System.out.println("visited vertices of " + source + " are ");
        System.out.println(visitedVertices);
        System.out.println("shortest distances of " + source + " are");
        System.out.println(shortestDistances);
        return shortestDistances;

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T t : map.keySet()) {

            builder.append(t.toString() + ": ");
            for (AdjacencyVertexAndWeight<T> adjacencyVertexAndWeight : map.get(t)) {
                System.out.println("adjancey of " + t.toString() + " is " + adjacencyVertexAndWeight.vertex());
                builder.append(adjacencyVertexAndWeight.vertex().toString() + " ");
            }
            builder.append("\n");

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        FindShortestPath<String> g = new FindShortestPath<String>();
        g.addEdge("A", "B", 5);
        g.addEdge("A", "C", 2);
        g.addEdge("B", "D", 3);
        g.addEdge("C", "D", 1);
        g.addEdge("C", "E", 6);
        g.addEdge("D", "F", 2);
        g.addEdge("E", "F", 4);
        System.out.println(g.shortestLengthFromSourceToDestination("A", "F"));
    }

}
