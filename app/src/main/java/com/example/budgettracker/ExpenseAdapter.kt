package com.example.budgettracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(
    private var transactions: List<TransactionItem>,
    private val onItemClick: (TransactionItem) -> Unit
) : RecyclerView.Adapter<ExpenseAdapter.TransactionViewHolder>() {

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val tvCategory: TextView = view.findViewById(R.id.tvCategory)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvAmount: TextView = view.findViewById(R.id.tvAmount)
        val ivPhotoIndicator: ImageView = view.findViewById(R.id.ivPhotoIndicator)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = transactions[position]
        holder.tvDescription.text = item.description
        holder.tvCategory.text = item.category
        holder.tvDate.text = item.date
        
        if (item.isExpense) {
            holder.tvAmount.text = "- R ${String.format("%.2f", item.amount)}"
            holder.tvAmount.setTextColor(Color.RED)
        } else {
            holder.tvAmount.text = "+ R ${String.format("%.2f", item.amount)}"
            holder.tvAmount.setTextColor(Color.parseColor("#2E7D32")) // Dark Green
        }
        
        holder.ivPhotoIndicator.visibility = if (item.hasPhoto) View.VISIBLE else View.GONE
        
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = transactions.size

    fun updateData(newTransactions: List<TransactionItem>) {
        transactions = newTransactions
        notifyDataSetChanged()
    }

    fun getTransactionAt(position: Int): TransactionItem {
        return transactions[position]
    }
}
