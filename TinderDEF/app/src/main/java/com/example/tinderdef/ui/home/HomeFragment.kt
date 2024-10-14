package com.example.tinderdef.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager.widget.ViewPager
import com.example.tinderdef.MainActivity
import com.example.tinderdef.R
import com.example.tinderdef.adapters.HistoriaAdapter
import com.example.tinderdef.adapters.OnInteractionListener
import com.example.tinderdef.models.Historia

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var historiaAdapter: HistoriaAdapter

    // Utilizar el HomeViewModel compartido
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)

        // Observar los cambios en la lista de imágenes desde el ViewModel
        homeViewModel.imageList.observe(viewLifecycleOwner) { imageList ->
            // Inicializar el adapter con la lista de imágenes del ViewModel
            historiaAdapter = HistoriaAdapter(requireContext(), imageList, object : OnInteractionListener {
                override fun onLiked(image: Int) {
                    homeViewModel.addLikedImage(image)  // Agregar imagen "likeada"
                    homeViewModel.removeImage(image)  // Eliminar de la lista en el ViewModel
                }

                override fun onDisliked(image: Int) {
                    homeViewModel.addDislikedImage(image)  // Agregar imagen "dislikeada"
                    homeViewModel.removeImage(image)  // Eliminar de la lista en el ViewModel
                }
            })
            viewPager.adapter = historiaAdapter
        }
    }
}