/*Author:Arjun Parihar
 * Grade: A-
 * Attempted:Hard mode will go randomly at times when it should compare 
 * Credit: Mr.Cortez
 */
package rock.paper.scissors.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 *
 * @author Arjun
 */
public class GUIcontroller implements Initializable 
{
    CPUclass CPU = new CPUclass();
    @FXML
    private Label label;
    @FXML
    private ImageView imgHuman, imgCPU;
    
    @FXML
    private void handleDifficulty()
    {
        int ent = 0;
        while(!(ent == 1 || ent == 2))
        {
            ent = Integer.parseInt(JOptionPane.showInputDialog("Type 1 For Easy, and Type 2 For Hard"));
        }
        CPU.setDifficulty(ent);
    }
    @FXML
    private void handleRock() 
    {
        System.out.println("");
        CPU.CPUmove(1);
        imgHuman.setImage(new Image ("resources/Rock.jpg"));
        if (CPU.GetCmove() == 1)
            imgCPU.setImage(new Image ("resources/Rock.jpg"));
        else if (CPU.GetCmove() == 2)
            imgCPU.setImage(new Image ("resources/Paper.jpg"));
        else
            imgCPU.setImage(new Image ("resources/Scissors.jpg"));
        System.out.println(CPU.FindWinner());
        System.out.println(CPU.GetStats());
    }
    @FXML
    private void handlePaper() 
    {
        System.out.println("");
        CPU.CPUmove(2);
        imgHuman.setImage(new Image ("resources/Paper.jpg"));
        if (CPU.GetCmove() == 1)
            imgCPU.setImage(new Image ("resources/Rock.jpg"));
        else if (CPU.GetCmove() == 2)
            imgCPU.setImage(new Image ("resources/Paper.jpg"));
        else
            imgCPU.setImage(new Image ("resources/Scissors.jpg"));
        System.out.println(CPU.FindWinner());
        System.out.println(CPU.GetStats());
    }
    @FXML
    private void handleScissors() 
    {
        System.out.println("");
        CPU.CPUmove(3);
        imgHuman.setImage(new Image ("resources/Scissors.jpg"));
        if (CPU.GetCmove() == 1)
            imgCPU.setImage(new Image ("resources/Rock.jpg"));
        else if (CPU.GetCmove() == 2)
            imgCPU.setImage(new Image ("resources/Paper.jpg"));
        else
            imgCPU.setImage(new Image ("resources/Scissors.jpg"));
        
        System.out.println(CPU.FindWinner());
        System.out.println(CPU.GetStats());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
}
