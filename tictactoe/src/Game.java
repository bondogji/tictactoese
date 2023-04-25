import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Game extends JFrame {
    private static Board board;
    private static JPanel buttonPnl;
    private static JButton quitBtn, resetBtn, scoreBtn;
    public static Player playerX;
    public static Player playerO;
    public static boolean somebodyWon = false;
    public Game(String title){
        super(title);
        initialize();
    }
    public void initialize(){
        setLayout(new BorderLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 300);
        setVisible(true);

        playerX = new Player("X");
        playerO = new Player("O");

        board = new Board();
        createButtonPanel();

        this.add(board, BorderLayout.CENTER);
        this.add(buttonPnl, BorderLayout.SOUTH);
    }

    private static void createButtonPanel()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));

        quitBtn = new JButton("Quit");
        resetBtn = new JButton("Reset");
        scoreBtn = new JButton("Score");

        buttonPnl.add(resetBtn);
        resetBtn.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Reset game?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION)
            {
                board.reset();
            }
        });

        buttonPnl.add(scoreBtn);
        scoreBtn.addActionListener((ActionEvent ae) -> {
            JOptionPane.showMessageDialog(null, "Player X's number of Wins" + " " + playerX.getWins() + " \nPlayer O's number of Wins" + " " + playerO.getWins());
        });

        buttonPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exiting Tic Tac Toe", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        });
    }
    public static  void main(String[] args){
        Game game = new Game("Tic Tac Toe");
        game.setVisible(true);
    }

}
