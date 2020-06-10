package guiProgram;

public class HoopWithEquals extends Hoop {
	public HoopWithEquals(int xin,int yin, int d, int t) {
		super(xin,yin, d, t);
	}
	public boolean equals(HoopWithEquals w) {
		return(getDiameter() == w.getDiameter() && getThickness() == w.getThickness());
	}
	public HoopWithEquals clone() {
		int outerDiameter = getDiameter();
		int innerDiameter = outerDiameter - 2 * getThickness();
		return new HoopWithEquals(getX(), getY() , outerDiameter, innerDiameter);
	}
	public static void main(String [] args) {
		//Create hoop
		HoopWithEquals hoop= new HoopWithEquals(100, 66, 90,20);
		//identical hoop but diff object
		HoopWithEquals hoop1= hoop.clone();
		System.out.println("hoop1 == hoop? " + (hoop1 == hoop) + " \t" + "hoop1.equals(hoop)?" + hoop1.equals(hoop));
		
		//point hoop1 to same object that hoop refers to
		
		hoop1 = hoop;
		
		System.out.println("hoop == hoop? " + (hoop1 == hoop) + "\t" + "hoop1.equals(hoops)?" + hoop1.equals(hoop));
	}
	
}
