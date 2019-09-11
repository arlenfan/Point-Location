//Arlen Fan
//Point Loc Problem

public class RegionBinaryTree {

	public Segment segmentHead;
	/*
	 * This class is called RegionBinaryTree and contains segments.
	 * Think of the variable up there public Segment segmentHead as data or element in a tree
	 * It stores the segment class, which is defined in my segment class.
	 * The segment class is just defined as two points.
	 */

	//instead of right and left, I use cw side and ccw side

	public RegionBinaryTree counterClockwiseSide;
	public RegionBinaryTree clockwiseSide;
	static int COUNTERCLOCKWISE = 1;
	static int CLOCKWISE = -1;


	public String toString(){
		//System.out.println();
		return " "+segmentHead+" ";
	}


	public void insert(Segment x){	//finds where to put the segment into the tree
		if(segmentHead == null)
			segmentHead = x;
		else{
			if(false == !Segment.boolIntersect(segmentHead,x)){
				if(counterClockwiseSide == null){
					counterClockwiseSide = new RegionBinaryTree();
				}	//makes new c-clockwiseside child if there is none already


				if(clockwiseSide == null){
					clockwiseSide = new RegionBinaryTree();
				}	//makes new clockwiseside child if there is none already

				counterClockwiseSide.insert(x);
				clockwiseSide.insert(x);
			}


			else if(SearchBinaryTree.ccw(segmentHead.p1, segmentHead.p2, x.p1)
					== CLOCKWISE){

				if(clockwiseSide == null){
					clockwiseSide = new RegionBinaryTree();
				}
				clockwiseSide.insert(x);
			}

			else if(SearchBinaryTree.ccw(segmentHead.p1, segmentHead.p2, x.p1)
					== COUNTERCLOCKWISE){

				if(counterClockwiseSide == null){
					counterClockwiseSide = new RegionBinaryTree();
				}
				counterClockwiseSide.insert(x);
			}
		}
	}


}
