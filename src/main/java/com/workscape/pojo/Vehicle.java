package com.workscape.pojo;

public class Vehicle {

	private String id;

    private Powertrain powertrain;

    private Frame frame;

    private Wheels wheels;

    public Vehicle(Frame frame2, Wheels dataWheels,Powertrain powertrain,String id) {
		this.frame=frame2;
		this.wheels=dataWheels;
		this.powertrain=powertrain;
		this.id=id;
	}
    
    public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Powertrain getPowertrain ()
    {
        return powertrain;
    }

    public void setPowertrain (Powertrain powertrain)
    {
        this.powertrain = powertrain;
    }

    public Frame getFrame ()
    {
        return frame;
    }

    public void setFrame (Frame frame)
    {
        this.frame = frame;
    }

    public Wheels getWheels ()
    {
        return wheels;
    }

    public void setWheels (Wheels wheels)
    {
        this.wheels = wheels;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", powertrain = "+powertrain+", frame = "+frame+", wheels = "+wheels+"]";
    }
    
   /* @Override
    public boolean equals(Object obj) {
    	Vehicle vehicle = (Vehicle)obj; 
    	return checkFrame(vehicle.getFrame());
    }
    
    @Override
    public int hashCode() {
    	return  1;
    }*/
    
    boolean checkFrame(Frame frame){
    	return frame.equals(this.frame);
    }
}
