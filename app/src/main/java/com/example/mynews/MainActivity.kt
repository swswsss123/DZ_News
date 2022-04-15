package com.example.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mynews.api.RetofitInst.api
import com.example.mynews.model.NewsJson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse
import java.lang.Exception
import java.text.DateFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCurrentdata()
    }

    private fun getCurrentdata() {
        //использовал корутины
        GlobalScope.launch(Dispatchers.IO) {
            //обработка ошики в блоке трай кетч
            try {

            val response:Response<NewsJson> = api.getNews().awaitResponse()
            if(response.isSuccessful){
                var data:NewsJson = response.body()!!
                    //заполнение даныvb Активити
                withContext(Dispatchers.Main){
                    data_1.text =data.news[0].date
                    news_1.text = data.news[0].description

                    data_2.text =data.news[1].date
                    news_2.text = data.news[1].description

                    data_3.text =data.news[2].date
                    news_3.text = data.news[2].description

                    data_4.text =data.news[3].date
                    news_4.text = data.news[3].description

                    data_5.text =data.news[4].date
                    news_5.text = data.news[4].description

                    DateFormat.getDateInstance().format(data)
                    data_6.text =data.news[5].date
                    news_6.text = data.news[5].description
                }
            }
        }catch (e:Exception){
            //обработка исключения
            withContext(Dispatchers.Main){
                Toast.makeText(applicationContext,"Ошибка соединения...",Toast.LENGTH_LONG).show()
            }

            }
        }
    }
}