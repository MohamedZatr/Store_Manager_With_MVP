package com.example.mohamedramadan.storemanager;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    CircleImageView imageProfile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
      imageProfile = findViewById(R.id.image);
      imageProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           ImageProfile imageProfile = new ImageProfile(this);
           imageProfile.imageProfieMode();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ImageProfile.DEFULT_VALUE_SELECT && data != null)
        {
            Uri uri = data.getData();
            imageProfile.setImageURI(uri);
        }
        if(requestCode == ImageProfile.DEFULT_VALUE_TAKE && data != null && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageProfile.setImageBitmap(photo);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == ImageProfile.DEFULT_VALUE_PERMISSION)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,ImageProfile.DEFULT_VALUE_TAKE);
            }
        }

    }
}
