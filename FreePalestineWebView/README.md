# Free Palestine WebView App 🇵🇸

تطبيق Android WebView تم إنشاؤه باستخدام Jetpack Compose و Material 3 لعرض موقع Free Palestine.

## المميزات

- 🎨 تصميم حديث باستخدام Material 3 Design System
- 🚀 مبني بالكامل باستخدام Jetpack Compose
- 🌐 WebView محسّن مع دعم JavaScript
- 🎭 دعم الوضع الليلي والنهاري
- ⚡ انيميشن سلسة وتجربة مستخدم ممتازة
- 🔄 أزرار التنقل (رجوع، إلى الأمام، تحديث)
- 📱 دعم جميع أحجام الشاشات

## المتطلبات

- Android Studio Arctic Fox أو أحدث
- Android SDK 34
- Kotlin 1.9.20
- Gradle 8.2.0

## التثبيت والتشغيل

1. قم بنسخ المشروع:
```bash
git clone <repository-url>
cd FreePalestineWebView
```

2. افتح المشروع في Android Studio

3. قم بتحديث مسار Android SDK في `local.properties`:
```properties
sdk.dir=/path/to/your/android/sdk
```

4. قم بمزامنة المشروع مع Gradle

5. شغل التطبيق على المحاكي أو جهاز حقيقي

## البنية التقنية

### التقنيات المستخدمة:
- **Jetpack Compose**: لبناء واجهة المستخدم
- **Material 3**: نظام التصميم الحديث من Google
- **Accompanist WebView**: مكتبة WebView لـ Compose
- **Kotlin Coroutines**: للعمليات غير المتزامنة

### هيكل المشروع:
```
app/
├── src/main/java/com/example/freepalestinewebview/
│   ├── MainActivity.kt          # النشاط الرئيسي
│   ├── WebViewScreen.kt        # شاشة WebView Composable
│   └── ui/theme/
│       ├── Color.kt            # ألوان Material 3
│       ├── Theme.kt            # إعدادات Theme
│       └── Type.kt             # Typography
└── src/main/res/
    ├── values/
    │   ├── strings.xml         # النصوص
    │   ├── colors.xml          # الألوان
    │   └── themes.xml          # Themes
    └── xml/
        └── ...                 # ملفات الإعدادات
```

## الأذونات المطلوبة

التطبيق يحتاج إلى الأذونات التالية:
- `INTERNET` - للوصول إلى الإنترنت
- `ACCESS_NETWORK_STATE` - لفحص حالة الشبكة
- `ACCESS_WIFI_STATE` - لفحص حالة WiFi

## التخصيص

### تغيير الرابط:
في `MainActivity.kt`:
```kotlin
WebViewScreen(url = "https://your-url-here.com")
```

### تغيير الألوان:
قم بتعديل الألوان في `Color.kt` لتخصيص مظهر التطبيق.

### تغيير اسم التطبيق:
في `strings.xml`:
```xml
<string name="app_name">Your App Name</string>
```

## الترخيص

هذا المشروع مفتوح المصدر ومتاح للاستخدام الحر.

## الدعم

للمساعدة أو الإبلاغ عن مشاكل، يرجى فتح Issue في GitHub.

---
صُنع بـ ❤️ لدعم فلسطين 🇵🇸