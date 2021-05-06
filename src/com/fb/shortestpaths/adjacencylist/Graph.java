package com.fb.shortestpaths.adjacencylist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author swamy on 3/13/21
 */
public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
