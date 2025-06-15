package com.market.stream.exception

// TODO add other exceptions...

sealed class DataAccessException(
    message: String? = null,
    cause: Throwable? = null
) : Exception(message, cause) {

    class NetworkException(
        message: String? = null,
        cause: Throwable? = null
    ) : DataAccessException(message, cause)

    data object ServerException : DataAccessException("Failed to parse response")
}