package com.example.meditationdemov1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.meditationdemov1.model.network_client.MyApolloClient
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPosts()

    }

    private fun getPosts(){
        val feedQuery = FeedQueryResultQuery.builder().build()
        MyApolloClient.apolloClient.query(feedQuery).enqueue(object: ApolloCall.Callback<FeedQueryResultQuery.Data>() {

            override fun onFailure(e: ApolloException) {
                Log.d("Error Respond", "${e.message}")
            }

            override fun onResponse(response: Response<FeedQueryResultQuery.Data>) {
               Log.d("Success Respond", "${response.data()}")
                val sb = StringBuilder()
                runOnUiThread {
                    val characters = response.data()?.characters()
                    val character = response.data()?.characters
                    val operationName = response.operation().name()
                    val data = response.data()
                    sb.append(characters)
                    sb.append(character)
                    sb.append(operationName)
                    sb.append(data)
                    txt_placeholder_main.text = sb
                }
            }

        })
    }

}
