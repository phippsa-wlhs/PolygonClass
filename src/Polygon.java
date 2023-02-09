import java.text.DecimalFormat;
/**
 * @file Polygon Java
 * @Date 2/2/23
 * @Author Andrew Phipps
 *
 * @Description identifies if the shape imputed is a polygon and prints out the side lengths, number of sides, type, area and perimeter.
 */
public class Polygon {
    /**
     * instance variables
     */
    private int sides;
    private double sideLength;
    private String type;
    private double area;
    private double perimeter;

    private boolean check;

    /**
     * default constructor
     *
     * @deprecation Creates a polygon with the side lengths, sides, area, perimeter, and type
     *
     */
    public Polygon(){
        sides = 3;
        sideLength = 1.0;
        area = 0.433;
        perimeter = 3;
        type = "triangle";
    }
    /**
     * overloaded constructor
     *
     * @description test to see if is it a proper polygon and if so runs with it otherwise puts in default values
     *
     * @param s number of sides
     * @param sl the length of a side
     * @param t the type of polygon
     *
     */
        public Polygon(int s, double sl, String t){
            /**
             * validation check
             *
             * @description checks to see if it is a true polygon and then will construct it otherwise will input default values
             */
            if(s < 2 || sl < 0.0){
                sides = 3;
                sideLength = 1.0;
                type = "triangle";
                area = 0.433;
                perimeter = 3;
                check = false;
            }else{
                sides = s;
                sideLength = sl;
                type = t;
                check = true;
            }

            if(s > 2 || sl > 0.0){
                /**
                 * @returns area
                 */
                getShapeArea();
                /**
                 * @returns perimeter
                 */
                getShapePerimeter();
            }
        }

    //methods and accessors
        /**
         * @return the number of sides
         */
        public int getNumSides(){
            return sides;
        }

        /**
         * @return the side length
         */
        public double getSideLength(){
            return sideLength;
        }

        /**
         * @return the polygon type
         */
        public String getShapeType(){
            return type;
        }

        /**
         * @description gets shape area
         */
        public void getShapeArea(){
            area = (sides * (sideLength * sideLength)) / (4.0 * Math.tan((Math.PI / sides)));
        }
        /**
         * @description gets shape perimeter
         */
        public void getShapePerimeter(){
            perimeter = sides * sideLength;
        }

    /**
     * @description prints out if it is not valid and gives it, its own variable set otherwise it will print out sides, sideLength, type, perimeter, and, area.
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.###"); //number point 2 decimal places.
        if(check == false) {
            return "Not a valid polygon. Your polygon was given a default of "+ sides +" sides , was named \"triangle\", and each side has a length of "+sideLength+
                    " units. " + "\n" + "The area of your \"triangle\" is "+ df.format(area) + " units and the perimeter of your \"triangle\" " + df.format(perimeter)
                    + " units. ";
        }else{
            return "Your shape is a " + type + " and it has " + sides + " sides." + "\n"
                    + "It has a side length of " + df.format(sideLength) + "." + "\n"
                    + "It has a perimeter of " + df.format(perimeter) + " units." + "\n"
                    + "It has an area of " + df.format(area) + " units.";
            }
        }
    }