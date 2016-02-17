package org.tmr.telehealth.util;

import android.util.Xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by tmr on 10/02/2016.
 */
public class Utils {

    private Utils(){}

    public static String inputStreamToString (InputStream is, Charset charset) throws IOException {

        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, charset));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }

        return inputStringBuilder.toString();
    }
}
