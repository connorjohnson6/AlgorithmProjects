package binarySearch;

public class binarySearch {

    class Node {
        int asciiValue;
        String phrase;

        Node leftChild;
        Node rightChild;

        Node(int key, String phrase) {
            this.asciiValue = key;
            this.phrase = phrase;
        }

        public String toString() {
            return phrase;
        }
    }

    public Node root;

    public void addNode(int asciiValue, String phrase) {
        Node newNode = new Node(asciiValue, phrase);

        if (root == null) {
            root = newNode;
            System.out.println("Root node: " + phrase );
            return;
        }

        String path = "R"; // Path to the new node, starting from the root node.
        Node focusNode = root;
        Node parent;

        while (true) {
            parent = focusNode;
            if (asciiValue < focusNode.asciiValue) { // less than is left side
                focusNode = focusNode.leftChild;
                if (focusNode == null) { // if left node has no children
                    parent.leftChild = newNode;
                    System.out.println(phrase + ": " + path + "L");
                    break;
                } else {
                    path += "L"; // Update the path to the new node.
                }
            } else { // greater than is right side
                focusNode = focusNode.rightChild;
                if (focusNode == null) { // if right node has no children
                    parent.rightChild = newNode;
                    System.out.println(phrase + ": " + path + "R");
                    break;
                } else {
                    path += "R"; // Update the path to the new node.
                }
            }
        }
    }

    public String findNode(int key) {
        int numComparisons = 0;
        Node focusNode = root;
        StringBuilder path = new StringBuilder();
        while (focusNode.asciiValue != key) { //loop to find desired node
            numComparisons++;
            if (key < focusNode.asciiValue) { //goes to the left of the tree
                path.append("L,"); 
                focusNode = focusNode.leftChild;
            } else {
                path.append("R,"); //goes to the right of the tree
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return "Not found";
            }
        }
        return " Number of comparisons: " + numComparisons + "  ";
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) { // make sure its not empty
            inOrderTraverseTree(focusNode.leftChild);
            System.out.print(focusNode+", ");
            inOrderTraverseTree(focusNode.rightChild);
        }
    }
}
