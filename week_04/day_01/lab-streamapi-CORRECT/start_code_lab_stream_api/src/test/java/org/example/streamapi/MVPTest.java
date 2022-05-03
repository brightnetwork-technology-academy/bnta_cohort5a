package org.example.streamapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MVPTest {

    private MVP mvp = new MVP();

    @Nested
    @DisplayName("printNames")
    class PrintNames {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        {
            System.setOut(new PrintStream(outContent));
        }

        List<String> names1 = List.of("Linda", "Bob", "Ed");
        List<String>  names2 = List.of("Andy");
        List<String>  names3 = List.of("Giovanni", "Antonio", "Giorgio", "Marco");

        @Test
        @DisplayName("should print \"Linda\", \"Bob\", \"Ed\"")
        void printNames_L_B_E() {
            mvp.printNames(names1);
            assertEquals("Linda" + System.lineSeparator() + "Bob" + System.lineSeparator() + "Ed" + System.lineSeparator(), outContent.toString());
        }

        @Test
        @DisplayName("should print \"Andy\"")
        void printNames_A() {
            mvp.printNames(names2);
            assertEquals("Andy" + System.lineSeparator(), outContent.toString());
        }

        @Test
        @DisplayName("should print \"Giovanni\", \"Antonio\", \"Giorgio\", \"Marco\"")
        void printNames() {
            mvp.printNames(names3);
            assertEquals("Giovanni" + System.lineSeparator() + "Antonio" + System.lineSeparator() + "Giorgio" + System.lineSeparator() + "Marco" + System.lineSeparator(), outContent.toString());
        }

    }

    @Nested
    @DisplayName("returnEvenNumbers")
    class ReturnEvenNumbers {

        @Test
        @DisplayName("should return 2, 4 for (1, 2, 4, 7, 15)")
        void returnEvenNumbers_1_2_4_7_15() {

            List<Integer> input = List.of(1, 2, 4, 7, 15);
            List<Integer> expected = List.of(2, 4);

            assertEquals(expected, mvp.returnEvenNumbers(input));
        }

        @Test
        @DisplayName("should return 0 for (0, -3, -15)")
        void returnEvenNumbers_0_m3_m15() {

            List<Integer> input = List.of(0, -3, -15);
            List<Integer> expected = List.of(0);

            assertEquals(expected, mvp.returnEvenNumbers(input));
        }

        @Test
        @DisplayName("should return empty list for empty list")
        void returnEvenNumbers_empty() {

            List<Integer> input = List.of();
            List<Integer> expected = List.of();

            assertEquals(expected, mvp.returnEvenNumbers(input));
        }

        @Test
        @DisplayName("should return 700 for (700)")
        void returnEvenNumbers_700() {

            List<Integer> input = List.of(700);
            List<Integer> expected = List.of(700);

            assertEquals(expected, mvp.returnEvenNumbers(input));
        }

    }

    @Nested
    @DisplayName("splitToAllCapsList")
    class SplitToAllCapsList {

        @Test
        @DisplayName("should return a list [\"H\", \"E\", \"Y\"] for \"hey\"")
        void splitWord_hey() {

            String input = "hey";
            List<String> expected = List.of("H", "E", "Y");

            assertEquals(expected, mvp.splitToAllCapsList(input));
        }

        @Test
        @DisplayName("should return [\"T\",\"A\",\"N\",\"G\",\"O\"] for \"tAnGo\"")
        void splitWord_tAnGo() {

            String input = "tAnGo";
            List<String> expected = List.of("T", "A", "N", "G", "O");

            assertEquals(expected, mvp.splitToAllCapsList(input));
        }

        @Test
        @DisplayName("should return [\"\"] for empty String")
        void splitWord_emptyString() {

            String input = "";
            List<String> expected = List.of("");

            assertEquals(expected, mvp.splitToAllCapsList(input));
        }
    }

    @Nested
    @DisplayName("doubleInts")
    class DoubleInts {

        @Test
        @DisplayName("should return [2, 4, 8] for [1, 2, 4]")
        void doubleInts_1_2_4() {

            int[] input = {1, 2, 4};
            int[] expected = {2, 4, 8};

            assertArrayEquals(expected, mvp.doubleInts(input));
        }

        @Test
        @DisplayName("should return [0, -6, 0] for [0, -3, 0]")
        void doubleInts_0_3_0() {

            int[] input = {0, -3, 0};
            int[] expected = {0, -6, 0};

            assertArrayEquals(expected, mvp.doubleInts(input));
        }

        @Test
        @DisplayName("should return [1400] for [700]")
        void doubleInts_7000() {

            int[] input = {700};
            int[] expected = {1400};

            assertArrayEquals(expected, mvp.doubleInts(input));
        }

        @Test
        @DisplayName("should print 1400 for (700)")
        void doubleInts_emptyArr() {

            int[] input = {};
            int[] expected = {};

            assertArrayEquals(expected, mvp.doubleInts(input));
        }
    }

    @Nested
    @DisplayName("filterByFirstLetterAndOrder")
    class FilterByFirstLetterAndOrder {

        @Test
        @DisplayName("should return [\"PANDA\", \"PARROT\", \"PENGUIN\"] for p  [\"penguin\", \"cat\", \"monkey\", \"parrot\", \"lion\", \"panda\"]")
        void filterFirstLetter_p() {

            List<String> input = List.of("penguin", "cat", "monkey", "parrot", "lion", "panda");
            List<String> expected = List.of("PANDA", "PARROT", "PENGUIN");

            assertEquals(expected, mvp.filterByFirstLetterAndOrder(input, "p"));
        }

        @Test
        @DisplayName("should return [\"LION\"] for l [\"penguin\", \"cat\", \"monkey\", \"parrot\", \"lion\", \"panda\"]")
        void filterFirstLetter_l() {

            List<String> input = List.of("penguin", "cat", "monkey", "parrot", "lion", "panda");
            List<String> expected = List.of("LION");

            assertEquals(expected, mvp.filterByFirstLetterAndOrder(input, "l"));
        }

        @Test
        @DisplayName("should return [] for G [\"penguin\", \"cat\", \"monkey\", \"parrot\", \"lion\", \"panda\"]")
        void filterFirstLetter_g() {

            List<String> input = List.of("penguin", "cat", "monkey", "parrot", "lion", "panda");
            List<String> expected = List.of();

            assertEquals(expected, mvp.filterByFirstLetterAndOrder(input, "g"));
        }

    }

    @Nested
    @DisplayName("filterWords")
    class FilterWords {

        @Test
        @DisplayName("should return [\"London\", \"Lisbon\"] for  [\"London\", \"Paris\", \"Louisville\", \"Lisbon\", \"Sydney\"]; 7; \"L\"")
        void findShortWords_7_L() {

            List<String> inputCities = List.of("London", "Paris", "Louisville", "Lisbon", "Sydney");
            int inputMaxLength = 7;
            String inputFirstLetter = "L";
            List<String> expected = List.of("London", "Lisbon");

            assertEquals(expected, mvp.filterWords(inputCities, inputMaxLength, inputFirstLetter));
        }

        @Test
        @DisplayName("should return [\"Peru\"] for [\"Peru\", \"Panama\", \"Portugal\"] 5; \"P\"")
        void findShortWords_5_P() {
            List<String> inputCountries = List.of("Peru", "Panama", "Portugal");
            int inputMaxLength = 5;
            String inputFirstLetter = "P";

            List<String> expected = List.of("Peru");

            assertEquals(expected, mvp.filterWords(inputCountries, inputMaxLength, inputFirstLetter));
        }

    }

}