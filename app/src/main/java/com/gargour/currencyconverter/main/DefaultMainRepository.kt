package com.gargour.currencyconverter.main

import com.gargour.currencyconverter.data.CurrencyApi
import com.gargour.currencyconverter.data.models.CurrencyResponse
import com.gargour.currencyconverter.util.Resource
import java.lang.Exception
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(base)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (ex: Exception) {
            Resource.Error(ex.message ?: "An error occurred")
        }
    }

}