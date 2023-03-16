insert into fleet_manager.roles(name) values ('ADMIN'), ('USER');

insert into fleet_manager.users(first_name, last_name, email, password) values('Jakub', 'Kopta', 'jakub.kopta@gmail.com', '{bcrypt}$2a$12$xSaAIJtGDfw.jKQFXabRL.QvoO9Ck7qo5i.NT1ju7ZPxoAdmB8zxm');

insert into fleet_manager.users_roles(user_id, roles_id) values (1, 1);