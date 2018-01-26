package wellcem;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// устанавливаем LookAndFeel
			// UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			// UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			System.err
					.println("Can't use the specified look and feel on this platform.");
		} catch (Exception e) {
			System.err
					.println("Couldn't get specified look and feel, for some reason.");
		}

	}

}
