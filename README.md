# EKAMBANI M-Pesa Reader – starter Android project

This is an Android Studio / Gradle starter project, **not an APK**.

## Current sample behaviour
- Requests Android SMS receive permission.
- Locally detects incoming SMS broadcasts.
- Performs a basic sender-ID filter for M-Pesa-like messages.
- Does not read unrelated messages into a backend.
- Does not upload SMS, verify payments, or generate renewal codes.

## Build
Open this folder in Android Studio and build the `app` debug variant, or push it to a GitHub repository and run the included Actions workflow. The workflow publishes a debug APK artifact.

## Before real EKAMBANI integration
1. Confirm the exact sender ID and genuine Safaricom SMS formats from sample messages (hide phone numbers and personal details).
2. Implement encrypted local pending storage and retryable HTTPS sync.
3. Add authenticated backend requests and server-side replay/duplicate protection.
4. Match payment to a pending Device ID and expected amount.
5. Verify payment independently where possible. Never issue a renewal code solely because an SMS text looks genuine.
6. Review Android SMS permission policy before distributing through Google Play. The sample targets API 28 to demonstrate the SMS broadcast receiver; this is not a recommendation for public Play Store release.
