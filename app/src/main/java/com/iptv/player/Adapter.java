package com.iptv.player;

import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class Adapter extends RecyclerView.Adapter<Adapter.H>{
 List<Channel> list; OnClick click;
 interface OnClick{void c(Channel ch);}
 public Adapter(List<Channel> l,OnClick c){list=l;click=c;}

 static class H extends RecyclerView.ViewHolder{
  TextView t; H(View v){super(v);t=v.findViewById(R.id.name);}
 }

 public H onCreateViewHolder(ViewGroup p,int v){
  return new H(LayoutInflater.from(p.getContext()).inflate(R.layout.item,p,false));
 }
 public void onBindViewHolder(H h,int i){
  Channel c=list.get(i); h.t.setText(c.name);
  h.itemView.setOnClickListener(v->click.c(c));
 }
 public int getItemCount(){return list.size();}
}
