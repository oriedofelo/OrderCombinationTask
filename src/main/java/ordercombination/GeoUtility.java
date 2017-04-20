package ordercombination;

import javax.measure.Measure;
import javax.measure.quantity.Length;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.geotools.referencing.CRS.AxisOrder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class GeoUtility {
	/*
	 * Separation distance in Kilometers that two orders should have so as to
	 * have the same delivery vehicle
	 */
	public static int sameDeliveryDistanceKm = 30;

	// check if two coordinates are equal
	public static boolean coordinatesEqual(Location locationOne, Location locationTwo) {
		GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
		Coordinate coordOne = new Coordinate(locationOne.getLatitude(), locationOne.getLongitude());
		Coordinate coordTwo = new Coordinate(locationTwo.getLatitude(), locationTwo.getLongitude());
		Point pointOne = geometryFactory.createPoint(coordOne);
		Point pointTwo = geometryFactory.createPoint(coordTwo);

		if (pointOne.equals(pointTwo)) {
			return true;
		}
		return false;

	}

	// check if two coordinates intersect
	public static boolean coordinatesIntersect(Location locationOne, Location locationTwo) {
		GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
		Coordinate coordOne = new Coordinate(locationOne.getLatitude(), locationOne.getLongitude());
		Coordinate coordTwo = new Coordinate(locationTwo.getLatitude(), locationTwo.getLongitude());
		Point pointOne = geometryFactory.createPoint(coordOne);
		Point pointTwo = geometryFactory.createPoint(coordTwo);

		if (pointOne.intersects(pointTwo)) {
			return true;
		}
		return false;

	}

	// check if two coordinates overlap
	public static boolean coordinatesOverlap(Location locationOne, Location locationTwo) {
		GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
		Coordinate coordOne = new Coordinate(locationOne.getLatitude(), locationOne.getLongitude());
		Coordinate coordTwo = new Coordinate(locationTwo.getLatitude(), locationTwo.getLongitude());
		Point pointOne = geometryFactory.createPoint(coordOne);
		Point pointTwo = geometryFactory.createPoint(coordTwo);

		if (pointOne.overlaps(pointTwo)) {
			return true;
		}
		return false;

	}

	// check if two coordinates touch edges, do not overlap
	public static boolean coordinatesTouch(Location locationOne, Location locationTwo) {
		GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
		Coordinate coordOne = new Coordinate(locationOne.getLatitude(), locationOne.getLongitude());
		Coordinate coordTwo = new Coordinate(locationTwo.getLatitude(), locationTwo.getLongitude());
		Point pointOne = geometryFactory.createPoint(coordOne);
		Point pointTwo = geometryFactory.createPoint(coordTwo);

		if (pointOne.touches(pointTwo)) {
			return true;
		}
		return false;

	}

	// check if one geometry is completely within another, no touching edges
	public static boolean coordinatesWithin(Location locationOne, Location locationTwo) {
		GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
		Coordinate coordOne = new Coordinate(locationOne.getLatitude(), locationOne.getLongitude());
		Coordinate coordTwo = new Coordinate(locationTwo.getLatitude(), locationTwo.getLongitude());
		Point pointOne = geometryFactory.createPoint(coordOne);
		Point pointTwo = geometryFactory.createPoint(coordTwo);

		if (pointOne.within(pointTwo)) {
			return true;
		}
		return false;

	}

	// check if one geometry contains another
	public static boolean coordinatesContains(Location locationOne, Location locationTwo) {
		GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
		Coordinate coordOne = new Coordinate(locationOne.getLatitude(), locationOne.getLongitude());
		Coordinate coordTwo = new Coordinate(locationTwo.getLatitude(), locationTwo.getLongitude());
		Point pointOne = geometryFactory.createPoint(coordOne);
		Point pointTwo = geometryFactory.createPoint(coordTwo);

		if (pointOne.contains(pointTwo)) {
			return true;
		}
		return false;

	}

	// get distance between two orders
	public static boolean coordinatesNearEachOther(Location locationOne, Location locationTwo) {
		CoordinateReferenceSystem crs = DefaultGeographicCRS.WGS84;
		String[] args = { locationOne.getLatitude() + "", locationOne.getLongitude() + "",
				locationTwo.getLatitude() + "", locationTwo.getLongitude() + "" };
		GeometryFactory geomFactory = new GeometryFactory();
		Point[] points = new Point[2];
		for (int i = 0, k = 0; i < 2; i++, k += 2) {
			double x = Double.valueOf(args[k]);
			double y = Double.valueOf(args[k + 1]);
			if (CRS.getAxisOrder(crs).equals(AxisOrder.NORTH_EAST)) {
				points[i] = geomFactory.createPoint(new Coordinate(x, y));
			} else {
				points[i] = geomFactory.createPoint(new Coordinate(y, x));
			}

		}
		double distance = 0.0;
		try {
			distance = JTS.orthodromicDistance(points[0].getCoordinate(), points[1].getCoordinate(), crs);
		} catch (TransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Measure<Double, Length> dist = Measure.valueOf(distance, SI.METER);
		double separationDistance=dist.doubleValue(SI.KILOMETER);
		System.out.println("Distance of Separation is: "+separationDistance + " Km");
		
		if(separationDistance <= sameDeliveryDistanceKm){
			return true;
		}
		return false;

	}

}
