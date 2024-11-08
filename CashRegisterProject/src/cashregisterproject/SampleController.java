/*Author: Arjun Parihar
 * Grade: A
 * Attempted: Rounding sometimes doesn't work
 */
package cashregisterproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Arjun
 */
public class SampleController implements Initializable 
{
    
    @FXML
    private Label lblTotalCost, lblChange, lbl100, lbl50, lbl20, lbl10, lbl5, lbl1, lblQ, lblD, lblN, lblP;
    @FXML
    private TextField txtAmountGiven;
    
    @FXML
    private void handleOtherPurchase() 
    {
        double OtherPrice = Double.parseDouble(JOptionPane.showInputDialog("What Is The Price? (Type Like This: _ . _ _"));
        Add2Total(OtherPrice);
    }
    @FXML
    private void handleBuyGame() 
    {
        double GamePrice = ((int)(35+(Math.random()*30)))-0.01;
        Add2Total(GamePrice);
    }
    @FXML
    private void handleBuyConsole() 
    {
        double ConsolePrice = ((int)(250+(Math.random()*350)))-0.01;
        Add2Total(ConsolePrice);
    }
    @FXML
    private void handleBuyCookie() 
    {
        double CookiePrice = ((int)(1+(Math.random()*5)))-0.01;
        System.out.println(CookiePrice);
    }
    @FXML
    private void handleCheckOut() 
    {
        Tax = 0.08 * SubTotal;
        Total = SubTotal + Tax;
        Total *= 100;Math.round(Total);Total/=100.0;
        lblTotalCost.setText("$" + Double.toString(Total));
        GetChange();
    }
    @FXML
    private void handleReset() 
    {
        SubTotal = 0.0;Total = 0.0;Tax = 0.0;
        lblTotalCost.setText("$0.00");lblChange.setText("$0.00");
        lbl100.setText("0");lbl50.setText("0");lbl20.setText("0");lbl10.setText("0");lbl5.setText("0");lbl1.setText("0");
        lblQ.setText("0");lblD.setText("0");lblN.setText("0");lblP.setText("0");
        txtAmountGiven.setText("0.00");
    }
    
    public void Add2Total(double Price)
    {
        SubTotal += Price;
        SubTotal *=100;Math.round(SubTotal);SubTotal/=100.0;
        lblTotalCost.setText("$" + Double.toString(SubTotal));
    }
    
    public void GetChange()
    {
        Given = Double.parseDouble(txtAmountGiven.getText());
        Change = Given - Total;
        if (Change > 0)
        {
        Change *= 100;Math.round(Change);Change /= 100.0;
        lblChange.setText(Double.toString(Change));
        lbl100.setText(Integer.toString((int)(Change/100)));
        Change%=100;
        lbl50.setText(Integer.toString((int)(Change/50)));
        Change%=50;
        lbl20.setText(Integer.toString((int)(Change/20)));
        Change%=20;
        lbl10.setText(Integer.toString((int)(Change/10)));
        Change%=10;
        lbl5.setText(Integer.toString((int)(Change/5)));
        Change%=5;
        lbl1.setText(Integer.toString((int)(Change/1)));
        Change%=1;
        lblQ.setText(Integer.toString((int)(Change/0.25)));
        Change%=0.25;
        lblD.setText(Integer.toString((int)(Change/0.10)));
        Change%=0.10;
        lblN.setText(Integer.toString((int)(Change/0.05)));
        Change%=0.05;
        lblP.setText(Double.toString(Change));
        }
        else
        {
            System.out.println("Not Enough Money");
        }
    }
    
    double SubTotal = 0.00;
    double Total = 0.00;
    double Tax = 0.00;
    double Change = 0.00;
    double Given = 0.00;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
}
