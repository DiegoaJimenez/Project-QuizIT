package com.example.project_quizit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.project_quizit.databinding.FragmentSecondBinding
import com.koushikdutta.ion.Ion
import okhttp3.*
import java.io.IOException

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    //val args: SecondFragmentArgs by navArgs()
    private var _binding: FragmentSecondBinding? = null

    //private val client = OkHttpClient()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    //lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textCount = requireArguments().getString("textCount")
        Log.d("TAGTEXT","textCount")
        println("ACA ESTA EL PRINT")
        println(textCount)
        //val text = args.textCount
        //binding.output = "${text}"

        binding.textviewSecond.text = textCount

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.buttonquiz.setOnClickListener {
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            loadDataApi()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadDataApi(){
        val client = OkHttpClient()
        val url = "https://quizapi.io/api/v1/questions?apiKey=5nZ0X4lZfpX1aYWUYbCkGRF3Jp3so7TkfOzv76yf"
        Log.d("TAGURL","URL api: $url")
        val request = Request.Builder()
            .url(url)
            .get()
            .build()
        Log.d("TAGREQUEST","REQUEST api: $request")
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                val responseBody = response.body?.string()
                Log.d("TAGRESPOSE","respuesta api: $responseBody")
            }

            override fun onFailure(call: Call, e: IOException) {

                Log.d("TAGERROR","error api: $e")

            }
        })

    }
}