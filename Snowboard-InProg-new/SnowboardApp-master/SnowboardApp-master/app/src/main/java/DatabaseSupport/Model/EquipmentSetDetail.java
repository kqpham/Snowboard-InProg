package DatabaseSupport.Model;



import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "equipment_set_detail",
        foreignKeys = @ForeignKey(  entity = Equipment.class,
                                    parentColumns = "equipment_Id",
                                    childColumns ="equip_id" ))
public class EquipmentSetDetail {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "equip_id")
    public Integer equip_id;

    @ColumnInfo(name = "snowboard")
    public Integer snowboard_id;

    @ColumnInfo(name = "boot")
    public Integer boot_id;

    @ColumnInfo(name = "binding")
    public Integer binding_id;

    @ColumnInfo(name = "helmet")
    public Integer helmet_id;

    @ColumnInfo(name = "goggle")
    public Integer goggle_id;
}
