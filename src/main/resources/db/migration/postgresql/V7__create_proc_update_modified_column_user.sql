CREATE OR REPLACE FUNCTION update_modified_column_user()
RETURNS TRIGGER AS $$
BEGIN
    NEW.user_updated_at = now();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql