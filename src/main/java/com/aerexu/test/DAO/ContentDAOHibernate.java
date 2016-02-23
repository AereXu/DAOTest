//package com.aerexu.test.DAO;
//
//import com.ericsson.bmsc.mdfup.sessionmgt.entity.UpContentDeliveryEntity;
//import org.hibernate.Query;
//
//import java.util.List;
//
///**
// * Created by epxpxpx on 2/19/2016.
// */
//public class ContentDAOHibernate
//        extends GenericHibernateDAO<UpContentDeliveryEntity, Long>
//        implements ContentDAO {
//
//    public List<UpContentDeliveryEntity> findByEntity(UpContentDeliveryEntity entityInstance) {
//        return null;
//    }
//
//    public UpContentDeliveryEntity findByDsiIdAndContentId(Long dsiId, Long contentId) {
//        Query q =  getSession().getNamedQuery(ContentDAO.QUERY_FIND_BY_DSIID_AND_CONTENTID);
//        q.setParameter("dsiId", dsiId);
//        q.setParameter("contentId", contentId);
//        return (UpContentDeliveryEntity) q.uniqueResult();
//    }
//}
