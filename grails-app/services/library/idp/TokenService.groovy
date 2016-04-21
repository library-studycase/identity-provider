package library.idp

import grails.transaction.Transactional

@Transactional
class TokenService {

    AccountService accountService;

    UserService userService

    def resetAndGet(Credentials credentials) {
        def account = accountService.login(credentials)
        def user = userService.createAndReplace(account)
        new Token(value: user.token)
    }
}
