package library.idp

class TokenController {

    static allowedMethods = [save: 'POST']
    static responseFormats = ['json']

    TokenService tokenService;

    def save(Credentials credentials) {
        respond tokenService.resetAndGet(credentials)
    }
}
