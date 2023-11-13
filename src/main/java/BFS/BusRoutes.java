package BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {

    class RouteData {
        int stopNumber;
        int count;
        RouteData(int stopNumber, int count) {
            this.stopNumber = stopNumber;
            this.count = count;
        }
    }

    Map<Integer, Set<Integer>> getStopToBusMapping(int[][] routes) {
        Map<Integer, Set<Integer>> stopToBusMapping = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                Set<Integer> buses = stopToBusMapping.getOrDefault(routes[i][j], new HashSet<>());
                buses.add(i);
                stopToBusMapping.put(routes[i][j], buses);
            }
        }
        return stopToBusMapping;
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Set<Integer>> stopToBusMapping = getStopToBusMapping(routes);

        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStop = new HashSet<>();
        Queue<RouteData> queue = new LinkedList<>();
        traverseRoutesFromGivenStop(stopToBusMapping,
                routes,
                source,
                queue,
                visitedBuses,
                visitedStop,
                1);

        while(!queue.isEmpty()) {
            RouteData routeData = queue.poll();
            if (routeData.stopNumber == target) {
                return routeData.count;
            }
            traverseRoutesFromGivenStop(stopToBusMapping,
                    routes,
                    routeData.stopNumber,
                    queue,
                    visitedBuses,
                    visitedStop,
                    routeData.count + 1);

        }
        return -1;
    }

    void traverseRoutesFromGivenStop(Map<Integer, Set<Integer>> stopToBusMapping,
                                 int[][] routes,
                                 int source,
                                 Queue<RouteData> queue,
                                 Set<Integer> visitedBuses,
                                 Set<Integer> visitedStop,
                                 int count) {
        Set<Integer> buses = stopToBusMapping.get(source);
        for (Integer bus: buses) {
            if (visitedBuses.contains(bus)) {
                continue;
            }
            for (int i = 0; i < routes[bus].length; i++) {
                if (visitedStop.contains(routes[bus][i])) {
                    continue;
                }
                queue.add(new RouteData(routes[bus][i], count));
                visitedStop.add(routes[bus][i]);
            }
            visitedBuses.add(bus);
        }
    }
}


// No --> route 1 2 7
// Stop --> bus mapping

// start = 1
// target = 6
//     0 --> 1, 2, 7
//     1 --> 3, 6, 7

//     1 --> 0
//     2 --> 0
//     7 --> 0, 1
//     3 --> 1
//     6 --> 1


//     1
//     1, 2, 7
}
