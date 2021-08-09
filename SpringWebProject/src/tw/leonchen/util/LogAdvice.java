package tw.leonchen.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAdvice")
@Aspect
public class LogAdvice {
	
	@Pointcut(value = "execution(* tw.leonchen.model.HouseService.*(..))")
	private void pointcut1() {}

	@Before(value = "pointcut1()")
	public void logBefore(JoinPoint point) {
		System.out.print("before at " + point.getTarget().getClass() + " ");
		System.out.print("calling " + point.getSignature().getName() + " ");
		System.out.println("using " + point.getArgs()[0] + " ");
		System.out.println("before: going to JoinPoint method");
	}

	@Around(value = "pointcut1()")
	public Object logAround(ProceedingJoinPoint pPoint) throws Throwable {
		System.out.print("around at " + pPoint.getTarget().getClass() + " ");
		System.out.print("calling " + pPoint.getSignature().getName() + " ");
		System.out.println("using " + pPoint.getArgs()[0] + " ");
		Object result = pPoint.proceed();
		System.out.println("around result:" + result);
		return result;
	}
	

	@AfterReturning(value = "pointcut1()", returning = "result")
	public void logAfter(JoinPoint point, Object result) {
		System.out.println("after: JoinPoint method finished");
		System.out.println("after result:" + result);
	}

	@AfterThrowing(value = "pointcut1()", throwing = "exception")
	public void logThrow(JoinPoint point, Throwable exception) {
		System.out.println("Exception:" + exception);
	}
}
