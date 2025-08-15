#!/bin/bash

# Generate keystore for signing the app
echo "🔐 Generating keystore for Palestine app..."

# Generate keystore
keytool -genkey -v -keystore palestine-release-key.jks \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias palestine-key \
  -dname "CN=Free Palestine, OU=Palestine, O=Palestine, L=Gaza, ST=Palestine, C=PS" \
  -storepass palestine2024 \
  -keypass palestine2024

echo ""
echo "✅ Keystore generated successfully!"
echo ""
echo "📋 Keystore Information:"
echo "========================"
echo "File: palestine-release-key.jks"
echo "Alias: palestine-key"
echo "Store Password: palestine2024"
echo "Key Password: palestine2024"
echo ""
echo "🔑 To add to GitHub Secrets:"
echo "============================"
echo ""
echo "1. KEYSTORE_BASE64 - Run this command to get base64 encoded keystore:"
echo "   base64 -w 0 palestine-release-key.jks"
echo ""
echo "2. KEYSTORE_PASSWORD: palestine2024"
echo ""
echo "3. KEY_ALIAS: palestine-key"
echo ""
echo "4. KEY_PASSWORD: palestine2024"
echo ""
echo "📌 Add these secrets in your GitHub repository:"
echo "   Settings → Secrets and variables → Actions → New repository secret"
echo ""
echo "⚠️  IMPORTANT: Keep your keystore file safe and never commit it to git!"