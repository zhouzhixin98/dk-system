package lee.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zzx.dksystem.service.EmpManager;

public class test {
    public static void main (String[] args)
    {
        BeanFactory appContext = new ClassPathXmlApplicationContext("appContext.xml");
        var emp = appContext.getBean("EmpManager", EmpManager.class);
        var result = emp.getAllType();
        System.out.println(result);
    }
}
