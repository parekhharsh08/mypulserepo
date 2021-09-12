package com.example.mypulse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.transform.Result;

import de.hdodenhof.circleimageview.CircleImageView;

public class PrescriptionAdd extends AppCompatActivity {

    private Button prescripionimage;
    private ImageView prescriptionset;
    AppCompatTextView dialogclose;
    AppCompatTextView dailogCamera;
    AppCompatTextView dialogGallery;

    private static final int PICK_PHOTO = 1;
    private static final int CAMERA_REQUEST = 0;

    Bitmap bitmap;
    private Uri filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_add);

        prescriptionset = findViewById(R.id.imagepic);
        prescripionimage = findViewById(R.id.clickphoto);
        prescripionimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendialog();
            }
        });
    }

    public void opendialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.profile_dialogbox, null);

        dialogclose = dialogLayout.findViewById(R.id.dialog_cancle);
        dailogCamera = dialogLayout.findViewById(R.id.dialog_camera);
        dialogGallery = dialogLayout.findViewById(R.id.dialog_gallery);

        builder.setView(dialogLayout);
        final AlertDialog mAlertDialog = builder.show();

        dailogCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
                mAlertDialog.dismiss();
            }
        });
        dialogGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
                mAlertDialog.dismiss();
            }
        });
        dialogclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
            }
        });
        mAlertDialog.show();
    }

    private void openCamera() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
            }
        } else {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    }

    private void openGallery() {
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.putExtra("return-data", true);
                startActivityForResult(intent, PICK_PHOTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openGallery();
        } else if (requestCode == 0 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if (requestCode == PICK_PHOTO && resultCode == RESULT_OK) {
                try {
                    Uri uri = data.getData();
                    try {
                        InputStream image = null;
                        image = getContentResolver().openInputStream(uri);
                        bitmap = BitmapFactory.decodeStream(image);
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 200, out);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 200, out);
                        bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));
                        prescriptionset.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        Toast.makeText(this, "Some error occurred!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    Toast.makeText(this, "Some error occurred!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            } else if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK && null != data) {
                bitmap = (Bitmap) data.getExtras().get("data");
                prescriptionset.setImageBitmap(bitmap);

            }


        } catch (Exception e) {
            Toast.makeText(this, "Some error occurred!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}
