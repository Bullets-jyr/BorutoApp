package kr.co.bullets.borutoapp.domain.use_cases.get_selected_hero

import kr.co.bullets.borutoapp.data.repository.Repository
import kr.co.bullets.borutoapp.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}