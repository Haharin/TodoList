package dal.mapper;

import dao.Addlist;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddlistRowMapper extends BeanPropertyRowMapper {

    public AddlistRowMapper(Class mappedClass) {
        super(mappedClass);
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Addlist addlist = new Addlist();
        addlist.setAddId(rs.getLong("ID"));
        addlist.setMainlistId(rs.getLong("MAIN_ID"));
        addlist.setAddName(rs.getString("ADD_NAME"));
        addlist.setAddDescription(rs.getString("DESCRIPTION"));
        return addlist;
    }

}
