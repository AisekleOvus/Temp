//package flashcards;
import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Formatter;
import java.util.Random;

public class First {
    private static LinkedHashMap<String,String> cards = new LinkedHashMap<>();
    private static Scanner scnr = new Scanner(System.in);
	
    public static void main(String[] args) {
		while(true) {
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
		    String action = scnr.next();
		    if( action.toLowerCase().equals("add")) Add();
		    if( action.toLowerCase().equals("ask")) Ask();
		    if( action.toLowerCase().equals("exit")) {
			    System.out.println("Bye bye!");
			    break;
			}
			System.out.println();
		}
    }
	
    private static boolean Ask() {
		System.out.println("How many times to ask?");
		int times = 0;
		if(!scnr.hasNextInt()) {
			times = 1;
		    scnr.next();
		}
		else
			times = scnr.nextInt();
		    times = cards.size() == 0 ? 0 : times;
		for(int i = 0; i < times; i++) {
            String card = cards.size() > 1 ? (String) cards.keySet().toArray()[new Random().nextInt(cards.size()-1)] : (String) cards.keySet().toArray()[0];
		    String definition = cards.get(card);
			String answer;
			String wrongKey;

			System.out.println("Print the definition of \""+card+"\":");
            answer = scnr.next();
			System.out.println("ANSWER WAS : "+answer);
			if(definition.toLowerCase().equals(answer.toLowerCase())) 
				System.out.println("Correct answer.");
			else
				if((wrongKey = (String) getKeyByValue(cards, answer)) != null)
					System.out.println("Wrong answer. The correct one is \""+definition+"\", you've just written the definition of \""+wrongKey+"\".");
				else
					System.out.println("Wrong answer. The correct one is \""+definition+"\".");
            
		}
		return true; 
    }
    private static boolean Add() {
            System.out.println("The card:");
            String term = scnr.next();
            if(cards.containsKey(term)) {
                System.out.println("The card \""+term+"\" already exists.");
                return false;
            } else {
                System.out.println("The definition of the card:");
                String definition = scnr.next();
				if(getKeyByValue(cards, definition) != null) {
					System.out.println("The definition \""+definition+"\" already exists.");
				    return false;
			    }
                cards.put(term,definition);
				System.out.println("The pair (\""+term+"\":\""+definition+"\") has been added.");
                return true;
            }

    }
	public static <M extends Map, V> Object getKeyByValue(Map<?, ?> map, V value) {
	    Object result = null;
		if(map.containsValue(value)) {
		    for(Map.Entry<?, ?> entry : map.entrySet()) {
				if(value.equals(entry.getValue()))
				 result = entry.getKey();
			}
		}
		return result;
	}
}