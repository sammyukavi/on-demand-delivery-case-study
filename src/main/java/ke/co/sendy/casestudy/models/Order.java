package ke.co.sendy.casestudy.models;

public class Order {
	
	/**
	 * The name of the order to be picked/delivered
	 */
	private String name;
	
	/**
	 * The location where an order is going to be dropped off
	 */
	private Location dropOffLocation;
	
	/**
	 * The location where an order is going to be picked up
	 */
	private Location pickUpLocation;
	
	/**
	 * The cost of shipping an order
	 */
	private float orderCost;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Location getDropOffLocation() {
		return dropOffLocation;
	}
	
	public void setDropOffLocation(Location dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}
	
	public Location getPickUpLocation() {
		return pickUpLocation;
	}
	
	public void setPickUpLocation(Location pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	
	public float getOrderCost() {
		return orderCost;
	}
	
	public void setOrderCost(float orderCost) {
		this.orderCost = orderCost;
	}
}
