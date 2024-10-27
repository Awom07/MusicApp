
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.maximillianleonov.musicmax.configureAndroidCompose
import com.maximillianleonov.musicmax.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply(libs.plugins.android.application.get().pluginId)
        val extension = extensions.getByType<BaseAppModuleExtension>()
        configureAndroidCompose(extension)
    }
}
