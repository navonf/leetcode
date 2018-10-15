// Tree implementations
import java.util.ArrayDeque;
import java.util.ArrayList;
class Tree {
  public static void main(String[] args) {

    Node root = new Node(5);
    root.insert(3);
    root.insert(9);
    root.insert(1);
    root.insert(4);
    root.insert(10);

    // root.inorder();
    // System.out.println(root.contains(1513475));
    ArrayList<ArrayList<Node>> answer = levelOrder(root);
    for(ArrayList<Node> a : answer) {
      System.out.print("[");
      for(Node n : a) {
        System.out.print(n.data +", ");
      }
      System.out.print("], ");
    }
    System.out.println();
  }

  public static ArrayList<ArrayList<Node>> levelOrder(Node root) {
    ArrayDeque<Node> queue = new ArrayDeque<Node>();
    ArrayList<ArrayList<Node>> bigList = new ArrayList<ArrayList<Node>>();

    // offer the first root in queue to start BFS.
    queue.offer(root);

    // We will offer into the queue each child of the current
    // nodes in the queue. always adding more children, if they
    // exist. This will in time end our level travelsal.
    while(!queue.isEmpty()) {
      // System.out.println("Start loop:");
      ArrayList<Node> smallList = new ArrayList<Node>();

      // Add everything on the level.
      // Emptying the queue.
      // System.out.println("Queue: Size:  " + queue.size());
      while(!queue.isEmpty()) {
        Node remove = queue.poll();

        smallList.add(remove);
        // System.out.println("out the q: " + remove.data);
      }

      // Add children to queue, if they exist.
      for(Node n: smallList) {
        // System.out.println("current node:"+ n.data);
        if(n.left != null) {
          // System.out.println("Left:" + n.left.data);
          queue.offer(n.left);
        }

        if(n.right != null) {
          // System.out.println("Right:" + n.right.data);
          queue.offer(n.right);
        }
      }
      // System.out.println();
      bigList.add(smallList);
    }

    return bigList;
  }

}

// BST
class Node {
  public Node left, right;
  public int data;

  Node(int d) {
    this.data = d;
    this.left = null;
    this.right = null;
  }

  public void insert(int value) {
    // if the value passed in is less than or equal
    // to the data, insert on the left.
    if(value <= data) {
      if(left == null) {
        left = new Node(value);
      }
      else {
        left.insert(value);
      }
    }
    // if the value passed in is greater than
    // the data, insert on the right.
    else {
      if(right == null) {
        right = new Node(value);
      }
      else {
        right.insert(value);
      }
    }
  }

  public boolean contains(int value) {
    if(value == data) return true;
    else if(value < data) {
      if(left == null) {
        return false;
      }
      else {
        return left.contains(value);
      }
    }
    else {
      if(right == null) {
        return false;
      }
      else {
        return right.contains(value);
      }
    }
  }

  public void inorder() {
    if(left != null) {
      left.inorder();
    }

    System.out.println(data);

    if(right != null) {
      right.inorder();
    }
  }

  public void preorder() {
    System.out.println(data);

    if(left != null) {
      left.preorder();
    }

    if(right != null) {
      right.preorder();
    }
  }

  public void postorder() {
    if(left != null) {
      left.postorder();
    }

    if(right != null) {
      right.postorder();
    }

    System.out.println(data);
  }
}

// 10/14/18
// class Node2 {
//   public int data;
//   public Node2 left, right;
//
//   Node2(int d) {
//     this.data = d;
//     this.left = this.right = null;
//   }
//
//   public void insert(int val) {
//     // So in an insert, it lends naturally to recursion.
//     // We will check the left and right references of
//     // the current node, then make a decision to insert.
//     // Insert is O(logn).
//
//     // The value inserted is LESS than the data.
//     // This means we will handle the left reference.
//     if(val <= data) {
//       // This means we've gotten to where we need to insert.
//       if(left == null) {
//         left = new Node2(val);
//       }
//       // This means we have not, so send the value to the
//       // current left to tell me where the correct spot is.
//       else {
//         left.insert(val);
//       }
//     }
//     // The value inserted is MORE than the data.
//     else {
//       // Everything works very similar to the left references.
//       if(right == null) {
//         right = new Node2(val);
//       }
//       else {
//         right.insert(val);
//       }
//     }
//   }
//
//   public boolean contains(int val) {
//     // In contains we are returning if the value exists
//     // in the tree. This operation is O(logn) because tree.
//
//     // We are at the node with the value, we fount it.
//     if(data == val) {
//       return true;
//     }
//     // Cases are similar to insert, almost.
//     else if(val < data) {
//       if(left != null) {
//         // send it to the left reference.
//         return left.contains(val);
//       }
//       else {
//         // we did not find it, since the val we are looking
//         // for is less than the data.
//         return false;
//       }
//     }
//     else {
//       // Similarly.
//       if(right != null) {
//         return right.contains(val);
//       }
//       else {
//         return false;
//       }
//     }
//   }
//
//   public void inorder() {
//     if(left != null) {
//       left.inorder();
//     }
//
//     System.out.println(data);
//
//     if(right != null) {
//       right.inorder();
//     }
//   }
// }

// 10/13/18
// class Node {
//   public int data;
//   public Node left, right;
//
//   Node(int d) {
//     this.data = d;
//   }
//
//   public static void insert(int value) {
//     if(value <= data) {
//       if(left == null) {
//         left = new Node(value);
//       }
//       else {
//         left.insert(value);
//       }
//     }
//     else {
//       if(right == null) {
//         right = new Node(value);
//       }
//       else {
//         right.insert(value);
//       }
//     }
//   }
//
//   public static boolean contains(int value) {
//     if(data == value) return true;
//     else if(data < value) {
//       if(left == null) {
//         return false;
//       }
//       else {
//         return left.contains(value);
//       }
//     }
//     else {
//       if(right == null) {
//         return false;
//       }
//       else {
//         return right.contains(value);
//       }
//     }
//    }
//
//    public static void inorder() {
//      if(left != null) {
//        left.inorder();
//      }
//
//      System.out.println(data);
//
//      if(right != null) {
//        right.inorder();
//      }
//    }
// }
