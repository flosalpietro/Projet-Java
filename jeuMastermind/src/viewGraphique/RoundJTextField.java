package viewGraphique;

import java.awt.Graphics;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RoundJTextField extends JTextField {
	/**
	 * Dessine l'arrondi des bords.
	 */
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
}