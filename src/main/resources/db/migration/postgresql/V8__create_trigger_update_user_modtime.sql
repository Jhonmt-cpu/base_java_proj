CREATE TRIGGER update_user_modtime
BEFORE UPDATE ON tb_users
FOR EACH ROW
EXECUTE PROCEDURE update_modified_column_user();