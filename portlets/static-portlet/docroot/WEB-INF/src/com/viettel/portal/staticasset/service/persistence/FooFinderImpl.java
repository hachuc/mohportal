package com.viettel.portal.staticasset.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.staticasset.model.Foo;

public class FooFinderImpl extends BasePersistenceImpl implements FooFinder {
	public List findLatestArticleByTagName(
            String tagName,
            int begin, int end) {

        Session session = null;
        try {
            SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
            session = sessionFactory.openSession();

            String sql = CustomSQLUtil.get(FIND_BY_LATEST_ARTICLES_BY_TAGNAME);

            SQLQuery q = session.createSQLQuery(sql);
            q.setCacheable(false);

            q.addEntity("JournalArticle_JournalArticle", PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.journal.model.impl.JournalArticleImpl"));

            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(tagName);

            return (List) QueryUtil.list(q, getDialect(), begin, end);
        } catch (Exception e) {
            try {
                throw new SystemException(e);
            } catch (SystemException se) {
                se.printStackTrace();
            }
        } finally {
            closeSession(session);
        }

        return null;
    }

    public static final String FIND_BY_LATEST_ARTICLES_BY_TAGNAME  = FooFinder.class.getName() +".findLatestArticleByTagName";
}
