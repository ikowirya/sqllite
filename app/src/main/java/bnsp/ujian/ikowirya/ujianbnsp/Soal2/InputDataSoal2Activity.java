package bnsp.ujian.ikowirya.ujianbnsp.Soal2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bnsp.ujian.ikowirya.ujianbnsp.Database.DataHelper;
import bnsp.ujian.ikowirya.ujianbnsp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InputDataSoal2Activity extends AppCompatActivity {
    @BindView(R.id.txtNama)
    TextView txtNama;
    @BindView(R.id.txtAlamat)
    TextView txtAlamat;
    @BindView(R.id.txtNomor)
    TextView txtNomor;
    @BindView(R.id.txtJenisKelamin)
    TextView txtJenisKelamin;
    @BindView(R.id.txtTanggalLahir)
    TextView txtTanggalLahir;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;
    @BindView(R.id.btnKembali)
    Button btnKembali;
    DataHelper dbHelper;
    String nama,nomor,jenis_kelamin,tanggal_lahir,alamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_soal2);
        ButterKnife.bind(this);
        dbHelper = new DataHelper(this);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = txtNama.getText().toString();
                nomor = txtNomor.getText().toString();
                alamat = txtAlamat.getText().toString();
                tanggal_lahir = txtTanggalLahir.getText().toString();
                jenis_kelamin = txtJenisKelamin.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO BIODATA(nama, nomor,tanggal_lahir, alamat, jenis_kelamin) values('" +
                        nama + "','" +
                        nomor + "','" +
                        tanggal_lahir + "','" +
                        alamat + "','" +
                        jenis_kelamin + "')");
                Toast.makeText(getApplicationContext(), "Tambah Berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InputDataSoal2Activity.this, Soal2Activity.class);
                InputDataSoal2Activity.this.startActivity(intent);
                finish();
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputDataSoal2Activity.this, Soal2Activity.class);
                InputDataSoal2Activity.this.startActivity(intent);
                finish();
            }
        });
    }
}
