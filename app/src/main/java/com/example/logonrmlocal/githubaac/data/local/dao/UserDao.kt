package com.example.logonrmlocal.githubaac.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.logonrmlocal.githubaac.data.local.entity.User
import java.util.*

//Dao creates the methods to access and interact with the object
//Data access object
@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun save(user: User)

    //Real time observable variable (LiveData <Variable>)
    @Query("SELECT * FROM User WHERE login = :login") // Notation ':Variable' pass the variable to the function
    fun load(login: String): LiveData<User>

    @Query("SELECT * FROM User Where login = :login AND lastRefresh = :lastRefresh LIMIT 1")
    fun hasUser(login: String, lastRefresh: Date): User
}