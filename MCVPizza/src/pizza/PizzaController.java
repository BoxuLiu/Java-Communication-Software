package pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

/**
 * Controller class of pizza, acts as an intermediary between view and model.
 * defines what should happen on user interaction
 * 
 * @author BoxuLIU
 */
public class PizzaController implements ActionListener{
	
	/**
	 * Fields of the controller which point to view and model
	 */
	private PizzaView pizzaView;
	private PizzaModel pizzaModel;
	
	/**
	 * Constructor to create controller object
	 * 
	 * @param v view object of pizza which is managed by this controller
	 * @param m model object of pizza which is managed by this controller
	 */
	public PizzaController(PizzaView v,PizzaModel m){
		pizzaView = v;
		pizzaModel = m;
	}
	/**
	 * ActionListener, will be called whenever a key on the pizza view is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int count = 0;
		for(JCheckBox tem : pizzaView.toppings) {
			if(tem.isSelected())
				count++;
		}
		pizzaModel.setToppings(count);
		
		if(e.getSource() == pizzaView.small)
			pizzaModel.setSize(pizzaModel.SMALL);
		if(e.getSource() == pizzaView.medium)
			pizzaModel.setSize(pizzaModel.MEDIUM);
		if(e.getSource() == pizzaView.large)
			pizzaModel.setSize(pizzaModel.LARGE);	
		
		pizzaView.upDate();
	}
	
}
