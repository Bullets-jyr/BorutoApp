package kr.co.bullets.borutoapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.bullets.borutoapp.data.repository.Repository
import kr.co.bullets.borutoapp.domain.model.Hero

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}