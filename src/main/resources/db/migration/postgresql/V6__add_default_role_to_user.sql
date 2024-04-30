CREATE OR REPLACE FUNCTION default_user_role_id()
RETURNS INTEGER AS $$
BEGIN
    RETURN (SELECT role_id FROM tb_roles WHERE role_name = 'User');
END;
$$ LANGUAGE plpgsql;

ALTER TABLE tb_users ALTER COLUMN user_role_id SET DEFAULT default_user_role_id();