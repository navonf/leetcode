import java.util.ArrayList;
import java.util.Arrays;

class Graph {
  public static Node[] nodes;
  public static final int SIZE = 6;
  public static void main(String[] args) {
    // Graph of size 6.
    nodes = new Node[SIZE];

    // Build graph.
    nodes[0] = new Node("0");
    nodes[1] = new Node("1");
    nodes[2] = new Node("2");
    nodes[3] = new Node("3");
    nodes[4] = new Node("4");
    nodes[5] = new Node("5");

    // Node 0 points to 1, 4, 5.
    nodes[0].children.add(nodes[1]);
    nodes[0].children.add(nodes[4]);
    nodes[0].children.add(nodes[5]);

    // Node 1 points to 3, 4.
    nodes[1].children.add(nodes[3]);
    nodes[1].children.add(nodes[4]);

    // Node 2 points to 1.
    nodes[2].children.add(nodes[1]);

    // Node 3 points to 2, 4.
    nodes[3].children.add(nodes[2]);
    nodes[3].children.add(nodes[4]);

    DFS(nodes[0]);
  }

  public static void DFS(Node root) {
    // Check if the root is null
    if(root == null) return;

    root.visited = true;
    System.out.println(root.name);

    // for(Node n : root.children) {
    //   if(n != null) System.out.print(n.name  + " ");
    // }

    for(Node n : root.children) {
      if(n.visited == false) {
        DFS(n);
      }
    }
  }
}

class Node {
  public String name;
  public boolean visited;
  public ArrayList<Node> children;

  Node(String n) {
    this.name = n;
    this.visited = false;
    this.children = new ArrayList<Node>();
  }
}
