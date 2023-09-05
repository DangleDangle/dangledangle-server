package com.dangle.usecase.lock.port.out

import java.time.Duration

interface DistributedLockPort {
    fun <T> withLock(key: String, timeout: Duration, supplier: () -> T): T
}
