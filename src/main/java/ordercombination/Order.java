package ordercombination;

import java.util.Date;

import org.joda.time.DateTime;

public class Order {

	private Location pickUpLocation;
	private String orderName;
	private Location dropOffLocation;
	private DateTime orderDateTime;

	public DateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(DateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Location getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(Location pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public Location getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(Location dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public Order() {

	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

}
