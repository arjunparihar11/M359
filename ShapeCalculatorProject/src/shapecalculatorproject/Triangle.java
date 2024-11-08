/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapecalculatorproject;

/**
 *
 * @author parihar1205
 */
public class Triangle 
{
    public Triangle(String a, String b, String c)//takes out x1,x2,y1,y2 from (x1,y1)/(x2,y2)
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
    }
    
    public double getSlope(double x1, double x2, double y1, double y2)//calculates slope
    {
        return (y2 - y1)/(x2 - x1);
    }
    public double getDistance(double x1, double x2, double y1, double y2)//calculates distance
    {
        return Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
    }
//    public double getArea()//calculates area
//    {
//        
//    }
    
    public String getAngleType()
    {
        double dAB, dBC, dCA;
        dAB = getDistance(xA, xB, yA, yB);
        dBC = getDistance(xB, xC, yB, yC);
        dCA = getDistance(xC, xA, yC, yA);
        
        if ((Math.pow(dCA, 2)) + (Math.pow(dBC, 2)) == (Math.pow(dAB, 2)))//if a^2 + b^2 = c^2 right triangle
        {
            AngleType = "Right Triangle";
            return "Right Triangle";
        }
        else if ((Math.pow(dCA, 2)) + (Math.pow(dBC, 2)) > (Math.pow(dAB, 2)))//if a^2 + b^2 > c^2 acute triangle
        {
            AngleType = "Acute Triangle";
            return "Acute Triangle";
        }
        else if ((Math.pow(dCA, 2)) + (Math.pow(dBC, 2)) < (Math.pow(dAB, 2)))//if a^2 + b^2 < c^2 obtuse triangle
        {
            AngleType = "Obtuse Triangle";
            return "Obtuse Triangle";
        }
        else
        {
            return null;
        }
            
    }
    public String getSideType()
    {
        double dAB, dBC, dCA;
        dAB = getDistance(xA, xB, yA, yB);
        dBC = getDistance(xB, xC, yB, yC);
        dCA = getDistance(xC, xA, yC, yA);
        
        if (dAB == dBC)//If  2 sides congruent
        {
            if (dAB == dCA)//if All sides congruent
            {
                SideType = "Equilateral Triangle";
                AngleType = "Equiangular Triangle";
                return "Equilateral Triangle \n Equiangular Triangle";
            }
            else
            {
                SideType = "Isosceles Triangle";
                return "Isosceles Triangle";
            }
        }
        else if (dAB == dCA)//If  2 sides congruent
        {
            if (dAB == dBC)//If all sides congruent
            {
                SideType = "Equilateral Triangle";
                AngleType = "Equiangular Triangle";
                return "Equilateral Triangle \n Equiangular Triangle";
            }
            else
            {
                SideType = "Isosceles Triangle";
                return "Isosceles Triangle";
            }
                
        }
        else if (dBC == dCA)//If  2 sides congruent
        {
            if (dBC == dAB)
            {
                SideType = "Equilateral Triangle";
                AngleType = "Equiangular Triangle";
                return "Equilateral Triangle \n Equiangular Triangle";
            }
            else
            {
                SideType = "Isosceles Triangle";
                return "Isosceles Triangle";
            }
        }
        else//If  no sides congruent
        {
            SideType = "Scaline Triangle";
            return "Scaline Triangle";
        }
    }
    
    private double xA, xB, xC, yA, yB, yC;//Cordinates
    private String AngleType;
    private String SideType;
}
