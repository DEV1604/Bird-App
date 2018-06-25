package com.example.this_pc.flyhigh.fragments

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.this_pc.flyhigh.R

/**
 * Created by Saksham on 2018 06 25
 * Last Branch Update - v
 * Updates :
 * Saksham - 2018 06 25 - v - Initial
 */
class ModalBottomSheet: BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet_modal, container, false)
    }

    fun newInstance(): BottomSheetDialogFragment {
        return BottomSheetDialogFragment()
    }
}