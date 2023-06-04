package _03_Intro_to_Binary_Trees;

public class BinaryTreeDemo {

    /*
     * A Binary Tree is a data structure that makes use of nodes and references
     * like a LinkedList, but instead of the nodes pointing to a previous node
     * or next node in an unorderd list they each points to two child nodes that
     * are below them in the hierarchy.
     * 
     * Some important properties of BinaryTree are:
     * 
     * -The left node is always a smaller value than its parent and the right
     * node is always a larger value. This is a property you have seen in some
     * form already via Binary Search.
     * 
     * -Empty nodes are null references.
     * 
     * -The parent node at the very top of the tree is called the root.
     * 
     * 1. Read through the BinaryTree and Node classes.
     * 
     * 2. Create a BinaryTree of any type you like.
     * 
     * 3. Try using some BinaryTree methods to insert, search for, delete and
     * print elements.
     * 
     * 4. Save the root into a Node Object and use references to traverse
     * through the BinaryTree and perform an operation on every element(You may
     * choose to do this recursively or iteratively). Then print it out to see
     * if it worked.
     * 
     */

    public static void main(String[] args) {

    	BinaryTree<Integer> tree = new BinaryTree<Integer>();
    	Node<Integer> node = new Node<Integer>(null);
    	tree.insert(8);
    	tree.insert(10);
    	tree.insert(16);
    	tree.insert(90);
    	tree.insert(7);
    	tree.insert(5);
    	tree.insert(2);
    	tree.insert(1);
    	tree.insert(4);
    	tree.printVertical();
    	
    	Node<Integer> current = tree.getRoot();
    	System.out.println(tree.maxLevel(current));
    	Node<Integer> left = current.getLeft();
    	
    	
    	while(current != null) {
    		current.setLeft(left);
    	}
    	
    	
    	tree.search(7);
    	tree.recursiveSearch(current, 7);
    	tree.recursiveDelete(current, 5);
    	tree.printVertical();

    }

}
