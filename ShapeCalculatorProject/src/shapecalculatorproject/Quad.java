/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapecalculatorproject;

/**
 *
 * @author parihar1205
 */
public class Quad 
{
    public Quad(String a, String b, String c, String d)
    {
        int commaA = a.indexOf(",");
        xA = Integer.parseInt(a.substring(1, commaA));
        yA = Integer.parseInt(a.substring((commaA+1), (a.length()-1)));
        int commaB = a.indexOf(",");
        xB = Integer.parseInt(a.substring(1, commaA));
        yB = Integer.parseInt(a.substring((commaA+1), (a.length()-1)));
        int commaC = a.indexOf(",");
        xC = Integer.parseInt(a.substring(1, commaA));
        yC = Integer.parseInt(a.substring((commaA+1), (a.length()-1)));
        int commaD = a.indexOf(",");
        xD = Integer.parseInt(a.substring(1, commaA));
        yD = Integer.parseInt(a.substring((commaA+1), (a.length()-1)));
    }
    
    public double getSlope(double x1, double x2, double y1, double y2)
    {
        return (y2 - y1)/(x2 - x1);
    }
    public double getDistance(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
    }
    public double getArea()
    {
        if (type.equals("Rectangle"))
        {
            return (getDistance(xA, xB, yA, yB)) * (getDistance(xB, xC, yB, yC));
        }
        else if (type.equals("Square"))
        {
            return Math.pow((getDistance(xA, xB, yA, yB)), 2);
        }
        else
        {
            return 0;
        }
    }
    
    public String getType()
    {
        double sAB, sBC, sCD, sDA;
        sAB = getSlope(xA, xB, yA, yB);
        sBC = getSlope(xB, xC, yB, yC);
        sCD = getSlope(xC, xD, yC, yD);
        sDA = getSlope(xD, xC, yD, yC);
        double dAB, dBC, dCD, dDA;
        dAB = getDistance(xA, xB, yA, yB);
        dBC = getDistance(xB, xC, yB, yC);
        dCD = getDistance(xC, xD, yC, yD);
        dDA = getDistance(xD, xC, yD, yC);
        
        if (sAB == sCD)//If 1 Pair parrallel
        {
            if (sBC == sDA)//If Both Pairs parrallel
            {
                if (dAB == dCD)//If 1 pair of congruent lines
                {
                    if (dBC == dDA)//If 2 pairs of congruent lines 
                    {
                        if ((sAB * sBC) == -1)//if AB is perependicular to BC
                        {
                            type = "Square";
                            return "Square";
                        }
                        else
                        {
                            type = "Rhombus";
                            return "Rhombus";
                        }
                    }
                    else
                    {
                        if ((sAB * sBC) == -1)//if AB is perependicular to BC
                        {
                            type = "Rectangle";
                            return "Rectangle";
                        }
                        else
                        {
                            type = "Parallelagram";
                            return "Parallelagram";
                        }
                        
                    }
                }
                else
                {
                    return "Quadrilateral is a Triangle";
                }
            }
            else
            {
                type = "Trapezoid";
                return "Trapezoid";
            }
        }
        else if (sBC == sDA)//If 1 Pair parrallel
        {
            if (sAB == sCD)//If Both Pairs parrallel
            {
                if (dAB == dCD)//If 1 pair of congruent lines
                {
                    if (dBC == dDA)//If 2 pairs of congruent lines 
                    {
                        if ((sAB * sBC) == -1)//if AB is perependicular to BC
                        {
                            type = "Square";
                            return "Square";
                        }
                        else
                        {
                            type = "Rhombus";
                            return "Rhombus";
                        }
                    }
                    else
                    {
                        if ((sAB * sBC) == -1)//if AB is perependicular to BC
                        {
                            type = "Rectangle";
                            return "Rectangle";
                        }
                        type = "Parallelagram";
                        return "Parallelagram";
                    }
                }
                else
                {
                    
                }
            }
            else
            {
                type = "Trapezoid";
                return "Trapezoid";
            }
        }
        else
        {
            type = "Quadrilateral";
            return "Quadrilateral";
        }
        return null;
        
   } 
    private String type;
    private double xA, xB, xC, xD, yA, yB, yC, yD;
    private int dummy;
}