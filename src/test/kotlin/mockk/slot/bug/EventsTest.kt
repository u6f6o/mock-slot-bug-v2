package mockk.slot.bug

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Test


class EventsTest {

    private val showCase = mockk<ShowCase>()

    private val payloadSlot = slot<Payload>()


    @Test
    fun testSth() {
        every { showCase.doSth(capture(payloadSlot)) } returns "Bliblablub"

        val event = EmailReceivedEvent(
            userId = "arthur123"
        )
        val result = showCase.doSth(event)

        result shouldBe "Bliblablub"
        payloadSlot.captured shouldBe event
    }
}