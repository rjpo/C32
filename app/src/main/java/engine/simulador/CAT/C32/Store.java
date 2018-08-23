package engine.simulador.CAT.C32;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public class Store extends AppCompatActivity {

    public void write(String key, String value) {
        SharedPreferences global = getSharedPreferences("stores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = global.edit();
        editor.putString(key, value).apply();
    }

    public String get(String key) {
        SharedPreferences global = getSharedPreferences("stores", Context.MODE_PRIVATE);
        return global.getString(key, "");
    }
}
