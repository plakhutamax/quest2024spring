package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.forEach
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.core.BaseViewBindingFragment
import com.yandex.mobius360quest.core.Randomizer
import com.yandex.mobius360quest.core.databinding.RotateLayoutBinding

class Rotate : BaseViewBindingFragment<RotateLayoutBinding>(RotateLayoutBinding::inflate) {

    private val value = Randomizer.getNewValue()
    private var entry = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        entry = binding.passcode.text.toString()
        makeCheck()
        binding.text.text = getString(R.string.rotate_passcode_template, value)
        binding.grid.forEach { itemView ->
            when {
                itemView.id == com.yandex.mobius360quest.core.R.id.button_clear -> itemView.setOnClickListener {
                    binding.passcode.text = entry
                    entry = ""
                }
                itemView.id == com.yandex.mobius360quest.core.R.id.button_next -> itemView.setOnClickListener {
                    findNavController().navigate(R.id.step_to_next)
                }
                itemView is Button -> itemView.setOnClickListener {
                    entry += itemView.text.toString()
                    binding.passcode.text = entry
                    makeCheck()
                }
            }
        }
    }

    private fun makeCheck() {
        binding.buttonNext.isEnabled = Randomizer.compare(entry, value)
    }
}