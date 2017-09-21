package LecturerExampleUDPObject;

import java.io.Serializable;

public class Points implements Serializable {
	private double x;
	private double y;
	
	public Points(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Points() {
		this(0.0, 0.0);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}