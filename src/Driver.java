/**
 * Binary Search Tree
 * Driver class that tests all of the methods to BST
 * Author: William Writer
 * Collaborator(s):
 * Collaboration:
 * Date: 4/25/22
 * On My Honor, I confirm that I followed all collaboration policy guidelines, and that the work I am submitting is my own: WW
 **/
public class Driver {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println("Test size method: " + binarySearchTree.size()); //should return 0
        System.out.println("Test isEmpty method: " + binarySearchTree.isEmpty());//should return true
        System.out.println("Test get method: " + binarySearchTree.get("hi")); //should return null
        System.out.println("Test contains method: " + binarySearchTree.contains("neigh"));//should return false
        System.out.println("Testing put method"); //should add all 3 components
        binarySearchTree.put(1, "ISHHY");
        binarySearchTree.put(2, "Tandonnn");
        binarySearchTree.put(3, "Cutie");
        System.out.println("Test size method: " + binarySearchTree.size());//should return 3
        System.out.println("Test isEmpty method: " + binarySearchTree.isEmpty()); //should return false
        System.out.println("Test get method: " + binarySearchTree.get(1)); //should return Ishan
        System.out.println("Test get method: " + binarySearchTree.get(3)); //should return Cutie
        System.out.println("Test contains method: " + binarySearchTree.contains(2));//should return true
        System.out.println("Test min method: " + binarySearchTree.min()); //should return 1
        System.out.println("Test max method: " + binarySearchTree.max());//should return 3
    }
}
