# 🔐 Keystore Information for GitHub Secrets

## GitHub Repository Secrets Configuration

Add these secrets to your repository at:
**Settings → Secrets and variables → Actions → New repository secret**

### 1. KEYSTORE_BASE64
Copy the entire content from `keystore_base64.txt` file

### 2. KEYSTORE_PASSWORD
```
palestine2024
```

### 3. KEY_ALIAS
```
palestine-key
```

### 4. KEY_PASSWORD
```
palestine2024
```

## Important Notes

- ⚠️ **NEVER** commit the `.jks` file to the repository
- The keystore file (`palestine-release-key.jks`) has been generated locally
- The base64 encoded version is in `keystore_base64.txt`
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