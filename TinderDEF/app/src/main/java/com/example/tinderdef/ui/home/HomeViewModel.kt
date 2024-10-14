package com.example.tinderdef.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tinderdef.R

class HomeViewModel : ViewModel() {

    // LiveData para la lista de imágenes
    private val _imageList = MutableLiveData<MutableList<Int>>()
    val imageList: LiveData<MutableList<Int>> = _imageList

    // Inicializar la lista de imágenes
    init {
        _imageList.value = mutableListOf(
            R.drawable.pato1, R.drawable.pato2, R.drawable.pato3,
            R.drawable.pato4, R.drawable.pato5, R.drawable.gato1,
            R.drawable.gato2, R.drawable.gato3, R.drawable.gato4,
            R.drawable.aguila1, R.drawable.aguila2, R.drawable.aguila3,
            R.drawable.grand1,R.drawable.grand2,R.drawable.back1,
            R.drawable.back2,R.drawable.mtrainer1,R.drawable.mtrainer2,R.drawable.mtrainer3 ,
            R.drawable.mtrainer2,R.drawable.mtrainer3,R.drawable.mtrainer4,R.drawable.zion1,
            R.drawable.zion2,R.drawable.zion3,R.drawable.zion4,R.drawable.zion5,R.drawable.zion6,
            R.drawable.zion7
            // Añadir más imágenes según sea necesario
        )

    }

    // Métodos para agregar/quitar imágenes
    fun removeImage(image: Int) {
        _imageList.value?.let {
            it.remove(image)
            _imageList.value = it // Notificar el cambio
        }
    }


    /* private val _text = MutableLiveData<String>().apply {
         value = "This is home Fragment"
     }
     val text: LiveData<String> = _text*/

    private val _likedImages = MutableLiveData<MutableList<Int>>(mutableListOf())
    val likedImages: LiveData<MutableList<Int>> get() = _likedImages


    // Lista que contiene las imágenes "dislikeadas"
    private val _dislikedImages = MutableLiveData<MutableList<Int>>(mutableListOf())
    val dislikedImages: LiveData<MutableList<Int>> get() = _dislikedImages

    // Agregar imagen a la lista de "likeadas"
    fun addLikedImage(image: Int) {
        _likedImages.value?.add(image)
        _likedImages.value = _likedImages.value // Notificar cambio
    }

    // Agregar imagen a la lista de "dislikeadas"
    fun addDislikedImage(image: Int) {
        _dislikedImages.value?.add(image)
        _dislikedImages.value = _dislikedImages.value // Notificar cambio
    }
}
