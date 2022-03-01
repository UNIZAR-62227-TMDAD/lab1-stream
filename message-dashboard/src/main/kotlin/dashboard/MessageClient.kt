package dashboard

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder

@Component
class MessageClient(
    templateBuilder: RestTemplateBuilder,
    @Value("\${message.factory.protocol}") val protocol: String,
    @Value("\${message.factory.host}") val host: String,
    @Value("\${message.factory.port}") val port: Int
) {

    private val restTemplate = templateBuilder.build()

    fun search(q: String): List<Message> {
        val url = UriComponentsBuilder.newInstance()
            .scheme(protocol)
            .host(host)
            .port(port)
            .pathSegment("messages")
            .queryParam("q", q)
            .build()
            .toUri()
        val response = restTemplate.exchange(url, HttpMethod.GET, null, MessageList)
        return response.body ?: ArrayList()
    }
}

object MessageList : ParameterizedTypeReference<List<Message>>()
