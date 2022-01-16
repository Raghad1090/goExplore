package com.raghad.goexplore.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.raghad.goexplore.R
import com.raghad.goexplore.TripDatabase
import com.raghad.goexplore.databinding.FragmentTripBinding
import com.raghad.goexplore.overview.OverViewViewModel

class TripFragment : Fragment() {


    private var binding: FragmentTripBinding? = null

    private val viewModel : OverViewViewModel by viewModels()

    var id = FirebaseAuth.getInstance().currentUser?.uid ?: ""

    private val collection = Firebase.firestore.collection("My trips")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentTripBinding = FragmentTripBinding.inflate(inflater,container,false)
        binding = fragmentTripBinding

        return fragmentTripBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.creatTrip?.setOnClickListener {

//            save(binding!!.addtripTitle.editableText.toString(),binding!!.addtripDes.editableText.toString())
//            save(binding!!.addtripTitle.editableText.toString(),binding!!.addtripDes.editableText.toString())

            save(binding!!.addtripTitle.editText.toString(),binding!!.addtripDes.editableText.toString())

            val action = TripFragmentDirections.actionTripFragmentToTravelPlansFragment()
            view.findNavController().navigate(action)
        }
    }


    private fun save(title: String , description: String){

        TripDatabase().save(title,description)

    }
}

