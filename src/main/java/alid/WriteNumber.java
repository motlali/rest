package alid;

import org.apache.commons.lang3.StringUtils;

/**
 * Spring Boot (Rest) - algorithm
 */
public class WriteNumber {

    public static String toEnglishString(Integer value) {
        //FIXME : Not specified : only integer positive values under 1_000_000
        if (null == value || value >= 1_000_000 || value < 0) {
            throw new IllegalArgumentException("incorrect parameter " + value);
        }

        // FIXME : not specified : special case zero
        if (value.equals(0)) {
            return "Zero";
        }

        String digitalStringValue = StringUtils.leftPad(String.valueOf(value), 6, "0");

        return StringUtils.capitalize(
                hundredThousandsToEnglishString(value, digitalStringValue)
                        + hundredToEnglishString(digitalStringValue)
        );
    }

    private static String hundredToEnglishString(String digitalStringValue) {
        String tenthDigitalValue = StringUtils.substring(digitalStringValue, 4, 6);
        char hundredDigitalChar = digitalStringValue.charAt(3);
        return hundredsDigitalStringToEnglishString(hundredDigitalChar, tenthDigitalValue);
    }

    private static String hundredThousandsToEnglishString(Integer value, String digitalStringValue) {
        if (value >= 1_000) {
            String tenthThousandsDigitalValue = StringUtils.substring(digitalStringValue, 1, 3);
            char hundredDigitalChar = digitalStringValue.charAt(0);
            String tenthThousandsEnglishString = tenthToEnglishString(tenthThousandsDigitalValue);
            return new StringBuilder().append(hundredsDigitalStringToEnglishString(hundredDigitalChar, tenthThousandsDigitalValue))
                    .append(space(tenthThousandsEnglishString))
                    .append("thousand, ").toString();
        }
        return "";
    }

    private static String hundredsDigitalStringToEnglishString(char hundredDigitalChar, String tenthDigitalValue) {
        String hundredsEnglishString = hundredDigitalCharToEnglishString(hundredDigitalChar);
        String tenthToEnglishString = tenthToEnglishString(tenthDigitalValue);
        return new StringBuilder()
                .append(hundredsEnglishString)
                .append(space(hundredsEnglishString))
                .append(tenthToEnglishString).toString();
    }

    private static String space(String value) {
        if (StringUtils.isNotBlank(value)) {
            return " ";
        } else {
            return "";
        }
    }

    private static String hundredDigitalCharToEnglishString(Character character) {
        String hundredsEnglishString = unitToEnglishString(character);
        if (hundredsEnglishString.isEmpty()) {
            return hundredsEnglishString;
        } else {
            return hundredsEnglishString + " hundred";
        }
    }

    private static String tenthToEnglishString(String tenthString) {
        String unit = StringUtils.substring(tenthString, 1);
        String unitEnglishString = unitToEnglishString(unit.charAt(0));

        String tenth = StringUtils.substring(tenthString, 0, 1);
        if ("1".equalsIgnoreCase(tenth)) {
            return firstTenthToEnglishString(tenthString);
        } else if (unitEnglishString.isEmpty()) {
            return tenthToEnglishString(tenth.charAt(0));
        } else {
            return tenthToEnglishString(tenth.charAt(0)) + " " + unitEnglishString;
        }
    }

    private static String unitToEnglishString(Character character) {
        switch (character) {
            case '1':
                return "one";
            case '2':
                return "two";
            case '3':
                return "three";
            case '4':
                return "four";
            case '5':
                return "five";
            case '6':
                return "six";
            case '7':
                return "seven";
            case '8':
                return "eight";
            case '9':
                return "nine";
            default:
                return "";
        }
    }

    private static String tenthToEnglishString(Character integer) {
        switch (integer) {
            case '2':
                return "twenty";
            case '3':
                return "thirty";
            case '4':
                return "forty";
            case '5':
                return "fifty";
            case '6':
                return "sixty";
            case '7':
                return "seventy";
            case '8':
                return "eighty";
            case '9':
                return "ninety";
            default:
                return "";
        }
    }

    private static String firstTenthToEnglishString(String integer) {
        switch (integer) {
            case "10":
                return "ten";
            case "11":
                return "eleven";
            case "12":
                return "twelve";
            case "13":
                return "thirteen";
            case "14":
                return "fourteen";
            case "15":
                return "fifteen";
            case "16":
                return "sixteen";
            case "17":
                return "seventeen";
            case "18":
                return "eighteen";
            case "19":
                return "nineteen";
            default:
                return "";
        }
    }
}
