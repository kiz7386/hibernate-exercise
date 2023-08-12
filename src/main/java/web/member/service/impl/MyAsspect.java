package web.member.service.impl;

import java.sql.Time;
import java.time.LocalTime;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAsspect {

	@Before("execution(* web.member.service.impl.MemberServiceImpl.login(..))")
	public void before() {
		System.out.println(LocalTime.now());
		System.out.println(new Time(System.currentTimeMillis()));
	}
}
