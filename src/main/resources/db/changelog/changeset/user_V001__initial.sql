CREATE TABLE IF NOT EXISTS times (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    created timestamptz DEFAULT current_timestamp
)