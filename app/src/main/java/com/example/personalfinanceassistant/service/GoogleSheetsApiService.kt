package com.example.personalfinanceassistant.service

import com.example.personalfinanceassistant.model.SheetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleSheetsApiService {
    @GET("v4/spreadsheets/{spreadsheetId}/values/{range}")
    fun getSheetData(
        @Path("spreadsheetId") spreadsheetId: String,
        @Path("range") range: String,
        @Query("key") apiKey: String
    ): Call<SheetResponse>
}
