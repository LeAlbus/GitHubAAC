package com.example.logonrmlocal.githubaac.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class User(

        @PrimaryKey //Indica que a chave é prmaria e não pode ser duplicada
        var id: Int = 0,

        var name: String = "",

        @SerializedName("avatar_url") //Indica a chave real do servidor, como as CodingKeys
        var avatarURL: String = "",

        var login: String = "",
        var lastRefresh: Date? = null
)