package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import com.yandex.mobius360quest.core.BaseViewBindingFragment
import com.yandex.mobius360quest.core.databinding.FragmentFirstBinding

class HelloFragment : BaseViewBindingFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    // fix #7
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.isContextClickable = true
    }
    // -------
}