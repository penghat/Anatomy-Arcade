import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardLayoutQuestion
{
    ScreenHolder mainPane;

    public CardLayoutQuestion()
    {
        mainPane = new ScreenHolder(new CardLayout());
        mainPane.setOpaque(true);
    }
    public static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Card Layout Question");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayoutQuestion cardLayoutQuestion = new CardLayoutQuestion();
        frame.setContentPane(cardLayoutQuestion.mainPane);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            } );
    }
}

class ScreenHolder extends JPanel
{
    final static String MAIN_MENU = "Main Menu";
    final static String GAME_SCREEN = "Game";
    private final CardLayout cardLayout;

    public ScreenHolder(final CardLayout _cardLayout)
    {
	super(_cardLayout);
	cardLayout = _cardLayout;
        add(new MainMenu(this, GAME_SCREEN), MAIN_MENU);
        add(new GameScreen(this, MAIN_MENU), GAME_SCREEN);
    }

    public void switchToMainMenu ()
    {
	cardLayout.show(this, MAIN_MENU);
    }
    
    public void switchToGameScreen()
    {
	cardLayout.show(this, GAME_SCREEN);
    }
}

class MainMenu extends JPanel
{
    final JButton gameScreenButton;
    public MainMenu(final ScreenHolder mainPane, final String GAME_SCREEN)
    {
        gameScreenButton = new JButton(GAME_SCREEN);
        gameScreenButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
		    mainPane.switchToGameScreen();
                }
            } );
        add(gameScreenButton);
    }
}

class GameScreen extends JPanel
{
    final JButton mainMenuButton;
    public GameScreen(final ScreenHolder mainPane, final String MAIN_MENU)
    {
        mainMenuButton = new JButton(MAIN_MENU);
        mainMenuButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
		    mainPane.switchToMainMenu();
                }
            } );
        add(mainMenuButton);
    }
}
