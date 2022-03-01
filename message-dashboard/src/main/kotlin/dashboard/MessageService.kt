package dashboard

import org.springframework.stereotype.Service

@Service
class MessageService(private val messageClient: MessageClient) {
    fun search(query: String): List<Message> = messageClient.search(query)
}
