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
        userDataAccessObject.clearUsers();

        ClearOutputData clearOutputData = new ClearOutputData("All Users have been cleared.");
        userPresenter.prepareSuccessView(clearOutputData);
    }
}
