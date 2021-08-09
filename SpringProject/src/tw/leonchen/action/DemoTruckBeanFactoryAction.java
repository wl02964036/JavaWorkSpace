package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.TruckBean;

public class DemoTruckBeanFactoryAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		TruckBean bmwTruck = context.getBean("bmwTruck", TruckBean.class);
		System.out.println(bmwTruck.getId() + " , " + bmwTruck.getBrand());

		TruckBean benzTruck = context.getBean("benzTruck", TruckBean.class);
		System.out.println(benzTruck.getId() + " , " + benzTruck.getBrand());
		
		context.close();

	}

}
