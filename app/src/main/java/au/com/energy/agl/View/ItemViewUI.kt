package au.com.energy.agl.view

import android.content.Context
import android.graphics.Color
import android.view.View
import au.com.energy.agl.R
import org.jetbrains.anko.*

class ItemViewUI : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {

        return relativeLayout {
            padding = dip(15)
            textView {
                lparams {
                    width = wrapContent
                    height = wrapContent
                }
                textSize = sp(10).toFloat()
                textColor = Color.RED
                id = R.id.txtType
            }
        }
    }
}