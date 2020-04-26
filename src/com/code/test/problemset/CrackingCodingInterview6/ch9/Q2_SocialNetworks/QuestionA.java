package com.code.test.problemset.CrackingCodingInterview6.ch9.Q2_SocialNetworks;

import java.util.*;

public class QuestionA {
	public static LinkedList<Person> findPathBFS(HashMap<Integer, Person> people, int source, int destination) {
		Queue<PathNode> toVisit = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		toVisit.add(new PathNode(people.get(source), null));
		visited.add(source);
		while (!toVisit.isEmpty()) {
			PathNode node = toVisit.poll();
			Person person = node.getPerson();
			if (person.getID() == destination) {
				return node.collapse(false);
			}
			
			/* Search friends. */
			ArrayList<Integer> friends = person.getFriends();
			for (int friendId : friends) {
				if (!visited.contains(friendId)) {
					visited.add(friendId);
					Person friend = people.get(friendId);
					toVisit.add(new PathNode(friend, node));
				}
			}
		}
		return null;
	}

	public static LinkedList<Person> findPathBFSBi_ALI(HashMap<Integer, Person> people, int source, int destination) {
		Queue<PathNode> toVisitS = new LinkedList<>();
		HashSet<Integer> visitedS = new HashSet<>();
		toVisitS.add(new PathNode(people.get(source), null));
		visitedS.add(source);

		Queue<PathNode> toVisitD = new LinkedList<>();
		HashSet<Integer> visitedD = new HashSet<>();
		toVisitD.add(new PathNode(people.get(source), null));
		visitedD.add(destination);


		while (!toVisitS.isEmpty() && !toVisitD.isEmpty()) {
			PathNode nodeS = toVisitS.poll();

			if(visitedD.contains(nodeS)){

			}


			Person person = nodeS.getPerson();
			if (person.getID() == destination) {
				return nodeS.collapse(false);
			}

			/* Search friends. */
			ArrayList<Integer> friends = person.getFriends();
			for (int friendId : friends) {
				if (!visitedS.contains(friendId)) {
					visitedS.add(friendId);
					Person friend = people.get(friendId);
					toVisitS.add(new PathNode(friend, nodeS));
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		int nPeople = 11;
		HashMap<Integer, Person> people = new HashMap<Integer, Person>();
		for (int i = 0; i < nPeople; i++) {
			Person p = new Person(i);
			people.put(i, p);
		}
		
		int[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};
		
		for (int[] edge : edges) {
			Person source = people.get(edge[0]);
			source.addFriend(edge[1]);
			
			Person destination = people.get(edge[1]);
			destination.addFriend(edge[0]);
		}
		
		int i = 1;
		int j = 10;
		LinkedList<Person> path1 = findPathBFS(people, i, j);
		Tester.printPeople(path1);
	}

}
