package com.brkayaoglu.loldebug.core.constants

class NetworkConstants {


    companion object{
        const val baseUrl = "https://tr1.api.riotgames.com/"

        const val API_SUMMONER_GET = "lol/summoner/v4/summoners/by-name"

        const val API_KEY = "RGAPI-9e98a1ae-e2d4-4d72-bc10-19487c429b2a"

    }

    enum class Encoding(val encoding: String) {
        JSON("application/json"),
        FORM_DATA("multipart/form-data; charset=utf-8; boundary=GoogleVolleyFormBoundary"),
    }

    enum class Headers(val key: String) {
        CONTENT_TYPE("Content-Type"),
        ACCEPT("Accept"),
        RIOT_TOKEN("X-Riot-Token")
    }

}