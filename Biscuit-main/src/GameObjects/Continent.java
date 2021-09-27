package GameObjects;

import java.util.ArrayList;



public interface Continent {
	public String dataPath = "/Users/rubenvanbreda/OneDrive/Development/UCD Coding/Java/RISK/src/Contients/contientDetails.txt";
	public enum ContinentName{
		Africa,
		Asia,
		Australia,
		Europe,
		North_America,
		South_America;	}
	
	public ContinentName location = ContinentName.Africa;
	public ArrayList<Country> countries = null;
	public int numberOfTerritories = countries.size();
	
}
