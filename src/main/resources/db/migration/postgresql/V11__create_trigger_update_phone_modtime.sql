CREATE TRIGGER update_phone_modtime
BEFORE UPDATE ON tb_phones
FOR EACH ROW
EXECUTE PROCEDURE update_modified_column_phone();
