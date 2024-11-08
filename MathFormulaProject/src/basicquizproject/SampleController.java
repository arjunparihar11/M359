/*Author: Arjun Parihar
 * Grade: A-
 * Attemped: Completed
 */
package basicquizproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 *
 * @author Arjun
 */
public class SampleController implements Initializable 
{
    
    @FXML
    private Label label;
    
    @FXML
    private void AreaOfQuad() 
    {
        DoArea();
        System.out.println("The Area Of Your Quadrilateral Is: " + AreaAns);
    }
    
    private void DoArea()
    {
        double length;
        double width;
        String input = JOptionPane.showInputDialog("What is the length?");
        length = Double.parseDouble(input);
        String input2 =JOptionPane.showInputDialog("What is the width?");
        width = Double.parseDouble(input2);
        AreaAns = (length * width);
        AreaAns *= 100;
        AreaAns = Math.round(AreaAns);
        AreaAns /= 100;
    }
    
    @FXML
    private void VolumeOfSphere()
    {
        DoVolume();
        System.out.println("The Volume Of Your Sphere Is: " + VolumeAns);
    }
    
    private void DoVolume()
    {
        double radius;
        String input = JOptionPane.showInputDialog("What is the radius?");
        radius = Double.parseDouble(input);
        VolumeAns = ((4/3) * Math.PI * (Math.pow(radius, 3)));
        VolumeAns *= 100;
        VolumeAns = Math.round(VolumeAns);
        VolumeAns /= 100;
    }
    
    @FXML
    private void Sin()
    {
        DoSin();
        System.out.println(SinAns);
    }
    
    private void DoSin()
    {
        double x;
        String input = JOptionPane.showInputDialog("SIN Of ___");
        x = Double.parseDouble(input);
        SinAns = Math.sin(x);
        SinAns *= 100;
        SinAns = Math.round(SinAns);
        SinAns /= 100;
    }
    
    @FXML
    private void Cos()
    {
        DoCos();
        System.out.println(CosAns);
    }
    
    private void DoCos()
    {
        double y;
        String input = JOptionPane.showInputDialog("COS Of ___");
        y = Double.parseDouble(input);
        CosAns = Math.cos(y);
        CosAns *= 100;
        CosAns = Math.round(CosAns);
        CosAns /= 100;
    }
    
    @FXML
    private void Tan()
    {
        DoTan();
        System.out.println(TanAns);
    }
    
    private void DoTan()
    {
        double z;
        String input = JOptionPane.showInputDialog("TAN Of ___");
        z = Double.parseDouble(input);
        TanAns = Math.cos(z);
        TanAns *= 100;
        TanAns = Math.round(TanAns);
        TanAns /= 100;
    }
    
    @FXML
    private void PkmnFormula()
    {
        DoPkmnFormula();
        System.out.println("The Damage Your Pokemon's Move Would Do  To Your Target Is Without A Crit: " + PkmnAns);
        System.out.println("The Damage Your Pokemon's Move Would Do  To Your Target Is With A Crit: " + PkmnCritAns);
    }
    
    private void DoPkmnFormula()
    {
        double level;
        double attack;
        double move;
        double defense;
        double multiple;
        double stab;
        String effective;
        String input1 = JOptionPane.showInputDialog("What Level Is The Attacking Pokemon?");
        level = Double.parseDouble(input1);
        String input2 = JOptionPane.showInputDialog("What Is The Attack Stat Of The Attacking Pokemon?");
        attack = Double.parseDouble(input2);
        String input5 = JOptionPane.showInputDialog("What Is The Base Attack Of The Attacking Pokemon's Move?");
        move = Double.parseDouble(input5);
        String input3 = JOptionPane.showInputDialog("What Is The Defense Stat Of The Pokemon Being Attacked?");
        defense = Double.parseDouble(input3);
        String input4 = JOptionPane.showInputDialog("Is The Attacking Move The Same Type As The Attacking Pokemon? Type \"Yes\" or \"No\"");
        if (input4.equalsIgnoreCase("Yes"))
        {
            stab = 1.5;
        }
        else if (input4.equalsIgnoreCase("No"))
        {
            stab = 1;
        }
        effective = JOptionPane.showInputDialog("Type \"Super\" If The Move Is Super Effective, Type \"Not\" If It Is Not Very Effective, And Write \"Normal\" If It Is Neither");
        if (effective.equalsIgnoreCase("Super"))
        {
            multiple = 2;
        }
        else if (effective.equalsIgnoreCase("Not"))
        {
            multiple = 0.5;
        }
        else if (effective.equalsIgnoreCase("Normal"))
        {
            multiple = 1;
        }
        PkmnAns = ((((((level * 0.4 * 1)+ 2)*attack * move / 50 / defense))+2) );
        PkmnAns *= 100;
        PkmnAns = Math.round(PkmnAns);
        PkmnAns /= 100;
        PkmnCritAns = ((((((level * 0.4 * 2)+ 2)*attack * move / 50 / defense))+2) );
        PkmnCritAns *= 100;
        PkmnCritAns = Math.round(PkmnCritAns);
        PkmnCritAns /= 100;
    }
    private double AreaAns;
    private double VolumeAns;
    private double SinAns;
    private double CosAns;
    private double TanAns;
    private double PkmnAns;
    private double PkmnCritAns;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
}
