package com.example.this_pc.flyhigh.fragments

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.this_pc.flyhigh.R
import com.example.this_pc.flyhigh.adapter.DialogAdapter
import com.example.this_pc.flyhigh.utils.C
import kotlinx.android.synthetic.main.bottom_sheet_modal_filter.*

/**
 * Created by Saksham on 2018 07 09.
 * Last Branch Update - v
 * Updates:
 * Saksham - 2018 07 09 - v  - Initial
 */
class ModalBottomFilterSheet: BottomSheetDialogFragment(), View.OnClickListener{
    lateinit var recyclerView : RecyclerView
    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet_modal_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*recyclerView = view.findViewById<View>(R.id.dialog_box) as RecyclerView*/
        dialog_box.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        dialog_box.adapter = DialogAdapter(Integer.parseInt(C.adapterPosition))
    }
}