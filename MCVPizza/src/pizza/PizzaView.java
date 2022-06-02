package pizza;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.*;

/**
 * View class of pizza view, generates the GUI
 * @author BoxuLIU
 */
public class PizzaView extends JFrame{
	/**
	 * Fields of the view which point to model and controller
	 */
	private PizzaModel pizzaModel = new PizzaModel();
	private PizzaController pizzacontroller = new PizzaController(this,pizzaModel);
	
	
	/**
	 * The buttons to choose the size of pizza which includes small, medium, large
	 */
	public JRadioButton small = new JRadioButton("Small");
	public JRadioButton medium = new JRadioButton("Medium");
	public JRadioButton large = new JRadioButton("Large");	
	public ButtonGroup size = new ButtonGroup();{
		size.add(small);
		size.add(medium);
		size.add(large);
	}
	
	/**
	 * Field as a list which includes all keys of toppings 
	 * Keys can be accessed by their index
	 */
	public ArrayList<JCheckBox> toppings = new ArrayList<JCheckBox>();{
		toppings.add(new JCheckBox("Cheese"));
		toppings.add(new JCheckBox("Onion"));
		toppings.add(new JCheckBox("Salami"));
		toppings.add(new JCheckBox("Mushroom"));
		toppings.add(new JCheckBox("Sweet pepper"));
		toppings.add(new JCheckBox("Jalapeno pepper"));
	}
	
	
	/**
	 * The delicious pizza's image
	 */
	private JLabel pizzaLabel = new JLabel(new ImageIcon("pizza.jpg"));
	private JLabel totalPriceLabel = new JLabel("Total price");
	
	
	/**
	 * For showing the display
	 */
	private JTextField display = new JTextField("                             "); {
		this.display.setEditable(false);
	}
	
	
	/**
	 * All the panels will be used in the frame
	 */
	private Panel pN = new Panel();
	private Panel pS = new Panel(new FlowLayout());
	private Panel pE = new Panel(new GridLayout(6,1));
	  
	private Panel pSL = new Panel();{
		pSL.setSize(2000,50);
	}
	private Panel pSR = new Panel();{
		pSR.setSize(200,50);
	}
	 
	/**
	 * Constructor to create a view object
	 * Includes all elements of the GUI and links them to the controller
	 */
	public PizzaView(){
		super("Choose your pizza");
		
//		combine all of the parts of frame
		pN.add(small);
		pN.add(medium);
		pN.add(large);
		
		for(JCheckBox tem : toppings) {
			pE.add(tem);
		}
		
		pSL.add(totalPriceLabel);
		pSR.add(display);
		pS.add(pSL);
		pS.add(pSR);
		
		this.add(pN,BorderLayout.NORTH);
		
		this.add(pizzaLabel,BorderLayout.WEST);
		
		this.add(pE,BorderLayout.EAST);
		
		this.add(pS,BorderLayout.SOUTH);
		
//		Connect all keys of the pizza to controller
		small.addActionListener(pizzacontroller);
		medium.addActionListener(pizzacontroller);
		large.addActionListener(pizzacontroller);
		for(JCheckBox tem : toppings) {
			tem.addActionListener(pizzacontroller);
		}
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
//		set the default size as small
		small.doClick();
	}
	
	/**
	 * Will be called by the controller when view should be updated
	 */
	public void upDate() {
		display.setText(Double.toString(pizzaModel.totalPrice()));
	}
}
