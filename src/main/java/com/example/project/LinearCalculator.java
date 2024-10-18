package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coordinateOne, String coordinateTwo){ // <--add 2 string parameters to this constructor
        int coordinateOneComma = coordinateOne.indexOf(",");
        int coordinateOneLength = coordinateOne.length();
        x1 = Integer.parseInt(coordinateOne.substring(1, coordinateOneComma));
        y1 = Integer.parseInt(coordinateOne.substring(coordinateOneComma + 1, coordinateOneLength - 1));
        int coordinateTwoComma = coordinateTwo.indexOf(",");
        int coordinateTwoLength = coordinateTwo.length();
        x2 = Integer.parseInt(coordinateTwo.substring(1, coordinateTwoComma));
        y2 = Integer.parseInt(coordinateTwo.substring(coordinateTwoComma + 1, coordinateTwoLength - 1));
    }

    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX){x1 = newX;}
    public void setY1(int newY){y1 = newY;}
    public void setX2(int newX){x2 = newX;}
    public void setY2(int newY){y2 = newY;}

    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        int yDistance = (y1) - (y2);
        int xDistance = (x1) - (x2);
        double distance = roundedToHundredth(Math.sqrt(Math.pow(xDistance,2) + Math.pow(yDistance,2)));
        return distance; 
    }
    
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double slope = slope();
        if(slope == -999.99){
            return -999.99;
        }
        return roundedToHundredth(y1 - slope * x1);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if(x1 != x2){
            return roundedToHundredth(((y2 * 1.0) - (y1))/((x2 * 1.0)-(x1)));
        }
        else{
            return -999.99;
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        double slope = slope();
        double yInt = yInt();
        if(slope == -999.99){
            return "undefined";
        }
        if(slope == 0.0){
            return "y=" + yInt;
        }
        if(yInt == 0.0){
            return "y=" + slope + "x";
        }
        if(yInt < 0){
            return "y=" + slope + "x" + yInt;
        }
        return "y=" + slope + "x" + "+" + yInt;
    }

    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100.0)/100.0;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation() ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        double xSymmetry = 0 - x1;
        double ySymmetry = 0 - y1;
        if(y2 == ySymmetry && x2 == xSymmetry){
            return "Symmetric about the origin";
        }
        else if(y2 == ySymmetry){
            return "Symmetric about the x-axis";
        }
        else if(x2 == xSymmetry){
            return "Symmetric about the y-axis";
        }
        return "No symmetry";
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double xDistance = ((x2) + (x1))/2;
        double yDistance = ((y2) + (y1))/2;
        return "The midpoint of this line is: (" + roundedToHundredth(xDistance) + "," + roundedToHundredth(yDistance) + ")";
    }

}



