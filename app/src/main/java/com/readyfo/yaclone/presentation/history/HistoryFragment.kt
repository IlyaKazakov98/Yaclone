package com.readyfo.yaclone.presentation.history


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.readyfo.yaclone.App
import com.readyfo.yaclone.R
import com.readyfo.yaclone.domain.models.HistoryModel
import com.readyfo.yaclone.domain.usecases.implementations.FetchHistoryUseCaseImpl
import kotlinx.android.synthetic.main.fragment_history.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class HistoryFragment : MvpAppCompatFragment(),
    HistoryView, HistoryAdapter.OnClickFavorites {
    @Inject
    lateinit var fetchHistoryUseCaseImpl: FetchHistoryUseCaseImpl

    @InjectPresenter lateinit var presenter: HistoryPresenter
    @ProvidePresenter
    fun provideHistoryPresenter(): HistoryPresenter {
        return HistoryPresenter(
            fetchHistoryUseCase = fetchHistoryUseCaseImpl
        )
    }

    private val mHistoryAdapter by lazy {
        HistoryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.injectHistoryFragment(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        presenter.fetchHistory()
    }

    override fun onClickFavorites(isFavorites: Boolean) {

    }

    // View implementation
    override fun presentHistory(historyData: MutableList<HistoryModel>) {
        mHistoryAdapter.setData(historyData)
    }

    override fun presentLoading(isLoading: Boolean) {
        setVisibility(progressBar, isLoading)
    }

    override fun presentHistoryEmpty(isEmpty: Boolean) {
        setVisibility(isEmptyHistory, isEmpty)
    }

    private fun setVisibility(view: View, visibility: Boolean){
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
