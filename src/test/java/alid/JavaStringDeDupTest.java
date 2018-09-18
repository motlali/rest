package alid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JavaStringDeDupTest {

    @Test
    void should_return_acehinstu_for_ceciestunechaine() {
        //Given
        String input = "ceciestunechaine";
        String expected = "acehinstu";
        //When
        String result = JavaStringDeDup.deDup(input, null);
        //Then
        Assertions.assertEquals(expected, result);
    }

    /**
     * FIXME : not specified --> ask client before
     **/
    @Test
    void should_return_acehinstu_for_ceCiEstunechaine_Case_Incensitiv() {
        //Given
        String input = "ceCiEstunechaiNe";
        String expected = "acehinstu";
        //When
        String result = JavaStringDeDup.deDup(input, null);
        //Then
        Assertions.assertEquals(expected, result);
    }

    /**
     * FIXME : not specified --> ask client before
     **/
    @Test
    void Should_return_empty_String_for_null_input() {
        //Given
        String input = null;
        String expected = "";
        //When
        String result = JavaStringDeDup.deDup(input, null);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void Should_return_acehinstu_with_more_than_30_char_long_string() {
        //Given
        String input = "ceciestunechainececiestunechainececiestunechaineabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        String expected = "acehinstu";
        //When
        String result = JavaStringDeDup.deDup(input, 30);
        //Then
        Assertions.assertEquals(expected, result);
    }
}