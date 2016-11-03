package jp.ac.asojuku.st.familyapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by momosakishigetada on 2016/11/02.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        //縦スクロール
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);

        ArrayList<MealData> meal = new ArrayList<MealData>();
        for (int i = 0; i < MyData.mealArray.length; i++) {
            meal.add(new MealData(
                    MyData.mealArray[i]
            ));
        }

        RecyclerView.Adapter adapter = new MealAdapter(meal);
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(meal.size() - 1);//最後までスクロール

    }
}
