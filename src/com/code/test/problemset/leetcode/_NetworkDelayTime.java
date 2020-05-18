package com.code.test.problemset.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Network Delay Time:
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 * <p>
 * Note:
 * <p>
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 * <p>
 * https://leetcode.com/problems/network-delay-time/
 */
public class _NetworkDelayTime {
    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));
    }

    static class Node implements Comparable {
        int id;
        Integer minDistance;
        List<int[]> adjacenciesList;

        public Node(int id, int minDistance, List<int[]> adjList) {
            this.id = id;
            this.minDistance = minDistance;
            this.adjacenciesList = adjList;
        }

        @Override
        public int compareTo(Object o) {
            return this.minDistance.compareTo(((Node) o).minDistance);
        }
    }

    static public int networkDelayTime(int[][] times, int N, int K) {
        List<Node> nodes = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            Node curr = new Node(i, -1, new ArrayList<>());
            nodes.add(curr);
        }

        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < 3; j++) {
                nodes.get(times[i][0]).adjacenciesList.add(new int[]{times[i][1], times[i][2]});
            }

        }

        Node source = nodes.get(K);

        source.minDistance = 0;
        PriorityQueue<Node> dijkstraVertexPrioQueue = new PriorityQueue<>();
        dijkstraVertexPrioQueue.add(source);

        while (!dijkstraVertexPrioQueue.isEmpty()) {
            Node current = dijkstraVertexPrioQueue.poll();

            // Visit each edge exiting u
            for (int[] targetEdge : current.adjacenciesList) {
                Node targetDijkstraVertex = nodes.get(targetEdge[0]);
                if (targetDijkstraVertex.minDistance == -1 ||
                        current.minDistance + targetEdge[1] < targetDijkstraVertex.minDistance) {
                    dijkstraVertexPrioQueue.remove(targetDijkstraVertex);// remove then add to update it priority queue index
                    targetDijkstraVertex.minDistance = current.minDistance + targetEdge[1];
                    dijkstraVertexPrioQueue.add(targetDijkstraVertex);
                }
            }
        }

        int max = 0;
        nodes.remove(0);
        for (Node n : nodes) {
            if (n.minDistance == -1)
                return -1;
            else
                max = Math.max(n.minDistance, max);
        }
        return max;
    }
}
