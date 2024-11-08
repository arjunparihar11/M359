/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
 * @author parihar1205
 */
public class SampleController implements Initializable {
    
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lblNumCorrect;
    @FXML
    private Label lblNumIncorrect;
    
    @FXML
    private void handleButtonAction() 
    {
        int correct=0;
        int incorrect=0;
        String input;
        int answer;
        double answer2;
        
        input = JOptionPane.showInputDialog("Question #1\n\nWhat is 8(3+5)?");
        answer = Integer.parseInt(input);
        if (answer==64)
        {
            System.out.println("Correct!!!");
            correct++;
        }
        else
        {
            System.out.println("Incorrect!!!");
            incorrect++;
        }
        
        input = JOptionPane.showInputDialog("Question #2\n\nWhat state is Oakland yet?");
        if (input.equalsIgnoreCase("california"))
        {
            System.out.println("Correct!!!");
            correct++;
        }
        else
        {
            System.out.println("Incorrect!!!");
            incorrect++;
        }
        
        input = JOptionPane.showInputDialog("Question #3\n\nHow many sides does an octagon have?");
        answer = Integer.parseInt(input);
        if (answer==8)
        {
            System.out.println("Correct!!!");
            correct++;
        }
        else
        {
            System.out.println("Incorrect!!!");
            incorrect++;
        }
        
        input = JOptionPane.showInputDialog("Question #4\n\nWhat country is directly north of the USA?");
        if (input.equalsIgnoreCase("canada"))
        {
            System.out.println("Correct!!!");
            correct++;
        }
        else
        {
            System.out.println("Incorrect!!!");
            incorrect++;
        }
        
        input = JOptionPane.showInputDialog("Question #3\n\nWhat are the first 5 digits of pi?");
        answer2 = Double.parseDouble(input);
        if (answer==3.1415)
        {
            System.out.println("Correct!!!");
            correct++;
        }
        else
        {
            System.out.println("Incorrect!!!");
            incorrect++;
        }
        lblNumCorrect.setText(Integer.toString(correct));
        lblNumIncorrect.setText(Integer.toString(incorrect));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
