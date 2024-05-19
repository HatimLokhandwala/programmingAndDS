package interviews;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import javafx.util.Pair;
/*
You and your friends are driving to a Campground to go camping. Only 2 of you have cars, so you will be carpooling.

Routes to the campground are linear, so each location will only lead to 1 location and there will be no loops or detours. Both cars will leave from their starting locations at the same time. The first car to pass someone's location will pick them up. If both cars arrive at the same time, the person can go in either car.

Roads are provided as a directed list of connected locations with the duration (in minutes) it takes to drive between the locations.
[Origin, Destination, Duration it takes to drive]

Given a list of roads, a list of starting locations and a list of people/where they live, return a collection of who will be in each car upon arrival to the Campground.
------------------------------------------------------
Bridgewater--(30)-->Caledonia--(15)-->New Grafton--(5)-->Campground
                                       ^
Liverpool---(10)---Milton-----(30)-----^

roads1 = [
    ["Bridgewater", "Caledonia", "30"], <= The road from Bridgewater to Caledonia takes 30 minutes to drive.
    ["Caledonia", "New Grafton", "15"],
    ["New Grafton", "Campground", "5"],
    ["Liverpool", "Milton", "10"],
    ["Milton", "New Grafton", "30"]
]
starts1 = ["Bridgewater", "Liverpool"]
people1 = [
    ["Jessie", "Bridgewater"], ["Travis", "Caledonia"],
    ["Jeremy", "New Grafton"], ["Katie", "Liverpool"]
]

Car1 path: (from Bridgewater): [Bridgewater(0, Jessie)->Caledonia(30, Travis)->New Grafton(45)->Campground(50)]
Car2 path: (from Liverpool): [Liverpool(0, Katie)->Milton(10)->New Grafton(40, Jeremy)->Campground(45)]

Output (In any order/format):
    [Jessie, Travis], [Katie, Jeremy]
--------------------------------------
Riverport->Chester->Campground
             ^
Halifax------^

roads2 = [["Riverport", "Chester", "40"], ["Chester", "Campground", "60"], ["Halifax", "Chester", "40"]]
starts2 = ["Riverport", "Halifax"]
people2 = [["Colin", "Riverport"], ["Sam", "Chester"], ["Alyssa", "Halifax"]]

Output (In any order/format):
    [Colin, Sam], [Alyssa] OR [Colin], [Alyssa, Sam]
----------------------------------------
Riverport->Bridgewater->Liverpool->Campground

roads3 = [["Riverport", "Bridgewater", "1"], ["Bridgewater", "Liverpool", "1"], ["Liverpool", "Campground", "1"]]
starts3_1 = ["Riverport", "Bridgewater"]
starts3_2 = ["Bridgewater", "Riverport"]
starts3_3 = ["Riverport", "Liverpool"]
people3 = [["Colin", "Riverport"], ["Jessie", "Bridgewater"], ["Sam", "Liverpool"]]

Output (starts3_1/starts3_2):  [Colin], [Jessie, Sam] - (Cars can be in any order)
Output (starts3_3): [Jessie, Colin], [Sam]
----------------------------------------
All Test Cases: (Cars can be in either order)
carpool(roads1, starts1, people1) => [Jessie, Travis], [Katie, Jeremy]
carpool(roads2, starts2, people2) => [Colin, Sam], [Alyssa] OR [Colin], [Alyssa, Sam]
carpool(roads3, starts3_1, people3) => [Colin], [Jessie, Sam]
carpool(roads3, starts3_2, people3) => [Jessie, Sam], [Colin]
carpool(roads3, starts3_3, people3) => [Jessie, Colin], [Sam]
----------------------------------------
Complexity Variable:
n = number of roads
*/
public class carTraverse {
    static int getReducedTime(String[][] products, String[] toPurchase) {
        if (products == null || toPurchase == null) {
            return 0;
        }
        Map<String, String> productToDepartmentMap = buildMap(products);
        int normalTime = getTimePassingThroughList(productToDepartmentMap, toPurchase);
        int optimalTime = getOptimalTime(productToDepartmentMap, toPurchase);
        return normalTime - optimalTime;
    }

    static int getOptimalTime(Map<String, String> productToDepartmentMap, String[] toPurchase) {
        Set<String> departments = new HashSet<>();
        for (String product: toPurchase) {
            String department = productToDepartmentMap.get(product);
            departments.add(department);
        }
        return departments.size();
    }

    static int getTimePassingThroughList(Map<String, String> productToDepartmentMap, String[] toPurchase) {
        String department = productToDepartmentMap.get(toPurchase[0]);
        int count = 1;
        for (int i = 1; i < toPurchase.length; i++) {
            String currentDepartment = productToDepartmentMap.get(toPurchase[i]);
            if (!currentDepartment.equals(department)) {
                count++;
                department = currentDepartment;
            }
        }
        return count;
    }

    static Map<String, String> buildMap(String[][] products) {
        Map<String, String> productToDepartmentMap = new HashMap<>();
        Stream.of(products)
                .forEach(arr -> productToDepartmentMap.put(arr[0], arr[1]));
        return productToDepartmentMap;
    }

    public static void main(String[] argv) {
        String[][] roads1 = {
                {"Bridgewater", "Caledonia", "30"}, {"Caledonia", "New Grafton", "15"},
                {"New Grafton", "Campground", "5"}, {"Liverpool", "Milton", "10"},
                {"Milton", "New Grafton", "30"}
        };
        String[] starts1 = {"Bridgewater", "Liverpool"};
        String[][] people1 = {
                {"Jessie", "Bridgewater"}, {"Travis", "Caledonia"},
                {"Jeremy", "New Grafton"}, {"Katie", "Liverpool"}
        };

        String[][] roads2 = {{"Riverport", "Chester", "40"}, {"Chester", "Campground", "60"}, {"Halifax", "Chester", "40"}};
        String[] starts2 = {"Riverport", "Halifax"};
        String[][] people2 = {{"Colin", "Riverport"}, {"Sam", "Chester"}, {"Alyssa", "Halifax"}};

        String[][] roads3 = {{"Riverport", "Bridgewater", "1"}, {"Bridgewater", "Liverpool", "1"}, {"Liverpool", "Campground", "1"}};
        String[] starts3_1 = {"Riverport", "Bridgewater"};
        String[] starts3_2 = {"Bridgewater", "Riverport"};
        String[] starts3_3 = {"Riverport", "Liverpool"};
        String[][] people3 = {{"Colin", "Riverport"}, {"Jessie", "Bridgewater"}, {"Sam", "Liverpool"}};
    }
}
