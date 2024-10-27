
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.maximillianleonov.musicmax.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class FirebaseConfigConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val googleServicesFile = rootProject.file("app/google-services.json")
        if (googleServicesFile.exists()) {
            with(pluginManager) {
                apply(libs.plugins.google.services.get().pluginId)
                apply(libs.plugins.firebase.crashlytics.get().pluginId)
            }
        }

        extensions.configure<BaseAppModuleExtension> {
            buildTypes {
                debug {
                    manifestPlaceholders["firebase_crashlytics_collection_enabled"] = false
                }

                release {
                    manifestPlaceholders["firebase_crashlytics_collection_enabled"] = true
                }

                getByName("benchmark") {
                    manifestPlaceholders["firebase_crashlytics_collection_enabled"] = false
                }
            }
        }
    }
}
