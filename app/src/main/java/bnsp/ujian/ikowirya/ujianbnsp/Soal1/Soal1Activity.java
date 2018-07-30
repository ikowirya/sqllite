package bnsp.ujian.ikowirya.ujianbnsp.Soal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bnsp.ujian.ikowirya.ujianbnsp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Soal1Activity extends AppCompatActivity {
    @BindView(R.id.txtNama)
    TextView txtNama;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtNomor)
    TextView txtNomor;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;
    @BindView(R.id.btnKembali)
    Button btnKembali;
    String nama,email,nomor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal1);
        ButterKnife.bind(this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama  = txtNama.getText().toString();
                email  = txtEmail.getText().toString();
                nomor  = txtNomor.getText().toString();
                Intent intent = new Intent(Soal1Activity.this, ResultActivity.class);
                intent.putExtra("nama", nama);
                intent.putExtra("email", email);
                intent.putExtra("nomor", nomor);
                Soal1Activity.this.startActivity(intent);
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
