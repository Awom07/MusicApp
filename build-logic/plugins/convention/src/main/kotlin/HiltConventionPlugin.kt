
import com.maximillianleonov.musicmax.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.plugins.kotlin.kapt.get().pluginId)

        dependencies {
            add("implementation", libs.dagger.hilt.core)
            add("kapt", libs.dagger.hilt.compiler)
        }
    }
}
