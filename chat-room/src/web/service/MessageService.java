package web.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import domain.Meses;
import domain.Users;

@Transactional
public class MessageService {

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;
	
	public void save(Meses meses) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(meses);
	}

	public List<Meses> getMeses(Integer gid,Integer sid) {
		// TODO Auto-generated method stub
		String hql = "from Meses where usersByGid='"+gid+"' and usersBySid='" +sid+"' and isget='0'";
		List<Meses> list = sessionFactory.getCurrentSession().createQuery(hql).list();
		//System.out.println(hql);
		return list;
	}

	public void updateMeses(Meses meses) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().update(meses);
	}
	
}
