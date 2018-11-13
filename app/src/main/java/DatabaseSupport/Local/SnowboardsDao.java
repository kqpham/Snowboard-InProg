package DatabaseSupport.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import DatabaseSupport.Model.Snowboards;

@Dao
public interface SnowboardsDao {
    @Query("SELECT * from snowboards_table")
    List<Snowboards> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Snowboards... snowboardDbs);

    @Insert
    void insertSnowboard(Snowboards data);


    @Query("SELECT * FROM snowboards_table WHERE snowboard_id = :idVal")
    public Snowboards getSnowboardById(String idVal);


    @Query("DELETE FROM snowboards_table")
    void deleteAll();
}
