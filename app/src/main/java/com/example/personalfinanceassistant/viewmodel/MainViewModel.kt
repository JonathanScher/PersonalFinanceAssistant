package com.example.personalfinanceassistant.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalfinanceassistant.service.RetrofitInstance
import com.example.personalfinanceassistant.model.SheetResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val apiKey = "API_KEY"
    private val spreadsheetId = "SPREADSHEET_ID"
    private val range = "Analysis!A1"

    private val _cellValue = MutableLiveData<String>()
    val cellValue: LiveData<String> = _cellValue

    init {
        fetchCellValue()
    }

    fun fetchCellValue() {
        viewModelScope.launch(Dispatchers.IO) {
            val call = RetrofitInstance.api.getSheetData(spreadsheetId, range, apiKey)
            call.enqueue(object : Callback<SheetResponse> {
                override fun onResponse(call: Call<SheetResponse>, response: Response<SheetResponse>) {
                    if (response.isSuccessful) {
                        _cellValue.postValue(response.body()?.values?.get(0)?.get(0) ?: "No data")
                    } else {
                        _cellValue.postValue("Error: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<SheetResponse>, t: Throwable) {
                    _cellValue.postValue("Failure: ${t.message}")
                }
            })
        }
    }
}
