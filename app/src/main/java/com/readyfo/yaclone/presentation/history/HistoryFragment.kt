package com.readyfo.yaclone.presentation.history


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.readyfo.yaclone.R
import com.readyfo.yaclone.core.common.BaseFragment
import com.readyfo.yaclone.core.common.BaseViewModel
import kotlinx.android.synthetic.main.fragment_history.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HistoryFragment : BaseFragment(), HistoryAdapter.OnClickFavorites {

    private val viewModel by sharedViewModel<HistoryViewModel>()
    private val mHistoryAdapter by lazy {
        HistoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        viewModel.fetchHistory()
    }

    override fun onClickFavorites(isFavorites: Boolean) {
        // TODO make clickFavorite
    }

    // View implementation
//    override fun presentHistory(historyData: MutableList<HistoryModel>) {
//        mHistoryAdapter.setData(historyData)
//    }
//
//    override fun presentHistoryEmpty(isEmpty: Boolean) {
//        setVisibility(isEmptyHistory, isEmpty)
//    }

    private fun setVisibility(view: View, visibility: Boolean) {
        view.visibility =
            if (visibility)
                View.VISIBLE
            else
                View.INVISIBLE
    }

    private fun setupAdapter() {
        recyclerViewHistory.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        recyclerViewHistory.adapter = mHistoryAdapter
        mHistoryAdapter.registerCallBack(this)
    }
}
