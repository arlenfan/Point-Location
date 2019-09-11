//Arlen Fan
//Point Loc Problem

import java.io.*;

public class Project3PointLocationProblem {

	static int COUNTERCLOCKWISE = 1;
	static int CLOCKWISE = -1;

	public static void main(String[] args) throws IOException	{
		int amountOfLines = 1;
		int amountOfPairedPoints = 1;

		SearchBinaryTree theTree = new SearchBinaryTree();
		String[] inputSplittedCoordinates = new String[4];

		String inputFile= "problemset.txt";
		String outputFile= "OUTPUT.txt";
		BufferedReader bufRead = new BufferedReader(new FileReader(inputFile));
		BufferedWriter bufWrite = new BufferedWriter(new FileWriter(outputFile));
		amountOfLines = Integer.parseInt(bufRead.readLine());


		double x1 = 1, y1 = 1;
		double x2 = 1, y2 = 1;

		String theSplitter =   "    ";
		for(int i=0; i<amountOfLines; i++)	{
			theSplitter = bufRead.readLine();


			inputSplittedCoordinates=theSplitter.split(" ");
			x1=Double.parseDouble(inputSplittedCoordinates[0]);
			y1=Double.parseDouble(inputSplittedCoordinates[1]);
			x2=Double.parseDouble(inputSplittedCoordinates[2]);
			y2=Double.parseDouble(inputSplittedCoordinates[3]);

			theTree.insert(new    Segment(x1,y1,x2,y2)  );
		}
		bufWrite.write("Arlen Fan");	bufWrite.newLine();
		bufWrite.write("Point Location Problem");	bufWrite.newLine();
		bufWrite.write("amountOfLines = " + amountOfLines);    bufWrite.newLine();
		bufWrite.write("Calculating # of external nodes in the tree... ");	bufWrite.newLine();
	    bufWrite.write("Number of unique regions detected: "+theTree.countRegions(theTree.head));
	    bufWrite.newLine();


	    double timeStart = System.nanoTime() / 1000000;
	    bufWrite.newLine();

		bufWrite.write("Starting timer...");	bufWrite.newLine();

		int debug = 0;

		Point ptSplit1 = new Point(0,0), ptSplit2 = new Point (0,0);

		amountOfPairedPoints=Integer.parseInt(bufRead.readLine());

		debug += amountOfPairedPoints;


	    System.out.println("value of debug: "+ debug);	//debug variable for reading line
	    //it should work now, so this is no use

	    bufWrite.write("number of point pairs to be checked = " + amountOfPairedPoints);    bufWrite.newLine();

	    bufWrite.newLine();
		for(int x=0; x<amountOfPairedPoints;x++)	{
			theSplitter = bufRead.readLine();
			inputSplittedCoordinates=theSplitter.split(" ");

			ptSplit1.x=Double.parseDouble(inputSplittedCoordinates[0]);
			ptSplit1.y=Double.parseDouble(inputSplittedCoordinates[1]);
			System.out.println("ptSplit1.x "+ptSplit1.x);
			System.out.println("ptSplit1.y "+ptSplit1.y);

			ptSplit2.x=Double.parseDouble(inputSplittedCoordinates[2]);
			ptSplit2.y=Double.parseDouble(inputSplittedCoordinates[3]);
			System.out.println("ptSplit2.x "+ptSplit2.x);
			System.out.println("ptSplit2.y "+ptSplit2.y);

			if(theTree.search(theTree.head, ptSplit1, ptSplit2) != null)
				bufWrite.write(ptSplit1+" and "+ptSplit2+" are separated by the segment defined by "
			+theTree.search(theTree.head, ptSplit1, ptSplit2));
			else
				bufWrite.write(ptSplit1+" and "+ptSplit2+" are in the same region.");

			bufWrite.newLine();
		}

		bufWrite.newLine();
		bufWrite.write("The search took "+(System.nanoTime()/1000000-timeStart) +" milliseconds.");
		bufRead.close();	bufWrite.close();
	}
}
