This project is a cross-platform application developed with Kotlin Multiplatform and Compose Multiplatform. Below are the key aspects of the project:

<img height="550" src="https://github.com/user-attachments/assets/b924e57a-510a-4e4e-a022-1caef46543dc" />


---

## **Recipe App KMP Compose Multiplatform**

### **Description**
Recipe App is a cross-platform application that allows users to explore, search, and manage recipes. It is designed to run on multiple platforms (Android, iOS, Desktop) using Kotlin Multiplatform and Compose Multiplatform.

### **Main Features**
- **Recipe Management**: Allows adding, updating, deleting, and searching for recipes.
- **Favorites**: Users can mark recipes as favorites.
- **Authentication**: Includes login and logout flows.
- **Customizable Themes**: Support for light and dark themes with different contrast levels.
- **Navigation**: Navigation implementation using Compose Navigation.
- **Data Persistence**: Uses SQLDelight for local database management.
- **Cross-Platform Configuration**: Uses Multiplatform Settings to store configurations.

---

### **Project Structure**
The project is organized into cross-platform modules (`commonMain`) and platform-specific modules (`desktopMain`, `androidMain`, etc.). Below are the main directories:

- **`features/designSystem/theme`**: Contains the theme and color configuration for the user interface.
- **`features/common/data/database`**: Includes database access logic and custom adapters.
- **`features/common/data/models`**: Defines the data models used in the application.
- **`features/app/navigation`**: Implements navigation between screens.
- **`features/common/ui/components`**: Contains reusable components like loaders and error messages.
- **`di`**: Dependency injection configuration with Koin.

---

### **Technologies Used**
- **Kotlin Multiplatform**: For sharing logic across platforms.
- **Compose Multiplatform**: For building declarative user interfaces.
- **Koin**: For dependency injection.
- **SQLDelight**: For data persistence.
- **Coil**: For image loading.
- **KTOR Client**: For making HTTP requests.
- **Multiplatform Settings**: For storing cross-platform configurations.
- **Compose Navigation**: For screen navigation.

---

### **Theme Configuration**
The project includes support for light and dark themes with different contrast levels. Themes are defined in the `Theme.kt` file and applied using the `RecipeAppCMPTheme` function.

---

### **Dependency Injection**
Koin is used to manage dependencies. The JVM-specific configuration is located in the `KoinJvm.kt` file.

---

### **Data Persistence**
Data persistence is implemented with SQLDelight. The `DbHelper` class manages database creation and access. DAOs (`FavoriteRecipeDao`, `RecipeDao`) encapsulate database operations.

---

### **Navigation**
Navigation is implemented using Compose Navigation. The `AppNavHost.kt` file defines the routes and navigation graphs.

---

### **Reusable Components**
- **`Loader`**: Loading indicator.
- **`ErrorContent`**: Generic error message.

---

### **How to Run the Project**
1. **Prerequisites**:
    - Android Studio with Kotlin Multiplatform support.
    - JDK 11 or higher.
    - Gradle installed.

2. **Clone the repository**:
   ```bash
   git clone <REPOSITORY_URL>
   cd recipe-app-kmp
   ```

3. **Sync dependencies**:
   ```bash
   ./gradlew sync
   ```

4. **Run on Android**:
    - Select a virtual or physical device in Android Studio.
    - Click "Run."

5. **Run on Desktop**:
   ```bash
   ./gradlew :composeApp:run
   ```
