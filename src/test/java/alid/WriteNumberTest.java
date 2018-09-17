package alid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WriteNumberTest {

    @Test
    void should_Return_English_String_Value_thousand() {
        // Given
        Integer input = 100_282;
        String expected = "One hundred thousand, two hundred eighty two";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_hundreds() {
        // Given
        Integer input = 282;
        String expected = "Two hundred eighty two";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_tenOfThouthands() {
        // Given
        Integer input = 110_282;
        String expected = "One hundred ten thousand, two hundred eighty two";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_ten() {
        // Given
        Integer input = 10;
        String expected = "Ten";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_nineTeen() {
        // Given
        Integer input = 19;
        String expected = "Nineteen";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_eleven() {
        // Given
        Integer input = 111_443;
        String expected = "One hundred eleven thousand, four hundred forty three";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_twelve() {
        // Given
        Integer input = 112_557;
        String expected = "One hundred twelve thousand, five hundred fifty seven";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_thirteen() {
        // Given
        Integer input = 113_669;
        String expected = "One hundred thirteen thousand, six hundred sixty nine";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_fourteen() {
        // Given
        Integer input = 114_771;
        String expected = "One hundred fourteen thousand, seven hundred seventy one";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }


    @Test
    void should_Return_English_String_Value_fifteen() {
        // Given
        Integer input = 115_337;
        String expected = "One hundred fifteen thousand, three hundred thirty seven";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_sixteen() {
        // Given
        Integer input = 116_999;
        String expected = "One hundred sixteen thousand, nine hundred ninety nine";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_seventeen() {
        // Given
        Integer input = 117_888;
        String expected = "One hundred seventeen thousand, eight hundred eighty eight";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_eighteen() {
        // Given
        Integer input = 118_222;
        String expected = "One hundred eighteen thousand, two hundred twenty two";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_Return_English_String_Value_zero() {
        // Given
        Integer input = 0;
        String expected = "Zero";
        //When
        String found = WriteNumber.toEnglishString(input);
        //Then
        Assertions.assertEquals(expected, found);
    }

    @Test
    void should_throws_exception_on_null_value() {

        assertThrows(IllegalArgumentException.class, () -> WriteNumber.toEnglishString(null));
    }

    @Test
    void should_throws_exception_on_negative_value() {

        assertThrows(IllegalArgumentException.class, () -> WriteNumber.toEnglishString(-1));
    }

    @Test
    void should_throws_exception_on_bad_value() {

        assertThrows(IllegalArgumentException.class, () -> WriteNumber.toEnglishString(1_000_000));
    }
}