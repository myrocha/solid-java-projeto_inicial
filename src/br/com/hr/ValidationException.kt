package br.com.hr

import java.lang.RuntimeException

class ValidationException(message: String?) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}