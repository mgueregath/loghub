/*
 * StarterKit.
 */
package io.codeffeine.starterkit.usecase.sort.topological;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class TolopogicalSort {

    private TolopogicalSort() {
        // Prevent instantation
    }

    public static <T> List<T> sort(DirectedGraph<T> graph) {
        DirectedGraph<T> reversedGraph = reverseGraph(graph);

        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Set<T> expanded = new HashSet<>();

        for (T node : reversedGraph) {
            explore(node, reversedGraph, result, visited, expanded);
        }

        return result;
    }

    private static <T> void explore(T node, DirectedGraph<T> graph, List<T> result, Set<T> visited, Set<T> expanded) {
        if (visited.contains(node)) {
            if (expanded.contains(node)) {
                return;
            }
            throw new IllegalArgumentException("A cycle was detected within the Graph when exploring node " + node.toString());
        }

        visited.add(node);

        for (T predecessor : graph.edgesFrom(node)) {
            explore(predecessor, graph, result, visited, expanded);
        }

        result.add(node);
        expanded.add(node);
    }

    private static <T> DirectedGraph<T> reverseGraph(DirectedGraph<T> graph) {
        DirectedGraph<T> result = new DirectedGraph<>();

        for (T node : graph) {
            result.addNode(node);
        }

        for (T node : graph) {
            for (T endpoint : graph.edgesFrom(node)) {
                result.addEdge(endpoint, node);
            }
        }

        return result;
    }
}
