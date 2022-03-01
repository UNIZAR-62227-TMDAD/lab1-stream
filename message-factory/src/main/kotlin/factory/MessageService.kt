package factory

import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.atomic.AtomicLong

/**
 * A service that creates messages.
 */
@Service
class MessageService {

    private val counter = AtomicLong()
    private val random = Random()
    private val loremIpsum: LoremIpsum = LoremIpsum.getInstance()

    /**
     * Creates a message.
     */
    private fun createMessage(query: String): Message = Message(
        counter.getAndIncrement(),
        loremIpsum.name,
        loremIpsum.country,
        query,
        loremIpsum.getHtmlParagraphs(MIN_PARAGRAPHS, MAX_PARAGRAPHS)
    )

    private suspend fun computeDelay() = delay(MIN_DELAY + random.nextInt(AVERAGE_PROCESS).toLong())

    /**
     * Represents multiple synchronously computed values.
     */
    fun getMessageList(query: String): List<Message> = runBlocking {
        MESSAGE_RANGE.map {
            computeDelay()
            createMessage(query)
        }
    }

    /**
     * Represents multiple asynchronously computed values.
     */
    fun getMessageFlow(query: String): Flow<Message> = flow {
        while (true) {
            computeDelay()
            emit(createMessage(query))
        }
    }

    companion object {
        const val MIN_DELAY = 250
        const val AVERAGE_PROCESS = 2500
        const val MIN_PARAGRAPHS = 1
        const val MAX_PARAGRAPHS = 2
        val MESSAGE_RANGE = 0 until 10
    }
}
