package interface_adapter.clear_users;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ViewManagerModel viewManagerModel,
                           ClearViewModel clearViewModel,
                           SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        // On success, switch to the sign up view.
        SignupState signupState = signupViewModel.getState();
        signupState.setClearUserMessage(response.getMessage());
        this.signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
