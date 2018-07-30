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

public class UpdateDataSoal2Activity extends AppCompatActivity {
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
    @BindView(R.id.btnUpdate)
    Button btnUpdate;
    @BindView(R.id.btnKembali)
    Button btnKembali;
    Cursor cursor;
    DataHelper dbHelper;
    String id,nama,nomor,jenis_kelamin,tanggal_lahir,alamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_soal2);

        ButterKnife.bind(this);
        dbHelper = new DataHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            id = (cursor.getString(0).toString());
            txtNama.setText(cursor.getString(1).toString());
            txtNomor.setText(cursor.getString(2).toString());
            txtTanggalLahir.setText(cursor.getString(3).toString());
            txtAlamat.setText(cursor.getString(4).toString());
            txtJenisKelamin.setText(cursor.getString(5).toString());
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = txtNama.getText().toString();
                nomor = txtNomor.getText().toString();
                alamat = txtAlamat.getText().toString();
                tanggal_lahir = txtTanggalLahir.getText().toString();
                jenis_kelamin = txtJenisKelamin.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE BIODATA set nama='"+nama+"', nomor='"+nomor+"', tanggal_lahir='"+
                        tanggal_lahir +"', alamat='" +alamat + "', jenis_kelamin='" +jenis_kelamin + "' " + "WHERE ID='"+id+"'");
                Toast.makeText(getApplicationContext(), "Update Berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDataSoal2Activity.this, Soal2Activity.class);
                UpdateDataSoal2Activity.this.startActivity(intent);
                finish();
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateDataSoal2Activity.this, Soal2Activity.class);
                UpdateDataSoal2Activity.this.startActivity(intent);
                finish();
            }
        });
    }
}
