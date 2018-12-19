package com.viettel.portal.vcms.service.persistence;
import java.util.List;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.model.impl.ContentDetailImpl;

public class ContentDetailFinderImpl extends BasePersistenceImpl<ContentDetail> implements ContentDetailFinder {
	public static final String FIND_BY_VERSION_SQL = ContentDetailFinder.class.getName() + ".findByVersions";

	public List<ContentDetail> findByVersion(long groupId, long contentId, int[] version) throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_VERSION_SQL);
			StringBuilder versionConn = new StringBuilder();
			for(int i = 0; i< version.length ; i ++){
				versionConn.append("version = ?");
				if(i < version.length - 1)
					versionConn.append(" OR ");
			}
			sql = StringUtil.replace(sql, "version = ?", versionConn.toString());
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ContentDetail", ContentDetailImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(contentId);
			for(int j = 0; j< version.length; j++){
				qPos.add(version[j]);
			}
			return (List<ContentDetail>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	private static final Log LOG = LogFactoryUtil.getLog(ContentDetailFinderImpl.class);
}