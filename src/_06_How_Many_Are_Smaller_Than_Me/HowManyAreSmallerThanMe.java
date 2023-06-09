package _06_How_Many_Are_Smaller_Than_Me;

import java.util.Scanner;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

	/*
	 * Given an AVLTree filled with the random numbers from 1 to 20, and a single
	 * number within the AVL Tree, figure out how many numbers in the AVLTree are
	 * smaller than the provided number and return the result.
	 * 
	 * You may want to create a helper method to search through the AVLTree and
	 * count iteratively or recursively.
	 */

	public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {

		AVLNode<Integer> current = avlTree.getRoot();
	
		int count = loop(current, me);

		return count;

	}

	public static int loop(AVLNode<Integer> current, int me) {
		int count = 0;
		if (current == null) {
			return 0 ;
		}
		if(current.getValue() < me) {
			System.out.println(current.getValue() + " is less than " + me);
			count++;
		}

		count+= loop(current.getRight(), me);
		count += loop(current.getLeft(), me);
		return count;
	}
	public static void looping(AVLNode<Integer> current, int me) {
		if (current == null) {
			return;
		}

		loop(current.getRight(), me);
		loop(current.getLeft(), me);
	}
}
