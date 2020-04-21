package com.readyfo.yaclone.presentation.choselang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.readyfo.yaclone.R
import com.readyfo.yaclone.domain.models.LanguageModel
import kotlinx.android.synthetic.main.item_chose_language.view.*
import java.util.*

class ChoseLangAdapter(private val selectedLanguage: String) :
    RecyclerView.Adapter<ChoseLangAdapter.ChoseLangViewHolder>() {
    private val mLanguageList: MutableList<LanguageModel> = LinkedList()
    private var callBackSelectedLang: OnSelectedLang? = null

    interface OnSelectedLang {
        fun onSelectedLang(language: String)
    }

    fun setData(languages: List<LanguageModel>) {
        mLanguageList.clear()
        mLanguageList.addAll(languages)

        notifyDataSetChanged()
    }

    fun registerCallBack(callBack: OnSelectedLang) {
        callBackSelectedLang = callBack
    }

    inner class ChoseLangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val parentLayout = itemView.parentLayout
        private val tvLanguage = itemView.tvLanguage
        private val icSelectedLanguage = itemView.icSelectedLanguage

        fun bindTo(model: LanguageModel) {
            tvLanguage.text = model.language

            when(selectedLanguage){
                model.language -> {
                    icSelectedLanguage.visibility = View.VISIBLE
//                    parentLayout.setBackgroundColor(R.color.grey)
                }
                else -> {
                    icSelectedLanguage.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChoseLangViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_chose_language, parent, false)
    )

    override fun getItemCount() = mLanguageList.count()

    override fun onBindViewHolder(holder: ChoseLangAdapter.ChoseLangViewHolder, position: Int) {
        holder.bindTo(mLanguageList[position])
    }
}