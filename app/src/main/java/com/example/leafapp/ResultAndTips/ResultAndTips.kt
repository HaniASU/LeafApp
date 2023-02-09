package com.example.leafapp.ResultAndTips

import android.graphics.Bitmap
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leafapp.R
import com.example.leafapp.databinding.FragmentResultAndTipsBinding

class ResultAndTips : Fragment() {

    companion object {
        fun newInstance() = ResultAndTips()
    }

    private lateinit var viewModel: ResultAndTipsViewModel
    lateinit var binding: FragmentResultAndTipsBinding

    lateinit var img : Bitmap
    var isSave: Boolean =  true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentResultAndTipsBinding.inflate(layoutInflater)
//        getFragment(UserHomeFragment())
        val args = arguments?.let {
            ResultAndTipsArgs.fromBundle(
                it
            )
        }
        args?.let {
            img = it.myImage
            isSave = it.saveImge
        }

        return binding.root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ResultAndTipsViewModel::class.java)
        viewModel.setImageBitmab(img, this.requireActivity().assets,this.requireActivity().contentResolver, isSave)
        binding.takenImg.setImageBitmap(img)
        binding.plantName.text = viewModel.plantName
        binding.desas.text= viewModel.dseas
        if(viewModel.disasData != null){
            binding.disease = viewModel.disasData
            binding.fail.visibility= View.GONE
        }
        else{
            binding.resLv.visibility = View.GONE

        }

        if (viewModel.dseas.equals("healthy")){
            binding.statImg.setImageResource(R.drawable.good_plant)
        }



    }

}