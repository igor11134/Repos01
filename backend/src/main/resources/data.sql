INSERT INTO roles (name) VALUES
  ('ADMIN'),
  ('INITIATOR'),
  ('CURATOR'),
  ('EXPERT_GROUP_LEAD'),
  ('EXPERT'),
  ('OBSERVER')
ON CONFLICT (name) DO NOTHING;

INSERT INTO users (username, full_name) VALUES
  ('admin', 'Admin User'),
  ('initiator', 'Initiator User'),
  ('curator', 'Curator User'),
  ('expert_lead', 'Expert Group Lead'),
  ('expert', 'Expert User'),
  ('observer', 'Observer User')
ON CONFLICT (username) DO NOTHING;

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
JOIN roles r ON r.name = 'ADMIN'
WHERE u.username = 'admin'
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur WHERE ur.user_id = u.id AND ur.role_id = r.id
  );

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
JOIN roles r ON r.name = 'INITIATOR'
WHERE u.username = 'initiator'
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur WHERE ur.user_id = u.id AND ur.role_id = r.id
  );

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
JOIN roles r ON r.name = 'CURATOR'
WHERE u.username = 'curator'
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur WHERE ur.user_id = u.id AND ur.role_id = r.id
  );

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
JOIN roles r ON r.name = 'EXPERT_GROUP_LEAD'
WHERE u.username = 'expert_lead'
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur WHERE ur.user_id = u.id AND ur.role_id = r.id
  );

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
JOIN roles r ON r.name = 'EXPERT'
WHERE u.username = 'expert'
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur WHERE ur.user_id = u.id AND ur.role_id = r.id
  );

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u
JOIN roles r ON r.name = 'OBSERVER'
WHERE u.username = 'observer'
  AND NOT EXISTS (
    SELECT 1 FROM user_roles ur WHERE ur.user_id = u.id AND ur.role_id = r.id
  );
