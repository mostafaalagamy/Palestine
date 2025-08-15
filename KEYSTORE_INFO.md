# 🔐 Keystore Information for GitHub Secrets

## Generate Your Own Keystore

First, generate a keystore file locally:

```bash
keytool -genkey -v -keystore release-key.jks \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias my-key-alias
```

Then convert it to base64:

```bash
base64 -w 0 release-key.jks > keystore_base64.txt
```

## GitHub Repository Secrets Configuration

Add these secrets to your repository at:
**Settings → Secrets and variables → Actions → New repository secret**

### Required Secrets:

1. **KEYSTORE_BASE64**
   - The base64 encoded content of your keystore file
   - Get it by running: `base64 -w 0 your-keystore.jks`

2. **KEYSTORE_PASSWORD**
   - The password you used when creating the keystore

3. **KEY_ALIAS**
   - The alias you used when creating the keystore

4. **KEY_PASSWORD**
   - The key password (usually same as keystore password)

## Important Notes

- ⚠️ **NEVER** commit the `.jks` file to the repository
- Keep your keystore file and passwords secure
- These credentials are required for building signed Release APKs
- Debug APKs will build without these secrets

## Verification

After adding the secrets, you can trigger the workflow manually:
1. Go to Actions tab
2. Select "Build Palestine App" workflow
3. Click "Run workflow"
4. Check the artifacts for both Debug and Release APKs

---

**Free Palestine** 🇵🇸