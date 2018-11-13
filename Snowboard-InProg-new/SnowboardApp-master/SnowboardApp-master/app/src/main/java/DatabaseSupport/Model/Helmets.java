package DatabaseSupport.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "helmets_table")
public class Helmets {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public Integer helmet_id;
    @ColumnInfo(name = "helmet_name")
    public String name;
    @ColumnInfo(name = "brand_info")
    public String brand;
    @ColumnInfo(name = "price_info")
    public Float price;
    @ColumnInfo(name = "rating_info")
    public Float rating;
    @ColumnInfo(name = "image_url")
    public String imageURL;
}
