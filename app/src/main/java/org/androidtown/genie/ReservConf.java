package org.androidtown.genie;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by soongu on 2016-05-12.
 */
public class ReservConf extends Activity{

    String url ="http://192.168.0.21/genie/main.php";
    TextView sub;
    TextView cont;
    String idRequest;
    String subject;
    String content;
    String email;
    String v_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board2);


        Intent intent = getIntent();
        idRequest = intent.getStringExtra("idRequest");
        email = intent.getStringExtra("email");
        Log.d("222222", idRequest);
        Log.d("222222", email);
        SendPost sendPost = new SendPost();
        sendPost.execute("0");

    }

    public void onreservconfButton(View v){
        Intent intent = new Intent(getApplicationContext(),)
    }
    public void onReserClickedButton(View v){
        SendPost sendPost = new SendPost();
        sendPost.execute("1");
    }

    private class SendPost extends AsyncTask<String, Void, String> {
        String param;

        @Override
        protected String doInBackground(String... params) {
            param=params[0];

            try {
                if(param=="0"){
                    ArrayList<NameValuePair> pair = new ArrayList<NameValuePair>();
                    pair.add(new BasicNameValuePair("msgType","4"));
                    pair.add(new BasicNameValuePair("idRequest", idRequest));

                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url);
                    post.setEntity(new UrlEncodedFormEntity(pair,"UTF-8"));
                    HttpResponse response = client.execute(post);

                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);
                    JSONObject jobj = new JSONObject(data);
                    JSONObject jreal = jobj.getJSONObject("result");

                    subject = jreal.getString("subject");
                    content = jreal.getString("content");
                }

                if(param=="1"){
                    ArrayList<NameValuePair> pair = new ArrayList<NameValuePair>();
                    pair.add(new BasicNameValuePair("msgType","7"));
                    pair.add(new BasicNameValuePair("idRequest", idRequest));
                    pair.add(new BasicNameValuePair("email", email));

                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url);
                    post.setEntity(new UrlEncodedFormEntity(pair,"UTF-8"));
                    HttpResponse response = client.execute(post);

                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);
                    JSONObject jobj = new JSONObject(data);

                    v_flag = jobj.getString("result");
                    Log.d("v_flag",v_flag);
                }


                    //Log.d("11111111",tmp_content[i]);


            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String str) {
            if(param =="0"){
                sub = (TextView)findViewById(R.id.subject_2);
                cont = (TextView)findViewById(R.id.content_2);
                sub.setText(subject);
                cont.setText(content);
            }
            if(param=="1"){
                Toast.makeText(getApplicationContext(),"예약되었습니다.",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
