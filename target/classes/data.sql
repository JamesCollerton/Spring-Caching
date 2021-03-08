DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id    INT AUTO_INCREMENT  PRIMARY KEY,
  name  VARCHAR(250) NOT NULL
);

INSERT INTO users (name) VALUES
  ('Sarah'),
  ('June'),
  ('Elizabeth');