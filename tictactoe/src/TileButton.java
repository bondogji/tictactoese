import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class TileButton extends JButton implements ActionListener {
    public static int count = 0;
    private int id;
    private static String player = "";
    public TileButton(int id, String text){
        super(text);
        this.id = id;
        this.addActionListener(this);
    }
    public int getID(){
        return id;
    }
    public static String getPlayer(){
        return player;
    }
    public void resetTile(){
        this.setEnabled(true);
        this.setText("");
    }
    public void disableTile(){
        this.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9)
        {
            player = Game.playerX.getName();
        }
        else if (count == 2 || count == 4 || count == 6 || count == 8 || count == 10)
        {
            player = Game.playerO.getName();
        }
        setText(player);
        setEnabled(false);
        Board.CheckForWin();
    }
}
