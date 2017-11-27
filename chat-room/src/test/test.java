package test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Meses;
import domain.Users;

import web.service.MessageService;
import web.service.UsersService;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//MessageService messageService = new MessageService();
		//UsersService usersService = new UsersService();
		Users getter =(Users) MyHibernateUtil.getCurrentSession().get(Users.class, 1);
		Users sender =(Users) MyHibernateUtil.getCurrentSession().get(Users.class, 2);
		//messageService.getMeses(getter, sender);
		String hql = "from Meses where usersByGid='"+2+"' and usersBySid='" +1+"' and isget='0'";
		
		//SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		List<Meses> list = MyHibernateUtil.getCurrentSession().createQuery(hql).list();
		for (Meses meses : list) {
			System.out.println(meses.getCon());
		}
	}

}
