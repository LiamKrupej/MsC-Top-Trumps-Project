import java.util.Scanner;

// reads human players chosen attribute //
public class PlayerSelect extends ExampleClass{ 
	private String choice = "";
	public String decideOnCategory() {
        setPlayableChoices();
        Scanner input = new Scanner(System.in);
        
		String output = getUserChoice();
		System.out.println(output);
	
		choice = input.nextLine();
        choice = decideOnCategory();
		}
}
		input.close();
		choice = (this.pickTopCard()); //pickTopCard to be included as method in Player class? 
		return choice;
	}
	
      public String getUserChoice() {
// loops through potential categories to show what player can choose from
      String output = "Choose a category (" + playableChoices.get(0);
	  for(int i=1;i<playableChoices.size();i++) {
	   if (i != playableChoices.size()-1) {
			output += ", " + playableChoices.get(i);
		} else {
			output += " OR " + playableChoices.get(i) + ")";
		}
	}
	return output;
 }
     public void setPlayableChoices() {
// set the suitable characteristics which the user can choose from
	if (playableChoices.isEmpty()) {
		for(String category: pickTopCard()) { 
			playableChoices.add(category);
		}
	}
}
}