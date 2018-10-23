package vn.linh.androidoptimizerecyclerview;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;

import vn.linh.androidoptimizerecyclerview.adapter.ImageAdapter;
import vn.linh.androidoptimizerecyclerview.model.ImageItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewImage;
    private ImageAdapter adapter;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewImage = findViewById(R.id.recycler_view_image);
        ArrayList<ImageItem> data = new ArrayList<>();
        for (int j = 0; j < 100; j++) {

            data.add(new ImageItem(Color.CYAN, "" + j));
        }

//        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
//        pool.setMaxRecycledViews(0, 10);
//        recyclerViewImage.setRecycledViewPool(pool);
//        recyclerViewImage.setItemViewCacheSize(0);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setInitialPrefetchItemCount(1);
        recyclerViewImage.setLayoutManager(layoutManager);
//        recyclerViewImage.setLayoutManager(new GridLayoutManager(this,6));
        adapter = new ImageAdapter(recyclerViewImage);
        recyclerViewImage.setAdapter(adapter);
        recyclerViewImage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setImages(data);


        findViewById(R.id.button_scroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i = 0; i < 100000; i++){
                    recyclerViewImage.scrollBy(0,10);
                    count++;
                }
//                CountDownTimer countDownTimer = new CountDownTimer(10000,1) {
//                    @Override
//                    public void onTick(long l) {
//                        recyclerViewImage.scrollBy(0,10);
//                        count++;
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        Log.i("TAG", "count = "+count);
//                    }
//                };
//                countDownTimer.start();
            }
        });
    }
}
