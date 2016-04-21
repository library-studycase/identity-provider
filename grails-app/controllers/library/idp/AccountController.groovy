package library.idp

class AccountController {

    static allowedMethods = [update: 'PUT', delete: 'DELETE']
    static responseFormats = ['json']

    AccountService accountService

    def update(Account account) {
        accountService.updateIfExists(account)
        respond []
    }

    def delete(Account account) {
        accountService.deleteIfExists(account.login)
        respond []
    }
}
