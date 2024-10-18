package appDomain;

import shapes.*;
import utilities.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class AppDriver {

    public static void main(String[] args) {
        // Parses the command line arguments
        String filePath = ""; // Placeholder 
        Comparator<Shape> comparator = null; // Placeholder 
        String sortAlgorithm = ""; // Placeholder 

        // Parses command line arguments
        for (String arg : args) {
            if (arg.startsWith("-f") || arg.startsWith("-F")) {
                filePath = arg.substring(2);  
            } else if (arg.startsWith("-t") || arg.startsWith("-T")) {
                char type = arg.charAt(2);  
                switch (type) {
                    case 'v':  // Sort by volume
                        comparator = Shape.VolumeComparator.reversed();  
                        break;
                    case 'h':  // Sort by height (natural order)
                        comparator = Comparator.naturalOrder();  
                        break;
                    case 'a':  // Sort by base area
                        comparator = Shape.AreaComparator.reversed();  
                        break;
                    default:
                        System.out.println("Invalid sorting type: " + type);
                        return;
                }
            } else if (arg.startsWith("-s") || arg.startsWith("-S")) {
                sortAlgorithm = arg.substring(2).toLowerCase();  
            }
        }


        // Reads shape data from the file
        Shape[] shapes = readShapesFromFile(filePath);
        if (shapes.length == 0) {
            System.out.println("No shapes to sort.");
            return;
        }

//     //   DEBUG
//        for (Shape shape : shapes) {
//            System.out.println(shape + " has a Volume of: " + shape.getVolume());
//        }

    
        
        // Start time
        long startTime = System.currentTimeMillis();  

        // Sorts the shapes based on the user selected algorithm and comparator
        switch (sortAlgorithm) {
            // Bubble sort
            case "b": 
            	BubbleSort.bubbleSort(shapes, Shape.VolumeComparator.reversed());
                break;
            // Selection sort
            case "s":  
                SelectionSort.selectionSort(shapes, comparator);
                break;
            // Insertion sort
            case "i":  
                InsertionSort.insertionSort(shapes, comparator);
                break;
            // Merge sort
            case "m":  
                MergeSort.mergeSort(shapes, comparator);
                break;
            // Cocktail sort 
            case "z": 
                CocktailSort.cocktailSort(shapes, comparator);
                break;
            default:
                System.out.println("Invalid sorting algorithm: " + sortAlgorithm);
                return;
        }
        // End timer
        long endTime = System.currentTimeMillis();  

//     // DEBUG: Print the volume of each shape after sorting
//        System.out.println("After Sorting:");
//        for (Shape shape : shapes) {
//            System.out.println(shape + " has a Volume of: " + shape.getVolume());
//        }

        // Displays the sorted elements
       
        displaySortedShapes(shapes);

        // Step 6: Display runtime
        System.out.println(sortAlgorithm + " sort run time was: " + (endTime - startTime) + " milliseconds");
    }

    /**
     * Reads shape data from a file and returns an array of shapes.
     */
    public static Shape[] readShapesFromFile(String filePath) {
    	// Error checks to make sure array is not empty
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int numberOfShapes = scanner.nextInt();  
            Shape[] shapes = new Shape[numberOfShapes];  

            // Skips the first line (number of shapes)
            scanner.nextLine();

            int index = 0;
            while (scanner.hasNextLine() && index < numberOfShapes) {  
                String[] shapeData = scanner.nextLine().split(" ");
                String shapeType = shapeData[0];
                double height = Double.parseDouble(shapeData[1]);
                double side = Double.parseDouble(shapeData[2]);

                // Create the appropriate shape based on the type
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
    public static void displaySortedShapes(Shape[] shapes) {
        int n = shapes.length;

        System.out.println("First element is: " + shapes[0]);

        
        for (int i = 1000; i < n; i += 1000) {
            System.out.println(i + "-th element is: " + shapes[i - 1]);
        }

      
        if (n > 1) {
            System.out.println("Second Last element is: " + shapes[n - 2]);
        }


        System.out.println("Last element is: " + shapes[n - 1]);
    }
}
