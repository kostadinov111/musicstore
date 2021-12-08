package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.model.service.UserRegisterServiceModel;
import bg.softuni.musicstore.model.view.UserManageViewModel;
import bg.softuni.musicstore.model.view.UserRolesManageViewModel;

import java.util.List;

public interface UserService {

    void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel);

    List<UserManageViewModel> findAll();

    UserEntity findById(Long id);

    void disableUserById(Long id);

    void enableUserById(Long id);

    List<UserRolesManageViewModel> findUserRoles();

    void removeRole(Long id, String role);

    void addRole(Long id, String role);
}
