package factory

import kotlinx.coroutines.reactive.asPublisher
import org.reactivestreams.Publisher
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(
    private val messageService: MessageService
) {
    /**
     * Return a JSON representation of a list of messages.
     */
    @GetMapping("/messages")
    fun getMessagesOfUser(@RequestParam("q") query: String): List<Message> = messageService.getMessageList(query)

    /**
     * Return a stream of JSON representation of single messages.
     */
    @GetMapping(path = ["/messages-sse"], produces = [MediaType.APPLICATION_NDJSON_VALUE])
    fun streamEvents(@RequestParam("q") query: String): Publisher<Message> =
        messageService.getMessageFlow(query).asPublisher()
}
