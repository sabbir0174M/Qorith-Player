# Qorith – Offline-First Music Player

A premium, lightweight, offline music player for Android built with privacy and performance in mind.

## Features

- **Fully Offline**: No internet required, no cloud dependency
- **Privacy-First**: No analytics, no tracking, no user accounts
- **Fast & Lightweight**: Optimized for low-end Android devices
- **Folder-Based Organization**: Browse music by folder structure
- **Powerful Queue System**: Drag-and-drop reordering, queue management
- **Playlists & Favorites**: Create custom playlists and manage favorites
- **Multiple Themes**: AMOLED, Dark, Light, AMOLED Light
- **Material Design 3**: Modern, clean, professional UI
- **Media3 & ExoPlayer**: Robust audio playback

## Requirements

- Android 8.0+ (minSdk 26)
- Android Studio Hedgehog or newer
- Kotlin 1.9.20+

## Project Structure

```
app/
├── src/main/
│   ├── kotlin/com/qorithone/qorith/
│   │   ├── ui/                 # Compose screens
│   │   ├── viewmodel/          # ViewModels
│   │   ├── data/               # Data layer
│   │   │   ├── model/          # Data models
│   │   │   ├── dao/            # Room DAOs
│   │   │   ├── db/             # Database
│   │   │   ├── repository/     # Repositories
│   │   │   └── di/             # Dependency injection
│   │   ├── service/            # Services
│   │   └── util/               # Utilities
│   └── res/                    # Resources
├── build.gradle.kts            # App build config
└── proguard-rules.pro          # ProGuard rules
```

## Stack

- **Jetpack Compose**: UI framework
- **Material Design 3**: Design system
- **Kotlin Coroutines**: Async operations
- **Room Database**: Local data persistence
- **Hilt**: Dependency injection
- **Media3/ExoPlayer**: Audio playback
- **Navigation Compose**: Navigation

## Building

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Run on device/emulator
./gradlew installDebug
```

## Permissions

- `READ_EXTERNAL_STORAGE` – Read music files
- `WAKE_LOCK` – Keep device awake during playback
- `FOREGROUND_SERVICE` – Background audio playback

## Privacy

Qorith is completely offline:
- ✅ No user accounts
- ✅ No cloud sync
- ✅ No analytics
- ✅ No tracking
- ✅ No internet dependency
- ✅ No data collection

## License

Private – QorithOne

## Author

QorithOne

---

**Qorith** – Your music, your way.
