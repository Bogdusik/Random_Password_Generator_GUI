# 🔐 Random Password Generator GUI

![Java](https://img.shields.io/badge/Java-11-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.9-blue.svg)
![JUnit](https://img.shields.io/badge/JUnit-5-green.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)
![CI](https://github.com/Bogdusik/Random_Password_Generator_GUI/workflows/CI/badge.svg)

A simple and secure password generator application with a graphical user interface (GUI), built in Java using Swing. This application allows users to generate secure passwords based on their preferences for length, inclusion of uppercase letters, lowercase letters, numbers, and special symbols.

## ✨ Features

- **Customizable Password Length**: Set any password length from 1 to any desired value
- **Character Type Selection**: Toggle to include:
  - Uppercase letters (A-Z)
  - Lowercase letters (a-z)
  - Numbers (0-9)
  - Special symbols (!@#$%^&*()...)
- **Secure Random Generation**: Uses Java's `Random` class for cryptographically secure password generation
- **User-Friendly GUI**: Intuitive Swing-based interface
- **Input Validation**: Validates password length and character type selection
- **Error Handling**: Displays user-friendly error messages for invalid inputs

## 🛠️ Technologies Used

- **Java 11**: Main programming language
- **Java Swing**: GUI toolkit for building the user interface
- **Maven**: Build automation and dependency management
- **JUnit 5**: Unit testing framework
- **Docker**: Containerization support

## 📋 Prerequisites

- Java JDK 11 or higher
- Maven 3.6+ (optional, for building with Maven)
- Git

## 🚀 Getting Started

### Using Maven (Recommended)

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Bogdusik/Random_Password_Generator_GUI.git
   cd Random_Password_Generator_GUI
   ```

2. **Build the project:**
   ```bash
   mvn clean package
   ```

3. **Run the application:**
   ```bash
   java -jar target/random-password-generator-gui-1.0.0.jar
   ```
   
   Or using Maven:
   ```bash
   mvn exec:java -Dexec.mainClass="App"
   ```

### Using Java Compiler (Alternative)

1. **Navigate to the source directory:**
   ```bash
   cd src/main/java
   ```

2. **Compile the Java files:**
   ```bash
   javac App.java PasswordGenerator.java PasswordGeneratorGUI.java
   ```

3. **Run the application:**
   ```bash
   java App
   ```

## 🐳 Docker Support

### Build Docker Image

```bash
docker build -t password-generator .
```

### Run with Docker

**Note:** GUI applications in Docker require X11 forwarding. For Linux:

```bash
docker run -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix password-generator
```

For macOS/Windows, you may need additional X11 server setup.

## 🧪 Testing

Run the test suite using Maven:

```bash
mvn test
```

The project includes comprehensive unit tests covering:
- Password generation with different character types
- Input validation
- Edge cases (empty character sets, zero/negative length)
- Password uniqueness

## 📖 Usage

1. **Launch the application** using one of the methods above
2. **Enter the desired password length** in the input field (must be a positive integer)
3. **Select character types** by toggling the checkboxes:
   - Uppercase: Include capital letters (A-Z)
   - Lowercase: Include lowercase letters (a-z)
   - Numbers: Include digits (0-9)
   - Symbol: Include special characters (!@#$%...)
4. **Click the "Generate" button** to create the password
5. **Copy the generated password** from the output area

### Example

- Length: `16`
- Options: All toggles enabled
- Result: `K9#mP2@vL7$nQ4!x`

## 📁 Project Structure

```
Random_Password_Generator_GUI/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── App.java                    # Main entry point
│   │       ├── PasswordGenerator.java      # Password generation logic
│   │       └── PasswordGeneratorGUI.java   # GUI components
│   └── test/
│       └── java/
│           └── PasswordGeneratorTest.java # Unit tests
├── .github/
│   └── workflows/
│       └── ci.yml                          # CI/CD pipeline
├── Dockerfile                              # Docker configuration
├── pom.xml                                 # Maven configuration
└── README.md                               # This file
```

## 🔧 Development

### Building from Source

```bash
mvn clean compile
```

### Running Tests

```bash
mvn test
```

### Creating JAR

```bash
mvn clean package
```

The JAR file will be created in `target/random-password-generator-gui-1.0.0.jar`

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style

- Follow Java naming conventions
- Add Javadoc comments for public methods
- Write unit tests for new features
- Ensure all tests pass before submitting

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Bogdusik**

- GitHub: [@Bogdusik](https://github.com/Bogdusik)

## 🙏 Acknowledgments

- Built with Java Swing for cross-platform GUI support
- Uses Maven for modern Java project management
- Includes comprehensive testing with JUnit 5

---

⭐ If you find this project useful, please consider giving it a star!
