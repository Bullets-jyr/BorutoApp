package kr.co.bullets.borutoapp.data.repository

import kr.co.bullets.borutoapp.data.local.BorutoDatabase
import kr.co.bullets.borutoapp.domain.model.Hero
import kr.co.bullets.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}