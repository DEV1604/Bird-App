package com.example.this_pc.flyhigh.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.fragments.ModalBottomSheet;
import com.example.this_pc.flyhigh.utils.C;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*List<Uri> mSelected;*/
    RelativeLayout get_img_gallery_btn, open_camera_btn;
    FloatingActionButton fab_options;
    /*Bitmap bitmap;
    Intent intent;
*/
    ModalBottomSheet modalBottomSheet ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modalBottomSheet = new ModalBottomSheet();

        fab_options = findViewById(R.id.fab_options);
  /*      open_camera_btn = findViewById(R.id.open_camera_btn);
        get_img_gallery_btn = findViewById(R.id.get_img_gallery_btn);
        open_camera_btn.setOnClickListener(this);
        get_img_gallery_btn.setOnClickListener(this);

*/
        fab_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modalBottomSheet.show(getSupportFragmentManager(), "bottom sheet");
            }
        });
    }

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
*/
  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && requestCode == RESULT_OK) {
            String path = "sdcard/bird_app/cam_image.jpg";
            Drawable d = Drawable.createFromPath(path);
            bitmap = ((BitmapDrawable) d).getBitmap();
            intent = new Intent(MainActivity.this, FiltercolorActivity.class);
            C.cameraBitmap = bitmap;
            startActivity(intent);
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
*/
   /* private File getFile() {
        File folder = new File("sdcard/bird_app");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");
        return image_file;
    }*/
}