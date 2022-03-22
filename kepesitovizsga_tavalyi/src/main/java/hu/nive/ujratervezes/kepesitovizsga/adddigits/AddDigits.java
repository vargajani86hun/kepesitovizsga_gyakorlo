package hu.nive.ujratervezes.kepesitovizsga.adddigits;

public class AddDigits {
    public int addDigits(String input) {
        if (input == null || input.isEmpty()) return -1;

        int sum = 0;
        for (Character c: input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Integer.parseInt(c.toString());
            }
        }
        return sum;
    }
}
