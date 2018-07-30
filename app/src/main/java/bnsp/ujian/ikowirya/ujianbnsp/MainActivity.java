package bnsp.ujian.ikowirya.ujianbnsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import bnsp.ujian.ikowirya.ujianbnsp.Soal1.Soal1Activity;
import bnsp.ujian.ikowirya.ujianbnsp.Soal2.InputDataSoal2Activity;
import bnsp.ujian.ikowirya.ujianbnsp.Soal2.Soal2Activity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnSoal1)
    LinearLayout btnSoal1;
    @BindView(R.id.btnSoal2)
    LinearLayout btnSoal2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnSoal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Soal1Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        btnSoal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Soal2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
