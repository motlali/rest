package alid;

import org.apache.commons.lang3.StringUtils;

public interface WriteNumber {
    static String toEnglishString(Integer value) {
        if (null == value || value >= 1_000_000 || value < 0) {
            throw new IllegalArgumentException("incorrect parameter " + value);
        }

        if (value.equals(0)) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();
        String stringValue = StringUtils.leftPad(String.valueOf(value), 6, "0");
        if (value >= 1_000) {
            String tenthThousandsValue = StringUtils.substring(stringValue, 1, 3);
            String hundredsToEnglishString = hundredsToEnglishString(stringValue.charAt(0));
            String tenthToEnglishString = tenthToEnglishString(tenthThousandsValue);
            result.append(hundredsToEnglishString)
                    .append(space(hundredsToEnglishString))
                    .append(tenthToEnglishString)
                    .append(space(tenthToEnglishString))
                    .append("thousand, ");
        }

        String tenthValue = StringUtils.substring(stringValue, 4, 6);
        String hundredsToEnglishString = hundredsToEnglishString(stringValue.charAt(3));
        String tenthToEnglishString = tenthToEnglishString(tenthValue);
        result.append(hundredsToEnglishString)
                .append(space(hundredsToEnglishString))
                .append(tenthToEnglishString);

        return StringUtils.capitalize(result.toString());
    }

    static String space(String value) {
        if (StringUtils.isNotBlank(value)) {
            return " ";
        } else {
            return "";
        }
    }

    static String hundredsToEnglishString(Character character) {
        String hundredsEnglishString = unitToEnglishString(character);
        if (hundredsEnglishString.isEmpty()) {
            return hundredsEnglishString;
        } else {
            return hundredsEnglishString + " hundred";
        }
    }

    static String tenthToEnglishString(String tenthString) {
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

    static String unitToEnglishString(Character character) {
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

    static String tenthToEnglishString(Character integer) {
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

    static String firstTenthToEnglishString(String integer) {
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
