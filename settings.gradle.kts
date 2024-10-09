pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ComposeIntro"
include(":app")
include(":app:selectabletext")
include(":app:box")
include(":app:ozellestirilmiscomposable")
include(":app:state")
include(":app:button")
include(":app:textfield")
include(":app:yenisayfaolusturma")
include(":app:sayfalar_arasi_veri_transferi")
include(":app:launched_effect")
include(":app:disposable_effect")
include(":app:side_effect")
include(":app:card")
include(":app:lazycolumn")
include(":app:lazyrow")
include(":app:lazygrid")
include(":app:icon-iconbutton")
include(":app:fabbutton")
include(":app:switch")
include(":app:checkbox")
include(":app:radiobutton")
include(":app:progress_bar")
include(":app:dropdown_menu")
include(":app:top_app_bar&navigation_drawer")
include(":app:bottom_nav_bar")
include(":app:app_ilhamver")
include(":app:app_login")
include(":app:app_yemektarifi")
