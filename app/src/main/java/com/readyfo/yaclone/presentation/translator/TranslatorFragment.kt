package com.readyfo.yaclone.presentation.translator


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.readyfo.yaclone.R
import com.readyfo.yaclone.presentation.choselang.ChoseLangFragment
import kotlinx.android.synthetic.main.fragment_translator.*
import moxy.MvpAppCompatFragment


class TranslatorFragment : MvpAppCompatFragment(){
//    @InjectPresenter
//    var translatorPresenter: TranslatorPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupChoseLangContainer()
    }

    // TODO delete mock selectedLanguage
    private fun setupChoseLangContainer() {
        btnLanguageFrom.setOnClickListener {
            val typeLanguage = ChoseLangFragment.TYPE_TEXT_LANGUAGE
            val action = TranslatorFragmentDirections.actionNavigationTranslatorToChoseLangFragment("ru", typeLanguage)
            it.findNavController().navigate(action)
        }

//        btnSwapLang.setOnClickListener {
//
//        }

        btnLanguageTo.setOnClickListener {
            val typeLanguage = ChoseLangFragment.TYPE_TRANSLATE_LANGUAGE
            val action = TranslatorFragmentDirections.actionNavigationTranslatorToChoseLangFragment("en", typeLanguage)
            it.findNavController().navigate(action)
        }
    }
}
//fun toMap(`object`: JSONObject): Map<String, Any>? {
//    val map: MutableMap<String, Any> = HashMap()
//    val keys: Iterator<*> = `object`.keys()
//    while (keys.hasNext()) {
//        val key = keys.next() as String
//        map[key] = fromJson(`object`[key])
//    }
//    return map
//}