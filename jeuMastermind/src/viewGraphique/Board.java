package viewGraphique;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Board est la classe qui construit le plateau de jeu.
 */
@SuppressWarnings("serial")
public class Board extends JPanel implements MouseListener, ActionListener{
	/**
	 * Tableau des lignes d�j� propos�es
	 */
	private Line[] tabLine = new Line[Param.NBLINES];
	/**
	 * JPanel contenant les lignes d�j� propos�es.
	 */
	private JPanel tab = new JPanel();
	/**
	 * Ligne de proposition de couleurs contenant �galement la validation de cette ligne et le reset
	 */
	private Line propLine = new Line();
	/**
	 * Box contenant la ligne de proposition, la ligne des r�sultats et les lignes d�j� propos�es.
	 */
	private JPanel propTabBox = new JPanel();
	/**
	 * Tableau contenant les couleurs disponibles pour le jeu.
	 */
	private Button[] colors = new Button[Param.NBCOLORS];
	/**
	 * Box contenant les couleurs disponibles.
	 */
	private JPanel colorsBox = new JPanel();
	/**
	 * Tableau contenant les r�sultats des lignes propos�es.
	 */
	private Results[] results = new Results[Param.NBLINES];
	/**
	 * Box contenant les r�sultats des lignes propos�es.
	 */
	private JPanel resultsLines = new JPanel();
	/**
	 * Tableau contenant les r�ponses des lignes propos�es et les lignes propos�es.
	 */
	private JPanel resTabBox = new JPanel();
	/**
	 * Num�ro de la case que l'on va remplir dans propLine au prochain addColor.
	 */
	private int currProp = 1;
	/**
	 * Ligne du r�sultat final � d�couvrir.
	 */
	private Line resultLine = new Line();
	/**
	 * Bouton de validation de propLine.
	 */
	private JLabel ok = new JLabel();
	/**
	 * Bouton de r�initialisation des couleurs de propLine.
	 */
	private JLabel nok = new JLabel();
	/**
	 * Ligne que l'on va proposer � la prochaine validation.
	 */
	private int currLine = 0;
	/**
	 * Tableau pour savoir si la couleur dans la ligne de r�sultat � �t� v�rifi�e.
	 */
	private boolean isVerifiedResult[] = new boolean[Param.NBCASES];
	/**
	 * Tableau pour savoir si la couleur dans la ligne de proposition a �t� v�rifi�e.
	 */
	private boolean isVerifiedProp[] = new boolean[Param.NBCASES];
	/**
	 * Bool�en pour savoir si le jeu est multijoueur.
	 */
	private boolean isMulti=false;
	/**
	 * Bool�en servant � savoir si la board appartient � un serveur.
	 */
	private boolean isServer=false;
	/**
	 * Socket du serveur si le joueur choisi d'�tre un serveur.
	 */
	private ServeurSocket ss;
	/**
	 * Socket du client si le joueur choisi d'�tre un client.
	 */
	private ClientSocket cs;
	/**
	 * Bool�en servant � savoir si c'est au tour de cette board ci.
	 */
	private boolean turn = true;
	/**
	 * Mainframe pass�e en param�tre dans le constructeur pour pouvoir revenir au menu.
	 */
	private MainFrame mf;
	
	/**
	 * JPanel Multi instanci� pour pouvoir changer le message d'erreur.
	 */
	private Multi multi;
	/**
	 * JPanel Solo instanci� pour pouvoir changer le message d'erreur.
	 */
	private Solo solo;
	
	/**
	 * Constructeur sans arguments permettant de construire et d'afficher le plateau de jeu.
	 * @param mf Mainframe de base, pass�e en param�tre pour permettre de repasser au menu.
	 */
	public Board(MainFrame mf){
		this.mf = mf;
		createInterface();
	}
	/**
	 * M�thode construisant tout le plateau de jeu et tout ses JPanel.
	 */
	public void createInterface(){
		displayLines();
		displayResults();
		displayPropLine();
		displayColors();
		displayResultLine();
		for(int i=0;i<Param.NBCASES;i++)
			propLine.getCase(i).getLbl().addMouseListener(this);
		this.add(propTabBox);
		this.setBackground(new Color(0, 0, 0, 0));
	}
	/**
	 * Instancie toute les lignes de proposition.
	 */
	public void displayLines(){
		tab.setLayout(new GridLayout(Param.NBLINES,1));
		for(int i=0;i<Param.NBLINES;i++){
			tabLine[i] = new Line();
			tab.add(tabLine[i]);
		}
		tab.setBackground(new Color(0, 0, 0, 0));
	}
	/**
	 * G�n�re la ligne de r�sultats et cache la ligne.
	 */
	public void displayResultLine(){
		if(isServer || !isMulti)resultLine.createRandom();
		resultLine.hide(true);
		resultLine.setBorder(new EmptyBorder(0, 0, Param.TAILLEROND/2, 0));
		resultLine.setBackground(new Color(0, 0, 0, 0));
		
	}
	/**
	 * Instancie les r�sultats des lignes propos�es.
	 */
	public void displayResults(){
		resultsLines.setLayout(new GridLayout(Param.NBLINES, 1));
		for(int i=0;i<Param.NBLINES;i++){
			results[i] = new Results();
			resultsLines.add(results[i]);
		}
		resTabBox.add(tab);
		resTabBox.add(resultsLines);
		resTabBox.setBackground(new Color(0, 0, 0, 0));
	}
	/**
	 * Cr�� le tableau de couleurs et les rend cliquable.
	 */
	public void displayColors(){
		colorsBox.setLayout(new GridLayout(Param.NBCOLORS, 1, 20, 15));
		for(int q=0;q<Param.NBCOLORS;q++){
			colors[q] = new Button((q+1)+"");
			colors[q].addActionListener(this);
			colorsBox.add(colors[q]);
			colors[q].addMouseListener(this);
		}
		colorsBox.setBorder(new EmptyBorder(0, 30, 0, 0));
		resTabBox.add(colorsBox);
		colorsBox.setBackground(new Color(0, 0, 0, 0));
	}
	/**
	 * Cr�� la ligne de proposition avec des cases vide et les bouton cliquables pour valider et pour effacer la ligne.
	 */
	public void displayPropLine(){
		propLine.setBorder(new EmptyBorder(Param.TAILLEROND, 0, Param.TAILLEROND, 0));
		ok.setIcon(new ImageIcon(getClass().getResource("/valider.png")));
		ok.setBorder(new EmptyBorder(Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS));
		ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(currProp==Param.NBCASES+1){
					if(turn)addLine();
				}else{
					if(turn){
						if(isMulti){
							multi.getError().setText("<html><u>La ligne n'est pas remplie.</u></html>");
						}else{
							solo.getError().setText("<html><u>La ligne n'est pas remplie.</u></html>");
						}
					}
				}
			}
			public void mouseEntered(MouseEvent arg0){
				ok.setIcon(null);
				ok.setIcon(new ImageIcon(getClass().getResource("/validerHover.png")));
			}
			public void mouseExited(MouseEvent arg0){
				ok.setIcon(null);
				ok.setIcon(new ImageIcon(getClass().getResource("/valider.png")));
			}
		});
		
		nok.setIcon(new ImageIcon(getClass().getResource("/effacer.png")));
		nok.setBorder(new EmptyBorder(Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS, Param.ECARTRONDS));
		nok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(turn){
					for(int i=0;i<Param.NBCASES;i++){
						propLine.getCase(i).setColor(0);
						send("removecolor,;,"+i);
					}
					calibrateCurr();
				}
			}
			public void mouseEntered(MouseEvent arg0){
				nok.setIcon(null);
				nok.setIcon(new ImageIcon(getClass().getResource("/effacerHover.png")));
			}
			public void mouseExited(MouseEvent arg0){
				nok.setIcon(null);
				nok.setIcon(new ImageIcon(getClass().getResource("/effacer.png")));
			}
		});
		for(int i=0;i<Param.NBCASES;i++)
			propLine.getCase(i).getLbl().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		propLine.add(ok);
		propLine.add(nok);
		propTabBox.setLayout(new BoxLayout(propTabBox, BoxLayout.PAGE_AXIS));
		propTabBox.add(resultLine);
		propTabBox.add(resTabBox);
		propTabBox.add(propLine);
		propTabBox.setBackground(new Color(0, 0, 0, 0));
		resultsLines.setBackground(new Color(0, 0, 0, 0));
	}
	/**
	 * Ajoute la ligne propLine au tableau de lignes propos�es en faisant les v�rification n�cessaires.
	 */
	public void addLine(){
		if(turn){
			if(isMulti){
				multi.getError().setText("");
			}else{
				solo.getError().setText("");
			}
		}
		compare();
		
		for(int i=0;i<Param.NBCASES;i++){
			tabLine[currLine].getCase(i).setColor(propLine.getCase(i).getColor());
			propLine.getCase(i).setColor(0);
		}
		for(int i=0;i<Param.NBCASES;i++){
			isVerifiedResult[i] = false;
			isVerifiedProp[i] = false;
		}
		currProp=1;
		if(results[currLine].getScore() == Param.NBCASES){
			if(turn){
				win();
			}else{
				lose();
			}
		}
		if(isMulti){	
			if(turn)send("addline,;,1");
			passTurn();
		}
		if(currLine==Param.NBLINES-1 && (!(results[currLine].getScore() == Param.NBCASES))) {
			lose();
			}
		currLine++;
		
	}
	/**
	 * Compare la ligne de proposition et la ligne de r�sultat.
	 */
	public void compare(){
		int sameColor=0;
		int same=0;
		for(int i=0;i<Param.NBCASES;i++){
			for(int j=0;j<Param.NBCASES;j++){
				if(i==j&&propLine.getCase(i).getColor()==resultLine.getCase(i).getColor()){
					if(!isVerifiedProp[i] && !isVerifiedResult[i]){
						same++;
						isVerifiedProp[i]=true;
						isVerifiedResult[i]=true;
					}
				}
			}
		}
		for(int i=0;i<Param.NBCASES;i++){
			for(int j=0;j<Param.NBCASES;j++){
				if(propLine.getCase(i).getColor()==resultLine.getCase(j).getColor()){
					if(!isVerifiedProp[i] && !isVerifiedResult[j]){
						sameColor++;
						isVerifiedProp[i]=true;
						isVerifiedResult[j] = true;
					}
				}
			}
		}
		results[currLine].setScore(same, sameColor);
	}
	/**
	 * Affiche la ligne de r�sultat et affiche un message pour dire que le joueur a gagn�.
	 */
	public void win(){
		resultLine.hide(false);
		JOptionPane.showMessageDialog(null, "C'est gagn�!", "Succ�s", 2, new ImageIcon(getClass().getResource("/fireworks.gif")));
		if(isMulti){
			if(isServer){
				try {
					ss.close();
				} catch (IOException e) {
					System.out.println("Impossible de fermer le socket serveur.");
				}
			}else{
				try {
					cs.close();
				} catch (IOException e) {
					System.out.println("Impossible de fermer le socket client.");
				}
			}
		}
		mf.menu();
	}
	/**
	 * affiche la ligne de r�sultat et affiche un message pour dire que le joueur � perdu.
	 */
	public void lose(){
		resultLine.hide(false);
		JOptionPane.showMessageDialog(null, "Perdu.. :(");
		mf.menu();
	}
	/**
	 * Ajoute une couleur � la propLine.
	 * @param nbColor Num�ro de la couleur � ajouter.
	 */
	public void addColor(int nbColor){
			if(currProp < Param.NBCASES+1){
				propLine.getCase(currProp-1).setColor(nbColor);
				if(turn){
					send("addcolor,;,"+nbColor);
				}
				calibrateCurr();
			}
	}
	/**
	 * Envoie un objet par le socket correspondant.
	 * @param o Objet envoy�.
	 */
	public void send(Object o){
		if(isMulti){
			if(isServer){
				ss.ecrireSurTousLesClients(o);
			}else{
				cs.ecrire(o);
			}
		}
	}
	/**
	 * Calibre la case sur laquelle on va faire la proposition.
	 */
	public void calibrateCurr(){
		for(int j=0;j<Param.NBCASES;j++){
			if(propLine.getCase(j).isEmpty()){
				currProp = j+1;
				break;
			}else if(j==Param.NBCASES-1){
				currProp = Param.NBCASES+1;
			}
		}
	}
	/**
	 * Remet la couleur de la case � 0.
	 * @param nbCase Num�ro de la case � r�initialiser.
	 */
	public void removeColor(int nbCase){
		if(turn){
			send("removecolor,;,"+nbCase);
		}
		propLine.getCase(nbCase).setColor(0);
		calibrateCurr();
	}
	/**
	 * Envoie les couleurs de la ligne des r�sultats.
	 */
	public void sendResults(){
		for(int i=0;i<Param.NBCASES;i++){
			String o = "resultline,;,"+i+",;,"+resultLine.getCase(i).getColor();
			send(o);
		}
	}
	/**
	 * Modifie le socket client.
	 * @param cs Le socket client
	 */
	public void setCs(ClientSocket cs) {
		isMulti = true;
		this.isServer = false;
		this.cs = cs;
	}
	/**
	 * Modifie le socket serveur
	 * @param ss Le socket serveur.
	 */
	public void setSs(ServeurSocket ss) {
		this.ss = ss;
		isMulti = true;
		this.isServer = true;
		turn = false;
	}
	/**
	 * Impl�mente le clic sur les couleurs.
	 */
	public void actionPerformed(ActionEvent e) {
		if(turn) {
			addColor(Integer.parseInt(e.getActionCommand()));
		}
	}
	/**
	 * Impl�mentation du clic de la souris sur les couleurs.
	 * @param e event du clic de souris.
	 */
	public void mouseClicked(MouseEvent e) {
		for(int i=0;i<Param.NBCASES;i++){
			if(e.getSource()== propLine.getCase(i).getLbl()){
				if(turn)removeColor(i);
				break;
			}
		}
	}
	/**
	 * Impl�mentation de si la souris survole les couleurs.
	 * @param e event du survol de la souris.
	 */
	public void mouseEntered(MouseEvent e) {
		for(int i=0;i<Param.NBCOLORS;i++){
			if(e.getSource()==colors[i]){
				colors[i].setIcon(new ImageIcon(getClass().getResource("/"+ (i+1) + "Hover.png")));
				
			}
		}
	}
	/**
	 * Impl�mentation de si la souris quitte les couleurs.
	 * @param e event du d�part de la souris.
	 */
	public void mouseExited(MouseEvent e) {
		for(int i=0;i<Param.NBCOLORS;i++){
			if(e.getSource()==colors[i]){
				colors[i].setIcon(new ImageIcon(getClass().getResource("/"+ (i+1) + ".png")));
				
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	/**
	 * M�thode permettant de traiter les objets re�us � travers le socket.
	 * @param o objet re�u
	 */
	public void processReceivedObject(Object o){
		String[] str = o.toString().split(",;,");;
		if(str[0].equals("addcolor")){
			addColor(Integer.parseInt(str[1]));
		}else if(str[0].equals("removecolor")){
			removeColor(Integer.parseInt(str[1]));
		}else if(str[0].equals("addline")){
			addLine();
		}else if(str[0].equals("resultline")&&(!isServer)){
			resultLine.getCase(Integer.parseInt(str[1])).setColor(Integer.parseInt(str[2]));
			resultLine.hide(true);
		}else if(str[0].equals("passturn")){
			JOptionPane.showMessageDialog(null, "L'adversaire a pass� son tour.");
			passTurn();
		}else if(str[0].equals("deconnecte")){
			if(isServer){
				try {
					ss.close();
					JOptionPane.showMessageDialog(null, "Le client a �t� d�connect�");
					mf.menu();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					cs.close();
					JOptionPane.showMessageDialog(null, "Le serveur a �t� d�connect�");
					mf.menu();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else if(str[0].equals("case")){
			Param.NBCASES = Integer.parseInt(str[1]);
			Param.NBCOLORS = Integer.parseInt(str[2]);
			this.resetBoard();
		}
	}
	/**
	 * Passe le tour.
	 */
	public void passTurn() {
		if(turn){
			turn=false;
			multi.setTurnLbl(Param.TXTTURNN);
		}else{
			turn=true;
			multi.setTurnLbl(Param.TXTTURNY);
		}
	}
	/**
	 * Reconstruit tout le plateau.
	 */
	private void resetBoard() {
		this.removeAll();
		tabLine = new Line[Param.NBLINES];
		propLine = new Line();
		colors = new Button[Param.NBCOLORS];
		results = new Results[Param.NBLINES];
		resultLine = new Line();
		tab = new JPanel();
		propTabBox = new JPanel();
		colorsBox = new JPanel();
		resultsLines = new JPanel();
		resTabBox = new JPanel();
		createInterface();
	}
	
	/**
	 * Change la variable multi.
	 * @param multi Nouveau multi � mettre en place.
	 */
	public void setMulti(Multi multi){
		this.multi = multi;
	}
	/**
	 * Change la variable solo
	 * @param solo Nouveau solo � mettre en place.
	 */
	public void setSolo(Solo solo){
		this.solo = solo;
	}
	/**
	 * Renvoie vrai si c'est � son tour.
	 * @return Bool�en d�pendant du tour.
	 */
	public boolean getTurn() {
		return turn;
	}
}