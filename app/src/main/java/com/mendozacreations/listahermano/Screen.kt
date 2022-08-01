package com.mendozacreations.listahermano

sealed class Screen(val route: String) {
    object RegistroHermanoScreen: Screen("RegistroHermanoScreen")
    object ListaHermanoScreen: Screen("ListaHermanoScreen")
}
