package factory

/**
 * A data class that represents an outgoing message.
 */
data class Message(
    val id: Long,
    val from: String,
    val country: String,
    val query: String,
    val content: String
)
