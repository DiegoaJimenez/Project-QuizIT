package com.example.project_quizit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.project_quizit.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textTomarQuiz1.setOnClickListener {
            val args = Bundle()
            //args.putFloat("number1",binding.number1.text.toString().toFloatOrNull()?:0.0)
            args.putString("textCount",binding.textQuiz1.text.toString())
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, args)
        }

        binding.textTomarQuiz2.setOnClickListener {
            val args = Bundle()
            //args.putFloat("number1",binding.number1.text.toString().toFloatOrNull()?:0.0)
            args.putString("textCount",binding.textQuiz2.text.toString())
            findNavController().navigate(R.id.action_FirstFragment_to_DockerFragment, args)
        }

        binding.textTomarQuiz3.setOnClickListener {
            val args = Bundle()
            //args.putFloat("number1",binding.number1.text.toString().toFloatOrNull()?:0.0)
            args.putString("textCount",binding.textQuiz3.text.toString())
            findNavController().navigate(R.id.action_FirstFragment_to_mysqlFragment, args)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}