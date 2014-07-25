package sk.apupo.shoppinglist.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by APUPO on 7/24/2014.
 */
public class AssetsFileReader {

    public static ArrayList<Object> readStringFile(Context context, String fileName) {

        ArrayList<Object> out = new ArrayList<Object>();

        BufferedReader reader = null;

        InputStream in = null;

        try {
            reader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(fileName, Context.MODE_WORLD_READABLE)));

            String line = "";
            while((line = reader.readLine()) != null) {
                out.add(line.toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(reader != null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return out;
    }
}
