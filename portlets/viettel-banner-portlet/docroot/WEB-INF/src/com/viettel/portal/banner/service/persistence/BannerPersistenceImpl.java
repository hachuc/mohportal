/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package com.viettel.portal.banner.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.viettel.portal.banner.NoSuchBannerException;
import com.viettel.portal.banner.model.Banner;
import com.viettel.portal.banner.model.impl.BannerImpl;
import com.viettel.portal.banner.model.impl.BannerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the banner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see BannerPersistence
 * @see BannerUtil
 * @generated
 */
public class BannerPersistenceImpl extends BasePersistenceImpl<Banner>
	implements BannerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BannerUtil} to access the banner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BannerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Boolean.class.getName() },
			BannerModelImpl.TRANGTHAI_COLUMN_BITMASK |
			BannerModelImpl.ORDER__COLUMN_BITMASK |
			BannerModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the banners where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findByTrangThai(boolean trangThai)
		throws SystemException {
		return findByTrangThai(trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the banners where trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findByTrangThai(boolean trangThai, int start, int end)
		throws SystemException {
		return findByTrangThai(trangThai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners where trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findByTrangThai(boolean trangThai, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { trangThai };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { trangThai, start, end, orderByComparator };
		}

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Banner banner : list) {
				if ((trangThai != banner.getTrangThai())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

				if (!pagination) {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Banner>(list);
				}
				else {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first banner in the ordered set where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByTrangThai_First(boolean trangThai,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByTrangThai_First(trangThai, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the first banner in the ordered set where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByTrangThai_First(boolean trangThai,
		OrderByComparator orderByComparator) throws SystemException {
		List<Banner> list = findByTrangThai(trangThai, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner in the ordered set where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByTrangThai_Last(boolean trangThai,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByTrangThai_Last(trangThai, orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the last banner in the ordered set where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByTrangThai_Last(boolean trangThai,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTrangThai(trangThai);

		if (count == 0) {
			return null;
		}

		List<Banner> list = findByTrangThai(trangThai, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where trangThai = &#63;.
	 *
	 * @param id the primary key of the current banner
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner[] findByTrangThai_PrevAndNext(long id, boolean trangThai,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, banner, trangThai,
					orderByComparator, true);

			array[1] = banner;

			array[2] = getByTrangThai_PrevAndNext(session, banner, trangThai,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByTrangThai_PrevAndNext(Session session, Banner banner,
		boolean trangThai, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(trangThai);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banners where trangThai = &#63; from the database.
	 *
	 * @param trangThai the trang thai
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTrangThai(boolean trangThai) throws SystemException {
		for (Banner banner : findByTrangThai(trangThai, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(banner);
		}
	}

	/**
	 * Returns the number of banners where trangThai = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTrangThai(boolean trangThai) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TRANGTHAI;

		Object[] finderArgs = new Object[] { trangThai };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TRANGTHAI_TRANGTHAI_2 = "banner.trangThai = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HIENTHI = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHienThi",
			new String[] {
				Boolean.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HIENTHI =
		new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHienThi",
			new String[] { Boolean.class.getName(), Date.class.getName() },
			BannerModelImpl.TRANGTHAI_COLUMN_BITMASK |
			BannerModelImpl.NGAYKETTHUC_COLUMN_BITMASK |
			BannerModelImpl.ORDER__COLUMN_BITMASK |
			BannerModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HIENTHI = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHienThi",
			new String[] { Boolean.class.getName(), Date.class.getName() });

	/**
	 * Returns all the banners where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findByHienThi(boolean trangThai, Date ngayKetThuc)
		throws SystemException {
		return findByHienThi(trangThai, ngayKetThuc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findByHienThi(boolean trangThai, Date ngayKetThuc,
		int start, int end) throws SystemException {
		return findByHienThi(trangThai, ngayKetThuc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findByHienThi(boolean trangThai, Date ngayKetThuc,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HIENTHI;
			finderArgs = new Object[] { trangThai, ngayKetThuc };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HIENTHI;
			finderArgs = new Object[] {
					trangThai, ngayKetThuc,
					
					start, end, orderByComparator
				};
		}

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Banner banner : list) {
				if ((trangThai != banner.getTrangThai()) ||
						!Validator.equals(ngayKetThuc, banner.getNgayKetThuc())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_HIENTHI_TRANGTHAI_2);

			boolean bindNgayKetThuc = false;

			if (ngayKetThuc == null) {
				query.append(_FINDER_COLUMN_HIENTHI_NGAYKETTHUC_1);
			}
			else {
				bindNgayKetThuc = true;

				query.append(_FINDER_COLUMN_HIENTHI_NGAYKETTHUC_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

				if (bindNgayKetThuc) {
					qPos.add(CalendarUtil.getTimestamp(ngayKetThuc));
				}

				if (!pagination) {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Banner>(list);
				}
				else {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByHienThi_First(boolean trangThai, Date ngayKetThuc,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByHienThi_First(trangThai, ngayKetThuc,
				orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", ngayKetThuc=");
		msg.append(ngayKetThuc);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the first banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByHienThi_First(boolean trangThai, Date ngayKetThuc,
		OrderByComparator orderByComparator) throws SystemException {
		List<Banner> list = findByHienThi(trangThai, ngayKetThuc, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByHienThi_Last(boolean trangThai, Date ngayKetThuc,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByHienThi_Last(trangThai, ngayKetThuc,
				orderByComparator);

		if (banner != null) {
			return banner;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("trangThai=");
		msg.append(trangThai);

		msg.append(", ngayKetThuc=");
		msg.append(ngayKetThuc);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBannerException(msg.toString());
	}

	/**
	 * Returns the last banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByHienThi_Last(boolean trangThai, Date ngayKetThuc,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHienThi(trangThai, ngayKetThuc);

		if (count == 0) {
			return null;
		}

		List<Banner> list = findByHienThi(trangThai, ngayKetThuc, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the banners before and after the current banner in the ordered set where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * @param id the primary key of the current banner
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner[] findByHienThi_PrevAndNext(long id, boolean trangThai,
		Date ngayKetThuc, OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByHienThi_PrevAndNext(session, banner, trangThai,
					ngayKetThuc, orderByComparator, true);

			array[1] = banner;

			array[2] = getByHienThi_PrevAndNext(session, banner, trangThai,
					ngayKetThuc, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByHienThi_PrevAndNext(Session session, Banner banner,
		boolean trangThai, Date ngayKetThuc,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

		query.append(_FINDER_COLUMN_HIENTHI_TRANGTHAI_2);

		boolean bindNgayKetThuc = false;

		if (ngayKetThuc == null) {
			query.append(_FINDER_COLUMN_HIENTHI_NGAYKETTHUC_1);
		}
		else {
			bindNgayKetThuc = true;

			query.append(_FINDER_COLUMN_HIENTHI_NGAYKETTHUC_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(trangThai);

		if (bindNgayKetThuc) {
			qPos.add(CalendarUtil.getTimestamp(ngayKetThuc));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the banners where trangThai = &#63; and ngayKetThuc = &#63; from the database.
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHienThi(boolean trangThai, Date ngayKetThuc)
		throws SystemException {
		for (Banner banner : findByHienThi(trangThai, ngayKetThuc,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(banner);
		}
	}

	/**
	 * Returns the number of banners where trangThai = &#63; and ngayKetThuc = &#63;.
	 *
	 * @param trangThai the trang thai
	 * @param ngayKetThuc the ngay ket thuc
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHienThi(boolean trangThai, Date ngayKetThuc)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HIENTHI;

		Object[] finderArgs = new Object[] { trangThai, ngayKetThuc };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_HIENTHI_TRANGTHAI_2);

			boolean bindNgayKetThuc = false;

			if (ngayKetThuc == null) {
				query.append(_FINDER_COLUMN_HIENTHI_NGAYKETTHUC_1);
			}
			else {
				bindNgayKetThuc = true;

				query.append(_FINDER_COLUMN_HIENTHI_NGAYKETTHUC_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangThai);

				if (bindNgayKetThuc) {
					qPos.add(CalendarUtil.getTimestamp(ngayKetThuc));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_HIENTHI_TRANGTHAI_2 = "banner.trangThai = ? AND ";
	private static final String _FINDER_COLUMN_HIENTHI_NGAYKETTHUC_1 = "banner.ngayKetThuc IS NULL";
	private static final String _FINDER_COLUMN_HIENTHI_NGAYKETTHUC_2 = "banner.ngayKetThuc = ?";

	public BannerPersistenceImpl() {
		setModelClass(Banner.class);
	}

	/**
	 * Caches the banner in the entity cache if it is enabled.
	 *
	 * @param banner the banner
	 */
	@Override
	public void cacheResult(Banner banner) {
		EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey(), banner);

		banner.resetOriginalValues();
	}

	/**
	 * Caches the banners in the entity cache if it is enabled.
	 *
	 * @param banners the banners
	 */
	@Override
	public void cacheResult(List<Banner> banners) {
		for (Banner banner : banners) {
			if (EntityCacheUtil.getResult(
						BannerModelImpl.ENTITY_CACHE_ENABLED, BannerImpl.class,
						banner.getPrimaryKey()) == null) {
				cacheResult(banner);
			}
			else {
				banner.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all banners.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BannerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BannerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the banner.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Banner banner) {
		EntityCacheUtil.removeResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Banner> banners) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Banner banner : banners) {
			EntityCacheUtil.removeResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
				BannerImpl.class, banner.getPrimaryKey());
		}
	}

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param id the primary key for the new banner
	 * @return the new banner
	 */
	@Override
	public Banner create(long id) {
		Banner banner = new BannerImpl();

		banner.setNew(true);
		banner.setPrimaryKey(id);

		return banner;
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the banner
	 * @return the banner that was removed
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner remove(long id) throws NoSuchBannerException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner that was removed
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner remove(Serializable primaryKey)
		throws NoSuchBannerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Banner banner = (Banner)session.get(BannerImpl.class, primaryKey);

			if (banner == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBannerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(banner);
		}
		catch (NoSuchBannerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Banner removeImpl(Banner banner) throws SystemException {
		banner = toUnwrappedModel(banner);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(banner)) {
				banner = (Banner)session.get(BannerImpl.class,
						banner.getPrimaryKeyObj());
			}

			if (banner != null) {
				session.delete(banner);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (banner != null) {
			clearCache(banner);
		}

		return banner;
	}

	@Override
	public Banner updateImpl(com.viettel.portal.banner.model.Banner banner)
		throws SystemException {
		banner = toUnwrappedModel(banner);

		boolean isNew = banner.isNew();

		BannerModelImpl bannerModelImpl = (BannerModelImpl)banner;

		Session session = null;

		try {
			session = openSession();

			if (banner.isNew()) {
				session.save(banner);

				banner.setNew(false);
			}
			else {
				session.merge(banner);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BannerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bannerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bannerModelImpl.getOriginalTrangThai()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { bannerModelImpl.getTrangThai() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}

			if ((bannerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HIENTHI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bannerModelImpl.getOriginalTrangThai(),
						bannerModelImpl.getOriginalNgayKetThuc()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HIENTHI, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HIENTHI,
					args);

				args = new Object[] {
						bannerModelImpl.getTrangThai(),
						bannerModelImpl.getNgayKetThuc()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HIENTHI, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HIENTHI,
					args);
			}
		}

		EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey(), banner);

		return banner;
	}

	protected Banner toUnwrappedModel(Banner banner) {
		if (banner instanceof BannerImpl) {
			return banner;
		}

		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setNew(banner.isNew());
		bannerImpl.setPrimaryKey(banner.getPrimaryKey());

		bannerImpl.setId(banner.getId());
		bannerImpl.setTen(banner.getTen());
		bannerImpl.setFileId(banner.getFileId());
		bannerImpl.setFileLink(banner.getFileLink());
		bannerImpl.setFileName(banner.getFileName());
		bannerImpl.setFileSize(banner.getFileSize());
		bannerImpl.setNgayTao(banner.getNgayTao());
		bannerImpl.setNgaySua(banner.getNgaySua());
		bannerImpl.setNgayKetThuc(banner.getNgayKetThuc());
		bannerImpl.setLienKet(banner.getLienKet());
		bannerImpl.setOrder_(banner.getOrder_());
		bannerImpl.setTrangThai(banner.isTrangThai());
		bannerImpl.setNguoiTao(banner.getNguoiTao());
		bannerImpl.setNguoiTaoId(banner.getNguoiTaoId());
		bannerImpl.setNguoiSua(banner.getNguoiSua());
		bannerImpl.setNguoiSuaId(banner.getNguoiSuaId());
		bannerImpl.setCompanyId(banner.getCompanyId());
		bannerImpl.setGroupId(banner.getGroupId());

		return bannerImpl;
	}

	/**
	 * Returns the banner with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByPrimaryKey(primaryKey);

		if (banner == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBannerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return banner;
	}

	/**
	 * Returns the banner with the primary key or throws a {@link com.viettel.portal.banner.NoSuchBannerException} if it could not be found.
	 *
	 * @param id the primary key of the banner
	 * @return the banner
	 * @throws com.viettel.portal.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByPrimaryKey(long id)
		throws NoSuchBannerException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Banner banner = (Banner)EntityCacheUtil.getResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
				BannerImpl.class, primaryKey);

		if (banner == _nullBanner) {
			return null;
		}

		if (banner == null) {
			Session session = null;

			try {
				session = openSession();

				banner = (Banner)session.get(BannerImpl.class, primaryKey);

				if (banner != null) {
					cacheResult(banner);
				}
				else {
					EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
						BannerImpl.class, primaryKey, _nullBanner);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
					BannerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return banner;
	}

	/**
	 * Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the banner
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the banners.
	 *
	 * @return the banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @return the range of banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the banners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.banner.model.impl.BannerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of banners
	 * @param end the upper bound of the range of banners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Banner> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BANNER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BANNER;

				if (pagination) {
					sql = sql.concat(BannerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Banner>(list);
				}
				else {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the banners from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Banner banner : findAll()) {
			remove(banner);
		}
	}

	/**
	 * Returns the number of banners.
	 *
	 * @return the number of banners
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BANNER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the banner persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.viettel.portal.banner.model.Banner")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Banner>> listenersList = new ArrayList<ModelListener<Banner>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Banner>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BannerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BANNER = "SELECT banner FROM Banner banner";
	private static final String _SQL_SELECT_BANNER_WHERE = "SELECT banner FROM Banner banner WHERE ";
	private static final String _SQL_COUNT_BANNER = "SELECT COUNT(banner) FROM Banner banner";
	private static final String _SQL_COUNT_BANNER_WHERE = "SELECT COUNT(banner) FROM Banner banner WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "banner.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Banner exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Banner exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BannerPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "ten", "fileId", "fileLink", "fileName", "fileSize",
				"ngayTao", "ngaySua", "ngayKetThuc", "lienKet", "order_",
				"trangThai", "nguoiTao", "nguoiTaoId", "nguoiSua", "nguoiSuaId",
				"companyId"
			});
	private static Banner _nullBanner = new BannerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Banner> toCacheModel() {
				return _nullBannerCacheModel;
			}
		};

	private static CacheModel<Banner> _nullBannerCacheModel = new CacheModel<Banner>() {
			@Override
			public Banner toEntityModel() {
				return _nullBanner;
			}
		};
}