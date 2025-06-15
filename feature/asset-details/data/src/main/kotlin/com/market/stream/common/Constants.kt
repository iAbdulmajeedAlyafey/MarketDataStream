package com.market.stream.common

// TODO Common Constants - we can move it to core:network module..
const val DATABASE_NAME = "app-database"

object HttpClient {
    const val READ_TIMEOUT = 60
    const val CALL_TIMEOUT = 60
    const val CONNECTION_TIMEOUT = 60
}
object ErrorCode {
    const val BAD_REQUEST = 400
    const val NOT_FOUND = 404
}

object HeaderKeys {
    const val AUTH = "Authorization"
    const val BEARER = "Bearer "
}
