package com.gargour.currencyconverter.main

import com.gargour.currencyconverter.data.models.CurrencyResponse
import com.gargour.currencyconverter.util.Resource

interface MainRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}