# **Recipe App KMP Compose Multiplatform** 🍲

> Una aplicación multiplataforma de recetas desarrollada con Kotlin Multiplatform y Compose Multiplatform.

<p align="center">
  <img height="550" src="https://github.com/user-attachments/assets/b924e57a-510a-4e4e-a022-1caef46543dc" />
</p>

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.5.0-green.svg)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## **📝 Descripción**

Recipe App es una aplicación multiplataforma que permite a los usuarios explorar, buscar y gestionar recetas culinarias. Diseñada para funcionar en múltiples plataformas (Android, iOS, Desktop) utilizando Kotlin Multiplatform y Compose Multiplatform, ofrece una experiencia de usuario consistente y fluida en todos los dispositivos.

## **✨ Características Principales**

- **🍽️ Gestión de Recetas**: Permite añadir, actualizar, eliminar y buscar recetas de forma intuitiva.
- **❤️ Favoritos**: Los usuarios pueden marcar recetas como favoritas para acceder rápidamente a ellas.
- **🔐 Autenticación**: Incluye flujos completos de inicio de sesión y cierre de sesión.
- **🎨 Temas Personalizables**: Soporte para temas claros y oscuros con diferentes niveles de contraste.
- **🧭 Navegación**: Implementación de navegación fluida utilizando Compose Navigation.
- **💾 Persistencia de Datos**: Utiliza SQLDelight para una gestión eficiente de la base de datos local.
- **⚙️ Configuración Multiplataforma**: Utiliza Multiplatform Settings para almacenar configuraciones en todas las plataformas.

---

## **💻 Estructura del Proyecto**

El proyecto está organizado en módulos multiplataforma (`commonMain`) y módulos específicos para cada plataforma (`desktopMain`, `androidMain`, `iosMain`, etc.). Esta arquitectura permite compartir código entre plataformas mientras se mantiene la capacidad de implementar funcionalidades específicas para cada una.

```
RecipeApp/
├── composeApp/           # Módulo principal de la aplicación
│   ├── commonMain/       # Código compartido entre plataformas
│   ├── androidMain/      # Código específico para Android
│   ├── desktopMain/      # Código específico para Desktop
│   └── iosMain/          # Código específico para iOS
├── androidApp/           # Punto de entrada para Android
├── desktopApp/           # Punto de entrada para Desktop
└── iosApp/               # Punto de entrada para iOS
```

### Directorios Principales

- **`features/designSystem/theme`**: Contiene la configuración de temas y colores para la interfaz de usuario.
- **`features/common/data/database`**: Incluye lógica de acceso a la base de datos y adaptadores personalizados.
- **`features/common/data/models`**: Define los modelos de datos utilizados en la aplicación.
- **`features/app/navigation`**: Implementa la navegación entre pantallas.
- **`features/common/ui/components`**: Contiene componentes reutilizables como indicadores de carga y mensajes de error.
- **`di`**: Configuración de inyección de dependencias con Koin.

---

## **📱 Tecnologías Utilizadas**

| Tecnología | Descripción | Versión |
|------------|-------------|--------|
| [**Kotlin Multiplatform**](https://kotlinlang.org/docs/multiplatform.html) | Permite compartir lógica entre plataformas | 1.9.0 |
| [**Compose Multiplatform**](https://www.jetbrains.com/lp/compose-multiplatform/) | Framework para construir interfaces de usuario declarativas | 1.5.0 |
| [**Koin**](https://insert-koin.io/) | Framework ligero de inyección de dependencias | 3.4.0 |
| [**SQLDelight**](https://cashapp.github.io/sqldelight/) | Generador de código SQL para persistencia de datos | 2.0.0 |
| [**Coil**](https://coil-kt.github.io/coil/) | Biblioteca de carga de imágenes para Kotlin | 2.4.0 |
| [**KTOR Client**](https://ktor.io/docs/client.html) | Cliente HTTP para realizar peticiones a APIs | 2.3.0 |
| [**Multiplatform Settings**](https://github.com/russhwolf/multiplatform-settings) | Almacenamiento de configuraciones multiplataforma | 1.0.0 |
| [**Compose Navigation**](https://developer.android.com/jetpack/compose/navigation) | Navegación entre pantallas en aplicaciones Compose | 2.7.0 |

---

## **🎨 Configuración de Temas**

La aplicación incluye soporte para temas claros y oscuros con diferentes niveles de contraste, permitiendo una experiencia de usuario personalizada y accesible.

```kotlin
// Ejemplo de uso del tema
RecipeAppCMPTheme(darkTheme = isDarkMode, dynamicColor = useDynamicColor) {
    // Contenido de la aplicación
}
```

Los temas están definidos en el archivo `Theme.kt` y se aplican utilizando la función `RecipeAppCMPTheme`. Esta función configura colores, tipografía y formas para toda la aplicación.

---

## **🔗 Inyección de Dependencias**

Koin se utiliza para gestionar dependencias en toda la aplicación. Esta biblioteca ligera facilita la separación de responsabilidades y mejora la testabilidad del código.

```kotlin
// Ejemplo de módulo Koin
val appModule = module {
    single { RecipeRepository(get()) }
    viewModel { RecipeViewModel(get()) }
}
```

La configuración específica para JVM se encuentra en el archivo `KoinJvm.kt`, mientras que la configuración común se define en módulos compartidos.

---

## **💾 Persistencia de Datos**

La persistencia de datos se implementa con SQLDelight, que proporciona una forma segura de tipo para trabajar con bases de datos SQLite.

```kotlin
// Ejemplo de consulta SQLDelight
select *
from Recipe
where id = ?;
```

La clase `DbHelper` gestiona la creación y acceso a la base de datos. Los DAOs (`FavoriteRecipeDao`, `RecipeDao`) encapsulan las operaciones de base de datos, proporcionando una API limpia para el resto de la aplicación.

---

## **🧭 Navegación**

La navegación se implementa utilizando Compose Navigation, permitiendo una transición fluida entre pantallas.

```kotlin
// Ejemplo de configuración de navegación
NavHost(navController = navController, startDestination = "home") {
    composable("home") { HomeScreen() }
    composable("recipe/{id}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")
        RecipeDetailScreen(id)
    }
}
```

El archivo `AppNavHost.kt` define las rutas y gráficos de navegación, centralizando la lógica de navegación de la aplicación.

---

## **🐛 Componentes Reutilizables**

La aplicación incluye varios componentes reutilizables para mantener la coherencia de la interfaz de usuario y reducir la duplicación de código:

- **`Loader`**: Indicador de carga animado que se muestra durante operaciones asíncronas.
- **`ErrorContent`**: Componente para mostrar mensajes de error con opciones de reintento.
- **`RecipeCard`**: Tarjeta para mostrar la información resumida de una receta.
- **`RatingBar`**: Componente para mostrar y capturar valoraciones de recetas.
- **`SearchBar`**: Barra de búsqueda personalizada para filtrar recetas.

---

## **🚀 Cómo Ejecutar el Proyecto**

### Requisitos Previos

- Android Studio Arctic Fox (2021.3.1) o superior con soporte para Kotlin Multiplatform
- JDK 11 o superior
- Gradle 7.6 o superior
- Para iOS: macOS con Xcode 14.1 o superior
- Para Web: Node.js 16 o superior

### Pasos para Ejecutar

#### 1. Clonar el Repositorio

```bash
git clone https://github.com/manuelduarte077/RecipeApp.git
cd RecipeApp
```

#### 2. Sincronizar Dependencias

```bash
./gradlew sync
```

#### 3. Ejecutar en Android

Opción 1: Desde Android Studio
- Abrir el proyecto en Android Studio
- Seleccionar un dispositivo virtual o físico
- Hacer clic en "Run"


#### 4. Ejecutar en Desktop

```bash
./gradlew :desktopApp:run
```

#### 5. Ejecutar en Web

```bash
./gradlew :composeApp:jsBrowserDevelopmentRun
```

Esto iniciará un servidor de desarrollo en `http://localhost:8080`
