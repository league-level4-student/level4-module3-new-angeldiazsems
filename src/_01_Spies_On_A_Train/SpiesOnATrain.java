package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {

		HashMap<String, Integer> results = new HashMap<String, Integer>();
		// key is name, value is amount of times their behavior matches clues

		String pieFlavor = "";
		String phoneModel = "";
		String briefcaseColor = "";

		String currentPerson = "";
		String suspect = "";

		String spy = "";

		int number = 0;

		for (int i = 0; i < clues.length; i++) {
			String[] words = clues[i].split(" "); // every word is an index

			if (words[words.length - 1].equals("pie")) {
				pieFlavor = words[words.length - 2];
			} else if (words[words.length - 1].equals("phone")) {
				phoneModel = words[words.length - 2];
			} else { // briefcase
				briefcaseColor = words[words.length - 2];
			}
		}

		Node<TrainCar> current = train.getHead();
		while (current != null) {
			String evidence = current.getValue().questionPassenger();
			String[] spilt = evidence.split(" ");
			currentPerson = spilt[7];
			suspect = spilt[13];

			if (evidence.contains("pie") && evidence.contains(pieFlavor)) {
				results.put(suspect, number + 1);
			} else if (evidence.contains("phone") && evidence.contains(phoneModel)) {
				results.put(suspect, number + 1);
			} else if (evidence.contains("briefcase") && evidence.contains(briefcaseColor)) {
				results.put(suspect, number + 1);
			} else {
				current = current.getNext();
			}

		}

		for (String name : results.keySet()) {
			int num = results.get(name);
			if (num == 3) {
				spy = name;
			}
		}

		return ""+spy.trim();

	}

}
