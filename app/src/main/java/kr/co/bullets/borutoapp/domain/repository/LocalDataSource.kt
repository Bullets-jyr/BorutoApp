package kr.co.bullets.borutoapp.domain.repository

import kr.co.bullets.borutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}