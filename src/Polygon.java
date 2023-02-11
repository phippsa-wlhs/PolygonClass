import java.text.DecimalFormat;
/**
 * @file Polygon Java
 * @Date 2/10/23
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
        check = true;
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
                calculateArea();
                /**
                 * @returns perimeter
                 */
                calculatePerimeter();
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
         * @description if newSides is greater than or equal to 3, sides become newSides otherwise it stays as sides
         * @param newSides
         */
        public void setNumSides(int newSides) {
            if(sides <= 3){
                sides = newSides;
            }
        }

        /**
         * @return the side length
         */
        public double getSideLength(){
            return sideLength;
        }

        /**
         * @description if newSideLength is not greater than or equal to zero, sideLength becomes newSideLength otherwise it stays as sideLength
         * @param newSideLength
         */
        public void setSideLength(double newSideLength){

            if(newSideLength >= 0) {
                sideLength = newSideLength;
            }
        }


        /**
         * @return the polygon type
         */
        public String getShapeType(){
            return type;
        }

        /**
         * @description if newType does not equal none, type becomes newType otherwise it stays type
         * @param newType
         */
        public void setShapeName(String newType){
                if(newType != ("none")){
                    type = newType;
                }
            }


        /**
         * @description calculate shape area
         */
        public double calculateArea(){
            area = (sides * (sideLength * sideLength)) / (4.0 * Math.tan((Math.PI / sides)));
            return area = Math.round(area*1000)/1000.0;
        }
        /**
         * @description get shape area and rounds it to the nearest 1000th place
         */
        public double getArea(){
        area = (sides * (sideLength * sideLength)) / (4.0 * Math.tan((Math.PI / sides)));
        return area = Math.round(area*1000)/1000.0;
    }
        /**
         * @description gets shape perimeter and rounds it to the nearest 1000th place
         */
        public double calculatePerimeter(){
            perimeter = Math.round(sides * sideLength * 1000);
            return perimeter /= 1000.0;
        }

    /**
     * @description prints out if it is not valid and gives it, its own variable set otherwise it will print out sides, sideLength, type, perimeter, and, area.
     */
    public String toString() {
        if(check == false) {
            return "Not a valid polygon. Your polygon was given a default of "+ sides +" sides , was named \"triangle\", and each side has a length of "+sideLength+
                    " units. " + "\n" + "The area of your \"triangle\" is "+ area + " units and the perimeter of your \"triangle\" " + perimeter + " units. ";
        }else{
            return "Your shape is a " + type + " and it has " + sides + " sides." + "\n"
                    + "It has a side length of " + sideLength + "." + "\n"
                    + "It has a perimeter of " + perimeter + " units." + "\n"
                    + "It has an area of " + area + " units.";
            }
        }
    }