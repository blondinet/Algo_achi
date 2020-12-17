package ressources;


public class Position {
	private int xPos;
	private int yPos;
	
	public Position(int x, int y) {
		this.xPos=x;
		this.yPos=y;
	}
	
	public Position(Position pos) {
		this.xPos=pos.getPosX();
		this.yPos=pos.getPosY();
	}
	
	public int getPosX() {
		return this.xPos;
	}
	public int getPosY() {
		return this.yPos;
	}
	public void setPosX(int x) {
		this.xPos=x;
	}
	public void setPosY(int y) {
		this.yPos=y;
	}
	
	public void moveY(int pos) {
		this.setPosY(this.yPos+pos);
	}
	public void moveX(int pos) {
		this.setPosX(this.xPos+pos);
	}
	
	public boolean estCase(Position pos) {
		return this.xPos==pos.getPosX() && this.yPos==pos.getPosY();
	}
}
