package ordercombination;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felix.ojiem
 */
public class OrderCombination {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>();

        Order A = new Order();
        A.setOrderName("A");
        Location aPickUpLocation = new Location();
        aPickUpLocation.setLocation("X");
        aPickUpLocation.setLatitude(0.5119278);
        aPickUpLocation.setLongitude(35.1991709);
        A.setPickUpLocation(aPickUpLocation);
        Location aDropOffLocation = new Location();
        aDropOffLocation.setLocation("Y");
        aDropOffLocation.setLatitude(0.5168118);
        aDropOffLocation.setLongitude(35.2739668);
        A.setDropOffLocation(aDropOffLocation);

        Order B = new Order();
        B.setOrderName("B");
        Location bPickUpLocation = new Location();
        bPickUpLocation.setLocation("X");
        bPickUpLocation.setLatitude(0.5168118);
        bPickUpLocation.setLongitude(35.2739668);
        B.setPickUpLocation(bPickUpLocation);
        Location bDropOffLocation = new Location();
        bDropOffLocation.setLocation("Z");
        bDropOffLocation.setLatitude(0.5152843);
        bDropOffLocation.setLongitude(35.2734052);
        B.setDropOffLocation(bDropOffLocation);
        orders.add(A);
        orders.add(B);

        CombineOrders combiner = new CombineOrders();
        // try to combine orders
        ArrayList<ArrayList<Order>> combinedOrders = combiner.combineOrders(orders);

        // lets loop through the sets of orders that were combined
        for (int i = 0; i < combinedOrders.size(); i++) {
            ArrayList<Order> listOrders = combinedOrders.get(i);
            System.out.println("Delivery: " + i);
            System.out.println("Printing Orders in Delivery : " + i);
            for (Order orderItem : listOrders) {
                System.out.println("Order Name: " + orderItem.getOrderName() + ", Pickup Location: "
                        + orderItem.getPickUpLocation().getLocation()+" ; Latitude: "+orderItem.getPickUpLocation().getLatitude()+" Longitude: "+orderItem.getPickUpLocation().getLongitude() + ", DropOff Location: "
                        + orderItem.getDropOffLocation().getLocation()+" ; Latitude: "+orderItem.getDropOffLocation().getLatitude()+" Longitude: "+orderItem.getDropOffLocation().getLongitude());
            }
            System.out.println("Done Printing Orders in Delivery : " + i);
        }

    }

}
