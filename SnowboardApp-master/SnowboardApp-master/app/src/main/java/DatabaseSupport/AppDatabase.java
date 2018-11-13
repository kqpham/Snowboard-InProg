package DatabaseSupport;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import DatabaseSupport.Local.BindingsDao;
import DatabaseSupport.Local.BootsDao;
import DatabaseSupport.Local.EquipmentDao;
import DatabaseSupport.Local.EquipmentSetDetailDao;
import DatabaseSupport.Local.GogglesDao;
import DatabaseSupport.Local.HelmetsDao;
import DatabaseSupport.Local.SnowboardsDao;
import DatabaseSupport.Model.Bindings;
import DatabaseSupport.Model.Boots;
import DatabaseSupport.Model.Equipment;
import DatabaseSupport.Model.EquipmentSetDetail;
import DatabaseSupport.Model.Goggles;
import DatabaseSupport.Model.Helmets;
import DatabaseSupport.Model.Snowboards;

import static android.support.constraint.Constraints.TAG;

@Database(entities = {Bindings.class, Boots.class,Equipment.class,EquipmentSetDetail.class,Goggles.class,Helmets.class,Snowboards.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract BindingsDao bindingsModel();
    public abstract BootsDao bootsModel();
    public abstract EquipmentDao equipmentModel();
    public abstract EquipmentSetDetailDao equipmentSetDetailModel();
    public abstract GogglesDao gogglesModel();
    public abstract HelmetsDao helmetsModel();
    public abstract SnowboardsDao snowboardModel();

    public static AppDatabase getInMemoryDatabase(Context context){
        if(INSTANCE == null)
        {
            INSTANCE = Room.inMemoryDatabaseBuilder(context,AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static AppDatabase getFileDatabase(Context context)
    {
        Log.d(TAG, "getFileDatabase: in getfiledatabase");
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class, "snowboard-db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {INSTANCE =null;}
}
