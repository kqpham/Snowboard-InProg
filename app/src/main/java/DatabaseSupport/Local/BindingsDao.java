package DatabaseSupport.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import DatabaseSupport.Model.Bindings;

@Dao
public interface BindingsDao {
    @Query("SELECT * from bindings_table")
    List<Bindings> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Bindings... bindingsDbs);

    @Insert
    void insertBinding(Bindings data);

    @Query("SELECT * FROM bindings_table WHERE binding_id = :idVal")
    public Bindings getBindingById(String idVal);

    @Query("DELETE FROM bindings_table")
    void deleteAll();
}
