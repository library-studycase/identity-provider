package library.idp

class UserController {

    static allowedMethods = [index: 'GET', show: 'GET']
    static responseFormats = ['json']

    UserService userService;

    def index(String token) {
        respond userService.getIfNotExpired(token)
    }
}
