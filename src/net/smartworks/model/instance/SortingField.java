package net.smartworks.model.instance;

public class SortingField {
	
	private String fiieldId;
	private boolean isAscending;
	
	public String getFiieldId() {
		return fiieldId;
	}

	public void setFiieldId(String fiieldId) {
		this.fiieldId = fiieldId;
	}

	public boolean isAscending() {
		return isAscending;
	}

	public void setAscending(boolean isAscending) {
		this.isAscending = isAscending;
	}

	public SortingField(){
		super();
	}

}
