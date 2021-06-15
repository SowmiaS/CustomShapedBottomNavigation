package com.ss.customshapedbottomnavigation

import android.content.Context
import android.graphics.*
import android.graphics.Color.*
import android.os.Build
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.google.android.material.bottomnavigation.BottomNavigationView

class BazierCurve1BottomNavigation @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr) , StyledBottomNavigation {


    var path = Path()
    val paint = getPaintStyle()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path = getPath(w, h)
    }

//    override fun getLayoutParams(): ViewGroup.LayoutParams {
//        super.getLayoutParams().height = 48
//        return super.getLayoutParams()
//    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, paint)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun getPath(w: Int, h: Int): Path {
        val path = Path()
        path.moveTo(0f, 20f)
        path.quadTo(w * 0.20f, 0f, w * 0.35f, 0f  )
        path.quadTo(w * 0.40f, 0f, w * 0.40f, 20f )
        path.quadTo(w * 0.50f, h.toFloat(), w * 0.60f, 20f )
        path.quadTo(w * 0.60f, 0f, w * 0.65f, 0f )
        path.quadTo(w * 0.80f, 0f, w.toFloat() , 20f )
        path.lineTo(w.toFloat(), h.toFloat())
        path.lineTo(0f,h.toFloat())
        path.close()
        return path

//        val rect =  RectF(w * 0.40f, -20f, w * 0.60f, h/2f)
//        path.addArc( rect, 0f, 180f )
    }

    override fun getPaintStyle(): Paint {
        val paint = Paint()
        paint.color = WHITE
        paint.style = Paint.Style.FILL_AND_STROKE
        return paint
    }

}


interface StyledBottomNavigation{

    fun getPath(w: Int, h: Int) : Path
    fun getPaintStyle() : Paint

}