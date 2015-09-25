INSERT INTO whw_role (`code`, `label`) VALUES ('1','ADMIN');
INSERT INTO whw_role (`code`, `label`) VALUES ('2','USER');

INSERT INTO whw_user (`username`, `password`, `enable`) VALUES ('admin', '$2a$10$tN5VtfiKwUU0gU2uvjE5IOxtTUomu4hgDOcd9ER8thF6NyTgqiAqO', true);

INSERT INTO whw_user_roles (`whw_user_id`, `roles_id`) VALUES (1, 1);
INSERT INTO whw_user_roles (`whw_user_id`, `roles_id`) VALUES (1, 2);
