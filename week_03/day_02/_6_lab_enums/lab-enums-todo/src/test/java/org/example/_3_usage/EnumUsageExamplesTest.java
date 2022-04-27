package org.example._3_usage;

import org.example._2_basics.LogLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumUsageExamplesTest {

    private static final String DEBUG_MSG = "It's DEBUG!";
    private static final String INFO_MSG = "It's INFO!";
    private static final String WARNING_MSG = "It's WARNING!";

    EnumUsageExamples examples = new EnumUsageExamples();

    @Test
    @DisplayName("getLogLevelMessageUsingIf should return " + DEBUG_MSG + " for LogLevel.DEBUG")
    void getLogLevelMessageUsingIf_DEBUG() {
        assertEquals(DEBUG_MSG, examples.getLogLevelMessageUsingIf(LogLevel.DEBUG));
    }

    @Test
    @DisplayName("getLogLevelMessageUsingIf should return " + INFO_MSG + " for " + "LogLevel.INFO")
    void getLogLevelMessageUsingIf_INFO() {
        assertEquals(INFO_MSG, examples.getLogLevelMessageUsingIf(LogLevel.INFO));
    }

    @Test
    @DisplayName("getLogLevelMessageUsingIf should return " + WARNING_MSG + " for " + "LogLevel.WARNING")
    void getLogLevelMessageUsingIf_WARNING() {
        assertEquals(WARNING_MSG, examples.getLogLevelMessageUsingIf(LogLevel.WARNING));
    }

    @Test
    @DisplayName("getLogLevelMessageUsingSwitchCase should return " + DEBUG_MSG + " for LogLevel.DEBUG")
    void getLogLevelMessageUsingSwitchCase_DEBUG() {
        assertEquals(DEBUG_MSG, examples.getLogLevelMessageUsingSwitchCase(LogLevel.DEBUG));
    }

    @Test
    @DisplayName("getLogLevelMessageUsingSwitchCase should return " + INFO_MSG + " for " + "LogLevel.INFO")
    void getLogLevelMessageUsingSwitchCase_INFO() {
        assertEquals(INFO_MSG, examples.getLogLevelMessageUsingSwitchCase(LogLevel.INFO));
    }

    @Test
    @DisplayName("getLogLevelMessageUsingSwitchCase should return " + WARNING_MSG + " for " + "LogLevel.WARNING")
    void getLogLevelMessageUsingSwitchCase_WARNING() {
        assertEquals(WARNING_MSG, examples.getLogLevelMessageUsingSwitchCase(LogLevel.WARNING));
    }
}
