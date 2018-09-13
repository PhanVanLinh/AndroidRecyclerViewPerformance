package vn.linh.androidoptimizerecyclerview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import vn.linh.androidoptimizerecyclerview.adapter.ImageAdapter;
import vn.linh.androidoptimizerecyclerview.model.ImageItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewImage;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewImage = findViewById(R.id.recycler_view_image);
        ArrayList<ImageItem> data = new ArrayList<>();
        for (int j = 0; j < 20; j++) {

            data.add(new ImageItem(Color.CYAN, "" + j));
        }

        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        pool.setMaxRecycledViews(0, 10);

//        recyclerViewImage.setRecycledViewPool(pool);
        recyclerViewImage.setItemViewCacheSize(0);

        recyclerViewImage.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ImageAdapter();
        recyclerViewImage.setAdapter(adapter);
        recyclerViewImage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setImages(data);
    }
}
