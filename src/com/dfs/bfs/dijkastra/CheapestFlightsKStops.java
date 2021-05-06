package com.dfs.bfs.dijkastra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 */
class Pair {
    int city, cost;

    Pair(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}

class City {
    int city, distFromSrc, costFromSrc;

    City(int city, int distFromSrc, int cost) {
        this.city = city;
        this.distFromSrc = distFromSrc;
        this.costFromSrc = cost;
    }
}
public class CheapestFlightsKStops {

    public static void main(String[] args) {
        CheapestFlightsKStops c = new CheapestFlightsKStops();
        /**
         * Algorithm:
         * Initially push the src into the heap
         * for every step:
         *
         * check if the current top element in heap is dst. If so return its costFromSrc;
         * Push every adjacent edge into the heap if the distance is less than k;
         * If it is larger than k, no more neighbors get pushed into the heap;
         * If until the end, we cannot find dst, return -1;
         */
        /*
        Input:
        n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
        src = 0, dst = 2, k = 1
         Output: 200
         0
    100 / \
       /   \ 500
      1-----2
       100
       0-->1-->2  = 200
         */
        int[][] flights ={
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;
       int res=  c.findCheapestPrice(n, flights, src, dst, k);
       System.out.println(res);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // DFS
        if(n <= 0 || flights == null || flights.length == 0 || K < 0)
            return -1;

        List<List<Pair>> graph = new ArrayList<>();
        this.buildGraph(graph, n, flights);

        Queue<City> pQueue = new PriorityQueue<>((City c1, City c2) -> c1.costFromSrc - c2.costFromSrc);
        pQueue.offer(new City(src, 0, 0));

        int totalCost = 0;

        while (!pQueue.isEmpty()) {
            City top = pQueue.poll();

            if (top.city == dst) {
                return top.costFromSrc;
            }

            if (top.distFromSrc > K) {
                continue;
            }

            List<Pair> neighbors = graph.get(top.city);
            for (Pair neighbor: neighbors) {
                pQueue.offer(new City(neighbor.city, top.distFromSrc + 1, top.costFromSrc + neighbor.cost));
            }
        }

        return -1;
    }

    private void buildGraph(List<List<Pair>> graph, int n, int[][] flights) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight: flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }

}
