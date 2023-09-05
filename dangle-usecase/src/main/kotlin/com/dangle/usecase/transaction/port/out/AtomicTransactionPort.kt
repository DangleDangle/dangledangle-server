package com.dangle.usecase.transaction.port.out

interface AtomicTransactionPort {
    fun <T> withTransaction(supplier: () -> T): T
}
