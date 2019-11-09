

package ${PackageName}.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ${PackageName}.presentation.viewmodel.${ViewModelName}
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ${PresentationModuleName} {
    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(${ViewModelName}::class)
    abstract fun bindsHomeViewModel(m${ViewModelName}: ${ViewModelName}): ViewModel
}