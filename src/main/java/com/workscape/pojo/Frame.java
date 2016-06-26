package com.workscape.pojo;

public class Frame {

    private String material;

    public Frame(String material) {
        this.material=material;
    }
    public Frame() {
		// TODO Auto-generated constructor stub
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
        return "ClassPojo [material = "+material+"]";
    }
    
   /* @Override
    public boolean equals(Object obj) {
    	Frame frame = (Frame)obj;
    	return frame.getMaterial().equals(this.getMaterial());
    }
*/
}
