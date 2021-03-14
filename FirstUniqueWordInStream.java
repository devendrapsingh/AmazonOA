package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.*;

public class FirstUniqueWordInStream {

    public static void main(String[] args) {

        String input= "The angry dog was red And the cat was also angry";

        //System.out.println(find(input));
        System.out.println(firstUniqChar("aadadaad"));
    }

    //when data is fixed in size
    static String find(String input){

        String [] data = input.split(" ");

        Set<String> uniqueWords = new HashSet<>();
        Map<String,Integer> indexToWordsMapping = new LinkedHashMap<>();

        for(int i=0;i<data.length;i++){

            if(!uniqueWords.contains(data[i].toLowerCase())){
                uniqueWords.add(data[i].toLowerCase());
            } else{
                uniqueWords.remove(data[i]);
            }
            indexToWordsMapping.putIfAbsent(data[i],i);
        }
        for(Map.Entry<String,Integer> entry : indexToWordsMapping.entrySet()){

            String word  = entry.getKey().toLowerCase();
            if(uniqueWords.size()>0 && uniqueWords.contains(word))
                return entry.getKey();   // if we want to return word
        }
       return "no word found";
    }


    // for character

    public static int firstUniqChar(String s) {

        Set<Character> uniqueCharacter = new HashSet<>();
        Map<Character,Integer> indexToCharacterMapping = new LinkedHashMap<>();

        for(int i=0 ;i<s.length();i++){

            char c = s.charAt(i);

            if(!uniqueCharacter.contains(c) && !indexToCharacterMapping.containsKey(c)){
                uniqueCharacter.add(c);
            }else{
                uniqueCharacter.remove(c);
            }
            indexToCharacterMapping.putIfAbsent(c,i);
        }
        System.out.println(uniqueCharacter.size());
        for(Map.Entry<Character,Integer> entry: indexToCharacterMapping.entrySet()){

            char c = entry.getKey();
            if(uniqueCharacter.contains(c))
                return entry.getValue();

        }
        return -1;
    }
}
