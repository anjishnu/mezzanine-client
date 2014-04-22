package com.example.staggeredgridviewdemo;

import java.io.File;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.origamilabs.library.views.StaggeredGridView;
import com.origamilabs.library.views.StaggeredGridView.OnItemClickListener;


public class MainActivity extends Activity   {

		
	/**
	 * This will not work so great since the heights of the imageViews 
	 * are calculated on the imageLoader callback ruining the offsets. To fix this try to get 
	 * the (intrinsic) image width and height and set the views height manually. I will
	 * look into a fix once I find extra time.
	 */
	@Override

	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StaggeredGridView gridView = (StaggeredGridView) this.findViewById(R.id.staggeredGridView1);		
		
		int margin = getResources().getDimensionPixelSize(R.dimen.margin);
		gridView.setItemMargin(margin); // set the GridView margin
		gridView.setPadding(margin, 0, margin, 0); // have the margin on the sides as well 

		
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
              
              String targetPath = ExternalStorageDirectoryPath + "/DCIM/Camera/";
              
              Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
              File targetDirector = new File(targetPath);
              File[] files = targetDirector.listFiles();
              shuffleArray(files);
              String[] uri = new String[files.length];
              int index =0;
              
              for (File file: files)
              {		
            	  uri[index] = file.getAbsolutePath();
            	  index +=1;
              }
            	  
              CustomStaggeredAdapter adapter = new CustomStaggeredAdapter(MainActivity.this, R.id.imageView1, uri);
              gridView.setAdapter(adapter);
              
              //Intent i = new Intent(this, DisplayImageActivity.class);
              gridView.setOnItemClickListener(new OnItemClickListener() {            	  
				@Override
				public void onItemClick(StaggeredGridView parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
            		  
//            		  Toast.makeText(getApplicationContext(),
//                    	      "Click ListItem Number " + position, Toast.LENGTH_LONG)
//                    	      .show();
            		  
            		  Intent i = new Intent(MainActivity.this, DisplayImageActivity.class);
            		  String filepath = (String) parent.getAdapter().getItem(position);
            	      i.putExtra("filepath", filepath);
            	      startActivity(i);
				}
            	}); 
              
              adapter.notifyDataSetChanged();
              
              
	}
	
	//Randomly Shuffles an array of objects using Fisher Yates
	private void shuffleArray(Object[] array)
	{
	    int index; 
	    Object temp;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
