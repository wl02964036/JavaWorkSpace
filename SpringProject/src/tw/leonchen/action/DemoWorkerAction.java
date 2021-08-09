package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.WorkerDao;

public class DemoWorkerAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		WorkerDao workerDao =  context.getBean("workerDao", WorkerDao.class);
		workerDao.printDetails();
		
		context.close();

	}

}
