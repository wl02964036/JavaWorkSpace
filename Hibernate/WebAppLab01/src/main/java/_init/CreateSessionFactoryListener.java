package _init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class CreateSessionFactoryListener implements ServletContextListener {



    public void contextDestroyed(ServletContextEvent sce)  { 
    	HibernateUtils.close();
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("系統啟動中...");
    	HibernateUtils.getSessionFactory();
    	System.out.println("系統啟動完畢");
    }
	
}
