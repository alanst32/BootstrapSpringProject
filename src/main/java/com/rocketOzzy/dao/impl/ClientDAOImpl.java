package com.rocketOzzy.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rocketOzzy.dao.ClientDAO;
import com.rocketOzzy.model.ClientDB;

@Repository("ClientDAO")
@SuppressWarnings("unchecked")
public class ClientDAOImpl implements ClientDAO {

	@Autowired	
	private SessionFactory sessionFactory;
	
	
	public List<ClientDB> getAllClients() {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientDB.class);
		
		return criteria.list();
	}

	
	public List<ClientDB> getClientByName(String name) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClientDB.class);
		
		criteria.add(Restrictions.eq("cliName", name));
		
		return criteria.list();
	}

	public boolean insertClient(ClientDB clientDB) {
		
		sessionFactory.getCurrentSession().beginTransaction();
		
		sessionFactory.getCurrentSession().save(clientDB);
		
		return true;
	}

	public boolean updateClient(ClientDB clientDB) {
		
		sessionFactory.getCurrentSession().beginTransaction();
		
		sessionFactory.getCurrentSession().update(clientDB);
		
		return true;
	}

	public boolean deleteClient(ClientDB clientDB) {

		sessionFactory.getCurrentSession().beginTransaction();
		
		sessionFactory.getCurrentSession().delete(clientDB);
		
		return true;
	}
	
	public boolean deleteClientsByNumber(ArrayList<BigDecimal> cliNumbers){
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("clientDB.deleteClientsByNumber");
		
		if( cliNumbers != null ){
			query.setParameterList("cliNumbers", cliNumbers);
			
			int cont = query.executeUpdate();
			
			return true;
		}
		else{
			return false;
		}
	}

}
