package GameObjects;


public interface cardInterface {
	enum CardType{
		Territory,
		Mission
	}
	public String title = "";
	public String desc = "";
	
	public Territory terr = null;
	int units = 1;
	
	
	
	public void Activate();
	
	public void Destroy();
	
	

}
