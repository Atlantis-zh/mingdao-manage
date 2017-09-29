package com.mingdao.dao.base.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.mingdao.enumprop.MemberShipSource;

/**
 *
 * <code>MemberShipSourceEnumTypeHandler<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月29日 上午10:57:49
 * @author libinf
 */

public class MemberShipSourceEnumTypeHandler extends BaseTypeHandler<MemberShipSource> {
	private Class<MemberShipSource> type;

	private final MemberShipSource[] enums;

	public MemberShipSourceEnumTypeHandler(Class<MemberShipSource> type) {
		if (type == null)
			throw new IllegalArgumentException("Type argument cannot be null");
		this.type = type;
		this.enums = type.getEnumConstants();
		if (this.enums == null)
			throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
	}


	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, MemberShipSource parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public MemberShipSource getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int i = rs.getInt(columnName);
		if (rs.wasNull()) {
			return null;
		} else {
			// 根据数据库中的code值，定位EnumStatus子类
			return locateEnumStatus(i);
		}
	}

	@Override
	public MemberShipSource getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int i = rs.getInt(columnIndex);
		if (rs.wasNull()) {
			return null;
		} else {
			// 根据数据库中的code值，定位EnumStatus子类
			return locateEnumStatus(i);
		}
	}

	@Override
	public MemberShipSource getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int i = cs.getInt(columnIndex);
		if (cs.wasNull()) {
			return null;
		} else {
			// 根据数据库中的code值，定位EnumStatus子类
			return locateEnumStatus(i);
		}
	}

	private MemberShipSource locateEnumStatus(int code) {
		for (MemberShipSource enumValue : enums) {
			if (enumValue.getValue() == (Integer.valueOf(code))) {
				return enumValue;
			}
		}
		throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + type.getSimpleName());
	}

}
