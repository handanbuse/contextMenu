package com.example.contextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edit1,edit2;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v.getId() == R.id.main_activity_edit1){
            this.getMenuInflater().inflate(R.menu.color_menu,menu);
        }
        else if (v.getId() == R.id.main_activity_edit2) {
            getMenuInflater().inflate(R.menu.font_menu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    //seçimini yapmak için

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.color_menu_blue){
            // color menüsü için
            edit1.setTextColor(Color.BLUE);
        }
        else if (item.getItemId()==R.id.color_menu_green){
            edit1.setTextColor(Color.GREEN);
        }
        else if (item.getItemId()==R.id.color_menu_red){
            edit1.setTextColor(Color.RED);
        }

        //FONT MENÜSÜ
        else if(item.getItemId()==R.id.font_color_c1){
            edit2.setTextSize(13);
        }
        else if(item.getItemId()==R.id.font_color_c2){
            edit2.setTextSize(17);
        }
        else if(item.getItemId()==R.id.font_color_c3){
            edit2.setTextSize(25);
        }



        return super.onContextItemSelected(item);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1=findViewById(R.id.main_activity_edit1);
        edit2=findViewById(R.id.main_activity_edit2);

        this.registerForContextMenu(edit1);
        this.registerForContextMenu(edit2);

    }
}