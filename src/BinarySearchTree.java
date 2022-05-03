/**
 * Binary Search Tree
 * code that allows the user to sort through a list with a fast speed of O(log(n))
 * Author: William Writer
 * Collaborator(s): trent and ishan
 * Collaboration: worked together through more complicated recursive methods
 * Date: 4/25/22
 * On My Honor, I confirm that I followed all collaboration policy guidelines, and that the work I am submitting is my own: WW
 **/
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {}

    public int size() {
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if(x == null){ // if node x is equal to null, run
            return 0;
        }else{
            //get the size of the current node and adds the nodes that are both right and left to it
            return x.getSize() + size(x.getLeft()) + size(x.getRight());
        }
    }

    public boolean isEmpty() { //seees if the node is empty
        return this.size() == 0;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        //if n is null, run
        if(n == null){
            n = new Node(key, val, 1); // creates a new node at point
        }
        //create int to compare
        int compare = key.compareTo(n.getKey());
        //if value is greater than zero, run
        if(compare > 0){
            n.setRight(put(n.getRight(), key, val));  //keep moving right until correct location
            //if value is less than zero, run
        }else if(compare < 0){
            n.setLeft(put(n.getLeft(), key, val));//keep moving it left until it is in the correct location
        }
        //return altered node
        return n;
    }

    //recursive get wrapper
    public Value get(Key key) {

        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) { //GSAAHSFNTWEADGZ
        // if n is null, run
        if(n == null){
            return null;
        }
        //int for node rotation
        int sizeOfTree = this.size();
        int count = 0;
        int check = key.compareTo(n.getKey());

        //if the amount of times looped is greater than the number of nodes, no key
        if(count == sizeOfTree){
            return null;
        } else if(check > 0){
            count ++;
            return get(n.getRight(), key);
        }else if(check < 0){
            count++;
            return get(n.getLeft(), key);
        }else{
            return n.getValue();
        }
    }

    public boolean contains(Key key) {
        //check if the key is there
        boolean b = get(key) == null;
        return !b;
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null;
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) { //DFSFVSDFUSD
        //if the left of the node is null, this is the furthest left possible
        if(n.getLeft() == null){
            return n;
        }else{
            return min(n.getLeft());
        }
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) { //ADFNDSJfSDjk
        //if the left of the node is null, this is the furthest right possible
        if(n.getRight() == null){
            return n;
        }else{
            return max(n.getRight());
        }
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}
