package com.example.stolovapadangorderfood.Sellers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.stolovapadangorderfood.MainActivity;
import com.example.stolovapadangorderfood.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class SellerMoreActivity extends AppCompatActivity {

    private Button Logout, Ubah;
    private TextView namaSeller, emailSeller, noHpSeller, alamatSeller;
    private CircleImageView profileImageView;
    private Uri imageUri;

    DatabaseReference ref,Photoref;
    FirebaseDatabase mDatabase,mDatabasePhoto;
    private String userPhone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_more);

        namaSeller = (TextView) findViewById(R.id.seller_profil_name);
        emailSeller = (TextView) findViewById(R.id.seller_profil_email);
        noHpSeller = (TextView) findViewById(R.id.seller_profil_nomorhp);
        alamatSeller = (TextView) findViewById(R.id.seller_profil_alamat);

        Logout = (Button) findViewById(R.id.logout);
        Ubah = (Button) findViewById(R.id.ubah_btn);
        profileImageView = (CircleImageView) findViewById(R.id.seller_profil_image);

        userInfoDisplay(profileImageView);

        Ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerMoreActivity.this, SellerUpdateInfoResto.class);
                startActivity(intent);
            }
        });

        mDatabase = FirebaseDatabase.getInstance();
        ref=mDatabase.getReference().child("Sellers").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        ref.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                //successfully

                String namaseller = dataSnapshot.child("name").getValue(String.class);
                String emailseller = dataSnapshot.child("email").getValue(String.class);
                String nohpseller = dataSnapshot.child("phone").getValue(String.class);
                String alamatseller = dataSnapshot.child("address").getValue(String.class);

                //sit in textView

                namaSeller.setText(namaseller);
                emailSeller.setText(emailseller);
                noHpSeller.setText(nohpseller);
                alamatSeller.setText(alamatseller);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SellerMoreActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });
    }

    private void userInfoDisplay(final CircleImageView profileImageView)
    {
        DatabaseReference SellersRef = FirebaseDatabase.getInstance().getReference().child("Sellers").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        SellersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.exists())
                {
                    if (dataSnapshot.child("logo").exists())
                    {
                        String image = dataSnapshot.child("logo").getValue().toString();

                        Picasso.get().load(image).into(profileImageView);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }
}
