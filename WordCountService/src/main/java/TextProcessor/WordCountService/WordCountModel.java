package TextProcessor.WordCountService;

import java.io.Serializable;

public class WordCountModel implements Serializable {

	public int wordCount;

	public String id;

	public WordCountModel() {
	}

	public WordCountModel(int wordCount, String id) {
		this.wordCount = wordCount;
		this.id = id;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
