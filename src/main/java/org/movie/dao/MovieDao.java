package org.movie.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.movie.entity.Movie;
import org.movie.util.HibernateUtil;

public class MovieDao {
	
	public void saveMovie(Movie movie) {
        Transaction transaction = null;
        try  {
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(movie);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List < Movie > getMovies(int page, int per_page, String movie_sub_str) {
        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
        	CriteriaBuilder cb = session.getCriteriaBuilder();
        	CriteriaQuery<Movie> cr = cb.createQuery(Movie.class);
        	Root<Movie> root = cr.from(Movie.class);
        	cr.select(root);
        	if(movie_sub_str != null) {
        		cr.where(cb.like(root.<String>get("Title"), "%"+movie_sub_str+"%"));
        	}
        	Query<Movie> query = session.createQuery(cr);
        	query.setFirstResult((page-1));
        	query.setMaxResults(per_page);
            return query.getResultList();
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public Long count(String movie_sub_str) {
        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
        	Criteria criteria = session.createCriteria(Movie.class)
                    .setProjection(Projections.rowCount());
        	if(movie_sub_str != null) {
        		criteria.add(Restrictions.like("Title", "%"+movie_sub_str+"%"));;
        	}
                List result = criteria.list();
                if (!result.isEmpty()) {
                    Long rowCount = (Long) result.get(0);
                    return rowCount;
                }
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return 0l;
    }
    
}
