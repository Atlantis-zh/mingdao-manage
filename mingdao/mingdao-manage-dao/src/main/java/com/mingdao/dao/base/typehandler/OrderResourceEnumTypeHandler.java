package com.mingdao.dao.base.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.mingdao.enumprop.OrderResource;

/**
 *
 * <code>OrderResourceEnumTypeHandler<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月15日 下午3:31:14
 * @author libinf
 */

public class OrderResourceEnumTypeHandler extends BaseTypeHandler<OrderResource> {

	private Class<OrderResource> type;
	private final OrderResource[] enums;

	public OrderResourceEnumTypeHandler(Class<OrderResource> type) {
		if (type == null)
			throw new IllegalArgumentException("Type argument cannot be null");
		this.type = type;
		this.enums = type.getEnumConstants();
		if (this.enums == null)
			throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, OrderResource parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public OrderResource getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
		int i = rs.getInt(columnName);
		if (rs.wasNull()) {
			return null;
		} else {
			// 根据数据库中的code值，定位EnumStatus子类
			return locateEnumStatus(i);
		}
	}

	@Override
	public OrderResource getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
		int i = rs.getInt(columnIndex);
		if (rs.wasNull()) {
			return null;
		} else {
			// 根据数据库中的code值，定位EnumStatus子类
			return locateEnumStatus(i);
		}
	}

	@Override
	public OrderResource getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
		int i = cs.getInt(columnIndex);
		if (cs.wasNull()) {
			return null;
		} else {
			// 根据数据库中的code值，定位EnumStatus子类
			return locateEnumStatus(i);
		}
	}

	/**
	 * 枚举类型转换，由于构造函数获取了枚举的子类enums，让遍历更加高效快捷
	 * 
	 * @param code
	 *            数据库中存储的自定义code属性
	 * @return code对应的枚举类
	 */
	private OrderResource locateEnumStatus(int code) {
		for (OrderResource enumValue : enums) {
			if (enumValue.getValue() == (Integer.valueOf(code))) {
				return enumValue;
			}
		}
		throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + type.getSimpleName());
	}

}
