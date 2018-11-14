package DatabaseSupport.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import DatabaseSupport.Model.Goggles;


@Dao
public interface GogglesDao {
    @Query("SELECT * from goggles_table")
    List<Goggles> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Goggles... gogglesDbs);

    @Insert
    void insertGoggle(Goggles data);

    @Query("SELECT * FROM goggles_table WHERE goggle_id = :idVal")
    public Goggles getGogglebyId(String idVal);

    @Query("DELETE FROM goggles_table")
    void deleteAll();
}
