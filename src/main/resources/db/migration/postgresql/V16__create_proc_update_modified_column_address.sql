CREATE OR REPLACE FUNCTION update_modified_column_address()
RETURNS TRIGGER AS $$
BEGIN
    NEW.address_updated_at = now();
    RETURN NEW;
END;
$$ language plpgsql