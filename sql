CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at DATE DEFAULT CURRENT_DATE,
    created_by VARCHAR(255) NOT NULL,
    last_updated_at DATE,
    last_updated_by VARCHAR(255)
);

CREATE TABLE balance (
    id SERIAL PRIMARY KEY,
    account_id INTEGER,
    remaining_balance NUMERIC(15, 2) DEFAULT 0,
    is_active BOOLEAN DEFAULT TRUE,
    created_at DATE DEFAULT CURRENT_DATE,
    created_by VARCHAR(255) NOT NULL,
    last_updated_at DATE,
    last_updated_by VARCHAR(255),
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES account(id)
);

CREATE TABLE transaction (
    id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    destination_account_id INTEGER,      
    amount NUMERIC(15, 2) NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated_at TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    last_updated_by VARCHAR(255),
    CONSTRAINT fk_account_transaction FOREIGN KEY (account_id) REFERENCES account(id),
    CONSTRAINT fk_destination_account FOREIGN KEY (destination_account_id) REFERENCES account(id)
);
