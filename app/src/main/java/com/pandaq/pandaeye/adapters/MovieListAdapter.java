package com.pandaq.pandaeye.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.entity.DouBan.MovieSubject;
import com.pandaq.pandaqlib.magicrecyclerView.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PandaQ on 2016/9/12.
 * email : 767807368@qq.com
 */
public class MovieListAdapter extends BaseRecyclerAdapter<MovieSubject> {

    private Fragment mFragment;

    public MovieListAdapter(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, MovieSubject data) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.mMovieName.setText(data.getTitle());
        float rate = data.getRating().getAverage();
        holder.mMovieRate.setText(toString(rate));
        holder.mMovieStarts.setRating(rate / 2);
        Glide.with(mFragment)
                .load(data.getImages().getMedium())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mMoviePic);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_pic)
        ImageView mMoviePic;
        @BindView(R.id.movie_name)
        TextView mMovieName;
        @BindView(R.id.movie_starts)
        RatingBar mMovieStarts;
        @BindView(R.id.movie_rate)
        TextView mMovieRate;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    protected String toString(Object string) {
        return string + "";
    }

}