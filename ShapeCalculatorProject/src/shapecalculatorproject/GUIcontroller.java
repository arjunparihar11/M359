/* Author: Arjun Parihar
 * Grade: B
 * Attempted: Area doesn't work
 */
package shapecalculatorproject;

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
public class GUIcontroller implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleQuad() 
    {
        String a = JOptionPane.showInputDialog("Type The Cordinates Of Point a, (x,y)");
        String b = JOptionPane.showInputDialog("Type The Cordinates Of Point b, (x,y)");
        String c = JOptionPane.showInputDialog("Type The Cordinates Of Point c, (x,y)");
        String d = JOptionPane.showInputDialog("Type The Cordinates Of Point d, (x,y)");
        QuadOutput(a, b, c, d);
    }
    @FXML
    private void handleTriangle()
    {
        String a = JOptionPane.showInputDialog("Type The Cordinates Of Point a, (x,y)");
        String b = JOptionPane.showInputDialog("Type The Cordinates Of Point b, (x,y)");
        String c = JOptionPane.showInputDialog("Type The Cordinates Of Point c, (x,y)");
        TriOutput(a, b, c);
    }
    
    public void QuadOutput(String a, String b, String c, String d)
    {
        Quad q = new Quad(a, b, c, d);
        System.out.println(q.getType());
        System.out.println(q.getArea());
    }
    public void TriOutput(String a, String b, String c)
    {
        Triangle t = new Triangle(a, b, c);
        System.out.println(t.getSideType());
        System.out.println(t.getAngleType());
//        System.out.println(t.getArea());
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
