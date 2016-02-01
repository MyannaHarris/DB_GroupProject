
public class User {
	
	private int ID;
	private int type; //0 is student, 1 is alumni
	
	public User(int ID_P) {
		ID = ID_P;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type_P) {
		type = type_P;
	}
}
