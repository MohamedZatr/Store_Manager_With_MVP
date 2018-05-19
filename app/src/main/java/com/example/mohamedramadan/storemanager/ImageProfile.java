package com.example.mohamedramadan.storemanager;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Mohamed Ramadan on 19-May-18.
 */

public class ImageProfile {

   private Activity  m_activity;
   public static  final int  DEFULT_VALUE_SELECT = 1;
    public static  final int  DEFULT_VALUE_TAKE = 2;
    public static  final int  DEFULT_VALUE_PERMISSION = 3;

    public ImageProfile(Activity activity)
    {
        m_activity = activity;
    }


    private void selectimage()
    {
        Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        m_activity.startActivityForResult(Intent.createChooser(intent,"Image Profile"),DEFULT_VALUE_SELECT);
    }

    public void imageProfieMode()
    {

        new AlertDialog.Builder(m_activity)
                .setTitle(m_activity.getResources().getString(R.string.image_profile))
                .setMessage(m_activity.getResources().getString(R.string.message_of_image))
                .setPositiveButton(m_activity.getResources().getString(R.string.select_image), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectimage();
                    }
                })
                .setNegativeButton(m_activity.getResources().getString(R.string.take_image), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tackImage();
                    }
                }).show();
    }

    private void tackImage()
    {
        Toast.makeText(m_activity,"inmethod",Toast.LENGTH_LONG).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if(m_activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    m_activity.requestPermissions(new String[]{Manifest.permission.CAMERA},DEFULT_VALUE_PERMISSION);

                }
            }
            else{
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            m_activity.startActivityForResult(cameraIntent, DEFULT_VALUE_TAKE);
        }
        }

    }
}
