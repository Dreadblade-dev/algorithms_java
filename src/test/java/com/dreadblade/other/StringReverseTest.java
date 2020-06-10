package com.dreadblade.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverseTest {

    @Test
    public void testCoverage1() {
        String str = "Hi!";

        String actual = StringReverse.reverse(str);

        String expected = "!iH";

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testCoverage2() {
        String str = "Hello world!";

        String actual = StringReverse.reverse(str);

        String expected = "!dlrow olleH";

        assertTrue(expected.equals(actual));
    }

    @Test
    public void testCoverage3() {
        String str = "This is a sequence of characters";

        String actual = StringReverse.reverse(str);

        String expected = "sretcarahc fo ecneuqes a si sihT";

        assertTrue(expected.equals(actual));
    }
}