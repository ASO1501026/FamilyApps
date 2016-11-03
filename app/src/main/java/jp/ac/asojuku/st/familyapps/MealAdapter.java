package jp.ac.asojuku.st.familyapps;

import android.app.Activity;
import android.content.Intent;
import android.net.sent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import jp.ac.asojuku.st.familyapps.MealData;
import jp.ac.asojuku.st.familyapps.MealViewHolder;

/**
 * Created by momosakishigetada on 2016/11/02.
 */
public class MealAdapter extends RecyclerView.Adapter<MealViewHolder> {
    private ArrayList<MealData> rouletteDataSet;

    public MealAdapter(ArrayList<MealData> roulette){

        this.rouletteDataSet = roulette;
    }
    //新しいViewを作成する
    //レイアウトマネージャーにより起動される
    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //parentはRecyclerView
        //public View inflate(int resource,ViewGroup root,boolean attachToRoot)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout,parent,false);

        return new MealViewHolder(view);
    }
    //Viewの内容を交換する（リサイクルだから）
    //レイアウトマネージャーにより起動される
    @Override
    public void onBindViewHolder(final MealViewHolder holder,final int listPosition){

        holder.textViewMeal.setText(rouletteDataSet.get(listPosition).getMeal());
        holder.base.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //vはcardView
                sent sent = sent.parse("mailto:");
                Intent intent = new Intent(Intent.ACTION_SENDTO,sent);
                intent.putExtra(Intent.EXTRA_SUBJECT,"今日のメイン料理");
                intent.putExtra(Intent.EXTRA_TEXT,"今日のメインは" + rouletteDataSet.get(listPosition) + "です。");
                startActivity(intent);


            }
        });
    }
    @Override
    public int getItemCount(){
        return rouletteDataSet.size();
    }

}
