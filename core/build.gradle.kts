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
golang {
    sourceSets {
        create("foss") {
            tags.set(listOf("foss"))
            srcDir.set(file("src/foss/golang"))
        }
        create("premium") {
            tags.set(listOf("premium", "without_gvisor", "without_system"))
            srcDir.set(file("src/premium/golang"))
        }
