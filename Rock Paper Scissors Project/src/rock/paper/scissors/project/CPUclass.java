/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rock.paper.scissors.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arjun
 */
public class CPUclass 
{
    List<Integer> Moves = new ArrayList<Integer>();
    List<Integer> Last5 = new ArrayList<Integer>();
    public void setDifficulty(int d)
    {
        if(d == 1)
        {
            easy = true;
            hard = false;
        }
        else if (d == 2)
        {
            hard = true;
            easy = false;
        }
        else
        {
            easy = true;
            hard = false;
        }
    }
    public void CPUmove(int Pmove)
    {
        pmove = Pmove;
        Moves.add(pmove);
        Last5.add(pmove);
        if (Last5.size() == 6)
        {
            Last5.remove(0);
        }
        
        if (hard)
        {
            if (Moves.size() > 5)
            {
                cmove = Compare();
            }
            else
            {
                cmove = Random();
            }
        }
        else
        {
            cmove = Random();
        }
    }
    public int Compare()
    {
        int x = 0;
        int i;
        for(i = 0; i < ((Moves.size()) - 5); i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(Moves.get(i+j) == Last5.get(j))
                {
                    x++;
                }
                else
                {
                    x = 0;
                }
            }
        }
        i = Moves.get(i + 1);
        if(x >= 5)
        {  
            System.out.println("Smart");
            if(i == (Moves.size() - 1))
            {
                return Random();
            }
            else
            {
                if(i == 1)
                    return 2;
                else if (i == 2)
                    return 3;
                else
                    return 1;
            }
        }
        else
        {
            System.out.println("Random");
            return Random();
        }
    }
    public int Random()
    {
        return (int)(1+((Math.random())*3));
    }
    public String FindWinner()
    { 
        if(pmove == 1 && cmove == 2)
        {
            losses++;
            return "You Lose";
        }
        else if(pmove == 1 && cmove == 3)
        {
            wins++;
            return "You Win";
        }
        else if(pmove == 2 && cmove == 1)
        {
            wins++;
            return "You Win";
        }
        else if(pmove == 2 && cmove == 3)
        {
            losses++;
            return "You Lose";
        }
        else if(pmove == 3 && cmove == 1)
        {
            losses++;
            return "You Lose";
        }
        else if(pmove == 3 && cmove == 2)
        {
            wins++;
            return "You Win";
        }
        else
        {
            ties++;
            return "Tie";
        }
    }
    public int GetCmove()
    {
        return cmove;
    }
    public String GetStats()
    {
        return "Wins: " + wins + ", Losses: " + losses + ", Ties: " + ties + ".";
    }
    int pmove = 0, cmove = 0, wins = 0, ties = 0, losses = 0;
    boolean easy, hard;
}
