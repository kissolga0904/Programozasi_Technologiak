import java.sql.PreparedStatement;
import java.util.List;

public interface Dao<T>{
    List<T> getAll();
    void delete(int id);
    void insert(String sql);
    void update(T t);
}
