

class UrlMappings {
        static mappings = {
            "/$controller/$action?/$id?(.$format)?"{
                constraints {
                    // apply constraints here
                }
            }

        "/accounts"(resources: 'account')
        "/tokens"(resources: 'token')
        "/users"(resources: 'user')

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
