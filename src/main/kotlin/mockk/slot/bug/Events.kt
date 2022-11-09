package mockk.slot.bug


data class EmailReceivedEvent(
    val userId: String,
    override val eventType: String = "EmailReceived"
): Payload()

data class EmailDeliveryFailedEvent(
    val userId: String,
    val message: String,
    override val eventType: String = "EmailDeliveryFailed"
): Payload()

sealed class Payload {
    abstract val eventType: String
}

class ShowCase {

    fun doSth(payload: Payload) = when(payload) {
        is EmailReceivedEvent -> "foo"
        is EmailDeliveryFailedEvent -> "bar"
    }
}