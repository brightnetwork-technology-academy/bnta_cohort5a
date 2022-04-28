import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesCheckerTest {

    private ParenthesesChecker checker;

    @BeforeEach
    public void before(){
        checker = new ParenthesesChecker();
    }


    // MVP TESTS

    @Test
    public void passesForEmptyString(){
        String testString = "";
        assertTrue(checker.checkParentheses(testString));
    }

    @Test
    public void passesWithOnePair(){
        String testString = "()";
        assertTrue(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfOnlyOpening(){
        String testString = "(";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfOnlyClosing(){
        String testString = ")";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void passesIfNested(){
        String testString = "(())";
        assertTrue(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfOnePairLeftOpen(){
        String testString = "(()";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfOnePairNotOpened(){
        String testString = "())";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void passesForMatchedParenthesesInText(){
        String testString = "test (for parentheses)";
        assertTrue(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfNoClosingBracketInText(){
        String testString = "test (for unclosed parentheses ";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfNoOpeningBracketInText(){
        String testString = "test for unopened parenthesis)";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void passesForMultipleParenthesesInText(){
        String testString = "test (for multiple) opening (and closing) brackets";
        assertTrue(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfOneBracketLeftOpen(){
        String testString = "test (for multiple) opening (and closing brackets";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void failsIfOneBracketNotOpened(){
        String testString = "test (for multiple) opening and closing) brackets";
        assertFalse(checker.checkParentheses(testString));
    }

    @Test
    public void passesForNestedBracketsInText(){
        String testString = "test for (lots of (nested)) brackets";
        assertTrue(checker.checkParentheses(testString));
    }


    // EXTENSION TESTS

    @Disabled
    @Test
    public void passesForBraces(){
        String testString = "test {braces}";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void failsForSingleOpeningBrace(){
        String testString = "test {braces";
        assertFalse(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void failsForSingleClosingBrace(){
        String testString = "test braces}";
        assertFalse(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForMultipleBraces(){
        String testString = "test {multiple} {braces}";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForNestedBraces(){
        String testString = "test { nested {braces}}";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForBrackets(){
        String testString = "test [brackets]";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void failsForSingleOpeningBracket(){
        String testString = "test [brackets";
        assertFalse(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void failsForSingleClosingBracket(){
        String testString = "test brackets]";
        assertFalse(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForMultipleBrackets(){
        String testString = "test [multiple] [brackets]";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForNestedBrackets(){
        String testString = "test [ nested [brackets]]";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForAngleBrackets(){
        String testString = "test <angle brackets>";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void failsForSingleAngleBracket(){
        String testString = "test <angle brackets";
        assertFalse(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void failsForSingleClosingAngleBracket(){
        String testString = "test angle brackets>";
        assertFalse(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForMultipleAngleBrackets(){
        String testString = "test <multiple> <angle brackets>";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForNestedAngleBrackets(){
        String testString = "test < nested <angle brackets>>";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void passesForCheckNestedMixedBrackets(){
        String testString = "(nested {mixture})";
        assertTrue(checker.checkParentheses(testString));
    }

    @Disabled
    @Test
    public void failsForWronglyOrderedMixedBrackets(){
        String testString = "(nested {mixture)}";
        assertFalse(checker.checkParentheses(testString));
    }

}
