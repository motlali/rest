package alid;

import org.junit.jupiter.api.Assertions;


class JavaStringDeDupTest {

    @org.junit.jupiter.api.Test
    void Should_return_acehinstu_for_ceciestunechaine() {
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
    @org.junit.jupiter.api.Test
    void Should_return_acehinstu_for_ceCiEstunechaine_Case_Incensitiv() {
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
    @org.junit.jupiter.api.Test
    void Should_return_empty_String_for_null_input() {
        //Given
        String input = null;
        String expected = "";
        //When
        String result = JavaStringDeDup.deDup(input, null);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void Should_return_acehinstu_with_30_char_long_string() {
        //Given
        String input = "ceciestunechainececiestunechainececiestunechaineabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        String expected = "acehinstu";
        //When
        String result = JavaStringDeDup.deDup(input, 30);
        //Then
        Assertions.assertEquals(expected, result);
    }
}