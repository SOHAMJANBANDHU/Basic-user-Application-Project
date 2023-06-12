package basicApplication.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.loader.custom.Return;

import basicApplication.DTO.BasicApplication;



public class BasicApplicationCRUD {

	public EntityManager getEntityManager()
	{
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		return entityManager;
		
		return Persistence.createEntityManagerFactory("soham").createEntityManager() ;
	}
	
	public void signupApplication(BasicApplication basicApp)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(basicApp);
		entityTransaction.commit();
	}
	
	public boolean loginUser(String email, String password)
	{
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT a FROM BasicApplication a WHERE a.email=?1") ;
		query.setParameter(1, email) ;
	
		try 
		{
			BasicApplication basic = (BasicApplication) query.getSingleResult() ;
			if(basic.getPassword().equals(password))
			{
				return true;
			}
		}
		catch (Exception e)
		{
			System.out.println("User with the give mail not found");
		}
		
	return false;	
	}

	public void displayPassword(String email) 
	{
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM BasicApplication u WHERE u.email =?1") ;
		query.setParameter(1, email) ;
		
		BasicApplication basic = (BasicApplication) query.getSingleResult() ;
		
		System.out.println("facebook : "+ basic.getFacebook());
		System.out.println("instagram : "+ basic.getInstagram());
		System.out.println("snapchat : "+ basic.getSnapchat());
		System.out.println("whatsapp : "+ basic.getWhatsapp());
		System.out.println("twitter : "+ basic.getTwitter());
		
	}

	public void updatePasswords(BasicApplication basic, String email) 
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Query query = entityManager.createQuery("SELECT u FROM BasicApplication u WHERE u.email =?1") ;
		query.setParameter(1, email) ;
		
		BasicApplication dbbasic = (BasicApplication) query.getSingleResult() ;
		
		entityTransaction.begin();
		basic.setId(dbbasic.getId());
		basic.setName(dbbasic.getName());
		basic.setEmail(dbbasic.getEmail());
		basic.setPassword(dbbasic.getPassword());
		basic.setPhone(dbbasic.getPhone());
		
		entityManager.merge(basic) ;
		entityTransaction.commit();
	}

	public void close() 
	{
		System.exit(200);
	}
	

}
