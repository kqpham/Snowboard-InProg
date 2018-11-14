package DatabaseSupport.Local;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import DatabaseSupport.Model.EquipmentSetDetail;

@Dao
public interface EquipmentSetDetailDao {
    @Query("SELECT * from equipment_set_detail")
    List<EquipmentSetDetail> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(EquipmentSetDetail... equipmentSetDetails);

    @Insert
    void insertEquipmentSetDetail(EquipmentSetDetail data);

    @Query("SELECT * FROM equipment_set_detail WHERE equip_id = :idVal")
    public EquipmentSetDetail getEqipmentSetDetailById(String idVal);


    @Query("DELETE FROM equipment_set_detail")
    void deleteAll();
}
