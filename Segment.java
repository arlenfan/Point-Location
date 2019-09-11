//Arlen Fan
//Point Loc Problem


public class Segment {
	//a segment is defined by two points
	public Point p1;
	public Point p2;

	public Segment(double x1, double y1, double x2, double y2){
		//ctor
		p1 = new Point(x1,y1);
		p2 = new Point(x2,y2);
	}

	public static boolean boolIntersect(Segment segment1, Segment segment2){

		//http://www.dreamincode.net/forums/topic/217676-intersection-point-of-two-lines/
		//refer to commented System.out.println(); to see what every if statement does

		double x1 = segment1.p1.x;
		double y1 = segment1.p1.y;
		double x2 = segment1.p2.x;
		double y2 = segment1.p2.y;
		double x3 = segment2.p1.x;
		double y3 = segment2.p1.y;
		double x4 = segment2.p2.x;
		double y4 = segment2.p2.y;

		double d = (y3-y4)*(x1-x2) - (y1-y2)*(x3-x4);
		if (d == 0) return false;

		//System.out.println("\nThe segments don't intersect as they are colinear.\n");

		double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
		double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;

		//System.out.println("The segments intersect, but we now check to see if they intersect within bounds.");
		//System.out.println("(Intersection pt): ("+xi+", "+yi+")");

		if (x3==x4) { //if vertical line
			if (yi < Math.min(y1,y2) || yi > Math.max(y1,y2)){
				//System.out.println("They intersect out of bounds. Return false.");
				return false;
			}
		}

		else if (xi < Math.min(x1,x2) || xi > Math.max(x1,x2) ||xi < Math.min(x3,x4) || xi > Math.max(x3,x4)){

			//System.out.println("They intersect out of bounds. Return false.");
			return false;

		}
		//System.out.println("It turns out that they do intersect in bounds. Return true.");
		return true;
	}

	public String toString(){
		//System.out.println();
		return p1 + " and " + p2;
	}




}
