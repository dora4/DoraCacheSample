package com.example.doracachesample.biz.orm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doracachesample.R
import com.example.doracachesample.biz.orm.AccountAdapter.AccountViewHolder
import java.util.*

class AccountAdapter : RecyclerView.Adapter<AccountViewHolder>() {
    private var accounts: List<Account> =
        ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        return AccountViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_account, null)
        )
    }

    fun setAccounts(accounts: List<Account>) {
        this.accounts = accounts
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val account = accounts[position]
        val tvAccKey = holder.itemView.findViewById<TextView>(R.id.tvAccKey)
        val tvAccDesc = holder.itemView.findViewById<TextView>(R.id.tvAccDesc)
        val tvAccValue = holder.itemView.findViewById<TextView>(R.id.tvAccValue)
        tvAccKey.text = account.accKey
        tvAccDesc.text = account.accDesc
        tvAccValue.text = account.accValue
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    class AccountViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)
}