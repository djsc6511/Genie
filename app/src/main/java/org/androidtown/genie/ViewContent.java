package org.androidtown.genie;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by soongu on 2016-05-12.
 */
public class ViewContent extends Activity{
    String subject ="";
    String content ="";
    String url ="http://192.168.0.3:80/genie/main.php";
    TextView sub;
    TextView cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board3);
        sub = (TextView)findViewById(R.id.subject_3);
        cont = (TextView)findViewById(R.id.content_3);
        new SendPost1().execute(url);
    }

    private class SendPost1 extends AsyncTask<String, Void, String> {
        String param;

        @Override
        protected String doInBackground(String... params) {

            param = params[0];
            StringBuilder jsonHtml = new StringBuilder();
            try {
                URL uri = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) uri.openConnection();

                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader br = new BufferedReader
                                (new InputStreamReader(conn.getInputStream(), "UTF-8"));

                        while (true) {
                            String line = br.readLine();
                            if (line == null)
                                break;
                            jsonHtml.append(line + "\n");
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonHtml.toString();
        }

        protected void onPostExecute(String str) {

            try{
                JSONObject jObject = new JSONObject(str);

               // JSONArray result = jObject.getJSONArray("result");

                subject = jObject.get("subject").toString();
                content = jObject.get("content").toString();

                sub.setText(subject);
                cont.setText(content);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
