package com.example.mlrit.imagecapture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView v;
    Button b;
    static final int REQUEST_IMAGE_CAPTURE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v=(ImageView)findViewById(R.id.imageView);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();

            }
        });


    }
    public void dispatchTakePictureIntent(){
        Intent tPI=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(tPI.resolveActivity(getPackageManager())!= null){

            startActivityForResult(tPI,REQUEST_IMAGE_CAPTURE);
    }
}

@Override

 protected void onActivityResult(int rc,int resc,Intent data){
if (rc==REQUEST_IMAGE_CAPTURE && resc==RESULT_OK)
{
    Bundle bundle=data.getExtras();
    Bitmap imageBitmap = (Bitmap) bundle.get("data");
    v.setImageBitmap(imageBitmap);
}
}
}