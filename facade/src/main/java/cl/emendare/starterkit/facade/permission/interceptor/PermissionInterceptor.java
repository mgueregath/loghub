/*
 * StarterKit.
 */
package cl.emendare.starterkit.facade.permission.interceptor;

import cl.emendare.starterkit.domain.error.SaveErrorInterface;
import cl.emendare.starterkit.domain.security.contract.user.CheckIfTheUserHasPermissionInterface;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.permission.annotation.Permission;
import cl.emendare.starterkit.facade.permission.annotation.ProtectedService;
import cl.emendare.starterkit.usecase.exception.security.ForbiddenException;
import com.google.inject.Inject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@Aspect
public class PermissionInterceptor {

    @Inject
    private CheckIfTheUserHasPermissionInterface checkIfTheUserHasPermission;

    @Inject
    private SaveErrorInterface saveError;

    @Pointcut("execution(@cl.emendare.starterkit.facade.permission.annotation.Permission * *(..))")
    public void permissionMethod() {
        // Call testModeOnly method
    }

    @Before("permissionMethod()")
    public void checkPermission(JoinPoint joinPoint) {
        if (joinPoint.getArgs().length > 0 && joinPoint.getArgs()[0].getClass() == User.class) {
            User user = (User) joinPoint.getArgs()[0];
            MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
            Permission annotation = methodSig.getMethod().getAnnotation(Permission.class);
            ProtectedService service = methodSig.getMethod().getDeclaringClass().getAnnotation(ProtectedService.class);
            boolean permissionGranted = checkIfTheUserHasPermission.check(
                    user, service.service(), annotation.method()
            );
            if (!permissionGranted) {
                throw new ForbiddenException();
            }
        } else {
            throw new ForbiddenException();
        }
    }

    @AfterThrowing(pointcut = "execution(* cl.emendare.starterkit.facade..service..*(..))", throwing = "e")
    public void exception(JoinPoint joinPoint, Throwable e) {
        logActions(joinPoint, false, e);
    }

    @AfterReturning("execution(* cl.emendare.starterkit.facade..service..*(..))")
    public void success(JoinPoint joinPoint) {
        logActions(joinPoint, true);
    }

    public void logActions(JoinPoint joinPoint, boolean result, Throwable e) {
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        if (joinPoint.getArgs().length > 0 && joinPoint.getArgs()[0] != null && joinPoint.getArgs()[0].getClass() == User.class) {
            User user = (User) joinPoint.getArgs()[0];
            saveError.save(user.getUsername(), result, methodSig.getMethod().getName(), e);
        } else {
            saveError.save("", result, methodSig.getMethod().getName(), e);
        }
    }

    public void logActions(JoinPoint joinPoint, boolean result) {
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        if (joinPoint.getArgs().length > 0 && joinPoint.getArgs()[0] != null && joinPoint.getArgs()[0].getClass() == User.class) {
            User user = (User) joinPoint.getArgs()[0];
            saveError.save(user.getUsername(), result, methodSig.getMethod().getName());
        } else {
            saveError.save("", result, methodSig.getMethod().getName());
        }
    }
}
