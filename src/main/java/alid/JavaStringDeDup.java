package alid;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
public interface JavaStringDeDup {
    static String deDup(String input, Integer maxSize) {
        String nonNullInput = Optional.ofNullable(input).orElse(StringUtils.EMPTY);//FIXME : not specified --> ask client before : default String empty
        Integer limit = Optional.ofNullable(maxSize).orElse(nonNullInput.length());

        return Arrays.stream(nonNullInput.split(""))
                .limit(limit)
                .filter(StringUtils::isNotBlank)//FIXME : not specified --> ask client before : don't take the blank char
                .map(StringUtils::lowerCase)//FIXME : not specified --> ask client before : working case insensitive (all lowercase output)
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }
}
