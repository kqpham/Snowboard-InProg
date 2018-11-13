package DatabaseSupport.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import DatabaseSupport.Model.Boots;

@Dao
public interface BootsDao {
    @Query("SELECT * from boots_table")
    List<Boots> getAll();

@Insert(onConflict = OnConflictStrategy.REPLACE)
void insertAll(Boots... bootsDbs);

    @Insert
    void insertBoot(Boots data);

    @Query("SELECT * FROM boots_table WHERE boot_id = :idVal")
    public Boots getBootbyId(String idVal);


    @Query("DELETE FROM boots_table")
    void deleteAll();
}
