#insert roles
INSERT INTO roles (role_name, role_description) VALUES ("all", "Puede ingresar al sistema, cuenta.logout, cuenta.editar");
INSERT INTO roles (role_name, role_description) VALUES ("admin", "Puede ingresar a los menus hijos cuenta.seguridad, informes.mensual, usuarios.crearNuevo y usuario.listar ");
INSERT INTO roles (role_name, role_description) VALUES ("reporter", "Puede ingresar a los menus hijos  informes.mensual,  informes.anual, usuarios.reporte, ");

#Defino variables con ids de role
SET @RoleAll = 1;
SET @RoleAdmin = 2;
SET @RoleReporter = 3;

#insert role "all" y Menu "Mi sistema" - root
INSERT INTO menus (menu_father_id, menu_name) VALUES (null, "Mi sistema");
SET @menus.menu_id = last_insert_id();
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAll);

#insert Cuenta - padre
INSERT INTO menus (menu_father_id, menu_name) VALUES (1, "Cuenta");
SET @menus.menu_id = last_insert_id(); -- id 2
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAll);

#insert Log out, editar y Seguridad - hijos de Cuenta
INSERT INTO menus (menu_father_id, menu_name) VALUES (2, "Logout");
SET @menus.menu_id = last_insert_id(); -- id 3
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAll);

INSERT INTO menus (menu_father_id, menu_name) VALUES (2, "Editar");
SET @menus.menu_id = last_insert_id(); -- id 4
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAll);

INSERT INTO menus (menu_father_id, menu_name) VALUES (2, "Seguridad");
SET @menus.menu_id = last_insert_id(); -- id 5
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAdmin);


#insert Informes - PADRE, pero hijo de root
INSERT INTO menus (menu_father_id, menu_name) VALUES (1, "Informes");
SET @menus.menu_id = last_insert_id(); -- id 6
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAdmin);
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleReporter);

#insert de mensual, anual - hijos de informes
INSERT INTO menus (menu_father_id, menu_name) VALUES (6, "Mensual");
SET @menus.menu_id = last_insert_id(); -- id 7
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAdmin);
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleReporter);

INSERT INTO menus (menu_father_id, menu_name) VALUES (6, "Anual");
SET @menus.menu_id = last_insert_id(); -- id 8
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleReporter);

#insert Usuarios - PADRE, pero hijo de root
INSERT INTO menus (menu_father_id, menu_name) VALUES (1, "Usuarios");
SET @menus.menu_id = last_insert_id(); -- id 9
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAdmin);
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleReporter);

#insert de Crear nuevo, Listar - hijos de usuario
INSERT INTO menus (menu_father_id, menu_name) VALUES (9, "Crear nuevo");
SET @menus.menu_id = last_insert_id(); -- id 10
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAdmin);

INSERT INTO menus (menu_father_id, menu_name) VALUES (9, "Listar");
SET @menus.menu_id = last_insert_id(); -- id 11
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleAdmin);

#insert de Reporte Hijo de root y padre
INSERT INTO menus (menu_father_id, menu_name) VALUES (9, "Reporte");
SET @menus.menu_id = last_insert_id(); -- id 12
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleReporter);

#insert de Reporte 1 y 3 - hijos de Reporte
INSERT INTO menus (menu_father_id, menu_name) VALUES (12, "Reporte 1");
SET @menus.menu_id = last_insert_id(); -- id 13
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleReporter);

INSERT INTO menus (menu_father_id, menu_name) VALUES (12, "Reporte 3");
SET @menus.menu_id = last_insert_id(); -- id 14
INSERT INTO menu_roles (menu_menu_id, roles_id) VALUES (@menus.menu_id, @RoleReporter);


#Consultas
select * from roles;
select * from menus;
select * from menu_roles;
select * from users;
