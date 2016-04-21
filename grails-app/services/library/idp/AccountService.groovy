package library.idp

import grails.transaction.Transactional

@Transactional
class AccountService {

    UserService userService

    def login(Credentials credentials) {
        def account = null // TODO: get an account info from the backend service
        account.save()
    }

    def logout(String login) {
        // TODO: send logout event to the backend service
        deleteIfExists(login)
    }

    def updateIfExists(Account updatedAccount) {
        def account = Account.findByLogin(updatedAccount.login)
        if (account != null) {
            account.nativeId = updatedAccount.nativeId
            account.login = updatedAccount.login
            account.roles = updatedAccount.roles
            account.registered = updatedAccount.registered
            account.lastModified = updatedAccount.lastModified
            account.save()
            userService.updateIfExists(account)
        }
    }

    def deleteIfExists(String login) {
        def account = Account.findByLogin(login)
        if (account != null) {
            account.delete();
            userService.deleteIfExists(login)
        }
    }
}
