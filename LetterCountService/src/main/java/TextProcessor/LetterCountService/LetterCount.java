package TextProcessor.LetterCountService;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LetterCount {


	public MostUsedCharacterModel getMostOccuringLetter(String str, String id) {
		String toLowerCase = str.toLowerCase();
		String azOnly = toLowerCase.replaceAll(" ", "");
		char[] Chararray = azOnly.toCharArray();
		HashMap<Character,Integer> charMap = new HashMap<>();
		for (char c : Chararray) {
			if(!charMap.containsKey(c)){
				charMap.put(c,1);
			}
			else{
				int val = charMap.get(c);
				charMap.put(c,val+1);
			}
		}
		Map.Entry<Character,Integer> max = null;
		for(Map.Entry<Character,Integer> i : charMap.entrySet()){
			if(max == null || i.getValue().compareTo(max.getValue()) > 0){
				max = i;
			}
		}
		return new MostUsedCharacterModel(max.getKey().toString(),max.getValue(),id);
	}
}
