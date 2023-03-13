package Lab3;

import java.util.*;

public class Network {
    private static List<Node> nodes = new ArrayList<>();
    private static int numberOfNodes = 0;
    private static Map<Node, Integer> numberOfConnections = new HashMap<>();
    private static List<List<Node>> relationships=new ArrayList<>();
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

    public static Map<Node, Integer> getNumberOfConnections() {
        return numberOfConnections;
    }

    public static void Importance() {
        int nrConnections;
        for (Node i : nodes) {
            nrConnections = 0;
            if (i instanceof Person) {
                for (int x = 1; x <= Person.getIdMax()+Company.getIdMax(); x++) {
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
    public static String GetRelationships()
    {
        String output = "";
        for(Node i: nodes)
        {
            if(i instanceof Person)
            {
                output=output.concat(i.getName()+":\n");
                 output= output.concat(((Person) i).getRelationships().toString()+ "\n");
            }
        }
       return output;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
