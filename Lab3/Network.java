package Lab3;

import java.util.*;

public class Network {
    private static List<Node> nodes = new ArrayList<>();
    private static int numberOfNodes = 0;
    private static Map<Node, Integer> numberOfConnections = new HashMap<>();
    private int id;

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
        numberOfNodes++;
        id = numberOfNodes;
    }

    public static int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Lab3.Network{" +
                "nodes=" + nodes +
                '}';
    }

    public static Map<Node, Integer> getNumberOfConnections() {
        return numberOfConnections;
    }

    public static void Importance() {
        int nrConnections;
        for (Node i : nodes) {
            nrConnections = 0;
            if (i instanceof Person) {
                for (int x = 1; x <= Person.getIdMax()+Company.getIdMax(); x++) {
                    //System.out.println(i.getId());
                    if (Person.matrixRelationships[x][i.getId()] == 1) {
                        nrConnections++;
                    }
                    if (Person.matrixRelationships[i.getId()][x] == 1) {
                        nrConnections++;
                    }
                }
                numberOfConnections.put(i, nrConnections);
            }
            if (i instanceof Company) {
                for (int x = 0; x <= i.getId()+Person.getIdMax(); x++) {
                    if (Person.matrixRelationships[x][i.getId()+Person.getIdMax()] == 1) {
                        nrConnections++;
                    }
                }
                numberOfConnections.put(i, nrConnections);
            }

        }
    }
    public static List<Map.Entry<Node, Integer>> PrintWithImportance()
    {
        List<Map.Entry<Node, Integer>> sorted = new ArrayList<>(numberOfConnections.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return sorted;
    }

}
