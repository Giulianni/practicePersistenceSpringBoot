package com.practice.persistencepractice.service;

import com.practice.persistencepractice.config.SpringConfig;
import com.practice.persistencepractice.dto.MenuDto;
import com.practice.persistencepractice.dto.login.RoleDto;
import com.practice.persistencepractice.dto.login.UserDto;
import com.practice.persistencepractice.exceptions.BadRequestException;
import com.practice.persistencepractice.exceptions.ResourceNotFoundException;
import com.practice.persistencepractice.persistence.model.Menu;
import com.practice.persistencepractice.persistence.model.login.Role;
import com.practice.persistencepractice.persistence.model.login.User;
import com.practice.persistencepractice.persistence.repository.MenuRepository;
import com.practice.persistencepractice.persistence.repository.login.RoleRepository;
import com.practice.persistencepractice.persistence.repository.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    SpringConfig mapper;


    public UserDto createUser(UserDto userDto) throws BadRequestException{
        UserDto response;

        validateUser(userDto);

        // TRABAJANDO CON LA CLASE USER:
        //Mappeo el usuarioDTO obtenido por parámetro a la clase User
        User user = mapper.getModelMapper().map(userDto, User.class);
        // Encripto la contraseña
        String hashedPassword = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes(StandardCharsets.UTF_8)); //Genera el password encriptado
        user.setPassword(hashedPassword);
        //seteo la lista de id de roles
        List<Role> roles = findRolesByIds(userDto);
        user.setRolesUser(roles);

        //mapeo lista string roles
        user.setRoles(roles.stream().map(Role::getRoleName).collect(Collectors.toList()).toArray(new String[roles.size()]));
        //Creo la respuesta mappeandola a DTO
        response = mapper.getModelMapper().map(userRepository.save(user), UserDto.class);

        return response;
    }

    private void validateUser(UserDto userDto) throws BadRequestException {
        String errorMessage = null;
            if (userDto == null) {
                errorMessage = "Ha ocurrido un error al intentar crear un usuario.";
            }else if(userDto.getEmail()==null) {
                errorMessage = "Verificar que se haya introducido un email";
            } else if (userRepository.findByEmail(userDto.getEmail()).isPresent()){
                errorMessage = "El usuario con email: " + userDto.getEmail() + " ya existe en la base de datos";
            } else if (findRolesByIds(userDto).isEmpty()) {
                errorMessage = "No se encuentran los roles asociados";
            }

            if (errorMessage != null) {
                throw new BadRequestException(errorMessage);
            }

    }

    private List<Role> findRolesByIds(UserDto userDto) {
        return roleRepository.findAllById(new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return userDto.getRoleIds().iterator();
            }
        });
    }

    public JSONObject login(UserDto userDto) throws BadRequestException {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if (user.isEmpty()) {
           throw new NotFoundException("Not found");
        }
        if (!new String(Base64.getDecoder().decode(user.get().getPassword().getBytes(StandardCharsets.UTF_8))).equals(userDto.getPassword())) {
            throw new BadRequestException("Password incorrecto");
        }

        Map<String, List<MenuDto>> arbolMenu = new HashMap<>();

        Optional<List<Menu>> menuList = menuRepository.findByRoleIds(user.get().getRolesUser().stream().map(Role::getId).collect(Collectors.toList()));
        //Optional<List<Menu>> menuList = menuRepository.findByRoleIds(user.get().getRoleIds());

        if (menuList.isPresent()) {
            menuList.get().forEach(menu -> {
                List<Menu> menuHijos = menuList.get().stream()
                        .filter(m -> Objects.equals(menu.getMenuId(), m.getMenuFatherId()))
                        .collect(Collectors.toList());

                List<MenuDto> menusDto = new ArrayList<>();
                menuHijos.forEach(hijo -> menusDto.add(mapper.getModelMapper().map(hijo, MenuDto.class)));
                arbolMenu.put(menu.getMenuName(), menusDto);
            });
        }

        JSONObject response = new JSONObject();
        response.put("user", mapper.getModelMapper().map(user.get(), UserDto.class));
        response.put("arbolMenu", arbolMenu);

        return response;
    }
}
