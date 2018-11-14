package DatabaseSupport.Model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "equipment")
public class Equipment {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public Integer equipment_Id;

    @ColumnInfo(name = "Set_Name")
    public String setName;

    @ColumnInfo(name = "Set_Budget")
    public String setBudget;
}
