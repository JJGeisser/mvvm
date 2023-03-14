package com.hyperskill.mvvm.data

import com.hyperskill.mvvm.data.database.dao.QuoteDao
import com.hyperskill.mvvm.data.database.entities.QuoteEntity
import com.hyperskill.mvvm.data.network.QuoteService
import com.hyperskill.mvvm.domain.model.Quote
import com.hyperskill.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
    ) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}