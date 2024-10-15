package appDomain;
import shapes.*;
import utilities.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Comparator;


public class AppDriver
{

	// TODO Auto-generated method stub

	// refer to demo001 BasicFileIO.java for a simple example on how to
	// read data from a text file

	// refer to demo01 Test.java for an example on how to parse command
	// line arguments and benchmarking tests

	// refer to demo02 Student.java for comparable implementation, and
	// NameCompare.java or GradeCompare for comparator implementations

	// refer to demo02 KittySort.java on how to use a custom sorting
	// algorithm on a list of comparables to sort using either the
	// natural order (comparable) or other orders (comparators)
	
	public static void main(String[] args) {
  
        Shape[] shapes = readShapesFromFile("res/shapes2.txt");
        
        // if (shapes.length == 0) {
        //     System.out.println("No shapes to sort.");
        //     return;
        // }

       	// Start timer
        long startTime = System.currentTimeMillis();  

        // Use any sorting algorithm here 
        // BubbleSort.bubbleSort(shapes);
        // MergeSort.mergeSort(shapes, Shape.VolumeComparator);
        
        // End timer
        long endTime = System.currentTimeMillis();  

        // DisplayS the first, every 1000th, and last element
         printSortedHighlights(shapes);
        
        // Displays runtime
        System.out.println("b run time was: " + (endTime - startTime) + " milliseconds");
        
        // New array
        System.out.println("Sorted Data:");
        for (Shape shape : shapes) {
        	System.out.println(shape);
        }
    }

    /**
     * Reads shape data from a file and returns an array of shapes.
     */
    public static Shape[] readShapesFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int numberOfShapes = scanner.nextInt();  
            Shape[] shapes = new Shape[numberOfShapes];  

            // Skips the fist line (number of elements)
            scanner.nextLine();

            int index = 0;
            while (scanner.hasNextLine() && index < numberOfShapes) { 
                String[] shapeData = scanner.nextLine().split(" ");
                String shapeType = shapeData[0];
                double height = Double.parseDouble(shapeData[1]);
                double side = Double.parseDouble(shapeData[2]);

                // Creates the appropriate shape based on the type
                switch (shapeType) {
                    case "Pyramid":
                        shapes[index++] = new Pyramid(height, side);
                        break;
                    case "Cylinder":
                        shapes[index++] = new Cylinder(height, side);
                        break;
                    case "Cone":
                        shapes[index++] = new Cone(height, side);
                        break;
                    case "PentagonalPrism":
                        shapes[index++] = new PentagonalPrism(height, side);
                        break;
                    case "OctagonalPrism":
                        shapes[index++] = new OctagonalPrism(height, side);
                        break;
                    case "TriangularPrism":
                        shapes[index++] = new TriangularPrism(height, side);
                        break;
                    case "SquarePrism":
                        shapes[index++] = new SquarePrism(height, side);
                        break;
                    	
                    default:
                        System.out.println("Unknown shape type: " + shapeType);
                        break;
                }
            }

            scanner.close();
            return shapes;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return new Shape[0];  
    }

    /**
     * Prints the first element, every 1000th element, and the last element of the sorted array.
     */
    public static void printSortedHighlights(Shape[] shapes) {
        int n = shapes.length;

        // Prints the first element
        System.out.println("First element is: " + shapes[0]);

        // Prints every 1000th element
        for (int i = 1000; i < n; i += 1000) {
            System.out.println(i + "-th element is: " + shapes[i - 1]);
        }

        // Prints the second last element
        if (n > 1) {
            System.out.println("Second Last element is: " + shapes[n - 2]);
        }

        // Prints the last element
        System.out.println("Last element is: " + shapes[n - 1]);
    }
}
