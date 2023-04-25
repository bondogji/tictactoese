import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel{
    private static TileButton button1 = new TileButton(1, "");
    private static TileButton button2 = new TileButton(2, "");
    private static TileButton button3 = new TileButton(3, "");
    private static TileButton button4 = new TileButton(4, "");
    private static TileButton button5 = new TileButton(5, "");
    private static TileButton button6 = new TileButton(6, "");
    private static TileButton button7 = new TileButton(7, "");
    private static TileButton button8 = new TileButton(8, "");
    private static TileButton button9 = new TileButton(9,"");
    public Board(){
        setLayout(new GridLayout(3, 3));
        //Buttons
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
    }

    public static void disableBoard(){
        button1.disableTile();
        button2.disableTile();
        button3.disableTile();
        button4.disableTile();
        button5.disableTile();
        button6.disableTile();
        button7.disableTile();
        button8.disableTile();
        button9.disableTile();
    }

    public static void reset(){
        button1.resetTile();
        button2.resetTile();
        button3.resetTile();
        button4.resetTile();
        button5.resetTile();
        button6.resetTile();
        button7.resetTile();
        button8.resetTile();
        button9.resetTile();

        Game.somebodyWon = false;
        TileButton.count = 0;
    }

    public static void CheckForWin()
    {
        if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        else if (button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        else if (button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        //looking for who wins vertically
        else if (button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        else if (button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        else if (button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        //looking for who wins diagonally
        else if (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        else if (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "")
        {
            Game.somebodyWon = true;
            Win();
        }
        else
        {
            Game.somebodyWon = false;
            Win();
        }
    }
    public static void Win()
    {
        if (Game.somebodyWon == true)
        {
            disableBoard();
            JOptionPane.showMessageDialog(null, "Player " + TileButton.getPlayer() + " Won!");
            if(TileButton.getPlayer().equalsIgnoreCase("X"))
            {
                Game.playerX.incWins();
            }
            else
            {
                Game.playerO.incWins();
            }
        }
        else if (TileButton.count == 9 && !Game.somebodyWon)
        {
            disableBoard();
            JOptionPane.showMessageDialog(null, "It's a Tie!");
        }
    }

}
