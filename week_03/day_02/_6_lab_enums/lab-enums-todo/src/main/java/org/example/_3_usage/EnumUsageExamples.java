package org.example._3_usage;

import org.example._2_basics.LogLevel;

public class EnumUsageExamples {
    /*
        TODO 5 It's time to use some enums, 3 case scenarios:

    1. use an enum variable in an if-else statement
    2. use of Enum in Switch-Case Statements

    First, let's look at some examples, and then your task will be to
    implement a few more, using enums created in TODO4.

    The examples:

    1. use an enum variable in an if-else logic

    Directions dir = Directions.EAST;

    if(dir == Directions.NORTH) {
       System.out.println("North");
    } else if(dir == Directions.EAST) {
       System.out.println("East");
    } else if(dir == Directions.SOUTH) {
       System.out.println("South");
    } else {
       System.out.println("West");
    }

    2. use of Enum in Switch-Case Statements (the below example is switch-case an equivalent
    of the if example):

    Directions dir = Directions.EAST;

    switch (dir) {
       case Directions.NORTH:
          System.out.println("North");
          break;

       case Directions.EAST:
          System.out.println("East");
          break;

       case Directions.SOUTH:
          System.out.println("South");
          break;

       default:
          System.out.println("West");
          break;
     }


 */
    /*
        TODO 6 implement the below methods
         and run the tests from org.example._3_usage.EnumUsageExamplesTest to verify your work
     */

    /*
        TODO 6a Implement the method's logic so that getLogLevelMessageUsingIf returns:

        getLogLevelMessageUsingIf(LogLevel.DEBUG)   -> "It's DEBUG!"
        getLogLevelMessageUsingIf(LogLevel.INFO)    -> "It's INFO!"
        getLogLevelMessageUsingIf(LogLevel.WARNING) -> "It's WARNING!"

     */

    /*

        TODO 6b Implement the method's logic so that getLogLevelMessageUsingSwitchCase returns:
        getLogLevelMessageUsingSwitchCase(LogLevel.DEBUG)   -> "It's DEBUG!"
        getLogLevelMessageUsingSwitchCase(LogLevel.INFO)    -> "It's INFO!"
        getLogLevelMessageUsingSwitchCase(LogLevel.WARNING) -> "It's WARNING!"

     */

    String getLogLevelMessageUsingSwitchCase(LogLevel logLevel) {
    //   pass the variable to a switch-case statement to return a specific message
        return "";
    }

    public String getLogLevelMessageUsingIf(LogLevel logLevel) {
        return "";
    }
}
