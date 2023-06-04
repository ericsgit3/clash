import com.github.kr328.golang.GolangBuildTask
import com.github.kr328.golang.GolangPlugin
import java.io.FileOutputStream
import java.time.Duration

plugins {
    kotlin("android")
    id("com.android.library")
    id("kotlinx-serialization")
    id("golang-android")
}
