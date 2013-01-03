package studio.coldstream.farmanimalsounds;


import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {  	
	
	List<ImageView> iv;
	
	List<MediaPlayer> mp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mp = new LinkedList<MediaPlayer>();
              
        for(int i = 0; i < 7; i++){
        	mp.add(new MediaPlayer());
        }        
        
        mp.set(1, MediaPlayer.create(MainActivity.this, R.raw.cow));
        mp.set(2, MediaPlayer.create(MainActivity.this, R.raw.pig));
        mp.set(3, MediaPlayer.create(MainActivity.this, R.raw.sheep));
        mp.set(4, MediaPlayer.create(MainActivity.this, R.raw.horse));
        mp.set(5, MediaPlayer.create(MainActivity.this, R.raw.chicken));
        mp.set(6, MediaPlayer.create(MainActivity.this, R.raw.duck));
        
        iv = new LinkedList<ImageView>();
        
        for(int i = 0; i < 7; i++){
        	iv.add(new ImageView(this));
        }    
        
        iv.set(1, (ImageView) findViewById(R.id.imageView1));
        iv.set(2, (ImageView) findViewById(R.id.imageView2));
        iv.set(3, (ImageView) findViewById(R.id.imageView3));
        iv.set(4, (ImageView) findViewById(R.id.imageView4));
        iv.set(5, (ImageView) findViewById(R.id.imageView5));
        iv.set(6, (ImageView) findViewById(R.id.imageView6));      
        
        iv.get(1).setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {  // onClick Method
				Log.d("", "1");
				processClick(v, 1);
			}
		});
        
        iv.get(2).setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {  // onClick Method
				Log.d("", "2");
				processClick(v, 2);
			}
		});        
        
        iv.get(3).setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {  // onClick Method
				Log.d("", "3");
				processClick(v, 3);
			}
		});
        
        iv.get(4).setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {  // onClick Method
				Log.d("", "4");
				processClick(v, 4);
			}
		});       
        
        iv.get(5).setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {  // onClick Method
				Log.d("", "5");
				processClick(v, 5);
			}
		});
        
        iv.get(6).setOnClickListener(new OnClickListener() {
			//@Override
			public void onClick(View v) {  // onClick Method
				Log.d("", "6");
				processClick(v, 6);
			}
		});       
        
    }
    
    void processClick(View v, int i){
    	try{
	    	for(int j = 1; j < 7; j++){        	
	        	iv.get(j).setPadding(0, 0, 0, 0);
	        	iv.get(j).invalidate();
	        }      	
			    	
	    	v.setBackgroundColor(Color.WHITE);
			v.setPadding(12, 12, 12, 12);
			v.invalidate();
			
			//Make the sound!		
			mp.get(i).start();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }    
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.options_menu, menu);
	    return true;
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {	      
		    case R.id.about:
		        showAbout();
		        return true;
		    default:
		        return super.onOptionsItemSelected(item);
	    }
	}
   
   public void showAbout(){
       Intent mainIntent = new Intent(MainActivity.this, AboutActivity.class);
       MainActivity.this.startActivityForResult(mainIntent, -1);
       return;
	}
    
}