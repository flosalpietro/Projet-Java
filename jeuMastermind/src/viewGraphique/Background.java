package viewGraphique;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Classe permettant de cr�er un Background de type JLabel.
 * 
 */

public class Background extends JLabel{
	/**
	 * Constructeur du background.
	 */
	public Background(){
		this.setIcon(new ImageIcon(getClass().getResource("/background.png")));
		this.setBounds(0, 0, Param.FRAMEWIDTH, Param.FRAMEHEIGHT);
	}
}