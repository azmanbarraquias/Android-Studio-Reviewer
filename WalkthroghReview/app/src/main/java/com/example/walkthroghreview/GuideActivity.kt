package com.example.walkthroghreview

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class GuideActivity(color : String) : Fragment() {
    var colorX = color
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.guide_layout, container, false)
        setBackgroundColor(view)
        return view
    }

    fun setBackgroundColor(view: View){
        view.findViewById<ConstraintLayout>(R.id.guide_fragment).setBackgroundColor(Color.parseColor(colorX))
    }
}