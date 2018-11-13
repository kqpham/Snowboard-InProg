package DatabaseSupport.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import DatabaseSupport.Model.Helmets;

@Dao
public interface HelmetsDao {
    @Query("SELECT * from helmets_table")
    List<Helmets> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserAll(Helmets... helmetsDbs);

    @Insert
    void insertHelmet(Helmets data);

    @Query("SELECT * FROM helmets_table WHERE helmet_id = :idVal")
    public Helmets getHelmetbyId(String idVal);


    @Query("DELETE FROM helmets_table")
    void deleteAll();
}
