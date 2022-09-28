package ru.alena.todoapp.todoapp.executer.entrypoints.http.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Aspect
@ControllerAdvice
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserEditUsecase.execute(..))|| " +
            "execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserCreateUseCase.execute(..)) ||" +
            "execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserSearchUseCase.execute(..)) ||" +
            "execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserRemoveUseCase.execute(..)) ")

    public void logBeforeExecuteUserUsecase(JoinPoint joinPoint) {
        logger.info("Start execute " + joinPoint.getSignature().getDeclaringType().getSimpleName());
    }

    @After("execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserEditUsecase.execute(..))|| " +
            "execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserCreateUseCase.execute(..)) ||" +
            "execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserSearchUseCase.execute(..)) ||" +
            "execution(* ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserRemoveUseCase.execute(..)) ")
    public void logAfterExecuteUserUsecase(JoinPoint joinPoint) {
        logger.info("Complete execute " + joinPoint.getSignature().getDeclaringType().getSimpleName());
    }


}
