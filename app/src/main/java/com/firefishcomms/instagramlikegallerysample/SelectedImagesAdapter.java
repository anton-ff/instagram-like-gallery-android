package com.firefishcomms.instagramlikegallerysample;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Varun on 01/07/15.
 */
public class SelectedImagesAdapter extends RecyclerView.Adapter<SelectedImagesAdapter.SelectedImageViewHolder> {

    private BaseActivity activity;
    private List<SelectedImagesItem> data;
    private SelectedImageViewHolder selectedHolder;

    public SelectedImagesAdapter(BaseActivity a, List<SelectedImagesItem> d) {
        this.activity = a;
        this.data = d;
    }

    @Override
    public SelectedImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_selected_images, viewGroup, false);
        return new SelectedImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SelectedImageViewHolder holder, final int position) {
        final SelectedImagesItem selectedImagesItem = data.get(position);
        holder.selectedImagesItem = selectedImagesItem;

        int desiredSize = (int) (Resources.getSystem().getDisplayMetrics().widthPixels * 0.85f);

        ViewGroup.LayoutParams lpm = holder.iv_selected_image.getLayoutParams();
        lpm.width = desiredSize;
        holder.iv_selected_image.setLayoutParams(lpm);

        Picasso.get().load(selectedImagesItem.imageFile).resize(desiredSize,0).centerInside().into(holder.iv_selected_image, new Callback() {
            @Override
            public void onSuccess() {
//                holder.gpuImage.setImage(((BitmapDrawable)holder.iv_selected_image.getDrawable()).getBitmap());
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SelectedImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView iv_selected_image;
        public SelectedImagesItem selectedImagesItem;

        public SelectedImageViewHolder(View v) {
            super(v);
            this.iv_selected_image = v.findViewById(R.id.iv_selected_image);
            this.iv_selected_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
