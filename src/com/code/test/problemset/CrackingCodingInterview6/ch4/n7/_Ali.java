package com.code.test.problemset.CrackingCodingInterview6.ch4.n7;

import java.util.*;
import java.util.stream.Collectors;

public class _Ali {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        List<String> paths = findPaths(dependencies);
        if(paths == null){
            System.out.println("Error");
        }else
            paths.stream().forEach(System.out::println);
    }

    static class Project {
        String name;
        List<Project> children;
//        List<String> path;

        public Project(String name) {
            this.name = name;
            children = new ArrayList<>();
//            path = new ArrayList<>();
        }

        @Override
        public boolean equals(Object obj) {
            return name.equals(((Project) obj).name);
        }
    }

    private static List<String> findPaths(String[][] dependencies) {
        Map<String, Project> graph = new HashMap<>();
        Arrays.stream(dependencies).forEach(arr -> {
            if (!graph.containsKey(arr[0])) {
                graph.put(arr[0], new Project(arr[0]));
            }
            if (!graph.containsKey(arr[1])) {
                graph.put(arr[1], new Project(arr[1]));
            }
            graph.get(arr[1]).children.add(graph.get(arr[0]));
        });
        List<Project> list = graph.entrySet().stream().map(entry -> entry.getValue())
                .collect(Collectors.toList());
        list.sort(Comparator.comparingInt(o -> o.children.size()));

//        List<List<String>> paths = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        for (int i = 0; i< list.size(); i++) {
            Project pr = list.get(i);
            if (pr.children.size() != 0) {
                return null;
            } else {
//                pr.path.add(pr.name);
                //update remaing projs
                for (int j = i+1; j < list.size(); j++) {
                    Project dep = list.get(j);
                    if(dep.children.remove(pr)){
//                        dep.path.add(pr.name);
                    }
                }
            }

//            paths.add(pr.path);
            paths.add(pr.name);
        }
        return paths;
    }
}
