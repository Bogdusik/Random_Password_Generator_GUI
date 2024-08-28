import java.util.Random;

// this class work as the backend and will generate thr password
public class PasswordGenerator {
    // character pools
    // these strings will hold the characters/symbols that we are going randomly pick to generate our password
    public static final String LOWERCASE_CHARACTERS = "sdkjfnskdjfnsssfn";
    public static final String UPPERCASE_CHARACTERS = "SDFKFIEJXHEUUDNWS";
    public static final String NUMBERS = "12382348289";
    public static final String SPECIAL_SYMBOLS = "!*4*£*(@(0£@)(${}304_+£)(@";

    // the random class allows us to generate a random number which will be used to randomly choose the characters
    private final Random random;

    // constructor
    public PasswordGenerator(){
        random = new Random();
    }

    // length - length of the password to be generated (taken from the user)
    // includeUppercase and etc... consider if the password should include uppercase, lowercase, etc... (taken from the user)
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
        // we will use builder over string for better efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        // string valid characters (toggle states)
        String validCharacters = "";
        if(includeLowercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        // build password
        for(int i = 0; i < length; i++){

            // generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            // get the char based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            // store char into password builder
            passwordBuilder.append(randomChar);

            // do this until we have reached the length that the user has provided to us
        }

        // return the result
        return passwordBuilder.toString();

    }
}
