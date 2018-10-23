package vn.linh.androidoptimizerecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.linh.androidoptimizerecyclerview.R;
import vn.linh.androidoptimizerecyclerview.model.ImageItem;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemImageHolder> {
    final String TAG = getClass().getSimpleName();
    private int createViewHolderCount;
    private RecyclerView mRecyclerView;
    public List<ImageItem> imageItems = new ArrayList<>();

    public ImageAdapter(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    public void setImages(List<ImageItem> imageItems) {
        this.imageItems = imageItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        Log.i(TAG, "onCreateViewHolder "
                + createViewHolderCount++
                + " pool:"
                + mRecyclerView.getRecycledViewPool().getRecycledViewCount(0));
//        mRecyclerView.setItemViewCacheSize();
        ItemImageHolder holder = new ItemImageHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemImageHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder pos:"
                + position
                + " reused-value:"
                + holder.tvTitle.getText()
                + " pool:"
                + mRecyclerView.getRecycledViewPool().getRecycledViewCount(0));
        ImageItem imageItem = imageItems.get(position);
        holder.tvTitle.setText(imageItem.getText());
        holder.root.setBackgroundColor(imageItem.getColor());
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    class ItemImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public View root;
        public TextView tvTitle;

        public ItemImageHolder(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            tvTitle = itemView.findViewById(R.id.text_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
