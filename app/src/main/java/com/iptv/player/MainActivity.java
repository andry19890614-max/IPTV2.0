package com.iptv.player;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.PlayerView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

 List<Channel> list=new ArrayList<>();
 Adapter adapter;
 ExoPlayer player;

 protected void onCreate(Bundle b){
  super.onCreate(b);
  setContentView(R.layout.activity_main);

  RecyclerView rv=findViewById(R.id.list);
  rv.setLayoutManager(new LinearLayoutManager(this));

  adapter=new Adapter(list,c->play(c.url));
  rv.setAdapter(adapter);

  PlayerView pv=findViewById(R.id.player);
  player=new ExoPlayer.Builder(this).build();
  pv.setPlayer(player);

  Button load=findViewById(R.id.load);
  load.setOnClickListener(v->loadTest());
 }

 void loadTest(){
  list.clear();
  list.add(new Channel("Test 1","https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8"));
  list.add(new Channel("Test 2","https://test-streams.mux.dev/test_001/stream.m3u8"));
  adapter.notifyDataSetChanged();
 }

 void play(String u){
  MediaItem i=MediaItem.fromUri(Uri.parse(u));
  player.setMediaItem(i);
  player.prepare();
  player.play();
 }

 protected void onDestroy(){
  super.onDestroy();
  player.release();
 }
}
