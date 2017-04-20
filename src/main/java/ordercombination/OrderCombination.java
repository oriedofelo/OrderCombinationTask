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
        aPickUpLocation.setLatitude(-1.3044564);
        aPickUpLocation.setLongitude(36.7073077);
        A.setPickUpLocation(aPickUpLocation);
        Location aDropOffLocation = new Location();
        aDropOffLocation.setLocation("Y");
        aDropOffLocation.setLatitude(-1.3131496);
        aDropOffLocation.setLongitude(36.8934144);
        A.setDropOffLocation(aDropOffLocation);

        Order B = new Order();
        B.setOrderName("B");
        Location bPickUpLocation = new Location();
        bPickUpLocation.setLocation("X");
        bPickUpLocation.setLatitude(-1.3044564);
        bPickUpLocation.setLongitude(36.7073077);
        B.setPickUpLocation(bPickUpLocation);
        Location bDropOffLocation = new Location();
        bDropOffLocation.setLocation("Z");
        bDropOffLocation.setLatitude(-1.3131496);
        bDropOffLocation.setLongitude(36.8934144);
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
