package com.blossom.site.log.aspect;

import com.blossom.site.base.utils.DateUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.base.utils.browser.BrowserUtils;
import com.blossom.site.log.annotation.VisitLog;
import com.blossom.site.log.service.VisitLogService;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Blossom
 * @Description 访问日志切面
 * @time 2017/3/24 15:45
 */
@Aspect
@Component
public class VisitLogAspect {

    private static final Class CLASS = VisitLogAspect.class;

    @Autowired
    private VisitLogService visitLogServiceImpl;

    @Pointcut("@annotation(com.blossom.site.log.annotation.VisitLog)")
    public void controllerAspect(){}

    /**
     * @description 前置通知用于拦截Controller层记录用户操作
     * @author Blossom
     * @DateTime 2017/3/24 15:51
     * @param
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        String userName = String.valueOf(session.getAttribute("userName"));
        //获取请求IP
        String ip = request.getRemoteAddr();
        try {
            //保存日志到数据库
            JSONObject json = new JSONObject();
            json.put("url", request.getRequestURL().toString());
            json.put("httpMethod",request.getMethod());
            json.put("broswer", BrowserUtils.checkBrowse(request));
            json.put("description",getControllerMethodDescription(joinPoint));
            json.put("method",(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            json.put("params", Arrays.toString(joinPoint.getArgs()));
            json.put("createBy",userName);
            json.put("createDate", DateUtils.format(DateUtils.format()));
            json.put("requestIp",ip );
            System.out.println("return json=======" + json.toString());

            json =  visitLogServiceImpl.saveEntityInfo(json);

            System.out.println("return json=======" + json.toString());
            System.out.println("=====前置通知结束=====");
        } catch (Exception e) {
            LoggerUtils.addLoggerError(CLASS, "doBefore", e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * @description:获取注解对方法的描述信息，用于controller层注解
     * @author Blossom
     * @time 2017年2月23日 下午2:14:46
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("rawtypes")
    private String getControllerMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(VisitLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
