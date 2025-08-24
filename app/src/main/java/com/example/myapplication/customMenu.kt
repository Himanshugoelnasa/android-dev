package com.example.myapplication

import android.content.Context
import android.view.View
import androidx.appcompat.widget.PopupMenu
import android.widget.Toast

class CustomMenu {

    fun showMenu(context: Context, view: View) {
        val pop = PopupMenu(context, view)
        pop.inflate(R.menu.menu)

        pop.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.editMenuItem -> {
                    Toast.makeText(context, "Edit Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.shareMenuItem -> {
                    Toast.makeText(context, "Share Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.deleteMenuItem -> {
                    Toast.makeText(context, "Delete Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        try {
            val fieldmPopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldmPopup.isAccessible = true
            val mPopup = fieldmPopup.get(pop)
            mPopup.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java).invoke(mPopup, true)
        } catch (e: Exception) {

        } finally {
            pop.show()
        }
    }



}
