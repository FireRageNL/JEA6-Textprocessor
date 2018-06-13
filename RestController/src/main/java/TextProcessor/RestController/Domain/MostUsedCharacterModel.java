package TextProcessor.RestController.Domain;

public class MostUsedCharacterModel {

	public String character;

	public int value;

	public String id;

	public MostUsedCharacterModel(){

	}

	public MostUsedCharacterModel(String character, int value, String id) {
		this.character = character;
		this.value = value;
		this.id = id;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
