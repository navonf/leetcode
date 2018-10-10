import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

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

    // The DFS traversal should be:
    // 0, 1, 3, 2, 4, 5
    DFS4(nodes[0]);
    // The BFS traversal should be:
    // 0, 1, 4, 5, 3, 2
    // BFS2(nodes[0]);
  }

  // 10/8/18
  public static void DFS4(Node root) {
    // Compact lol
    if(root == null) return;
    root.visited = true;
    System.out.println("Node: "+ root.name);
    for(Node curr : root.children)
      if(!curr.visited) DFS4(curr);
  }

  // 10/8/18
  public static void BFS2(Node root) {
    // Queue data structure.
    ArrayDeque<Node> queue = new ArrayDeque<Node>();

    // Start off the queue, with the root node.
    queue.offer(root);
    root.visited = true;

    while(!queue.isEmpty()) {
      // Process node
      Node currNode = queue.poll();
      System.out.println("Node: "+currNode.name);

      for(Node child : currNode.children) {
        if(!child.visited) {
          queue.offer(child);
          child.visited = true;
        }
      }
    }

  }

  // 10/7/18
  public static void BFS(Node root) {
    // Iterave approach! It's usually iterative.
    // We use a Queue to enqueue all the children nodes.
    // This way, when we dequeue each, we do it in a
    // "breadth-first" fashion.. *ba-dum-tss* ... Sorry.
    ArrayDeque<Node> q = new ArrayDeque<Node>();

    // So this is an clear line, we visit the first node.
    root.visited = true;

    // Then utilize our queue, offering (add), it to the queue.
    q.offer(root);

    // So this while loop operates until the queue is empty.
    // (1) We unload the front of the queue on the first line
    // in the while loop (queue of 1 node). (2) Process it.
    // (3) Now, look at the child nodes of the current node,
    // and if they been visited, mark them and enqueue it up!
    while(!q.isEmpty()) {

      // (1) Remove the front of the queue.
      Node myCurrentNode = q.poll();

      // (2) Process it.
      System.out.println("Node " + myCurrentNode.name);

      // (3) Loop through the children.
      for(Node n : myCurrentNode.children) {
        // If it hasn't been visited?
        if(n.visited == false) {
          // Mark as true.
          n.visited = true;
          // Enqueue it up!
          q.offer(n);
        }
      }
    }
  }

  // 10/7/18
  public static void DFS3(Node root) {
    if(root == null) {
      return;
    }
    root.visited = true;
    System.out.println("Node: "+root.name);
    for(Node n : root.children) {
      if(!n.visited) {
        DFS3(n);
      }
    }
  }

  // 10/3/18
  public static void DFS2(Node root) {
    // So in a DFS, we go to the deepest part of
    // where each node points to, then recurse back.
    // Continuing, with it's other children.
    // Rinse, repeat.

    // We need our base case that we will recurse
    // back from when we're finished with 1 path.
    if(root == null) return;

    // We must mark this node as visited.
    // If we don't mark it, we will never remember
    // what nodes we've visited.
    root.visited = true;

    // Now, we can process the node if we want.
    // Let's just print it for now.
    System.out.println("Node: " + root.name);

    // Let's look at each of it's children.
    for(Node myCurrentNode: root.children) {
      // Recurse down the first one we see.
      // This is what will help us hit our base case.
      // We visit if the node hasn't been visited.
      if(myCurrentNode.visited == false) {
        DFS2(myCurrentNode);
      }
    }
  }

  // 10/2/18
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
