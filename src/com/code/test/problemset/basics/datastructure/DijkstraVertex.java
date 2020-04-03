package com.code.test.problemset.basics.datastructure;

import java.util.ArrayList;
import java.util.List;

public class DijkstraVertex implements Comparable<DijkstraVertex> {
    public final long id;
    public List<DijkstraEdge> adjacenciesList;

    public double minDistance = Double.POSITIVE_INFINITY;
    public DijkstraVertex previous;

    public DijkstraVertex(long argName) {
        id = argName;
        adjacenciesList = new ArrayList<>();
    }

    public int compareTo(DijkstraVertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
