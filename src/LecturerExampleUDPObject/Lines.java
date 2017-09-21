package LecturerExampleUDPObject;

import java.io.Serializable;

public class Lines implements Serializable {
	private Points p1;
	private Points p2;
	
	public Lines(Points p1, Points p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Lines() {
		p1 = new Points();
		p2 = new Points();
	}
	
	public Points getP1() {
		return p1;
	}
	
	public Points getP2() {
		return p2;
	}
	
	public void setP1(Points p1) {
		this.p1 = p1;
	}
	
	public void setP2(Points p2) {
		this.p2 = p2;
	}
	
	public Points getMidPoint() {
		Points midPoint = new Points((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2);
		return midPoint;
	}
	
	@Override
	public String toString() {
		return "p1 " + p1.toString() + ", " + "p2 " + p2.toString();
	}
}