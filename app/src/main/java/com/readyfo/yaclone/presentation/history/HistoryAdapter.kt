package com.readyfo.yaclone.presentation.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.readyfo.yaclone.R
import com.readyfo.yaclone.domain.models.HistoryModel
import kotlinx.android.synthetic.main.item_history.view.*
import java.util.*

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val mHistoryList: MutableList<HistoryModel> = LinkedList()
    private var callBackFavorites: OnClickFavorites? = null

    interface OnClickFavorites {
        fun onClickFavorites(isFavorites: Boolean)
    }

    fun setData(newHistory: List<HistoryModel>) {
        mHistoryList.clear()
        mHistoryList.addAll(newHistory)

        notifyDataSetChanged()
    }

    fun registerCallBack(callBack: OnClickFavorites) {
        callBackFavorites = callBack
    }

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textFrom: TextView = itemView.textFromHistory
        private val textTo: TextView = itemView.textToHistory
        private val btnFavorites: ImageButton = itemView.btnFavorites
        private val languages: TextView = itemView.languagesHistory

        fun bindTo(model: HistoryModel) {
            textFrom.text = model.textFrom
            textTo.text = model.textTo
            btnFavorites.setImageResource(
                if (!model.favorite)
                    R.drawable.ic_favorite_border_black_24dp
                else
                    R.drawable.ic_favorite_red_24dp
            )
            btnFavorites.setOnClickListener {
                callBackFavorites?.onClickFavorites(!model.favorite)
            }
            languages.text = "${model.languageFrom}-${model.languageTo}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mHistoryList.count()
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bindTo(mHistoryList[position])
    }
}