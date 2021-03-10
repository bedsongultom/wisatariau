package com.bedsongultom.wisatariau.ui.newsupdate;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bedsongultom.wisatariau.R;
import com.bedsongultom.wisatariau.ui.newsdetails.NewsDetailFragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class NewsUpdateFragment extends Fragment {

    private NewsUpdateViewModel newsUpdateViewModel;
    RecyclerView rv;
    EditText edt;
    Button btn;
    ProgressBar pb;

    HttpURLConnection connection;
    //add class berita in array list

  //  ArrayList<News> all_berita;
    NewsAdapter adapter;
    RequestNews req;


    private ArrayList<News> all_berita = new ArrayList<News>();
    private Context context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsUpdateViewModel =
                ViewModelProviders.of(this).get(NewsUpdateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_newsupdate, container, false);

        final TextView textView = root.findViewById(R.id.text_newsupdate);
        rv = (RecyclerView) root.findViewById(R.id.recycler_view);
        edt = (EditText) root.findViewById(R.id.edit_cari);
        btn = (Button) root.findViewById(R.id.btn_cari);
        pb = (ProgressBar) root.findViewById(R.id.pb);

        rv.setHasFixedSize(true);


        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(edt.getText().toString());
            }
        });





        rv.addOnItemTouchListener(new RecyclerTouchListener(context,
                rv, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final News item = all_berita.get(position);
                adapter.editItem(position);
                adapter.notifyItemChanged(position);



                NewsDetailFragment fragment = new NewsDetailFragment(); // replace your custom fragment class
                Bundle bundle = new Bundle();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                bundle.putString("judul", item.getJudul());
                bundle.putString("poster", item.getPoster());
                bundle.putString("link", item.getLink());
                bundle.putString("tipe", item.getTipe());
                bundle.putString("waktu", item.getWaktu());
                bundle.putString("kutipan", item.getKutipan());

                fragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.frame_newsupdate,fragment);
                fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.remove();
                fragmentTransaction.commit();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        reload();

        newsUpdateViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


    void reload() {
        //inisialisasi all berita
        all_berita = new ArrayList<>();
        req = new RequestNews();
        pb.setVisibility(View.VISIBLE);
        req.execute("https://berita-news.herokuapp.com/search/?q=teknologi");
    }

    void search(String data) {
        //inisialisasi all berita
        all_berita = new ArrayList<>();
        req = new RequestNews();
        pb.setVisibility(View.VISIBLE);
        req.execute("https://berita-news.herokuapp.com/search/?q="+data);
    }

    private static interface ClickListener{
        public void onClick(View view,int position);
        public void onLongClick(View view,int position);
    }



    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView rv, final ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=rv.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,rv.getChildAdapterPosition(child));
                    }
                }
            });
        }


        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }


        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


    public class RequestNews extends AsyncTask<String, Void, Boolean> {

        @Override
        //calling this class we can do that with ctr+ o
        // internet connection
        protected Boolean doInBackground(String... params) {
            // for handling errors
            try {

                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                //10000 ->10 second
                connection.setReadTimeout(10000);
                connection.setConnectTimeout(10000);
                connection.setDoInput(true);
                connection.connect();

                int status = connection.getResponseCode();
                if (status == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    //append--> this function for read and  add data
                    sb.append(br.readLine()).append("\n");
                    br.close();

                    JSONObject data = new JSONObject(sb.toString());
                    //sukses is an object from server
                    if (data.getInt("status") == 200) {
                        JSONArray array_data = data.getJSONArray("data");
                        all_berita = new ArrayList<>();
                        for (int i = 0; i< array_data.length(); i++){
                            News news = new News();
                            JSONObject isi_data = array_data.getJSONObject(i);

                            news.setPoster(isi_data.getString("poster"));
                            news.setJudul(isi_data.getString("judul"));
                            news.setTipe(isi_data.getString("tipe"));
                            news.setWaktu(isi_data.getString("waktu"));
                            news.setLink(isi_data.getString("link"));
                            news.setKutipan(isi_data.getString("kutipan"));

                            all_berita.add(news);



                        }


                    }

                }//end if
                else
                {

                    return false;
                }


            }
            catch (MalformedURLException e) {

                e.printStackTrace();
            }
            // catch (IOExecption e){
            // e.printStackTrace();
            //  }

            catch (UnknownHostException abc){
                if (connection != null){
                    connection.disconnect();
                }
            }catch (Exception abc){
                if(connection != null){
                    connection.disconnect();
                }

            }
            return true;
        }

        @Override
        //calling this class we can do that with ctr+ o
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            // pb= pogressbar for hidden posgresbars
            pb.setVisibility(View.GONE);
            if (!aBoolean){
                Toast.makeText(getContext(), "maaf ada yang bersalah", Toast.LENGTH_LONG);
            }
            adapter = new NewsAdapter(getContext(), all_berita);
            rv.setAdapter(adapter);


        }
    }


}