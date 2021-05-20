package com.brkayaoglu.loldebug.util

import androidx.recyclerview.widget.DiffUtil


class RecipeDiffUtil(
    //private val oldList : List<FoodRecipeItem>,
    //private val newList : List<FoodRecipeItem>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return 0
    }

    override fun getNewListSize(): Int {
        return 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return false
    }

    /*
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }
     */
}