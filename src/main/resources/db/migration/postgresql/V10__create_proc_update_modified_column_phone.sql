CREATE OR REPLACE FUNCTION update_modified_column_phone()
RETURNS TRIGGER AS $$
BEGIN
    NEW.phone_updated_at = now();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql
