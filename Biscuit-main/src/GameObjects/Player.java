package GameObjects;

import java.awt.Color;
import java.util.ArrayList;

import GameObjects.Troop.TroopType;
import UI.Map.Node;


public class Player {
	
	public String name;
	public Card[] cards;
	public ArrayList<Troop> availableTroops;
	public ArrayList<Node> countries;
	public Color color;
	
	public Player(String _name, Color _col) {
		name = _name;
		color = _col;
		countries = new ArrayList<Node>();
	}
	
	public Card[] availableCards() {
		return cards;
	}
	
	public Card drawCard() {
		// TODO: draws a random card from the deck
		return new Card("Hello World");
	}
	
	public void addTroops(int n) {
		for(int i = 0; i < n;i++) {
			availableTroops.add(new Troop(Troop.TroopType.Artillery));
		}
		
	}
	
	public void addCountry(Node n) {
		countries.add(n);
	}
	
	public int numberOfTroops() {return availableTroops.size();}
	
	

}
