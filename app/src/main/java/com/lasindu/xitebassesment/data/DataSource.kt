package com.lasindu.xitebassesment.data

import com.lasindu.xitebassesment.model.Planet
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class DataSource {
    var planets: Planet? = null

    fun getPlants(): String? {
        var body: String? = null
        val client = HttpClient(CIO)
//        val response: HttpResponse = client.get("https://swapi.dev/api/planets/")
//        return loadPlanets()
//        runBlocking {
//            val response: HttpResponse = client.get("https://swapi.dev/api/planets/")
//            val responseBody: ByteArray = response.body()
//            body = responseBody.toString()
//        }

//        runBlocking {
//            val client = HttpClient(CIO) {
//                defaultRequest {
//                    url {
//                        protocol = URLProtocol.HTTPS
//                        host = "swapi.dev"
//                        path("api/planets")
//                    }
//                }
//            }
//
//            val response: HttpResponse = client.get("/")
//            println(response.status)
//        }

        print("Hello There")
//        print(body)
        return "Hello There"

    }

    fun loadPlanets(): List<Planet> {
        return listOf<Planet>(

            Planet("Tatooine", 200, "arid", "abc"),
            Planet("Alderaan", 200, "temperate", "abc"),
            Planet("Yavin IV", 200, "temperate, tropical", "abc"),
            Planet("Hoth", 200, "frozen", "abc"),
            Planet("Tatooine", 200, "arid", "abc"),
            Planet("Alderaan", 200, "temperate", "abc"),
            Planet("Yavin IV", 200, "temperate, tropical", "abc"),
            Planet("Hoth", 200, "frozen", "abc"),
            Planet("Tatooine", 200, "arid", "abc"),
            Planet("Alderaan", 200, "temperate", "abc"),
            Planet("Yavin IV", 200, "temperate, tropical", "abc"),
            Planet("Hoth", 200, "frozen", "abc"),
            Planet("Tatooine", 200, "arid", "abc"),
            Planet("Alderaan", 200, "temperate", "abc"),
            Planet("Yavin IV", 200, "temperate, tropical", "abc"),
            Planet("Hoth", 200, "frozen", "abc"),
            Planet("Tatooine", 200, "arid", "abc"),
            Planet("Alderaan", 200, "temperate", "abc"),
            Planet("Yavin IV", 200, "temperate, tropical", "abc"),
            Planet("Hoth", 200, "frozen", "abc"),

        )

    }
}