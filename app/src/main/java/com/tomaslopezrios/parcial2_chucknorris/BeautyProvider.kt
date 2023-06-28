package com.tomaslopezrios.parcial2_chucknorris

class BeautyProvider {
        companion object{
        val ChuckNorrisImages = mutableListOf<ChuckNorrisImage>(
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMaFgBVX8owFlTDFhnyUwW0ZK-mqw8qBsmCQ&usqp=CAU"),
            ChuckNorrisImage("https://i.blogs.es/9790d1/chuck-norris/450_1000.jpeg"),
            ChuckNorrisImage("https://uploads.jovemnerd.com.br/wp-content/uploads/2019/09/walker-texas-ranger.png"),
            ChuckNorrisImage("https://estaticos-cdn.prensaiberica.es/clip/f43b85c4-14e3-4a4d-ab61-cde8e8ed4e0e_16-9-aspect-ratio_default_0.jpg"),
            ChuckNorrisImage("https://i0.wp.com/codigoespagueti.com/wp-content/uploads/2018/12/chuck-norris-thanos.jpg"),
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS88S3KACYtWYxzB4ZTIqbO0reFAuiYe69TRA&usqp=CAU"),
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiwL1iZynVetswKYSNe1ltosjoCRKQ79h1KQ&usqp=CAU"),
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7BlFoJbmlpukfYRBIARN5gSxMOOWAbSIEjXFpbTRXf8ubiJ_gMayl_snGFvk7WqJkvXY&usqp=CAU"),
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqjSFOasFEYQm0yPDfBGy2OKVaC_24g3qraZ2X1ZFOsbgDjdvRZO3Q4ixAnBuMhon4Ysk&usqp=CAU"),
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrNK2KzhrK_tir7vRZXj5GH6kJVyM6CivAAhBvcHPS_FOXrczX63hfX9hnqOgpCiYi-30&usqp=CAUm"),
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8FJfk3jYTC9YRnomM9bbMvvulenDiuKstyuEBA_chgNQfv8BSUzKDaeMKg87b2DCkJVg&usqp=CAU"),
            ChuckNorrisImage("https://www.gannett-cdn.com/presto/2020/03/10/USAT/14860a5d-3ae8-4049-b4b5-5a02e14c4721-Chuck_Norris_01.JPG?crop=1933%2C1087%2Cx1%2Cy153&width=1200"),
            ChuckNorrisImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSr5n9jNw54T4paCL4bSz9DcKWbDgUg3C6dNZIjXRiOtS1RR_byvUmY5Z8To2z5Y_qWodE&usqp=CAU"),
        )
        val MainLogo : String = "https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png"
    }

}

data class ChuckNorrisImage (

    val urlPhoto: String
)

