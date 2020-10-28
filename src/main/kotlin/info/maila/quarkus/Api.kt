package info.maila.quarkus

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Contact
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.info.License
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@OpenAPIDefinition(
        tags = [
            Tag(name = "TagA", description = "the tag 'A'"),
            Tag(name = "TagB", description = "the tag 'B'")
        ],
        info = Info(
                title = "Code with Quarkus",
                version = "0.0.1",
                contact = Contact(
                        name = "Code with Quarkus API Support",
                        url = "https://github.com/jeschu/code-with-quarkus",
                        email = "jeschu@ok.de"
                ),
                license = License(
                        name = "MIT License",
                        url = "https://mit-license.org/"
                )
        )
)
class Api {
}