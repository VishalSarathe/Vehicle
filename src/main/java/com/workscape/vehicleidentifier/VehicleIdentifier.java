package com.workscape.vehicleidentifier;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.workscape.literals.VehiclaLiterals;
import com.workscape.pojo.Vehicle;
import com.workscape.pojo.Vehicles;
import com.workscape.pojo.Wheel;

/**
 * Hello world!
 * 
 */
public class VehicleIdentifier implements VehiclaLiterals {

	static Map<String, String> map = null;
	static JAXBContext jaxbContext = null;

	static {
		init();
	}

	public static boolean init() {
		try {
			// load domain data
			loadDataStorageMap();

			// initialize xmlToJavaObjectConvertor
			jaxbContext = JAXBContext.newInstance(Vehicles.class);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void main(String[] args) {
		try {

			String path = getXMLFilePath();

			File file = new File(path);

			Vehicles vehicles = (Vehicles) xmlToJavaObjectAdapter(file);

			ReportCreator.generateReports(vehicles);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	

	protected static String generateMapKey(Vehicle vehicle) {
		StringBuilder mapUrl = new StringBuilder();
		if (vehicle.getFrame() != null && vehicle.getFrame().getMaterial() != null)
			mapUrl.append(vehicle.getFrame().getMaterial().trim());
		if (vehicle.getPowertrain() != null)
			mapUrl.append(vehicle.getPowertrain().toString().trim());

		List<Wheel> wheelList = vehicle.getWheels().getWheel();

		mapUrl.append(wheelList.size());

		if (!wheelList.isEmpty() && wheelList.get(0).getMaterial() != null)
			mapUrl.append(wheelList.get(0).getMaterial().trim());
		return mapUrl.toString();
	}

	private static Object xmlToJavaObjectAdapter(File file) throws JAXBException {
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return jaxbUnmarshaller.unmarshal(file);
	}

	private static String getXMLFilePath() {
		String loc = new File(".").getAbsolutePath() + XML_FILE_PATH;
		return loc;
	}
	
	protected static boolean loadDataStorageMap() {
		try {
			map = new HashMap<String, String>();
			StringBuilder entry1 = new StringBuilder();
			entry1.append(PLASTIC).append(HUMAN).append(THREE).append(PLASTIC);
			map.put(entry1.toString(), BIG_WHEEL);

			StringBuilder entry2 = new StringBuilder();
			entry2.append(METAL).append(HUMAN).append(TWO).append(METAL);
			map.put(entry2.toString(), BICYCLE);

			StringBuilder entry3 = new StringBuilder();
			entry3.append(METAL).append(INTERNAL_COMBUSTION).append(TWO).append(METAL);
			map.put(entry3.toString(), MOTORCYCLE);

			StringBuilder entry4 = new StringBuilder();
			entry4.append(PLASTIC).append(BERNOULLI);
			map.put(entry4.toString(), HANG_GLIDER);

			StringBuilder entry5 = new StringBuilder();
			entry5.append(METAL).append(INTERNAL_COMBUSTION).append(FOUR);
			map.put(entry5.toString(), CAR);

			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	private static class ReportCreator{
		
		private static void generateReports(Vehicles vehicles) {
			List<Vehicle> vehicleList = vehicles.getVehicle();
			for (Vehicle vehicle : vehicleList) {
				System.out.println(generateReports(vehicle));
			}
		}

		private static String generateReports(Vehicle vehicle) {
			String mapUrl = generateMapKey(vehicle);
			String vehicleType = map.get(mapUrl);
			return generateReports(vehicle, vehicleType);
		}

		private static String generateReports(Vehicle vehicle, String vehicleType) {
			StringBuilder report = new StringBuilder();
			if (vehicleType == null || vehicleType == "") {
				report.append(vehicle.getId()+" Records not found , please provide valid records");
			} else {
				report.append(vehicle.getId()).append(" is a ").append(vehicleType);
				if (vehicle.getFrame() != null && vehicle.getFrame().getMaterial() != null) {
					report.append(" because it has ").append(vehicle.getFrame().getMaterial()).append(" Frame");
				}
				if (vehicle.getWheels() != null && !vehicle.getWheels().getWheel().isEmpty()) {
					report.append(" and ").append(vehicle.getWheels().getWheel().get(0).getMaterial()).append(" wheels");
				}
			}
			return report.toString();
		}
	}

}
