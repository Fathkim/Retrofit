package com.fathkim.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathkim.retrofit.data.UserItemResponse
import com.fathkim.retrofit.databinding.ActivityMainBinding
import com.fathkim.retrofit.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val adapterUser = AdapterUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get Api
        getApi()

        //set layout manager dan adapter

    }

    fun setData(data: ArrayList<UserItemResponse>){
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterUser
            adapterUser.setUser(data)
        }
    }

    fun getApi(){
        ApiConfig.getApiService().getLIstUser().enqueue(object : Callback<ArrayList<UserItemResponse>>{
            override fun onResponse(
                call: Call<ArrayList<UserItemResponse>>,
                response: Response<ArrayList<UserItemResponse>>
            ) {
                response.body()?.let {
//                   adapterUser.setUser(it)
                    setData(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UserItemResponse>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t",)
            }

        })
    }
}