# MarketDataStream

**Real-Time Market Data Streaming & Charting App**

Android application demonstrating real-time market data streaming, dynamic charting, and clean architecture using Jetpack Compose, Kotlin Coroutines (Flow), Hilt for dependency injection, and a Charting component built from Canvas.

## 🚀 Features

- **Dashboard Screen**: Displays a list of assets (stocks & crypto).
- **Asset Details Screen**: Shows a live-updating line chart of price history.
- **Real-Time Streaming**: Simulated WebSocket feed of `PriceTick` events.
- **Historical Data Fetch**: Initial loading of past price ticks.
- **Compose UI**: Fully built with Jetpack Compose (Material3).
- **Clean Architecture**: Separation of concerns into `domain`, `data`, and `ui` modules.
- **Dependency Injection**: Hilt for DI across ViewModels, UseCases, and Repositories.
- **Kotlin Version Catalog**: Centralized dependency versions in `libs.versions.toml`.

## 📂 Project Structure

```
MarketDataStream/
├── app/                      # Android application module
├── feature/
│   ├── dashboard/
│   │   ├── ui/               # Compose dashboard screen
│   │   └── domain/           # Dashboard use cases
│   └── asset-details/
│       ├── ui/               # Compose asset details screen & chart
│       ├── domain/           # UseCases and UI models
│       └── data/             # Repositories, remote/local/WebSocket sources
├── build-logic/              # Convention plugins (optional)
└── settings.gradle.kts       # Includes modules & version catalog
```

## 🛠️ Prerequisites

- Android Studio Flamingo or later
- JDK 17+
- Gradle 8.9+
- Android SDK & emulator/device (minSdk 26)

## ⚙️ Setup & Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/iAbdulmajeedAlyafey/MarketDataStream.git
   cd MarketDataStream
   ```

2. **Open in Android Studio**

   - Import the project (`settings.gradle.kts`).
   - Let Gradle sync and download dependencies.

3. **Build & Run**

   - Select the `app` module and your emulator/device.
   - Click **Run** or execute:
     ```bash
     ./gradlew :app:installDebug
     ```

## 🏗️ Architecture Overview

- **Domain Layer** (`feature/.../domain`)

  - `UseCase`s exposing Flows of `PriceTick` and `List<PriceTick>`.
  - UI state models: `AssetDetailsUiState`, `DashboardUiState`.

- **Data Layer** (`feature/.../data`)

  - `AssetDataRemoteSource` (REST), `AssetDataLocalSource` (cache), `AssetDataWebSocketSource`.
  - `AssetDataRepositoryImpl`: orchestrates sources and maps to domain models.

- **UI Layer** (`feature/.../ui`)

  - Compose screens: `DashboardScreen`, `AssetDetailsScreen`.
  - Custom `LineChart` composable using `Canvas` and `drawPath`.
  - `MarketNavHost` for navigation using Jetpack Compose Navigation.
  - Hilt `@HiltViewModel` for ViewModels.
 
  - <img width="867" alt="image" src="https://github.com/user-attachments/assets/e1998367-f2e4-4e95-bc5d-0b948b108553" />


## ✨ Technologies

- **Kotlin** 2.0.21
- **Jetpack Compose** (BOM `2025.06.00`)
- **Compose Material3**, **Navigation**, **Lifecycle-ViewModel-Compose**
- **Kotlin Coroutines & Flow**
- **Hilt** + **KAPT** for DI
- **Version Catalog** (`libs.versions.toml`)

## 📈 Demo

&#x20;

> For demo purposes, data is simulated with a fake WebSocket source and static historical snapshot.


