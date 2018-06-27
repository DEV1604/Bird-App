package com.example.this_pc.flyhigh.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.fragments.ModalBottomSheet;
import com.example.this_pc.flyhigh.utils.C;
import com.zhihu.matisse.Matisse;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Toolbar my_toolbar;

    List<Uri> mSelected;
    RelativeLayout get_img_gallery_btn, open_camera_btn;
    FloatingActionButton fab_options;
    Bitmap bitmap;
    Intent intent;
    ModalBottomSheet modalBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        modalBottomSheet = new ModalBottomSheet();

        fab_options = findViewById(R.id.fab_options);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        fab_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modalBottomSheet.show(getSupportFragmentManager(), "bottom sheet");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("hello", "");
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Log.d("hello", "");
            String path = "storage/emulated/0/bird_app/cam_image.jpg";
            Log.d("hello", "");
            Drawable d = Drawable.createFromPath(path);
            Log.d("hello", "");
            bitmap = ((BitmapDrawable) d).getBitmap();
            Log.d("hello", "");
            intent = new Intent(MainActivity.this, FiltercolorActivity.class);
            Log.d("hello", "");
            C.cameraBitmap = bitmap;
            Log.d("hello", "");
            startActivity(intent);
            Log.d("hello", "");

        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mSelected);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(mSelected.get(0).toString()));
                C.cameraBitmap = bitmap;
                intent = new Intent(MainActivity.this, FiltercolorActivity.class);
                startActivity(intent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.opt1 :
                Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt2 :
                Toast.makeText(MainActivity.this,"Action_clicked",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

}   /* private File getFile() {
        File folder = new File("sdcard/bird_app");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");
        return image_file;
    }*/
   /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_camera_btn:
                Intent cam_Intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                cam_Intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(cam_Intent, 1);
                break;

            case R.id.get_img_gallery_btn:
                Matisse.from(MainActivity.this)
                        .choose(MimeType.allOf())
                        .countable(true)
                        .maxSelectable(1)
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(2);
                break;

            default:
                break;
        }
    }
}
   */