import java.util.Stack;
public class Tree {
    private Node root;

    public Tree () {
        root = null;
    }

    public Node find (int key) {Node current = root;
        while (current.id !=key) {
            if (key < current.id) {
                current = current.leftChild;
            } else {
                current = current.righChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert (int id, String data) {
        Node newNode = new Node();
        newNode.id=id;
        newNode.data=data;
        if (root == null) {
            root=newNode;
        } else {
            Node current= root; Node parent;
            while (true) {
                parent=current;
                if (id<current.id) {
                    current=current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode; return;
                    }
                } else {
                    current = current.righChild;
                    if (current==null) {
                        parent.righChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.id !=key) {
            parent = current;
            if (key < current.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.righChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.righChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.righChild = current.leftChild;
            }
        } else if (current.righChild == null) {
            if (current == root) {
                root = current.leftChild;

            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.righChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.righChild;
            } else if (isLeftChild) {
                parent.leftChild = current.righChild;
            } else {
                parent.righChild = current.righChild;
            }
        } else {
            Node successor = getSuccessor (current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            }
            successor.leftChild=current.leftChild;
        }
        return true;
    }

    private Node getSuccessor (Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.leftChild;
        while (current !=null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor !=delNode.righChild) {
            successorParent.leftChild = successor.righChild;
            successor.righChild = delNode.leftChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("Preorder traversal: ");
                preOrder (root);
                break;
            case 2:
                System.out.print("Inorder traversal: ");
                inOrder (root);
                break;
            case 3:
                System.out.print("Postorder traversal: ");
                postOrder (root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot !=null) {
            System.out.print(localRoot.id + "");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.righChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot !=null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.id + "");
            inOrder(localRoot.righChild);
        }
    }

    private void postOrder(Node localRoot) {
        postOrder(localRoot.leftChild);
        postOrder(localRoot.righChild);
        System.out.print(localRoot.id + "");
    }

    public void displayTree() {
        Stack globalStack = new Stack ();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false; System.out.println(
                "................................................................."
        );
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp !=null) {
                    System.out.print(temp.id);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.righChild);
                    if (temp.leftChild !=null || temp.righChild !=null ) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("__"); localStack.push(null); localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();

            nBlanks /=2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(
                ".................................................................");
    }
}

