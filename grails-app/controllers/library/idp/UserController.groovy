package library.idp

class UserController {

    UserService userService;

    static responseFormats = ['json']

    static allowedMethods = [index:'GET', show:'GET', save:'POST', update:'PUT', delete:'DELETE']

    def index() {
        respond userService.getAll()
    }
}
