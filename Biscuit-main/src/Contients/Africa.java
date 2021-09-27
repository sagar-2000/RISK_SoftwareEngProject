package Contients;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import GameObjects.Continent;
import GameObjects.Country;

public class Africa implements Continent {
	
	public Africa() {
		//countries.add(new Country("South Africa"));
	}
	
	public void populateCountries() throws FileNotFoundException {
		// read from text file
		Scanner sc = new Scanner(new File(dataPath));
		
		while(sc.hasNext()) {
		String chuncks[] = sc.nextLine().split("@");
		
		for(String ch : chuncks) {
			System.out.println(ch);
		}
		}
		
	}
	
	private void Debug() {
		
	}
}
