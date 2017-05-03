package ordercombination;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author felix.ojiem
 */
public class CombineOrders {

	public CombineOrders() {
	}

	public boolean groupOrders(Order x, Order y) {

		// pick up locations equal
		if (GeoUtility.coordinatesEqual(x.getPickUpLocation(), y.getPickUpLocation()))
			return true;

		// drop off locations equal
		if (GeoUtility.coordinatesEqual(x.getDropOffLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations intersect
		if (GeoUtility.coordinatesIntersect(x.getPickUpLocation(), y.getPickUpLocation()))
			return true;

		// drop off locations intersect
		if (GeoUtility.coordinatesIntersect(x.getDropOffLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations overlap
		if (GeoUtility.coordinatesOverlap(x.getPickUpLocation(), y.getPickUpLocation()))
			return true;

		// drop off locations intersect
		if (GeoUtility.coordinatesOverlap(x.getDropOffLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations touch
		if (GeoUtility.coordinatesTouch(x.getPickUpLocation(), y.getPickUpLocation()))
			return true;

		// drop off locations touch
		if (GeoUtility.coordinatesTouch(x.getDropOffLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations within each other
		if (GeoUtility.coordinatesWithin(x.getPickUpLocation(), y.getPickUpLocation()))
			return true;

		// drop off locations within each other
		if (GeoUtility.coordinatesWithin(x.getDropOffLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations one contains the other
		if (GeoUtility.coordinatesContains(x.getPickUpLocation(), y.getPickUpLocation()))
			return true;

		// drop off locations one contains the other
		if (GeoUtility.coordinatesContains(x.getDropOffLocation(), y.getDropOffLocation()))
			return true;

		// pick up location distance between points is less than a specific set
		// convenience distance
		if (GeoUtility.coordinatesNearEachOther(x.getPickUpLocation(), y.getPickUpLocation()))
			return true;

		// drop off locations distance between points is less than a specific
		// set convenience distance
		if (GeoUtility.coordinatesNearEachOther(x.getDropOffLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations equal drop off
		if (GeoUtility.coordinatesEqual(x.getPickUpLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations intersect drop off
		if (GeoUtility.coordinatesIntersect(x.getPickUpLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations overlap dropoff
		if (GeoUtility.coordinatesOverlap(x.getPickUpLocation(), y.getDropOffLocation()))
			return true;

		// drop off locations within each other
		if (GeoUtility.coordinatesWithin(x.getPickUpLocation(), y.getDropOffLocation()))
			return true;

		// pick up locations one contains the other
		if (GeoUtility.coordinatesContains(x.getPickUpLocation(), y.getDropOffLocation()))
			return true;

		if (GeoUtility.coordinatesNearEachOther(x.getPickUpLocation(), y.getDropOffLocation()))
			return true;
		// orders cannot be combined
		return false;

	}

	public ArrayList<ArrayList<Order>> combineOrders(List<Order> inputOrders) {
		ArrayList<ArrayList<Order>> groupedOrders = new ArrayList<ArrayList<Order>>();
		// loop through all orders
		for (Order order : inputOrders) {
			// loop through grouped orders to check if item can be put in any of
			// groups
			boolean itemFound = false;
			ListIterator<ArrayList<Order>> iterGrp = groupedOrders.listIterator();

			while (iterGrp.hasNext()) {
				ArrayList<Order> orders = iterGrp.next();
				ArrayList<Order> itemsToAdd = new ArrayList<Order>();
				ListIterator<Order> iter = orders.listIterator();
				while (iter.hasNext()) {
					Order orderItem = iter.next();
					int timeDifferenceBetweenOrders = TimeUtility.
							getMinutesDifference(orderItem.getOrderDateTime(), order.getOrderDateTime());
					//if time difference between two orders is less than or equal to one
					if (groupOrders(orderItem, order) && timeDifferenceBetweenOrders <=1) {
						itemFound = true;
						itemsToAdd.add(order);
					}
				}

				orders.addAll(itemsToAdd);

			}
			// if item not grouped in any of groups, create new group
			if (itemFound == false) {
				ArrayList<Order> newGroup = new ArrayList<Order>();
				newGroup.add(order);
				groupedOrders.add(newGroup);
			}

		}
		return groupedOrders;
	}

}
