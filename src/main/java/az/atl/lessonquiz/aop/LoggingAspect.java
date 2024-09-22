package az.atl.lessonquiz.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Pointcut("within(az.atl.lessonquiz.controller..*)" +
            " || within(az.atl.lessonquiz.service.serviceImpl..*)")
    public void applicationPackagePointCut() {
    }

    @AfterReturning(pointcut = "applicationPackagePointCut()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("Executed method: {}. Result: {}", joinPoint.getSignature().toShortString(), result);
    }

    @AfterThrowing(pointcut = "applicationPackagePointCut()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in {}.{}() with cause = '{}' and exception = '{}'",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                getExceptionCause(ex), ex.getMessage());

    }

    private Object getExceptionCause(Throwable throwable) {
        return throwable.getCause() != null ? throwable.getCause() : "NULL";
    }

    @Around("applicationPackagePointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Executed method: {}", proceedingJoinPoint.getSignature().toShortString());

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        final long executionTime = stopWatch.getTotalTimeMillis();
        final String methodName = proceedingJoinPoint.getSignature().getName();
        final String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();

        log.info("Executed time {} ms for method: {}, in class: {}",
                executionTime, methodName, className);
        return result;
    }
}
