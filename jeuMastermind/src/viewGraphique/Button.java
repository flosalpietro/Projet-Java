package viewGraphique;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Button extends JButton implements MouseListener{
	
	private String name;
	
	private ImageIcon btnIcon;
	
	private ImageIcon btnIconHover;
	
	
	/**
	 * Constructeur d'un bouton.
	 * @param name Nom du bouton.
	 */
	public Button(String name) {
		super(name);
		this.name=name;
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnIcon = new ImageIcon(getClass().getResource("/"+this.name+".png"));
		this.btnIconHover = new ImageIcon(getClass().getResource("/"+this.name+"Hover.png"));
		this.setIcon(btnIcon);
		this.setBorder(null);
		this.addMouseListener(this);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setForeground(new Color(0, 0, 0, 0));
		this.setOpaque(false);
		this.setFocusable(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public String getName() {
		return name;
	}
	
	/**
	 * Change l'icone du bouton quand on passe la souris dessus.
	 */
	public void mouseEntered(MouseEvent e) {
		this.setIcon(btnIconHover);
	}
	/**
	 * Change l'icone du bouton quand on quitte la zone du bouton.
	 */
	public void mouseExited(MouseEvent e) {
		this.setIcon(btnIcon);
	}
	
	public void mouseClicked(MouseEvent arg0) {
		
		
	}
	
	public void mousePressed(MouseEvent e) {
	
		
	}
	
	public void mouseReleased(MouseEvent e) {
	
		
	}
}