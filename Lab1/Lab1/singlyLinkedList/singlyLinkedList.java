package singlyLinkedList;
public class singlyLinkedList {

    //Represent a node of the singly linked list // found via https://www.javatpoint.com/java-program-to-create-and-display-a-singly-linked-list     
    class Node{    
        char data;    
        Node next;    
            
        public Node(char data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
    //this is a test for the repo
    //Represent the head and tail of the singly linked list
    public Node head = null;    
    public Node tail = null;    
        
    //addNode() will add a new node to the list    
    public void addNode(char data) {    
        //Create a new node    
        Node newNode = new Node(data);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
    
    //code from geeksforgeeks.org https://www.geeksforgeeks.org/adding-an-element-to-the-front-of-linkedlist-in-java/ 
    public void addFront(char data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
    
        // If the list is empty, set head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // set the new node's next to the current head
            newNode.next = head;
            // Set the head to the new node
            head = newNode;
        }
    }

    public void addEnd(char data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
    
        // If the list is empty, set head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // set the current tail's next to the new node
            tail.next = newNode;
            // Set the tail to the new node
            tail = newNode;
        }
    }

    public void removeFront() {
        // If the list is empty, do nothing
        if (head == null) {
            return;
        }

        // set the head to the current head's next
        head = head.next;

        // If the head is null, set the tail to null as well
        if (head == null) {
            tail = null;
        }
    }

    public void removeEnd() {
        // If the list is empty, do nothing
        if (head == null) {
            return;
        }

        // If the list only contains one element, set the head and tail to null
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            //set the tail to the second to last node
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
    }
    


    //print() will print all the nodes present in the list    
    public void print() {    
        //Node current will point to head    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    } 

//start of the stack methods

    public void push(char data){
        // Create a new node with the given data
        Node newNode = new Node(data);
    
        // If the list is empty, set head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // set the new node's next to the current head
            newNode.next = head;
            // Set the head to the new node
            head = newNode;
        }
    }

    //was debuged by chatGPT
    public char pop() {
        // If the list is empty, do nothing
        if (head == null) {
            return 0;
        }

        // remove the current head
        char data = head.data;
        head = head.next;

        // If the head is null, set the tail to null as well
        if (head == null) {
            tail = null;
        }

        return data;
    }
    

    public void printStack() {
        //Node current will point to head    
        Node current = head;

        if (head == null) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Nodes of Stack singly linked list: ");

        while (current != null) {
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

//start of the queue methods

    public void enqueue(char data){
        // Create a new node with the given data
        Node newNode = new Node(data);
    
        // If the list is empty, set head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // set the current tail's next to the new node
            tail.next = newNode;
            // Set the tail to the new node
            tail = newNode;
        }
    }

    //was debuged by chatGPT
    public char dequeue() {
        // If the list is empty, do nothing
        if (head == null) {
            return 0;
        }

        // remove the current head
        char data = head.data;
        head = head.next;

        // If the head is null, set the tail to null as well
        if (head == null) {
            tail = null;
        }

        return data;
    }

    public void printQueue(){
        //Node current will point to head    
        Node current = head;    
            
        // If the current node is null, the list is empty
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of Queded singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }

    public int length(Node head){
        int count = 0;
        Node current = head;
        while(current != null){ //while current is not null count up and move to the next node
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }


} // end of SinglyLinkedList class