package tn.esprit.backend.configuration;

import tn.esprit.backend.service.serviceInterface.IService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
@EnableScheduling
@EnableAspectJAutoProxy
public class LoggingAspect {
    IService iService;
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @After("execution(* tn.esprit.backend.service.serviceInterface.*.add*(..))")
    public void LogMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("Bienvenue dans Notre application Location, Vente Immobilier! " + name + " ");
    }

   /*

    /*@After("execution(* tn.esprit.spring.service.*.addDonation(..))")
    public void LogMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Merci pour ce don! " + name + " ");
    }*/
    /*@Scheduled(cron = "0 0 0 1 * ?")
    public void getEmployeByDonation() {
        iService.getBestEmployeByDonations();
    }

    //@Scheduled(cron = "0 0 0 1 * ?") // Exécuté le 1er de chaque mois à minuit
   @Around("execution(* tn.esprit.spring.revision.service.*.getBestEmployeByDonations(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        log.info("Appel de la méthode : {}", name);

        Object result = joinPoint.proceed();

        log.info("Best employee for the current month : {}", result);

        return result;
    }
    @Scheduled(cron = "0 0 0 1 * ?")
    public void getEmployeByDonation() {
        iService.getEmployeByDonation();
    }

    @Around("execution(* tn.esprit.spring.service.*.getEmployeByDonation(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        log.info("Appel de la méthode : {}", name);

        Object result = joinPoint.proceed();

        if (result != null) {
            log.info("Best employee for the current month : {}", result);
        } else {
            log.info("No donations found for the current month.");
        }

        return result;
    }*/



}