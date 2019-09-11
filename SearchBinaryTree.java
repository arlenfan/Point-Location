//Arlen Fan
//Point Loc Problem



public class SearchBinaryTree {
	// this class is mainly used for searching the tree
static int COUNTERCLOCKWISE = 1;
static int CLOCKWISE = -1;
static int COLINEAR = 0;

	public static int ccw(Point p0, Point p1, Point p2) {

		double dx1 = p1.x - p0.x;
		double dy1 = p1.y - p0.y;
		double dx2 = p2.x - p0.x;
		double dy2 = p2.y - p0.y;
		if (dx1*dy2 > dy1*dx2) return COUNTERCLOCKWISE;
		else if (dx1*dy2 < dy1*dx2) return CLOCKWISE;
		else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return CLOCKWISE;
		else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return COUNTERCLOCKWISE;
		else return COLINEAR;
	}


	public RegionBinaryTree head;


	public SearchBinaryTree(){	//refer to RegionBinaryTree class
		head = new RegionBinaryTree();
	}

	public void insert(Segment x)	{
		head.insert(x);
	}

	public int countRegions(RegionBinaryTree region){
		//counts the amount of leaves/external nodes
		//this determines how many unique regions there are in the tree
		if(region==null)
			return 0;
		else if(region.counterClockwiseSide==null && region.clockwiseSide==null)
			return 1;
		else{
		int x=countRegions(region.counterClockwiseSide);
		int y=countRegions(region.clockwiseSide);
		return x+y;
		}
	}


	public RegionBinaryTree search(RegionBinaryTree temp,Point pt1, Point pt2){
		int side1 = ccw(temp.segmentHead.p1, temp.segmentHead.p2, pt1);
		int side2 = ccw(temp.segmentHead.p1, temp.segmentHead.p2, pt2);

		/*
		 * To understand this method:
		 * if the child of a node is null that means it is a leaf (aka external node)
		 * and therefore a region (not a segment)
		 * so if a search ends up in null, then that means it ended up in the same region
		 * The main method calls this to see if the search ends up in null
		 *
		 *
		 * If this method returns null, then they are in the same region.
		 * If not, then the returned RegionBinaryTree result is a line segment that separates them.
		 *
		 */
		while(side1==side2){
			if(side2==CLOCKWISE){
				if(temp.clockwiseSide==null)	//end of the tree... found the same region
					return null;
				else
					temp=temp.clockwiseSide;	//keep going until they branch

			}

			else if(side2==COUNTERCLOCKWISE){
				if(temp.counterClockwiseSide==null) //end of the tree... found the same region
					return null;

				else
					temp=temp.counterClockwiseSide; //keep going until they branch

			}

			side1=ccw(temp.segmentHead.p1, temp.segmentHead.p2, pt1);
			side2=ccw(temp.segmentHead.p1, temp.segmentHead.p2, pt2);
			//set ccw values and run the search again
		}
		return temp;
	}




}
