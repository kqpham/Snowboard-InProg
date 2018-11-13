package JsonSupport;

import android.support.v7.app.AppCompatActivity;

import EquipmentObjects.BindingsObj;
import EquipmentObjects.BootObj;
import EquipmentObjects.GoggleObj;
import EquipmentObjects.HelmetObj;
import EquipmentObjects.SnowboardObj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonExtractor extends AppCompatActivity {
    private SnowboardObj SB;
    private BootObj boot;
    private BindingsObj binding;
    private GoggleObj goggle;
    private HelmetObj helmet;

    public Object[][] snowboard_arr;
    public Object[][] boot_arr;
    public Object[][] bindings_arr;
    public Object[][] goggle_arr;
    public Object[][]helmet_arr;


    public JsonExtractor() {
        String jsonStr;

        try {
            InputStream is = getApplicationContext().getAssets().open("items.json");
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();
            jsonStr = new String(buffer, "UTF-8");

            JSONObject jsonObj = new JSONObject(jsonStr);

            // Getting JSON Array node
            JSONArray snowboards = jsonObj.getJSONArray("snowboards");


            for (int i = 0; i < snowboards.length(); i++) {

                JSONObject s = snowboards.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                SB = new SnowboardObj(Integer.parseInt(id), name, brand, Float.parseFloat(price), Float.parseFloat(rating), image);


                snowboard_arr[i][0] = id;
                snowboard_arr[i][1] = name;
                snowboard_arr[i][2] = brand;
                snowboard_arr[i][3] = price;
                snowboard_arr[i][4] = rating;
                snowboard_arr[i][5] = image;


            }

            JSONArray Boot = jsonObj.getJSONArray("boots");

            for (int i = 0; i < Boot.length(); i++) {

                JSONObject s = Boot.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                boot = new BootObj(Integer.parseInt(id), name, brand, Float.parseFloat(price), Float.parseFloat(rating), image);

                boot_arr[i][0] = id;
                boot_arr[i][1] = name;
                boot_arr[i][2] = brand;
                boot_arr[i][3] = price;
                boot_arr[i][4] = rating;
                boot_arr[i][5] = image;

            }

            JSONArray bind = jsonObj.getJSONArray("bindings");

            for (int i = 0; i < bind.length(); i++) {

                JSONObject s = bind.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                binding = new BindingsObj(Integer.parseInt(id), name, brand, Float.parseFloat(price), Float.parseFloat(rating), image);

                bindings_arr[i][0] = id;
                bindings_arr[i][1] = name;
                bindings_arr[i][2] = brand;
                bindings_arr[i][3] = price;
                bindings_arr[i][4] = rating;
                bindings_arr[i][5] = image;

            }

            JSONArray GOGGLE = jsonObj.getJSONArray("goggles");

            for (int i = 0; i < GOGGLE.length(); i++) {

                JSONObject s = GOGGLE.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                goggle = new GoggleObj(Integer.parseInt(id), name, brand, Float.parseFloat(price), Float.parseFloat(rating), image);

                goggle_arr[i][0] = id;
                goggle_arr[i][1] = name;
                goggle_arr[i][2] = brand;
                goggle_arr[i][3] = price;
                goggle_arr[i][4] = rating;
                goggle_arr[i][5] = image;

            }

            JSONArray helmets = jsonObj.getJSONArray("helmets");

            for (int i = 0; i < helmets.length(); i++) {

                JSONObject s = helmets.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                helmet = new HelmetObj(Integer.parseInt(id), name, brand, Float.parseFloat(price), Float.parseFloat(rating), image);

                helmet_arr[i][0] = id;
                helmet_arr[i][1] = name;
                helmet_arr[i][2] = brand;
                helmet_arr[i][3] = price;
                helmet_arr[i][4] = rating;
                helmet_arr[i][5] = image;

            }


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
