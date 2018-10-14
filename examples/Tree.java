// Tree implementations
class Tree {
  public static Node[] nodes;
  public static final int SIZE = 5;
  public static void main(String[] args) {
    nodes = new Node[SIZE];

    Node root = new Node(10);
    root.insert(7);
    root.insert(15);
    root.insert(3);
    root.insert(8);
    root.insert(9);
    root.insert(17);

    root.inorder();
    // System.out.println(isValid(root));
  }
}

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
