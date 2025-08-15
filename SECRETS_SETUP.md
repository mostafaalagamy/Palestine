# GitHub Secrets Setup

## Required Secrets for Signed APK

To enable signed APK builds in GitHub Actions, add these secrets to your repository:

### 1. Navigate to Repository Settings
- Go to your repository on GitHub
- Click on **Settings** → **Secrets and variables** → **Actions**

### 2. Add the Following Secrets

#### KEYSTORE_BASE64
- Your keystore file encoded in base64
- To encode your keystore:
  ```bash
  base64 -w 0 your-keystore.jks
  ```
- Copy the output and add it as the secret value

#### KEYSTORE_PASSWORD
- The password for your keystore

#### KEY_ALIAS
- The alias name for your signing key

#### KEY_PASSWORD
- The password for your signing key

#### GH_TOKEN (Optional)
- For creating releases automatically
- You can use the default `GITHUB_TOKEN` or create a personal access token

## Notes

- If secrets are not configured, the workflow will build an unsigned APK
- All secrets are encrypted and secure
- Never commit keystore files or passwords to the repository

## Example Values (DO NOT USE IN PRODUCTION)

These are example formats only:
- `KEYSTORE_BASE64`: (long base64 string)
- `KEYSTORE_PASSWORD`: your-secure-password
- `KEY_ALIAS`: your-key-alias
- `KEY_PASSWORD`: your-key-password