import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stringer {

    /**
     *
     * @param hex
     * @return
     */
    public static String unaccent(final String hex) {
        return Normalizer.normalize(hex, Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     *
     * @param hex
     * @return
     */
    public static boolean isValidName(final String hex) {
        final String VALID_NAME_PATTERN = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$";
        return stringMatcher(hex, VALID_NAME_PATTERN);
    }

    /**
     *
     * @param hex
     * @param from
     * @param to
     * @return
     */
    public static boolean isInRange(final String hex, final String from, final String to) {
        String RANGE_PATTERN = "^(1[0-8]|[1-9])$";
        Pattern pattern = Pattern.compile(RANGE_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    /**
     *
     * @param hex
     * @param stringPattern
     * @return
     */
    private static boolean stringMatcher(final String hex, final String stringPattern) {
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
