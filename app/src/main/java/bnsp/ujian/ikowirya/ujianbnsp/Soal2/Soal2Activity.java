package bnsp.ujian.ikowirya.ujianbnsp.Soal2;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import bnsp.ujian.ikowirya.ujianbnsp.Database.DataHelper;
import bnsp.ujian.ikowirya.ujianbnsp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Soal2Activity extends AppCompatActivity {
    String[] daftar;
    Cursor cursor;
    DataHelper dbcenter;
    @BindView(R.id.btnAddNew)
    Button btnAddNew;
    @BindView(R.id.list_item)
    ListView list_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal2);
        ButterKnife.bind(this);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soal2Activity.this, InputDataSoal2Activity.class);
                Soal2Activity.this.startActivity(intent);
                finish();
            }
        });
        dbcenter = new DataHelper(this);
        refresh();


    }

    public void refresh() {

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM BIODATA", null);
            daftar = new String[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                daftar[i] = cursor.getString(1).toString();
            }

        list_item.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        list_item.setSelected(true);
        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String selection = daftar[position];
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Soal2Activity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0:
                                Intent intent2 = new Intent(getApplicationContext(), LihatDataSoal2Activity.class);
                                intent2.putExtra("nama", selection);
                                startActivity(intent2);
                                break;
                            case 1:
                                Intent intent3 = new Intent(getApplicationContext(), UpdateDataSoal2Activity.class);
                                intent3.putExtra("nama", selection);
                                startActivity(intent3);
                                finish();
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("DELETE FROM BIODATA WHERE nama = '" + selection + "'");
                                Toast.makeText(Soal2Activity.this, "Hapus Berhasil", Toast.LENGTH_SHORT).show();
                                onResume();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)list_item.getAdapter()).notifyDataSetInvalidated();
    }

    @Override
    protected void onResume() {
        refresh();
        super.onResume();
    }
}