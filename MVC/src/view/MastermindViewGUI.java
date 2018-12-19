/**
 * 
 */
package view;

import java.util.Observable;
import java.util.Observer;

import controller.MastermindController;
import model.MastermindModel;

/**
 * @author Florence
 *
 */
public class MastermindViewGUI extends MastermindView implements Observer{

	/**
	 * 
	 */
	public MastermindViewGUI(MastermindModel model, MastermindController control) {

		super(model, control);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
