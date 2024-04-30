CREATE TRIGGER update_address_modtime
BEFORE UPDATE ON tb_addresses
FOR EACH ROW
EXECUTE PROCEDURE update_modified_column_address();
