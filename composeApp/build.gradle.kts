import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation("io.github.kdroidfilter:composemediaplayer:0.8.6")
            implementation("io.github.vinceglb:filekit-core:0.13.0")
            implementation("io.github.vinceglb:filekit-dialogs:0.13.0")
            implementation("io.github.vinceglb:filekit-dialogs-compose:0.13.0")
            implementation("io.github.vinceglb:filekit-coil:0.13.0")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}


