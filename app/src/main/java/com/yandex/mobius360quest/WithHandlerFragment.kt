package com.yandex.mobius360quest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.core.BaseViewBindingFragment
import com.yandex.mobius360quest.core.databinding.FragmentWithHandlerBinding

class WithHandlerFragment : BaseViewBindingFragment<FragmentWithHandlerBinding>(FragmentWithHandlerBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            Handler(Looper.getMainLooper()) {
//                findNavController().navigate(R.id.step_to_next)
                false
            }.post {
                // Пример 1: действие должно быть не в callback хэндлера, а в post { } (перехода не будет)
                findNavController().navigate(R.id.step_to_next)
            }
        }
    }
}