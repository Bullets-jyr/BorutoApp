package kr.co.bullets.borutoapp.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.bullets.borutoapp.domain.model.Hero

interface RemoteDataSource {

    fun getAllHeroes(): Flow<PagingData<Hero>>

    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}