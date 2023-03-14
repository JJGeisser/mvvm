package com.hyperskill.mvvm.domain

import com.hyperskill.mvvm.data.QuoteRepository
import com.hyperskill.mvvm.data.model.QuoteModel
import com.hyperskill.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}