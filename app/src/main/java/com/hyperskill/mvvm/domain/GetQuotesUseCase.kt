package com.hyperskill.mvvm.domain

import com.hyperskill.mvvm.data.QuoteRepository
import com.hyperskill.mvvm.data.database.entities.toDatabase
import com.hyperskill.mvvm.data.model.QuoteModel
import com.hyperskill.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}