INSERT INTO whw_role (`code`, `label`, `CREATED_AT`, `CREATED_BY`, `REFERENCE_ID`)
VALUES
 ('1','ADMIN', NOW(), 'init', 'init'),
 ('2','USER', NOW(), 'init', 'init');

INSERT INTO whw_user (`username`, `password`, `enable`, `CREATED_AT`, `CREATED_BY`, `REFERENCE_ID`)
VALUES
 ('test', '$2a$10$rjvoBv./ZCCHACKYhuT3P..7gPrGcjTCCFOh7aqYxX7egeomE8TpW', true, NOW(), 'init', 'init');

INSERT INTO whw_user_roles (`whw_user_id`, `roles_id`)
VALUES
 (1, 1),
 (1, 2);
