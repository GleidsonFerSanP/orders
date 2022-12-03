CREATE TABLE product(
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    sku VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    description TEXT NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL
    );
