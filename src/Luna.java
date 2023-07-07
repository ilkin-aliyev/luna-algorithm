public class Luna {
    public static void main(String[] args) {
        System.out.println(isValidPan("4893470318851588"));
    }

    private static boolean isValidPan(String pan) {
        if (pan.length() != 16) return false;

        var sum = 0;
        var oddDigit = true;

        for (int i = 0; i < 16; i++) {
            var digit = pan.charAt(i) - '0';

            if (oddDigit) {
                sum += getDoubleDigitSum(digit);
                oddDigit = false;
            } else {
                sum += digit;
                oddDigit = true;
            }
        }

        return sum % 10 == 0;
    }

    private static int getDoubleDigitSum(int digit) {
        var doubled = digit * 2;
        return doubled % 10 + doubled / 10;
    }
}
