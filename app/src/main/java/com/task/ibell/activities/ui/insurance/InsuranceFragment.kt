package com.task.ibell.activities.ui.insurance

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.task.ibell.R

class InsuranceFragment : Fragment() {

    companion object {
        fun newInstance() = InsuranceFragment()
    }

    private lateinit var viewModel: InsuranceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_insurance_view, container, false)
        val connectInsurance: FrameLayout = root.findViewById(R.id.frameLayoutConnectInsurance)
        connectInsurance.setOnClickListener {

        }
        return root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InsuranceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}