public class Alphabet {

    public static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITS = "0123456789";
    public static final String SYMBOLS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    private final StringBuilder pool;

    public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean digitsIncluded, boolean symbolsIncluded) {
        pool = new StringBuilder();
        if (uppercaseIncluded) {
            pool.append(UPPER_CASE);
        }
        if (lowercaseIncluded) {
            pool.append(LOWER_CASE);
        }
        if (digitsIncluded) {
            pool.append(DIGITS);
        }
        if (symbolsIncluded) {
            pool.append(SYMBOLS);
        }
    }

    public String getAlphabet() {
        return pool.toString();
    }
}
