package com.blossom.site.log.aspect;

import com.blossom.site.base.utils.DateUtils;
import com.blossom.site.base.utils.LoggerUtils;
import com.blossom.site.log.annotation.HandleLog;
import com.blossom.site.log.service.HandleLogService;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Blossom
 * @Description 操作日志切面
 * @time 2017/3/24 16:07
 */
@Aspect
@Component
public class HandleLogAspect {

    private static final Class CLASS = HandleLogAspect.class;


    @Autowired
    private HandleLogService handleLogServiceImpl;

    @Pointcut("@annotation(com.blossom.site.log.annotation.HandleLog)")
    public void serviceAspect(){}

    /**
     * @description 前置通知
     * @author Blossom
     * @DateTime 2017/3/24 16:10
     * @param joinPoint
     */
    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        String userName = "";
        if (session.getAttribute("userName") != null){
             userName = String.valueOf(session.getAttribute("userName"));
        }
        try {
            Map<String,String> map = getServiceMthodDescription(joinPoint);
            String description = "";
            if (map.containsKey("description")){
                description = map.get("description");
            }
            String tableName = "";
            if (map.containsKey("tableName")){
                tableName = map.get("tableName");
            }
            int type = 0;
            if ("insert".equals(description)){
                type = 1;
            } else if ("update".equals(description)){
                type = 2;
            } else if ("delete".equals(description)){
                type = 3;
            } else if ("select".equals(description)){
                type = 4;
            }
            //保存日志到数据库
            JSONObject json = new JSONObject();

            json.put("description",description);
            json.put("tableName",tableName);
            json.put("params", Arrays.toString(joinPoint.getArgs()));
            json.put("userName",userName);
            json.put("handleTime", DateUtils.format(DateUtils.format()));
            json.put("type",type);
            System.out.println("HandleLogAspect json=======" + json.toString());

            json = handleLogServiceImpl.saveEntityInfo(json);
            System.out.println("return json=======" + json.toString());
            System.out.println("=====前置通知结束=====");
        } catch (Exception e) {
            LoggerUtils.addLoggerError(CLASS, "doBefore", e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * @description:
     * @author Blossom
     * @time 2017年2月23日 下午2:19:51
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("rawtypes")
    private Map<String,String> getServiceMthodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        String tableName = "";
        Map<String,String> map = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(HandleLog.class).description();
                    tableName = method.getAnnotation(HandleLog.class).tableName();

                    map.put("description",description);
                    map.put("tableName",tableName);
                    break;
                }
            }
        }
        return map;
    }

}
