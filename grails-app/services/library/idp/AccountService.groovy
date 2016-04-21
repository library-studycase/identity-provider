package library.idp

import com.tsystems.dfmg.studies.library.datasource.domain.LibraryPort
import com.tsystems.dfmg.studies.library.datasource.domain.LibraryPortService
import com.tsystems.dfmg.studies.library.datasource.domain.ReadUserBisRequest
import grails.transaction.Transactional

@Transactional
class AccountService {

    UserService userService

    LibraryPort backend = new LibraryPortService().getLibraryPortSoap11()

    def login(Credentials credentials) {

        def response = backend
                .readUserBis(new ReadUserBisRequest(
                        login: credentials.login,
                        password: credentials.password))
                .userBis

        new Account(
                    nativeId: response.nativeId,
                    login: response.login,
                    roles: response.roles,
                    registered: response.created,
                    lastModified: response.lastModified)
                .save()
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
