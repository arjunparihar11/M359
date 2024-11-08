/*
 * Author: Arjun Parihar
 * Grade: C
 * Attempted: Switch Pieces/Valid Move
 * Credit: Andy
 */
package add.buttons.runtime;
import com.sun.prism.paint.Color;
import java.awt.Transparency;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

/**
 *
 * @author rcortez
 */
public class GUIcontroller implements Initializable 
{
    Button[][] btn = new Button[8][8];
    Integer[][] nums = new Integer[8][8];
    //GridPane gPane = new GridPane();
    @FXML
    private Label lblP1Score, lblP2Score, lblPturn, lblW, lblB;
    @FXML
    private AnchorPane aPane;
    @FXML
    private GridPane gPane;
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        
        for(int i=0; i<btn.length; i++)
        {
                for(int j=0; j<btn.length;j++)
                {     
                 //Initializing 2D buttons with values i,j
                 btn[i][j] = new Button();
                 btn[i][j].setPrefSize(50, 50);
                 //Paramters:  object, columns, rows
                 gPane.add(btn[i][j], j, i); 
                }
        }
        lblPturn.setOpacity(1);
        lblP1Score.setOpacity(1);
        lblP2Score.setOpacity(1);
        lblW.setOpacity(1);
        lblB.setOpacity(1);
        nums[3][3] = 1; btn[3][3].setText("W");
        nums[3][4] = 2; btn[3][4].setText("B");
        nums[4][4] = 1; btn[4][4].setText("W");
        nums[4][3] = 2; btn[4][3].setText("B");
        
        gPane.setGridLinesVisible(true);
        gPane.setVisible(true);
        
        EventHandler z;
        z = new EventHandler<ActionEvent>() 
{
@Override
public void handle(ActionEvent t) 
{   
   int row = GridPane.getRowIndex(((Button) t.getSource()));
   int collumn = GridPane.getColumnIndex(((Button) t.getSource()));
   System.out.println("Start");
   if (ValidMove(row, collumn))
   {
       if(pturn == 1)
       {
       btn[row][collumn].setText("W");
       nums[row][collumn] = 1;
       }
       else
       {
       btn[row][collumn].setText("B");
       nums[row][collumn] = 2;
       }
   }
   else
   {
       System.out.println("Invalid Move");
   }
       
   if(pturn == 1)
   {
       pturn = 2;
       lblPturn.setText("Black's Turn");
   }
   else
   {
       pturn = 1;
       lblPturn.setText("White's Turn");
   }
   
   for(int r = 0; r < 9; r++)
   {
       for(int c = 0; c < 9; c++)
       {
           if(nums[r][c] == 1)
           {
               p1Score++;
           }
           else if(nums[r][c] != 2)
           {
               p1Score+=0;
           }
           else
           {
               p2Score++;
           }
       }
   }
   lblP1Score.setText(Integer.toString(p1Score));
   lblP2Score.setText(Integer.toString(p1Score));
   System.out.println("End");
}
};
        for(int i=0; i<btn.length; i++)
        {
                for(int j=0; j<btn.length;j++)
                {
                    btn[i][j].setOnAction(z);
    
                }
        }
    }
    
    public boolean ValidMove(int r, int c)
    {
        return true;
//        if(nums[r][c] == null)
//        {
//            if(r == 8 || c == 8 || r == 0 || c == 0)
//            {
//                if(r == 8)
//                {
//                    if(nums[r+1][c] == pturn || nums[r][c+1] == pturn || nums[r+1][c+1] == pturn || nums[r-1][c] == pturn || nums[r][c-1] == pturn || nums[r-1][c-1] == pturn)
//                {
//                    return false;
//                }
//                else
//                {
//                    for(int i = 1; i < 8; i++)
//                    {
//                        int x = 0;
//                        x++;
//                        if(!(nums[r][c+1+i] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else
//                        {
//                            return false;
//                        }
//                    }
//                }
//                }
//                else if(c == 8)
//                {
//                    if(nums[r+1][c] == pturn || nums[r][c+1] == pturn || nums[r+1][c+1] == pturn || nums[r-1][c] == pturn || nums[r][c-1] == pturn || nums[r-1][c-1] == pturn)
//                {
//                    return false;
//                }
//                else
//                {
//                    for(int i = 1; i < 8; i++)
//                    {
//                        int x = 0;
//                        x++;
//                        if(!(nums[r+1+i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else
//                        {
//                            return false;
//                        }
//                    }
//                }
//                }
//                else if(r == 0)
//                {
//                    if(nums[r+1][c] == pturn || nums[r][c+1] == pturn || nums[r+1][c+1] == pturn || nums[r-1][c] == pturn || nums[r][c-1] == pturn || nums[r-1][c-1] == pturn)
//                {
//                    return false;
//                }
//                else
//                {
//                    for(int i = 1; i < 8; i++)
//                    {
//                        int x = 0;
//                        x++;
//                        if(!(nums[r+1+i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else if(!(nums[r][c+1+i] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else
//                        {
//                            return false;
//                        }
//                    }
//                }
//                }
//                else
//                {
//                    if(nums[r+1][c] == pturn || nums[r][c+1] == pturn || nums[r+1][c+1] == pturn || nums[r-1][c] == pturn || nums[r][c-1] == pturn || nums[r-1][c-1] == pturn)
//                {
//                    return false;
//                }
//                else
//                {
//                    for(int i = 1; i < 8; i++)
//                    {
//                        int x = 0;
//                        x++;
//                        if(!(nums[r+1+i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else if(!(nums[r][c+1+i] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else
//                        {
//                            return false;
//                        }
//                    }
//                }
//                }
//            }
//            else
//            {
//                if(nums[r+1][c] == pturn || nums[r][c+1] == pturn || nums[r+1][c+1] == pturn || nums[r-1][c] == pturn || nums[r][c-1] == pturn || nums[r-1][c-1] == pturn)
//                {
//                    return false;
//                }
//                else
//                {
//                    for(int i = 1; i < 8; i++)
//                    {
//                        int x = 0;
//                        x++;
//                        if(!(nums[r+1+i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else if(!(nums[r][c+1+i] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, true);
//                            return true;
//                        }
//                        else if(!(nums[r-1-i][c] == pturn))
//                        {
//                            ChangePieces(x, r, c, false);
//                            return true;
//                        }
//                        else
//                        {
//                            return false;
//                        }
//                    }
//                }
//            }
//            
//        }
//        else
//        {
//            return false;
//        }
    }
    
    public void ChangePieces(int x, int r, int c, boolean y)
    {
        if(y)
        {
            for(int i = r; i<x; i++)
            {
                if(pturn == 1)
                {
                    nums[r+i][c] = 1;
                }
                else
                {
                    nums[r+i][c] = 2;
                }
            }
        }
        else
        {
            for(int i = c; i<x; i++)
            {
                if(pturn == 1)
                {
                    nums[r][c+i] = 1;
                }
                else
                {
                    nums[r][c+i] = 2;
                }
            }
        }
        
    }
    
    private int pturn = 0, p1Score = 0, p2Score = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
}