package com.hyperskill.mvvm.domain.model

import com.hyperskill.mvvm.data.database.entities.QuoteEntity
import com.hyperskill.mvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String )

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)