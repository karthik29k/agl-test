package au.com.energy.agl.view

import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import au.com.energy.agl.MainActivity
import au.com.energy.agl.adapter.PetDetailsAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class LayoutUI(
        private val maleAdapter: PetDetailsAdapter,
        private val femaleAdapter: PetDetailsAdapter) : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {

        return relativeLayout {

            // Data layout
            linearLayout {
                orientation = LinearLayout.VERTICAL

                // Male data
                textView(Gender.MALE.name).lparams(width = matchParent, height = wrapContent)
                recyclerView {
                    id = Ids.maleListView
                    layoutManager = LinearLayoutManager(ctx)
                    adapter = maleAdapter
                }.lparams(width = matchParent, height = wrapContent) {
                    padding = 16
                }

                // Female data
                textView(Gender.FEMALE.name).lparams(width = matchParent, height = wrapContent)
                recyclerView {
                    id = Ids.femaleListView
                    layoutManager = LinearLayoutManager(ctx)
                    adapter = femaleAdapter
                }.lparams(width = matchParent, height = wrapContent) {
                    padding = 16
                }

            }.lparams(width = matchParent, height = wrapContent) {
                above(Ids.buttonLayout)
                alignParentTop()
                alignParentStart()
                padding = 16
            }

            // Button layout
            linearLayout {
                id = Ids.buttonLayout
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER
                padding = 16

                // Refresh button
                button(ButtonAction.REFRESH.name) {
                    id = Ids.refreshButton
                    gravity = Gravity.CENTER
                    onClick {
                        ui.owner.refreshListViewOnClick()
                    }
                }.lparams(width = wrapContent, height = wrapContent)

                // Clear button
                button(ButtonAction.CLEAR.name) {
                    id = Ids.clearButton
                    onClick {
                        ui.owner.clearListView()
                    }
                }.lparams(width = wrapContent, height = wrapContent)

            }.lparams(width = matchParent, height = wrapContent) {
                centerInParent()
                alignParentStart()
                alignParentEnd()
            }
        }
    }

    private object Ids {
        const val maleListView = 1
        const val femaleListView = 2
        const val buttonLayout = 3
        const val refreshButton = 4
        const val clearButton = 5
    }

}

enum class Gender { MALE, FEMALE }
enum class ButtonAction { CLEAR, REFRESH }
