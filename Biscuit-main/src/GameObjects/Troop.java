package GameObjects;

public class Troop {
	public enum TroopType{
		Infantry,
		Cavalry,
		Artillery	
	}
	
	public TroopType type;
	public Player owner;
	
	public Troop(TroopType type) {
		this.type = type;
		
	}
}
