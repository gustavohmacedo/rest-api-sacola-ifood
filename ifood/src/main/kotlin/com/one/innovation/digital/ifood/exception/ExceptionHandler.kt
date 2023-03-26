package com.one.innovation.digital.ifood.exception

import com.one.innovation.digital.ifood.dto.ApiError
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApplicationException::class)
    fun handleApplicationException(
        exception: ApplicationException,
        request: HttpServletRequest
    ) = ApiError(
        status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
        error = HttpStatus.INTERNAL_SERVER_ERROR.name,
        message = exception.message ?: "Erro interno no Servidor",
        path = request.servletPath
    )

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BagNotFoundException::class)
    fun handleBagNotFound(
        exception: BagNotFoundException,
        request: HttpServletRequest
    ) = ApiError(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.name,
        message = exception.message!!,
        path = request.servletPath
    )

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotFoundException::class)
    fun handleProductNotFoundException(
        exception: ProductNotFoundException,
        request: HttpServletRequest
    ) = ApiError(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.name,
        message = exception.message!!,
        path = request.servletPath
    )

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClosedBagException::class)
    fun handleClosedBagException(
        exception: ClosedBagException,
        request: HttpServletRequest
    ) = ApiError(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.name,
        message = exception.message!!,
        path = request.servletPath
    )



}