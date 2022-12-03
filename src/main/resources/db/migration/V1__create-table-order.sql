CREATE TABLE customer_order (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    total NUMERIC(10,2) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL
    );