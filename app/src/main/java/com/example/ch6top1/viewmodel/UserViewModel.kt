package com.example.ch6top1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ch6top1.model.ResponseDataUserItem
import com.example.ch6top1.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    var liveDataUser: MutableLiveData<List<ResponseDataUserItem>>
    init {
        liveDataUser = MutableLiveData()
    }
    fun getData(){
        //memakai callback yang retrofit
        RetrofitClient.instance.getAlluser().enqueue(object : Callback<List<ResponseDataUserItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataUserItem>>,
                response: Response<List<ResponseDataUserItem>>

            ) {
                if (response.isSuccessful){
                    liveDataUser.postValue(response.body())
                }else{
                    liveDataUser.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
                liveDataUser.postValue(null)
            }

        })
    }
}