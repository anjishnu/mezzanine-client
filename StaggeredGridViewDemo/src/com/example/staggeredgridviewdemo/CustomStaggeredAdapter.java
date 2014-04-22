package com.example.staggeredgridviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.staggeredgridviewdemo.StaggeredAdapter.ViewHolder;
import com.example.staggeredgridviewdemo.loader.ImageLoader;
import com.example.staggeredgridviewdemo.views.ScaleImageView;

public class CustomStaggeredAdapter extends ArrayAdapter<String> {

		//private ImageLoader mLoader;

		public CustomStaggeredAdapter(Context context, int textViewResourceId,
				String[] objects) {
			super(context, textViewResourceId, objects);
			//mLoader = new ImageLoader(context);
		}

	     
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;

			if (convertView == null) {
				LayoutInflater layoutInflator = LayoutInflater.from(getContext());
				convertView = layoutInflator.inflate(R.layout.row_staggered_demo,
						null);
				holder = new ViewHolder();
				holder.imageView = (ScaleImageView) convertView .findViewById(R.id.imageView1);
				convertView.setTag(holder);
			}

			holder = (ViewHolder) convertView.getTag();
			String resourceURL = getItem(position);
			Log.i("MyActivity", "found:"+ resourceURL);
			DisplayImage(getItem(position), holder.imageView);
			return convertView;
		}
		
	    public void DisplayImage(String url, ImageView imageView)
	    {
	   
	        Bitmap bitmap = BitmapFactory.decodeFile(url);
	    	//Bitmap bitmap=memoryCache.get(url);
	        if(bitmap!=null)
	            imageView.setImageBitmap(bitmap);
	        else
	        {
	            imageView.setImageDrawable(null);
	        }
	    }

		static class ViewHolder {
			ScaleImageView imageView;
		}
	}


