package cn.hk.navigation3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import cn.hk.navigation3.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//      val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        val myViewModel by activityViewModels<MyViewModel>()
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )
        binding.also {
            it.data = myViewModel
            it.lifecycleOwner = activity
            it.button3.setOnClickListener { v ->
                val controller = Navigation.findNavController(v)
                controller.navigate(R.id.action_detailFragment_to_homeFragment)
            }
        }
        return binding.root
    }

}