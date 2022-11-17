package com.service.product.aop.lock;

import com.service.product.service.lock.LockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LockAopAspect {
    private final LockService lockService;

    @Around("@annotation(com.service.product.aop.lock.ProductOrderLock)")
    public Object orderAroundLockMethod(
            ProceedingJoinPoint pjp
    ) throws Throwable {
        // lock 취득 시도
        lockService.lock();
        try {
            return pjp.proceed();
        } finally {
            // lock 해제
            lockService.unlock();
        }
    }
}