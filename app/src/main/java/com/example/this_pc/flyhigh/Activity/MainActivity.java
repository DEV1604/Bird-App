package com.example.this_pc.flyhigh.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.this_pc.flyhigh.R;
import com.example.this_pc.flyhigh.utils.C;
import com.wonderkiln.camerakit.CameraKitEventCallback;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.engine.impl.PicassoEngine;
import com.zhihu.matisse.filter.Filter;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int REQUEST_CODE_CHOOSE=1;
    List<Uri> mSelected;
    ImageView get_img_gallery_btn;
    FloatingActionButton get_img_camera_btn;
    CameraView cameraView;
    Bitmap bitmap;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraView=(CameraView)findViewById(R.id.camera_view);
        get_img_camera_btn=(FloatingActionButton)findViewById(R.id.get_img_camera_btn);
        get_img_camera_btn.setOnClickListener(this);
        get_img_gallery_btn=(ImageView)findViewById(R.id.get_img_gallery_btn);
        get_img_gallery_btn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        cameraView.stop();
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.get_img_camera_btn:
                cameraView.captureImage(new CameraKitEventCallback<CameraKitImage>() {
                    @Override
                    public void callback(CameraKitImage cameraKitImage) {
                        bitmap = cameraKitImage.getBitmap();
                         intent = new Intent(MainActivity.this,FiltercolorActivity.class);
                        C.cameraBitmap = bitmap;
                        startActivity(intent);
                    }

                });
                break;
            case R.id.get_img_gallery_btn:
                Matisse.from(MainActivity.this)
                        .choose(MimeType.allOf())
                        .countable(true)
                        .maxSelectable(1)
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_CHOOSE);
                break;

            default:break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mSelected);
            try {
                bitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(),Uri.parse(mSelected.get(0).toString()));
                C.cameraBitmap=bitmap;
                intent = new Intent(MainActivity.this,FiltercolorActivity.class);
                startActivity(intent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}