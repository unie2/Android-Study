package com.example.phpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "userID";
    private static final String TAG_PASSWORD = "userPassword";
    private static final String TAG_NAME = "userName";
    private static final String TAG_AGE = "userAge" ;

    JSONArray info = null;

    ArrayList<HashMap<String, String>> infoList;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        infoList = new ArrayList<HashMap<String, String>>();
        getData("http://IP주소/PHP_connection.php");
    }

    protected void showList() {
        try {
            JSONObject jsonObject = new JSONObject(myJSON);
            info = jsonObject.getJSONArray(TAG_RESULTS);

            for (int i=0; i<info.length(); i++) {
                JSONObject c = info.getJSONObject(i);
                String userID = c.getString(TAG_ID);
                String userPassword = c.getString(TAG_PASSWORD);
                String userName = c.getString(TAG_NAME);
                String userAge = c.getString(TAG_AGE);

                HashMap<String, String> infos = new HashMap<String, String>();

                infos.put(TAG_ID, userID);
                infos.put(TAG_PASSWORD, userPassword);
                infos.put(TAG_NAME, userName);
                infos.put(TAG_AGE, userAge);

                infoList.add(infos);
            }

            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, infoList, R.layout.list_item,
                    new String[]{TAG_ID, TAG_PASSWORD, TAG_NAME, TAG_AGE},
                    new int[]{R.id.userID, R.id.userPassword, R.id.userName, R.id.userAge}
            );

            list.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                System.out.println("result: " + result);
                myJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }
}