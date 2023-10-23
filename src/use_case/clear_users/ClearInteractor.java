package use_case.clear_users;

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary userPresenter;

    public ClearInteractor(ClearUserDataAccessInterface clearDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = clearDataAccessInterface;
        this.userPresenter = clearOutputBoundary;
    }

    public void execute() {
        String deleted_users = userDataAccessObject.clearUsers();

        ClearOutputData clearOutputData = new ClearOutputData(deleted_users);
        userPresenter.prepareSuccessView(clearOutputData);
    }
}
