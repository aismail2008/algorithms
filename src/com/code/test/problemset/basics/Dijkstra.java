package com.code.test.problemset.basics;

import com.code.test.problemset.basics.datastructure.DijkstraEdge;
import com.code.test.problemset.basics.datastructure.DijkstraVertex;

import java.util.*;

public class Dijkstra {

    /**
     * Assuming all vertices has minDistnace with infinity
     *
     * @param source
     */
    public static void computePaths(DijkstraVertex source) {
        source.minDistance = 0;
        PriorityQueue<DijkstraVertex> dijkstraVertexPrioQueue = new PriorityQueue<>();
        dijkstraVertexPrioQueue.add(source);

        while (!dijkstraVertexPrioQueue.isEmpty()) {
            DijkstraVertex current = dijkstraVertexPrioQueue.poll();

            // Visit each edge exiting u
            for (DijkstraEdge targetEdge : current.adjacenciesList) {
                DijkstraVertex targetDijkstraVertex = targetEdge.target;
                if (current.minDistance + targetEdge.weight < targetDijkstraVertex.minDistance) {
                    dijkstraVertexPrioQueue.remove(targetDijkstraVertex);// remove then add to update it priority queue index
					targetDijkstraVertex.minDistance = current.minDistance + targetEdge.weight;
					targetDijkstraVertex.previous = current;
                    dijkstraVertexPrioQueue.add(targetDijkstraVertex);
                }
            }
        }
    }

    /**
     * You call this after you make sure you have gone through {@link Dijkstra#computePaths(DijkstraVertex)} )
     *
     * @param target
     * @return
     */
    public static Stack<DijkstraVertex> getShortestPathTo(DijkstraVertex target) {
        Stack path = new Stack();
        for (DijkstraVertex dijkstraVertex = target; dijkstraVertex != null; dijkstraVertex = dijkstraVertex.previous) {
            path.add(dijkstraVertex);
        }
        return path;
    }
}