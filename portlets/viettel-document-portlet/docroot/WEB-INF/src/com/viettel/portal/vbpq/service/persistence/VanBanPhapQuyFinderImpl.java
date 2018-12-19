package com.viettel.portal.vbpq.service.persistence;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.viettel.portal.vbpq.model.VanBanPhapQuy;
import com.viettel.portal.vbpq.model.impl.VanBanPhapQuyImpl;
import com.viettel.portal.vbpq.service.impl.VanBanPhapQuyLocalServiceImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.vbpq.VanBanPhapQuyGrid;

public class VanBanPhapQuyFinderImpl extends BasePersistenceImpl<VanBanPhapQuy>
		implements VanBanPhapQuyFinder {
	/*
	public static final String FINDER_SQL = VanBanPhapQuyFinder.class.getName()
		+ ".finder";

	public static final String COUNT_SQL = VanBanPhapQuyFinder.class.getName()
		+ ".count";
	
	public static final String TIMKIEMVANBAN_SQL = VanBanPhapQuyFinder.class.getName()
			+ ".timKiemVanBanSQL";
	
	public static final String COUNTVANBAN_SQL = VanBanPhapQuyFinder.class.getName()
			+ ".countVanBanSQL";	
	
	public static final String TIMKIEMVANBAN_SQL2 = VanBanPhapQuyFinder.class.getName()
			+ ".timKiemVanBanTheoNgayTaoSQL";
	
	public static final String COUNTVANBAN_SQL2 = VanBanPhapQuyFinder.class.getName()
			+ ".countVanBanTheoNgayTaoSQL";	

	public int count(String keyword, long groupId, long[] loaiVanBanIds,
			long[] linhVucVanBanIds, long[] coQuanBanHanhIds, Integer status,
			Date startDateObj, Date endDateObj) 
		throws SystemException {
		String[] keywords = _getKeywords(keyword);
		boolean andOperator = false;
		if (Validator.isNull(keyword)) {
			andOperator = true;
		}
		return countBy_K(keywords, groupId, loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, 
				status, startDateObj, endDateObj, andOperator);
	}

	public List<VanBanPhapQuy> find(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, Integer status, Date startDateObj,
			Date endDateObj, int start, int end, OrderByComparator obc)
		throws SystemException {
		
		String[] keywords = _getKeywords(keyword);
		boolean andOperator = false;

		if (Validator.isNull(keyword)) {
			andOperator = true;
		}

		return findBy_K(keywords, groupId, loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds,
			status, startDateObj, endDateObj, andOperator, start, end, obc);
	}
	
	private int countBy_K(String[] keywords, long groupId, long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, Integer status,
			Date startDateObj, Date endDateObj, boolean andOperator)
		throws SystemException {
		
		Session session = null;
		
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(trichyeu)",
				StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nguoiky)",
				StringPool.LIKE, true, keywords);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(mavanban)",
				StringPool.LIKE, true, keywords);

			if (ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql = StringUtil.replace(sql, "AND (coquanbanhanh IN ([$WHERE_CQBH$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_CQBH$]", StringUtil.merge(coQuanBanHanhIds));
			}

			if (ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (loaivanban IN ([$WHERE_LVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVB$]", StringUtil.merge(loaiVanBanIds));
			}

			if (ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (linhvucvanban IN ([$WHERE_LVVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVVB$]", StringUtil.merge(linhVucVanBanIds));
			}
			
			if(status == null) {
				sql = StringUtil.replace(sql, "AND (status = ?)",
					StringPool.BLANK);
			}
			
			if(startDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh >= ?)", StringPool.BLANK);
			}
			
			if(endDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh <= ?)", StringPool.BLANK);
			}
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(keywords, 2);
			qPos.add(keywords, 2);
			qPos.add(keywords, 2);
			if(status != null) {
				qPos.add(status);
			}
			
			if(startDateObj != null) {
				//Timestamp startDateTS = CalendarUtil.getTimestamp(startDateObj);
				qPos.add(startDateObj);
			}
			
			if(endDateObj != null) {
				//Timestamp endDateTS = CalendarUtil.getTimestamp(endDateObj);
				qPos.add(endDateObj);
			}
			
			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	private List<VanBanPhapQuy> findBy_K(String[] keywords, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, Integer status,
			Date startDateObj, Date endDateObj, boolean andOperator, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		Session session = null;
		
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(trichyeu)",
					StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nguoiky)",
					StringPool.LIKE, true, keywords);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(mavanban)",
					StringPool.LIKE, true, keywords);

			if (ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql = StringUtil.replace(sql, "AND (coquanbanhanh IN ([$WHERE_CQBH$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_CQBH$]", StringUtil.merge(coQuanBanHanhIds));
			}

			if (ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (loaivanban IN ([$WHERE_LVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVB$]", StringUtil.merge(loaiVanBanIds));
			}

			if (ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (linhvucvanban IN ([$WHERE_LVVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVVB$]", StringUtil.merge(linhVucVanBanIds));
			}
			
			if(status == null) {
				sql = StringUtil.replace(sql, "AND (status = ?)",
					StringPool.BLANK);
			}
			
			if(startDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh >= ?)", StringPool.BLANK);
			}
			
			if(endDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh <= ?)", StringPool.BLANK);
			}
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			System.err.println("VIETTEL PORTAL: " + sql);

			q.addEntity("VanBanPhapQuy", VanBanPhapQuyImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(keywords, 2);

			qPos.add(keywords, 2);
			
			qPos.add(keywords, 2);

			if(status != null) {
				qPos.add(status);
			}
			
			if(startDateObj != null) {
				//Timestamp startDateTS = CalendarUtil.getTimestamp(startDateObj);
				
				qPos.add(startDateObj);
			}
			
			if(endDateObj != null) {
				//Timestamp endDateTS = CalendarUtil.getTimestamp(endDateObj);
				
				qPos.add(endDateObj);
			}

			return (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	private String[] _getKeywords(String keyword) {
		if (Validator.isNull(keyword)) {
			return new String[] {null};
		}
		
		keyword = keyword.trim();
		
		return new String[]{StringUtil.quote(StringUtil.toLowerCase(keyword), 
			StringPool.PERCENT)};
	}
*/
	
	public int timKiemVanBanPhapQuyCount(String keyword,
			long groupId, long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, long[] nhomVanBanIds, Integer status,
			Date startDateObj, Date endDateObj)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			List<Object> params = new ArrayList<Object>();
			String sql = " FROM portal_vanban "
					+ " WHERE (groupId = ?) "
					+ " AND ( (lower(trichyeu) LIKE ? ) OR (lower(nguoiky) LIKE ?) OR (lower(mavanban) LIKE ?) ) "
					;
			params.add(groupId);
			_log.info("VIETTEL PORTAL groupId: " + groupId);
			if(keyword == null){
				keyword = "";
			}
			else{
				keyword = keyword.trim().toLowerCase();
			}
			_log.info("VIETTEL PORTAL keyword: " + "%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			if (!ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql += " AND coquanbanhanh IN (";
				for(int i = 0; i < coQuanBanHanhIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(coQuanBanHanhIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql += " AND loaivanban IN (";
				for(int i = 0; i < loaiVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(loaiVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql += " AND linhvucvanban IN (";
				for(int i = 0; i < linhVucVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(linhVucVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(nhomVanBanIds)) {
				sql += " AND nhomVanBanId IN (";
				for(int i = 0; i < nhomVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(nhomVanBanIds[i]);
				}
				sql += " ) ";
			}
			if(status != null) {
				sql += " AND (status = ?) ";
				params.add(status);
				_log.info("VIETTEL PORTAL status: " + status);
			}
			if(startDateObj != null) {
				sql += " AND (ngaybanhanh >= ?) ";
				params.add(startDateObj);
				_log.info("VIETTEL PORTAL startDateObj: " + startDateObj);
			}
			if(endDateObj != null) {
				sql += " AND (ngaybanhanh <= ?) ";
				Calendar cal = Calendar.getInstance();
				cal.setTime(endDateObj);
				cal.add(Calendar.DATE, 1);
				params.add(cal.getTime());
				_log.info("VIETTEL PORTAL endDateObj: " + endDateObj);
			}
			SQLQuery q = session.createSQLQuery(" SELECT count(*) as TOTAL  " + sql);
			_log.info("VIETTEL PORTAL sql: " + sql);
			q.addScalar("TOTAL", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			for (Object param : params) {
				qPos.add(param);
			}
			int total = 0;
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					total = count.intValue();
					return total;
				}
			}
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return 0;
	}	
	
	public List<VanBanPhapQuy> timKiemVanBanPhapQuyFind(String keyword,
			long groupId, long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, long[] nhomVanBanIds, Integer status,
			Date startDateObj, Date endDateObj, int start,
			int end, OrderByComparator obc, String [] orderBys)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			List<Object> params = new ArrayList<Object>();
			String sql = " FROM portal_vanban "
					+ " WHERE (groupId = ?) "
					+ " AND ( (lower(trichyeu) LIKE ? ) OR (lower(nguoiky) LIKE ?) OR (lower(mavanban) LIKE ?) ) "
					;
			params.add(groupId);
			_log.info("VIETTEL PORTAL groupId: " + groupId);
			if(keyword == null){
				keyword = "";
			}
			else{
				keyword = keyword.trim().toLowerCase();
			}
			_log.info("VIETTEL PORTAL keyword: " + "%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			if (!ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql += " AND coquanbanhanh IN (";
				for(int i = 0; i < coQuanBanHanhIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(coQuanBanHanhIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql += " AND loaivanban IN (";
				for(int i = 0; i < loaiVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(loaiVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql += " AND linhvucvanban IN (";
				for(int i = 0; i < linhVucVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(linhVucVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(nhomVanBanIds)) {
				sql += " AND nhomVanBanId IN (";
				for(int i = 0; i < nhomVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(nhomVanBanIds[i]);
				}
				sql += " ) ";
			}
			if(status != null) {
				sql += " AND (status = ?) ";
				params.add(status);
				_log.info("VIETTEL PORTAL status: " + status);
			}
			if(startDateObj != null) {
				sql += " AND (ngaybanhanh >= ?) ";
				params.add(startDateObj);
				_log.info("VIETTEL PORTAL startDateObj: " + startDateObj);
			}
			if(endDateObj != null) {
				sql += " AND (ngaybanhanh <= ?) ";
				Calendar cal = Calendar.getInstance();
				cal.setTime(endDateObj);
				cal.add(Calendar.DATE, 1);
				params.add(cal.getTime());
				_log.info("VIETTEL PORTAL endDateObj: " + endDateObj);
			}
			sql  = " SELECT *  " + sql + " order by ngaybanhanh desc, ngaysua desc ";
			SQLQuery q = session.createSQLQuery(sql);
			if(obc != null){
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			}
			if (orderBys != null && orderBys.length > 0) {
				sql += " order by ";
				for (int i = 0; i < orderBys.length; i++) {
					if (orderBys[i].trim().length() > 0) {
						String[]ss = orderBys[i].split("_");
						sql += ss[0] + " " + ss[1];
						if (i + 1 < orderBys.length) sql += ", ";
					}
				}
			}	
			q.addEntity("VanBanPhapQuy", VanBanPhapQuyImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			for (Object param : params) {
				qPos.add(param);
			}
			List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(), start, end);
			return list;
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public VanBanPhapQuyGrid timKiemVanBanPhapQuy(String keyword,
			long groupId, long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, long[] nhomVanBanIds, Integer status,
			Date startDateObj, Date endDateObj, int start,
			int end, OrderByComparator obc, String [] orderBys)
		throws SystemException {

		Session session = null;
		VanBanPhapQuyGrid grid = new VanBanPhapQuyGrid();
		try {
			session = openSession();
			List<Object> params = new ArrayList<Object>();
			String sql = " FROM portal_vanban "
					+ " WHERE (groupId = ?) "
					+ " AND ( (lower(trichyeu) LIKE ? ) OR (lower(nguoiky) LIKE ?) OR (lower(mavanban) LIKE ?) ) "
					;
			params.add(groupId);
			_log.info("VIETTEL PORTAL groupId: " + groupId);
			if(keyword == null){
				keyword = "";
			}
			else{
				keyword = keyword.trim().toLowerCase();
			}
			_log.info("VIETTEL PORTAL keyword: " + "%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			if (!ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql += " AND coquanbanhanh IN (";
				for(int i = 0; i < coQuanBanHanhIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(coQuanBanHanhIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql += " AND loaivanban IN (";
				for(int i = 0; i < loaiVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(loaiVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql += " AND linhvucvanban IN (";
				for(int i = 0; i < linhVucVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(linhVucVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(nhomVanBanIds)) {
				sql += " AND nhomVanBanId IN (";
				for(int i = 0; i < nhomVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(nhomVanBanIds[i]);
				}
				sql += " ) ";
			}
			if(status != null) {
				sql += " AND (status = ?) ";
				params.add(status);
				_log.info("VIETTEL PORTAL status: " + status);
			}
			if(startDateObj != null) {
				sql += " AND (ngaybanhanh >= ?) ";
				params.add(startDateObj);
				_log.info("VIETTEL PORTAL startDateObj: " + startDateObj);
			}
			if(endDateObj != null) {
				sql += " AND (ngaybanhanh <= ?) ";
				Calendar cal = Calendar.getInstance();
				cal.setTime(endDateObj);
				cal.add(Calendar.DATE, 1);
				params.add(cal.getTime());
				_log.info("VIETTEL PORTAL endDateObj: " + endDateObj);
			}
			SQLQuery q = session.createSQLQuery(" SELECT count(*) as TOTAL  " + sql);
			_log.info("VIETTEL PORTAL sql: " + sql);
			q.addScalar("TOTAL", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			for (Object param : params) {
				qPos.add(param);
			}
			int total = 0;
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					total = count.intValue();
				}
			}
			_log.info("VIETTEL PORTAL total: " + total);
			List<VanBanPhapQuy> list = null;
			if(total > 0){
				sql  = " SELECT *  " + sql + " order by ngaybanhanh desc, ngaysua desc ";
				q = session.createSQLQuery(sql);
				if(obc != null){
					sql = CustomSQLUtil.replaceOrderBy(sql, obc);
				}
				if (orderBys != null && orderBys.length > 0) {
					sql += " order by ";
					for (int i = 0; i < orderBys.length; i++) {
						if (orderBys[i].trim().length() > 0) {
							String[]ss = orderBys[i].split("_");
							sql += ss[0] + " " + ss[1];
							if (i + 1 < orderBys.length) sql += ", ";
						}
					}
				}
				_log.info("VIETTEL PORTAL sql: " + sql);
				q.addEntity("VanBanPhapQuy", VanBanPhapQuyImpl.class);
				qPos = QueryPos.getInstance(q);
				for (Object param : params) {
					qPos.add(param);
				}
				list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(), start, end);
			}
			grid.setTotal(total);
			grid.setList(list);
			return grid;
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public VanBanPhapQuyGrid timKiemVanBanPhapQuyTheoNgayTao(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds, long[] nhomVanBanIds,
			Integer status, Date startDateObj, Date endDateObj, int start,
			int end, OrderByComparator obc, String[] orderBys) throws Exception {
		
		Session session = null;
		VanBanPhapQuyGrid grid = new VanBanPhapQuyGrid();
		try {
			session = openSession();
			List<Object> params = new ArrayList<Object>();
			String sql = " FROM portal_vanban "
					+ " WHERE (groupId = ?) "
					+ " AND ( (lower(trichyeu) LIKE ? ) OR (lower(nguoiky) LIKE ?) OR (lower(mavanban) LIKE ?) ) "
					;
			params.add(groupId);
			_log.info("VIETTEL PORTAL groupId: " + groupId);
			if(keyword == null){
				keyword = "";
			}
			else{
				keyword = keyword.trim().toLowerCase();
			}
			_log.info("VIETTEL PORTAL keyword: " + "%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			params.add("%" + keyword + "%");
			if (!ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql += " AND coquanbanhanh IN (";
				for(int i = 0; i < coQuanBanHanhIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(coQuanBanHanhIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql += " AND loaivanban IN (";
				for(int i = 0; i < loaiVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(loaiVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql += " AND linhvucvanban IN (";
				for(int i = 0; i < linhVucVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(linhVucVanBanIds[i]);
				}
				sql += " ) ";
			}
			if (!ArrayUtil.isEmpty(nhomVanBanIds)) {
				sql += " AND nhomVanBanId IN (";
				for(int i = 0; i < nhomVanBanIds.length; i++){
					sql += (i == 0 ? " ? " : ", ?");
					params.add(nhomVanBanIds[i]);
				}
				sql += " ) ";
			}
			if(status != null) {
				sql += " AND (status = ?) ";
				params.add(status);
				_log.info("VIETTEL PORTAL status: " + status);
			}
			if(startDateObj != null) {
				sql += " AND (ngaytao >= ?) ";
				params.add(startDateObj);
				_log.info("VIETTEL PORTAL startDateObj: " + startDateObj);
			}
			if(endDateObj != null) {
				sql += " AND (ngaytao <= ?) ";
				Calendar cal = Calendar.getInstance();
				cal.setTime(endDateObj);
				cal.add(Calendar.DATE, 1);
				params.add(cal.getTime());
				_log.info("VIETTEL PORTAL endDateObj: " + endDateObj);
			}
			SQLQuery q = session.createSQLQuery(" SELECT count(*) as TOTAL  " + sql);
			_log.info("VIETTEL PORTAL sql: " + sql);
			q.addScalar("TOTAL", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			for (Object param : params) {
				qPos.add(param);
			}
			int total = 0;
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					total = count.intValue();
				}
			}
			_log.info("VIETTEL PORTAL total: " + total);
			List<VanBanPhapQuy> list = null;
			if(total > 0){
				sql  = " SELECT *  " + sql + " order by ngaytao desc, ngaysua desc ";
				q = session.createSQLQuery(sql);
				if(obc != null){
					sql = CustomSQLUtil.replaceOrderBy(sql, obc);
				}
				if (orderBys != null && orderBys.length > 0) {
					sql += " order by ";
					for (int i = 0; i < orderBys.length; i++) {
						if (orderBys[i].trim().length() > 0) {
							String[]ss = orderBys[i].split("_");
							sql += ss[0] + " " + ss[1];
							if (i + 1 < orderBys.length) sql += ", ";
						}
					}
				}				
				q.addEntity("VanBanPhapQuy", VanBanPhapQuyImpl.class);
				qPos = QueryPos.getInstance(q);
				for (Object param : params) {
					qPos.add(param);
				}
				list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(), start, end);
			}
			grid.setTotal(total);
			grid.setList(list);
			return grid;
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(VanBanPhapQuyLocalServiceImpl.class);
}
