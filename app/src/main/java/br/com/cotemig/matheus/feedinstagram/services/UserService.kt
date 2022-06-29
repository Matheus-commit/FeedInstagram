package br.com.cotemig.matheus.feedinstagram.services

import br.com.cotemig.matheus.feedinstagram.models.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("feed")
    fun getFeed(): Call<List<User>>
}