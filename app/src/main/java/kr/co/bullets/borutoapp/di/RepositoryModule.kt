package kr.co.bullets.borutoapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.bullets.borutoapp.data.repository.DataStoreOperationsImpl
import kr.co.bullets.borutoapp.data.repository.Repository
import kr.co.bullets.borutoapp.domain.repository.DataStoreOperations
import kr.co.bullets.borutoapp.domain.use_cases.UseCases
import kr.co.bullets.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import kr.co.bullets.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import kr.co.bullets.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import kr.co.bullets.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import kr.co.bullets.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }
}