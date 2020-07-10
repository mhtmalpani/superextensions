# SuperExtensions

![Android CI](https://github.com/mhtmalpani/superextensions/workflows/Android%20CI/badge.svg)

## Download:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```gradle
dependencies {
    implementation 'com.github.mhtmalpani:superextensions:0.2.0'
}
```