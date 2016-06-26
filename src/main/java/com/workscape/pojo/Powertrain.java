package com.workscape.pojo;

public class Powertrain {
    private String human;

    private String internalCombustion;
    
    private String bernoulli;
    
    public String getHtestuman() {
		return internalCombustion;
	}

	public void setHtestuman(String internalCombustion) {
		this.internalCombustion = internalCombustion;
	}

	public String getHuman ()
    {
        return human;
    }

    public void setHuman (String human)
    {
        this.human = human;
    }

    public String getInternalCombustion() {
		return internalCombustion;
	}

	public void setInternalCombustion(String internalCombustion) {
		this.internalCombustion = internalCombustion;
	}

	public String getBernoulli() {
		return bernoulli;
	}

	public void setBernoulli(String bernoulli) {
		this.bernoulli = bernoulli;
	}

	@Override
    public String toString()
    {
    	if(human!=null){
    		return "Human";
    	}
    	
    	if(internalCombustion!=null){
    		return "Internal Combustion";
    	}
    	
    	if(bernoulli!=null){
    		return "Bernoulli";
    	}
    	return "";
    }
}
