package DatabaseSupport;

import android.os.AsyncTask;
import android.util.Log;

import DatabaseSupport.Model.Bindings;
import DatabaseSupport.Model.Boots;
import DatabaseSupport.Model.Equipment;
import DatabaseSupport.Model.EquipmentSetDetail;
import DatabaseSupport.Model.Goggles;
import DatabaseSupport.Model.Helmets;
import DatabaseSupport.Model.Snowboards;

import static android.support.constraint.Constraints.TAG;

public class DatabaseInitializer {

    private static final int DELAY_MILLIS = 500;

    public static void populateAsync(final AppDatabase db)
    {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }
    private static void PopulateWithTestData(AppDatabase db)
    {
        Log.d(TAG, "PopulateWithTestData: adding json data");
        db.bindingsModel().deleteAll();
        db.bootsModel().deleteAll();
        db.equipmentModel().deleteAll();
        db.equipmentSetDetailModel().deleteAll();
        db.gogglesModel().deleteAll();
        db.helmetsModel().deleteAll();
        db.snowboardModel().deleteAll();

        //Populate data here using JSON import and call appropriate add functions from below.
        
    }

    private static void addBinding(final AppDatabase db, final Integer id, final String name, final String brand, final Float price, final Float rating, final String imageURL)
    {
        Bindings bindings = new Bindings();
        bindings.binding_id = id;
        bindings.name = name;
        bindings.brand = brand;
        bindings.price = price;
        bindings.rating = rating;
        bindings.imageURL = imageURL;
        db.bindingsModel().insertBinding(bindings);
    }

    private static void addBoots(final AppDatabase db, final Integer id, final String name, final String brand, final Float price, final Float rating, final String imageURL)
    {
        Boots boots = new Boots();
        boots.boot_id = id;
        boots.name = name;
        boots.brand = brand;
        boots.price = price;
        boots.rating = rating;
        boots.imageURL = imageURL;
        db.bootsModel().insertBoot(boots);
    }

    private static void addGoggle(final AppDatabase db, final Integer id, final String name, final String brand, final Float price, final Float rating, final String imageURL)
    {
        Goggles goggles = new Goggles();
        goggles.goggle_id = id;
        goggles.name = name;
        goggles.brand = brand;
        goggles.price = price;
        goggles.rating = rating;
        goggles.imageURL = imageURL;
        db.gogglesModel().insertGoggle(goggles);
    }

    private static void addHelmet(final AppDatabase db, final Integer id, final String name, final String brand, final Float price, final Float rating, final String imageURL)
    {
        Helmets helmets = new Helmets();
        helmets.helmet_id = id;
        helmets.name = name;
        helmets.brand = brand;
        helmets.price = price;
        helmets.rating = rating;
        helmets.imageURL = imageURL;
        db.helmetsModel().insertHelmet(helmets);
    }

    private static void addSnowboard(final AppDatabase db, final Integer id, final String name, final String brand, final Float price, final Float rating, final String imageURL)
    {
        Snowboards snowboards = new Snowboards();
        snowboards.snowboard_id = id;
        snowboards.name = name;
        snowboards.brand = brand;
        snowboards.price = price;
        snowboards.rating = rating;
        snowboards.imageURL = imageURL;
        db.snowboardModel().insertSnowboard(snowboards);
    }

    private static void addEquipment(final AppDatabase db, final Integer id, final String setName, final String setBudget)
    {
        Equipment equipment = new Equipment();
        equipment.equipment_Id = id;
        equipment.setName = setName;
        equipment.setBudget=setBudget;
        db.equipmentModel().insertEquipment(equipment);
    }

    private static void addEquipmentSetDetail(final AppDatabase db, final Integer id, final Integer snowboard, final Integer boot, final Integer glove, final Integer binding, final Integer helmet, final Integer goggle )
    {
        EquipmentSetDetail equipmentSetDetail = new EquipmentSetDetail();
        equipmentSetDetail.equip_id = id;
        equipmentSetDetail.binding_id =binding;
        equipmentSetDetail.boot_id=boot;
        equipmentSetDetail.helmet_id=helmet;
        equipmentSetDetail.goggle_id=goggle;
        equipmentSetDetail.snowboard_id=snowboard;
        db.equipmentSetDetailModel().insertEquipmentSetDetail(equipmentSetDetail);
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void,Void>{
        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) { mDb =db;}


        @Override
        protected Void doInBackground(final Void... voids) {
            PopulateWithTestData(mDb);
            return null;
        }
    }
}


