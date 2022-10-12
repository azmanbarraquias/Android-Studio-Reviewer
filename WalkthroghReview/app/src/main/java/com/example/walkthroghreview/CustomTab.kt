package com.example.walkthroghreview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.custom_tab.view.*

class CustomTab @JvmOverloads constructor(context: Context, attributeSet: AttributeSet, defStyle : Int = 0
) : LinearLayout(context, attributeSet, defStyle){

     private var tabArray = arrayOf<ImageView>()
     var previousIndex = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_tab, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        tabArray  = arrayOf(tab1, tab2, tab3, tab4)
        setBackGroundColor()
        viewPagerListener()
    }

    fun setR(fragmentManager: FragmentManager , lifecycle: Lifecycle){
        viewPager2.adapter = ViewPager2Adapter(fragmentManager, lifecycle)
    }

    fun setBackGroundColor(){
        tabArray.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                it.setBackgroundColor(Color.parseColor("#ffffff"))
                if(previousIndex != index){
                    tabArray[previousIndex].setBackgroundColor(Color.parseColor("#000000"))
                    tabStrip.animate().translationX(imageView.x).duration = 300
                    viewPager2.currentItem = index
                }
                previousIndex = index
            }
        }
    }

    fun viewPagerListener(){
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabArray[position].setBackgroundColor(Color.parseColor("#ffffff"))
                tabStrip.animate().translationX(tabArray[position].x).duration = 300
                tabArray[previousIndex].setBackgroundColor(Color.parseColor("#000000"))
                previousIndex = position
            }
        })
    }
}