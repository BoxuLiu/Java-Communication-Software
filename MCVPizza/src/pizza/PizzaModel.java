package pizza;

/**
 * Model class for pizza, holds base calculation functions
 * 
 * @author BoxuLIU
 */
public class PizzaModel {
	public final double SMALL = 4;
	public final double MEDIUM = 5.5;
	public final double LARGE = 7;
	private final double STOPPING = 0.75;
	private final double MTOPPING = 1;
	private final double LTOPPING = 1.45;
	
	private double size = 0;
	private double number = 0;
	
	/**
	 * set the size of pizza which include small, medium, large
	 * @param size size of pizza
	 */
	public void setSize(double size) {
		this.size = size;
	}
	
	/**
	 * set the number of the toppings
	 * @param number the number of the toppings
	 */
	public void setToppings(int number) {
		this.number = number;
	}
	
	/**
	 * calculate the total price of the pizza
	 * @return the total price of the pizza
	 */
	public double totalPrice() {
		if(size == this.SMALL)
			return SMALL + STOPPING * number;
		if(size == this.MEDIUM)
			return MEDIUM + MTOPPING * number;
		else
			return LARGE + LTOPPING * number;
	}
}
