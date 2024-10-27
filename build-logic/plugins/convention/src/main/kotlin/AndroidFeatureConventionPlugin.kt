
import com.maximillianleonov.musicmax.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("musicmax.android.library")
            apply("musicmax.android.library.compose")
            apply("musicmax.android.hilt")
        }

        dependencies {
            add("implementation", project(":core:core-ui"))

            add("implementation", libs.androidx.lifecycle.runtime.compose)
            add("implementation", libs.androidx.lifecycle.viewmodel.compose)
            add("implementation", libs.androidx.hilt.navigation.compose)
            add("implementation", libs.kotlinx.coroutines.android)
        }
    }
}
