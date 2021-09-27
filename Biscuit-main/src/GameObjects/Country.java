package GameObjects;

public class Country {
	
	public Continent home;
	public String name = "";
	public Troop[] troops;
	
	public Country(String _name, Troop[] guests) {
		name = _name;
		troops = guests;
	}
	
	public Country(String _name) {
		name = _name;
	}
}
