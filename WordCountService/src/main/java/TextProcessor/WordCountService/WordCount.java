package TextProcessor.WordCountService;

import org.springframework.stereotype.Component;

@Component
public class WordCount {

	public int getWordCount(String str){
		String[] words = str.split("\\s+");
		return words.length;
	}
}
