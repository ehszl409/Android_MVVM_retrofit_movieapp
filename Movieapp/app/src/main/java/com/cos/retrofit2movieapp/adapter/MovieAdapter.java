package com.cos.retrofit2movieapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.retrofit2movieapp.MainActivity;
import com.cos.retrofit2movieapp.R;
import com.cos.retrofit2movieapp.databinding.CardItemBinding;
import com.cos.retrofit2movieapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private static final String TAG = "MovieAdapter";
    private List<Movie> movies = new ArrayList<>();

    // 컨텍스트를 받아오는 방법
    private final MainActivity mContext;

    public MovieAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }

    // 데이터를 설정하기 위해 함수를 만들어 줬다.
    public void setMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }


    // 아이템 아이디를 찾기위한 함수
    public long getMovieId(int position){
        return movies.get(position).getId();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardItemBinding cardItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.card_item,
                parent,
                false
        );

        return new MovieViewHolder(cardItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        // 데이터 바인드 5번 째
        holder.cardItemBinding.setMovie(movies.get(position));

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    // card_item 디자인이 연결 된다.
    class MovieViewHolder extends RecyclerView.ViewHolder{

        // 데이터 바인딩 해보기 (순서중요)
        // 데이터 바인딩 4번 째
        // 타입 이름 = 데이터 바인딩 하는 레이아웃+Binding
        private CardItemBinding cardItemBinding;

        public MovieViewHolder(@NonNull CardItemBinding cardItemBinding) {
            super(cardItemBinding.getRoot());
            this.cardItemBinding = cardItemBinding;

        }
    }
}
