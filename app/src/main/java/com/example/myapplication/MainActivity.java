//package com.example.myapplication;
//import androidx.appcompat.app.AppCompatActivity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private Button button1;
//    private TextView text1;
//    private List<String> selectedItems;
//    private String[] s1 = { "美味蟹堡", "義式香腸堡", "蔬菜水果堡", "香蕉潛艇堡", "香烤雞肉堡" };
//    private boolean[] check = { false, false, false, false, false };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        button1 = findViewById(R.id.button1);
//        text1 = findViewById(R.id.text1);
//        selectedItems = new ArrayList<>();
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle(R.string.str2)
//                        .setMultiChoiceItems(
//                                s1,
//                                check,
//                                new DialogInterface.OnMultiChoiceClickListener() {
//                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                                        if (isChecked) {
//                                            selectedItems.add(s1[which]);
//                                        } else {
//                                            selectedItems.remove(s1[which]);
//                                        }
//                                    }
//                                })
//                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                StringBuilder stringBuilder = new StringBuilder();
//                                for (String item : selectedItems) {
//                                    stringBuilder.append(item).append("\n");
//                                }
//                                text1.setText(getString(R.string.str2) + "\n" + stringBuilder.toString());
//                            }
//                        })
//                        .setNegativeButton("離開", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        })
//                        .show();
//            }
//        });
//    }
//}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button button1;
    private TextView text1;
    private List<String> selectedItems;

    private String[] s1 = { "美味蟹堡", "義式香腸堡", "蔬菜水果堡", "香蕉潛艇堡", "香烤雞肉堡" };
    private boolean[] check = { false, false, false, false, false };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        text1 = findViewById(R.id.text1);
        selectedItems = new ArrayList<>();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.str2)
                        .setMultiChoiceItems(s1, check, new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    selectedItems.add(s1[which]);
                                } else {
                                    selectedItems.remove(s1[which]);
                                }
                            }
                        })
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 0; i < check.length; i++) {
                                    if (check[i]) {
                                        stringBuilder.append(s1[i]).append("\n");
                                    }
                                }
                                text1.setText(getString(R.string.str2) + "\n" + stringBuilder.toString());
                            }
                        })
                        .setNegativeButton("離開", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
}