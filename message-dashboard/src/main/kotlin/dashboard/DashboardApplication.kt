package dashboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DashboardApplication

fun main(vararg args: String) {
    runApplication<DashboardApplication>(*args)
}
