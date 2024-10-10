package appDomain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.*;

public class AppDriver
{

	public static void main( String[] args )
	{
		
		// Read data from a text file.
		try 
			{
			  // ***** Change your file path here. *****
		      File myFile = new File("res/shapes1.txt");
		      // ***** Change your file path here. *****
		      
		      Scanner myReader = new Scanner(myFile);
		      
		      // Read the first line which contains the number of shapes.
		      int numberOfShapes = myReader.nextInt();
		      
		      // Create an array of shapes.
		      String[] shapes = new String[numberOfShapes];
		      
		   	  // Skip the first line which is the number of shapes.
		      myReader.nextLine();
		      
		      // Shape indexing and tracking.
		      int currentShape = 0;
		      
		      // Loop reading each line.
		      while (myReader.hasNextLine()) 
		      {
		    	 // Store each line to shapes's array, then increase the index value.
		    	 shapes[currentShape] = myReader.nextLine();
		    	 currentShape++;
		      }
		      
		      // Close file when the process is done.
		      myReader.close();
		      
		      // Iteration all shapes that got from text files.
		      for (String shape : shapes) 
		      {
		    	  	// Split each element in array, then assign to variable by using its index.
		    	  	String[] shapeComponents = shape.split(" ");
		    	  	String firstIndex = shapeComponents[0];
		    	  	String secondIndex = shapeComponents[1];
		    	  	String thirdIndex = shapeComponents[2];
		    	  	
		    	  	// Assign height and side.
		    	  	double height = Double.parseDouble(secondIndex);
	    	  		double side = Double.parseDouble(thirdIndex);
	    	  		double radius = Double.parseDouble(thirdIndex);
		    	  	
	    	  		// Switch case by using firstIndex which is the name of the shape in text file.
		    	  	switch (firstIndex) 
		    	  	
		    	  	{
		    	  	// Case 1: If SquarePrism is considered.
		    	  	case "SquarePrism":
		    	  		SquarePrism squarePrism = new SquarePrism(height, side);
		    	  		System.out.println("The SquarePrism has a volume of: " + squarePrism.getVolume());
		    	  		break;
		    	  	
		    	  	// Case 2: If TriangularPrism is considered.
		    	  	case "TriangularPrism":
		                TriangularPrism triangularPrism = new TriangularPrism(height, side);
		                System.out.println("The TriangularPrism has a volume of: " + triangularPrism.getVolume());
		    	  		break;
		    	  	
		    	  	// Case 3: If PentagonalPrism is considered.
		    	  	case "PentagonalPrism":
		                PentagonalPrism pentagonalPrism = new PentagonalPrism(height, side);
		                System.out.println("The PentagonalPrism has a volume of: " + pentagonalPrism.getVolume());
		    	  		break;
		    	  		
		    	  	// Case 4: If OctagonalPrism is considered.
		    	  	case "OctagonalPrism":
		    	  		OctagonalPrism octagonalPrism = new OctagonalPrism(height, side);
		    	  		System.out.println("The OctagonalPrism has a volume of: " + octagonalPrism.getVolume());
		    	  		break;
		    	  	
		    	  	// Case 5: If Cone is considered.
		    	  	case "Cone":
		    	  		Cone cone = new Cone(height, radius);
		    	  		System.out.println("The Cone has a volume of: " + cone.getVolume());
		    	  		break;
		    	  	
		    	  	// Case 6: If Cylinder is considered.
		    	  	case "Cylinder":
		    	  		Cylinder cylinder = new Cylinder(height, radius);
		    	  		System.out.println("The Cylinder has a volume of: " + cylinder.getVolume());
		    	  		break;
		    	  		
		    	  	// Case 7: If Pyramid is considered.
		    	  	case "Pyramid":
		    	  		Pyramid pyramid = new Pyramid(height, side);
		    	  		System.out.println("The Pyramid has a volume of: " + pyramid.getVolume());
		    	  		break;
		    	  	
		    	  	// Default case if unknown shape is considered.
		    	  	default:
		                System.out.println("Unknown shape type: " + firstIndex);
		                break;
		    	  	}
		      
				}
		    }
		
		catch (FileNotFoundException e) 
			{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
