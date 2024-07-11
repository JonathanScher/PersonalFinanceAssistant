package com.example.personalfinanceassistant.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.model.ValueRange
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.sheets.v4.SheetsScopes

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _cellValue = MutableLiveData<String>()
    val cellValue: LiveData<String> = _cellValue

    private lateinit var googleAccount: GoogleSignInAccount

    fun setGoogleAccount(account: GoogleSignInAccount) {
        googleAccount = account
        fetchCellValue()
    }

    fun fetchCellValue() {
        viewModelScope.launch(Dispatchers.IO) {
            val credential = GoogleAccountCredential.usingOAuth2(
                getApplication(),
                listOf(SheetsScopes.SPREADSHEETS_READONLY)
            ).setSelectedAccountName(googleAccount.email)

            val sheetsService = Sheets.Builder(
                NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                credential
            ).setApplicationName("PersonalFinanceAssistant")
                .build()

            val spreadsheetId = "1xIrgK_OXpAlUYzmaJrREQqooWK__kZhcfE0-BqBJUxU"
            val range = "Analysis!A1"
            val response: ValueRange = sheetsService.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute()
            val values = response.getValues()

            if (values != null && values.isNotEmpty()) {
                _cellValue.postValue(values[0][0] as String)
            } else {
                _cellValue.postValue("No data found.")
            }
        }
    }
}
