package com.example.project;
public class LinearCalculator{
    //Instance Variables
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //For both points, program finds index of "," and then accepts anything before it and anything after it excluding the parentheses at the start and end
    public LinearCalculator(String coordinateOne, String coordinateTwo){ // 
        int coordinateOneComma = coordinateOne.indexOf(",");
        int coordinateOneLength = coordinateOne.length();
        x1 = Integer.parseInt(coordinateOne.substring(1, coordinateOneComma));
        y1 = Integer.parseInt(coordinateOne.substring(coordinateOneComma + 1, coordinateOneLength - 1));
        int coordinateTwoComma = coordinateTwo.indexOf(",");
        int coordinateTwoLength = coordinateTwo.length();
        x2 = Integer.parseInt(coordinateTwo.substring(1, coordinateTwoComma));
        y2 = Integer.parseInt(coordinateTwo.substring(coordinateTwoComma + 1, coordinateTwoLength - 1));
    }

    //getMethods return the four coordinates while the setMethods set the coordinates to new numbers
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX){x1 = newX;}
    public void setY1(int newY){y1 = newY;}
    public void setX2(int newX){x2 = newX;}
    public void setY2(int newY){y2 = newY;}

    //Uses the pythagorean theorem to find the distance between two points and rounds the distance using the roundedtoHundredth() method
    //Returns the rounded distance
    public double distance(){
        int yDistance = (y1) - (y2);
        int xDistance = (x1) - (x2);
        double distance = roundedToHundredth(Math.sqrt(Math.pow(xDistance,2) + Math.pow(yDistance,2)));
        return distance; 
    }
    
    //Calls the slope() method.
    //If the slope is defined, the program will calculate the y-intercept using the equation y1 - slope * x1 and rounds the y-intercept using roundedtoHundredth() method.
    //If the slope is undefined, the y-intercept will also be undefined.
    //Returns the rounded y-intercept
    public double yInt(){
        double slope = slope();
        if(slope == -999.99){
            return -999.99;
        }
        return roundedToHundredth(y1 - slope * x1);
    }

    //Uses (y2 - y1)/(x2 - x1) formula to find the slope and rounds the slope using the roundedtoHundredth() method
    //Returns the rounded slope
    public double slope(){
        if(x1 != x2){
            return roundedToHundredth(((y2 * 1.0) - (y1))/((x2 * 1.0)-(x1)));
        }
        else{
            return -999.99;
        }
    }

    //Calls the slope() and yInt() methods.
    //If the slope isn't defined, the equation won't be defined.
    //If the slope is 0, the equation will be y = the y-intercept.
    //If the y-intercept is 0, the equation will be y = slope * x.
    //If the y-intercept is greater than 0, the equation will be y = slope * x + y-intercept.
    //Returns the equation
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

    //Rounds a number to 2 decimal places by multiplying it by 100.0 then rounding it to nearest whole number using Math.round() before dividing it by 100.0
    //Returns the rounded number
    public double roundedToHundredth(double x){
        return Math.round(x * 100.0)/100.0;
    }

    //Information about the two points is stored in str by calling the equation(), slope(), yInt(), distance(), findSymmetry(), and Midpoint() methods
    //Returns str
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

    //If y2 = 0 - y1 and x2 = 0 - x1, the points are symmetric about the origin
    //If y2 = 0 - y1, the points are symmetric about the x-axis
    //If x2 = 0 - x1, the points are symmetric about the y-axis
    //If none of these conditions are true, there is no symmetry
    //Returns a sentence saying what the symmetry is 
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

    //Finds the midpoint between the x and y coordiantes by using the formulas (x2 + x1)/2 and (y2 + y1)/2 and rounds the midpoint using roundedToHundredth()
    //Returns a sentence saying the value of the midpoint 
    public String Midpoint(){
        double xDistance = ((x2) + (x1))/2;
        double yDistance = ((y2) + (y1))/2;
        return "The midpoint of this line is: (" + roundedToHundredth(xDistance) + "," + roundedToHundredth(yDistance) + ")";
    }

}



