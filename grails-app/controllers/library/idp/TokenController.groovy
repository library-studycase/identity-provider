package library.idp

import grails.converters.JSON

class TokenController {

    static allowedMethods = [index:'GET', show:'GET', save:'POST', update:'PUT', delete:'DELETE']
    static responseFormats = ['json']

    TokenService tokenService;

    def save(Credentials credentials) {
        respond tokenService.renew(credentials)
    }
}
