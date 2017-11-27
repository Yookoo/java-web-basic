package test;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class MyHibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	//使用线程局部模式
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	//私有的构造方法无法创建对象,保证单例模式
	private MyHibernateUtil(){};
	
	static{
		Configuration config =new Configuration().configure();
		sessionFactory =config.buildSessionFactory();
		
	}
	public static Session OpenSession(){
		Session session= sessionFactory.openSession();	
		return session;
	}
	public static Session getCurrentSession(){
		
		Session session= threadLocal.get();
		if(session==null || !session.isOpen()){
			session=sessionFactory.openSession();
			//把session对象设置到 threadLocal,相当于该session已经和线程绑定
			threadLocal.set(session);
		}
		return session;
	}
	//增删改查
	//增
	public static void executeAdd(Object obj){
		Session session =null;
		Transaction tx = null;
		try {
			session = getCurrentSession();
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			new RuntimeException(e.getMessage());
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
			
		}
	}
	//删改
	public static void executeUpdate(String hql,String[] parameter){
		Session session =null;
		Transaction tx = null;
		
		try {
			session = getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			//判断是否有参数
			if(parameter!=null&&parameter.length>0){
				for(int i=0; i<parameter.length; i++){
					query.setString(i, parameter[i]);			
				}
			}
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			//e.getStackTrace();
			new RuntimeException(e.getMessage());
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
			
		}
	}
	//查寻
	public static List executeQuery(String hql,String[] parameter){
		
		Session session =null;
		Transaction tx = null;
		List list = null;
		try {
			session = getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			//判断是否有参数
			if(parameter!=null&&parameter.length>0){
				for(int i=0; i<parameter.length; i++){
					query.setString(i, parameter[i]);			
				}
			}
			list= query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			new RuntimeException(e.getMessage());
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
			
		}
		return list;
	}
	//分页查询;
	public static List executeQueryByPage(String hql,String[] parameter,int pageNow,int pageSize){
		
		Session session =null;
		Transaction tx = null;
		List list = null;
		try {
			session = getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			//判断是否有参数
			if(parameter!=null&&parameter.length>0){
				for(int i=0; i<parameter.length; i++){
					query.setString(i, parameter[i]);			
				}
			}
			query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
			list= query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			new RuntimeException(e.getMessage());
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
			
		}
		return list;
	}
	//单个查询;
	public static Object executeQueryByOne(String hql,String[] parameter){
		
		Session session =null;
		Object  obj = null;
		try {
			session = getCurrentSession();
			Query query = session.createQuery(hql);
			//判断是否有参数
			if(parameter!=null&&parameter.length>0){
				for(int i=0; i<parameter.length; i++){
					query.setString(i, parameter[i]);			
				}
			}
			obj= query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			new RuntimeException(e.getMessage());
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
			
		}
		return obj;
	}
}


