package GameObjects;

import java.awt.Image;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;

public class Dice {
	
	int faces[] = {1,2,3,4,5,6};
	public ImageIcon face_img[] = { 
				new ImageIcon("assets/dice_1.png"), 
				new ImageIcon("assets/dice_2.png"), 
				new ImageIcon("assets/dice_3.png"), 
				new ImageIcon("assets/dice_4.png"),
				new ImageIcon("assets/dice_5.png"),
				new ImageIcon("assets/dice_6.png")};
	
	public Dice() {
		
	}
	
	public int[] roll(int numOfDie) {
		int values[] = new int[numOfDie];
		for (int d = 0; d < numOfDie; d++) {
			values[d] = faces[RandomNumber(0,faces.length)];
			
		}
		
		return values ;
	}
	
	public int getHighest(int[] roll) {
		int h = 0;
		for(int i =0; i< roll.length-1;i++) {
			if(roll[i] > roll[i+1]) {
				h = roll[i];
			}
		}
		return h;
	}
	
	public void sort (int [] rolls) {
		Arrays.sort(rolls);
	}
	
	public int RandomNumber(int lower, int upper) {
	    Random random = new Random();
	    return random.nextInt(upper - lower) + lower;
	}
}
