package com.example.doracachesample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountViewHolder> {

    private List<Account> accounts = new ArrayList<>();

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AccountViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account, null));
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        Account account = accounts.get(position);
        TextView tvAccKey = holder.itemView.findViewById(R.id.tvAccKey);
        TextView tvAccDesc = holder.itemView.findViewById(R.id.tvAccDesc);
        TextView tvAccValue = holder.itemView.findViewById(R.id.tvAccValue);
        tvAccKey.setText(account.getAccKey());
        tvAccDesc.setText(account.getAccDesc());
        tvAccValue.setText(account.getAccValue());
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public static class AccountViewHolder extends RecyclerView.ViewHolder {

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
