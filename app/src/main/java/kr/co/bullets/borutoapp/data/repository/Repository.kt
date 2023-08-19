package kr.co.bullets.borutoapp.data.repository

import kotlinx.coroutines.flow.Flow
import kr.co.bullets.borutoapp.domain.repository.DataStoreOperations
import javax.inject.Inject

class Repository @Inject constructor(
  private val dataStore: DataStoreOperations
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}