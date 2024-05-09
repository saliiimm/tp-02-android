package com.example.tp02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.resultatc);
        registerForContextMenu(textView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        menu.setHeaderTitle("Select a style");

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() ==R.id.btns1){
            textView.setTextAppearance(R.style.Style1);
        }
        if(item.getItemId() ==R.id.btns2){
            textView.setTextAppearance(R.style.Style2);
        }
        if(item.getItemId() ==R.id.btns3){
            textView.setTextAppearance(R.style.Style3);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView messageView;
        Context context;
        Resources resources;

        // referencing the text and button views
        messageView = (TextView) findViewById(R.id.resultatc);

        if(item.getItemId() ==R.id.btnArabic){

                    context = LocaleHelper.setLocale(MainActivity.this, "ar");
                    resources = context.getResources();
                    messageView.setText(resources.getString(R.string.larbi_text));

        }
        if(item.getItemId() ==R.id.btnEnglish){

            context = LocaleHelper.setLocale(MainActivity.this, "eng");
            resources = context.getResources();
            messageView.setText(resources.getString(R.string.larbi_text));

        }
        if(item.getItemId() ==R.id.btnFrench){

            context = LocaleHelper.setLocale(MainActivity.this, "fr");
            resources = context.getResources();
            messageView.setText(resources.getString(R.string.larbi_text));

        }
        return super.onOptionsItemSelected(item);
    }
}