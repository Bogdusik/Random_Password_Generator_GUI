import java.util.Random;

/**
 * Generates random passwords based on selected character sets.
 */
public class PasswordGenerator {
    /** Characters used for password generation. */
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = LOWERCASE_CHARACTERS.toUpperCase();
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    // the random class allows us to generate a random number which will be used to randomly choose the characters
    private final Random random;

    // constructor
    public PasswordGenerator(){
        random = new Random();
    }

    /**
     * Generates a random password based on the specified criteria.
     * 
     * @param length The desired password length (must be greater than 0)
     * @param includeUppercase Whether to include uppercase letters
     * @param includeLowercase Whether to include lowercase letters
     * @param includeNumbers Whether to include numbers
     * @param includeSpecialSymbols Whether to include special symbols
     * @return Generated password string, or empty string if no character sets are selected
     * @throws IllegalArgumentException if length is less than or equal to 0
     */
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols) {
        // Validate input
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        // Use StringBuilder for better efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        // Build valid character set based on user preferences
        StringBuilder validCharactersBuilder = new StringBuilder();
        if (includeUppercase) {
            validCharactersBuilder.append(UPPERCASE_CHARACTERS);
        }
        if (includeLowercase) {
            validCharactersBuilder.append(LOWERCASE_CHARACTERS);
        }
        if (includeNumbers) {
            validCharactersBuilder.append(NUMBERS);
        }
        if (includeSpecialSymbols) {
            validCharactersBuilder.append(SPECIAL_SYMBOLS);
        }

        String validCharacters = validCharactersBuilder.toString();

        // Return empty string if no character sets are selected
        if (validCharacters.isEmpty()) {
            return "";
        }

        // Generate password by randomly selecting characters from the valid set
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }

        return passwordBuilder.toString();
    }
}
