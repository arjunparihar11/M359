/*Author: Arjun Parihar
 * Grade: B+/A-
 * Notes: Assemble Word doesn't work properley, but is attempted (Doesn't Crash Program). Top Ten not Finished. Not able to use
 * letter twice works unless the guess button is spammed. 
 */
package evil.hangman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

public class GUIcontroller implements Initializable 
{
    gamePlay game = new gamePlay();
    List<String> picts = new ArrayList<>();
    
    private int numPic=0;
    @FXML
    private Label lblWord,lblWL;
    @FXML
    private ImageView imgHang;
    @FXML
    private Button btnGuess, btnStart;
    @FXML
    private ListView topList;
   
    public GUIcontroller()
    {
        FileReader r = null;
        try
        {
            r = new FileReader("src/resources/Scores.txt");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(GUIcontroller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No Text File Found");
        }
        Scanner f = new Scanner(r);
        while(f.hasNextLine())
        {
            data.add(f.nextLine());
        }
        for(int i = 0; i < data.size(); i ++)
        {
            int x = data.get(i).indexOf(" ");
            names.add(data.get(i).substring(0, x));
            scores.add(Integer.parseInt(data.get(i).substring(x+1)));
        }
        try 
        {
            r.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(GUIcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void handleStart(ActionEvent event) 
    {
        picts.clear();
        numPic =0;
        picts.add("resources/hangman1.png");
        picts.add("resources/hangman2.png");
        picts.add("resources/hangman3.png");
        picts.add("resources/hangman4.png");
        picts.add("resources/hangman5.png");
        picts.add("resources/hangman6.png");
        picts.add("resources/hangman7.png");
        imgHang.setImage(new Image(picts.get(numPic)));
        pname = JOptionPane.showInputDialog("What Is Your Name?");
        while(pname.length() < 0)
        {
            pname = JOptionPane.showInputDialog("What Is Your Name?");
        }
        game.Start();
        lblWord.setText(game.AssembleWord());
        
        btnGuess.setDisable(false);
        btnStart.setDisable(true);
    }
    @FXML
    private void handleGuess(ActionEvent event)
    {
        String g = JOptionPane.showInputDialog("Guess Your Letter");
        String x = game.getGuess();
        if(g.length() == 1 || x.length() == 0)
        {
            boolean repeat = false;
            for(int i=0;i<x.length();i++)
            {
                while(!repeat)
                {
                   if(x.charAt(i) == g.charAt(0))
                   {
                       g = JOptionPane.showInputDialog("Guess Your Letter");
                       repeat = true;
                       lblWL.setText("You Already Guessed " + g);
                   }
                   else
                       break;
                }
            }
            game.Guess(g);
        }
        else
        {
            lblWL.setText("Nothing Or Too Many Letters Guessed!");
        }
        
//        numPic = game.getWrongGuess();
//        imgHang.setImage(new Image(picts.get(numPic)));
        
        if(game.CheckWin())
        {
            lblWL.setText("YOU WIN!!!");
            
            btnStart.setDisable(false);
            btnGuess.setDisable(true);
        }
        else
        {
//            if(numPic ==6)
//            {
//                lblWL.setText("You Lose... The Word Was: " + game.getWord());
//                btnStart.setDisable(false);
//                btnGuess.setDisable(true);
//            }
        }
    }
    public void save()
    {
//        add = false;
//        for(int i = 0; i < scores.size(); i ++)
//        {
//            if(scores.get(i) < Integer.parseInt(s))
//            {
//                scores.add(i, S);
//                names.add(i, n);
//                add = true;
//                break;
//            }
//        }
//        if(!add)
//        {
//            scores.add(S);
//            names.add(n);
//        }
//        data.clear();
//        for(int i =0; i < scores.size(); i ++)
//        {
//            data.add(names.get(i) + " " + Integer.toString(scores.get(i)));
//        }
//        System.out.println(scores);
//        System.out.println(names);
//        System.out.println(data);
//       //write to text file
//        PrintWriter o = null;
//        try 
//        {
//            o = new PrintWriter("src/resources/Scores.txt");
//        } 
//        catch (FileNotFoundException ex)
//        {
//            Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        for(int i = 0; i < data.size(); i++)
//        {
//            o.println(data.get(i));
//        }
//        o.close();
//       ObservableList<String> x = FXCollections.observableArrayList(data); 
//       topList.setItems(x);
    }
    
    private String pname = "";
    List<String> data = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<Integer> scores = new ArrayList<>();
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
}
