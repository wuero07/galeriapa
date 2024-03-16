package com.example.galeriapa;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private final int[] imageResources = new int[]{
            R.drawable.imagen1,
            R.drawable.imagen2,
            R.drawable.imagen3,
            R.drawable.imagen4,
            R.drawable.imagen5,
            R.drawable.imagen6,
            R.drawable.imagen7
    };
    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        updateImage();

        findViewById(R.id.btnSiguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = (currentPosition + 1) % imageResources.length;
                updateImage();
            }
        });

        findViewById(R.id.btnAtras).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = (currentPosition - 1 + imageResources.length) % imageResources.length;
                updateImage();
            }
        });

        findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateImage() {
        imageView.setImageResource(imageResources[currentPosition]);
    }
}
