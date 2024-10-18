package appDomain;
import shapes.*;
import utilities.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Comparator;


public class AppDriver
{
 
 public static void main(String[] args) 
 {
  
  // Check command line does it has 6 arguments included.
        if (args.length != 6) 
        {
            System.out.println("6 command line arguments are required as sample below.");
            System.out.println("java -jar Sort.jar -f<fileName> -t<type> -s<algorithm>");
            return;
        }
  
        // Declare variables.
        String fileName = null;
        String sortType = null;
        String sortAlgorithm = null;
        
        // For loop to run each argument in command line.
        for (int i = 0; i < args.length; i++) 
        {
         
         // Re-format argument to lower case.
         String argElement = args[i].toLowerCase();
         
         // Check filename
            if (argElement.startsWith("-f")) 
            {
             // Assign filename starts with index 2 since we have -f which are index 0 and 1.
                fileName = argElement.substring(2);
                
                // In case there is double quotes come with file path.
                if (fileName.startsWith("\"") && fileName.endsWith("\"")) 
                {
                 fileName = fileName.substring(2, fileName.length() - 1);
                }
            } 
            
            // Check type to sort which are height, volume or area.
            else if (argElement.startsWith("-t")) 
            {
	             // Assign sort type to variable.
	             sortType = argElement.substring(2);
           
	             // If sortType doesn't match with "h", "a", "v" just return.
	             if (!sortType.matches("[hav]")) 
	             {
	                  System.out.println("Sort type must be 'h' for sorting by height, "
	                    + "'a' for sorting by area "
	                    + "or 'v' for sorting by volume");
	                  return;
	             }
            }
            
         // Check algorithm to sort.
            else if (argElement.startsWith("-s")) 
            {
	             // Assign sort algorithm to variable.
	             sortAlgorithm = argElement.substring(2);
	             
	             // If sortType doesn't match just return.
	             if (!sortAlgorithm.matches("[bzimqs]")) 
	             {
	                    System.out.println("Sort algorithm must be one of 'b' for bubble sort, "
	                      + "'z' for cocktail sort, "
	                      + "'i' for insertion sort, "
	                      + "'m' for merge sort, "
	                      + "'q' for quick sort, "
	                      + "or 's' for selection sort.");
	                    return;
	                }
             
            } 
            
        }
        
        // Check statement if user doesn't input the filename.
        if (fileName == null) 
        {
            System.out.println("File name is required in arguments start with (-f)");
            return;
        }
        
        // Check statement if user doesn't input the sort type.
        if (sortType == null) 
        {
            System.out.println("Sorting type is required in arguments start with (-t).");
            return;
        }

        // Check statement if user doesn't input the sort algorithm.
        if (sortAlgorithm == null) 
        {
            System.out.println("Sorting algorithm is required in arguments start with (-s).");
            return;
        }
     
        Shape[] shapes = readShapesFromFile(fileName);
        

        // Start timer
        long startTime = System.currentTimeMillis();
        
        // **********************************************************
        
        if (sortType != null && sortAlgorithm != null) 
        {
         Comparator<Shape> comparator = null;
         
            // Choose the comparison type based on sortType
            switch (sortType) 
            {
            
                case "h":
                    // Sort by height
                    System.out.println("Sorting by height...");
                    break;
                    
                case "a":
                    // Sort by area
                 comparator = Shape.AreaComparator;
                    System.out.println("Sorting by area...");
                    break;
                    
                case "v":
                    // Sort by volume
                 comparator = Shape.VolumeComparator;
                    System.out.println("Sorting by volume...");
                    break;
                    
                default:
                    System.out.println("Invalid sort type.");
                    return;
                    
            }

            // Apply the chosen sorting algorithm (bubble, insertion, etc.)
            switch (sortAlgorithm) 
            {
                case "b":
                    System.out.println("Hold on .. using Bubble sort");
                    BubbleSort.bubbleSort(shapes, comparator);
                    break;
                case "z":
                    System.out.println("Hold on .. using Cocktail sort");
                    CocktailSort.cocktailSort(shapes, comparator);
                    break;
                case "i":
                    System.out.println("Hold on .. using Insertion sort");
                    InsertionSort.insertionSort(shapes, comparator);
                    break;
                case "m":
                    System.out.println("Hold on .. using Merge sort");
                    MergeSort.mergeSort(shapes, comparator);
                    break;
                case "q":
                    System.out.println("Hold on .. using Quick sort");
                    QuickSort.sort(shapes, comparator);
                    break;
                case "s":
                    System.out.println("Hold on .. using Selection sort");
                    SelectionSort.selectionSort(shapes, comparator);
                    break;
                default:
                    System.out.println("Invalid sort algorithm.");
                    return;
            }
        }
        
        // **********************************************************
        
        // End timer
        long endTime = System.currentTimeMillis();  

        // Displays the first, every 1000th, and last element.
        displaySortedShapes(shapes);
        
        // Displays runtime.
        System.out.println(sortAlgorithm + " sort run time was: " + (endTime - startTime) + " milliseconds");
        
//        Prints sorted data.
//        System.out.println("Sorted Data:");
//        for (Shape shape : shapes) 
//        {
//         System.out.println(shape);
//        }
        
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
