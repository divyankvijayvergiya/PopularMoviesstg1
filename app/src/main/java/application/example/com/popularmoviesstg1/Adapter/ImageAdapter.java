package application.example.com.popularmoviesstg1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import application.example.com.popularmoviesstg1.Model.GridMovieItem;
import application.example.com.popularmoviesstg1.R;


public class ImageAdapter extends ArrayAdapter<GridMovieItem> {
    private static final String BASE_URL = "http://image.tmdb.org/t/p/w185";
    private ArrayList<GridMovieItem> movieItems=null;


    public ImageAdapter(Context context, List<GridMovieItem> t) {
        super(context, 0, t);


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.activity_griditem, parent, false);
        }
        ImageView imageView_item = (ImageView) convertView.findViewById(R.id.item_image);
        GridMovieItem movieItem = getItem(position);


        Picasso.with(getContext()).load(BASE_URL.concat(movieItem.getPosterPath())).placeholder(R.drawable.placeholder).error(R.drawable.user_placeholder_error).fit().into(imageView_item);


        return convertView;
    }
    public void setData(ArrayList<GridMovieItem> movieData){
        movieItems=movieData;
        notifyDataSetChanged();

    }
    public void clearMoviePosterData() {
        movieItems.clear();
        notifyDataSetChanged();
    }

}







