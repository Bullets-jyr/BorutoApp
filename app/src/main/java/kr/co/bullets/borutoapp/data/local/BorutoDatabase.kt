package kr.co.bullets.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.co.bullets.borutoapp.data.local.dao.HeroDao
import kr.co.bullets.borutoapp.data.local.dao.HeroRemoteKeysDao
import kr.co.bullets.borutoapp.domain.model.Hero
import kr.co.bullets.borutoapp.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}