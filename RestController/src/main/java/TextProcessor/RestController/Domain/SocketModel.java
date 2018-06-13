package TextProcessor.RestController.Domain;

import java.io.Serializable;

public class SocketModel implements Serializable {

	public String type;

	public String value;

	public String property;

	public SocketModel() {
	}

	public SocketModel(String type, String value) {
		this.type = type;
		this.value = value;
		this.property = "";
	}

	public SocketModel(String type, String value, String property) {
		this.type = type;
		this.value = value;
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
