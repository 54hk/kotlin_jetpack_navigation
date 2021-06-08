package cn.hk.navigation3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import cn.hk.navigation3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        val myViewModel by activityViewModels<MyViewModel>()
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false
        )
        binding.also {
            it.data = myViewModel
            it.lifecycleOwner = activity
            it.button.setOnClickListener { v ->
                val controller = Navigation.findNavController(v)
                controller.navigate(R.id.action_homeFragment_to_detailFragment)
            }
            myViewModel.get().value?.also { numberValue ->
                it.seekBar.progress = numberValue
            }
            it.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                   myViewModel.set(p1)
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })
        }

        return binding.root
    }


}