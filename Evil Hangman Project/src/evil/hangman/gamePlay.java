/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evil.hangman;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rcortez
 */
public class gamePlay 
{
    Dictionary Dict = new Dictionary();
    ArrayList<String> PossibleWords = new ArrayList<>();
    ArrayList<String> PrevPossibleWords = new ArrayList<>();
    public gamePlay()
    {
        
    }
    public void Start()
    {
        word = null;
        guess = "";
        WrongGuess = 0;
        FoundWord = false;
        length = (int)(((Math.random())*14)+2);
        System.out.println("Length: " + length); //sout #'s 2-15
    }
    public void Guess(String g)
    {
        PrevPossibleWords = Dict.getArrayNoMatch(guess, length);
        guess += g;
        System.out.println("Guessed: " + guess);
        PossibleWords = Dict.getArrayNoMatch(guess, length);
        if(!FoundWord)
        {
            SetWord();
            System.out.println("Possible Words: ");
            System.out.println(PossibleWords);
        }
        else
        {
            System.out.println("Word: " + word);
        }
        AssembleWord();
    }
    public boolean CheckWin()
    {
        boolean w = false;
        String x = AssembledWord;
        for(int i=0; i<x.length();i++)
        {
            if(x.substring(i, (i+1)) == "_")
            {
                w = true;
                break;
            }
            else
            {
                w = false;
            }
        }
        if(w)
            return true;
        else
            return false;
            
    }
    public int WrongGuesses()
    {
        return WrongGuess;
    }
    public String AssembleWord()
    {
        String x = "";
        if(!FoundWord)
        {
            x = "";
            for(int i = 0; i < length; i ++)
            {
                x += " _ ";
            }
        }
        else //(FoundWord)
        {
            x = "";
            boolean match = false;
            String y = "";
            for(int g=0; g<guess.length(); g++)
            {
                for(int w=0; w<word.length(); w++)
                {
                    if(word.charAt(w) == guess.charAt(g))
                    {
                        match = true;
                        y+=w;
                    }
                        
                }
            }
            if(match)
            {
                for(int i=0; i<word.length();i++)
                {
                    if(i == Integer.parseInt(y.substring(i, (i+1))))
                    {
                        x+= word.charAt(i);
                    }
                    else
                    {
                        x+= " _ ";
                    }
                }
            }
        }
        AssembledWord = x;
        CheckWin();
        return x;
    }
    public void SetWord()
    {
        if(PossibleWords.size() == 1)
        {
            word = PossibleWords.get(0);
            FoundWord = true;
            System.out.println("Word: " + word);
        }
        else if (PossibleWords.isEmpty())
        {
            int x = (int)((Math.random()*PrevPossibleWords.size()));
//            System.out.println("Random # For PrevPW: " + x);
            word = PrevPossibleWords.get(x);
            guess = guess.substring(0, guess.length()-2);
            FoundWord = true;
            System.out.println("Word: " + word);
        }
        else
        {
            word = null;
            FoundWord = false;
            WrongGuess ++;
        }
    }
    public String getGuess()
    {
        return guess;
    }
    public String getWord()
    {
        if(!FoundWord)
        {
            int x = (int)((Math.random()*PrevPossibleWords.size()));
            word = PrevPossibleWords.get(x);
        }
        return word;
    }
    public int getWrongGuess()
    {
        return WrongGuess;
    }
    private int length = 0, WrongGuess = 0;
    private String guess, word, AssembledWord;
    private boolean FoundWord = false;
}