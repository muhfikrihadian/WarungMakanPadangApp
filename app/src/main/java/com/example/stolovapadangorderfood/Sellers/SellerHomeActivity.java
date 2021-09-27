package com.example.stolovapadangorderfood.Sellers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.stolovapadangorderfood.MainActivity;
import com.example.stolovapadangorderfood.R;

import androidx.appcompat.app.AppCompatActivity;

public class SellerHomeActivity extends AppCompatActivity {

    private Button daftarMenu,tambahMenu,updateMenu,cekOrder,logoutBtn,infoBtn,historiBtn;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);

        daftarMenu = (Button) findViewById(R.id.daftar_menu_seller_btn);
        tambahMenu = (Button) findViewById(R.id.tambah_btn);
        updateMenu = (Button) findViewById(R.id.maintain_btn);
        cekOrder = (Button) findViewById(R.id.check_orders_btn);
        logoutBtn = (Button) findViewById(R.id.seller_logout_btn);
        infoBtn = (Button) findViewById(R.id.info_btn);
        historiBtn = (Button) findViewById(R.id.histori_btn);

        daftarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerDaftarMenuActivity.class);
                startActivity(intent);
            }
        });
        tambahMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerAddNewProductActivity.class);
                startActivity(intent);
            }
        });
        updateMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerUpdateMenuActivity.class);
                startActivity(intent);
            }
        });
        cekOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerNewOrderActivity.class);
                startActivity(intent);
            }
        });
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerMoreActivity.class);
                startActivity(intent);
            }
        });
        historiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerHomeActivity.this, SellerHistoriOrderActivity.class);
                startActivity(intent);
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerHomeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
