package dal;

import dao.Mainlist;

import java.util.List;

public interface MainlistDao {
    void save(Mainlist entity);

    List<Mainlist> findAll();

    Mainlist findById(Long MainlistId);
}
