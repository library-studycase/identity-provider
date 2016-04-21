package library.idp

class UserController {

    static allowedMethods = [show: 'GET']
    static responseFormats = ['json']

    UserService userService;

    def show(String token) {
        respond userService.getIfNotExpired(token)
    }
}
