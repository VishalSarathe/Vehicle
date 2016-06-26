package com.workscape.vehicleidentifier;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.workscape.pojo.Frame;
import com.workscape.pojo.Powertrain;
import com.workscape.pojo.Vehicle;
import com.workscape.pojo.Wheel;
import com.workscape.pojo.Wheels;
/**
 * Unit test for simple App.
 */
@PrepareForTest( VehicleIdentifier.class )
public class VehicleIdentifierTest {

	@Mock
    private VehicleIdentifier vehicleIdentifier;
 
	
	@Before
    public void setUp() throws Exception {
		vehicleIdentifier = PowerMockito.mock(VehicleIdentifier.class);
        MockitoAnnotations.initMocks(this);
    }
	
	/**
	 * Rigorous Test :-)
	 */
	/*@Test
	public void testApp() {
		Result result = JUnitCore.runClasses(VehicleIdentifier.class);
	    for (Failure failure : result.getFailures()) {
	        System.out.println(failure.toString());
	    };
	}*/
	
	@Test
	public void test_initMethodShouldIntializeProperly() { 
	//initialization

	//expected
    
    // Assert the mocked result is returned from method call
    Assert.assertEquals(vehicleIdentifier.init(), true);
   }
	
	@Test
	public void test_mainMethodShouldProperCall() { 
		//initialization
		String[] inputVars = {"test1","test2","test3"};
	    //verify
		Mockito.verify(vehicleIdentifier,Mockito.atLeastOnce()).main(inputVars);
	}
	
	@Test
	public void test_generateMapKey() { 
		//initialization
		Vehicle vehicle = new Vehicle();
		Frame frame = new Frame();
		frame.setMaterial("metal");
		vehicle.setFrame(frame);
		vehicle.setId("vehicle 1");
		vehicle.setPowertrain(new Powertrain());
		Wheel wheel = new Wheel();
		List<Wheel> wheelList = new ArrayList<Wheel>();
		wheelList.add(wheel);
		Wheels wheels = new Wheels();
		wheels.setWheel(wheelList);
		vehicle.setWheels(wheels);
		String expected = "metal1";
		//expected
		String actual= vehicleIdentifier.generateMapKey(vehicle);
		//verify
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test_loadDataStorageMap() { 
		//initialization

		//expected
		boolean actual= VehicleIdentifier.loadDataStorageMap();
		//verify
		Assert.assertEquals(true, actual);
	}
	
	
	
}
