# Raitha Vartha

Raitha Vartha is a smart farming advisory Android application designed to help farmers access crop-related tips, disease guidance, and farming recommendations through a simple mobile interface. The app focuses on presenting agricultural advisory information in an organized, farmer-friendly format with support for both English and Kannada content.

## Project Overview

The project was developed as part of an internship under the title **Android App Development Using Gen AI** at **MindMatrix.io (CL Infotech Pvt. Ltd.)**. Raitha Vartha provides crop advisory information for commonly grown crops such as Paddy, Tomato, Coconut, Areca Nut, Maize, and Ragi. The application uses a modern Android development stack and follows a clean project structure based on MVVM architecture.

The main goal of the application is to make farming advisory information easier to view, search, filter, and save. The interface is designed with large readable text, crop images, card-based layouts, and simple navigation so that farmers can use the app comfortably.

## Key Features

- **Login Screen**: Allows farmers to enter their name and password to access the application.
- **Home Dashboard**: Displays welcome text, weather-style advisory information, crop filters, and today’s farming tips.
- **Crop Advisory Flashcards**: Shows crop image, crop name, category, advisory title, tip text, and save option.
- **Crop Filter**: Allows users to view advisories for a selected crop.
- **Search Screen**: Supports searching by crop name, disease keyword, category, or farming tip.
- **Ask Expert Screen**: Provides a UI where farmers can describe crop problems and upload an image placeholder for future expert support.
- **Saved Tips Page**: Displays bookmarked advisories for later reference.
- **Farmer Profile Page**: Shows farmer details such as name, mobile number, district, taluk, and preferred language.
- **Bottom Navigation**: Provides quick navigation between Home, Search, Expert, Saved, and Profile screens.
- **Advisory Detail Page**: Displays detailed advisory information including summary, dosage, weather condition, and advisory source.

## Tech Stack Used

| Technology | Purpose |
|---|---|
| Kotlin | Used for Android application development and app logic implementation. |
| Jetpack Compose | Used for building modern declarative UI screens. |
| Material 3 | Used for cards, buttons, text fields, filter chips, and navigation components. |
| Navigation Compose | Used for navigating between multiple app screens. |
| MVVM Architecture | Used to separate UI, data models, and application logic. |
| Coil | Used for loading crop images in advisory cards and detail screens. |
| Gradle Kotlin DSL | Used for project configuration and dependency management. |
| Android Studio | Used for development, testing, and debugging. |

## App Screens

The application contains the following major screens:

1. Login Screen
2. Home Dashboard
3. Search Tips Screen
4. Ask Expert Screen
5. Saved Tips Screen
6. Farmer Profile Screen
7. Advisory Detail Screen

## Architecture

Raitha Vartha follows the **MVVM (Model-View-ViewModel)** architecture pattern.

### Model

The Model layer contains data classes such as:

- `Advisory`
- `FarmerProfile`

These classes define the structure of crop advisory data and farmer profile information.

### View

The View layer is built using Jetpack Compose. It contains UI screens such as:

- `LoginScreen`
- `HomeScreen`
- `SearchScreen`
- `AskExpertScreen`
- `SavedTipsScreen`
- `ProfileScreen`
- `AdvisoryDetailScreen`

### ViewModel

The ViewModel layer manages UI state and application logic. It handles:

- Farmer login name
- Crop filter selection
- Search query updates
- Saved/bookmarked advisories
- Expert problem text
- Advisory lookup by ID

## Project Structure

```text
RaithaVartha2.0/
├── app/
│   ├── src/main/
│   │   ├── java/com/raithavartha/app/
│   │   │   ├── data/
│   │   │   ├── model/
│   │   │   ├── navigation/
│   │   │   ├── screens/
│   │   │   ├── ui/
│   │   │   ├── viewmodel/
│   │   │   └── MainActivity.kt
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Crop Advisory Information

The app presents advisory content inspired by Krishi Vigyan Kendra and government agricultural advisory formats. The advisories are organized by crop and category so users can quickly understand the recommendation.

Included crops:

- Paddy / ಅಕ್ಕಿ
- Tomato / ಟೊಮೇಟೊ
- Coconut / ತೆಂಗು
- Areca Nut / ಅಡಿಕೆ
- Maize / ಜೋಳ
- Ragi / ರಾಗಿ

Example advisory:

> Maintain shallow water in young paddy. Keep 2-3 cm standing water after transplanting and drain excess water after heavy rain.

## Functional Flow

1. The user opens the app and logs in using the farmer login screen.
2. The Home screen displays crop advisory flashcards and weather-style advisory information.
3. The user can filter advisories based on crop type.
4. The user can search advisories using crop names, disease keywords, or farming tips.
5. The user can save important advisories for later reference.
6. The Ask Expert screen allows the user to describe a crop-related problem.
7. The Profile screen displays farmer information and app-related user details.

## How to Run the Project

1. Clone or download the repository.
2. Open the project in Android Studio.
3. Wait for Gradle Sync to complete.
4. Select an Android Emulator or connect a real Android device.
5. Click **Run** to build and launch the application.

## Requirements

- Android Studio
- Kotlin support
- Android SDK
- Gradle
- Android Emulator or physical Android device

## Output Summary

The Raitha Vartha application was successfully developed and tested in Android Studio. The app displays all major screens correctly, including login, home dashboard, advisory flashcards, search, ask expert, saved tips, profile, and detail pages. Crop filtering, search functionality, screen navigation, and saved tips functionality worked as expected during testing.

## Learning Outcomes

Through this project, the following learning outcomes were achieved:

- Learned Android app development using Kotlin and Jetpack Compose.
- Gained practical experience with Material 3 UI components.
- Understood screen navigation using Navigation Compose.
- Applied MVVM architecture for clean project organization.
- Learned state management for search, filters, and saved tips.
- Used Coil for loading crop images in Compose UI.
- Improved debugging and testing skills using Android Studio and Android Emulator.
- Learned how to organize and upload an Android project to GitHub.

## Future Enhancements

- Firebase integration for real-time advisory storage.
- Weather API integration for live weather updates.
- Expert consultation with backend support.
- Voice-based advisory playback.
- AI-based crop disease detection from uploaded images.
- Offline storage support using Room Database.

## Conclusion

Raitha Vartha demonstrates how mobile technology can be used to support farmers by presenting crop advisory information in a clean, bilingual, and easy-to-use Android application. The project provides a strong foundation for future smart agriculture features and showcases practical implementation of modern Android development concepts.
