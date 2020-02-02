package com.example.lbstest.CardView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.etsy.android.grid.StaggeredGridView;
import com.example.lbstest.CardView.card.CardsAnimationAdapter;
import com.example.lbstest.R;
import com.nhaarman.listviewanimations.swinginadapters.AnimationAdapter;

public class CardMainActivity extends AppCompatActivity {

    private StaggeredGridView mPage;
    private int[] imgIds = new int[]{R.drawable.zaoyi,R.drawable.zaowater,
            R.drawable.zaotooth, R.drawable.zaofoot, R.drawable.zaoyao,
            R.drawable.zaovideo, R.drawable.zaosleep,R.drawable.zaoyu};
    private BaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_main);

        mPage = (StaggeredGridView) findViewById(R.id.page);

        mAdapter = new PageAdapter(this, imgIds);
        AnimationAdapter animationAdapter = new CardsAnimationAdapter(mAdapter);
        animationAdapter.setAbsListView(mPage);
        mPage.setAdapter(animationAdapter);
    }
}
