import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int number1 = 0;
        for (Point curPoint : s.getPoints()){
            number1 = number1 + 1;
        }
        return number1;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avglength = getPerimeter(s)/getNumPoints(s);
        return avglength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if(currDist > largestSide){
                largestSide = currDist;
            }
        }
        // totalPerim is the answer
        return largestSide;
    }
    
    private int x;
    private int y;
    public int getX() { return x; }
    public int getY() { return y; }
    
    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            int xx = prevPt.getX();
            if(largestX < xx){
                largestX = xx;
            }
            
        }
        // totalPerim is the answer
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double total1 = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            
            double totalPerim = 0.0;
            // Start wth prevPt = the last point 
            Point prevPt = s.getLastPoint();
            // For each point currPt in the shape,
            for (Point currPt : s.getPoints()) {
                // Find distance from prevPt point to currPt 
                double currDist = prevPt.distance(currPt);
                // Update totalPerim by currDist
                totalPerim = totalPerim + currDist;
                // Update prevPt to be currPt
                prevPt = currPt;
            } 
            if(total1 < totalPerim){
                total1 = totalPerim;
            }
        }
        return total1;
    }


    public String getFileWithLargestPerimeter() {
            //Variable for holding largest perimeter value initialized to 0
        double largestPerim = 0;
            //Variable for holding filename of each file that is iterated on by the for loop initialized to 0
        String fileName = null;
            
            //Variable that you transfer filename's value to when the largest perimeter is selected for in your if conditional
        String fileNameLP = null;
            
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
                
                //Set fileName to the name of current iteration
            fileName = f.getName();
                    
                    //Convert to file resource
            FileResource fr = new FileResource(f);
                    
                    //Convert to shape
            Shape s = new Shape(fr);
                    
                    //Set current perimeter value to value of get perimeter of shape
            double currPerim = getPerimeter(s);
                
            if (currPerim > largestPerim) {
                    
                    //If current perimeter value is larger than the largest perimeter value
                    //set largets perimeter variable to current perimeter value
                largestPerim = currPerim;
                        //transfer the file name associated in the current iteration to new variable fileNameLP
                fileNameLP = fileName;      
            } 
        } 
           //Return the file name
        return fileNameLP;
       }
    

    public void testFileWithLargestPerimeter() {
        String lar_name = getFileWithLargestPerimeter();
        System.out.println("LargestX in all files' name is = " + lar_name);
    }
    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int number = getNumPoints(s);
        double avg1 = getAverageLength(s);
        double lar = getLargestSide(s);
        double larX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("total number of the points = " + number);
        System.out.println("average length = " + avg1);
        System.out.println("LargestSide = " + lar);
        System.out.println("LargestX = " + larX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double larrx = getLargestPerimeterMultipleFiles();
        System.out.println("LargestX in all files = " + larrx);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
