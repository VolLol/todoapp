package ru.alena.todoapp.todoapp.executer.usecase.usermanage;


import org.springframework.data.domain.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.*;
import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserEntityResponse;

@Service
public class UserSearchUseCase {

    private final UserRepository repository;
    private final PagedResourcesAssembler<UserEntityResponse> pagedResourcesAssembler;

    public UserSearchUseCase(UserRepository repository, PagedResourcesAssembler<UserEntityResponse> pagedResourcesAssembler) {
        this.repository = repository;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    public PagedModel<EntityModel<UserEntityResponse>> execute(Integer pageNumber, Integer pageSize) {

        PageRequest request = PageRequest.of(pageNumber, pageSize);
        Page<User> page = repository.findAll(request);

        Page<UserEntityResponse> responseModel = page.map(u ->
                UserEntityResponse.builder()
                        .username(u.getUsername())
                        .email(u.getEmail())
                        .mood(u.getMood())
                        .createdAt(u.getCreatedAt())
                        .updatedAt(u.getUpdatedAt())
                        .deletedAt(u.getDeletedAt())
                        .build());

        return pagedResourcesAssembler.toModel(responseModel);
    }
}
