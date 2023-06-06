package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		Node<Zombie> first = new Node<Zombie>(dancer);
		Node<Zombie> current = congaLine.getHead();

		current.setPrev(first);
		first.setNext(current);
		first.setPrev(null);
		congaLine.setHead(first);
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		Node<Zombie> last = new Node<Zombie>(dancer);

		Node<Zombie> current = congaLine.getHead();
		Node<Zombie> next = current.getNext();

		while (current != null) {
			if (current.getNext() == null) {
				last.setPrev(current);
				last.setNext(null);
				current.setNext(last);
				break;
			}
			current = current.getNext();
			next = current.getNext();
		}
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		Node<Zombie> zoom = new Node<Zombie>(dancer);

		Node<Zombie> current = congaLine.getHead();
		Node<Zombie> next = current.getNext();
		int count = 0;
		while (current != null) {
			if (count == position) {
				if (next != null && current.getPrev() != null) {
					current.setNext(zoom);
					next.setPrev(zoom);
					zoom.setPrev(current);
					zoom.setNext(next);
					break;
				} else if (next == null) {
					caboose(dancer);
					break;
				} else if (current.getPrev() == null) {
					engine(dancer);
					break;
				}
			}
			current = current.getNext();
			next = current.getNext();
			count++;
		}
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();
		Node<Zombie> current = congaLine.getHead();
		Node<Zombie> next = current.getNext();

		while (current != null) {

			if (current.getValue().getZombieHatColor().equals(hatColor)) {
				System.out.println("removing :" + current.getValue());
				if (current.getPrev() != null && next != null) {
					current.getPrev().setNext(next);
					next.setPrev(current.getPrev());
					next = current;
				} else if (current.getPrev() == null) {
					if (next != null) {
						next.setPrev(null);
					}
					congaLine.setHead(next);
					next = current;

				} else if (next == null) {
					if (current.getPrev() != null) {
						current.getPrev().setNext(null);
					}
					congaLine.setTail(current.getPrev());

				}
			}
			current = current.getNext();
				if(current != null) {
			next = current.getNext();
				}

		}

	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();
		Node<Zombie> current = congaLine.getHead();
		Node<Zombie> next = current.getNext();

		while (current != null) {
			if (current.getValue().getZombieHatColor().equals(hatColor)) {
				if (current.getPrev() != null && next != null) {
					current.getPrev().setNext(next);
					next.setPrev(current.getPrev());
					break;
				} else if (current.getPrev() == null && next != null) { // removing the first one
					next.setPrev(null);
					congaLine.setHead(next);
					break;
				} else if (current.getPrev() != null && next == null) { // removing the last one
					current.setNext(null);
					congaLine.setTail(current);
					break;
				}
			}
			current = current.getNext();
			next = current.getNext();

		}

	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();

		Zombie start = new Zombie(hatColor);
		Zombie end = new Zombie(hatColor);
		Node<Zombie> middle = new Node<Zombie>(new Zombie(hatColor));

		engine(start);
		caboose(end);

		Node<Zombie> current = congaLine.getHead();
		Node<Zombie> next = current.getNext();
		int mid = (congaLine.size() - 1) / 2;
		int count = 0;

		while (current != null) {
			if (count == mid) {
				current.setNext(middle);
				middle.setPrev(current);
				next.setPrev(middle);
				middle.setNext(next);
				break;
			}
			current = current.getNext();
			next = current.getNext();
			count++;
		}

	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {

		Node<Zombie> red = new Node<Zombie>(new Zombie(ZombieHatColor.R));
		Node<Zombie> orange = new Node<Zombie>(new Zombie(ZombieHatColor.O));
		Node<Zombie> yellow = new Node<Zombie>(new Zombie(ZombieHatColor.Y));
		Node<Zombie> green = new Node<Zombie>(new Zombie(ZombieHatColor.G));
		Node<Zombie> blue = new Node<Zombie>(new Zombie(ZombieHatColor.B));
		Node<Zombie> indigo = new Node<Zombie>(new Zombie(ZombieHatColor.I));
		Node<Zombie> violet = new Node<Zombie>(new Zombie(ZombieHatColor.V));

		Zombie redd = new Zombie(ZombieHatColor.R);
		Zombie orangee = new Zombie(ZombieHatColor.O);
		Zombie yelloww = new Zombie(ZombieHatColor.Y);
		Zombie greenn = new Zombie(ZombieHatColor.G);
		Zombie bluee = new Zombie(ZombieHatColor.B);
		Zombie indigoo = new Zombie(ZombieHatColor.I);
		Zombie violett = new Zombie(ZombieHatColor.V);

		Node<Zombie> zoomer = new Node<Zombie>(dancer);
		Node<Zombie> head = congaLine.getHead();

		if (head == null) { // if this is the first round
			congaLine.setHead(zoomer);

			zoomer.setNext(red);
			red.setPrev(zoomer);
			red.setNext(orange);
			orange.setPrev(red);
			orange.setNext(yellow);
			yellow.setPrev(orange);
			yellow.setNext(green);
			green.setPrev(yellow);
			green.setNext(blue);
			blue.setPrev(green);
			blue.setNext(indigo);
			indigo.setPrev(blue);
			indigo.setNext(violet);
			violet.setNext(null);
		} else {
			engine(dancer);

			caboose(redd);
			caboose(orangee);
			caboose(yelloww);
			caboose(greenn);
			caboose(bluee);
			caboose(indigoo);
			caboose(violett);

		}

	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}

}
