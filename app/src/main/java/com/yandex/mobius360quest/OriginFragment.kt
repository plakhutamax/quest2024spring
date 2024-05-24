package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.core.BaseViewBindingFragment
import com.yandex.mobius360quest.core.databinding.OrdinaryDaysBinding

class OriginFragment : BaseViewBindingFragment<OrdinaryDaysBinding>(OrdinaryDaysBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.step_to_next)
        }
    }

}
