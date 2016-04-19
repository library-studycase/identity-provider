package library.idp

class AccountController {

    static allowedMethods = [index: 'GET', save: 'POST',]
    static responseFormats = ['json']

    def index() {
        respond Account.list
    }

    def save(Account account) {
        Account.save(account)
    }
}
