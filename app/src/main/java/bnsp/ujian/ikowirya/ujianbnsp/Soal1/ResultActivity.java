package bnsp.ujian.ikowirya.ujianbnsp.Soal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import bnsp.ujian.ikowirya.ujianbnsp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {
    @BindView(R.id.txtNama)
    TextView txtNama;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtNomor)
    TextView txtNomor;
    String nama,email,nomor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        email = intent.getStringExtra("email");
        nomor = intent.getStringExtra("nomor");
        txtNama.setText("Nama: "+ nama);
        txtEmail.setText("Email: "+email);
        txtNomor.setText("Nomor: "+nomor);
    }
}
