package com.readyfo.yaclone.presentation.choselang


import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.readyfo.yaclone.R
import kotlinx.android.synthetic.main.fragment_chose_lang.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ChoseLangFragment : Fragment(), ChoseLangAdapter.OnSelectedLang {
    companion object {
        const val TYPE_TEXT_LANGUAGE = 0
        const val TYPE_TRANSLATE_LANGUAGE = 1
    }

    private val viewModel by sharedViewModel<ChoseLangViewModel>()
    private val args: ChoseLangFragmentArgs by navArgs()
    private val mChoseLangAdapter by lazy {
        ChoseLangAdapter(args.selectedLanguage)
    }
    private val appCompatActivity by lazy {
        activity as AppCompatActivity
    }
    private lateinit var toolbar: Toolbar
    private val onBackPressedDispatcherCallback by lazy {
        object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_chose_lang, container, false)
        toolbar = rootView!!.findViewById(R.id.toolbarChoseLang)
        setupActionBar()

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle()
        setupAdapter()

        viewModel.fetchLanguages()
    }

    override fun onStart() {
        super.onStart()
        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedDispatcherCallback)
    }

    override fun onStop() {
        super.onStop()
        onBackPressedDispatcherCallback.remove()
    }

//    override fun presentLanguages(languages: List<LanguageModel>) {
//        mChoseLangAdapter.setData(languages)
//    }
//
//    override fun presentLoading(isLoading: Boolean) {
//        setVisibility(progressBar, isLoading)
//    }

    override fun onSelectedLang(language: String) {
        // TODO("Not yet implemented")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().navigateUp()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }

    private fun setupActionBar() {
        appCompatActivity.setSupportActionBar(toolbar)

        appCompatActivity.supportActionBar?.setHomeButtonEnabled(true)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupAdapter() {
        recyclerViewChoseLang.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        recyclerViewChoseLang.adapter = mChoseLangAdapter
        mChoseLangAdapter.registerCallBack(this)
    }

    private fun setTitle() {
        appCompatActivity.setSupportActionBar(toolbar)

        when (args.typeLanguage) {
            TYPE_TEXT_LANGUAGE -> {
                appCompatActivity.supportActionBar?.setTitle(R.string.titleTextLanguage)
            }
            TYPE_TRANSLATE_LANGUAGE -> {
                appCompatActivity.supportActionBar?.setTitle(R.string.titleTranslateLanguage)
            }
        }
    }
}
