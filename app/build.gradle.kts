import java.util.Properties

plugins {
    id(ProjectProperties.Gradle.KOTLIN)
    id(ProjectProperties.Gradle.APPLICATION)
    id(ProjectProperties.Gradle.HILT)
    kotlin(ProjectProperties.Gradle.KAPT)
}

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())

android {
    namespace = ProjectProperties.Gradle.APP
    compileSdk = ProjectProperties.Versions.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = ProjectProperties.Gradle.APP
        minSdk = ProjectProperties.Versions.MIN_SDK_VERSION
        targetSdk = ProjectProperties.Versions.TARGET_SDK_VERSION
        versionCode = ProjectProperties.Versions.VERSION_CODE
        versionName = ProjectProperties.Versions.VERSION_NAME

        buildConfigField("String", "CHATGPT", "${properties["CHATGPT"]}")

        testInstrumentationRunner = ProjectProperties.TestProperties.TEST_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectProperties.Files.DEFAULT_PROGUARDFILES),
                ProjectProperties.Files.PROGUARDFILES
            )
        }
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    //hilt
    implementation(Dependency.Google.HILT_ANDROID)
    kapt(Dependency.Google.HILT_ANDROID_COMPILER)

    //coil
    implementation(Dependency.Image.COIL)

    //aac
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependency.Navigation.NAVIGATION)

    //compose
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_TOOLING)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    implementation(Dependency.Compose.COMPOSE_MATERIAL3)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)

    //junit
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO_CORE)
    androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)
    debugImplementation(Dependency.Test.COMPOSE_MANIFEST)

    //accompanist
    implementation(Dependency.Google.ACCOMPANIST)
    implementation(Dependency.Google.ACCOMPANIST_PERMISSION)

    //retrofit
    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.RETROFIT_CONVERTER_GSON)

    //okhttp
    implementation(Dependency.Libraries.OKHTTP)
    implementation(Dependency.Libraries.OKHTTP_LOGGING_INTERCEPTOR)
}