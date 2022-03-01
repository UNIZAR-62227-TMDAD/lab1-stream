package dashboard

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageSearchController(val service: MessageService) {

    @RequestMapping("/search")
    fun search(@RequestParam("q") q: String?): SearchResponse = q
        ?.let { SearchResponse(service.search(it)) }
        ?: emptyResponse()

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Throwable::class)
    fun handleAnyException(): SearchResponse = emptyResponse()
}

data class SearchResponse(val messages: List<Message> = emptyList())

fun emptyResponse() = SearchResponse()
