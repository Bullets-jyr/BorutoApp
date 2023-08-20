package kr.co.bullets.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.bullets.borutoapp.data.local.BorutoDatabase
import kr.co.bullets.borutoapp.data.paging_source.HeroRemoteMediator
import kr.co.bullets.borutoapp.data.paging_source.SearchHeroesSource
import kr.co.bullets.borutoapp.data.remote.BorutoApi
import kr.co.bullets.borutoapp.domain.model.Hero
import kr.co.bullets.borutoapp.domain.repository.RemoteDataSource
import kr.co.bullets.borutoapp.util.Constants.ITEMS_PER_PAGE

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
) : RemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(borutoApi = borutoApi, query = query)
            }
        ).flow
    }
}