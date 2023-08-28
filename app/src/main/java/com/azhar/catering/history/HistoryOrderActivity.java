package com.azhar.catering.history;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.azhar.catering.R;
import com.azhar.catering.database.DatabaseModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryOrderActivity extends AppCompatActivity {

    List<DatabaseModel> modelDatabaseList = new ArrayList<>();
    HistoryAdapter historyAdapter;
    HistoryViewModel historyViewModel;
    Toolbar toolbar;
    RecyclerView rvHistory;
    TextView tvNotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_order);

        setToolbar();
        setInitLayout();
        setViewModel();
        setSwipeToDelete();
    }

    //untuk toolbar
    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    //untuk inisialisasi Id dan menampilkan data list
    private void setInitLayout() {
        rvHistory = findViewById(R.id.rvHistory);
        tvNotFound = findViewById(R.id.tvNotFound);

        tvNotFound.setVisibility(View.GONE);

        historyAdapter = new HistoryAdapter(this, modelDatabaseList);
        rvHistory.setHasFixedSize(true);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        rvHistory.setAdapter(historyAdapter);
    }

    //untuk get data dari class viewmodel
    private void setViewModel() {
        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        historyViewModel.getDataList().observe(this, modelDatabases -> {
            if (modelDatabases.size() != 0) {
                historyAdapter.setDataAdapter(modelDatabases);
            } else {
                tvNotFound.setVisibility(View.VISIBLE);
                rvHistory.setVisibility(View.GONE);
            }
        });
    }

    private void setSwipeToDelete() {
        ItemTouchHelper.SimpleCallback simpleCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START
                        | ItemTouchHelper.END) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                final DatabaseModel databaseModel = historyAdapter.getData().get(position);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        HistoryOrderActivity.this);
                alertDialogBuilder.setMessage("Hapus riwayat ini?");
                alertDialogBuilder.setPositiveButton("Ya, Hapus", (dialogInterface, i) -> {
                    int uid = databaseModel.uid;
                    historyViewModel.deleteDataById(uid);
                    historyAdapter.setSwipeRemove(viewHolder.getAdapterPosition());
                    Toast.makeText(HistoryOrderActivity.this, "Data yang dipilih sudah dihapus",
                            Toast.LENGTH_SHORT).show();
                });

                alertDialogBuilder.setNegativeButton("Batal", (dialogInterface, i) -> {
                    historyAdapter.restoreItem(databaseModel, position);
                    rvHistory.scrollToPosition(position);
                    setViewModel();
                    dialogInterface.cancel();
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();}
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvHistory);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}