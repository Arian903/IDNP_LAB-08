package com.example.lab08_idnp;
import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Helper {
    public static final String FILE_NAME = "register.txt";

    public void writeFile(String pos, Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILE_NAME, MODE_PRIVATE | MODE_APPEND);
            fos.write(pos.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

}
