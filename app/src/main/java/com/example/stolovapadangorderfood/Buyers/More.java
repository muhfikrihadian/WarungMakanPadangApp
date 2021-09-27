package com.example.stolovapadangorderfood.Buyers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stolovapadangorderfood.Helpers.DataHelper;
import com.example.stolovapadangorderfood.MainActivity;
import com.example.stolovapadangorderfood.Prevalent.Prevalent;
import com.example.stolovapadangorderfood.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;

public class More extends AppCompatActivity {

    private Button Logout, Update;
    private TextView namaUser, emailUser, noHpUser, alamatUser, kotaUser;
    private CircleImageView profileImageView;
    private Uri imageUri;

    DatabaseReference ref, Photoref;
    FirebaseDatabase mDatabase, mDatabasePhoto;
    private String userPhone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        Paper.init(this);
        namaUser = (TextView) findViewById(R.id.profil_name);
        emailUser = (TextView) findViewById(R.id.profil_email);
        noHpUser = (TextView) findViewById(R.id.profil_nomorhp);
        alamatUser = (TextView) findViewById(R.id.profil_alamat);
        kotaUser = (TextView) findViewById(R.id.profil_kota);
        Logout = (Button) findViewById(R.id.logout);
        Update = (Button) findViewById(R.id.update_btn);
        profileImageView = (CircleImageView) findViewById(R.id.profil_image);
        userInfoDisplay(profileImageView);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(More.this, UpdateInfoProfileActivity.class);
                startActivity(intent);
            }
        });

        mDatabase = FirebaseDatabase.getInstance();
        ref = mDatabase.getReference().child("Users").child(Prevalent.currentOnlineUser.getPhone());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String namauser = dataSnapshot.child("name").getValue(String.class);
                String emailuser = dataSnapshot.child("email").getValue(String.class);
                String nohpuser = dataSnapshot.child("phone").getValue(String.class);
                String alamatuser = dataSnapshot.child("address").getValue(String.class);
                String kotauser = dataSnapshot.child("city").getValue(String.class);
                namaUser.setText(namauser);
                emailUser.setText(emailuser);
                noHpUser.setText(nohpuser);
                alamatUser.setText(alamatuser);
                kotaUser.setText(kotauser);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().destroy();
                DataHelper dataHelper = new DataHelper(More.this);
                dataHelper.deletePref();
                Intent intent = new Intent(More.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.more);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext(), CartActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        Intent intent = new Intent(More.this, HomeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), HistoryOrderActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void userInfoDisplay(final CircleImageView profileImageView) {
        DatabaseReference UsersRef = FirebaseDatabase.getInstance().getReference().child("Users").child(Prevalent.currentOnlineUser.getPhone());
        UsersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    if (dataSnapshot.child("image").exists()) {
                        String image = dataSnapshot.child("image").getValue().toString();
                        Picasso.get().load(image).into(profileImageView);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
