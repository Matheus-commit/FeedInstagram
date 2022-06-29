package br.com.cotemig.matheus.feedinstagram.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.cotemig.matheus.feedinstagram.R
import br.com.cotemig.matheus.feedinstagram.models.User
import br.com.cotemig.matheus.feedinstagram.services.RetrofitInitializer
import br.com.cotemig.matheus.feedinstagram.ui.adapters.FeedAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFeed()
    }

    fun getFeed(){

        var s = RetrofitInitializer().getUserService()
        var call = s.getFeed()

        call.enqueue(object : retrofit2.Callback<List<User>>{

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.code() == 200){

                    response.body()?.let {
                        showFeed(it)
                    }
                }

            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun showFeed(list: List<User>){
        var listFeed = findViewById<ListView>(R.id.feed)
        listFeed.adapter = FeedAdapter(this, list)

    }
}