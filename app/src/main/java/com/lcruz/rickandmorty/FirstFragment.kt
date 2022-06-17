package com.lcruz.rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.lcruz.rickandmorty.adapter.CharactersAdapter
import com.lcruz.rickandmorty.databinding.FragmentFirstBinding
import com.lcruz.rickandmorty.model.Character
import com.lcruz.rickandmorty.viewmodel.CharactersViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CharactersViewModel by viewModel()
    private val list: MutableList<Character> = mutableListOf()
    private val charactersAdapter: CharactersAdapter by inject {
        parametersOf(list)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        viewModel.getCharacters()


        viewModel.characters.observe(viewLifecycleOwner) {
            charactersAdapter.updateList(it as MutableList<Character>)
        }
    }

    fun initComponents() = with(binding) {

        rvCharactersMain.layoutManager = GridLayoutManager(requireContext(), 2)
        rvCharactersMain.adapter = charactersAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}