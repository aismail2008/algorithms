package com.code.test.problemset.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex> {
	public final long id;
	public List<Edge> adjacenciesList;
	public double minDistance = Double.POSITIVE_INFINITY;

	public Vertex previous;

	public Vertex(long argName) {
		id = argName;
		adjacenciesList = new ArrayList<Edge>();
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}
}

class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}

public class Dijkstra {

	/**
	 * Assuming all vertices has minDistnace with infinity
	 * @param source
	 */
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacenciesList) {
				Vertex v = e.target;
				if (u.minDistance + e.weight < v.minDistance) {
					vertexQueue.remove(v);// remove then add to update it priority queue index
					v.minDistance = u.minDistance + e.weight;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);
		Collections.reverse(path);
		return path;
	}
}
// This code is contributed by Aakash Hasija
