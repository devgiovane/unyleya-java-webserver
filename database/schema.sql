USE unyleya;

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `company` (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

INSERT INTO company(name, address) VALUES ("Unyleya", "Rua unyleya, numero 1");
