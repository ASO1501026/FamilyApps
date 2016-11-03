package jp.ac.asojuku.st.familyapps;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by momosakishigetada on 2016/11/02.
 */
public class MealViewHolder extends RecyclerView.ViewHolder{

    View base;
    TextView textViewMeal;

    public MealViewHolder(View v){
        super(v);
        this.base = v;
        this.textViewMeal = (TextView) v.findViewById(R.id.comment);
    }

}
