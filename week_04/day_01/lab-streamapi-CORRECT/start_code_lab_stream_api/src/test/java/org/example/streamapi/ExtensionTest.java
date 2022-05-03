package org.example.streamapi;

import org.example.streamapi.model.Bodybuilder;
import org.example.streamapi.model.Friend;
import org.example.streamapi.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.stream.IntStream;

import static org.example.streamapi.model.User.GENDER.*;
import static org.junit.jupiter.api.Assertions.*;

class ExtensionTest {

    private Extension extension = new Extension();


    @Nested
    @DisplayName("streamNumbers")
    class StreamNumbers {

        @Test
        @DisplayName("should return an IntStream[4, 5, 6, 7] for (4, 8)")
        void streamNumbers_4_8() {

            int a = 4;
            int b = 8;
            int[] expected = IntStream.range(4,8).toArray();

            assertArrayEquals(expected, extension.streamNumbers(a,b));
        }

        @Test
        @DisplayName("should return an IntStream[4, 5, 6, 7] for (8, 4)")
        void streamNumbers_8_4() {

            int a = 8;
            int b = 4;
            int[] expected = IntStream.range(4,8).toArray();

            assertArrayEquals(expected, extension.streamNumbers(a,b));
        }
    }

    @Nested
    @DisplayName("getUserByIdOrCreateNew")
    class GetUserByIdOrCreateNew {

        List<User> input = List.of(
                new User(1234567, "Joanna", FEMALE),
                new User(9876543, "David", MALE),
                new User(4567890, "Arnold", MALE)
        );

        @Test
        @DisplayName("should return Joanna for id 1234567")
        void getUserById_user1() {

            User expected = input.get(0);

            assertEquals(expected, extension.getUserByIdOrCreateNew(input, 1234567));
        }

        @Test
        @DisplayName("should return David for id 4567890")
        void getUserById_user3() {

            User expected = input.get(2);

            assertEquals(expected, extension.getUserByIdOrCreateNew(input, 4567890));
        }

        @Test
        @DisplayName("should return \"'New user\" for id 123456")
        void getUserById_newUser() {

            User expected = new User(123456,"New user", UNKNOWN);

            assertEquals(expected, extension.getUserByIdOrCreateNew(input, 123456));
        }
    }

    @Nested
    @DisplayName("partyWithFriends")
    class PartyWithFriends {

        @Test
        @DisplayName("should return {\"Adam\", \"Bella\", \"John\"}")
        void partyWithFriends() {

           List<Friend> input = List.of(
                    new Friend("Adam","Saturday", "Party"),
                    new Friend("Bob","Sunday","Bowling"),
                    new Friend("Lola","Saturday","Climbing"),
                    new Friend("Bella","Saturday","Party"),
                    new Friend("Mike","Monday","Party"),
                    new Friend("John","Saturday","Party"),
                    new Friend("Paul", "Tuesday", "Party"),
                    new Friend("Karina", "Saturday", "Dinner")
            );

            List<String> expected = List.of("Adam", "Bella", "John");

            assertEquals(expected, extension.partyWithFriends(input));
        }

        @Test
        @DisplayName("should return empty for no matching friends")
        void partyWithFriends_noParty() {

            List<Friend> input = List.of(
                    new Friend("Paul", "Tuesday", "Party"),
                    new Friend("Karina", "Saturday", "Fitness"),
                    new Friend("Angela", "Tuesday", "Walk"),
                    new Friend("Mark", "Thursday", "Party")
            );

            List<Friend> expected = List.of();

            assertEquals(expected, extension.partyWithFriends(input));
        }
    }

    @Nested
    @DisplayName("sortBodybuilders")
    class SortBodybuilders {

        @Test
        @DisplayName("should return [Andy, Muhammad, Max, Mike, Peter, Greg, Lisa, Alexandra] when sorted by lift, age, name")
        void sortBodybuilders_1() {

            List<Bodybuilder> input = List.of(
                    new Bodybuilder("Mike", 144, 23),
                    new Bodybuilder("Max", 144, 23),
                    new Bodybuilder("Muhammad", 144, 21),
                    new Bodybuilder("Greg", 132, 27),
                    new Bodybuilder("Alexandra", 78, 29),
                    new Bodybuilder("Andy", 156, 31),
                    new Bodybuilder("Lisa", 78, 19),
                    new Bodybuilder("Peter", 144, 23));

            List<String> expected = List.of("Andy", "Muhammad", "Max", "Mike", "Peter", "Greg", "Lisa", "Alexandra");

            assertEquals(expected, extension.sortBodybuilders(input));
        }

        @Test
        @DisplayName("should return by name asc when lift and age values are the same")
        void sortBodybuilders_2() {

            List<Bodybuilder> input = List.of(
                    new Bodybuilder("John", 100, 19),
                    new Bodybuilder("Josh", 100, 19),
                    new Bodybuilder("Lena", 100, 19));

            List<String> expected = List.of("John", "Josh", "Lena");

            assertEquals(expected, extension.sortBodybuilders(input));
        }

        @Test
        @DisplayName("should order by age asc when lift value is the same")
        void sortBodybuilders_3() {

            List<Bodybuilder> input = List.of(
                    new Bodybuilder("John", 100, 30),
                    new Bodybuilder("Josh", 100, 22),
                    new Bodybuilder("Lena", 100, 19));

            List<String> expected = List.of("Lena", "Josh", "John");

            assertEquals(expected, extension.sortBodybuilders(input));
        }

        @Test
        @DisplayName("should return by lift desc when age value is the same")
        void sortBodybuilders_4() {

            List<Bodybuilder> input = List.of(
                    new Bodybuilder("John", 90, 30),
                    new Bodybuilder("Josh", 100, 30),
                    new Bodybuilder("Lena", 110, 30));

            List<String> expected = List.of("Lena", "Josh", "John");

            assertEquals(expected, extension.sortBodybuilders(input));
        }

        @Test
        @DisplayName("should return [] for empty list")
        void sortBodybuilders_5() {
            List<Bodybuilder> input = List.of();

            List<String> expected = List.of();

            assertEquals(expected, extension.sortBodybuilders(input));
        }
    }

}