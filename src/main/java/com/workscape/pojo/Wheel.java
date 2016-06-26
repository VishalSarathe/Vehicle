package com.workscape.pojo;

public class Wheel {
public Wheel() {
	// TODO Auto-generated constructor stub
}

    private String position;

    private String material;

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getMaterial ()
    {
        return material;
    }

    public void setMaterial (String material)
    {
        this.material = material;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [position = "+position+", material = "+material+"]";
    }
}
