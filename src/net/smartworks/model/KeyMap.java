package net.smartworks.model;

public class KeyMap {

	private String id;
	private String key;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public KeyMap(String id, String key){
		super();
		this.id = id;
		this.key = key;
	}
}
