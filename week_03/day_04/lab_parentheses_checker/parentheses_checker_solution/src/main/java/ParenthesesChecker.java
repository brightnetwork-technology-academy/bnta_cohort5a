import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ParenthesesChecker {

    private Stack<Character> unmatchedCharacters;

    public ParenthesesChecker(){
        unmatchedCharacters = new Stack<>();
    }

    public boolean checkParentheses(String testString) {

        List<Character> openingCharacters = Arrays.asList('(', '{', '[', '<');
        List<Character> closingCharacters = Arrays.asList(')', '}', ']', '>');

        char[] brokenString = testString.toCharArray();

        for (Character character : brokenString){
            if (openingCharacters.contains(character)){
                unmatchedCharacters.push(character);
            }
            else if (closingCharacters.contains(character)){

                int indexToCheck = closingCharacters.indexOf(character);

                char correspondingOpeningCharacter = openingCharacters.get(indexToCheck);

                if (unmatchedCharacters.isEmpty() || !unmatchedCharacters.peek().equals(correspondingOpeningCharacter)) {
                    return false;
                }
                else {
                    unmatchedCharacters.pop();
                }
            }
        }

        return unmatchedCharacters.isEmpty();
    }

}
