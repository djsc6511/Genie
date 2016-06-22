package org.androidtown.genie;

/**
 * Created by soongu on 2016-05-22.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CFviewer extends Fragment {

    ListView listView;
    static int flag;
    static String CFclassification;
    static ArrayList<String> tmp_idRequest = new ArrayList<String>();
    String idRequest;
    static String email;
    public CFviewer() {
    }

    public static CFviewer newInstance(ArrayList<String> con,
                                     String classification,ArrayList<String> idReq,String em) {
        CFviewer fragment = new CFviewer();
        Bundle bundle = new Bundle();
        CFclassification=classification;
        Log.d("classifi",classification);
        email = em;
        if(classification=="help"){
            flag=0;
            for(int i=0;i<con.size();i++){
                bundle.putString("help"+Integer.valueOf(i),con.get(i));
                Log.d("con",con.get(i));
                tmp_idRequest.add(idReq.get(i));
                Log.d("tmp",tmp_idRequest.get(i));
                flag++;
            }

            fragment.setArguments(bundle);

        }
        if(classification=="item"){
            flag=0;
            for(int i=0;i<con.size();i++){
                bundle.putString("item"+Integer.valueOf(i),con.get(i));
                tmp_idRequest.add(idReq.get(i));
                flag++;
            }
            fragment.setArguments(bundle);
        }
        if(classification=="study"){
            flag=0;
            for(int i=0;i<con.size();i++){
                bundle.putString("study"+Integer.valueOf(i),con.get(i));
                tmp_idRequest.add(idReq.get(i));
                flag++;
            }
            fragment.setArguments(bundle);

        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainboard, container, false);

        ArrayList<String> list = new ArrayList<String>();
        Log.d("cladsfa",CFclassification);
        if(CFclassification=="help"){
            for(int i=0;i<flag;i++){
                list.add(getArguments().getString("help" + Integer.valueOf(i)));
                Log.d("list",list.get(i));
            }
        }
        if(CFclassification=="item"){
            for(int i=0;i<flag;i++){
                list.add(getArguments().getString("item" + Integer.valueOf(i)));
            }
        }
        if(CFclassification=="study"){
            for(int i=0;i<flag;i++){
                list.add(getArguments().getString("study" + Integer.valueOf(i)));
            }
        }

        ArrayAdapter<String> listAdapter;
        listAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1,list);
        listView = (ListView)view.findViewById(R.id.listView2);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                idRequest = tmp_idRequest.get(position);

                Intent intent = new Intent(getActivity(),ViewmylistInfo.class);
                Id ider = new Id(email,idRequest);
                intent.putExtra("emailidRequest",ider);
                startActivity(intent);
            }
        });
        return view;
    }

}
