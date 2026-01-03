import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PasswordGenerator class.
 */
@DisplayName("PasswordGenerator Tests")
class PasswordGeneratorTest {
    private PasswordGenerator passwordGenerator;

    @BeforeEach
    void setUp() {
        passwordGenerator = new PasswordGenerator();
    }

    @Test
    @DisplayName("Should generate password with lowercase letters only")
    void testGeneratePasswordWithLowercaseOnly() {
        String password = passwordGenerator.generatePassword(10, false, true, false, false);
        
        assertNotNull(password);
        assertEquals(10, password.length());
        assertTrue(password.matches("[a-z]+"));
    }

    @Test
    @DisplayName("Should generate password with uppercase letters only")
    void testGeneratePasswordWithUppercaseOnly() {
        String password = passwordGenerator.generatePassword(15, true, false, false, false);
        
        assertNotNull(password);
        assertEquals(15, password.length());
        assertTrue(password.matches("[A-Z]+"));
    }

    @Test
    @DisplayName("Should generate password with numbers only")
    void testGeneratePasswordWithNumbersOnly() {
        String password = passwordGenerator.generatePassword(8, false, false, true, false);
        
        assertNotNull(password);
        assertEquals(8, password.length());
        assertTrue(password.matches("[0-9]+"));
    }

    @Test
    @DisplayName("Should generate password with special symbols only")
    void testGeneratePasswordWithSpecialSymbolsOnly() {
        String password = passwordGenerator.generatePassword(12, false, false, false, true);
        
        assertNotNull(password);
        assertEquals(12, password.length());
        assertTrue(password.matches("[!@#$%^&*()\\-_=+\\[\\]{}|;:'\",.<>?/]+"));
    }

    @Test
    @DisplayName("Should generate password with all character types")
    void testGeneratePasswordWithAllCharacterTypes() {
        String password = passwordGenerator.generatePassword(20, true, true, true, true);
        
        assertNotNull(password);
        assertEquals(20, password.length());
        // Verify password contains only valid characters from all allowed sets
        // Note: We don't guarantee all types are present due to randomness,
        // but we verify the password only contains valid characters
        assertTrue(password.matches("^[a-zA-Z0-9!@#$%^&*()\\-_=+\\[\\]{}|;:'\",.<>?/]+$"));
    }

    @Test
    @DisplayName("Should return empty string when no character types are selected")
    void testGeneratePasswordWithNoCharacterTypes() {
        String password = passwordGenerator.generatePassword(10, false, false, false, false);
        
        assertNotNull(password);
        assertEquals("", password);
    }

    @Test
    @DisplayName("Should throw exception for zero length")
    void testGeneratePasswordWithZeroLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            passwordGenerator.generatePassword(0, true, true, true, true);
        });
    }

    @Test
    @DisplayName("Should throw exception for negative length")
    void testGeneratePasswordWithNegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            passwordGenerator.generatePassword(-5, true, true, true, true);
        });
    }

    @Test
    @DisplayName("Should generate passwords of correct length on consecutive calls")
    void testGeneratePasswordConsistency() {
        String password1 = passwordGenerator.generatePassword(20, true, true, true, true);
        String password2 = passwordGenerator.generatePassword(20, true, true, true, true);
        
        // Verify both passwords are generated correctly
        assertNotNull(password1);
        assertNotNull(password2);
        assertEquals(20, password1.length());
        assertEquals(20, password2.length());
        // Verify passwords contain valid characters
        assertTrue(password1.matches(".*[a-zA-Z0-9!@#$%^&*()\\-_=+\\[\\]{}|;:'\",.<>?/].*"));
        assertTrue(password2.matches(".*[a-zA-Z0-9!@#$%^&*()\\-_=+\\[\\]{}|;:'\",.<>?/].*"));
    }

    @Test
    @DisplayName("Should generate password with mixed character types")
    void testGeneratePasswordWithMixedTypes() {
        String password = passwordGenerator.generatePassword(16, true, true, true, false);
        
        assertNotNull(password);
        assertEquals(16, password.length());
        // Verify password contains only allowed character types (letters and numbers, no special symbols)
        assertTrue(password.matches("^[a-zA-Z0-9]+$"));
    }

    @Test
    @DisplayName("Should handle minimum length of 1")
    void testGeneratePasswordWithMinimumLength() {
        String password = passwordGenerator.generatePassword(1, true, false, false, false);
        
        assertNotNull(password);
        assertEquals(1, password.length());
        assertTrue(password.matches("[A-Z]"));
    }

    @Test
    @DisplayName("Should handle large password length")
    void testGeneratePasswordWithLargeLength() {
        String password = passwordGenerator.generatePassword(100, true, true, true, true);
        
        assertNotNull(password);
        assertEquals(100, password.length());
    }
}

