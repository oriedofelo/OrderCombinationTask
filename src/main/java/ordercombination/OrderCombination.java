package ordercombination;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

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
        aDropOffLocation.setLatitude(-0.3154676);
        aDropOffLocation.setLongitude(35.9387712);
        A.setDropOffLocation(aDropOffLocation);
        //set date time; year/month/day/hour/minute
        A.setOrderDateTime(new DateTime(2017, 5, 3, 10, 34));
        Order B = new Order();
        B.setOrderName("B");
        Location bPickUpLocation = new Location();
        bPickUpLocation.setLocation("X");
        bPickUpLocation.setLatitude(-0.7134721);
        bPickUpLocation.setLongitude(36.415688);
        B.setPickUpLocation(bPickUpLocation);
        Location bDropOffLocation = new Location();
        bDropOffLocation.setLocation("Z");
        bDropOffLocation.setLatitude(-1.3044564);
        bDropOffLocation.setLongitude(36.7073077);
        B.setDropOffLocation(bDropOffLocation);
      //set date time; year/month/day/hour/minute
        B.setOrderDateTime(new DateTime(2017, 5, 3, 10, 32));
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
