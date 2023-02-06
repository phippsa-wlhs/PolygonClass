import java.text.DecimalFormat;
/**
 * @file Polygon Java
 * @Date 2/2/23
 * @Author Andrew Phipps
 *
 * @Description identifies if the shape imputed is a polygon and prints out the side lengths, number of sides, type, area and perimeter.
 */
public class Polygon {

    //instance variables
    private int sides;
    private double sideLength;
    private String type;
    private double area;
    private double perimeter;

    //default constructor
    public Polygon(){
        sides = 3;
        sideLength = 1.0;
        area = 0.433;
        perimeter = 3;
        type = "triangle";
    }

    //overloaded constructor
        public Polygon(int s, double sl, String t){
            sides = s;
            sideLength = sl;
            type = t;

            //validation check
            if(s < 3){
                type = "none";
            }
            if(sl <= 0){
                type = "none";
            }

            if(type != "none"){
                //area check
                getShapeArea();

                //finding perimeter
                getShapePerimeter();
            }
        }

    //methods and accessors
        //getNumSides
        public int getNumSides(){
            return sides;
        }

        // getSideLength
        public double getSideLength(){
            return sideLength;
        }

        // getShapeType
        public String getShapeType(){
            return type;
        }

        //getShapeArea
        public void getShapeArea(){
            area = (sides * (sideLength * sideLength)) / (4.0 * Math.tan((Math.PI / sides)));
        }
        //getShapePerimeter
        public void getShapePerimeter(){
            perimeter = sides * sideLength;
        }

    //String output
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.###"); //number pint 2 decimal places.
        if(type == "none") {
            return "Not a valid polygon";
        }else{
            return "Your shape is a " + type + " and it has " + sides + " sides." + "\n"
                    + "It has a side length of " + df.format(sideLength) + "." + "\n"
                    + "It has a perimeter of " + df.format(perimeter) + " units." + "\n"
                    + "It has an area of " + df.format(area) + " units.";
            }
        }
    }