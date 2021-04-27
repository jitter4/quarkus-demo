SET @identity := (INSERT INTO contact (contact_mobile_number) VALUES ('1234567890') RETURNING id)
INSERT INTO persons (person_name, contact_id) VALUES('shubham', @identity);