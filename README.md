[//]: # (![Musicmax]&#40;docs/images/musicmax-splash.svg&#41;)

[//]: # ()
[//]: # (# Musicmax)

[//]: # ()
[//]: # (Musicmax is a Music Player application for Android built with Jetpack Compose and Jetpack Media 3.)

[//]: # ()
[//]: # (<a href='https://play.google.com/store/apps/details?id=com.maximillianleonov.musicmax&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png' height='100' /></a>)

[//]: # ()
[//]: # (or get the apk from the [Releases section]&#40;https://github.com/MaximillianLeonov/Musicmax/releases/latest&#41;.)

[//]: # ()
[//]: # (# Preview)

[//]: # ()
[//]: # (<img src="docs/images/screenshot-1-home.png" width="25%"><img src="docs/images/screenshot-2-player.png" width="25%"><img src="docs/images/screenshot-3-artist.png" width="25%"><img src="docs/images/screenshot-4-album.png" width="25%">)

[//]: # (<img src="docs/images/screenshot-5-folder.png" width="25%"><img src="docs/images/screenshot-6-search.png" width="25%"><img src="docs/images/screenshot-7-favorite.png" width="25%"><img src="docs/images/screenshot-8-lock-screen.png" width="25%">)

[//]: # ()
[//]: # (# Development Environment)

[//]: # ()
[//]: # (**Musicmax** uses the Gradle build system and can be imported directly into the latest stable)

[//]: # (version of Android Studio &#40;available [here]&#40;https://developer.android.com/studio&#41;&#41;. The `debug`)

[//]: # (build can be built and run using the default configuration.)

[//]: # ()
[//]: # (# Build)

[//]: # ()
[//]: # (The app contains the usual `debug` and `release` build variants.)

[//]: # ()
[//]: # (In addition, the `benchmark` variant of `app` is used to test startup performance and generate a)

[//]: # (baseline profile &#40;see below for more information&#41;.)

[//]: # ()
[//]: # (For normal development use the `debug` variant. For UI performance testing use the `release`)

[//]: # (variant.)

[//]: # ()
[//]: # (# Architecture)

[//]: # ()
[//]: # (The **Musicmax** app follows the)

[//]: # ([official architecture guidance]&#40;https://developer.android.com/topic/architecture&#41;.)

[//]: # ()
[//]: # (![Architecture diagram]&#40;docs/images/architecture-graph.png&#41;)

[//]: # ()
[//]: # (# Modularization)

[//]: # ()
[//]: # (The **Musicmax** app has been fully modularized.)

[//]: # ()
[//]: # (# UI)

[//]: # ()
[//]: # (The app was designed using [Material 3 guidelines]&#40;https://m3.material.io/&#41;.)

[//]: # ()
[//]: # (The Screens and UI elements are built entirely)

[//]: # (using [Jetpack Compose]&#40;https://developer.android.com/jetpack/compose&#41;.)

[//]: # ()
[//]: # (The app has two themes:)

[//]: # ()
[//]: # (- Dynamic color - uses colors based on)

[//]: # (  the [user's current color theme]&#40;https://material.io/blog/announcing-material-you&#41; &#40;if supported&#41;)

[//]: # (- Default theme - uses predefined colors when dynamic color is not supported)

[//]: # ()
[//]: # (Each theme also supports dark mode.)

[//]: # ()
[//]: # (# Baseline profiles)

[//]: # ()
[//]: # (The baseline profile for this app is located)

[//]: # (at [`app/src/main/baseline-prof.txt`]&#40;app/src/main/baseline-prof.txt&#41;. It contains rules that enable)

[//]: # (AOT compilation of the critical user path taken during app launch. For more information on baseline)

[//]: # (profiles, read [this document]&#40;https://developer.android.com/studio/profile/baselineprofiles&#41;.)

[//]: # ()
[//]: # (> **Note**: The baseline profile needs to be re-generated for release builds that touch code which changes app startup.)

[//]: # ()
[//]: # (To generate the baseline profile, select the `benchmark` build variant and run the)

[//]: # (`BaselineProfileGenerator` benchmark test on an AOSP Android Emulator. Then copy the resulting)

[//]: # (baseline profile from the emulator)

[//]: # (to [`app/src/main/baseline-prof.txt`]&#40;app/src/main/baseline-prof.txt&#41;.)

[//]: # ()
[//]: # (# Localization)

[//]: # ()
[//]: # (**Musicmax** uses [Crowdin]&#40;https://crowdin.com/&#41; as a localization management platform and is available on Crowdin at [this link]&#40;https://crowdin.com/project/musicmax-android&#41;.)

[//]: # ()
[//]: # ([![Crowdin]&#40;https://badges.crowdin.net/musicmax-android/localized.svg&#41;]&#40;https://crowdin.com/project/musicmax-android&#41;)

[//]: # ()
[//]: # (# License)

[//]: # ()
[//]: # (```)

[//]: # (Copyright 2022 Afig Aliyev)

[//]: # ()
[//]: # (Licensed under the Apache License, Version 2.0 &#40;the "License"&#41;;)

[//]: # (you may not use this file except in compliance with the License.)

[//]: # (You may obtain a copy of the License at)

[//]: # ()
[//]: # (    http://www.apache.org/licenses/LICENSE-2.0)

[//]: # ()
[//]: # (Unless required by applicable law or agreed to in writing, software)

[//]: # (distributed under the License is distributed on an "AS IS" BASIS,)

[//]: # (WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.)

[//]: # (See the License for the specific language governing permissions and)

[//]: # (limitations under the License.)

[//]: # (```)
