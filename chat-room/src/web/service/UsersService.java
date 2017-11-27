package web.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import domain.Users;
@Transactional
public class UsersService {
	
	private SessionFactory sessionFactory; 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Users checkUsers(Users users){
		String hql = "from Users where name='"+users.getName()
				+"' and password='"+users.getPassword()+"'";
		return (Users) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();		
	}

	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		String hql = "from Users";
		return  (List<Users>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public Users findUsersById(Serializable id) {
		// TODO Auto-generated method stub
		return (Users) sessionFactory.getCurrentSession().get(Users.class, id);
	}
	
	
}
