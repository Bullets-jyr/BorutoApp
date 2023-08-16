package kr.co.bullets.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.bullets.borutoapp.data.local.dao.HeroDao
import kr.co.bullets.borutoapp.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
//@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
//    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}