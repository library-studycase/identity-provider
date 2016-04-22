package library.idp

import grails.transaction.Transactional

@Transactional
class UserService {

    AccountService accountService;

    def createAndReplace(Account account) {

        deleteIfExists(account.login)

        def user = new User(
                login: account.login,
                nativeId: account.nativeId,
                roles: account.roles,
                registered: account.registered,
                lastModified: account.lastModified,
                lastActed: new Date(),
                token: UUID.randomUUID().toString())

        user.save()

        user
    }

    def getIfNotExpired(String token) {

        def user = User.findByToken(token)

        if (user == null) {
            throw new IllegalArgumentException("user is missing")
        }

        if (new Date().getTime() - user.lastActed.getTime() > 15 * 60 * 1000) {
            user.delete()
            throw new IllegalArgumentException("user is expired")
        }

        user.lastActed = new Date()

        user.save()

        user
    }

    def updateIfExists(Account updatedAccount) {
        def user = User.findByLogin(updatedAccount.login)
        if (user != null) {
            user.nativeId = updatedAccount.nativeId
            user.login = updatedAccount.login
            user.roles = updatedAccount.roles
            user.registered = updatedAccount.registered
            user.lastModified = updatedAccount.lastModified
            user.save();
        }
    }

    def deleteIfExists(String login) {
        def user = User.findByLogin(login)
        if (user != null) {
            user.delete()
        }
    }
}
