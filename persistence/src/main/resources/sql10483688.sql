--INSERT INTO roles(roleName, roleDescription) VALUES ("all", "Puede ingresar al sistema, cuenta.logout, cuenta.editar");
--INSERT INTO roles(roleName, roleDescription) VALUES ("admin", "Puede ingresar a los menus hijos cuenta.seguridad, informes.mensual, usuarios.crearNuevo y usuario.listar ");
--INSERT INTO roles(roleName, roleDescription) VALUES ("reporter", "Puede ingresar a los menus hijos  informes.mensual,  informes.anual, usuarios.reporte, ");


--Insert father menu "Mi sistema"
--INSERT INTO menus(menuName, roles) VALUES('Mi sistema', ?);