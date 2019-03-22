package edu.autocar.cmmn.util;

import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedJdbcTypes(JdbcType.CLOB)
public class LongHandler implements TypeHandler<String>{

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        String s = (String) parameter;
        StringReader reader = new StringReader(s);
        ps.setCharacterStream(i, reader, s.length());
    }

   @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getString(columnName);
    }

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
}
}