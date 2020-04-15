package com.readyfo.yaclone.presentation.utils


//abstract class DiffCallback<BM : BaseItemModel> : DiffUtil.Callback() {
//    private val mOldItems: MutableList<BM> = LinkedList()
//    private val mNewItems: MutableList<BM> = LinkedList()
//
//    fun setItems(oldItems: List<BM>, newItems: List<BM>) {
//        mOldItems.clear()
//        mOldItems.addAll(oldItems)
//        mNewItems.clear()
//        mNewItems.addAll(newItems)
//    }
//
//    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//        return areItemsTheSame(
//            mOldItems[oldItemPosition],
//            mNewItems[newItemPosition]
//        )
//    }
//
//    abstract fun areItemsTheSame(oldItem: BM, newItem: BM): Boolean
//
//    override fun getOldListSize(): Int {
//        return mOldItems.count()
//    }
//
//    override fun getNewListSize(): Int {
//        return mNewItems.count()
//    }
//
//    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//        return areContentsTheSame(
//            mOldItems[oldItemPosition],
//            mNewItems[newItemPosition]
//        )
//    }
//
//    abstract fun areContentsTheSame(oldItem: BM, newItem: BM): Boolean
//}