INSERT INTO role (`code`, `label`) VALUES ('1','SUPERUSER');
INSERT INTO role (`code`, `label`) VALUES ('2','ADMIN');
INSERT INTO role (`code`, `label`) VALUES ('3','USER');

INSERT INTO user (`username`, `password`, `enable`) VALUES ('admin', '$2a$10$tN5VtfiKwUU0gU2uvjE5IOxtTUomu4hgDOcd9ER8thF6NyTgqiAqO', true);

INSERT INTO user_roles (`user_id`, `roles_id`) VALUES (1, 1);
INSERT INTO user_roles (`user_id`, `roles_id`) VALUES (1, 2);
INSERT INTO user_roles (`user_id`, `roles_id`) VALUES (1, 3);
