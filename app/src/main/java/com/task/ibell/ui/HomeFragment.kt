package com.task.ibell.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.task.ibell.R
import com.task.ibell.databinding.FragmentHomeBinding

// HomeFragment.kt

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        // Set up your ViewPager here...

        // Dynamically add menu items to BottomNavigationView
        /*val bottomNavMenu = binding.bottomNav.menu

        for (i in 0 until 10) {
            bottomNavMenu.add(Menu.NONE, i, Menu.NONE, "Item $i")
                .setIcon(R.drawable.ic_placeholder) // Set your icon here
        }*/

        // Set item selected listener if needed
        /*binding.bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            // Handle item selection here
            true
        }*/

        // Styling the header title
        styleHeaderText(binding.headerTitle)
    }

    private fun styleHeaderText(textView: TextView) {
        val spannable = SpannableString(resources.getString(R.string.lee_health))

        // Set blue  for "Lee"
        val blueColor = ContextCompat.getColor(requireContext(),R.color.lee_blue)
        spannable.setSpan(
            ForegroundColorSpan(blueColor),
            0,
            3,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )

        // Set green color for "Health"
        val greenColor = ContextCompat.getColor(requireContext(),R.color.health_green)
        spannable.setSpan(
            ForegroundColorSpan(greenColor),
            4,
            spannable.length,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )

        // Make the entire text bold
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            spannable.length,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        textView.text = spannable
    }

}
