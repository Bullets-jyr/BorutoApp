package kr.co.bullets.borutoapp.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.bullets.borutoapp.domain.model.Hero
import kr.co.bullets.borutoapp.domain.repository.DataStoreOperations
import kr.co.bullets.borutoapp.domain.repository.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {
    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remote.searchHeroes(query = query)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}