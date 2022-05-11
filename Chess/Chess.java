import javax.swing.UIManager;

public class Chess {
    public static void main(String[] args) {
        // to make the gui look better
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChessGame game = new ChessGame();
    }
}
