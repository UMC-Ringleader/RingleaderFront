package com.example.ringleaderfront.WriteReview

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import com.example.ringleaderfront.R
import com.example.ringleaderfront.Store
import kotlinx.android.synthetic.main.store_list_item.view.*

class StoreListViewAdapter(val items: MutableList<Store>) : BaseAdapter(), Filterable {

    var TAG = "StoreListViewAdapter"

    var filteredStores = ArrayList<Store>()


    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()
            Log.d(TAG, "charSequence : $charSequence")

            val filteredList: ArrayList<Store> = ArrayList<Store>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = items
                results.count = items.size

                return results
            } else {
                for (item in items) {
                    if (item.storeName.contains(filterString)) {
                        filteredList.add(item)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }


        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
            filteredStores.clear()
            filteredStores.addAll(filterResults?.values as ArrayList<Store>)
            notifyDataSetChanged()
        }


    }



    init {
        filteredStores.addAll(items)
    }

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Store = items[position]
    override fun getItemId(position: Int): Long = position.toLong()

    //listview를 보여줌 storeName을 바인딩함
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var convertView = view
        if (convertView == null) convertView =
            LayoutInflater.from(parent?.context).inflate(R.layout.store_list_item, parent, false)

        val item: Store = items[position]
        //Store 배열의 한 객체인 item의 storeName을 item 레이아웃의 textview에 할당
        convertView!!.store_list_item_tv.text = item.storeName

        return convertView

    }

    var itemFilter = ItemFilter()

    override fun getFilter(): Filter {
        return itemFilter
    }

}