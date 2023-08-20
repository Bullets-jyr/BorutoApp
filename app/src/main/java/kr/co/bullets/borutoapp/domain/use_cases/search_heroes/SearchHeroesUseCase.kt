package kr.co.bullets.borutoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.bullets.borutoapp.data.repository.Repository
import kr.co.bullets.borutoapp.domain.model.Hero

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}