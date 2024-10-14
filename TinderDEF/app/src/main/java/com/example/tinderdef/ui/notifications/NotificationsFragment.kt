package com.example.tinderdef.ui.notifications

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
import com.example.tinderdef.databinding.FragmentNotificationsBinding
import com.example.tinderdef.ui.home.HomeViewModel

class NotificationsFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var historiaAdapter: HistoriaAdapter
    private var dislikedImages = mutableListOf<Int>()
    private var _binding: FragmentNotificationsBinding? = null
    // Compartir el mismo HomeViewModel
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
        homeViewModel.dislikedImages.observe(viewLifecycleOwner) { images ->
            dislikedImages.clear()
            dislikedImages.addAll(images)

            // Inicializar o actualizar el adapter cuando haya cambios
            historiaAdapter = HistoriaAdapter(requireContext(), dislikedImages, object :
                OnInteractionListener {
                override fun onLiked(image: Int) {
                    // No es necesario aquí
                }

                override fun onDisliked(image: Int) {
                    // No es necesario aquí
                }
            })

            viewPager.adapter = historiaAdapter
        }
    }
}