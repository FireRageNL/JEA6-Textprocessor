package TextProcessor.WordCountService;

import java.io.Serializable;

public class TextProcess implements Serializable {


	public String text;

	public Boolean amountOfWords;

	public Boolean mostOccuringCharacter;

	public String id;

	public TextProcess(){

	}

	public TextProcess(String text, Boolean amountOfWords, Boolean mostOccuringCharacter, String id) {
		this.text = text;
		this.amountOfWords = amountOfWords;
		this.mostOccuringCharacter = mostOccuringCharacter;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getAmountOfWords() {
		return amountOfWords;
	}

	public void setAmountOfWords(Boolean amountOfWords) {
		this.amountOfWords = amountOfWords;
	}
}
