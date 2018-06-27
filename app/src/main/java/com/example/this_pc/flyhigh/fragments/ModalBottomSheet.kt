package com.example.this_pc.flyhigh.fragments

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.BottomSheetDialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.dawnimpulse.permissions.android.Permissions
import com.example.this_pc.flyhigh.R
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import java.io.File

/**
 * Created by Saksham on 2018 06 25
 * Last Branch Update - v
 * Updates :
 * Saksham - 2018 06 25 - v - Initial
 */
class ModalBottomSheet: BottomSheetDialogFragment() , View.OnClickListener{
    lateinit var get_img_gallery_btn: RelativeLayout
    lateinit var open_camera_btn:RelativeLayout
    internal var bitmap: Bitmap? = null
    internal var intent: Intent? = null
    internal var mSelected: List<Uri>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet_modal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        open_camera_btn = view.findViewById(R.id.open_camera_btn)
        get_img_gallery_btn = view.findViewById(R.id.get_img_gallery_btn)
        open_camera_btn.setOnClickListener(this)
        get_img_gallery_btn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.getId()) {
            R.id.open_camera_btn -> {
                Permissions.askCameraPermission(activity!!,{no,yes ->
                    if (yes!=null){
                        Permissions.askReadExternalStoragePermission(activity!!,{no,yes->
                            if (yes!=null){
                                Permissions.askWriteExternalStoragePermission(activity!!,{no,yes->
                                    if (yes!=null){
                                        val cam_Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                                        val file = getFile()
                                        cam_Intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file))
                                        activity!!.startActivityForResult(cam_Intent, 1)
                                        Log.d("hello", "hello")
                                    }
                                })
                            }
                        })
                    }
                })
            }
            R.id.get_img_gallery_btn -> {
                Permissions.askReadExternalStoragePermission(activity!!,{no,yes->
                    if (yes!=null){
                        Permissions.askWriteExternalStoragePermission(activity!!,{no,yes->
                            if (yes!=null){
                                Matisse.from(activity)
                                        .choose(MimeType.allOf())
                                        .countable(true)
                                        .maxSelectable(1)
                                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                                        .thumbnailScale(0.85f)
                                        .imageEngine(GlideEngine())
                                        .forResult(2)
                            }
                        })
                    }
                })
            }
            else -> {}
        }
    }

  /*  override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("hello","hello")

        if (requestCode == 1 && requestCode == RESULT_OK)
        {
            val path = "/bird_app/cam_image.jpg"
            val d = Drawable.createFromPath(path)
            bitmap = (d as BitmapDrawable).bitmap
            intent = Intent(context, FiltercolorActivity::class.java)
            C.cameraBitmap = bitmap!!
            startActivity(intent)
        }
        else if (requestCode == 2 && resultCode == RESULT_OK)
        {
            mSelected = Matisse.obtainResult(data)
            Log.d("Matisse", "mSelected: " + mSelected)
            try
            {
                bitmap = MediaStore.Images.Media.getBitmap(context!!.contentResolver, Uri.parse((mSelected as MutableList<Uri>?)!![0].toString()))
                C.cameraBitmap = bitmap!!
                intent = Intent(context, FiltercolorActivity::class.java)
                startActivity(intent)
            }
            catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
*/
    private fun getFile(): File {
        val folder = File("storage/emulated/0/bird_app")
        if (!folder.exists())
        {
            folder.mkdir()
        }
        val image_file = File(folder, "cam_image.jpg")
        return image_file
    }
}