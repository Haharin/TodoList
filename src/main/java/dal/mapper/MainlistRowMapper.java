package dal.mapper;

import dao.Mainlist;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainlistRowMapper extends BeanPropertyRowMapper {

    public MainlistRowMapper(Class mappedClass) {
        super(mappedClass);
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mainlist mainlist = new Mainlist();
        mainlist.setMainId(rs.getLong("ID"));
        mainlist.setName(rs.getString("NAME"));

        String stringDateTime = rs.getString("DATE_TIME");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm:SS");
        LocalDateTime localDateTime = formatter.parseLocalDateTime(stringDateTime);
        mainlist.setDateTime(localDateTime);

        mainlist.setDescriotion(rs.getString("Description"));
        mainlist.setImportance(rs.getBoolean("Importance"));
        mainlist.setPeriod(rs.getLong("Period"));
        mainlist.setNotification(rs.getBoolean("Notification"));
        return mainlist;
    }

}