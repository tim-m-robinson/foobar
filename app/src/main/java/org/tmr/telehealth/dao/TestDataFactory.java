package org.tmr.telehealth.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tmr.telehealth.util.Utils;

import android.content.Context;

import org.tmr.telehealth.R;

import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by tmr on 10/02/2016.
 */
public class TestDataFactory {

    private Context _ctx = null;

    private TestDataFactory(Context ctx){
        super();
        setContext(ctx);
        readEventData();
        readMessageData();
    };

    public static TestDataFactory newInstance(Context ctx) {
        return new TestDataFactory(ctx);
    }

    public String getRawEventData() throws IOException {
        InputStream is = getContext().getResources().openRawResource(R.raw.events);

        String result = Utils.inputStreamToString(is, Charset.forName("UTF-8"));

        try {
            is.close();
        } catch (IOException e) {
            //ignore!!
        } finally {
            is = null;
        }

        return result;
    }

    public Event[] getEventData() throws IOException, JSONException, javax.xml.datatype.DatatypeConfigurationException {
        ArrayList<Event> result =  new ArrayList<Event>();

        String eventJsonData = getRawEventData();

        if (eventJsonData != null) {
            JSONArray jsonArray = new JSONArray(eventJsonData);
            for(int i = 0; i < jsonArray.length(); i++) {
                result.add(Event.parseJson(jsonArray.getJSONObject(i)));
            }

        }
        return result.toArray(new Event[0]);
    }

    public Message[] getMessageData() {
        return ( (Message[]) new ArrayList<Message>().toArray() );

    }

    private void setContext(Context ctx) {
        this._ctx = ctx;
    }

    private Context getContext() {
        return _ctx;
    }

    private void readEventData() {

    }

    private void readMessageData() {

    }
}
