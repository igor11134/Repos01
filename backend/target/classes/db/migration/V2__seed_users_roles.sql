INSERT INTO roles (name) VALUES
  ('ADMIN'),
  ('INITIATOR'),
  ('CURATOR'),
  ('EXPERT_GROUP_LEAD'),
  ('EXPERT'),
  ('OBSERVER');

INSERT INTO users (username, full_name) VALUES
  ('admin', 'Admin User'),
  ('initiator', 'Initiator User'),
  ('curator', 'Curator User'),
  ('expert_lead', 'Expert Group Lead'),
  ('expert', 'Expert User'),
  ('observer', 'Observer User');

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'admin' AND r.name = 'ADMIN';
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'initiator' AND r.name = 'INITIATOR';
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'curator' AND r.name = 'CURATOR';
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'expert_lead' AND r.name = 'EXPERT_GROUP_LEAD';
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'expert' AND r.name = 'EXPERT';
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username = 'observer' AND r.name = 'OBSERVER';
