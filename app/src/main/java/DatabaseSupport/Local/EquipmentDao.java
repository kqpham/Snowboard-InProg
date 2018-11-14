package DatabaseSupport.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import DatabaseSupport.Model.Equipment;


@Dao
public interface EquipmentDao {
    @Query("SELECT * from equipment")
    List<Equipment> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Equipment... equipments);

    @Insert
    void insertEquipment(Equipment data);

    @Delete
    void delete(Equipment equipment);


    @Query("SELECT * FROM equipment WHERE equipment_Id = :idVal")
    public Equipment getEqipmentById(String idVal);


    @Query("DELETE FROM equipment")
    void deleteAll();
}
