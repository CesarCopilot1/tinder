package com.example.tinderdef.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.tinderdef.R
import com.example.tinderdef.adapters.HistoriaAdapter
import com.example.tinderdef.adapters.OnInteractionListener
import com.example.tinderdef.databinding.FragmentDashboardBinding
import com.example.tinderdef.ui.home.HomeViewModel

class DashboardFragment : Fragment() {
    private lateinit var viewPager: ViewPager
    private lateinit var historiaAdapter: HistoriaAdapter
    private var likedImages = mutableListOf<Int>()

    private var _binding: FragmentDashboardBinding? = null


    private val homeViewModel: HomeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager)

        // Observar los cambios en la lista de imágenes "likeadas"
        homeViewModel.likedImages.observe(viewLifecycleOwner) { images ->
            likedImages.clear()
            likedImages.addAll(images)

            // Inicializar o actualizar el adapter cuando haya cambios
            historiaAdapter = HistoriaAdapter(requireContext(), likedImages, object :
                OnInteractionListener {
                    override fun onLiked(image: Int) {
                    // No es necesario aquí
                    }

                    override fun onDisliked(image: Int) {
                        // No es necesario aquí
                    }
                }
            )

            viewPager.adapter = historiaAdapter
        }
    }
}